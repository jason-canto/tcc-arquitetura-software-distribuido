import { Component, OnInit } from '@angular/core';
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {Product} from "../../model/product.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import { RxwebValidators,RxFormBuilder } from "@rxweb/reactive-form-validators";

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  product: Product;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService) { }

  ngOnInit() {
    let productId = localStorage.getItem("editProductId");
    if(!productId) {
      alert("Ação Inválida.")
      this.router.navigate(['list-product']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      price: ['', Validators.required],
      pictureUrl: ['', Validators.required],
	  });
    this.productService.getProductById(productId)
      .subscribe( data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.productService.updateProduct(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-product']);
        },
        error => {
          alert(error);
        });
  }

}
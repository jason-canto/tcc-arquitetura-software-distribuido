import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProductService} from "../../services/product.service";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";
import { RxwebValidators,RxFormBuilder } from "@rxweb/reactive-form-validators";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: [],
      name: ['', Validators.required],
      pictureUrl: ['', Validators.required],
      price: ['', Validators.required]
    });

  }

  onSubmit() {
    this.productService.createProduct(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-products']);
      });
  }

}

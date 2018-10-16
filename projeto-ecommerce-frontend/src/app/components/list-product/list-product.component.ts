import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProductService} from "../../services/product.service";
import {Product} from "../../model/product.model";

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  products: Product[];

  constructor(private router: Router, private productService: ProductService) { }

  ngOnInit() {
    this.productService.getProducts()
      .subscribe( data => {
        this.products = data;
      });
  }

  deleteProduct(product: Product): void {
    this.productService.deleteProduct(product.id)
      .subscribe( data => {
        this.products = this.products.filter(u => u !== product);
      })
  };

  editProduct(product: Product): void {
    localStorage.removeItem("editProductId");
    localStorage.setItem("editProductId", product.id);
    this.router.navigate(['edit-product']);
  };

  addProduct(): void {
    this.router.navigate(['add-product']);
  };
}

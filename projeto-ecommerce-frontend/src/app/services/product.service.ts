import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from "../model/product.model";
import {Subject} from "rxjs/internal/Subject";
import {AppComponent} from "../app.component";

@Injectable()
export class ProductService {
	constructor(private http: HttpClient) { }
	private productUrl = "/admin/products";

	getProducts() {
		return this.http.get<Product[]>(AppComponent.API_URL + this.productUrl);
	}

	getProductById(id: string) {
		return this.http.get<Product>(AppComponent.API_URL + this.productUrl + '/' + id);
	}

	createProduct(product: Product) {
		return this.http.post(AppComponent.API_URL + this.productUrl, product);
	}

	updateProduct(product: Product) {
		return this.http.put(AppComponent.API_URL + this.productUrl + '/' + product.id, product);
	}

	deleteProduct(id: string) {
		return this.http.delete(AppComponent.API_URL + this.productUrl + '/' + id);
	}
}
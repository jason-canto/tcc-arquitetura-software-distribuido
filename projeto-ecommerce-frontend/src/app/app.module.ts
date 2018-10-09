import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from "@angular/http";
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FacebookModule} from "ngx-facebook";
import {routing} from "./app.routing";
import {AuthService} from "./services/auth.service";
import {AccountService} from "./services/account.service";
import {EcommerceService} from "./services/ecommerce.service";
import {UserService} from "./services/user.service";
import {AppComponent} from './app.component';
import {EcommerceComponent} from './components/ecommerce/ecommerce.component';
import {ProductsComponent} from './components/products/products.component';
import {ShoppingCartComponent} from './components/shopping-cart/shopping-cart.component';
import {OrdersComponent} from './components/orders/orders.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AddUserComponent} from './components/add-user/add-user.component';
import {EditUserComponent} from './components/edit-user/edit-user.component';
import {ListUserComponent} from './components/list-user/list-user.component';
import {UrlPermission} from "./urlPermission/url.permission";

@NgModule({
    declarations: [
        AppComponent,
        EcommerceComponent,
        ProductsComponent,
        ShoppingCartComponent,
        OrdersComponent,
        LoginComponent,
		RegisterComponent,
		ProfileComponent,
        AddUserComponent,
        EditUserComponent,
        ListUserComponent
    ],
    imports: [
        BrowserModule,
		HttpModule,
		routing,
        HttpClientModule,
        FormsModule,
		FacebookModule.forRoot(),
        ReactiveFormsModule
    ],
    providers: [AuthService, AccountService, UrlPermission, UserService, EcommerceService],
    bootstrap: [AppComponent]
})

export class AppModule {}
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpModule} from "@angular/http";
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FacebookModule} from "ngx-facebook";
import {UrlPermission} from "./ecommerce/urlPermission/url.permission";
import {routing} from "./app.routing";
import {AuthenticationService} from "./ecommerce/services/auth.service";
import {AppComponent} from './app.component';
import {EcommerceComponent} from './ecommerce/ecommerce.component';
import {ProductsComponent} from './ecommerce/products/products.component';
import {ShoppingCartComponent} from './ecommerce/shopping-cart/shopping-cart.component';
import {OrdersComponent} from './ecommerce/orders/orders.component';
import {EcommerceService} from "./ecommerce/services/EcommerceService";
import {LoginComponent} from './ecommerce/components/login/login.component';
import {RegisterComponent} from './ecommerce/components/register/register.component';
import {AuthService} from "./ecommerce/services/auth.service";
import {AccountService} from "./ecommerce/services/account.service";
import {ProfileComponent} from './ecommerce/components/profile/profile.component';
import {AddUserComponent} from './ecommerce/add-user/add-user.component';
import {EditUserComponent} from './ecommerce/edit-user/edit-user.component';
import {ListUserComponent} from './ecommerce/list-user/list-user.component';
import {UserService} from "./ecommerce/services/user.service";
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
    providers: [AuthService,AccountService,UrlPermission,AuthenticationService, UserService, EcommerceService],
    bootstrap: [AppComponent]
})
export class AppModule {}

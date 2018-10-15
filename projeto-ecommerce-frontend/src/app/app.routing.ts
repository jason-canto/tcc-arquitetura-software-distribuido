import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {UrlPermission} from "./urlPermission/url.permission";
import {AddUserComponent} from "./components/add-user/add-user.component";
import {ListUserComponent} from "./components/list-user/list-user.component";
import {EditUserComponent} from "./components/edit-user/edit-user.component";
import {EcommerceComponent} from './components/ecommerce/ecommerce.component';
import {ShoppingCartComponent} from './components/shopping-cart/shopping-cart.component';
import {ProductsComponent} from './components/products/products.component';



const appRoutes: Routes = [
	{ path: 'profile', component: ProfileComponent, canActivate: [UrlPermission] },
	{ path: 'login', component: LoginComponent },
	{ path: 'register', component: RegisterComponent },
	{ path: 'admin', redirectTo: '/login' },
    { path: '', component: EcommerceComponent}
];

export const routing = RouterModule.forRoot(appRoutes);
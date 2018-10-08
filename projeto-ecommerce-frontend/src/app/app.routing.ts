import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./ecommerce/components/login/login.component";
import {RegisterComponent} from "./ecommerce/components/register/register.component";
import {ProfileComponent} from "./ecommerce/components/profile/profile.component";
import {UrlPermission} from "./ecommerce/urlPermission/url.permission";
import {AddUserComponent} from "./ecommerce/add-user/add-user.component";
import {ListUserComponent} from "./ecommerce/list-user/list-user.component";
import {EditUserComponent} from "./ecommerce/edit-user/edit-user.component";

const appRoutes: Routes = [
  { path: 'profile', component: ProfileComponent ,canActivate: [UrlPermission] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  // otherwise redirect to profile
  { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);
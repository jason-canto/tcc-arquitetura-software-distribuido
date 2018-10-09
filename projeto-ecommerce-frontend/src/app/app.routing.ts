import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {UrlPermission} from "./urlPermission/url.permission";
import {AddUserComponent} from "./components/add-user/add-user.component";
import {ListUserComponent} from "./components/list-user/list-user.component";
import {EditUserComponent} from "./components/edit-user/edit-user.component";

const appRoutes: Routes = [
  { path: 'profile', component: ProfileComponent ,canActivate: [UrlPermission] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: '', component: LoginComponent},

  // otherwise redirect to profile
  { path: '**', redirectTo: '/login' }
];

export const routing = RouterModule.forRoot(appRoutes);
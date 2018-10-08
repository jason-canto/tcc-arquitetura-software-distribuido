import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./ecommerce/login.component";
import {AddUserComponent} from "./ecommerce/add-user/add-user.component";
import {ListUserComponent} from "./ecommerce/list-user/list-user.component";
import {EditUserComponent} from "./ecommerce/edit-user/edit-user.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'add-user', component: AddUserComponent },
  { path: 'list-user', component: ListUserComponent },
  { path: 'edit-user', component: EditUserComponent },
  { path : '', component : LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
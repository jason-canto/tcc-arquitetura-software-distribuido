import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";
import {User} from "../../model/user.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {first} from "rxjs/operators";
import { RxwebValidators,RxFormBuilder } from "@rxweb/reactive-form-validators";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  user: User;
  editForm: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService) { }

  ngOnInit() {
    let userId = localStorage.getItem("editUserId");
    if(!userId) {
      alert("Ação Inválida.")
      this.router.navigate(['list-user']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      username: ['', Validators.required],
      password: ['', Validators.required],
      fullName: ['', Validators.required],
	  confirmPassword:['', RxwebValidators.compare({fieldName:'password' })]
    });
    this.userService.getUserById(userId)
      .subscribe( data => {
        this.editForm.setValue({'id': data.id, 'username': data.username, 'fullName': data.fullName,  'password': ''});
      });
  }

  onSubmit() {
    this.userService.updateUser(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-user']);
        },
        error => {
          alert(error);
        });
  }

}
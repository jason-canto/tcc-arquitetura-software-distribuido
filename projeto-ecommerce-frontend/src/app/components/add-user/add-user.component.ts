import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";
import {first} from "rxjs/operators";
import {Router} from "@angular/router";
import { RxwebValidators,RxFormBuilder } from "@rxweb/reactive-form-validators";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: [],
      username: ['', Validators.required],
      fullName: ['', Validators.required],
      password: ['', Validators.required],
	  confirmPassword:['', RxwebValidators.compare({fieldName:'password' })]
    });

  }

  onSubmit() {
    this.userService.createUser(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['list-user']);
      });
  }

}

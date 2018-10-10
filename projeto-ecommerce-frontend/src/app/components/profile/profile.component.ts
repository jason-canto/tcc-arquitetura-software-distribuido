import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {User} from "../../model/user.model";
import {Router} from "@angular/router";

@Component({
	selector: 'app-profile',
	templateUrl: './profile.component.html',
	styleUrls: ['./profile.component.css'],
	encapsulation: ViewEncapsulation.None
})
export class ProfileComponent implements OnInit {
	currentUser: User;
	constructor(public authService: AuthService, public router: Router) {
		this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
	}

	ngOnInit() {}

	logOut() {
		this.authService.logOut()
		.subscribe(
			data => {
				this.router.navigate(['/login']);
			},
        error => {});
	}
}

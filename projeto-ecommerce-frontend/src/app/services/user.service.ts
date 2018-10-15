import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "../model/user.model";
import {Subject} from "rxjs/internal/Subject";
import {AppComponent} from "../app.component";

@Injectable()
export class UserService {
	constructor(private http: HttpClient) { }
	private usersUrl = "/admin/users";

	getUsers() {
		return this.http.get<User[]>(AppComponent.API_URL + this.usersUrl);
	}

	getUserById(id: string) {
		return this.http.get<User>(AppComponent.API_URL + this.usersUrl + '/' + id);
	}

	createUser(user: User) {
		return this.http.post(AppComponent.API_URL + this.usersUrl, user);
	}

	updateUser(user: User) {
		return this.http.put(AppComponent.API_URL + this.usersUrl + '/' + user.id, user);
	}

	deleteUser(id: string) {
		return this.http.delete(AppComponent.API_URL + this.usersUrl + '/' + id);
	}
}
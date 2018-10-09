import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "../model/user.model";
import {Subject} from "rxjs/internal/Subject";

@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }
  private usersUrl = "/admin/users";

  getUsers() {
    return this.http.get<User[]>(this.usersUrl);
  }

  getUserById(id: number) {
    return this.http.get<User>(this.usersUrl + '/' + id);
  }

  createUser(user: User) {
    return this.http.post(this.usersUrl, user);
  }

  updateUser(user: User) {
    return this.http.put(this.usersUrl + '/' + user.id, user);
  }

  deleteUser(id: number) {
    return this.http.delete(this.usersUrl + '/' + id);
  }
}
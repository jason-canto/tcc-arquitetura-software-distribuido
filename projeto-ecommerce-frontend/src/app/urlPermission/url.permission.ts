import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class UrlPermission implements CanActivate {

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem('currentUser')) {
      // usuario logado cache
      return true;
    }

    // nao logado redirect
    this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
    return false;
  }
}

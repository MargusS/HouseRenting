import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss'],
})
export class MenuComponent implements OnInit {

  isLogged: boolean;
  isAdmin: boolean;

  constructor(private router: Router,private tokenService: TokenService) { }
  
  ngOnInit(){
    this.testLogged();
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToHome() {
    this.router.navigateByUrl("/houses-list");
  }
  goToAdmin() {
    this.router.navigateByUrl("/admin");
  }

  logOut() {
    this.tokenService.logOut();
    this.isLogged = false;
    this.isAdmin = false;
    this.router.navigate(['/login']);
  }

  testLogged(): void {
    this.isLogged = this.tokenService.getToken()!= null;
    this.isAdmin = this.tokenService.isAdmin();
  }

}

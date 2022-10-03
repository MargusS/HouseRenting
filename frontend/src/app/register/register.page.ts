import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { concatMap } from 'rxjs/operators';
import { Login } from '../models/login';
import { NewUser } from '../models/new-user';
import { AuthService } from '../service/auth.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  newUser: NewUser;
  userLogin: Login;
  name = '';
  userName = '';
  email = '';
  password = '';
  phNumber = '';

  isLogged = false;

  constructor(
    private authService: AuthService,
    private tokenService: TokenService,
    private toastController: ToastController,
    private router: Router
  ) { }

  ngOnInit() {
    this.testLogged();
  }

  ionViewWillEnter() {
    this.testLogged();
    this.vaciar();
  }

  onRegister() {
    this.newUser = new NewUser(this.name, this.userName, this.email, this.password, this.phNumber);
    console.log(this.userName);
    this.userLogin = new Login(this.userName, this.password);
    this.authService.newUser(this.newUser).pipe(concatMap (newRes => this.authService.loginUser(this.userLogin))).subscribe(
      data => {
        this.tokenService.setToken(data.token);
        this.isLogged = true;
        this.presentToast('cuenta creada');
        this.router.navigate(['/houses-list']);
      },
      err => {
        this.presentToast(err.error.message);
      }
    );
  }

  vaciar() {
    this.name = '';
    this.userName = '';
    this.email = '';
    this.password = '';
    this.phNumber = '';
  }

  async presentToast(msj: string) {
    const toast = await this.toastController.create({
      message: msj,
      duration: 2000,
      position: 'bottom',
      color: "danger",
      icon:"alert-circle-outline",
      animated: true
    });
    toast.present();
  }

  logOut(): void {
    this.tokenService.logOut();
    this.isLogged = false;
    this.vaciar();
  }

  testLogged(): void {
    this.isLogged = this.tokenService.getToken() != null;
  }

}
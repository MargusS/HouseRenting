import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Login } from '../models/login';
import { AuthService } from '../service/auth.service';
import { TokenService } from '../service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  
  isLogged = false;
  
  loginUser: Login;
  userName = '';
  password = '';

  constructor(private tokenService: TokenService, private authService: AuthService, private router:Router, private toastController: ToastController) { }

  ngOnInit() {
    this.testLogged();
  }

  ionViewWillEnter() {
    this.testLogged();
    this.vaciar();
  }

  onLogin():void{
    this.loginUser = new Login(this.userName,this.password);
    this.authService.loginUser(this.loginUser).subscribe(
      data =>{
        this.isLogged = true;
        this.tokenService.setToken(data.token);
        this.router.navigate(['/houses-list']);
      },
      err =>{
        if(err.status === 401){
          this.presentToast("Incorrect username or password");
        }
      }
    )
  }

  async presentToast(mss: string) {
    const toast = await this.toastController.create({
      message:  mss,
      duration: 3000,
      position:'middle'
    });
    await toast.present();
  }

  vaciar() {
    this.userName = '';
    this.password = '';
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

import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {HouseGuardService} from './guard/house-guard.service';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomePageModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'register',
    loadChildren: () => import('./register/register.module').then( m => m.RegisterPageModule)
  },
  {
    path: 'houses-list',
    loadChildren: () => import('./houses-list/houses-list.module').then( m => m.HousesListPageModule),
    canActivate: [HouseGuardService], data: {requiredRoles: ['user','admin']}
  },
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminPageModule),
    canActivate: [HouseGuardService], data: {requiredRoles: ['admin']}
  },
  {
    path: 'new-rent',
    loadChildren: () => import('./new-rent/new-rent.module').then(m => m.NewRentPageModule),
    canActivate: [HouseGuardService], data: {requiredRoles: ['admin']}
  },
  {
    path: 'upt-rent/:id',
    loadChildren: () => import('./upt-rent/upt-rent.module').then(m => m.UptRentPageModule),
    canActivate: [HouseGuardService], data: {requiredRoles: ['admin']}
  },
  {
    path: 'detail/:id',
    loadChildren: () => import('./detail/detail.module').then( m => m.DetailPageModule),
    canActivate: [HouseGuardService], data: {requiredRoles: ['user' , 'admin']}
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

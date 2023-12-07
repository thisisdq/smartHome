import { Routes } from '@angular/router';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { SmartHouseControllPageComponent } from './components/smart-house-controll-page/smart-house-controll-page.component';
import { TestComponent } from './components/test/test.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { SmartHosueHomePageComponent } from './smart-hosue-home-page/smart-hosue-home-page.component';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginPageComponent, title: 'Login SmartHome' },
    { path: 'smarthousepage', component: SmartHouseControllPageComponent, title: 'USER PAGE' },
    { path: 'net', component: SmartHosueHomePageComponent, title: 'Ngồi net code chơi'},
    { path: 'test', component: TestComponent, title: 'test' },
    { path: '**', component: PageNotFoundComponent, title: 'Pagenotfound' }];

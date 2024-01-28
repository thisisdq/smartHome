import { Routes } from '@angular/router';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { SmartHouseControllPageComponent } from './components/smart-house-controll-page/smart-house-controll-page.component';
import { TestComponent } from './components/test/test.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { TestwsComponent } from './components/testws/testws.component';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'login', component: LoginPageComponent, title: 'Login SmartHome' },
    { path: 'testws', component: TestwsComponent,title: 'Test'},
    { path: 'smarthousepage', component: SmartHouseControllPageComponent, title: 'USER PAGE' },
    { path: 'test', component: TestComponent, title: 'test' },
    { path: '**', component: PageNotFoundComponent, title: 'Pagenotfound' }];

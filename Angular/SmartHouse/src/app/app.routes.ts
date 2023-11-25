import { Routes } from '@angular/router';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HomepageComponent } from './components/homepage/homepage.component';
import { SmarthousepageComponent } from './components/smarthousepage/smarthousepage.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';

export const routes: Routes = [
    {path: '', redirectTo: '/login',pathMatch : 'full'},
    {path:'homepage',component: HomepageComponent,title: 'Homepage SmartHome'},
    {path:'login',component: LoginPageComponent,title : 'Login SmartHome'},
    {path: 'smarthousepage', component: SmarthousepageComponent, title: 'Device Light'},
    {path: '**', component: PagenotfoundComponent, title: 'Pagenotfound'}
];

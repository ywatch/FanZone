import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { RegisterComponent } from './pages/register/register.component';
import { StadesComponent } from './pages/stades/stades.component';
import { HebergementsComponent } from './pages/hebergements/hebergements.component';
import { ForumComponent } from './pages/forum/forum.component';

export const routes: Routes = [
    
        {path:'',redirectTo:'home',pathMatch:'full'},
        {path:'login',component:LoginComponent},
        {path:'register',component:RegisterComponent},
        {path:'home',component:LayoutComponent},
        {path:'dashboard',component:DashboardComponent},
        {path:'Stades',component:StadesComponent},
        {path:'Hebergements',component:HebergementsComponent},
        {path:'Forum',component:ForumComponent}
    ];

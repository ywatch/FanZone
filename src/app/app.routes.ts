import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { LayoutComponent } from './pages/layout/layout.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { RegisterComponent } from './pages/register/register.component';
import { StadesComponent } from './pages/stades/stades.component';
import { HebergementsComponent } from './pages/hebergements/hebergements.component';
import { ForumComponent } from './pages/forum/forum.component';
import { SinglepageCardsComponent } from './pages/singlepage-cards/singlepage-cards.component';

export const routes: Routes = [
    
        {path:'',redirectTo:'home',pathMatch:'full'},
        {path:'login',component:LoginComponent},
        {path:'register',component:RegisterComponent},
        {path:'home',component:LayoutComponent},
        {path:'home/:message',component:LayoutComponent},
        {path:'dashboard/:message',component:DashboardComponent},
        {path:'Stades/:message',component:StadesComponent},
        {path:'single/:message/:user',component:SinglepageCardsComponent},
        {path:'Hebergements/:message',component:HebergementsComponent},
        {path:'Forum/:message',component:ForumComponent}
    ];

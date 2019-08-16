import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RouteComponent } from './route/route.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ViewseatsComponent } from './viewseats/viewseats.component';
import { BookticketComponent } from './bookticket/bookticket.component';
import { ConfirmbookingComponent } from './confirmbooking/confirmbooking.component';
import { SignupComponent } from './signup/signup.component';


const routes: Routes = [
   { path:'login',component:LoginComponent },
   { path:'route',component:RouteComponent },
   { path:'schedule',component:ScheduleComponent},
   { path:'viewSeats',component:ViewseatsComponent },
   { path:'bookticket',component:BookticketComponent },
   { path: 'confirmbooking',component:ConfirmbookingComponent},
   { path:'signup',component:SignupComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

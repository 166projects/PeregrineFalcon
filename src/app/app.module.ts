import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { Routes } from '../../node_modules/@angular/router';
import { CustomerService } from './customer.service';
import { FormsModule } from '@angular/forms';
import { SignupComponent } from './signup/signup.component';
import { RouteComponent } from './route/route.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ViewseatsComponent } from './viewseats/viewseats.component';
import { BookticketComponent } from './bookticket/bookticket.component';
import { ConfirmbookingComponent } from './confirmbooking/confirmbooking.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    RouteComponent,
    ScheduleComponent,
    ViewseatsComponent,
    BookticketComponent,
    ConfirmbookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }

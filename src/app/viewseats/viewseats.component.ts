import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-viewseats',
  templateUrl: './viewseats.component.html',
  styleUrls: ['./viewseats.component.css']
})
export class ViewseatsComponent implements OnInit {

  constructor(private customerservice:CustomerService, private route: ActivatedRoute, private router: Router) { }

  bnoofseats: number;
  enoofseats: number;
  fnoofseats: number;
  fid: String="F_200";
  destination: String;
  source: String;
  routes: Route;
  value: string;

  // getalldestination(): String {
  //   this.customerservice.getallroutes()
  //   .subscribe((data: any) => {
  //   this.destination = data.destination;})

  //   return this.destination; 
  // }
  getnoofbusinessseats(): number {
    console.log('type of seat');
    this.customerservice.getnoofseats("business",this.fid)
    .subscribe((data: any) => {
    this.bnoofseats = data;})
    return this.bnoofseats; 
  }
  getnoofeconomyseats(): number {
    console.log('type of seat');
    this.customerservice.getnoofseats("economy",this.fid)
    .subscribe((data: any) => {
    this.enoofseats = data;})
    return this.enoofseats; 
  }
  getnooffclassseats(): number {
    console.log('type of seat');
    this.customerservice.getnoofseats("firstclass",this.fid)
    .subscribe((data: any) => {
    this.fnoofseats = data;})
    return this.fnoofseats; 
  }
  onSubmit():void {
    this.router.navigate(['/bookticket']);
  }
  
  // getroutebydestination(): Route {
  //   console.log('Route by Destination');
  //   this.customerservice.getroutebydestination(this.destination)
  //   .subscribe((data: any) => {
  //   this.routes = data;})
  //   return this.routes;
  // }
  // getroutebysource(): Route {
  //   console.log('Route by source');
  //   this.customerservice.getroutebysource(this.source)
  //   .subscribe((data: any) => {
  //   this.routes = data;})
  //   return this.routes; 
  // }
  // getallroutes(): Route {
  //   console.log('All Routes');
  //   this.customerservice.getallroutes()
  //   .subscribe((data: any) => {
  //   this.routes = data;})
  //   return this.routes; 
  // }
  ngOnInit() {
  }

}

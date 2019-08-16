import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Fuser } from '../fuser';
import { Schedule } from '../schedule';

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
  styleUrls: ['./route.component.css']
})
export class RouteComponent implements OnInit {
  
  source: string;
  destination: string;
  fdate: string;
  memberArray: Array<Route>;
  returnUrl: string;
  routes: Route[];
  member: Route;
  schedule : Schedule[];
  isLoadingResults = true;
  fuser:Fuser;
  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router) 
  { 
    // this.getflightdetails();
     this.fuser=this.customerService.currentFuserValue;
  }

  
  getflightdetails():any{
  this.customerService.getflightdetails(this.source,this.destination)
  .subscribe((data: any) => {
    this.schedule = data;
    console.log('flights called');
    //this.router.navigate(['/schedule']);
  });

}
    
onSubmit():void {
  this.router.navigate(['/schedule']);
  this.getflightdetails();
}



    ngOnInit() { 
      this.customerService.getallRoutes().subscribe(routes => this.member = routes);
    }
}

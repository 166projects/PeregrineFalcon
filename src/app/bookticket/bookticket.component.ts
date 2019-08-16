import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Passenger } from '../passenger';
import { Observable } from '../../../node_modules/rxjs';

@Component({
  selector: 'app-bookticket',
  templateUrl: './bookticket.component.html',
  styleUrls: ['./bookticket.component.css']
})
export class BookticketComponent implements OnInit {

  // passenger:Passenger;
  passenger = new Passenger();
  returnUrl: string;
  isLoadingResults = true;
  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router) 
  { 
    this.addPassenger();
  }
  addPassenger():void{
    this.passenger = {
       'pid' : this.passenger.pid,
      'age' : this.passenger.age,
      'gender' : this.passenger.gender,
      'name' : this.passenger.name,
      'passport' : this.passenger.passport,
      'phone' : this.passenger.phone,
      'seatno' : 15
    };

  this.customerService.addPassenger(this.passenger).subscribe((res: any)=>{
    this.passenger=res;
    // this.router.navigate(['/confirmbooking']);
  },(err:any)=> {
    console.log(err);
  
  });
  }
  onSubmit():void{
     this.router.navigate(['/confirmbooking']);
  }
  ngOnInit() {
   
  }


}
// this.userserviceService.addpassenger(this.passenger).subscribe((res: any)=>{
//   const id= res._id;
//   this.router.navigateByUrl('bookticket');
// },(err: any)=>{
//   console.log(err);
// });




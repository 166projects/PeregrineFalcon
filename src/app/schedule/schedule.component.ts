import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  member: Schedule;
  arrival: string;
  departure: string;
  fdate: string;
  fid: string;
  schedules : Schedule[];
  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router) {
    this.getSchedules();
   
   }

   getSchedules():any{
     this.customerService.getSchedules()
     .subscribe((data: any) => {
       this.member = data;
       console.log('schedule called');
     })
   }
  
   getfname():any{
     this.customerService.getFlightById(this.member.flight.name)
     .subscribe((data: any) => {
       this.member = data;
       console.log('fname called');
      
     })
   }
   onSubmit():void {
    this.router.navigate(['/viewSeats']);
  }
  
  ngOnInit() {

  }

}

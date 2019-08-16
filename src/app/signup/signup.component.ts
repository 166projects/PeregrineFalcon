import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { CustomerService } from '../customer.service';
import { Fuser } from '../fuser';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  fuser= new Fuser();


  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router) { 
   // this.registerUser();
  }
  registerUser(){
   
    this.fuser = {
      'cid' : this.fuser.cid,
      'cname' : this.fuser.cname,
      'cemail' : this.fuser.cemail,
      'cpass' : this.fuser.cpass,
      'dob': this.fuser.dob,
      'phonenum': this.fuser.phonenum,
      'gender': this.fuser.gender,
      'role': 'customer'
    };
    console.log(this.fuser+'component'+this.fuser.cemail);
   this.customerService.registerUser(this.fuser).subscribe((res: any)=>{
    const id= res._id;
    this.router.navigateByUrl('route');
  },(err: any)=>{
    console.log(err);
  });


  }
  onSubmit(): void{
    this.router.navigate(['/route']);
  }
  ngOnInit() {
  }

}

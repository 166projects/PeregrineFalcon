import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Fuser } from '../fuser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  cid: string;
  cpass :string;
  memberArray : Array<Fuser>;
  //member: Fuser;
  returnUrl: string;
  member : Fuser;
  isLoadingResults = true;
  ngOnInit() {
  }
  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router) { }
  login():void {
    this.customerService.login(this.cid,this.cpass)
   .subscribe((data: any) => {
     this.member = data;
     console.log(this.member.role);
      //console.log('admin logged in');
    if(this.member.role === 'customer'){
        console.log('customer logged in');
        this.router.navigateByUrl(`route`);
      }
      
   });
  }
  // onSubmit():void {
  //   if(this.member.cid === this.cid && this.member.cpass === this.cpass){
  //   this.router.navigate(['/route']);
  //   }
  // }
} 



import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  username:string='';
  password:string='';
  firstName:string='';
  lastName:string='';
  processing:boolean=false;


  constructor(private auth:AuthService,private toastr:ToastrService,private _router:Router
    ){

  }
  onSubmit(){
    this.processing=true;
    var signupDto={
      username:this.username,
      password:this.password,
      firstName:this.firstName,
      lastName:this.lastName
    }

    this.auth.create(signupDto).subscribe(
      (response)=>{
        this.processing=false;
        this.toastr.success("Account Created!");
        this._router.navigateByUrl('/login');
      },
      (error)=>{
        this.processing=false
        this.toastr.error("The server is down, try again later");
      }
    );

  }
}

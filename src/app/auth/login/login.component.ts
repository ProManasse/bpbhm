import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { ToastrService } from 'ngx-toastr';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  public username = '';
  public password = '';
  public processing:boolean=false;

  constructor(private auth:AuthService,private toastr:ToastrService,private _cookie:CookieService,private _router:Router){

  }

  onSubmit(){
    this.processing=true
    var loginDto={
      username:this.username,
      password:this.password
    }

    this.auth.login(loginDto).subscribe(
      (response:any)=>{
        this._cookie.set("username",response.username);
        this._cookie.set("userId",response.id);
        this.processing=false
        this.toastr.success("ready");
        console.log(response);
        this._router.navigateByUrl('/monitor');
      },
      (error)=>{
        this.processing=false
        this.toastr.error("incorrect chridetials, try again later");
        
      }
    );
    
  }
}

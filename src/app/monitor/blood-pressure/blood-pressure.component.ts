import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { MonitorService } from '../monitor.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-blood-pressure',
  templateUrl: './blood-pressure.component.html',
  styleUrls: ['./blood-pressure.component.css']
})
export class BloodPressureComponent {
  title = 'bp_based_health_monitor';

  diastolic:number=0.0;
  systolic:number=0.0;

  constructor(private _cookie:CookieService,private _monitor:MonitorService,private _router:Router,private _toastr:ToastrService) { }
  public barChartOptions = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public data:any=[];
  public barChartLabels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
  public barChartType = 'bar';
  public barChartLegend = true;
  public barChartData = [
    {data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A'},
    // {data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B'}
  ];
  ngOnInit() {
    this.onGetRecords();
  }

  onGetRecords(){
    var user={
      username:this._cookie.get("username")
    };

    this._monitor.getMyRecords(user).subscribe(
      (response)=>{
        this.data=response;
        
      },
      (error)=>{
        console.log(error);
      }
    );
  }

  onSubmit(){
    var record={
      diastolic:this.diastolic,
      systolic:this.systolic,
      userId:this._cookie.get("userId")
    }
    this._monitor.addMyRecords(record).subscribe(
      (response)=>{
       this._toastr.success("Records added successfully!");
       location.reload();
      },
      (error)=>{
        this._toastr.error("Something went wrong, try again later!");
      }
    );
  }

  logout(){
    this._cookie.deleteAll();
    this._router.navigateByUrl('/login');
  }

}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MonitorComponent } from './monitor.component';
import { BloodPressureComponent } from './blood-pressure/blood-pressure.component';

const routes: Routes = [
  {
    path:'',component:MonitorComponent,
    children:[
      {path:'',component:BloodPressureComponent},
      {path:'bloodpressure',component:BloodPressureComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MonitorRoutingModule { }

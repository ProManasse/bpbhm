import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MonitorRoutingModule } from './monitor-routing.module';
import { MonitorComponent } from './monitor.component';
import { BloodPressureComponent } from './blood-pressure/blood-pressure.component';
import { NgChartsModule } from 'ng2-charts';
import { MaterialModule } from '../material.module';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    MonitorComponent,
    BloodPressureComponent
  ],
  imports: [
    CommonModule,
    MonitorRoutingModule,
    NgChartsModule,
    MaterialModule,
    ToastrModule,
    FormsModule
  ],

})
export class MonitorModule { }

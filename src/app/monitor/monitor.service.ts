import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8081/bloodp/health';

@Injectable({
  providedIn: 'root'
})
export class MonitorService {

  constructor(private http: HttpClient) { }

  getMyRecords(data:any): Observable<any> {
    return this.http.post(baseUrl+"/records", data);
  }

  addMyRecords(data:any): Observable<any> {
    return this.http.post(baseUrl+"/record", data);
  }
}
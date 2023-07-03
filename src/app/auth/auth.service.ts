import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8081/bloodp/health';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(data:any): Observable<any> {
    return this.http.post(baseUrl+"/login", data);
  }

  create(data:any): Observable<any> {
    return this.http.post(baseUrl+"/user", data);
  }
}

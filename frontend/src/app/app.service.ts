import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseURL = "http://localhost:8080/system/api/"
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AppService {

  constructor(private http : HttpClient) {}
  getAllcriterias()  {
    return this.http.get(baseURL +'getAllCriteria');
  }
  login(email: any, password: any): Observable<any> {
    return this.http.post(
      baseURL + 'signin',
      {
        "email":email,
        "password":password,
      },
      httpOptions
    );
  };

}

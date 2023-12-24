import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InscriptionServiceService {

private apiUrl = 'http://localhost:8080/system/api';

  constructor(private http: HttpClient) {}

  sendInscriptionData(data: any): Observable<any> {
    const url = `${this.apiUrl}/inscription`;
    return this.http.post(url, data);
  }


  getCriteria(): Observable<any> {
    const criteriaUrl = `${this.apiUrl}/getCriteriaByDate`;  
    return this.http.get<any>(criteriaUrl);
  }


  getCandidates(): Observable<any> {
    const criteriaUrl = `${this.apiUrl}/getAllCandidates`;  
    return this.http.get<any>(criteriaUrl);
  }



}

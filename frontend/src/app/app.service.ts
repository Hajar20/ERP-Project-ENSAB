import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {StorageService} from "./storage.service";

const baseURL = "http://localhost:8080/system/api/"
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AppService {

  constructor(private http : HttpClient, private storage: StorageService) {}

  addPost(Post : any){
      return this.http.post(
          `${baseURL}addPost/${this.storage.getUser().id}`,
          {
              "title" : Post.title,
              "details" : Post.details,
              "file" : Post.file
          }
      )
  }
  getAllcriterias()  {
    return this.http.get(baseURL +'getAllCriteria');
  }
  getCriteriaById(id:any){
    return this.http.get(`${baseURL}getCriteria/${id}`);
  }
  addCriteria(criteria : any){
    return this.http.post(
        `${baseURL}addCriteria/${this.storage.getUser().id}`,
        {
          "startDate": criteria.startDate,
          "endDate": criteria.endDate,
          "threshold1": criteria.threshold1,
          "threshold2": criteria.threshold2,
          "threshold3": criteria.threshold3,
          "details": criteria.details,
          "link": criteria.link,
          "majorPlaces": criteria.majorPlaces
        }
    )
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

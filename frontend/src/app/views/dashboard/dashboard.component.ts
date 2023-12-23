import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../../app.service";
import {StorageService} from "../../storage.service";



@Component({
  templateUrl: 'dashboard.component.html',
  styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  constructor(private router: Router,private app : AppService,private storageService: StorageService) {
  }
  user : any = null


  ngOnInit(): void {
    if(this.storageService.isLoggedIn()){
      this.user = this.storageService.getUser()
      console.log(this.user)
    } else {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['authenticate']);
      });

    }
  }




}

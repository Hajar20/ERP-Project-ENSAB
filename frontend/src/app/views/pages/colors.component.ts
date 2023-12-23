import {  Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../../app.service";
import {StorageService} from "../../storage.service";


@Component({
  templateUrl: 'colors.component.html'
})
export class ColorsComponent implements OnInit {

  constructor(private router: Router,private app : AppService,private storageService: StorageService) {
  }

  majors: any[] = [{ name: '', availablePlaces: '' }];
  user : any = null
  addMajor() {
    this.majors.push({ name: '', availablePlaces: '' });
  }

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




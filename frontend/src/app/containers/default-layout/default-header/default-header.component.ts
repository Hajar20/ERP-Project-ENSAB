import { Component, Input } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

import { ClassToggleService, HeaderComponent } from '@coreui/angular';
import {Router} from "@angular/router";
import {AppService} from "../../../app.service";
import {StorageService} from "../../../storage.service";

@Component({
  selector: 'app-default-header',
  templateUrl: './default-header.component.html',
})
export class DefaultHeaderComponent extends HeaderComponent {

  @Input() sidebarId: string = "sidebar";
  user :any = null

  constructor(private classToggler: ClassToggleService,private router: Router,private app : AppService,private storageService: StorageService) {
    super();
  }
    ngOnInit() {
        this.user = this.storageService.getUser()
    }
  logout(){
   this.storageService.clean()

    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['authenticate']);
    });
  }
}

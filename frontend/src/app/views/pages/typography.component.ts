import {Component, OnInit} from '@angular/core';
import {AppService} from "../../app.service";
import {Router} from "@angular/router";
import {StorageService} from "../../storage.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  templateUrl: 'typography.component.html',
})
export class TypographyComponent implements OnInit {
  constructor(private router: Router,private app : AppService,private storageService: StorageService) {}
  fileName=""
  myForm = new FormGroup({
    title : new FormControl(''),
    details : new FormControl(''),
    file :new FormControl(''),
  })
  getFileDetails(event: any) {
    const selectedFile = event.target.files[0];
     this.fileName = selectedFile.name;
     this.myForm.value.file = selectedFile.name
    //console.log('Filename:', this.myForm.value.file);
  }

  onSubmit(){
    //console.log('Filename:', this.myForm.value.file);
    this.app.addPost(this.myForm.value).subscribe((response: any) => {
         // console.warn("The post :", response);
          this.alert=true
          this.myForm.reset();
        },
    );
  }
  alert : boolean = false
  closeAlert(){
    this.alert=false
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

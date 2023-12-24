import {Component, OnInit} from '@angular/core';
import {AppService} from "../../app.service";
import {Router} from "@angular/router";
import {StorageService} from "../../storage.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  templateUrl: 'typography.component.html',
})
export class TypographyComponent implements OnInit {
  constructor(private router: Router,private app : AppService,private storageService: StorageService) {}
  fileName=""
  myForm = new FormGroup({
    title : new FormControl('', Validators.required),
    details : new FormControl('', Validators.required),
    file :new FormControl('', Validators.required),
  })
  getFileDetails(event: any) {
    const selectedFile = event.target.files[0];
     this.fileName = selectedFile.name;
     this.myForm.value.file = selectedFile.name
    //console.log('Filename:', this.myForm.value.file);
  }
  isFieldsEmpty = false
  onSubmit(){
    if(this.myForm.value.title === '' || this.myForm.value.details === ''){
      this.isFieldsEmpty = true
    } else {
      this.app.addPost(this.myForm.value).subscribe((response: any) => {
            // console.warn("The post :", response);
        this.isFieldsEmpty = false
            this.alert=true
            this.myForm.reset();
          },
      );
    }
  }
  alert : boolean = false
  closeAlert(){
    this.isFieldsEmpty = false
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

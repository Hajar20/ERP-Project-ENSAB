import {Component, OnInit} from '@angular/core';
import {AppService} from "../../app.service";
import {Router} from "@angular/router";
import {StorageService} from "../../storage.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
    templateUrl: 'upload.component.html',
})
export class UploadComponent implements OnInit {
    constructor(private router: Router,private app : AppService,private storageService: StorageService) {}
    alert : boolean = false;selectedFile:boolean = true
    myForm = new FormGroup({
        file :new FormControl('', Validators.required),
    })

    onSubmit(){
        if (this.myForm.value.file !== '') {
            this.selectedFile = true;
            console.log("Filename : ",this.myForm.value.file);
        } else {
            this.selectedFile = false;
            console.log("Filename : ", this.myForm.value.file);
        }
    }
    getFileDetails(event: any) {
        const selectedFile = event.target.files[0];
        this.myForm.value.file = selectedFile.name
        //console.log('Filename : ', this.myForm.value.file);
    }

    closeAlert(){
        this.selectedFile = false
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

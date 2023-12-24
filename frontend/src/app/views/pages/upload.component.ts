// upload.component.ts
import { Component, OnInit } from '@angular/core';
import { AppService } from "../../app.service";
import { Router } from "@angular/router";
import { StorageService } from "../../storage.service";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ApiService } from 'src/app/services/api/api.service';  // Update with the actual path

@Component({
  templateUrl: 'upload.component.html',
})
export class UploadComponent implements OnInit {
  constructor(
    private router: Router,
    private app: AppService,
    private storageService: StorageService,
    private apiService: ApiService // Add this line
  ) {}

  alert: boolean = false;
  selectedFile: boolean = true;
  myForm = new FormGroup({
    file: new FormControl('', Validators.required),
  });

  onSubmit() {
    const fileControl = this.myForm.get('file');
  
    if (fileControl && fileControl.value) {
      const formData = new FormData();
      formData.append('file', fileControl.value as unknown as Blob);
  
      this.apiService.processExcel(formData).subscribe(
        (response: any) => {
          // Handle the API response here
          console.log(response);
          this.alert = true; // Show success alert
        },
        (error: any) => {
          console.error(error);
          this.alert = false; // Show error alert
        }
      );
    } else {
      this.selectedFile = false;
      console.log("Filename : ", fileControl?.value);
    }
  }
  

  getFileDetails(event: any) {
    const selectedFile = event.target.files[0];
    this.myForm.patchValue({ file: selectedFile }); // Update form control value
    this.selectedFile = true;
    //console.log('Filename : ', this.myForm.value.file);
  }

  closeAlert() {
    this.selectedFile = false;
    this.alert = false;
  }

  user: any = null;

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.user = this.storageService.getUser();
      console.log(this.user);
    } else {
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['authenticate']);
      });
    }
  }
}

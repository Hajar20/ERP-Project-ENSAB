// upload.component.ts

import { Component, OnInit } from '@angular/core';
import { AppService } from "../../app.service";
import { Router } from "@angular/router";
import { StorageService } from "../../storage.service";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ApiService } from 'src/app/services/api/api.service'; // Update with the actual path
import jsPDF from 'jspdf';

@Component({
  templateUrl: 'upload.component.html',
})
export class UploadComponent implements OnInit {
  constructor(
    private router: Router,
    private app: AppService,
    private storageService: StorageService,
    private apiService: ApiService
  ) {}

  alert: boolean = false;
  selectedFile: boolean = true;
  examData:any = [];
  myForm = new FormGroup({
    file: new FormControl('', Validators.required),
    threshold: new FormControl('', Validators.required),
  });

  onSubmit() {
    const fileControl = this.myForm.get('file');
    const thresholdControl = this.myForm.get('threshold');

    if (fileControl && fileControl.value && thresholdControl && thresholdControl.value) {
      const formData = new FormData();
      formData.append('file', fileControl.value as unknown as Blob);
      formData.append('value', thresholdControl.value);

      this.apiService.processExcel(formData).subscribe(
        (response: any) => {
          // Handle the API response here
          console.log(response);
          this.examData = response;
          this.alert = true; // Show success alert
          this.generatePDF();
        },
        (error: any) => {
          console.error(error);
          this.alert = false; // Show error alert
        }
      );
    } else {
      this.selectedFile = false;
      console.log("Filename or threshold is missing.");
    }
  }

  getFileDetails(event: any) {
    const selectedFile = event.target.files[0];
    this.myForm.patchValue({ file: selectedFile }); // Update form control value
    this.selectedFile = true;
  }

  closeAlert() {
    this.selectedFile = false;
    this.alert = false;
  }
  generatePDF() {
    const doc = new jsPDF(); // Use 'jsPDF' directly
  
    // Logo on the right
    const imgData = '../assets/images/logo1.png';
    const logoWidth = 20;
    const logoHeight = 10;
    const logoX = doc.internal.pageSize.width - logoWidth - 20; // Adjust the margin as needed
    const logoY = 10;
    doc.addImage(imgData, 'JPEG', logoX, logoY, logoWidth, logoHeight);
  
    doc.text('Selected candidates to pass the oral exam', 20, 15);
    doc.setFontSize(12);
    doc.text(new Date().toLocaleDateString(), 20, 24);
  
    // Assuming the jsPDF version you are using may not have the 'getNumberOfPages' method,
    // you can calculate the number of pages by checking the length of the 'pages' array.
    const pageCount = doc.internal.pages.length; // Use 'pages.length' to get the count of pages
    for (let i = 1; i < pageCount; i++) {
      doc.setPage(i);
      doc.text(`Page ${i} of ${pageCount}`, doc.internal.pageSize.getWidth() / 2, doc.internal.pageSize.getHeight() - 10, {
        align: 'center'
      });
    }
  
    if (this.examData && this.examData.length > 0) {
      const candidateData = this.examData.map((candidate: any) => {
        return [candidate["CNE"], candidate["Nom"], candidate["Prénom"], candidate["Score"]];
      });
  
      const head = ['CNE', 'Nom', 'Prénom', 'Score'];
  
      const startYMargin = 30;
      doc.autoTable({
        head: [head],
        body: candidateData,
        startY: startYMargin,
        didDrawCell: (data: any) => {},
      });
    } else {
      // No data available
      doc.text('No data available', 20, 40);
    }
  
    // Save the PDF
    doc.save('candidatesPassedToOral.pdf');
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

import { Component, OnInit } from '@angular/core';

import jsPDF from 'jspdf';
import 'jspdf-autotable';
import { InscriptionServiceService } from 'src/app/services/inscription/InscriptionService.service';

@Component({
  selector: 'app-candidates-info',
  templateUrl: './candidates-info.component.html',
  styleUrls: ['./candidates-info.component.css']
})
export class CandidatesInfoComponent implements OnInit {

  
  candidates:any =  [];
  currentPage = 1;
  itemsPerPage = 5;

  
  constructor(private inscriptionService: InscriptionServiceService) { 
    this.inscriptionService.getCandidates().subscribe((data: any) => {
      this.candidates = data;
    });
  }

  ngOnInit() { 
    this.inscriptionService.getCandidates().subscribe((data: any) => {
      this.candidates = data;
      console.log('Candidates:', this.candidates);
    });
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
  
    doc.text('Selected candidates', 20, 15);
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
    
    if (this.candidates && this.candidates.length > 0) {
    
      const candidateData = this.candidates.map((candidate: { cne: string, firstname: string, lastname: string, major: { name: string } }) => {
        return [candidate.cne, candidate.firstname, candidate.lastname, candidate.major.name];
      });

      const head = ['CNE', 'Last Name', 'First Name', 'Applied major'];

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
    doc.save('candidates.pdf');
  
  }


  // pagenation

  get paginatedCandidates() {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.candidates.slice(startIndex, endIndex);
  }

  onNextPage() {
    if (this.hasNextPage()) {
      this.currentPage++;
    }
  }

  onPrevPage() {
    if (this.hasPrevPage()) {
      this.currentPage--;
    }
  }

  hasNextPage(): boolean {
    return this.currentPage < Math.ceil(this.candidates.length / this.itemsPerPage);
  }

  hasPrevPage(): boolean {
    return this.currentPage > 1;
  }
  
}

interface Candidate {
  cne: string;
  firstname: string;
  lastname: string;
  birthdate: string;
  cni: string;
  phone: number;
  sexe: string;
  degrees: any[]; 
  bac: any; 
}

declare module 'jspdf' {
  interface jsPDF {
    autoTable: (options: any) => void;
  }
}
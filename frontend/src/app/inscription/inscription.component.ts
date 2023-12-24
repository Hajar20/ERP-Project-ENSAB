import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { InscriptionServiceService } from '../services/inscription/InscriptionService.service';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  inscriptionForm: FormGroup;
  successMessage: string = '';
  isInspectionEnded: boolean = false;
  endInscriptionDate?:Date;

  constructor(private fb: FormBuilder, private inscriptionService: InscriptionServiceService) {

    this.inscriptionForm = this.fb.group({
      // Information personnelle
      sexe: ['', Validators.required],
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      cne: ['', Validators.required],
      cni: ['', Validators.required],
      dateNaissance: ['', Validators.required],
      telephone: ['', Validators.required],

      // Bac info
      bacType: ['', Validators.required],
      bacOption: ['', Validators.required],
      bacDateObtention: ['', Validators.required],
      bacMention: ['', Validators.required],

      // Diplome info
      diplomeType: ['', Validators.required],
      diplomeSpeciality: ['', Validators.required],
      diplomeDateObtention: ['', Validators.required],
      ecole: ['', Validators.required],
      noteS1: ['', Validators.required],
      noteS2: ['', Validators.required],
      noteS3: ['', Validators.required],
      noteS4: ['', Validators.required],

      // Bac+3
      isBac3: [false],
      diplomeTypeBac3: [''],
      diplomeSpecialityBac3: [''],
      diplomeDateObtentionBaC3:[''],
      ecoleBac3: [''],
      noteS5: [''],
      noteS6: [''],

      // Choix filière
      filiere: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.inscriptionService.getCriteria().subscribe(
      (criteria) => {
        this.endInscriptionDate = new Date(criteria.endDate);
        this.isInspectionEnded = new Date() >= this.endInscriptionDate;
        console.log('End date:', this.endInscriptionDate);
      },
      (error) => {
        console.error('Error fetching criteria', error);
      }
    );
  }

  submitForm() {
    if (this.inscriptionForm.valid) {
      const formData = this.inscriptionForm.value;

      // Assuming your backend expects data in the specified format
      const backendData = {
        cne: formData.cne,
        firstname: formData.prenom,
        lastname: formData.nom,
        birthdate: formData.dateNaissance,
        cni: formData.cni,
        phone: formData.telephone,
        sexe: formData.sexe,
        major: {
          name: formData.filiere
        },
        degrees: [
          {
          type: formData.diplomeType,
          degreeType: 'Bac+2', // Assuming it's always Bac+2 for this form
          speciality: formData.diplomeSpeciality,
          diplomaDate: formData.diplomeDateObtention,
          s1: formData.noteS1,
          s2: formData.noteS2,
          s3: formData.noteS3,
          s4: formData.noteS4,
          s5: formData.noteS5 || 0, // Assuming these fields are optional
          s6: formData.noteS6 || 0,
          college: formData.ecole
        },
        ...(formData.isBac3
          ? [
              {
                type: formData.diplomeTypeBac3,
                degreeType: 'Bac+3',
                speciality: formData.diplomeSpecialityBac3,
                diplomaDate: formData.diplomeDateObtentionBac3,
                s5: formData.noteS5 || 0,
                s6: formData.noteS6 || 0,
                college: formData.ecoleBac3
              }
            ]
          : [])
      ],
        bac: {
          type: formData.bacType,
          option: formData.bacOption,
          dateObtaining: formData.bacDateObtention,
          distinction: formData.bacMention
        }
      };

      this.inscriptionService.sendInscriptionData(backendData).subscribe(
        (response) => {
          this.successMessage = response.message; 
          this.openModal();
          console.log('Data sent successfully', response);
        },
        (error) => {
          console.error('Error sending data to the backend', error);
        }
      );
    } else {
      this.successMessage = "please fill all the required fields !!"; 
      this.openModal();
      console.log('Form is not valid', this.inscriptionForm.value);
    }
  }

  openModal() {
    const modal = document.getElementById('myModal');
    if (modal) {
      modal.style.display = 'block';
    }
  }

  closeModal() {
    const modal = document.getElementById('myModal');
    if (modal) {
      modal.style.display = 'none';
    }
  }

  isEndOfInscription(): boolean {
    return this.isInspectionEnded;
  }

}
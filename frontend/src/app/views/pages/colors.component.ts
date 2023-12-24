import {  Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../../app.service";
import {StorageService} from "../../storage.service";
import {FormControl, FormBuilder, FormGroup, FormArray, Validators, AbstractControl} from "@angular/forms";


@Component({
  templateUrl: 'colors.component.html'
})
export class ColorsComponent implements OnInit {
  myForm= new FormGroup({
    details: new FormControl('', Validators.required),
    startDate:  new FormControl('', Validators.required),
    endDate:  new FormControl('', Validators.required),
    threshold1:  new FormControl('', Validators.required),
    threshold2:  new FormControl('', Validators.required),
    threshold3:  new FormControl('', Validators.required),
    link:  new FormControl('', Validators.required),
    majorPlaces : new FormArray([
        new FormGroup({
          major : new FormControl('', Validators.required) ,
          availablePlaces : new FormControl('', Validators.required)
        })
    ])
  })
  user : any = null
  constructor(private fb: FormBuilder,private router: Router,private app : AppService,private storageService: StorageService) {
  }
  majors: any[] = [{ name: '', availablePlaces: '' }];
  getMajorPlacesControls() {
    return (this.myForm.get('majorPlaces') as FormArray).controls;
  }

  addMajor() {
    const majorArray = this.myForm.get('majorPlaces') as FormArray;
    majorArray.push(this.fb.group({
      major: new FormControl(''),
      availablePlaces: new FormControl('')
    }));
  }
  isFieldsEmpty:boolean = false
  alert : boolean = false
onSubmit(){

    if(this.myForm.value.details === '' || this.myForm.value.startDate === '' ||
        this.myForm.value.endDate === '' || this.myForm.value.threshold1 === ''
        || this.myForm.value.threshold2 === '' || this.myForm.value.threshold3 === ''
        || this.myForm.value.majorPlaces?.length === 0
    ){
      this.isFieldsEmpty = true
    } else {
      //console.log('majorPlacesData',this.myForm.value.majorPlaces)
      this.app.addCriteria(this.myForm.value).subscribe((response: any) => {
            //console.warn("The criteria :", response);
            this.alert=true
            this.myForm.reset();
          },
      );
    }


}
  closeAlert(){
    this.isFieldsEmpty = false
    this.alert=false
  }
  ngOnInit(): void {
    this.addMajor();
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




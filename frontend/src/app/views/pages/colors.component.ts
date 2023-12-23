import {  Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../../app.service";
import {StorageService} from "../../storage.service";
import {FormControl,FormBuilder, FormGroup, FormArray} from "@angular/forms";


@Component({
  templateUrl: 'colors.component.html'
})
export class ColorsComponent implements OnInit {
  myForm= new FormGroup({
    details: new FormControl(''),
    startDate:  new FormControl(''),
    endDate:  new FormControl(''),
    threshold1:  new FormControl(''),
    threshold2:  new FormControl(''),
    threshold3:  new FormControl(''),
    link:  new FormControl(''),
    majorPlaces : new FormArray([
        new FormGroup({
          major : new FormControl('') ,
          availablePlaces : new FormControl('')
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

  alert : boolean = false
onSubmit(){
//console.log('majorPlacesData',this.myForm.value.majorPlaces)
  this.app.addCriteria(this.myForm.value).subscribe((response: any) => {
        //console.warn("The criteria :", response);
        this.alert=true
        this.myForm.reset();
      },
    );

}
  closeAlert(){
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




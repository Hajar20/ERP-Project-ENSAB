import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { StorageService } from '../storage.service';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit{
  login = new FormGroup({
    email : new FormControl(''),
    password : new FormControl(''),

  })
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  alert : boolean = false
  constructor(private router: Router,private app : AppService,private storageService: StorageService) { }
  ngOnInit() {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    this.app.login(this.login.value.email, this.login.value.password).subscribe({
      next: data => {
        this.storageService.setUserInSession(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        //this.reloadPage();
        this.router.navigate(['/home']);
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
        this.alert=true
        this.login.reset({})
      }
    });
  }
  closeAlert(){
    this.alert=false
  }
  reloadPage(): void {
    window.location.reload();
  }


  goToPortfolioAndRefresh() {
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate(['']);
    });
  }
}

import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user:any={
    username:'',
    email:'',
    roles:["user"],
    password:''
  }
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private signupService:AuthService,private router:Router){}

  
  ngOnInit() {
    
  }

  
  onCreateAccount(){
    // console.log(this.signup);  
    this.signupService.registerUser(this.user)
    .subscribe(data=>{
    console.log(data);
    this.isSuccessful = true;
    this.isSignUpFailed = false;
    this.router.navigate(['login']);
    },
    err=>{
      this.errorMessage=err.error.message;
      this.isSignUpFailed=true;
    }
    ) ;  
  }
  
  }


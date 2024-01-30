import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { User } from '../../common/user';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrl: './signin.component.css'
})
export class SigninComponent {

  storage : Storage=localStorage
  constructor(private service: UserService, private router: Router) { }
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.maxLength(30)]),
    password: new FormControl('', [Validators.required, Validators.maxLength(30)]),
   UserId: new FormControl('', [Validators.required, Validators.maxLength(30)]),
  });
  login(insert: any) {
    console.log(this.loginForm);
  
  }

  get emailId() {
    return this.loginForm.get('email');

  }
  get password() {
    return this.loginForm.get('password')
  }
  submit() {
    if (  this.emailId?.value?.length === 0 || this.password?.value?.length == 0 || this.emailId?.invalid || this.password?.invalid) {
      alert("enter valid details")
    }
    else {
     // alert(JSON.stringify(this.loginForm.value))
      let user: User = new User()
     
      user.email= this.loginForm.value.email
      user.password = this.loginForm.value.password
      //admin.adminId=this.loginForm.value.adminId

      this.service.getuser(user).subscribe(
        data => {
          console.log(data)
          this.service.getuser(user).subscribe()
         this.storage.setItem('currentAdminUser', JSON.stringify( this.emailId?.value ));
          alert("loged in")
          this.router.navigate(['/userpage'])
        },
        error => {
          alert("invalid credentials")
        }

      );
    }
  }

}
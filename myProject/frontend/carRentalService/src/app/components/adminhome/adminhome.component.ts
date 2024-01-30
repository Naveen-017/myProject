import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Admin } from '../../common/admin';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrl: './adminhome.component.css'
})
export class AdminhomeComponent {


  storage : Storage=localStorage
  constructor(private service: AdminService, private router: Router) { }
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.maxLength(30)]),
    password: new FormControl('', [Validators.required, Validators.maxLength(30)]),
   
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
      alert(JSON.stringify(this.loginForm.value))
      let admin: Admin = new Admin()
     
      admin.email= this.loginForm.value.email
      admin.password = this.loginForm.value.password
      //admin.adminId=this.loginForm.value.adminId

      this.service.getAdmin(admin).subscribe(
        data => {
          console.log(data)
          this.service.getAdmin(admin).subscribe()
         this.storage.setItem('currentAdminUser', JSON.stringify( this.emailId?.value ));
          alert("loged in")
          this.router.navigate(['/adminpage'])
        },
        error => {
          alert("invalid credentials")
        }

      );
    }
  }

}
  



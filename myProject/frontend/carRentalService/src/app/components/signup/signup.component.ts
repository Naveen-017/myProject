import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
userForm : FormGroup;
  constructor(
    private builder: FormBuilder,
    private service: UserService,
    private router: Router){}


    ngOnInit() {
      this.userForm = this.builder.group({
        firstName: [
          '',
          [Validators.required, Validators.pattern('^[a-zA-Z]*$')],

          
        ],

        lastName: [
          '',
          [Validators.required, Validators.pattern('^[a-zA-Z]*$')],
        ],

        gender: [
          '',
          [Validators.required, Validators.pattern('^[a-zA-Z]*$')],
        ],
        address: [
          '',
          [Validators.required, Validators.pattern('^[a-zA-Z]*$')]
        ],

        password: [
          '',
          [Validators.required, Validators.pattern('^[a-zA-Z]*$')],

          
        ],
        email: ['', [Validators.required, Validators.email]],
        mobileNumber: [
          '',
          [Validators.required, Validators.pattern('^[6-9][0-9]{9}$')],
        ],
        
      });
    }
  
    createUser() {
      if (this.userForm.valid) {
        this.service.createUser(this.userForm.value).subscribe((data) => {
          this.router.navigateByUrl('/signin');
          console.log(data);
        });
      } else {
        console.log(this.userForm.value);
      }
    }

}

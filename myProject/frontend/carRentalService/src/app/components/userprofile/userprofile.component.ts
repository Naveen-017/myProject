import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrl: './userprofile.component.css'
})
export class UserprofileComponent {
  profile: any;

  constructor(private us:UserService) {
    const user = localStorage.getItem('currentUser');
    var currentUser = JSON.parse(user?user:"");
    var token = currentUser.e;

    this.us.getuser({"id":token}).subscribe((result:any)=>{this.profile=result});
   }

  ngOnInit(): void {
  }
  // viewUser(data:any){
  //   this.us.viewUser(data.value).subscribe((result:any)=>{this.user=result});
  // }

}



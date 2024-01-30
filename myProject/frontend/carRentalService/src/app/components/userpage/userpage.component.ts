import { Component } from '@angular/core';
import { User } from '../../common/user';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrl: './userpage.component.css'
})
export class UserpageComponent {


  user: User[];
  


  
  
  
  
  currentUserId:number|null|string=1
  constructor(private service: UserService,private route:ActivatedRoute){}
ngOnInit(){
  this.route.paramMap.subscribe(()=>{
    this.currentUserId;
  })
}

  displayEmployeeJobApplications(){
    this.service.getuser(this.currentUserId).subscribe((data)=>{
      this.user=data
    })
  }
}
  
  



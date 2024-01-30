import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../common/user';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = 'http://localhost:8181/myapp/api/user';

  constructor(private http:HttpClient) { }


  createUser(user: User):Observable<User>{
    return this.http.post<User>(this.baseUrl,user);
  }

  getuser(data: any):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/valid`,data);
  }
  viewProfile(data:any){
    return this.http.post(this.baseUrl,data)
  }
}


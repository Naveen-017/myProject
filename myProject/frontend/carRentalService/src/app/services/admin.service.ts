import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  
  baseUrl = 'http://localhost:8181/myapp/api/admin';

  constructor(private http:HttpClient) { }


  getAdmin(data: any):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/valid`,data);
  }
}

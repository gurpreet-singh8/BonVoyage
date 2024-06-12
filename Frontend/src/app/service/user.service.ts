import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  register(user:any):Observable<any>{
    return this.http.post('http://localhost:8094/api/users/register',user);
  }
  login(email:String,password:String):Observable<any>{
    return this.http.post<any>('http://localhost:8094/api/users/login',{email,password})
  }
}

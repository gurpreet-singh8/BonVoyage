import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  register(user:any):Observable<any>{
    return this.http.post('localhost:8094/api/users/register',user);
  }
login(email:String,password:String):Observable<any>{
  return this.http.post<any>('localhost:8094/api/users/login',{email,password})
}

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url ="http://localhost:8094/api/users"
  constructor(private http:HttpClient) { }

  register(user:any):Observable<any>{
    return this.http.post(`${this.url}/register`,user);
  }
login(email:String,password:String):Observable<any>{
  return this.http.post(`${this.url}/login`,{email,password})
}
getWishlist(userId:string,wishlistId:String): Observable<any> {
  return this.http.get(`http://localhost:8094/api/users/${userId}/${wishlistId}`);
  // localhost:8094/api/users/U101/W101

}
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

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
  getWishlist(userId:string|null,wishlistId:String|null): Observable<any> {
    return this.http.get(`http://localhost:8094/api/users/${userId}/${wishlistId}`);

  }
  removeWishlistItem(userId:String|null, packageId: string|null, wishlistId:string|null): Observable<any> {
    return this.http.delete(`${this.url}/${userId}/${wishlistId}/${packageId}`);
  }
  addPackageToWishlist(userId:String|null, wishlistId:string|null,packageId: string|null):Observable<any> {
    return this.http.post(`${this.url}/${userId}/${wishlistId}/${packageId}`,{});
  }

  
}

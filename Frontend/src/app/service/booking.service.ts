import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private url = "http://localhost:4000/bookings"
  constructor(private http: HttpClient) {}
  public createBookings(payload: any):any{
    return this.http.post(`${this.url}`,payload);
  }
  public getAllPackages(userId:any):any{
    return this.http.get(`${this.url}/${userId}`);
  }
  public updateBookings(payload:any):any{
    return this.http.put(`${this.url}`,payload);
  }
  public deleteBookings(bookingId:any):any{
    return this.http.delete(`${this.url}/${bookingId}`);
  }

}

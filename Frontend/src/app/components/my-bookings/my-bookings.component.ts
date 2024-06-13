import { Component, OnInit } from '@angular/core';
import { BookingService } from '../../service/booking.service';
import { PackageService } from '../../service/package.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-bookings',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule],
  templateUrl: './my-bookings.component.html',
  styleUrls: ['./my-bookings.component.css']
})
export class MyBookingsComponent implements OnInit {
  myForm: FormGroup = new FormGroup({});
  bookingList: any = [];
  userID: string | null = localStorage.getItem('userID');
  Edit = false;
  currBookingId:any; 
  packageID: any;
  packageData: any;
  errorMessage: string | undefined;
  constructor(private bookingService: BookingService,
    private packageService: PackageService, 
    private router: Router) {}

  getBookings():any{
    if (this.userID) {
      this.bookingService.getBookingById(this.userID).subscribe(
        (data: any) => {
          this.bookingList = data;
          console.log(this.bookingList);
        },
        (error: any) => {
          console.error('Error fetching booking data', error);
        }
      );
    }
  }
  ngOnInit(): void {
    const user = localStorage.getItem("userID");

    if(!user){
      this.router.navigate(['/signin']);
    }
    this.getBookings();
   
    this.myForm = new FormGroup({
      bookingRooms: new FormControl(null, [Validators.required, Validators.min(1)]),
      bookingPerson: new FormControl(null,[Validators.required, Validators.min(1)])
    });
    
  }


  editBooking(){
    if (this.myForm.invalid) {
      return;
    }
    const booking = this.bookingList.filter((booking: any) => booking.bookingId === this.currBookingId);
    console.log(booking[0]);
    
    const payload = {
      bookingRooms: this.myForm.value.bookingRooms,
      bookingPerson: this.myForm.value.bookingPerson,
      userId: this.userID,
      packageId: booking[0].packageId,
      bookingId: this.currBookingId,
      bookingDate: new Date().toISOString().split('T')[0],
      packageImage: booking[0].packageImage,
      packageName: booking[0].packageName
    };
    console.log(payload);

    this.bookingService.createBookings(payload).subscribe(
      (res: any) => {
        console.log(res);
        this.getBookings();
        this.Edit = !this.Edit;
      },
      (err: any) => {
        console.error(err);
        this.errorMessage = 'An error occurred while booking.\nPlease Enter Correct data !!!'; 
      }
    );

  }
  showEdit(bookingId:any) {
    this.Edit = !this.Edit;
    this.currBookingId = bookingId;
  }
  delete(bookingId:any){
    this.bookingService.deleteBookings(bookingId).subscribe(
      (res:any)=>{
        console.log(res);

        this.bookingList = this.bookingList.filter((booking: any) => booking.bookingId !== bookingId);
        
      }
    )
    
  }
}

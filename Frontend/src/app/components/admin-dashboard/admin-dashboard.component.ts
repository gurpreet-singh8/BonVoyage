import { Component, OnInit } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule } from '@angular/material/input';
import { PackageService } from '../../service/package.service';
import { BookingService } from '../../service/booking.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent  implements OnInit {
  bookings= [];
  packages= [];

  displayedBookingColumns: string[] = ['bookingId', 'userId', 'packageName', 'bookingDate', 'bookingPerson', 'bookingRooms'];
  displayedPackageColumns: string[] = ['packageID', 'packageName', 'packageCountry', 'packageCity', 'packageDesc', 'packagePrice', 'packageDuration'];

  constructor(private bookingService: BookingService,
    private packageService: PackageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const role = localStorage.getItem("role");
    if(role!="admin"){
      this.router.navigate(['/']);
    } 
    this.getBookings();
    this.getPackages();
    console.log(this.packages);
  }

  getBookings(): void {
    this.bookingService.getAllBooking().subscribe(
      (data: never[]) => {
        this.bookings = data;
        console.log('Bookings fetched:', this.bookings);
      },
      (error: any) => {
        console.error('Error fetching bookings:', error);
      }
    );
  }

  getPackages(): void {
    this.packageService.getAllPackages().subscribe(
      (data: { data: never[]; }) => {
        this.packages = data.data;
        console.log('Packages fetched:', this.packages);
      },
      (error: any) => {
        console.error('Error fetching packages:', error);
      }
    );
  }
}
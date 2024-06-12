import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PackageService } from '../../service/package.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { BookingService } from '../../service/booking.service';
import { CommonModule } from '@angular/common';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-package-page',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, CommonModule],
  templateUrl: './package-page.component.html',
  styleUrls: ['./package-page.component.css']
})
export class PackagePageComponent implements OnInit {

  packageID: string | undefined;
  userID: string | null = localStorage.getItem('userID');
  wishID: string | null = localStorage.getItem('wishlistID');
  packageData: any;
  myForm: FormGroup = new FormGroup({});
  errorMessage: string = ''; 

  constructor(
    private route: ActivatedRoute,
    private packageService: PackageService,
    private bookingService: BookingService,
    private wishlistService: UserService,
    private router: Router
  ) {}
  checkWishlist(): void {
    if (this.userID && this.wishID) {
      this.wishlistService.getWishlist(this.userID, this.wishID).subscribe(
        (wishlistData) => {
          console.log(wishlistData.data);
          const wishlistPackages = wishlistData.data;

          // Check if packageID is in the wishlist
          const isPresent = wishlistPackages.some((packageItem: any) => packageItem.packageID === this.packageID);
          this.packageData.present = isPresent;

          console.log('Updated packageData:', this.packageData);
        },
        (error) => {
          console.error('Error fetching wishlist', error);
        }
      );
    } else {
      console.error('User ID or Wishlist ID is null');
    }
  }
  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('packageID');
    this.packageID = param != null ? param : '';
    this.packageService.getPackageById(this.packageID).subscribe((data: any) => {
      this.packageData = data;
      console.log(data);
      this.checkWishlist();

    });
    this.myForm = new FormGroup({
      bookingRooms: new FormControl(null, [Validators.required, Validators.min(1)]),
      bookingPerson: new FormControl(null, [
        Validators.required,
        Validators.min(1),
        this.maxPeopleValidator.bind(this)
      ])
    });
  }

  
  maxPeopleValidator(control: FormControl): { [key: string]: boolean } | null {
    if (this.packageData && control.value > this.packageData.maxPeople) {
      return { maxPeopleExceeded: true };
    }
    return null;
  }

  onSubmit() {
    if (this.myForm.invalid) {
      return;
    }
    const payload = {
      bookingRooms: this.myForm.value.bookingRooms,
      bookingPerson: this.myForm.value.bookingPerson,
      userId: this.userID,
      packageId: this.packageID,
      bookingDate: new Date().toISOString().split('T')[0],
      packageImage: this.packageData.packageImage,
      packageName: this.packageData.packageName
    };
    console.log(payload);

    this.bookingService.createBookings(payload).subscribe(
      (res: any) => {
        console.log(res);
        this.router.navigate(['/checkout']);
      },
      (err: any) => {
        console.error(err);
        this.errorMessage = 'An error occurred while booking.\nPlease Enter Correct data !!!'; 
      }
    );
  }
  addToWishlist(packageID: any) {
    this.wishlistService.addPackageToWishlist(this.userID,this.wishID,packageID).subscribe((res)=>{
      console.log(res);
      this.checkWishlist();

      
  })
  }
}

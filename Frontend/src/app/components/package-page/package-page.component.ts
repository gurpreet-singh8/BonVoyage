import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PackageService } from '../../service/package.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BookingService } from '../../service/booking.service';

@Component({
  selector: 'app-package-page',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './package-page.component.html',
  styleUrl: './package-page.component.css'
})
export class PackagePageComponent {
  packageID: string | undefined;
  userID: string|null= null;
  packageData:any;
  myForm: FormGroup = new FormGroup({});
  constructor(private route: ActivatedRoute,
    private packageService:PackageService,
    private bookingService: BookingService) { }

  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('packageID');
    this.packageID = param!=null?param:"";
    this.packageService.getPackageById(this.packageID).subscribe((data: any)=>{
      this.packageData = data;
    });
    this.myForm = new FormGroup({
      "bookingRooms":new FormControl(null),
      "bookingPerson":new FormControl(null),
      
    });
  }
  onSubmit(){
    const payload= {
      "bookingRooms": this.myForm.value.bookingRooms,
      "bookingPerson": this.myForm.value.bookingPerson,
      "userId":this.userID,
      "packageId":this.packageID,
      "bookingDate":"2024-06-09",
      "packageImage": "https://example.com/images/package.jpg",
    }
    this.bookingService.createBookings(payload).subscribe((res:any)=>{
      console.log(res);
      
    })
    
  }
}

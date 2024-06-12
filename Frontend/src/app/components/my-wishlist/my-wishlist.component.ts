import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-my-wishlist',
  standalone: true,
  imports: [CommonModule,FormsModule,MatIconModule],
  templateUrl: './my-wishlist.component.html',
  styleUrl: './my-wishlist.component.css'
})
// export class MyWishlistComponent{
export class MyWishlistComponent  implements OnInit {
  user:any
  userId: string|null = localStorage.getItem("userID"); 
  wishlistId: string|null = localStorage.getItem("wishlistID");
  wishlist: any[] = [
    {
      // wishlistId:"",
      packageID: 'P101',
      packageImage: 'https://www.trawell.in/blog/wp-content/uploads/2024/03/ooty-main-730x410.jpg',
      packageCountry: 'India',
      packageCity: 'Hyderabad',
      packageName: 'Cultural Tamil Nadu',
      packageDesc: 'Experience the rich culture and heritage of Tamil Nadu. Visit temples, beaches, and heritage sites in Chennai, Madurai, and Thanjavur.',
      packageRating: 4.5,
      packagePrice: '20000',
      packageDuration: '5 days',
      availableDate: '2024-06-13'
    },
    {
      // wishlistId:"",
      packageID: 'P101',
      packageImage: 'https://hblimg.mmtcdn.com/content/hubble/img/ooty/mmt/activities/t_ufs/m_activities-ooty-pykara-waterfalls_l_400_640.jpg',
      packageCountry: 'India',
      packageCity: 'Hyderabad',
      packageName: 'Cultural Tamil Nadu',
      packageDesc: 'Experience the rich culture and heritage of Tamil Nadu. Visit temples, beaches, and heritage sites in Chennai, Madurai, and Thanjavur.',
      packageRating: 4.5,
      packagePrice: '20000',
      packageDuration: '5 days',
      availableDate: '2024-06-13'
    },
    {
      // wishlistId:"",
      packageID: 'P101',
      packageImage: 'https://hblimg.mmtcdn.com/content/hubble/img/ooty/mmt/activities/t_ufs/m_activities-ooty-pykara-waterfalls_l_400_640.jpg',
      packageCountry: 'India',
      packageCity: 'Hyderabad',
      packageName: 'Cultural Tamil Nadu',
      packageDesc: 'Experience the rich culture and heritage of Tamil Nadu. Visit temples, beaches, and heritage sites in Chennai, Madurai, and Thanjavur.',
      packageRating: 4.5,
      packagePrice: '20000',
      packageDuration: '5 days',
      availableDate: '2024-06-13'
    }
  ]
  constructor(private wishlistService: UserService) {}

  ngOnInit(): void {
    this.wishlistService.getWishlist(this.userId,this.wishlistId).subscribe(
      (data) => {
        console.log(data);
        
        this.wishlist = data.data;
      },
      (error) => {
        console.error('Error fetching wishlist', error);
      }
    );
  }
  removeFromWishlist(packageId: string): void {

    this.wishlistService.removeWishlistItem(this.userId,packageId,this.wishlistId).subscribe(
      response => {
        console.log(response);

        this.wishlist = this.wishlist.filter((wish: any) => {
          console.log(wish.packageID,packageId);
          wish.packageID !== packageId
      });
      }
    );
    console.log("wishlist id",this.wishlistId)
  }
  

}

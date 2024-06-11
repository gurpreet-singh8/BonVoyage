import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-my-wishlist',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './my-wishlist.component.html',
  styleUrl: './my-wishlist.component.css'
})
export class MyWishlistComponent{
// export class MyWishlistComponent  implements OnInit {
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

  // ngOnInit(): void {
  //   const wishlistId = '';
  //   const userId=''; 
  //   this.wishlistService.getWishlist(userId,wishlistId).subscribe(
  //     (data) => {
  //       this.wishlist = data;
  //     },
  //     (error) => {
  //       console.error('Error fetching wishlist', error);
  //     }
  //   );
  // }
  removeFromWishlist(packageId: string,wishlistId:string): void {
    // Remove item from wishlist and update server if needed
    this.wishlist = this.wishlist.filter(item => item.packageId !== packageId);
    this.wishlistService.removeWishlistItem(wishlistId,packageId).subscribe(
      response => {
        console.log('Item removed successfully');
      },
      error => {
        console.error('Error removing item', error);
      }
    );
  }

}

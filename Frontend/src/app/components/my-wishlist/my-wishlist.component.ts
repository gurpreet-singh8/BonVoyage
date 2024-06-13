import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../service/user.service';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-wishlist',
  standalone: true,
  imports: [CommonModule,FormsModule,MatIconModule],
  templateUrl: './my-wishlist.component.html',
  styleUrl: './my-wishlist.component.css'
})
export class MyWishlistComponent  implements OnInit {
  user:any
  userId: string|null = localStorage.getItem("userID"); 
  wishlistId: string|null = localStorage.getItem("wishlistID");
  wishlist: any[] = []
  constructor(private wishlistService: UserService, private router: Router) {}

  ngOnInit(): void {
    const user = localStorage.getItem("userID");

    if(!user){
      this.router.navigate(['/signin']);
    }
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
    console.log("wishlist id",this.wishlistId);
    location.reload();
  }
  

}

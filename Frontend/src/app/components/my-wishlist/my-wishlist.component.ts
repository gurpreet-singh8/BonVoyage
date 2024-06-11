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
export class MyWishlistComponent  implements OnInit {
  wishlist: any[] = [];

  constructor(private wishlistService: UserService) {}

  ngOnInit(): void {
    const wishlistId = '';
    const userId=''; 
    this.wishlistService.getWishlist(userId,wishlistId).subscribe(
      (data) => {
        this.wishlist = data;
      },
      (error) => {
        console.error('Error fetching wishlist', error);
      }
    );
  }

}

import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './sign-in.component.html',
  styleUrl: './sign-in.component.css'
})
export class SignInComponent {
  user: any = {
    email: '',
    password: ''
    
  };

  constructor(private authService: UserService, private router: Router) {}
  ngOnInit(): void {
    const user = localStorage.getItem("userID");
    
    if(user){
      this.router.navigate(['/home']);
    }
  }
  onSubmit() {
    this.authService.login(this.user.email, this.user.password).subscribe(
      data => {
        console.log('User logged in successfully', data);
        localStorage.setItem("userID",data.id);
        localStorage.setItem("wishlistID",data.wishlist[0].wishlistId);
        localStorage.setItem("role",data.role);
        location.reload();
        this.router.navigate(['/']);
      },
      error => {
        console.error('Error logging in user', error);
      }
    );
  }
   
  }



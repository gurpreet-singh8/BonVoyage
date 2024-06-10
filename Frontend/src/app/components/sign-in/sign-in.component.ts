import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ServiceService } from '../../service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

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

  constructor(private authService: ServiceService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.user.email, this.user.password).subscribe(
      data => {
        console.log('User logged in successfully', data);
        this.router.navigate(['/']);
      },
      error => {
        console.error('Error logging in user', error);
      }
    );
  }
   
  }



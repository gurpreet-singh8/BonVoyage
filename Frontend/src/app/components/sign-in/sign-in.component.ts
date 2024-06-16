import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  loginForm: FormGroup;
  backendError: string | null = null;

  constructor(private formBuilder: FormBuilder, private authService: UserService, private router: Router) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    const user = localStorage.getItem("userID");
    if (user) {
      this.router.navigate(['/home']);
    }
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.authService.login(email, password).subscribe(
        data => {
          console.log('User logged in successfully', data);
          localStorage.setItem("userID", data.id);
          localStorage.setItem("wishlistID", data.wishlist[0].wishlistId);
          localStorage.setItem("role", data.role);
          location.reload();
          this.router.navigate(['/']);
        },
        error => {
          console.error('Error logging in user', error);
          this.backendError = 'Error logging in user: ' + (error.error.message || error.message);
        }
      );
    }
  }
}

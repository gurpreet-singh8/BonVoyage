import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UserService } from '../../service/user.service';


@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

  user: any = {
    name: '',
    email: '',
    phone: '',
    password: '',
    address: '',
  };
  constructor(private userService: UserService, private router: Router) {}

  onSubmit() {

    this.userService.register(this.user).subscribe((data)=>{
      console.log('User registered successfully', data);
      this.router.navigate(['/signin']);
    }, error => {
      console.error('Error registering user', error);
    });
   
  }
}

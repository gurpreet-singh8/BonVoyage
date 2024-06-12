import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
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

  constructor(private userService: UserService, private router: Router) {}
  onSubmit() {

    this.userService.login(this.user.email, this.user.password).subscribe((data)=>{
      console.log('User Logined successfully', data);
      localStorage.setItem("userID",data.id)
       this.router.navigate(['/']);
    }, error => {
      console.error('Error registering user', error);
    });
   
  }

}

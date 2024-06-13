import { Router, RouterOutlet } from '@angular/router';
import { AllPackageComponent } from './components/all-package/all-package.component';
import { Component, ViewChild } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { RouterLink } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatIcon } from '@angular/material/icon';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,AllPackageComponent,MatToolbarModule, MatSidenavModule, RouterLink, FlexLayoutModule,MatIcon],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title(title: any) {
    return "Bonvoyage"
  }

  @ViewChild('sidenav') sidenav!: MatSidenav;

  constructor(private router: Router){

  }
  toggleSidenav() {
    this.sidenav.toggle();
  }
  user:any = null;
  role:any = null;
  ngOnInit(): void {
    this.user = localStorage.getItem("userID");
    this.role = localStorage.getItem("role");
    

  }
  logout() {
    localStorage.clear();
    location.reload();
  }
}

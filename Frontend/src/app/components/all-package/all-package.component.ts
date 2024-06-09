import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-all-package',
  standalone: true,
  imports: [MatIconModule,RouterLink],
  templateUrl: './all-package.component.html',
  styleUrl: './all-package.component.css'
})
export class AllPackageComponent {

}

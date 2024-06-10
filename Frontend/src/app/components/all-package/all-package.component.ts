import { Component, OnInit } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { PackageService } from '../../service/package.service';

@Component({
  selector: 'app-all-package',
  standalone: true,
  imports: [MatIconModule,RouterLink],
  templateUrl: './all-package.component.html',
  styleUrl: './all-package.component.css'
})
export class AllPackageComponent implements OnInit{
  packageList:any = [];
  constructor(private packageService:PackageService){}
  ngOnInit(): void {
    this.packageService.getAllPackages().subscribe((data: any)=>{
      this.packageList = data;
    });
    console.log(this.packageList);
    
  }

}

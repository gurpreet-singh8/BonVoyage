import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PackageService } from '../../service/package.service';

@Component({
  selector: 'app-package-page',
  standalone: true,
  imports: [],
  templateUrl: './package-page.component.html',
  styleUrl: './package-page.component.css'
})
export class PackagePageComponent {
  packageID: string | undefined;
  packageData:any;
  constructor(private route: ActivatedRoute,private packageService:PackageService) { }

  ngOnInit(): void {
    const param = this.route.snapshot.paramMap.get('packageID');
    this.packageID = param!=null?param:"";
    this.packageService.getPackageById(this.packageID).subscribe((data: any)=>{
      this.packageData = data;
      console.log(this.packageData);
      
    })
  }
}

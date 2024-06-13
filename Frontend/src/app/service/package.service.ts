import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PackageService {
  private url = "http://localhost:8080/api/package"
  constructor(private http: HttpClient) {}
  public getAllPackages():any{
    return this.http.get(`${this.url}/getPackages`);
  }
  public getPackageById(packageID:string):any{
    return this.http.get(`${this.url}/onepackage/${packageID}`);
  };
  public getPackageByCountry(country:string):any{
    return this.http.get(`${this.url}/packages/${country}`);
  }
}

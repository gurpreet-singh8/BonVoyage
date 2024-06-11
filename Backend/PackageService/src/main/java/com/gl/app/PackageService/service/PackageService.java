package com.gl.app.PackageService.service;

import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageResponse;
import org.springframework.stereotype.Service;


@Service
public interface PackageService {

    public PackageDto createPackage(PackageDto packageDto);
    public PackageResponse getAllPackages();
    public PackageDto getPackageById(String packageID);
    public  PackageResponse  getPackageByCountry(String country);
}

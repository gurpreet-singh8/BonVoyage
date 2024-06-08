package com.gl.app.PackageService.service;

import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PackageService {

    public PackageDto createPackage(PackageDto packageDto);
    public PackageResponse getAllPackages();
    public PackageDto getPackageById(String packageID);
    public  PackageResponse  getPackageByCountry(String country);
}

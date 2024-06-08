package com.gl.app.PackageService.controller;

import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageResponse;
import com.gl.app.PackageService.service.PackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class PackageController {

    private final PackageService packageService;

    private final PackageResponse packageResponse;
    public PackageController(PackageService packageService, PackageResponse packageResponse) {
        this.packageService = packageService;
        this.packageResponse = packageResponse;
    }

    @PostMapping("/createPackage")
    public ResponseEntity<PackageDto> createPackage(@RequestBody PackageDto packageDto){
        return new ResponseEntity<>(packageService.createPackage(packageDto), HttpStatus.CREATED);
    }

    @GetMapping("/getPackages")
    public PackageResponse getAllPackages(){
        return packageService.getAllPackages();
    }

    @GetMapping("packages/{country}")
    public PackageResponse getPackagesByCountry(@PathVariable String country){
        return packageService.getPackageByCountry(country);
    }

    @GetMapping("onepackage/{id}")
    public PackageDto getPackageById(@PathVariable String id){
        return packageService.getPackageById(id);
    }
}

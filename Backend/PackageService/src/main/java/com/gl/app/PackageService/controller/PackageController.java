package com.gl.app.PackageService.controller;

import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageResponse;
import com.gl.app.PackageService.service.PackageService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @CrossOrigin("*")
    @PostMapping("/createPackage")
    public ResponseEntity<PackageDto> createPackage(@Valid @RequestBody PackageDto packageDto){
        return new ResponseEntity<>(packageService.createPackage(packageDto), HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @GetMapping("/getPackages")
    public PackageResponse getAllPackages(){
        return packageService.getAllPackages();
    }

    @CrossOrigin("*")
    @GetMapping("packages/{country}")
    public PackageResponse getPackagesByCountry(@Valid @PathVariable String country){
        return packageService.getPackageByCountry(country);
    }

    @CrossOrigin("*")
    @GetMapping("onepackage/{id}")
    public PackageDto getPackageById(@Valid @PathVariable String id){
        return packageService.getPackageById(id);
    }
}

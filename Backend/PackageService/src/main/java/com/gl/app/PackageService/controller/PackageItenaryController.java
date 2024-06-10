package com.gl.app.PackageService.controller;

import com.gl.app.PackageService.payload.PackageItenaryDto;
import com.gl.app.PackageService.service.PackageItenaryService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/packageItenary")
public class PackageItenaryController {
    private final PackageItenaryService packageItenaryService;

    public PackageItenaryController(PackageItenaryService packageItenaryService) {
        this.packageItenaryService = packageItenaryService;
    }

    @CrossOrigin("*")
    @PostMapping("/create/{packageId}")
    public ResponseEntity<PackageItenaryDto> createPackageItenary(@Valid @RequestBody PackageItenaryDto packageItenaryDto, @PathVariable String packageId){
        PackageItenaryDto packageItenaryDto1 = packageItenaryService.createPackageItenary(packageItenaryDto,packageId);
        return new ResponseEntity<>(packageItenaryDto1, HttpStatus.CREATED);
    }

}

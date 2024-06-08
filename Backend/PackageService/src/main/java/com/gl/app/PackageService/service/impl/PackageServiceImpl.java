package com.gl.app.PackageService.service.impl;

import com.gl.app.PackageService.PackageServiceApplication;
import com.gl.app.PackageService.entity.Package;
import com.gl.app.PackageService.exception.ResourceNotFoundException;
import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageResponse;
import com.gl.app.PackageService.repository.PackageRepository;
import com.gl.app.PackageService.service.PackageService;
import com.gl.app.PackageService.util.MapperLibrary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service

public class PackageServiceImpl implements PackageService {
    private final PackageRepository packageRepository;
    private final PackageResponse packageResponse;

    public PackageServiceImpl(PackageRepository packageRepository, PackageResponse packageResponse) {

        this.packageRepository = packageRepository;
        this.packageResponse = packageResponse;
    }

    @Override
    public PackageDto createPackage(PackageDto packageDto) {
        Package pack = MapperLibrary.mapToPackageEntity(packageDto);
        pack.setPackageID(PackageServiceApplication.generateId());
        return MapperLibrary.mapToPackageDto(packageRepository.save(pack));
    }

    @Override
    public PackageResponse getAllPackages() {
        List<PackageDto> packageDtoList = packageRepository.findAll().stream().map(MapperLibrary::mapToPackageDto).toList();
        packageResponse.setData(packageDtoList);
        packageResponse.setResults(packageDtoList.size());
        packageResponse.setStatus(true);
        return packageResponse;
    }

    @Override
    public PackageDto getPackageById(String packageID) {
        Package pack = packageRepository.findById(packageID).orElseThrow(
                ()->new ResourceNotFoundException("Package","ID",packageID)
        );
        return MapperLibrary.mapToPackageDto(pack);
    }

    @Override
    public PackageResponse getPackageByCountry(String country) {
        List<Package> packList = packageRepository.findByPackageCountryIgnoreCase(country);
        List<PackageDto> packageDtoList =  packList.stream().map(MapperLibrary::mapToPackageDto).toList();
        packageResponse.setData(packageDtoList);
        packageResponse.setResults(packageDtoList.size());
        packageResponse.setStatus(true);
        return packageResponse;
    }
}

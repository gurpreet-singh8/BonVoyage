package com.gl.app.PackageService.service.impl;

import com.gl.app.PackageService.entity.Package;
import com.gl.app.PackageService.entity.PackageItenary;
import com.gl.app.PackageService.exception.ResourceNotFoundException;
import com.gl.app.PackageService.payload.PackageItenaryDto;
import com.gl.app.PackageService.repository.PackageItenaryRepository;
import com.gl.app.PackageService.repository.PackageRepository;
import com.gl.app.PackageService.service.PackageItenaryService;
import com.gl.app.PackageService.util.MapperLibrary;
import org.springframework.stereotype.Service;

@Service
public class PackageItenaryServiceImpl implements PackageItenaryService {

    private final PackageItenaryRepository packageItenaryRepository;
    private final PackageRepository packageRepository;

    public PackageItenaryServiceImpl(PackageItenaryRepository packageItenaryRepository, PackageRepository packageRepository) {
        this.packageItenaryRepository = packageItenaryRepository;
        this.packageRepository = packageRepository;
    }

    @Override
    public PackageItenaryDto createPackageItenary(PackageItenaryDto packageItenaryDto, String packageId) {
        Package pack = packageRepository.findById(packageId).orElseThrow(
                () -> new ResourceNotFoundException("Package", "packageId", packageId)
        );

        PackageItenary packageItenary = MapperLibrary.mapToPackageItenaryEntity(packageItenaryDto);
        packageItenary.setPack(pack);

        PackageItenary savedPackageItenary = packageItenaryRepository.save(packageItenary);
        return MapperLibrary.mapToPackageItenaryDto(savedPackageItenary);
    }

}

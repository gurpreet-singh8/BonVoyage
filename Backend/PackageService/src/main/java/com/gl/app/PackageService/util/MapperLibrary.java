package com.gl.app.PackageService.util;

import com.gl.app.PackageService.PackageServiceApplication;
import com.gl.app.PackageService.entity.Package;
import com.gl.app.PackageService.entity.PackageItenary;
import com.gl.app.PackageService.payload.PackageDto;
import com.gl.app.PackageService.payload.PackageItenaryDto;

public class MapperLibrary {
    public static PackageDto mapToPackageDto(Package pack){
        return PackageServiceApplication.modelMapper().map(pack,PackageDto.class);
    }
    public static Package mapToPackageEntity(PackageDto pack){
        return PackageServiceApplication.modelMapper().map(pack,Package.class);
    }

    public static PackageItenaryDto mapToPackageItenaryDto(PackageItenary pack){
        return PackageServiceApplication.modelMapper().map(pack,PackageItenaryDto.class);
    }
    public static PackageItenary mapToPackageItenaryEntity(PackageItenaryDto pack){
        return PackageServiceApplication.modelMapper().map(pack,PackageItenary.class);
    }


}

package com.gl.app.PackageService.repository;

import com.gl.app.PackageService.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Package, String> {
    public List<Package> findByPackageCountryIgnoreCase(String country);
}

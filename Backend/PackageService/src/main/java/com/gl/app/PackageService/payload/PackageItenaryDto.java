package com.gl.app.PackageService.payload;


import com.gl.app.PackageService.entity.Package;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackageItenaryDto {
    private String day;
    private String title;
    private String activities;
}

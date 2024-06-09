package com.gl.app.PackageService.payload;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackageItenaryDto {
    @NotBlank
    private String day;

    @NotBlank
    private String title;

    @NotBlank
    private String activities;
}

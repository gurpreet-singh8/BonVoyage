package com.gl.app.PackageService.payload;

import com.gl.app.PackageService.entity.PackageItenary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PackageDto {
    @NotBlank
    private String packageID;

    @NotBlank
    private String packageCountry;

    @NotBlank
    private String packageCity;

    @NotBlank
    private String packageName;

    @NotBlank
    private String packageDesc;

    @Min(1)
    @Max(5)
    private int packageRating;

    @Min(0)
    private int packageReviews;

    @NotBlank
    private String packagePrice;

    @NotBlank
    private String packageDuration;

    @NotBlank
    private String minAge;

    @Min(1)
    private int maxPeople;

    @NotBlank
    private String packagePickup;

    @NotBlank
    private String availableDate;

    @NotBlank
    private String packageLanguage;

    @NotNull
    @Size(min = 1)
    private List<PackageItenaryDto> packageItenary;

    @NotBlank
    private String packageImage;

}



package com.gl.app.PackageService.payload;

import com.gl.app.PackageService.entity.PackageItenary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackageDto {
    private String packageID;
    private String packageCountry;
    private String packageCity;
    private String packageName;
    private String packageDesc;
    private int packageRating;
    private int packageReviews;
    private String packagePrice;
    private String packageDuration;
    private String minAge;
    private int maxPeople;
    private String packagePickup;
    private String availableDate;
    private String packageLanguage;
    private List<PackageItenaryDto> packageItenary;
    private String packageImage;
}

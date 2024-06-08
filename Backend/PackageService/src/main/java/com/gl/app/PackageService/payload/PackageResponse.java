package com.gl.app.PackageService.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class PackageResponse {
    private  boolean status;
    private  int results;
    private List<PackageDto> data;

}

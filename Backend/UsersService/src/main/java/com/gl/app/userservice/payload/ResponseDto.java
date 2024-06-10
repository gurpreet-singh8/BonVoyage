package com.gl.app.userservice.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class ResponseDto {
    private String status;
    private String results;
    private List<PackageDto> data;
}

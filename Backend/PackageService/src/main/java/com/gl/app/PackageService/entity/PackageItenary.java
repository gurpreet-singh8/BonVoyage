package com.gl.app.PackageService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "packageItenary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PackageItenary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String activities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id", nullable = false)
    private Package pack;
}

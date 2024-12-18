package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "hinh_anh")
@Data
@AllArgsConstructor
@Builder
public class HinhAnh {

    @Id
    @Column(name = "ma_hinh_anh")
    private int maHinhAnh;

    @Column(name = "ten_hinh_anh")
    private String tenHinhAnh;

    @Column(name = "la_icon")
    private boolean laIcon;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "du_lieu_anh")
    private String duLieuAnh;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH,
    })
    @JoinColumn(name = "ma_sach", nullable = false)
    private Sach sach;

    public HinhAnh() {
    }
}

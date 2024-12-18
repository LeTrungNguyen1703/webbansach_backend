package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hinh_thuc_giao_hang")
@Data
@Builder
@AllArgsConstructor
public class HinhThucGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_thuc_giao_hang")
    private int maHinhThucGiaoHang;

    @Column(name = "ten_hinh_thuc_giao_hang")
    private String tenHinhThucGiaoHang;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "chi_phi_giao_hang")
    private double chiPhiGiaoHang;

    @OneToMany(mappedBy = "hinh_thuc_giao_hang",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<DonHang> danhSachDonHang;

    public HinhThucGiaoHang() {
    }
}

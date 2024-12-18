package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "su_danh_gia")
@Data
@Builder
@AllArgsConstructor
public class SuDanhGia {

    @Id
    @Column(name = "ma_danh_gia")
    private long maDanhGia;

    @Column(name = "diem_xep_hang")
    private float diemXepHang;

    @Column(name = "nhan_xet")
    private String nhanXet;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_sach", nullable = false)
    private Sach sach;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_nguoi_dung", nullable = false)
    private NguoiDung nguoiDung;

    public SuDanhGia() {

    }
}




























































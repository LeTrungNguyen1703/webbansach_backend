package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "nguoi_dung")
@Data
@Builder
@AllArgsConstructor
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private int maNguoiDung;

    @Column(name = "ho_dem", length = 255)
    private String hoDem;

    @Column(name = "ten", length = 255)
    private String ten;

    @Column(name = "ten_dang_nhap", length = 255)
    private String tenDangNhap;

    @Column(name = "mat_khau", length = 512)
    private String matKhau;

    @Column(name = "gioi_tinh", length = 255)
    private char gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi_mua_hang")
    private String diaChiMuaHang;

    @Column(name = "dia_chi_giao_hang")
    private String diaChiGiaoHang;

    @OneToMany(mappedBy = "nguoi_dung",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<SuDanhGia> danhsachSuDanhGia;

    @OneToMany(mappedBy = "nguoi_dung",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<SachYeuThich> danhSachYeuThich;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "nguoidung_quyen",
            joinColumns = @JoinColumn(name = "ma_nguoi_dung"),
            inverseJoinColumns = @JoinColumn(name = "ma_quyen")
    )
    private List<Quyen> danhSachQuyen;

    @OneToMany(mappedBy = "nguoi_dung",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<DonHang> danhSachDonHang;

    public NguoiDung() {
    }
}

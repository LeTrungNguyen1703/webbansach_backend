package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "don_hang")
@Data
@Builder
@AllArgsConstructor
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_don_hang")
    private int maDonHang;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "dia_chi_mua_hang")
    private String diaChiMuaHang;

    @Column(name = "dia_chi_nhan_hang")
    private String diaChiNhanHang;

    @Column(name = "tong_tien_san_pham")
    private double tongTienSanPham;

    @Column(name = "chi_phi_thanh_toan")
    private double chiPhiThanhToan;

    @Column(name = "tong_tien")
    private double tongTien;

    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH,
    })
    @JoinColumn(name = "ma_nguoi_dung", nullable = false)
    private NguoiDung nguoiDung;

    private HinhThucThanhToan hinhThucThanhToan;

    private HinhThucGiaoHang hinhThucGiaoHang;


}

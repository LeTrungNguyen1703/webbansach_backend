package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "sach")
@Data
@Builder
@AllArgsConstructor
public class Sach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_sach")
    private int maSach;

    @Column(name = "ten_sach", length = 255)
    private String tenSach;

    @Column(name = "ten_tac_gia", length = 512)
    private String tenTacGia;

    @Column(name = "isbn", length = 255)
    private String ISBN;

    @Column(name = "mo_ta", columnDefinition = "text")
    private String moTa;

    @Column(name = "gia_niem_yet")
    private double giaNiemYet;

    @Column(name = "gia_ban")
    private double giaBan;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "trung_binh_xep_hang")
    private double trungBinhXepHang;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "ma_sach"),
            inverseJoinColumns = @JoinColumn(name = "ma_the_loai")
    )
    private List<TheLoai> danhSachTheLoai;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HinhAnh> danhSachHinhAnh;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SuDanhGia> danhSachSuDanhGia;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<ChiTietDonHang> danhSachChiTietDonHang;

    @OneToMany(mappedBy = "sach",fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<SachYeuThich> danhSachYeuThich;

    public Sach() {
    }
}

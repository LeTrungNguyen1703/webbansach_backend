package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import java.util.List;


@Entity
@Table(name = "the_loai")
@Data
@Builder
@AllArgsConstructor
public class TheLoai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_the_loai")
    private int maTheLoai;

    @Column(name = "ten_the_loai")
    private String tenTheLoai;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "sach_theloai",
            joinColumns = @JoinColumn(name = "ma_the_loai"),
            inverseJoinColumns = @JoinColumn(name = "ma_sach")
    )
    private List<Sach> danhSachQuyenSach;

    public TheLoai() {
    }
}

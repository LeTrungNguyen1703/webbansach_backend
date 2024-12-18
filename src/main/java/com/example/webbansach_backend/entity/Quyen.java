package com.example.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quyen")
@Data
@Builder
@AllArgsConstructor
public class Quyen {

    @Id
    @Column(name = "ma_quyen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maQuyen;

    @Column(name = "ten_quyen")
    private String tenQuyen;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(
            name = "nguoidung_quyen",
            joinColumns = @JoinColumn(name = "ma_quyen"),
            inverseJoinColumns = @JoinColumn(name = "ma_nguoi_dung")
    )
    private List<NguoiDung> danhSachNguoiDung;

    public Quyen() {
    }
}

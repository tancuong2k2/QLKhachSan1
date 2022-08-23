/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author Lenovo
 */
public class LoaiPhong {
    String MaLP;
    int SoLuong;
    String TenLoai;
    double Gia;

    public LoaiPhong() {
    }

    public LoaiPhong(String MaLP, int SoLuong, String TenLoai, double Gia) {
        this.MaLP = MaLP;
        this.SoLuong = SoLuong;
        this.TenLoai = TenLoai;
        this.Gia = Gia;
    }

    public String getMaLP() {
        return MaLP;
    }

    public void setMaLP(String MaLP) {
        this.MaLP = MaLP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    
    
    
}

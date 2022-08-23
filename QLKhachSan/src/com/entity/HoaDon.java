/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class HoaDon {
    String MaHD;
    int SoNgayThue;
    Date NgayTra;
    double TongTien;
    String MaNV;
    String MaPKH;
    String TinhTrang;

    public HoaDon() {
    }

    public HoaDon(String MaHD, int SoNgayThue, Date NgayTra, double TongTien, String MaNV, String MaPKH, String TinhTrang) {
        this.MaHD = MaHD;
        this.SoNgayThue = SoNgayThue;
        this.NgayTra = NgayTra;
        this.TongTien = TongTien;
        this.MaNV = MaNV;
        this.MaPKH = MaPKH;
        this.TinhTrang = TinhTrang;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public int getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(int SoNgayThue) {
        this.SoNgayThue = SoNgayThue;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPKH() {
        return MaPKH;
    }

    public void setMaPKH(String MaPKH) {
        this.MaPKH = MaPKH;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

      public Object[] toObject(){
        return new Object[]{
            MaHD,SoNgayThue,NgayTra,TongTien,MaNV,MaPKH,TinhTrang
        };
    }
    
}

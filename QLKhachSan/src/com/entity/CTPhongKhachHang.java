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
public class CTPhongKhachHang {
    String MaPKH;
    int SoNguoi;
    double TongTien;
    String MaP  ;
    String MaKH  ;

    public CTPhongKhachHang(String MaPKH, int SoNguoi, double TongTien, String MaP, String MaKH, String MaSD) {
        this.MaPKH = MaPKH;
        this.SoNguoi = SoNguoi;
        this.TongTien = TongTien;
        this.MaP = MaP;
        this.MaKH = MaKH;
    }

    public CTPhongKhachHang() {
    }

    public String getMaPKH() {
        return MaPKH;
    }

    public void setMaPKH(String MaPKH) {
        this.MaPKH = MaPKH;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaP() {
        return MaP;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    
    
}

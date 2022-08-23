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
public class ChiTietSDDV {
    String MaSD;
    String MaDV;
    int SoLanSD;
    double TongTien;
    String MaPKH;

    public ChiTietSDDV() {
    }

    public ChiTietSDDV(String MaSD, String MaDV, int SoLanSD, double TongTien, String MaPKH) {
        this.MaSD = MaSD;
        this.MaDV = MaDV;
        this.SoLanSD = SoLanSD;
        this.TongTien = TongTien;
        this.MaPKH = MaPKH;
    }

    public String getMaSD() {
        return MaSD;
    }

    public void setMaSD(String MaSD) {
        this.MaSD = MaSD;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public int getSoLanSD() {
        return SoLanSD;
    }

    public void setSoLanSD(int SoLanSD) {
        this.SoLanSD = SoLanSD;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaPKH() {
        return MaPKH;
    }

    public void setMaPKH(String MaPKH) {
        this.MaPKH = MaPKH;
    }

   
    
}

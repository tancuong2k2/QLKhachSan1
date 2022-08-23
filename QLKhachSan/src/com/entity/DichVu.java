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
public class DichVu {
    String MaDV;
    String TenDV;
    double Gia; 

    public DichVu() {
    }

    public DichVu(String MaDV, String TenDV, double Gia) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.Gia = Gia;
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    
    
}

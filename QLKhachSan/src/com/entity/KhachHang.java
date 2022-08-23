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
public class KhachHang {
    String MaKH;
    String HoTen;
    String SDT;
    String Email;
    String CMND;
    boolean GioiTinh;

    public KhachHang() {
    }

    public KhachHang(String MaKH, String HoTen, String SDT, String Email, String CMND, boolean GioiTinh) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.SDT = SDT;
        this.Email = Email;
        this.CMND = CMND;
        this.GioiTinh = GioiTinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    
    @Override
    public String toString() {
        return MaKH;
    }
        public Object[] toObject(){
        return new Object[]{
            MaKH,HoTen,SDT,Email,CMND,GioiTinh
        };
    }
    
}

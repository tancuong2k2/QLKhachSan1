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
public class Phong {
    String MaP;
    String TenP;
    String TinhTrang;
    String MaLP;

    public Phong() {
    }

    public Phong(String MaP, String TenP, String TinhTrang, String MaLP) {
        this.MaP = MaP;
        this.TenP = TenP;
        this.TinhTrang = TinhTrang;
        this.MaLP = MaLP;
    }

    public String getMaP() {
        return MaP;
    }

    public void setMaP(String MaP) {
        this.MaP = MaP;
    }

    public String getTenP() {
        return TenP;
    }

    public void setTenP(String TenP) {
        this.TenP = TenP;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMaLP() {
        return MaLP;
    }

    public void setMaLP(String MaLP) {
        this.MaLP = MaLP;
    }

    @Override
    public String toString() {
        return MaP;
    }
    
    
    
}

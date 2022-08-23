/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.helper.jdbcHelper ;
import com.entity.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class KhachHangDAO extends InterDAO<KhachHang, String>{
    String INSERT_SQL = "INSERT INTO KhachHang(MaKH,HoTen,SDT,Email,CMND,GioiTinh) values(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang set Hoten = ? , SDT= ? , Email= ? , CMND= ? , GioiTinh = ? where MaKH = ?";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MaKH = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_KH";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_KH ?";
    
    
    @Override
    public void insert(KhachHang entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaKH(),entity.getHoTen(),entity.getSDT(),entity.getEmail(),entity.getCMND(),entity.isGioiTinh());
    }

    @Override
    public void update(KhachHang entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getHoTen(),entity.getSDT(),entity.getEmail(),entity.getCMND(),entity.isGioiTinh(),entity.getMaKH());
    }

    @Override
    public void delete(String entity) {
        jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MaKH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setCMND(rs.getString("CMND"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.LoaiPhong;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class LoaiPhongDAO extends InterDAO<LoaiPhong, String>{
    String INSERT_SQL = "INSERT INTO LoaiPhong(MaLP,SoLuong,TenLoai,Gia) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE LoaiPhong SET SoLuong = ? ,TenLoai = ? ,Gia= ? WHERE MaLP = ?";
    String DELETE_SQL = "DELETE FROM LoaiPhong WHERE MaLP = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_LP";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_LP ?";
    
    @Override
    public void insert(LoaiPhong entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaLP(),entity.getSoLuong(),entity.getTenLoai(),entity.getGia());
    }

    @Override
    public void update(LoaiPhong entity) {
                jdbcHelper.update(UPDATE_SQL,
                entity.getSoLuong(),
                entity.getTenLoai(),
                entity.getGia(),
                 entity.getMaLP()
        );
    }

    @Override
    public void delete(String entity) {
        jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<LoaiPhong> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiPhong selectById(String id) {
        List<LoaiPhong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
            List<LoaiPhong> list = new ArrayList<LoaiPhong>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                LoaiPhong entity = new LoaiPhong();
                entity.setMaLP(rs.getString("MaLP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setTenLoai(rs.getString("TenLoai"));
                entity.setGia(rs.getDouble("Gia"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }    }
    
}

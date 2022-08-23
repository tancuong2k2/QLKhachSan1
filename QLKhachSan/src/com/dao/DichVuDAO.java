/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.DichVu;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class DichVuDAO extends InterDAO<DichVu, String>{
    String INSERT_SQL = "INSERT INTO DichVu(MaDV,TenDV,Gia) VALUES (?,?,?)";
    String UPDATE_SQL = "UPDATE DichVu set TenDV = ? , Gia= ? where MaDV = ?";
    String DELETE_SQL = "DELETE FROM DichVu WHERE MaDV = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_DV";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_DV ?";

    @Override
    public void insert(DichVu entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaDV(),entity.getTenDV(),entity.getGia());
    }

    @Override
    public void update(DichVu entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getTenDV(),entity.getGia(),entity.getMaDV());
    }

    @Override
    public void delete(String entity) {
        jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<DichVu> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);  
    }

    @Override
    public DichVu selectById(String id) {
        List<DichVu> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);   
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
            List<DichVu> list = new ArrayList<DichVu>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                DichVu entity = new DichVu();
                entity.setMaDV(rs.getString("MaDV"));
                entity.setTenDV(rs.getString("TenDV"));
                entity.setGia(rs.getDouble("Gia"));            
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    } 
}
    


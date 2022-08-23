/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.ChiTietSDDV;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ChiTietSDDVDAO extends InterDAO<ChiTietSDDV, String>{
    String INSERT_SQL = "INSERT INTO ChiTietSDDV(MaSD,MaDV,SoLanSD,TongTien,MaPKH) VALUES (?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE ChiTietSDDV set MaDV =? , SoLanSD = ? , TongTien= ? ,MaPKH=? where MaSD = ?";
    String DELETE_SQL = "DELETE FROM Phong WHERE MaSD = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_CTSD";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_CTSD ?";

    @Override
    public void insert(ChiTietSDDV entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaSD(),entity.getMaDV(),entity.getSoLanSD(),entity.getTongTien());
    }

    @Override
    public void update(ChiTietSDDV entity) {
        jdbcHelper.update(INSERT_SQL,entity.getSoLanSD(),entity.getTongTien(),entity.getMaSD(),entity.getMaDV());
    }

    @Override
    public void delete(String entity) {
        jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<ChiTietSDDV> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL); 
    }

    @Override
    public ChiTietSDDV selectById(String id) {
       List<ChiTietSDDV> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);   
    }

    @Override
    protected List<ChiTietSDDV> selectBySql(String sql, Object... args) {
          List<ChiTietSDDV> list = new ArrayList<ChiTietSDDV>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                ChiTietSDDV entity = new ChiTietSDDV();
                entity.setMaSD(rs.getString("MaSD"));
                entity.setMaDV(rs.getString("MaDV"));
                entity.setSoLanSD(rs.getInt("SoLanSD"));
                entity.setTongTien(rs.getDouble("TongTien"));
                entity.setMaPKH(rs.getString("MaPKH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
    
}

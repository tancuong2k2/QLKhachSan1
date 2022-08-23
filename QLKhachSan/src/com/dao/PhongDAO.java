/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Phong;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PhongDAO extends InterDAO<Phong, String>{
    String INSERT_SQL = "INSERT INTO Phong(MaP,TenPhong,TinhTrang,MaLP) VALUES (?,?,?,?)";
    String UPDATE_SQL = "UPDATE Phong set TenPhong = ? , TinhTrang= ? , MaLP=? where MaP = ?";
    String DELETE_SQL = "DELETE FROM Phong WHERE MaP = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_P";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_P ?";
    
    @Override
    public void insert(Phong entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaP(),entity.getTenP(),entity.getTinhTrang(),entity.getMaLP());  
    }

    @Override
    public void update(Phong entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getTenP(),entity.getTinhTrang(),entity.getMaLP(),entity.getMaP()); 
    }

    @Override
    public void delete(String entity) {
       jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<Phong> selectAll() {
 return this.selectBySql(SELECT_ALL_SQL); 
    }

    @Override
    public Phong selectById(String id) {
               List<Phong> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);  
      
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
                    List<Phong> list = new ArrayList<Phong>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Phong entity = new Phong();
                entity.setMaP(rs.getString("MaP"));
                entity.setTenP(rs.getString("TenPhong"));
                entity.setTinhTrang(rs.getString("TinhTrang"));
                entity.setMaLP(rs.getString("MaLP"));            
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.CTPhongKhachHang;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ChiTietPhongDAO extends InterDAO<CTPhongKhachHang, String>{
    String INSERT_SQL = "INSERT INTO CTPhongKhachHang(MaPKH,SoNguoi,TongTien,MaP,MaKH) values(?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE CTPhongKhachHang set soNguoi = ? , TongTien= ? , MaP= ? , MaKH= ? where MaPKH = ?";
    String DELETE_SQL = "DELETE FROM CTPhongKhachHang WHERE MaPKH = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_PKH";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_PKH ?";
    
    @Override
    public void insert(CTPhongKhachHang entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaPKH(),entity.getSoNguoi(),entity.getTongTien(),entity.getMaP(),entity.getMaKH());
    }

    @Override
    public void update(CTPhongKhachHang entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getSoNguoi(),entity.getTongTien(),entity.getMaP(),entity.getMaKH(),entity.getMaPKH());
    }

    @Override
    public void delete(String entity) {
        jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<CTPhongKhachHang> selectAll() {
         return this.selectBySql(SELECT_ALL_SQL); 
    }

    @Override
    public CTPhongKhachHang selectById(String id) {
   List<CTPhongKhachHang> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    protected List<CTPhongKhachHang> selectBySql(String sql, Object... args) {
                List<CTPhongKhachHang> list = new ArrayList<CTPhongKhachHang>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                CTPhongKhachHang entity = new CTPhongKhachHang();
                entity.setMaPKH(rs.getString("MaPKH"));
                entity.setSoNguoi(rs.getInt("SoNguoi"));
                entity.setTongTien(rs.getDouble("TongTien"));
                entity.setMaP(rs.getString("MaP"));
                entity.setMaKH(rs.getString("MaKH"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
    
}

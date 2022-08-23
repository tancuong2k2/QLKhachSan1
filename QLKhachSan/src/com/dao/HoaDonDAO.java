/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.HoaDon;
import com.helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class HoaDonDAO extends InterDAO<HoaDon, String>{
    String INSERT_SQL = "INSERT INTO HoaDon(MaHD,SoNgayThue,NgayTra,TongTien,MaNV,MaPKH,TinhTrang) values(?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang set soNgayThue = ? , NgayTra= ? , TongTien= ? , MaNV= ? , MaPKH = ? , TinhTrang = ? where MaHH = ?";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MaHD = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_HD";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_HD ?";
    
    
    @Override
    public void insert(HoaDon entity) {
       jdbcHelper.update(INSERT_SQL,entity.getMaHD(),entity.getSoNgayThue(),entity.getNgayTra(),entity.getTongTien(),entity.getMaNV(),entity.getMaPKH(),entity.getTinhTrang());
    }

    @Override
    public void update(HoaDon entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getSoNgayThue(),entity.getNgayTra(),entity.getTongTien(),entity.getMaNV(),entity.getMaPKH(),entity.getTinhTrang(),entity.getMaHD());
    }

    @Override
    public void delete(String entity) {
       jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectById(String id) {
         List<HoaDon> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                HoaDon entity = new HoaDon();
                entity.setMaHD(rs.getString("MaHD"));
                entity.setSoNgayThue(rs.getInt("SoNgayThue"));
                entity.setNgayTra(rs.getDate("NgayTra"));
                entity.setTongTien(rs.getDouble("TongTien"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPKH(rs.getString("MaPKH"));
                entity.setTinhTrang(rs.getString("TinhTrang"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
    public List<Integer> selectYear(){
        String sql = "SELECT DISTINCT year(NgayTra) FROM HoaDon ORDER BY year(NgayTra) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public List<HoaDon> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Hoadon WHERE MaHD LIKE ?";
            return this.selectBySql(sql, "%"+keyword+"%");
         }
     
}

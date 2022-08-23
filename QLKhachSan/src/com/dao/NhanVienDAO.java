/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.helper.jdbcHelper ;
import com.entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class NhanVienDAO extends InterDAO<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO Nhanvien(MaNV,TenNV,MatKhau,VaiTro) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE Nhanvien SET TenNV = ? ,MatKhau = ? ,VaiTro= ? WHERE MaNV = ?";
    String DELETE_SQL = "DELETE FROM Nhanvien WHERE MaNV = ?";
    String SELECT_ALL_SQL = "EXEC SP_GETDATA_NV";
    String SELECT_BY_ID_SQL = "EXEC SP_Find_NV ?";

    @Override
    public void insert(NhanVien entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNV(),entity.getHoTen(),entity.getMatKhau(),entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        jdbcHelper.update(UPDATE_SQL,
                entity.getHoTen(),
                entity.getMatKhau(),
                entity.isVaiTro(),
                 entity.getMaNV()
        );
    }

    @Override
    public void delete(String entity) {
         jdbcHelper.update(DELETE_SQL, entity);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
       List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
 List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while (rs.next()) {                
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setHoTen(rs.getString("TenNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
    }
}

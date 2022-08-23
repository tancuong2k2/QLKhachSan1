/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import com.entity.NhanVien;

/**
 *
 * @author Lenovo
 */
public class Auth {
    public static NhanVien USER =null;

    public static void clear(){
        Auth.USER=null;
    }
    public static boolean isLogin(){
        return Auth.USER!=null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && USER.isVaiTro();
    }
}


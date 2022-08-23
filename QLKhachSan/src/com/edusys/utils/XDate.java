/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    
//chuuyển String sang Date
    /*
    @param date truyền vào date kiểu String
    @param pattern truyền vào kiểu
    return trả về date kiểu Date
    */
    public static Date toDate(String date,String...pattern){
        try {
            if(pattern.length>0)formater.applyPattern(pattern[0]);
            if(date==null)return XDate.now();
            return formater.parse(date);
        } catch (Exception ex) {
            throw new RuntimeException(ex); 
        }
    }
    public static String toString(Date date,String...pattern){
         if(pattern.length>0)formater.applyPattern(pattern[0]);
        if(date==null)date=XDate.now();
        return formater.format(date);
    }
        public static Date now() {
        return new Date();   //new Date lấy giờ hiện tại
    }

    public  static  Date addDays(Date date , long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return  date;
    }
}

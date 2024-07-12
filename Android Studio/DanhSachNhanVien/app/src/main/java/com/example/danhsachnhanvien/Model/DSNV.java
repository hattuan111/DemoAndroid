package com.example.danhsachnhanvien.Model;

import java.io.Serializable;

public class DSNV implements Serializable {
    private String ma, ten, dc;

    public DSNV() {
    }

    public DSNV(String ma, String ten, String dc) {
        this.ma = ma;
        this.ten = ten;
        this.dc = dc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }
}

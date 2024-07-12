package com.example.haanhtuan_21103100926;

import java.io.Serializable;

public class sinhvien implements Serializable {
    private String maSv, hoTen, queQuan, diem;

    public sinhvien() {
    }

    public sinhvien(String maSv, String hoTen, String queQuan, String diem) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.diem = diem;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}

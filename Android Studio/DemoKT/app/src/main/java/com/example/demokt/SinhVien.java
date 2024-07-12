package com.example.demokt;

import java.io.Serializable;

public class SinhVien{
    private String masv, hoten, quequan;
    private String diem;

    public SinhVien() {
    }

    public SinhVien(String masv, String hoten, String quequan, String diem) {
        this.masv = masv;
        this.hoten = hoten;
        this.quequan = quequan;
        this.diem = diem;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}

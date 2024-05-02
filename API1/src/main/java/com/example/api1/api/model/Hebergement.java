package com.example.api1.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hebergement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;
    private String hname;
    private String hadd;
    private double hprice;
    @OneToMany(mappedBy = "hebe")
    private List<CommentaireHebergement> CHebergement;
    public Hebergement() {
    }

    public Hebergement(int hid, String hname, String hadd, double hprice) {
        this.hid = hid;
        this.hname = hname;
        this.hadd = hadd;
        this.hprice = hprice;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public void setHadd(String hadd) {
        this.hadd = hadd;
    }

    public void setHprice(double hprice) {
        this.hprice = hprice;
    }

    public int getHid() {
        return hid;
    }

    public String getHname() {
        return hname;
    }

    public String getHadd() {
        return hadd;
    }

    public double getHprice() {
        return hprice;
    }
}

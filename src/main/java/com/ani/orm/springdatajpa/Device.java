package com.ani.orm.springdatajpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dvId;
    private String dvMan;
    private Date mfg;

    public Device() {
    }

    public Device(Long dvId, String dvMan, Date mfg) {
        this.dvId = dvId;
        this.dvMan = dvMan;
        this.mfg = mfg;
    }

    public Long getDvId() {
        return dvId;
    }

    public void setDvId(Long dvId) {
        this.dvId = dvId;
    }

    public String getDvMan() {
        return dvMan;
    }

    public void setDvMan(String dvMan) {
        this.dvMan = dvMan;
    }

    public Date getMfg() {
        return mfg;
    }

    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    @Override
    public String toString() {
        return "Device{" +
                "dvId=" + dvId +
                ", dvMan='" + dvMan + '\'' +
                ", mfg=" + mfg +
                '}';
    }
}

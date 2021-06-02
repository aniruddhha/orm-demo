package com.ani.orm.javaconfig;

import javax.persistence.*;

@Entity
@Table(name = "tab_tablet")
public class Tablet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tabId;

    @Column(name = "tab_os", unique = true)
    private String os;

    @Column(name = "tab_vre")
    private String ver;

    public Tablet() {
    }

    public Tablet(Long tabId, String os, String ver) {
        this.tabId = tabId;
        this.os = os;
        this.ver = ver;
    }

    public Long getTabId() {
        return tabId;
    }

    public void setTabId(Long tabId) {
        this.tabId = tabId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}

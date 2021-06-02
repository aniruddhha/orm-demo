package com.ani.orm.xmlconfig;

public class Mobile {

    private Long mbId;
    private String mbNum;
    private Integer version;

    public Mobile() {
    }

    public Mobile(Long mbId, String mbNum, Integer version) {
        this.mbId = mbId;
        this.mbNum = mbNum;
        this.version = version;
    }

    public Long getMbId() {
        return mbId;
    }

    public void setMbId(Long mbId) {
        this.mbId = mbId;
    }

    public String getMbNum() {
        return mbNum;
    }

    public void setMbNum(String mbNum) {
        this.mbNum = mbNum;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "mbId=" + mbId +
                ", mbNum='" + mbNum + '\'' +
                ", version=" + version +
                '}';
    }
}

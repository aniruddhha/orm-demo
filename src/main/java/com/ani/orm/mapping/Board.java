package com.ani.orm.mapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brdId;
    private String mfg;
    private LocalDate mfgDt;

    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL)
    private Processor processor;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Chip> chips = new ArrayList<>();

    public Long getBrdId() {
        return brdId;
    }

    public void setBrdId(Long brdId) {
        this.brdId = brdId;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
    }

    public LocalDate getMfgDt() {
        return mfgDt;
    }

    public void setMfgDt(LocalDate mfgDt) {
        this.mfgDt = mfgDt;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void setChips(List<Chip> chips) {
        this.chips = chips;
    }

    @Override
    public String toString() {
        return "Board{" +
                "brdId=" + brdId +
                ", mfg='" + mfg + '\'' +
                ", mfgDt=" + mfgDt +
                '}';
    }
}

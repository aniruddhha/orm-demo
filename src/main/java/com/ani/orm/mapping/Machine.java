package com.ani.orm.mapping;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcId;
    private String mfg;
    private LocalDate mfgDt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vm_processors",
            joinColumns = @JoinColumn(name = "mcId"),
            inverseJoinColumns = @JoinColumn(name = "prcId")
    )
    private Set<Processor> processors = new HashSet<>();

    public Long getMcId() {
        return mcId;
    }

    public void setMcId(Long mcId) {
        this.mcId = mcId;
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

    public Set<Processor> getProcessors() {
        return processors;
    }

    public void setProcessors(Set<Processor> processors) {
        this.processors = processors;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "mcId=" + mcId +
                ", mfg='" + mfg + '\'' +
                ", mfgDt=" + mfgDt +
                '}';
    }
}

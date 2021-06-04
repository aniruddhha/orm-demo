package com.ani.orm.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bkId;

    private String name;
    private String isbn;
    private Integer pageCount;
    private LocalDate pbDt;

    public Long getBkId() {
        return bkId;
    }

    public void setBkId(Long bkId) {
        this.bkId = bkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public LocalDate getPbDt() {
        return pbDt;
    }

    public void setPbDt(LocalDate pbDt) {
        this.pbDt = pbDt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bkId=" + bkId +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pageCount=" + pageCount +
                ", pbDt=" + pbDt +
                '}';
    }
}

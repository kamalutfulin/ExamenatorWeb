package com.example.spring.dao;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "result", schema = "public", catalog = "examen")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int points;
    private Date dateTest;


    public ResultEntity(int points, Date dateTest) {
        this.points = points;
        this.dateTest = dateTest;
    }


    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultEntity that = (ResultEntity) o;
        return id == that.id && points == that.points && Objects.equals(dateTest, that.dateTest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, dateTest);
    }

}

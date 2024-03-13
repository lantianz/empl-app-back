package com.ltz.emplInfo.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-09
 */
@TableName("empl_info")
public class EmplInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String studentId;

    private String companyName;

    private String companyType;

    private String companyProvince;

    private String companyCity;

    private LocalDate signDate;

    private String postgraduate;

    private String emplOntime;

    private String emplWithintwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public String getPostgraduate() {
        return postgraduate;
    }

    public void setPostgraduate(String postgraduate) {
        this.postgraduate = postgraduate;
    }

    public String getEmplOntime() {
        return emplOntime;
    }

    public void setEmplOntime(String emplOntime) {
        this.emplOntime = emplOntime;
    }

    public String getEmplWithintwo() {
        return emplWithintwo;
    }

    public void setEmplWithintwo(String emplWithintwo) {
        this.emplWithintwo = emplWithintwo;
    }

    @Override
    public String toString() {
        return "EmplInfo{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyType='" + companyType + '\'' +
                ", companyProvince='" + companyProvince + '\'' +
                ", companyCity='" + companyCity + '\'' +
                ", signDate=" + signDate +
                ", postgraduate=" + postgraduate +
                ", emplOntime=" + emplOntime +
                ", emplWithintwo=" + emplWithintwo +
                '}';
    }
}

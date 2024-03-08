package com.ltz.emplInfo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-07
 */
@TableName("empl_info")
public class EmplInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private String signedUnitName;

    private String signedUnitCategory;

    private String signedUnitLocation;

    private LocalDate signingDate;

    private Boolean isPursuingGraduateStudy;

    private Boolean isEmployedOnTime;

    private Boolean isEmployedWithinTwoYears;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSignedUnitName() {
        return signedUnitName;
    }

    public void setSignedUnitName(String signedUnitName) {
        this.signedUnitName = signedUnitName;
    }

    public String getSignedUnitCategory() {
        return signedUnitCategory;
    }

    public void setSignedUnitCategory(String signedUnitCategory) {
        this.signedUnitCategory = signedUnitCategory;
    }

    public String getSignedUnitLocation() {
        return signedUnitLocation;
    }

    public void setSignedUnitLocation(String signedUnitLocation) {
        this.signedUnitLocation = signedUnitLocation;
    }

    public LocalDate getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(LocalDate signingDate) {
        this.signingDate = signingDate;
    }

    public Boolean getIsPursuingGraduateStudy() {
        return isPursuingGraduateStudy;
    }

    public void setIsPursuingGraduateStudy(Boolean isPursuingGraduateStudy) {
        this.isPursuingGraduateStudy = isPursuingGraduateStudy;
    }

    public Boolean getIsEmployedOnTime() {
        return isEmployedOnTime;
    }

    public void setIsEmployedOnTime(Boolean isEmployedOnTime) {
        this.isEmployedOnTime = isEmployedOnTime;
    }

    public Boolean getIsEmployedWithinTwoYears() {
        return isEmployedWithinTwoYears;
    }

    public void setIsEmployedWithinTwoYears(Boolean isEmployedWithinTwoYears) {
        this.isEmployedWithinTwoYears = isEmployedWithinTwoYears;
    }

    @Override
    public String toString() {
        return "EmplInfo{" +
            "studentId = " + studentId +
            ", signedUnitName = " + signedUnitName +
            ", signedUnitCategory = " + signedUnitCategory +
            ", signedUnitLocation = " + signedUnitLocation +
            ", signingDate = " + signingDate +
            ", isPursuingGraduateStudy = " + isPursuingGraduateStudy +
            ", isEmployedOnTime = " + isEmployedOnTime +
            ", isEmployedWithinTwoYears = " + isEmployedWithinTwoYears +
        "}";
    }
}

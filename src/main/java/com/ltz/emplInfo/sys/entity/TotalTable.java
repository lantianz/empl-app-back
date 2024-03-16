package com.ltz.emplInfo.sys.entity;

public class TotalTable {

    private String companyType;

    private String companyProvince;

    private String companyCity;

    private String departments;

    private  String majors;

    private String countOfGraduate;

    private String countOfOnTime;

    private String countOfEmployed;

    private String employmentOnTimeRate;  // 按时就业率

    private String employmentRate;  // 就业率

    private String countOfThisTypeEmpl; // 该类型该院系就业人数

    private String countOfAllTypeEmpl;  // 该类型全院系就业人数

    private String countOfThisPositionEmpl;  // 市 该院

    private String countOfAllPositionEmpl;  // 市 该院

    private String allInDeptRate;   // 该类型该院系 比上 对应全类型该院系, (该地区)

    private String allInAllDeptRate;   // 该类型全院系 比上 对应全类型全院系, (该地区)
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

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getCountOfGraduate() {
        return countOfGraduate;
    }

    public void setCountOfGraduate(String countOfGraduate) {
        this.countOfGraduate = countOfGraduate;
    }

    public String getCountOfOnTime() {
        return countOfOnTime;
    }

    public void setCountOfOnTime(String countOfOnTime) {
        this.countOfOnTime = countOfOnTime;
    }

    public String getCountOfEmployed() {
        return countOfEmployed;
    }

    public void setCountOfEmployed(String countOfEmployed) {
        this.countOfEmployed = countOfEmployed;
    }

    public String getEmploymentOnTimeRate() {
        return employmentOnTimeRate;
    }

    public void setEmploymentOnTimeRate(String employmentOnTimeRate) {
        this.employmentOnTimeRate = employmentOnTimeRate;
    }

    public String getEmploymentRate() {
        return employmentRate;
    }

    public void setEmploymentRate(String employmentRate) {
        this.employmentRate = employmentRate;
    }

    public String getCountOfThisTypeEmpl() {
        return countOfThisTypeEmpl;
    }

    public void setCountOfThisTypeEmpl(String countOfThisTypeEmpl) {
        this.countOfThisTypeEmpl = countOfThisTypeEmpl;
    }

    public String getCountOfAllTypeEmpl() {
        return countOfAllTypeEmpl;
    }

    public void setCountOfAllTypeEmpl(String countOfAllTypeEmpl) {
        this.countOfAllTypeEmpl = countOfAllTypeEmpl;
    }

    public String getCountOfThisPositionEmpl() {
        return countOfThisPositionEmpl;
    }

    public void setCountOfThisPositionEmpl(String countOfThisPositionEmpl) {
        this.countOfThisPositionEmpl = countOfThisPositionEmpl;
    }

    public String getCountOfAllPositionEmpl() {
        return countOfAllPositionEmpl;
    }

    public void setCountOfAllPositionEmpl(String countOfAllPositionEmpl) {
        this.countOfAllPositionEmpl = countOfAllPositionEmpl;
    }

    public String getAllInDeptRate() {
        return allInDeptRate;
    }

    public void setAllInDeptRate(String allInDeptRate) {
        this.allInDeptRate = allInDeptRate;
    }

    public String getAllInAllDeptRate() {
        return allInAllDeptRate;
    }

    public void setAllInAllDeptRate(String allInAllDeptRate) {
        this.allInAllDeptRate = allInAllDeptRate;
    }
}

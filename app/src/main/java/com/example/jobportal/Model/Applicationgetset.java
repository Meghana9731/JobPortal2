package com.example.jobportal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Applicationgetset {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("company_name")
    private String company;

    @Expose
    @SerializedName("mob_number")
    private String mob;

    @Expose
    @SerializedName("address")
    private String adds;

    @Expose
    @SerializedName("bod")
    private String dob;

    @Expose
    @SerializedName("education")
    private String edu;

    @Expose
    @SerializedName("gender")
    private String gen;

    @Expose
    @SerializedName("sub_categories")
    private String cat;

    @Expose
    @SerializedName("experience")
    private String exp;

    @Expose
    @SerializedName("expect_salary")
    private String salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

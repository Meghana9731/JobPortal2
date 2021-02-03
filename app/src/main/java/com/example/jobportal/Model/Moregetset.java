package com.example.jobportal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class Moregetset {


    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("company_name")
    private String company;

    @Expose
    @SerializedName("nature_business")
    private String natb;

    @Expose
    @SerializedName("address")
    private String adds;

    @Expose
    @SerializedName("mobile")
    private String mob;

    @Expose
    @SerializedName("contact_person")
    private String contperson;

    @Expose
    @SerializedName("post_of_M_F")
    private String post;

    @Expose
    @SerializedName("no_of_post_M_F")
    private String nopost;

    @Expose
    @SerializedName("job_timing")
    private String jobtime;

    @Expose
    @SerializedName("salary")
    private String sal;

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

    public String getNatb() {
        return natb;
    }

    public void setNatb(String natb) {
        this.natb = natb;
    }

    public String getAdds() {
        return adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getContperson() {
        return contperson;
    }

    public void setContperson(String contperson) {
        this.contperson = contperson;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNopost() {
        return nopost;
    }

    public void setNopost(String nopost) {
        this.nopost = nopost;
    }

    public String getJobtime() {
        return jobtime;
    }

    public void setJobtime(String jobtime) {
        this.jobtime = jobtime;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }
}

package com.example.jobportal.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tradersgetset {
    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("company_name")
    private String company;

    @Expose
    @SerializedName("nature_business")
    private String busnss;

    @Expose
    @SerializedName("address")
    private String adds;

    @Expose
    @SerializedName("mob_no")
    private String mob;

    @Expose
    @SerializedName("land_no")
    private String land;

    @Expose
    @SerializedName("email")
    private String ema;

    @Expose
    @SerializedName("no_of_vac")
    private String nov;

    @Expose
    @SerializedName("job_type")
    private String jt;

    @Expose
    @SerializedName("time")
    private String tm;

    @Expose
    @SerializedName("salary")
    private String sar;

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

    public String getBusnss() {
        return busnss;
    }

    public void setBusnss(String busnss) {
        this.busnss = busnss;
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

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getEma() {
        return ema;
    }

    public void setEma(String ema) {
        this.ema = ema;
    }

    public String getNov() {
        return nov;
    }

    public void setNov(String nov) {
        this.nov = nov;
    }

    public String getJt() {
        return jt;
    }

    public void setJt(String jt) {
        this.jt = jt;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getSar() {
        return sar;
    }

    public void setSar(String sar) {
        this.sar = sar;
    }
}

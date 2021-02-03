package com.example.jobportal.Model;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {




    @GET("recruitments.php")
    Call<List<Recruitmentgetset>>getrecruitments();


    @FormUrlEncoded
    @POST("recruitments.php")
    Call<Recruitmentgetset> recruitmentsdata(
            @Field("id") int id,
            @Field("company_name") String company,
            @Field("nature_of_business") String busnss,
            @Field("address") String adds,
            @Field("contact") String mob,
            @Field("telephone_number") String land,
            @Field("email") String ema,
            @Field("total_vacancy") String nov,
            @Field("job_type") String jt,
            @Field("job_time") String tm,
            @Field("salary") String sar);

//
//    @GET("others.php")
//    Call<List<Othersgetset>>getother();
//
//
//    @FormUrlEncoded
//    @POST("others.php")
//    Call<Othersgetset> otherdata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("nature_business") String busnss,
//            @Field("address") String adds,
//            @Field("mob_no") String mob,
//            @Field("land_no") String land,
//            @Field("email") String ema,
//            @Field("no_of_vac") String nov,
//            @Field("job_type") String jt,
//            @Field("time") String tm,
//            @Field("salary") String sar);
//
//
//
//    @GET("service.php")
//    Call<List<Servicegetset>>getservice();
//
//
//    @FormUrlEncoded
//    @POST("service.php")
//    Call<Servicegetset> servicedata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("nature_business") String busnss,
//            @Field("address") String adds,
//            @Field("mob_no") String mob,
//            @Field("land_no") String land,
//            @Field("email") String ema,
//            @Field("no_of_vac") String nov,
//            @Field("job_type") String jt,
//            @Field("time") String tm,
//            @Field("salary") String sar);
//
//    @GET("traders.php")
//    Call<List<Tradersgetset>>gettraders();
//
//
//    @FormUrlEncoded
//    @POST("traders.php")
//    Call<Tradersgetset> tradersdata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("nature_business") String busnss,
//            @Field("address") String adds,
//            @Field("mob_no") String mob,
//            @Field("land_no") String land,
//            @Field("email") String ema,
//            @Field("no_of_vac") String nov,
//            @Field("job_type") String jt,
//            @Field("time") String tm,
//            @Field("salary") String sar);
//
//    @GET("consultancy.php")
//    Call<List<Consultancygetset>>getconsultancy();
//
//
//    @FormUrlEncoded
//    @POST("consultancy.php")
//    Call<Consultancygetset> consultancydata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("nature_business") String busnss,
//            @Field("address") String adds,
//            @Field("mob_no") String mob,
//            @Field("land_no") String land,
//            @Field("email") String ema,
//            @Field("no_of_vac") String nov,
//            @Field("job_type") String jt,
//            @Field("time") String tm,
//            @Field("salary") String sar);
//
//
//    @GET("jobapplication.php")
//    Call<List<Consultancygetset>>getjobapplication();
//
//
//    @FormUrlEncoded
//    @POST("jobapplication.php")
//    Call<Consultancygetset> jobapplicationdata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("mob_number") String mob,
//            @Field("address") String adds,
//            @Field("bod") String dob,
//            @Field("education") String edu,
//            @Field("gender") String gen,
//            @Field("sub_categories") String cat,
//            @Field("experience") String exp,
//            @Field("expect_salary") String salary);
//
//    @GET("insert.php")
//    Call<List<Moregetset>>getmore();
//
//
//    @FormUrlEncoded
//    @POST("insert.php")
//    Call<Moregetset> moredata(
//            @Field("id") int id,
//            @Field("company_name") String company,
//            @Field("nature_business") String natb,
//            @Field("address") String adds,
//            @Field("mobile") String mob,
//            @Field("contact_person") String contperson,
//            @Field("post_of_M_F") String post,
//            @Field("no_of_post_M_F") String nopost,
//            @Field("job_timing") String jobtime,
//            @Field("salary") String sal);


}
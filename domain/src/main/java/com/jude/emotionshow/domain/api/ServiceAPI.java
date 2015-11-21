package com.jude.emotionshow.domain.api;


import com.jude.emotionshow.domain.entities.Account;
import com.jude.emotionshow.domain.entities.Banner;
import com.jude.emotionshow.domain.entities.Category;
import com.jude.emotionshow.domain.entities.PersonDetail;
import com.jude.emotionshow.domain.entities.SeedDetail;
import com.jude.emotionshow.domain.entities.Token;
import com.jude.emotionshow.domain.entities.Topic;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by Mr.Jude on 2015/11/18.
 */
public interface ServiceAPI {
    String SERVER_ADDRESS = "http://114.215.86.90/meme.php";

    @GET("/home/discover/getBanner")
    Observable<List<Banner>> getBanner();

    @GET("/home/discover/index")
    Observable<List<Topic>> getTopic();

    @GET("/home/discover/ltagIndex")
    Observable<List<Category>> getProcess();

    @GET("/home/discover/ctagIndex")
    Observable<List<Category>> getScence();

    @FormUrlEncoded
    @POST("/home/user/login")
    Observable<Account> login(
            @Field("tel") String tel,
            @Field("password") String password,
            @Field("type") String type);

    @FormUrlEncoded
    @POST("/home/user/registerForA")
    Observable<Object> register(
            @Field("tel") String tel,
            @Field("code") String code,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("/home/user/checkTel")
    Observable<Object> checkTel(
            @Field("tel") String tel);

    @FormUrlEncoded
    @POST("/home/user/bindTel")
    Observable<Object> bindTel(
            @Field("tel") String tel,
            @Field("code") String code);

    @FormUrlEncoded
    @POST("/home/user/modPass")
    Observable<Object> modPass(
            @Field("oldpwd") String oldPwd,
            @Field("newpwd") String newPwd);

    @FormUrlEncoded
    @POST("/home/user/modIntro")
    Observable<Object> modIntro(
            @Field("intro") String intro);

    @FormUrlEncoded
    @POST("/home/user/getUserinfo")
    Observable<PersonDetail> getUserinfo(
            @Field("id") String id);

    @FormUrlEncoded
    @POST("/home/index/feedback")
    Observable<Object> feedback(
            @Field("content") String content);

    @GET("/home/user/myAttend")
    Observable<Object> myAttend();

    @GET("/home/user/getMyinfo")
    Observable<Account> getMyInfo();

    @FormUrlEncoded
    @POST("/home/user/modInfo")
    Observable<Object> modifyInfo(
            @Field("gender") int gender,
            @Field("address") String address,
            @Field("face") String face,
            @Field("name") String name,
            @Field("sign") String sign,
            @Field("intro") String intro,
            @Field("bg") String bg
    );


    @FormUrlEncoded
    @POST("/home/user/attend")
    Observable<Object> attend(
            @Field("id") String id);

    @FormUrlEncoded
    @POST("/home/history/add")
    Observable<Object> addSeed(
            @Field("content") String content,
            @Field("ctag") String scene,
            @Field("ltag") String process,
            @Field("address") String address,
            @Field("rights") int scope,
            @Field("tag") String tag,
            @Field("pics") String pics
            );

    @GET("/home/index/qiniuToken")
    Observable<Token> qiniuToken();

    @FormUrlEncoded
    @POST("/home/user/address")
    Observable<Object> uploadAddress(
            @Field("lat") double lat,
            @Field("lng") double lng);

    @FormUrlEncoded
    @POST("/home/history/item")
    Observable<SeedDetail> getSeedDetail(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("/home/history/comment")
    Observable<Object> comment(
            @Field("hid") int seedId,
            @Field("fid") int commentId,
            @Field("content") String content
    );

    @FormUrlEncoded
    @POST("/home/history/zan")
    Observable<SeedDetail> praiseSeed(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("/home/history/collect")
    Observable<Object> collect(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("/home/index/jubao")
    Observable<Object> report(
            @Field("hid") int hid
    );
}

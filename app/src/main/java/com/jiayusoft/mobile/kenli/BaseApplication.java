package com.jiayusoft.mobile.kenli;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiayusoft.mobile.kenli.utils.GlobalData;
import com.jiayusoft.mobile.kenli.utils.database.DaoMaster;
import com.jiayusoft.mobile.kenli.utils.database.DaoSession;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by ASUS on 2014/7/1.
 */
public class BaseApplication extends Application implements GlobalData {
    private static final String DB_NAME = "green.db";
    private static BaseApplication mInstance;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;


    public static BaseApplication getInstance() {
        return mInstance;
    }

//    public static UserDoctor getCurrentUser() {
//        if (currentUserDoctor == null){
//            currentUserDoctor = new UserDoctor();
//        }
//        return currentUserDoctor;
//    }
//
//    public static void setCurrentUser(UserDoctor currentUserDoctor) {
//        BaseApplication.currentUserDoctor = currentUserDoctor;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(mInstance == null)
            mInstance = this;
    }

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    private static OkHttpClient okHttpClient;
    public static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            okHttpClient = new OkHttpClient();
        }
        return okHttpClient;
    }

    public static void loadImage(Context context, ImageView imageView, String url, int loadingRes, int errorRes){
        try {
            if (context instanceof Activity){
                Glide.with((Activity)context)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(loadingRes)
                        .error(errorRes)
                        .into(imageView);
            }else {
                Glide.with(context)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(loadingRes)
                        .error(errorRes)
                        .into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
            imageView.setImageResource(errorRes);
        }
    }

    public static void loadImage(Context context,ImageView imageView,String url,int errorRes){
        try {
            if (context instanceof Activity){
                Glide.with((Activity) context)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .error(errorRes)
                        .into(imageView);
            }else {
                Glide.with(context)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .error(errorRes)
                        .into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
            imageView.setImageResource(errorRes);
        }
    }
}

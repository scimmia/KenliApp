package com.jiayusoft.mobile.kenli.utils.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.devspark.appmsg.AppMsg;
import com.jiayusoft.mobile.kenli.BaseApplication;
import com.jiayusoft.mobile.kenli.R;
import com.jiayusoft.mobile.kenli.utils.GlobalData;
import com.jiayusoft.mobile.kenli.utils.eventbus.BusProvider;
import com.jiayusoft.mobile.kenli.utils.eventbus.event.MessageEvent;
import com.squareup.otto.Subscribe;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by ASUS on 2014/11/14.
 */
public abstract class BaseActivity extends AppCompatActivity implements GlobalData {
    Activity mBaseActivity;
    public Activity getBaseActivity(){
        return mBaseActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        ButterKnife.bind(this);
        mBaseActivity = BaseActivity.this;
//        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
//        getActionBar().setDisplayShowHomeEnabled(true);
//        String logoColor = BaseApplication.getCurrentUser().getLogoColor();
//        if (StringUtils.isNotEmpty(logoColor)){
//            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(logoColor)));
//        }
    }

    protected abstract void initContentView();
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    protected Object showMessageListener;
    @Override
    public void onResume() {
        super.onResume();

        // Register ourselves so that we can provide the initial value.
        BusProvider.getInstance().register(this);
        showMessageListener = new Object() {
            @Subscribe
            public void showMessage(final MessageEvent event) {
                BaseActivity.this.showMessage(event);
            }
        };
        BusProvider.getInstance().register(showMessageListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        cancelMessage();
        cancelProgress();
        // Always unregister when an object no longer should be on the bus.
        BusProvider.getInstance().unregister(this);
        BusProvider.getInstance().unregister(showMessageListener);
    }


    private AppMsg appMsg;
    public void showMessage(MessageEvent event){
        switch (event.getMessageType()){
            case MessageEvent.STYLE_ALERT:
                showMessage(event.getMessage(),AppMsg.STYLE_ALERT);
                break;
            case MessageEvent.STYLE_CONFIRM:
                showMessage(event.getMessage(),AppMsg.STYLE_CONFIRM);
                break;
            case MessageEvent.STYLE_INFO:
                showMessage(event.getMessage(),AppMsg.STYLE_INFO);
                break;
        }
    }

    public void showMessage(String message){
        showMessage(message,AppMsg.STYLE_INFO);
    }
    public void showMessage(String message, AppMsg.Style style){
        cancelMessage();
        appMsg = AppMsg.makeText(getBaseActivity(), message, style);
        appMsg.setAnimation(android.R.anim.fade_in, android.R.anim.fade_out);
        appMsg.show();

    }
    public void cancelMessage(){
        if (appMsg!=null && appMsg.isShowing()){
            appMsg.cancel();
        }
    }

    public ProgressDialog mProgressDialog;
    /**
     * Shows the progress UI and hides the login form.
     */
    public void showProgress(String message) {
        cancelMessage();
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getBaseActivity(), ProgressDialog.THEME_HOLO_LIGHT);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }
    public void cancelProgress(){
        if (mProgressDialog!=null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }


    public void beginActivity(Class<?> launche){
        beginActivity(launche,null);
    }
    public void beginActivity(Class<?> launche, Bundle bundle){
        Intent intent = new Intent( getBaseActivity(), launche);
        if (bundle!=null){
            intent.putExtras(bundle);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(intent);
    }
}

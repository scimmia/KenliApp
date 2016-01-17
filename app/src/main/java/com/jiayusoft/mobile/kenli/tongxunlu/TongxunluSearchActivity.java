package com.jiayusoft.mobile.kenli.tongxunlu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import com.jiayusoft.mobile.kenli.R;
import com.jiayusoft.mobile.kenli.utils.DebugLog;
import com.jiayusoft.mobile.kenli.utils.app.BaseActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

public class TongxunluSearchActivity extends BaseActivity {

    @Bind(R.id.quxian)
    MaterialEditText quxian;
    @Bind(R.id.jiedaoxiangzhen)
    MaterialEditText jiedaoxiangzhen;
    @Bind(R.id.shequ)
    MaterialEditText shequ;
    @Bind(R.id.xingming)
    MaterialEditText xingming;
    @Bind(R.id.shenfenzheng)
    MaterialEditText shenfenzheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_tongxunlu_search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tongxunlu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            beginActivity(TongxunluResultActivity.class);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnFocusChange({R.id.quxian,R.id.jiedaoxiangzhen,R.id.shequ})
    void OnSignleFocusChange(MaterialEditText materialEditText,boolean focused) {
        DebugLog.e("OnSignleFocusChange"+materialEditText.getHint());
        if (focused) {
            OnSingleClick(materialEditText);
        }
    }

    @OnClick({R.id.quxian,R.id.jiedaoxiangzhen,R.id.shequ})
    void OnSingleClick(MaterialEditText materialEditText) {
        DebugLog.e("OnSingleClick"+materialEditText.getHint());

        int maxBeforeDays = getResources().getInteger(R.integer.maxBeforeDays);
//        ChooseFromToDatesDialogFragment.newInstance(beginTime, endTime,maxBeforeDays).show(getFragmentManager(), "ChooseFromToDates");
    }
}

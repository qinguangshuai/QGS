package com.qgsstrive.qgs.activity.ceshi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qgsstrive.qgs.R;
import com.qgsstrive.qgs.base.activity.BaseActivity;
import com.qgsstrive.qgs.base.adapter.BaseRecyclerViewAdapter;
import com.qgsstrive.qgs.base.presenter.BasePresenter;
import com.qgsstrive.qgs.base.view.IBaseView;

public class CeShiActivity extends BaseActivity {

    private RecyclerView recycle;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public void initView() {
        recycle = findViewById(R.id.recycle);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getDatas();
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_ceshi;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    private void getDatas() {
        new CeShiPresenter(new IBaseView<CeShiUser>() {
            @Override
            public void onDataSuccess(final CeShiUser data) {
                /*MainApapter mainApapter = new MainApapter(getApplicationContext(),data.getResult());
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recycle.setLayoutManager(linearLayoutManager);*/
                //mainApapter.setDatas(data.getResult());

                if (data.getResult().size()>0){
                    CeShiAdapter mApapter = new CeShiAdapter(getApplicationContext(), R.layout.layout);
                    linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recycle.setLayoutManager(linearLayoutManager);

                    recycle.setAdapter(mApapter);
                    mApapter.setList(data.getResult());

                    mApapter.setmItemClick(new BaseRecyclerViewAdapter.ItemClick() {
                        @Override
                        public void setOnItemClick(View view, int position) {
                            Toast.makeText(CeShiActivity.this, data.getResult().get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //Toast.makeText(CeShiActivity.this, data.getTimestamp() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDataFailter(String msg) {
                Toast.makeText(CeShiActivity.this, msg, Toast.LENGTH_SHORT).show();

            }
        }).getData();
    }
}

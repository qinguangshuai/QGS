package com.qgsstrive.qgs.activity.ceshi;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.qgsstrive.qgs.R;
import com.qgsstrive.qgs.base.adapter.BaseRecyclerViewAdapter;

/**
 * @ClassName CeShiAdapter
 * @Description TODO
 * @Author QGS
 * @Date 2020/4/7 13:50
 */
public class CeShiAdapter extends BaseRecyclerViewAdapter<CeShiUser.ResultBean> {

    private TextView text;
    //private onClickInfo mOnClickInfo;

    /*public void setOnClickInfo(onClickInfo onClickInfo) {
        mOnClickInfo = onClickInfo;
    }*/

    public CeShiAdapter(Context mContext, int mLayout) {
        super(mContext, mLayout);
    }

    @Override
    public void onBindChildViewHolder(RecyclerView.ViewHolder viewHolder, int position, CeShiUser.ResultBean mItemData) {
        View itemView = viewHolder.itemView;
        getView(itemView);
        setData(mItemData);
    }

    private void getView(View itemView) {
        text = itemView.findViewById(R.id.text1);
    }

    private void setData(CeShiUser.ResultBean mItemData) {
        text.setText(mItemData.getName());
    }

    /*public interface onClickInfo{
        void click(View view,int i);
    }*/
}

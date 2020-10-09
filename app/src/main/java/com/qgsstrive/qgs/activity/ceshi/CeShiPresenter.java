package com.qgsstrive.qgs.activity.ceshi;

import com.qgsstrive.qgs.base.presenter.CommonPresenter;
import com.qgsstrive.qgs.base.view.IBaseView;
import com.qgsstrive.qgs.utils.ConstantUtil;

import java.util.HashMap;

/**
 * @ClassName CeShiPresenter
 * @Description TODO
 * @Author QGS
 * @Date 2020/4/7 13:46
 */
public class CeShiPresenter extends CommonPresenter<CeShiUser> {
    public CeShiPresenter(IBaseView<CeShiUser> mIView) {
        super(mIView);
    }

    public void getData(){
        HashMap<String, Object> hashMap = new HashMap<>();
        doGet(ConstantUtil.CESHI,hashMap,new CeShiUser());
    }
}

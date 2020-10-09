package com.qgsstrive.qgs.base.presenter;

import com.qgsstrive.qgs.base.view.IBaseView;
import com.qgsstrive.qgs.http.model.CommonModel;

public abstract  class BasePresenter<IView extends IBaseView,Model extends CommonModel> {

    private IView mIView;
    private Model mModel;

    public BasePresenter(IView mIView) {
        this.mIView = mIView;
    }

    protected Model getModel(){
        if (mModel==null) {
            mModel=initModel();
        }
        return mModel;
    }

    public IView getIView(){
        return mIView;
    }

    public void onDestory(){
        if (mIView!=null) {
            mIView=null;
        }
        if (mModel!=null) {
            mModel.onDstory();
        }
    }

    protected abstract Model initModel();

}

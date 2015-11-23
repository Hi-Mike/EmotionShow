package com.jude.emotionshow.presentation.seed;

import android.os.Bundle;

import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.jude.emotionshow.data.model.SeedModel;
import com.jude.emotionshow.data.server.ServiceResponse;
import com.jude.emotionshow.domain.entities.SeedDetail;
import com.jude.utils.JUtils;

import rx.Subscriber;

/**
 * Created by Mr.Jude on 2015/11/21.
 */
public class SeedDetailPresenter extends BeamDataActivityPresenter<SeedDetailActivity,SeedDetail> {
    private int id;
    @Override
    protected void onCreate(SeedDetailActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        id = getView().getIntent().getIntExtra("id",0);
        refresh();
    }

    private void refresh(){
        SeedModel.getInstance().getSeedDetail(id).unsafeSubscribe(new Subscriber<SeedDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SeedDetail seedDetail) {
                publishObject(seedDetail);
            }
        });
    }

    public void comment(int commentId,String content){
        getView().getExpansion().showProgressDialog("提交中");
        SeedModel.getInstance().comment(id, commentId, content)
                .finallyDo(() -> getView().getExpansion().dismissProgressDialog())
                .subscribe(new ServiceResponse<Object>() {
                    @Override
                    public void onNext(Object o) {
                        super.onNext(o);
                        JUtils.Toast("评论成功");
                        refresh();
                    }
                });
    }

    public void praise(){
        SeedModel.getInstance().praise(id).subscribe(new ServiceResponse<Object>() {
            @Override
            public void onNext(Object o) {
                JUtils.Toast("您赞了这条印记");
                refresh();
            }
        });
    }

    public void collect(){
        SeedModel.getInstance().collect(id).subscribe(new ServiceResponse<Object>(){
            @Override
            public void onNext(Object o) {
                JUtils.Toast("您收藏了这条印记");
            }
        });
    }
    public void report(){
        SeedModel.getInstance().report(id).subscribe(new ServiceResponse<Object>(){
            @Override
            public void onNext(Object o) {
                JUtils.Toast("举报成功");
            }
        });
    }
}

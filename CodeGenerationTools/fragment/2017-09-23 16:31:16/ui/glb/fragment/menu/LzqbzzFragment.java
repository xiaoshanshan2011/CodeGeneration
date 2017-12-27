package com.app.sanbao.ui.glb.fragment.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.app.sanbao.R;
import com.app.sanbao.contract.LzqbzzContract;
import com.app.sanbao.databinding.FgLzqbzzLayoutBinding;
import com.app.sanbao.net.BaseBean;
import com.app.sanbao.presenter.LzqbzzPresenter;
import com.app.sanbao.ui.BaseFragment;

/**
 * 流转钱包转账
 * Created by chenjunshan on 2017-09-23.
 */

public class LzqbzzFragment extends BaseFragment<FgLzqbzzLayoutBinding, Object> implements LzqbzzContract.View {
    private LzqbzzPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.fg_lzqbzz_layout;
    }

    @Override
    public void initTitleBar() {
        super.initTitleBar();

    }

    @Override
    public void initOnCreate(@Nullable Bundle savedInstanceState) {
        super.initOnCreate(savedInstanceState);
        presenter = new LzqbzzPresenter(getActivity(), this);

    }

    @Override
    protected void initEvent() {
        super.initEvent();

    }

    @Override
    public void onSuccess(BaseBean baseBean, int mTag) {

    }

    @Override
    public void onFailure(Throwable e, int mTag) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.cancelAllRequest();
    }
}

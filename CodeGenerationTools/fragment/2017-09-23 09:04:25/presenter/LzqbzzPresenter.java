package com.app.sanbao.presenter;

import android.content.Context;

import com.app.sanbao.contract.LzqbzzContract;
import com.app.sanbao.net.HttpRequest;

/**
 * 流转钱包转账
 * Created by chenjunshan on 2017-09-23.
 */

public class LzqbzzPresenter extends HttpRequest implements LzqbzzContract.Presenter {
    private Context context;
    private LzqbzzContract.View view;

    public LzqbzzPresenter(Context context, LzqbzzContract.View view) {
        this.context = context;
        this.view = view;
    }

}

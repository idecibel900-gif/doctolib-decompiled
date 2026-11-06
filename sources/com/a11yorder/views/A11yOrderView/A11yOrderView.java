package com.a11yorder.views.A11yOrderView;

import android.content.Context;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class A11yOrderView extends ReactViewGroup {
    private String orderKey;

    public A11yOrderView(Context context) {
        super(context);
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }
}

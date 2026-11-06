package com.a11yorder.views.A11yIndexView;

import android.content.Context;
import android.view.View;
import com.a11yorder.views.A11yIndexView.Linking.A11yOrderLinking;
import com.facebook.react.views.view.ReactViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class A11yIndexView extends ReactViewGroup {
    private View firstChild;
    private Integer index;
    private String orderKey;

    public A11yIndexView(Context context) {
        super(context);
    }

    public void setIndex(int i) {
        if (this.index == null) {
            this.index = Integer.valueOf(i);
            return;
        }
        this.index = Integer.valueOf(i);
        if (this.firstChild == null || this.orderKey == null) {
            return;
        }
        A11yOrderLinking.getInstance().refreshIndexes(this.firstChild, this.orderKey, i);
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    private void linkViews(boolean z) {
        if (this.firstChild != null && this.orderKey != null && this.index != null && !z) {
            A11yOrderLinking.getInstance().addViewRelationship(this.firstChild, this.orderKey, this.index.intValue());
        }
        if (!z || this.orderKey == null || this.index == null) {
            return;
        }
        A11yOrderLinking.getInstance().removeRelationship(this.orderKey, this.index.intValue());
    }

    public void linkAddView(View view) {
        if (this.firstChild == null) {
            this.firstChild = view;
            linkViews(false);
        }
    }

    public void linkRemoveView(View view) {
        if (view == this.firstChild) {
            this.firstChild = null;
            linkViews(true);
        }
    }
}

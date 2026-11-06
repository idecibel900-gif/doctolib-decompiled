package com.facebook.react.uimanager;

import android.graphics.Rect;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactClippingViewGroup {
    void getClippingRect(Rect rect);

    boolean getRemoveClippedSubviews();

    void updateClippingRect(Set set);
}

package com.facebook.react.views.scroll;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactHorizontalScrollContainerLegacyView extends ReactViewGroup {
    private final boolean isRTL;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactHorizontalScrollContainerLegacyView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isRTL = I18nUtil.Companion.getInstance().isRTL(context);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, com.facebook.react.uimanager.ReactClippingViewGroup
    public boolean getRemoveClippedSubviews() {
        return super.getRemoveClippedSubviews();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup
    public void setRemoveClippedSubviews(boolean z) {
        if (this.isRTL) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.isRTL) {
            setLeft(0);
            setTop(i2);
            setRight(i3 - i);
            setBottom(i4);
        }
    }
}

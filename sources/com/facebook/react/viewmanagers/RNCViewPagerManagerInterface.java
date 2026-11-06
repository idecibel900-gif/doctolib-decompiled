package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNCViewPagerManagerInterface extends ViewManagerWithGeneratedInterface {
    void setInitialPage(View view, int i);

    void setKeyboardDismissMode(View view, String str);

    void setLayoutDirection(View view, String str);

    void setOffscreenPageLimit(View view, int i);

    void setOrientation(View view, String str);

    void setOverScrollMode(View view, String str);

    void setOverdrag(View view, boolean z);

    void setPage(View view, int i);

    void setPageMargin(View view, int i);

    void setPageWithoutAnimation(View view, int i);

    void setScrollEnabled(View view, boolean z);

    void setScrollEnabledImperatively(View view, boolean z);
}

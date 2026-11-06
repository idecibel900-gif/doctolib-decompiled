package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSTabsHostManagerInterface extends ViewManagerWithGeneratedInterface {
    void setControlNavigationStateInJS(View view, boolean z);

    void setNativeContainerBackgroundColor(View view, Integer num);

    void setTabBarBackgroundColor(View view, Integer num);

    void setTabBarControllerMode(View view, String str);

    void setTabBarHidden(View view, boolean z);

    void setTabBarItemActiveIndicatorColor(View view, Integer num);

    void setTabBarItemActiveIndicatorEnabled(View view, boolean z);

    void setTabBarItemIconColor(View view, Integer num);

    void setTabBarItemIconColorActive(View view, Integer num);

    void setTabBarItemLabelVisibilityMode(View view, String str);

    void setTabBarItemRippleColor(View view, Integer num);

    void setTabBarItemTitleFontColor(View view, Integer num);

    void setTabBarItemTitleFontColorActive(View view, Integer num);

    void setTabBarItemTitleFontFamily(View view, String str);

    void setTabBarItemTitleFontSize(View view, float f);

    void setTabBarItemTitleFontSizeActive(View view, float f);

    void setTabBarItemTitleFontStyle(View view, String str);

    void setTabBarItemTitleFontWeight(View view, String str);

    void setTabBarMinimizeBehavior(View view, String str);

    void setTabBarTintColor(View view, Integer num);
}

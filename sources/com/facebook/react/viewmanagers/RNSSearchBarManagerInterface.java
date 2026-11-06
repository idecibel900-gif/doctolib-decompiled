package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSSearchBarManagerInterface extends ViewManagerWithGeneratedInterface {
    void blur(View view);

    void cancelSearch(View view);

    void clearText(View view);

    void focus(View view);

    void setAllowToolbarIntegration(View view, boolean z);

    void setAutoCapitalize(View view, String str);

    void setAutoFocus(View view, boolean z);

    void setBarTintColor(View view, Integer num);

    void setCancelButtonText(View view, String str);

    void setDisableBackButtonOverride(View view, boolean z);

    void setHeaderIconColor(View view, Integer num);

    void setHideNavigationBar(View view, String str);

    void setHideWhenScrolling(View view, boolean z);

    void setHintTextColor(View view, Integer num);

    void setInputType(View view, String str);

    void setObscureBackground(View view, String str);

    void setPlaceholder(View view, String str);

    void setPlacement(View view, String str);

    void setShouldShowHintSearchIcon(View view, boolean z);

    void setText(View view, String str);

    void setTextColor(View view, Integer num);

    void setTintColor(View view, Integer num);

    void toggleCancelButton(View view, boolean z);
}

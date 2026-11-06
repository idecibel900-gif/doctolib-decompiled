package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSVGSvgViewAndroidManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAccessible(View view, boolean z);

    void setAlign(View view, String str);

    void setBackfaceVisibility(View view, String str);

    void setBbHeight(View view, Dynamic dynamic);

    void setBbWidth(View view, Dynamic dynamic);

    void setBorderBlockColor(View view, Integer num);

    void setBorderBlockEndColor(View view, Integer num);

    void setBorderBlockStartColor(View view, Integer num);

    void setBorderBottomColor(View view, Integer num);

    void setBorderBottomEndRadius(View view, Dynamic dynamic);

    void setBorderBottomLeftRadius(View view, Dynamic dynamic);

    void setBorderBottomRightRadius(View view, Dynamic dynamic);

    void setBorderBottomStartRadius(View view, Dynamic dynamic);

    void setBorderColor(View view, Integer num);

    void setBorderEndColor(View view, Integer num);

    void setBorderEndEndRadius(View view, Dynamic dynamic);

    void setBorderEndStartRadius(View view, Dynamic dynamic);

    void setBorderLeftColor(View view, Integer num);

    void setBorderRadius(View view, Dynamic dynamic);

    void setBorderRightColor(View view, Integer num);

    void setBorderStartColor(View view, Integer num);

    void setBorderStartEndRadius(View view, Dynamic dynamic);

    void setBorderStartStartRadius(View view, Dynamic dynamic);

    void setBorderStyle(View view, String str);

    void setBorderTopColor(View view, Integer num);

    void setBorderTopEndRadius(View view, Dynamic dynamic);

    void setBorderTopLeftRadius(View view, Dynamic dynamic);

    void setBorderTopRightRadius(View view, Dynamic dynamic);

    void setBorderTopStartRadius(View view, Dynamic dynamic);

    void setColor(View view, Integer num);

    void setFocusable(View view, boolean z);

    void setHasTVPreferredFocus(View view, boolean z);

    void setHitSlop(View view, Dynamic dynamic);

    void setMeetOrSlice(View view, int i);

    void setMinX(View view, float f);

    void setMinY(View view, float f);

    void setNativeBackgroundAndroid(View view, ReadableMap readableMap);

    void setNativeForegroundAndroid(View view, ReadableMap readableMap);

    void setNeedsOffscreenAlphaCompositing(View view, boolean z);

    void setNextFocusDown(View view, int i);

    void setNextFocusForward(View view, int i);

    void setNextFocusLeft(View view, int i);

    void setNextFocusRight(View view, int i);

    void setNextFocusUp(View view, int i);

    void setPointerEvents(View view, String str);

    void setRemoveClippedSubviews(View view, boolean z);

    void setVbHeight(View view, float f);

    void setVbWidth(View view, float f);
}

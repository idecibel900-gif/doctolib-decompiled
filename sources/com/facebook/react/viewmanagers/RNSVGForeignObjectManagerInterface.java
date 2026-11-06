package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNSVGForeignObjectManagerInterface extends ViewManagerWithGeneratedInterface {
    void setClipPath(View view, String str);

    void setClipRule(View view, int i);

    void setColor(View view, Integer num);

    void setDisplay(View view, String str);

    void setFill(View view, Dynamic dynamic);

    void setFillOpacity(View view, float f);

    void setFillRule(View view, int i);

    void setFilter(View view, String str);

    void setFont(View view, Dynamic dynamic);

    void setFontSize(View view, Dynamic dynamic);

    void setFontWeight(View view, Dynamic dynamic);

    void setHeight(View view, Dynamic dynamic);

    void setMarkerEnd(View view, String str);

    void setMarkerMid(View view, String str);

    void setMarkerStart(View view, String str);

    void setMask(View view, String str);

    void setMatrix(View view, ReadableArray readableArray);

    void setName(View view, String str);

    void setPointerEvents(View view, String str);

    void setPropList(View view, ReadableArray readableArray);

    void setResponsible(View view, boolean z);

    void setStroke(View view, Dynamic dynamic);

    void setStrokeDasharray(View view, Dynamic dynamic);

    void setStrokeDashoffset(View view, float f);

    void setStrokeLinecap(View view, int i);

    void setStrokeLinejoin(View view, int i);

    void setStrokeMiterlimit(View view, float f);

    void setStrokeOpacity(View view, float f);

    void setStrokeWidth(View view, Dynamic dynamic);

    void setVectorEffect(View view, int i);

    void setWidth(View view, Dynamic dynamic);

    void setX(View view, Dynamic dynamic);

    void setY(View view, Dynamic dynamic);
}

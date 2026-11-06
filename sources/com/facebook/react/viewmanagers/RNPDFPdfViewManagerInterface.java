package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface RNPDFPdfViewManagerInterface extends ViewManagerWithGeneratedInterface {
    void setEnableAnnotationRendering(View view, boolean z);

    void setEnableAntialiasing(View view, boolean z);

    void setEnableDoubleTapZoom(View view, boolean z);

    void setEnablePaging(View view, boolean z);

    void setEnableRTL(View view, boolean z);

    void setFitPolicy(View view, int i);

    void setHorizontal(View view, boolean z);

    void setMaxScale(View view, float f);

    void setMinScale(View view, float f);

    void setNativePage(View view, int i);

    void setPage(View view, int i);

    void setPassword(View view, String str);

    void setPath(View view, String str);

    void setScale(View view, float f);

    void setScrollEnabled(View view, boolean z);

    void setShowsHorizontalScrollIndicator(View view, boolean z);

    void setShowsVerticalScrollIndicator(View view, boolean z);

    void setSinglePage(View view, boolean z);

    void setSpacing(View view, int i);
}

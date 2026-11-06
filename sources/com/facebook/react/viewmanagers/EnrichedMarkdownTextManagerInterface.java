package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface EnrichedMarkdownTextManagerInterface extends ViewManagerWithGeneratedInterface {
    void setAccessibilityLabels(View view, ReadableMap readableMap);

    void setAllowFontScaling(View view, boolean z);

    void setAllowTrailingMargin(View view, boolean z);

    void setContextMenuItems(View view, ReadableArray readableArray);

    void setEnableLinkPreview(View view, boolean z);

    void setEnableTaskListItemToggle(View view, boolean z);

    void setImageRequestHeaders(View view, ReadableArray readableArray);

    void setLineBreakStrategyIOS(View view, String str);

    void setMarkdown(View view, String str);

    void setMarkdownStyle(View view, ReadableMap readableMap);

    void setMaxFontSizeMultiplier(View view, float f);

    void setMd4cFlags(View view, ReadableMap readableMap);

    void setSelectable(View view, boolean z);

    void setSelectionColor(View view, Integer num);

    void setSelectionHandleColor(View view, Integer num);

    void setSelectionMenuConfig(View view, ReadableMap readableMap);

    void setSpoilerOverlay(View view, String str);

    void setStreamingAnimation(View view, boolean z);

    void setStreamingConfig(View view, ReadableMap readableMap);

    void setTextBreakStrategy(View view, String str);

    void setWritingDirection(View view, String str);
}

package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class EnrichedMarkdownManagerDelegate extends BaseViewManagerDelegate {
    public EnrichedMarkdownManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "streamingConfig":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setStreamingConfig(view, (ReadableMap) obj);
                break;
            case "selectable":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setSelectable(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "textBreakStrategy":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setTextBreakStrategy(view, obj == null ? "highQuality" : (String) obj);
                break;
            case "enableTaskListItemToggle":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setEnableTaskListItemToggle(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "enableLinkPreview":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setEnableLinkPreview(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "allowFontScaling":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setAllowFontScaling(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "contextMenuItems":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setContextMenuItems(view, (ReadableArray) obj);
                break;
            case "selectionHandleColor":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setSelectionHandleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "streamingAnimation":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setStreamingAnimation(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "markdown":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setMarkdown(view, obj == null ? null : (String) obj);
                break;
            case "allowTrailingMargin":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setAllowTrailingMargin(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "maxFontSizeMultiplier":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setMaxFontSizeMultiplier(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "md4cFlags":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setMd4cFlags(view, (ReadableMap) obj);
                break;
            case "spoilerOverlay":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setSpoilerOverlay(view, obj == null ? "particles" : (String) obj);
                break;
            case "markdownStyle":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setMarkdownStyle(view, (ReadableMap) obj);
                break;
            case "writingDirection":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setWritingDirection(view, obj == null ? "first-strong" : (String) obj);
                break;
            case "lineBreakStrategyIOS":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setLineBreakStrategyIOS(view, obj == null ? "none" : (String) obj);
                break;
            case "accessibilityLabels":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setAccessibilityLabels(view, (ReadableMap) obj);
                break;
            case "imageRequestHeaders":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setImageRequestHeaders(view, (ReadableArray) obj);
                break;
            case "selectionMenuConfig":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setSelectionMenuConfig(view, (ReadableMap) obj);
                break;
            case "selectionColor":
                ((EnrichedMarkdownManagerInterface) this.mViewManager).setSelectionColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}

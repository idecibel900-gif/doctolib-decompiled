package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class EnrichedMarkdownTextManagerDelegate extends BaseViewManagerDelegate {
    public EnrichedMarkdownTextManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        switch (str) {
            case "streamingConfig":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setStreamingConfig(view, (ReadableMap) obj);
                break;
            case "selectable":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setSelectable(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "textBreakStrategy":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setTextBreakStrategy(view, obj == null ? "highQuality" : (String) obj);
                break;
            case "enableTaskListItemToggle":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setEnableTaskListItemToggle(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "enableLinkPreview":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setEnableLinkPreview(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "allowFontScaling":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setAllowFontScaling(view, obj != null ? ((Boolean) obj).booleanValue() : true);
                break;
            case "contextMenuItems":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setContextMenuItems(view, (ReadableArray) obj);
                break;
            case "selectionHandleColor":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setSelectionHandleColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case "streamingAnimation":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setStreamingAnimation(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "markdown":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setMarkdown(view, obj == null ? null : (String) obj);
                break;
            case "allowTrailingMargin":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setAllowTrailingMargin(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case "maxFontSizeMultiplier":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setMaxFontSizeMultiplier(view, obj == null ? 0.0f : ((Double) obj).floatValue());
                break;
            case "md4cFlags":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setMd4cFlags(view, (ReadableMap) obj);
                break;
            case "spoilerOverlay":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setSpoilerOverlay(view, obj == null ? "particles" : (String) obj);
                break;
            case "markdownStyle":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setMarkdownStyle(view, (ReadableMap) obj);
                break;
            case "writingDirection":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setWritingDirection(view, obj == null ? "first-strong" : (String) obj);
                break;
            case "lineBreakStrategyIOS":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setLineBreakStrategyIOS(view, obj == null ? "none" : (String) obj);
                break;
            case "accessibilityLabels":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setAccessibilityLabels(view, (ReadableMap) obj);
                break;
            case "imageRequestHeaders":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setImageRequestHeaders(view, (ReadableArray) obj);
                break;
            case "selectionMenuConfig":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setSelectionMenuConfig(view, (ReadableMap) obj);
                break;
            case "selectionColor":
                ((EnrichedMarkdownTextManagerInterface) this.mViewManager).setSelectionColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }
}

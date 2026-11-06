package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class EnrichedMarkdownTextInputManagerDelegate extends BaseViewManagerDelegate {
    public EnrichedMarkdownTextInputManagerDelegate(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(View view, String str, Object obj) {
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1775748605:
                if (str.equals("placeholderTextColor")) {
                    b = 0;
                }
                break;
            case -1670034216:
                if (str.equals("formatMenuConfig")) {
                    b = 1;
                }
                break;
            case -1636746131:
                if (str.equals("linkRegex")) {
                    b = 2;
                }
                break;
            case -1595747923:
                if (str.equals("cursorColor")) {
                    b = 3;
                }
                break;
            case -1339545093:
                if (str.equals("autoCapitalize")) {
                    b = 4;
                }
                break;
            case -1224696685:
                if (str.equals("fontFamily")) {
                    b = 5;
                }
                break;
            case -1206239059:
                if (str.equals("multiline")) {
                    b = 6;
                }
                break;
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    b = 7;
                }
                break;
            case -1024843314:
                if (str.equals("mentionIndicators")) {
                    b = 8;
                }
                break;
            case -734428249:
                if (str.equals("fontWeight")) {
                    b = 9;
                }
                break;
            case -659125328:
                if (str.equals("defaultValue")) {
                    b = 10;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = 11;
                }
                break;
            case -217824078:
                if (str.equals("contextMenuItems")) {
                    b = 12;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    b = 13;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    b = 14;
                }
                break;
            case 598246771:
                if (str.equals("placeholder")) {
                    b = 15;
                }
                break;
            case 763620866:
                if (str.equals("markdownStyle")) {
                    b = 16;
                }
                break;
            case 938894714:
                if (str.equals("isOnChangeMarkdownSet")) {
                    b = 17;
                }
                break;
            case 1067083267:
                if (str.equals("writingDirection")) {
                    b = 18;
                }
                break;
            case 1602416228:
                if (str.equals("editable")) {
                    b = 19;
                }
                break;
            case 1638055017:
                if (str.equals("autoFocus")) {
                    b = 20;
                }
                break;
            case 1969655853:
                if (str.equals("selectionMenuConfig")) {
                    b = 21;
                }
                break;
            case 2142299447:
                if (str.equals("selectionColor")) {
                    b = 22;
                }
                break;
        }
        switch (b) {
            case 0:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setPlaceholderTextColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 1:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setFormatMenuConfig(view, (ReadableMap) obj);
                break;
            case 2:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setLinkRegex(view, (ReadableMap) obj);
                break;
            case 3:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setCursorColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 4:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setAutoCapitalize(view, obj != null ? (String) obj : null);
                break;
            case 5:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setFontFamily(view, obj != null ? (String) obj : null);
                break;
            case 6:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setMultiline(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 7:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setScrollEnabled(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 8:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setMentionIndicators(view, (ReadableArray) obj);
                break;
            case 9:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setFontWeight(view, obj != null ? (String) obj : null);
                break;
            case 10:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setDefaultValue(view, obj != null ? (String) obj : null);
                break;
            case BaseVideoCapturer.RGBA /* 11 */:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setLineHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setContextMenuItems(view, (ReadableArray) obj);
                break;
            case 13:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 14:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setFontSize(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setPlaceholder(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setMarkdownStyle(view, (ReadableMap) obj);
                break;
            case 17:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setIsOnChangeMarkdownSet(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 18:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setWritingDirection(view, obj == null ? "first-strong" : (String) obj);
                break;
            case 19:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setEditable(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 20:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setAutoFocus(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 21:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setSelectionMenuConfig(view, (ReadableMap) obj);
                break;
            case 22:
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setSelectionColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.setProperty(view, str, obj);
                break;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    /* JADX INFO: renamed from: receiveCommand */
    public void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray) {
        str.getClass();
        switch (str) {
            case "copyToClipboard":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).copyToClipboard(view);
                break;
            case "outdentList":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).outdentList(view);
                break;
            case "toggleStrikethrough":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleStrikethrough(view);
                break;
            case "requestCaretRect":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).requestCaretRect(view, readableArray.getInt(0));
                break;
            case "toggleUnorderedList":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleUnorderedList(view);
                break;
            case "requestMarkdown":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).requestMarkdown(view, readableArray.getInt(0));
                break;
            case "toggleHeading":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleHeading(view, readableArray.getInt(0));
                break;
            case "toggleBold":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleBold(view);
                break;
            case "toggleOrderedList":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleOrderedList(view);
                break;
            case "setSelection":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setSelection(view, readableArray.getInt(0), readableArray.getInt(1));
                break;
            case "blur":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).blur(view);
                break;
            case "focus":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).focus(view);
                break;
            case "toggleSpoiler":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleSpoiler(view);
                break;
            case "insertMention":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).insertMention(view, readableArray.getString(0), readableArray.getString(1));
                break;
            case "indentList":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).indentList(view);
                break;
            case "toggleUnderline":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleUnderline(view);
                break;
            case "startMention":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).startMention(view, readableArray.getString(0));
                break;
            case "toggleItalic":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).toggleItalic(view);
                break;
            case "insertLink":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).insertLink(view, readableArray.getString(0), readableArray.getString(1));
                break;
            case "insertText":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).insertText(view, readableArray.getString(0));
                break;
            case "removeLink":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).removeLink(view);
                break;
            case "setValue":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setValue(view, readableArray.getString(0));
                break;
            case "setLink":
                ((EnrichedMarkdownTextInputManagerInterface) this.mViewManager).setLink(view, readableArray.getString(0));
                break;
        }
    }
}

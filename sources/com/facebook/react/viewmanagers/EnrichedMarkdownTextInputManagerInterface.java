package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* JADX INFO: loaded from: classes3.dex */
public interface EnrichedMarkdownTextInputManagerInterface extends ViewManagerWithGeneratedInterface {
    void blur(View view);

    void copyToClipboard(View view);

    void focus(View view);

    void indentList(View view);

    void insertLink(View view, String str, String str2);

    void insertMention(View view, String str, String str2);

    void insertText(View view, String str);

    void outdentList(View view);

    void removeLink(View view);

    void requestCaretRect(View view, int i);

    void requestMarkdown(View view, int i);

    void setAutoCapitalize(View view, String str);

    void setAutoFocus(View view, boolean z);

    void setColor(View view, Integer num);

    void setContextMenuItems(View view, ReadableArray readableArray);

    void setCursorColor(View view, Integer num);

    void setDefaultValue(View view, String str);

    void setEditable(View view, boolean z);

    void setFontFamily(View view, String str);

    void setFontSize(View view, float f);

    void setFontWeight(View view, String str);

    void setFormatMenuConfig(View view, ReadableMap readableMap);

    void setIsOnChangeMarkdownSet(View view, boolean z);

    void setLineHeight(View view, float f);

    void setLink(View view, String str);

    void setLinkRegex(View view, ReadableMap readableMap);

    void setMarkdownStyle(View view, ReadableMap readableMap);

    void setMentionIndicators(View view, ReadableArray readableArray);

    void setMultiline(View view, boolean z);

    void setPlaceholder(View view, String str);

    void setPlaceholderTextColor(View view, Integer num);

    void setScrollEnabled(View view, boolean z);

    void setSelection(View view, int i, int i2);

    void setSelectionColor(View view, Integer num);

    void setSelectionMenuConfig(View view, ReadableMap readableMap);

    void setValue(View view, String str);

    void setWritingDirection(View view, String str);

    void startMention(View view, String str);

    void toggleBold(View view);

    void toggleHeading(View view, int i);

    void toggleItalic(View view);

    void toggleOrderedList(View view);

    void toggleSpoiler(View view);

    void toggleStrikethrough(View view);

    void toggleUnderline(View view);

    void toggleUnorderedList(View view);
}

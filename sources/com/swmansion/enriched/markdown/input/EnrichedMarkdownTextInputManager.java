package com.swmansion.enriched.markdown.input;

import android.content.Context;
import android.text.Editable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerDelegate;
import com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.swmansion.enriched.markdown.input.autolink.LinkRegexConfig;
import com.swmansion.enriched.markdown.input.layout.InputEventEmitter;
import com.swmansion.enriched.markdown.input.layout.InputMeasurementStore;
import com.swmansion.enriched.markdown.input.model.StyleType;
import com.swmansion.enriched.markdown.input.toolbar.FormatMenuConfig;
import com.swmansion.enriched.markdown.input.toolbar.InputContextMenu;
import com.swmansion.enriched.markdown.input.toolbar.InputSelectionMenuConfig;
import com.swmansion.enriched.markdown.utils.input.BorderPropsApplicator;
import com.swmansion.enriched.markdown.utils.input.MarkdownStyleParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = EnrichedMarkdownTextInputManager.NAME)
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b-\b\u0007\u0018\u0000 k2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001kB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\\\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0(H\u0016J\u001c\u0010)\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010+\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J!\u0010,\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010-H\u0017¢\u0006\u0002\u0010.J\u001a\u0010/\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u000200H\u0017J\u001a\u00101\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u000200H\u0017J\u001a\u00102\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u000200H\u0017J\u001c\u00103\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J\u001a\u00104\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u000200H\u0017J!\u00105\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010-H\u0017¢\u0006\u0002\u0010.J!\u00106\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010-H\u0017¢\u0006\u0002\u0010.J\u001c\u00107\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001dH\u0017J!\u00108\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010-H\u0017¢\u0006\u0002\u0010.J\u001a\u00109\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020 H\u0017J\u001a\u0010:\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u00020 H\u0017J\u001c\u0010;\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J\u001c\u0010<\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J\u001a\u0010=\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010*\u001a\u000200H\u0017J\u001c\u0010>\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010?H\u0017J\u001c\u0010@\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001dH\u0017J\u001c\u0010A\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001dH\u0017J\u001c\u0010B\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001dH\u0017J\u001c\u0010C\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010?H\u0017J\u001c\u0010D\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\nH\u0017J\u0018\u0010E\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J2\u0010F\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020-H\u0016J\u0012\u0010K\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010L\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010M\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010N\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010O\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020-H\u0016J\u0012\u0010R\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010S\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010T\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010U\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010V\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010W\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010X\u001a\u00020-H\u0016J\u0012\u0010Y\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010Z\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010[\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\\\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010]\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010^\u001a\u0004\u0018\u00010\nH\u0016J&\u0010_\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010`\u001a\u0004\u0018\u00010\n2\b\u0010^\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010a\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010`\u001a\u0004\u0018\u00010\nH\u0016J&\u0010b\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010c\u001a\u0004\u0018\u00010\n2\b\u0010^\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010d\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010e\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010f\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010g\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010h\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010i\u001a\u00020-H\u0016J\u001a\u0010j\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010i\u001a\u00020-H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/swmansion/enriched/markdown/input/EnrichedMarkdownTextInputManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/swmansion/enriched/markdown/input/EnrichedMarkdownTextInputView;", "Lcom/facebook/react/viewmanagers/EnrichedMarkdownTextInputManagerInterface;", "<init>", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "updateState", "", "view", "props", "Lcom/facebook/react/uimanager/ReactStylesDiffMap;", "stateWrapper", "Lcom/facebook/react/uimanager/StateWrapper;", "onAfterUpdateTransaction", "", "onDropViewInstance", "measure", "", "context", "Landroid/content/Context;", "localData", "Lcom/facebook/react/bridge/ReadableMap;", "state", "width", "", "widthMode", "Lcom/facebook/yoga/YogaMeasureMode;", "height", "heightMode", "attachmentsPositions", "", "getExportedCustomDirectEventTypeConstants", "", "setDefaultValue", "value", "setPlaceholder", "setPlaceholderTextColor", "", "(Lcom/swmansion/enriched/markdown/input/EnrichedMarkdownTextInputView;Ljava/lang/Integer;)V", "setEditable", "", "setAutoFocus", "setScrollEnabled", "setAutoCapitalize", "setMultiline", "setCursorColor", "setSelectionColor", "setMarkdownStyle", "setColor", "setFontSize", "setLineHeight", "setFontFamily", "setFontWeight", "setIsOnChangeMarkdownSet", "setContextMenuItems", "Lcom/facebook/react/bridge/ReadableArray;", "setSelectionMenuConfig", "setFormatMenuConfig", "setLinkRegex", "setMentionIndicators", "setWritingDirection", "updateProperties", "setPadding", "left", "top", "right", "bottom", "focus", "blur", "setValue", "markdown", "setSelection", "start", "end", "toggleBold", "toggleItalic", "toggleUnderline", "toggleStrikethrough", "toggleSpoiler", "toggleHeading", "level", "toggleUnorderedList", "toggleOrderedList", "indentList", "outdentList", "setLink", "url", "insertLink", "text", "insertText", "insertMention", "displayText", "startMention", "indicator", "removeLink", "copyToClipboard", "requestMarkdown", "requestId", "requestCaretRect", "Companion", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrichedMarkdownTextInputManager extends SimpleViewManager<EnrichedMarkdownTextInputView> implements EnrichedMarkdownTextInputManagerInterface {
    public static final String NAME = "EnrichedMarkdownTextInput";
    private final ViewManagerDelegate delegate = new EnrichedMarkdownTextInputManagerDelegate(this);

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "writingDirection")
    public void setWritingDirection(EnrichedMarkdownTextInputView view, String value) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public EnrichedMarkdownTextInputView createViewInstance(ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new EnrichedMarkdownTextInputView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(EnrichedMarkdownTextInputView view, ReactStylesDiffMap props, StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStateWrapper(stateWrapper);
        return super.updateState(view, props, stateWrapper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction(view);
        view.afterUpdateTransaction();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.dismissActiveMention();
        super.onDropViewInstance(view);
        view.getLayoutManager().release();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap localData, ReadableMap props, ReadableMap state, float width, YogaMeasureMode widthMode, float height, YogaMeasureMode heightMode, float[] attachmentsPositions) {
        Intrinsics.checkNotNullParameter(context, "context");
        return InputMeasurementStore.INSTANCE.getMeasureById(context, localData != null ? Integer.valueOf(localData.getInt("viewTag")) : null, width, height, heightMode, props);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"onChangeText", "onChangeMarkdown", "onChangeSelection", "onChangeState", "onInputKeyPress", "onRequestMarkdownResult", "onRequestCaretRectResult", "onCaretRectChange", "onInputFocus", "onInputBlur", "onContextMenuItemPress", "onLinkDetected", "onStartMention", "onChangeMention", "onEndMention"});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listListOf) {
            linkedHashMap.put(obj, MapsKt.mapOf(TuplesKt.to("registrationName", (String) obj)));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "defaultValue")
    public void setDefaultValue(EnrichedMarkdownTextInputView view, String value) {
        Editable text;
        if (value == null || view == null || (text = view.getText()) == null || text.length() != 0) {
            return;
        }
        view.setValueFromJS(value);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "placeholder")
    public void setPlaceholder(EnrichedMarkdownTextInputView view, String value) {
        if (view != null) {
            view.setUserHint(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(EnrichedMarkdownTextInputView view, Integer value) {
        if (view != null) {
            view.setHintTextColor(value != null ? value.intValue() : -7829368);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultBoolean = true, name = "editable")
    public void setEditable(EnrichedMarkdownTextInputView view, boolean value) {
        if (view != null) {
            view.setEnabled(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(EnrichedMarkdownTextInputView view, boolean value) {
        if (view != null) {
            view.setAutoFocusRequested(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(EnrichedMarkdownTextInputView view, boolean value) {
        if (view != null) {
            view.setScrollEnabled(value);
        }
        if (view != null) {
            view.setVerticalScrollBarEnabled(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(EnrichedMarkdownTextInputView view, String value) {
        if (view != null) {
            view.setAutoCapitalize(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultBoolean = true, name = "multiline")
    public void setMultiline(EnrichedMarkdownTextInputView view, boolean value) {
        if (view != null) {
            view.setSingleLine(!value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(EnrichedMarkdownTextInputView view, Integer value) {
        if (view != null) {
            view.setCursorColorFromProps(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(EnrichedMarkdownTextInputView view, Integer value) {
        if (value == null || view == null) {
            return;
        }
        view.setHighlightColor(value.intValue());
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "markdownStyle")
    public void setMarkdownStyle(EnrichedMarkdownTextInputView view, ReadableMap value) {
        if (view == null || value == null || !view.setMarkdownStyleFromProps(MarkdownStyleParser.INSTANCE.parse(value))) {
            return;
        }
        view.applyFormatting();
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public void setColor(EnrichedMarkdownTextInputView view, Integer value) {
        if (view != null) {
            view.setColorFromProps(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultFloat = 16.0f, name = "fontSize")
    public void setFontSize(EnrichedMarkdownTextInputView view, float value) {
        if (view != null) {
            view.setFontSizeFromProps(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultFloat = 0.0f, name = "lineHeight")
    public void setLineHeight(EnrichedMarkdownTextInputView view, float value) {
        if (value <= 0.0f || view == null) {
            return;
        }
        view.setLineSpacing(value - view.getTextSize(), 1.0f);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "fontFamily")
    public void setFontFamily(EnrichedMarkdownTextInputView view, String value) {
        if (view != null) {
            view.setFontFamily(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "fontWeight")
    public void setFontWeight(EnrichedMarkdownTextInputView view, String value) {
        if (view != null) {
            view.setFontWeight(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(defaultBoolean = false, name = "isOnChangeMarkdownSet")
    public void setIsOnChangeMarkdownSet(EnrichedMarkdownTextInputView view, boolean value) {
        if (view != null) {
            view.setEmitMarkdown(value);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "contextMenuItems")
    public void setContextMenuItems(EnrichedMarkdownTextInputView view, ReadableArray value) {
        ReadableMap map;
        if (view == null) {
            return;
        }
        IntRange intRangeUntil = RangesKt.until(0, value != null ? value.size() : 0);
        ArrayList arrayList = new ArrayList();
        Iterator it = intRangeUntil.iterator();
        while (it.hasNext()) {
            String string = (value == null || (map = value.getMap(((IntIterator) it).nextInt())) == null) ? null : map.getString("text");
            if (string != null) {
                arrayList.add(string);
            }
        }
        view.setContextMenuItems(arrayList);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "selectionMenuConfig")
    public void setSelectionMenuConfig(EnrichedMarkdownTextInputView view, ReadableMap value) {
        InputSelectionMenuConfig inputSelectionMenuConfig;
        if (view == null) {
            return;
        }
        InputContextMenu contextMenu = view.getContextMenu();
        if (value == null) {
            inputSelectionMenuConfig = new InputSelectionMenuConfig(false, null, false, null, 15, null);
        } else {
            boolean z = value.getBoolean("format");
            String string = value.getString("formatLabel");
            if (string == null) {
                string = "";
            }
            boolean z2 = value.getBoolean("copyAsMarkdown");
            String string2 = value.getString("copyAsMarkdownLabel");
            inputSelectionMenuConfig = new InputSelectionMenuConfig(z, string, z2, string2 != null ? string2 : "");
        }
        contextMenu.setSelectionMenuConfig(inputSelectionMenuConfig);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "formatMenuConfig")
    public void setFormatMenuConfig(EnrichedMarkdownTextInputView view, ReadableMap value) {
        FormatMenuConfig formatMenuConfig;
        if (view == null) {
            return;
        }
        InputContextMenu contextMenu = view.getContextMenu();
        if (value == null) {
            formatMenuConfig = new FormatMenuConfig(false, null, false, null, false, null, false, null, false, null, false, null, 4095, null);
        } else {
            boolean z = value.getBoolean("bold");
            String string = value.getString("boldLabel");
            if (string == null) {
                string = "";
            }
            boolean z2 = value.getBoolean("italic");
            String string2 = value.getString("italicLabel");
            if (string2 == null) {
                string2 = "";
            }
            boolean z3 = value.getBoolean("underline");
            String string3 = value.getString("underlineLabel");
            if (string3 == null) {
                string3 = "";
            }
            boolean z4 = value.getBoolean("strikethrough");
            String string4 = value.getString("strikethroughLabel");
            if (string4 == null) {
                string4 = "";
            }
            boolean z5 = value.getBoolean("spoiler");
            String string5 = value.getString("spoilerLabel");
            if (string5 == null) {
                string5 = "";
            }
            boolean z6 = value.getBoolean("link");
            String string6 = value.getString("linkLabel");
            formatMenuConfig = new FormatMenuConfig(z, string, z2, string2, z3, string3, z4, string4, z5, string5, z6, string6 == null ? "" : string6);
        }
        contextMenu.setFormatMenuConfig(formatMenuConfig);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "linkRegex")
    public void setLinkRegex(EnrichedMarkdownTextInputView view, ReadableMap value) {
        LinkRegexConfig linkRegexConfig;
        if (view == null) {
            return;
        }
        if (value != null) {
            String string = value.getString("pattern");
            if (string == null) {
                string = "";
            }
            linkRegexConfig = new LinkRegexConfig(string, value.getBoolean("caseInsensitive"), value.getBoolean("dotAll"), value.getBoolean("isDisabled"), value.getBoolean("isDefault"));
        } else {
            linkRegexConfig = new LinkRegexConfig("", false, false, false, true);
        }
        view.setLinkRegex(linkRegexConfig);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    @ReactProp(name = "mentionIndicators")
    public void setMentionIndicators(EnrichedMarkdownTextInputView view, ReadableArray value) {
        IntRange intRangeUntil = RangesKt.until(0, value != null ? value.size() : 0);
        ArrayList arrayList = new ArrayList();
        Iterator it = intRangeUntil.iterator();
        while (it.hasNext()) {
            String string = value != null ? value.getString(((IntIterator) it).nextInt()) : null;
            if (string != null) {
                arrayList.add(string);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (view != null) {
            view.setMentionIndicators(arrayList2);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateProperties(EnrichedMarkdownTextInputView view, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(props, "props");
        BorderPropsApplicator.INSTANCE.apply(view, props);
        super.updateProperties(view, props);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(EnrichedMarkdownTextInputView view, int left, int top, int right, int bottom) {
        super.setPadding(view, left, top, right, bottom);
        if (view != null) {
            view.setPadding(left, top, right, bottom);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void focus(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.requestFocusProgrammatically();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void blur(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.clearFocus();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void setValue(EnrichedMarkdownTextInputView view, String markdown) {
        if (markdown == null || view == null) {
            return;
        }
        view.setValueFromJS(markdown);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void setSelection(EnrichedMarkdownTextInputView view, int start, int end) {
        Editable text;
        int length = (view == null || (text = view.getText()) == null) ? 0 : text.length();
        int iCoerceIn = RangesKt.coerceIn(start, 0, length);
        int iCoerceIn2 = RangesKt.coerceIn(end, 0, length);
        if (view != null) {
            view.setSelection(iCoerceIn, iCoerceIn2);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleBold(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleInlineStyle(StyleType.BOLD);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleItalic(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleInlineStyle(StyleType.ITALIC);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleUnderline(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleInlineStyle(StyleType.UNDERLINE);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleStrikethrough(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleInlineStyle(StyleType.STRIKETHROUGH);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleSpoiler(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleInlineStyle(StyleType.SPOILER);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleHeading(EnrichedMarkdownTextInputView view, int level) {
        if (view != null) {
            view.toggleHeading(level);
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleUnorderedList(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleUnorderedList();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void toggleOrderedList(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.toggleOrderedList();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void indentList(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.indentList();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void outdentList(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.outdentList();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void setLink(EnrichedMarkdownTextInputView view, String url) {
        if (url == null || view == null) {
            return;
        }
        view.setLinkForSelection(url);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void insertLink(EnrichedMarkdownTextInputView view, String text, String url) {
        if (url == null || view == null) {
            return;
        }
        if (text == null) {
            text = url;
        }
        view.insertLinkAtCursor(text, url);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void insertText(EnrichedMarkdownTextInputView view, String text) {
        if (text == null || view == null) {
            return;
        }
        view.insertTextAtCursor(text);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void insertMention(EnrichedMarkdownTextInputView view, String displayText, String url) {
        if (displayText == null || url == null || view == null) {
            return;
        }
        view.insertMention(displayText, url);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void startMention(EnrichedMarkdownTextInputView view, String indicator) {
        if (indicator == null || view == null) {
            return;
        }
        view.startMention(indicator);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void removeLink(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.removeLinkAtCursor();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void copyToClipboard(EnrichedMarkdownTextInputView view) {
        if (view != null) {
            view.copyToClipboard();
        }
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void requestMarkdown(EnrichedMarkdownTextInputView view, int requestId) {
        InputEventEmitter eventEmitter;
        if (view == null || (eventEmitter = view.getEventEmitter()) == null) {
            return;
        }
        eventEmitter.emitRequestMarkdownResult(requestId);
    }

    @Override // com.facebook.react.viewmanagers.EnrichedMarkdownTextInputManagerInterface
    public void requestCaretRect(EnrichedMarkdownTextInputView view, int requestId) {
        InputEventEmitter eventEmitter;
        if (view == null || (eventEmitter = view.getEventEmitter()) == null) {
            return;
        }
        eventEmitter.emitRequestCaretRectResult(requestId);
    }
}

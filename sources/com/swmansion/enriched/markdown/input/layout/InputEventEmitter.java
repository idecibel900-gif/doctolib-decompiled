package com.swmansion.enriched.markdown.input.layout;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView;
import com.swmansion.enriched.markdown.input.events.OnCaretRectChangeEvent;
import com.swmansion.enriched.markdown.input.events.OnChangeMarkdownEvent;
import com.swmansion.enriched.markdown.input.events.OnChangeMentionEvent;
import com.swmansion.enriched.markdown.input.events.OnChangeSelectionEvent;
import com.swmansion.enriched.markdown.input.events.OnChangeStateEvent;
import com.swmansion.enriched.markdown.input.events.OnChangeTextEvent;
import com.swmansion.enriched.markdown.input.events.OnContextMenuItemPressEvent;
import com.swmansion.enriched.markdown.input.events.OnEndMentionEvent;
import com.swmansion.enriched.markdown.input.events.OnInputBlurEvent;
import com.swmansion.enriched.markdown.input.events.OnInputFocusEvent;
import com.swmansion.enriched.markdown.input.events.OnInputKeyPressEvent;
import com.swmansion.enriched.markdown.input.events.OnLinkDetectedEvent;
import com.swmansion.enriched.markdown.input.events.OnRequestCaretRectResultEvent;
import com.swmansion.enriched.markdown.input.events.OnRequestMarkdownResultEvent;
import com.swmansion.enriched.markdown.input.events.OnStartMentionEvent;
import com.swmansion.enriched.markdown.input.formatting.FormattingStore;
import com.swmansion.enriched.markdown.input.formatting.MarkdownSerializer;
import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.CaretRect;
import com.swmansion.enriched.markdown.input.model.StyleType;
import com.swmansion.enriched.markdown.input.styles.BlockHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputEventEmitter {
    private CaretRect prevCaretRect;
    private int prevHeadingLevel;
    private Pair prevOrderedList;
    private Map prevState;
    private Pair prevUnorderedList;
    private final EnrichedMarkdownTextInputView view;

    public InputEventEmitter(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.prevState = MapsKt.emptyMap();
        Boolean bool = Boolean.FALSE;
        this.prevUnorderedList = TuplesKt.to(bool, 0);
        this.prevOrderedList = TuplesKt.to(bool, 0);
    }

    public final void emitChangeText() {
        String string;
        MarkdownSerializer markdownSerializer = MarkdownSerializer.INSTANCE;
        Editable text = this.view.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        dispatch(new OnChangeTextEvent(surfaceId(), this.view.getId(), markdownSerializer.stripZwsp(string)));
    }

    public final void emitChangeMarkdown() {
        dispatch(new OnChangeMarkdownEvent(surfaceId(), this.view.getId(), serializeToMarkdown()));
    }

    public final void emitSelection(int i, int i2) {
        dispatch(new OnChangeSelectionEvent(surfaceId(), this.view.getId(), i, i2));
    }

    public final void emitState() {
        int selectionStart = this.view.getSelectionStart();
        EnumEntries entries = StyleType.getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (Object obj : entries) {
            linkedHashMap.put(obj, Boolean.valueOf(isStyleEffectivelyActive((StyleType) obj, selectionStart)));
        }
        int iHeadingLevelAtCursor = this.view.headingLevelAtCursor();
        Pair pairListStateAtCursor = this.view.listStateAtCursor(BlockType.UNORDERED_LIST_ITEM);
        Pair pairListStateAtCursor2 = this.view.listStateAtCursor(BlockType.ORDERED_LIST_ITEM);
        if (Intrinsics.areEqual(linkedHashMap, this.prevState) && iHeadingLevelAtCursor == this.prevHeadingLevel && Intrinsics.areEqual(pairListStateAtCursor, this.prevUnorderedList) && Intrinsics.areEqual(pairListStateAtCursor2, this.prevOrderedList)) {
            return;
        }
        this.prevState = linkedHashMap;
        this.prevHeadingLevel = iHeadingLevelAtCursor;
        this.prevUnorderedList = pairListStateAtCursor;
        this.prevOrderedList = pairListStateAtCursor2;
        int iSurfaceId = surfaceId();
        int id = this.view.getId();
        Boolean bool = (Boolean) linkedHashMap.get(StyleType.BOLD);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = (Boolean) linkedHashMap.get(StyleType.ITALIC);
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = (Boolean) linkedHashMap.get(StyleType.UNDERLINE);
        boolean zBooleanValue3 = bool3 != null ? bool3.booleanValue() : false;
        Boolean bool4 = (Boolean) linkedHashMap.get(StyleType.STRIKETHROUGH);
        boolean zBooleanValue4 = bool4 != null ? bool4.booleanValue() : false;
        Boolean bool5 = (Boolean) linkedHashMap.get(StyleType.SPOILER);
        boolean zBooleanValue5 = bool5 != null ? bool5.booleanValue() : false;
        Boolean bool6 = (Boolean) linkedHashMap.get(StyleType.LINK);
        dispatch(new OnChangeStateEvent(iSurfaceId, id, zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, bool6 != null ? bool6.booleanValue() : false, iHeadingLevelAtCursor, ((Boolean) pairListStateAtCursor.getFirst()).booleanValue(), ((Number) pairListStateAtCursor.getSecond()).intValue(), ((Boolean) pairListStateAtCursor2.getFirst()).booleanValue(), ((Number) pairListStateAtCursor2.getSecond()).intValue()));
    }

    public final void emitKeyPress(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        dispatch(new OnInputKeyPressEvent(surfaceId(), this.view.getId(), key));
    }

    public final void emitFocus() {
        dispatch(new OnInputFocusEvent(surfaceId(), this.view.getId()));
    }

    public final void emitBlur() {
        dispatch(new OnInputBlurEvent(surfaceId(), this.view.getId()));
    }

    public final void emitLinkDetected(String text, String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(url, "url");
        dispatch(new OnLinkDetectedEvent(surfaceId(), this.view.getId(), text, url, i, i2));
    }

    public final void emitStartMention(String indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        dispatch(new OnStartMentionEvent(surfaceId(), this.view.getId(), indicator));
    }

    public final void emitChangeMention(String indicator, String text) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        Intrinsics.checkNotNullParameter(text, "text");
        dispatch(new OnChangeMentionEvent(surfaceId(), this.view.getId(), indicator, text));
    }

    public final void emitEndMention(String indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        dispatch(new OnEndMentionEvent(surfaceId(), this.view.getId(), indicator));
    }

    public final void emitRequestMarkdownResult(int i) {
        dispatch(new OnRequestMarkdownResultEvent(surfaceId(), this.view.getId(), i, serializeToMarkdown()));
    }

    public final void emitRequestCaretRectResult(int i) {
        dispatch(new OnRequestCaretRectResultEvent(surfaceId(), this.view.getId(), i, computeCaretRect()));
    }

    public final void emitCaretRectChangeIfNeeded() {
        CaretRect caretRectComputeCaretRect = computeCaretRect();
        if (Intrinsics.areEqual(caretRectComputeCaretRect, this.prevCaretRect)) {
            return;
        }
        this.prevCaretRect = caretRectComputeCaretRect;
        dispatch(new OnCaretRectChangeEvent(surfaceId(), this.view.getId(), caretRectComputeCaretRect));
    }

    private final CaretRect computeCaretRect() {
        Layout layout = this.view.getLayout();
        int selectionStart = this.view.getSelectionStart();
        if (layout == null || selectionStart < 0) {
            return new CaretRect(0.0f, 0.0f, 0.0f, 0.0f);
        }
        int lineForOffset = layout.getLineForOffset(selectionStart);
        float primaryHorizontal = layout.getPrimaryHorizontal(selectionStart) + this.view.getPaddingLeft();
        float lineTop = layout.getLineTop(lineForOffset) + this.view.getPaddingTop();
        float lineBottom = layout.getLineBottom(lineForOffset) + this.view.getPaddingTop();
        float f = this.view.getResources().getDisplayMetrics().density;
        return new CaretRect(primaryHorizontal / f, lineTop / f, 2.0f / f, (lineBottom - lineTop) / f);
    }

    public final void emitContextMenuItemPress(String itemText, String selectedText, int i, int i2) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        FormattingStore formattingStore = this.view.getFormattingStore();
        boolean z = i < i2;
        Pair pairListStateAtCursor = this.view.listStateAtCursor(BlockType.UNORDERED_LIST_ITEM);
        Pair pairListStateAtCursor2 = this.view.listStateAtCursor(BlockType.ORDERED_LIST_ITEM);
        dispatch(new OnContextMenuItemPressEvent(surfaceId(), this.view.getId(), itemText, selectedText, i, i2, emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.BOLD), emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.ITALIC), emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.UNDERLINE), emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.STRIKETHROUGH), emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.SPOILER), emitContextMenuItemPress$isActive(z, formattingStore, i, i2, this, StyleType.LINK), this.view.headingLevelAtCursor(), ((Boolean) pairListStateAtCursor.getFirst()).booleanValue(), ((Number) pairListStateAtCursor.getSecond()).intValue(), ((Boolean) pairListStateAtCursor2.getFirst()).booleanValue(), ((Number) pairListStateAtCursor2.getSecond()).intValue()));
    }

    private static final boolean emitContextMenuItemPress$isActive(boolean z, FormattingStore formattingStore, int i, int i2, InputEventEmitter inputEventEmitter, StyleType styleType) {
        if (z) {
            return formattingStore.isStyleActiveInRange(styleType, i, i2);
        }
        return inputEventEmitter.isStyleEffectivelyActive(styleType, i);
    }

    private final boolean isStyleEffectivelyActive(StyleType styleType, int i) {
        if (this.view.getPendingStyles().contains(styleType)) {
            return true;
        }
        return !this.view.getPendingStyleRemovals().contains(styleType) && this.view.getFormattingStore().isStyleActive(styleType, i);
    }

    private final String serializeToMarkdown() {
        String string;
        Editable text = this.view.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        return MarkdownSerializer.INSTANCE.serialize(string, this.view.allFormattingRangesForSerialization(), this.view.getBlockStore().getAllRanges(), new Function1() { // from class: com.swmansion.enriched.markdown.input.layout.InputEventEmitter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InputEventEmitter.serializeToMarkdown$lambda$1(this.f$0, (BlockRange) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String serializeToMarkdown$lambda$1(InputEventEmitter inputEventEmitter, BlockRange blockRange) {
        String strMarkdownLinePrefix;
        Intrinsics.checkNotNullParameter(blockRange, "blockRange");
        BlockHandler blockHandlerHandlerForBlock = inputEventEmitter.view.getFormatter().handlerForBlock(blockRange.getType());
        return (blockHandlerHandlerForBlock == null || (strMarkdownLinePrefix = blockHandlerHandlerForBlock.markdownLinePrefix(blockRange)) == null) ? "" : strMarkdownLinePrefix;
    }

    private final int surfaceId() {
        Context context = this.view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null) {
            return -1;
        }
        return UIManagerHelper.getSurfaceId(reactContext);
    }

    private final void dispatch(Event event) {
        EventDispatcher eventDispatcherForReactTag;
        if (this.view.getEditSession().getShouldSuppressEvents()) {
            return;
        }
        Context context = this.view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null || (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, this.view.getId())) == null) {
            return;
        }
        eventDispatcherForReactTag.dispatchEvent(event);
    }
}

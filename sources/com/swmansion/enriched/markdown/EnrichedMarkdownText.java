package com.swmansion.enriched.markdown;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.swmansion.enriched.markdown.accessibility.AccessibilityLabels;
import com.swmansion.enriched.markdown.accessibility.AccessibleMarkdownTextView;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.parser.Md4cFlags;
import com.swmansion.enriched.markdown.parser.Parser;
import com.swmansion.enriched.markdown.renderer.Renderer;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spoiler.SpoilerCapable;
import com.swmansion.enriched.markdown.spoiler.SpoilerOverlay;
import com.swmansion.enriched.markdown.spoiler.SpoilerOverlayDrawer;
import com.swmansion.enriched.markdown.styles.ParagraphStyle;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.common.BreakStrategyUtils;
import com.swmansion.enriched.markdown.utils.text.TailFadeInAnimator;
import com.swmansion.enriched.markdown.utils.text.interaction.CheckboxTouchHelper;
import com.swmansion.enriched.markdown.utils.text.view.LinkEventsKt;
import com.swmansion.enriched.markdown.utils.text.view.LinkLongPressMovementMethod;
import com.swmansion.enriched.markdown.utils.text.view.SelectionActionModeKt;
import com.swmansion.enriched.markdown.utils.text.view.SelectionMenuConfig;
import com.swmansion.enriched.markdown.utils.text.view.TextSelectionColorsKt;
import com.swmansion.enriched.markdown.utils.text.view.TextViewSetupKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EnrichedMarkdownText extends AccessibleMarkdownTextView implements SpoilerCapable {
    public static final Companion Companion = new Companion(null);
    private boolean allowFontScaling;
    private boolean allowTrailingMargin;
    private final CheckboxTouchHelper checkboxTouchHelper;
    private List contextMenuItemTexts;
    private String currentMarkdown;
    private long currentRenderId;
    private final ExecutorService executor;
    private TailFadeInAnimator fadeAnimator;
    private Map imageRequestHeaders;
    private float lastKnownFontScale;
    private final EnrichedMarkdownTextLayoutManager layoutManager;
    private final Handler mainHandler;
    private StyleConfig markdownStyle;
    private ReadableMap markdownStyleMap;
    private float maxFontSizeMultiplier;
    private Md4cFlags md4cFlags;
    private Function4 onContextMenuItemPressCallback;
    private Function1 onLinkLongPressCallback;
    private Function1 onLinkPressCallback;
    private final Parser parser;
    private CharSequence pendingStyledText;
    private int previousTextLength;
    private final Renderer renderer;
    private Integer selectionColor;
    private Integer selectionHandleColor;
    private SelectionMenuConfig selectionMenuConfig;
    private SpoilerOverlay spoilerOverlay;
    private SpoilerOverlayDrawer spoilerOverlayDrawer;
    private StateWrapper stateWrapper;
    private boolean streamingAnimation;

    public /* synthetic */ EnrichedMarkdownText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrichedMarkdownText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.parser = Parser.INSTANCE.getShared();
        this.renderer = new Renderer();
        this.checkboxTouchHelper = new CheckboxTouchHelper(this);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.executor = Executors.newSingleThreadExecutor();
        this.layoutManager = new EnrichedMarkdownTextLayoutManager(this);
        this.contextMenuItemTexts = CollectionsKt.emptyList();
        this.currentMarkdown = "";
        this.md4cFlags = Md4cFlags.INSTANCE.getDEFAULT();
        this.lastKnownFontScale = context.getResources().getConfiguration().fontScale;
        this.allowFontScaling = true;
        this.imageRequestHeaders = MapsKt.emptyMap();
        this.spoilerOverlay = SpoilerOverlay.PARTICLES;
        this.selectionMenuConfig = new SelectionMenuConfig(false, false, null, null, null, null, null, 127, null);
        TextViewSetupKt.setupAsMarkdownTextView(this);
        setCustomSelectionActionModeCallback(SelectionActionModeKt.createSelectionActionModeCallback(this, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.contextMenuItemTexts;
            }
        }, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.selectionMenuConfig;
            }
        }, new Function4() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EnrichedMarkdownText._init_$lambda$2(this.f$0, (String) obj, (String) obj2, ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
            }
        }));
    }

    public final EnrichedMarkdownTextLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final Function4 getOnContextMenuItemPressCallback() {
        return this.onContextMenuItemPressCallback;
    }

    public final void setOnContextMenuItemPressCallback(Function4 function4) {
        this.onContextMenuItemPressCallback = function4;
    }

    public final StyleConfig getMarkdownStyle() {
        return this.markdownStyle;
    }

    public final String getCurrentMarkdown() {
        return this.currentMarkdown;
    }

    public final Md4cFlags getMd4cFlags() {
        return this.md4cFlags;
    }

    @Override // com.swmansion.enriched.markdown.spoiler.SpoilerCapable
    public SpoilerOverlayDrawer getSpoilerOverlayDrawer() {
        return this.spoilerOverlayDrawer;
    }

    public final SpoilerOverlay getSpoilerOverlay() {
        return this.spoilerOverlay;
    }

    public final void setSpoilerOverlay(SpoilerOverlay spoilerOverlay) {
        Intrinsics.checkNotNullParameter(spoilerOverlay, "<set-?>");
        this.spoilerOverlay = spoilerOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(EnrichedMarkdownText enrichedMarkdownText, String itemText, String selectedText, int i, int i2) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Function4 function4 = enrichedMarkdownText.onContextMenuItemPressCallback;
        if (function4 != null) {
            function4.invoke(itemText, selectedText, Integer.valueOf(i), Integer.valueOf(i2));
        }
        return Unit.INSTANCE;
    }

    public final void setMarkdownContent(String markdown) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        if (Intrinsics.areEqual(this.currentMarkdown, markdown)) {
            return;
        }
        this.currentMarkdown = markdown;
        scheduleRender();
    }

    public final void setMarkdownStyle(ReadableMap readableMap) {
        StyleConfig styleConfig;
        this.markdownStyleMap = readableMap;
        updateMeasurementStoreFontScaling();
        if (readableMap != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            styleConfig = new StyleConfig(readableMap, context, this.allowFontScaling, this.maxFontSizeMultiplier);
        } else {
            styleConfig = null;
        }
        if (styleConfig != null) {
            styleConfig.setImageRequestHeaders(this.imageRequestHeaders);
        }
        if (Intrinsics.areEqual(this.markdownStyle, styleConfig)) {
            return;
        }
        this.markdownStyle = styleConfig;
        updateJustificationMode(styleConfig);
        scheduleRender();
    }

    public final void setImageRequestHeaders(Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (Intrinsics.areEqual(this.imageRequestHeaders, headers)) {
            return;
        }
        this.imageRequestHeaders = headers;
        StyleConfig styleConfig = this.markdownStyle;
        if (styleConfig != null) {
            styleConfig.setImageRequestHeaders(headers);
        }
        scheduleRenderIfNeeded();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (this.allowFontScaling) {
            float f = newConfig.fontScale;
            if (f == this.lastKnownFontScale) {
                return;
            }
            this.lastKnownFontScale = f;
            recreateStyleConfig();
            scheduleRenderIfNeeded();
        }
    }

    public final void setMd4cFlags(Md4cFlags flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        if (Intrinsics.areEqual(this.md4cFlags, flags)) {
            return;
        }
        this.md4cFlags = flags;
        scheduleRenderIfNeeded();
    }

    public final void setAllowFontScaling(boolean z) {
        if (this.allowFontScaling == z) {
            return;
        }
        this.allowFontScaling = z;
        updateMeasurementStoreFontScaling();
        recreateStyleConfig();
        scheduleRenderIfNeeded();
    }

    public final void setMaxFontSizeMultiplier(float f) {
        if (this.maxFontSizeMultiplier == f) {
            return;
        }
        this.maxFontSizeMultiplier = f;
        updateMeasurementStoreFontScaling();
        recreateStyleConfig();
        scheduleRenderIfNeeded();
    }

    public final void setAllowTrailingMargin(boolean z) {
        if (this.allowTrailingMargin == z) {
            return;
        }
        this.allowTrailingMargin = z;
        scheduleRenderIfNeeded();
    }

    public final void setStreamingAnimation(boolean z) {
        if (this.streamingAnimation == z) {
            return;
        }
        this.streamingAnimation = z;
        if (z) {
            CharSequence text = getText();
            this.previousTextLength = text != null ? text.length() : 0;
            return;
        }
        TailFadeInAnimator tailFadeInAnimator = this.fadeAnimator;
        if (tailFadeInAnimator != null) {
            tailFadeInAnimator.cancelAll();
        }
        this.fadeAnimator = null;
        this.previousTextLength = 0;
    }

    public final void commitProps() {
        updateMeasurementStoreFontScaling();
    }

    private final void updateMeasurementStoreFontScaling() {
        MeasurementStore.INSTANCE.updateFontScalingSettings(getId(), this.allowFontScaling, this.maxFontSizeMultiplier);
    }

    private final void scheduleRenderIfNeeded() {
        if (this.currentMarkdown.length() > 0) {
            scheduleRender();
        }
    }

    private final void recreateStyleConfig() {
        ReadableMap readableMap = this.markdownStyleMap;
        if (readableMap != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            StyleConfig styleConfig = new StyleConfig(readableMap, context, this.allowFontScaling, this.maxFontSizeMultiplier);
            styleConfig.setImageRequestHeaders(this.imageRequestHeaders);
            this.markdownStyle = styleConfig;
            updateJustificationMode(styleConfig);
        }
    }

    private final void updateJustificationMode(StyleConfig styleConfig) {
        if (Build.VERSION.SDK_INT >= 26) {
            int i = 0;
            if (styleConfig != null && styleConfig.getNeedsJustify()) {
                i = 1;
            }
            setJustificationMode(i);
        }
    }

    private final void scheduleRender() {
        final StyleConfig styleConfig = this.markdownStyle;
        if (styleConfig == null) {
            return;
        }
        final String str = this.currentMarkdown;
        if (str.length() == 0) {
            return;
        }
        final long j = 1 + this.currentRenderId;
        this.currentRenderId = j;
        this.executor.execute(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                EnrichedMarkdownText.scheduleRender$lambda$10(this.f$0, str, styleConfig, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRender$lambda$10(final EnrichedMarkdownText enrichedMarkdownText, String str, StyleConfig styleConfig, final long j) {
        try {
            MarkdownASTNode markdown = enrichedMarkdownText.parser.parseMarkdown(str, enrichedMarkdownText.md4cFlags);
            if (markdown == null) {
                enrichedMarkdownText.mainHandler.post(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        EnrichedMarkdownText.scheduleRender$lambda$10$lambda$7$lambda$6(j, enrichedMarkdownText);
                    }
                });
                return;
            }
            Renderer renderer = enrichedMarkdownText.renderer;
            Context context = enrichedMarkdownText.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            renderer.configure(styleConfig, context);
            final SpannableString spannableStringRenderDocument = enrichedMarkdownText.renderer.renderDocument(markdown, enrichedMarkdownText.onLinkPressCallback, enrichedMarkdownText.onLinkLongPressCallback);
            enrichedMarkdownText.mainHandler.post(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    EnrichedMarkdownText.scheduleRender$lambda$10$lambda$8(j, enrichedMarkdownText, spannableStringRenderDocument);
                }
            });
        } catch (Exception e) {
            e.getMessage();
            enrichedMarkdownText.mainHandler.post(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdownText$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    EnrichedMarkdownText.scheduleRender$lambda$10$lambda$9(j, enrichedMarkdownText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRender$lambda$10$lambda$7$lambda$6(long j, EnrichedMarkdownText enrichedMarkdownText) {
        if (j == enrichedMarkdownText.currentRenderId && enrichedMarkdownText.isAttachedToWindow()) {
            enrichedMarkdownText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRender$lambda$10$lambda$8(long j, EnrichedMarkdownText enrichedMarkdownText, SpannableString spannableString) {
        if (j == enrichedMarkdownText.currentRenderId) {
            if (enrichedMarkdownText.isAttachedToWindow()) {
                enrichedMarkdownText.applyRenderedText(spannableString);
            } else {
                enrichedMarkdownText.pendingStyledText = spannableString;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRender$lambda$10$lambda$9(long j, EnrichedMarkdownText enrichedMarkdownText) {
        if (j == enrichedMarkdownText.currentRenderId && enrichedMarkdownText.isAttachedToWindow()) {
            enrichedMarkdownText.setText("");
        }
    }

    private final void applyRenderedText(CharSequence charSequence) {
        ParagraphStyle paragraphStyle;
        int i = this.previousTextLength;
        StyleConfig styleConfig = this.markdownStyle;
        if (styleConfig != null && (paragraphStyle = styleConfig.getParagraphStyle()) != null) {
            setTextSize(0, paragraphStyle.getFontSize());
        }
        setText(charSequence);
        if (!(getMovementMethod() instanceof LinkLongPressMovementMethod)) {
            setMovementMethod(LinkLongPressMovementMethod.Companion.createInstance());
        }
        Iterator it = this.renderer.getCollectedImageSpans().iterator();
        while (it.hasNext()) {
            ((ImageSpan) it.next()).registerTextView(this);
        }
        this.spoilerOverlayDrawer = SpoilerOverlayDrawer.Companion.setupIfNeeded(this, charSequence, getSpoilerOverlayDrawer(), this.spoilerOverlay);
        this.layoutManager.invalidateLayout();
        getAccessibilityHelper().invalidateAccessibilityItems();
        if (this.streamingAnimation) {
            if (this.fadeAnimator == null) {
                this.fadeAnimator = new TailFadeInAnimator(this);
            }
            TailFadeInAnimator tailFadeInAnimator = this.fadeAnimator;
            if (tailFadeInAnimator != null) {
                tailFadeInAnimator.animate(i, charSequence.length());
            }
            this.previousTextLength = charSequence.length();
        }
        TextSelectionColorsKt.applySelectionColors(this, this.selectionColor, this.selectionHandleColor);
    }

    public final float trailingMarginBottomPx() {
        if (this.allowTrailingMargin) {
            return this.renderer.getLastElementMarginBottom();
        }
        return 0.0f;
    }

    public final void setContextMenuItems(List<String> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.contextMenuItemTexts = items;
    }

    public final void setSelectionMenuConfig(SelectionMenuConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (Intrinsics.areEqual(this.selectionMenuConfig, config)) {
            return;
        }
        this.selectionMenuConfig = config;
    }

    public final void setAccessibilityLabels(AccessibilityLabels labels) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        getAccessibilityHelper().setLabels(labels);
    }

    public final void setIsSelectable(boolean z) {
        TextViewSetupKt.applySelectableState(this, z);
    }

    public final void setSelectionColor(Integer num) {
        if (Intrinsics.areEqual(this.selectionColor, num)) {
            return;
        }
        this.selectionColor = num;
        TextSelectionColorsKt.applySelectionColors(this, num, this.selectionHandleColor);
    }

    public final void setSelectionHandleColor(Integer num) {
        if (Intrinsics.areEqual(this.selectionHandleColor, num)) {
            return;
        }
        this.selectionHandleColor = num;
        TextSelectionColorsKt.applySelectionColors(this, this.selectionColor, num);
    }

    public final void setTextBreakStrategy(String strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        MeasurementStore measurementStore = MeasurementStore.INSTANCE;
        measurementStore.updateBreakStrategy(getId(), strategy);
        setBreakStrategy(BreakStrategyUtils.INSTANCE.resolveBreakStrategy(strategy));
        measurementStore.invalidate(getId());
        scheduleRenderIfNeeded();
    }

    public final void emitOnLinkPress(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        LinkEventsKt.emitLinkPressEvent(this, url);
    }

    public final void emitOnLinkLongPress(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        LinkEventsKt.emitLinkLongPressEvent(this, url);
    }

    public final void setOnLinkPressCallback(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.onLinkPressCallback = callback;
    }

    public final void setOnLinkLongPressCallback(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.onLinkLongPressCallback = callback;
    }

    public final void setOnTaskListItemPressCallback(Function3 function3) {
        this.checkboxTouchHelper.setOnCheckboxTap(function3);
    }

    public final void setEnableTaskListItemToggle(boolean z) {
        this.checkboxTouchHelper.setEnabled(z);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        CharSequence charSequence = this.pendingStyledText;
        if (charSequence != null) {
            this.pendingStyledText = null;
            applyRenderedText(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    protected void onDetachedFromWindow() {
        stopSpoilerAnimations();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        SpoilerOverlayDrawer spoilerOverlayDrawer = getSpoilerOverlayDrawer();
        if (spoilerOverlayDrawer != null) {
            spoilerOverlayDrawer.draw(canvas);
        }
    }

    private final void stopSpoilerAnimations() {
        SpoilerOverlayDrawer spoilerOverlayDrawer = getSpoilerOverlayDrawer();
        if (spoilerOverlayDrawer != null) {
            spoilerOverlayDrawer.stop();
        }
        this.spoilerOverlayDrawer = null;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.checkboxTouchHelper.onTouchEvent(event)) {
            if (event.getAction() != 0) {
                return true;
            }
            LinkEventsKt.cancelJSTouchForCheckboxTap(this, event);
            return true;
        }
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (event.getAction() == 0) {
            LinkEventsKt.cancelJSTouchForLinkTap(this, event);
            return zOnTouchEvent;
        }
        LinkEventsKt.reallowParentInterceptIfLinkReleased(this);
        return zOnTouchEvent;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

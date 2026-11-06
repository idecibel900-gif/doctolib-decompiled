package com.swmansion.enriched.markdown;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
import com.swmansion.enriched.markdown.accessibility.AccessibilityLabels;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.parser.Md4cFlags;
import com.swmansion.enriched.markdown.parser.Parser;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spoiler.SpoilerOverlay;
import com.swmansion.enriched.markdown.styles.ParagraphStyle;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import com.swmansion.enriched.markdown.utils.common.BreakStrategyUtils;
import com.swmansion.enriched.markdown.utils.common.CodeBlockStreamingMode;
import com.swmansion.enriched.markdown.utils.common.MarkdownSegmentKt;
import com.swmansion.enriched.markdown.utils.common.MarkdownSegmentRenderer;
import com.swmansion.enriched.markdown.utils.common.MotionPreferencesKt;
import com.swmansion.enriched.markdown.utils.common.ReconciliationResult;
import com.swmansion.enriched.markdown.utils.common.RenderedSegment;
import com.swmansion.enriched.markdown.utils.common.SegmentReconciler;
import com.swmansion.enriched.markdown.utils.common.StreamingFilterResult;
import com.swmansion.enriched.markdown.utils.common.StreamingMarkdownFilter;
import com.swmansion.enriched.markdown.utils.common.TableStreamingMode;
import com.swmansion.enriched.markdown.utils.text.TailFadeInAnimator;
import com.swmansion.enriched.markdown.utils.text.view.SelectionMenuConfig;
import com.swmansion.enriched.markdown.utils.text.view.TextSelectionColorsKt;
import com.swmansion.enriched.markdown.views.BlockSegmentView;
import com.swmansion.enriched.markdown.views.CodeBlockContainerView;
import com.swmansion.enriched.markdown.views.TableContainerView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EnrichedMarkdown extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private AccessibilityLabels accessibilityLabels;
    private boolean allowFontScaling;
    private boolean allowTrailingMargin;
    private CodeBlockStreamingMode codeBlockStreamingMode;
    private List contextMenuItemTexts;
    private String currentMarkdown;
    private long currentRenderId;
    private final EnumSet dirtyFlags;
    private boolean enableTaskListItemToggle;
    private final ExecutorService executor;
    private int forceHeightRecalculationCounter;
    private Map imageRequestHeaders;
    private float lastKnownFontScale;
    private final Handler mainHandler;
    private StyleConfig markdownStyle;
    private ReadableMap markdownStyleMap;
    private final Lazy mathContainerClass$delegate;
    private float maxFontSizeMultiplier;
    private Md4cFlags md4cFlags;
    private Function4 onContextMenuItemPressCallback;
    private Function2 onCopyPressCallback;
    private Function1 onLinkLongPressCallback;
    private Function1 onLinkPressCallback;
    private Function3 onTaskListItemPressCallback;
    private final Parser parser;
    private RenderedSegment.CodeBlock pendingCodeBlockSegment;
    private boolean renderPending;
    private final List segmentSignatures;
    private final List segmentViews;
    private boolean selectable;
    private Integer selectionColor;
    private Integer selectionHandleColor;
    private SelectionMenuConfig selectionMenuConfig;
    private SpoilerOverlay spoilerOverlay;
    private StateWrapper stateWrapper;
    private boolean streamingAnimation;
    private TableStreamingMode tableStreamingMode;
    private String textBreakStrategy;

    private enum DirtyFlag {
        RECREATE_SEGMENTS,
        FORCE_HEIGHT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ EnrichedMarkdown(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnrichedMarkdown(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.parser = Parser.INSTANCE.getShared();
        this.mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.executor = executorServiceNewSingleThreadExecutor;
        this.mathContainerClass$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnrichedMarkdown.mathContainerClass_delegate$lambda$0();
            }
        });
        this.segmentViews = new ArrayList();
        this.segmentSignatures = new ArrayList();
        this.dirtyFlags = EnumSet.noneOf(DirtyFlag.class);
        this.tableStreamingMode = TableStreamingMode.PROGRESSIVE;
        this.codeBlockStreamingMode = CodeBlockStreamingMode.PROGRESSIVE;
        this.currentMarkdown = "";
        this.lastKnownFontScale = context.getResources().getConfiguration().fontScale;
        this.md4cFlags = Md4cFlags.INSTANCE.getDEFAULT();
        this.allowFontScaling = true;
        this.imageRequestHeaders = MapsKt.emptyMap();
        this.selectable = true;
        this.selectionMenuConfig = new SelectionMenuConfig(false, false, null, null, null, null, null, 127, null);
        this.accessibilityLabels = new AccessibilityLabels(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        this.textBreakStrategy = "highQuality";
        this.contextMenuItemTexts = CollectionsKt.emptyList();
        this.spoilerOverlay = SpoilerOverlay.PARTICLES;
        this.enableTaskListItemToggle = true;
    }

    private final Class<?> getMathContainerClass() {
        return (Class) this.mathContainerClass$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Class mathContainerClass_delegate$lambda$0() {
        try {
            return Class.forName("com.swmansion.enriched.markdown.views.MathContainerView");
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean getStreamingAnimation() {
        return this.streamingAnimation;
    }

    public final void setStreamingAnimation(boolean z) {
        this.streamingAnimation = z;
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final TableStreamingMode getTableStreamingMode() {
        return this.tableStreamingMode;
    }

    public final void setTableStreamingMode(TableStreamingMode tableStreamingMode) {
        Intrinsics.checkNotNullParameter(tableStreamingMode, "<set-?>");
        this.tableStreamingMode = tableStreamingMode;
    }

    public final CodeBlockStreamingMode getCodeBlockStreamingMode() {
        return this.codeBlockStreamingMode;
    }

    public final void setCodeBlockStreamingMode(CodeBlockStreamingMode codeBlockStreamingMode) {
        Intrinsics.checkNotNullParameter(codeBlockStreamingMode, "<set-?>");
        this.codeBlockStreamingMode = codeBlockStreamingMode;
    }

    public final String getCurrentMarkdown() {
        return this.currentMarkdown;
    }

    public final StyleConfig getMarkdownStyle() {
        return this.markdownStyle;
    }

    public final Md4cFlags getMd4cFlags() {
        return this.md4cFlags;
    }

    public final Function4 getOnContextMenuItemPressCallback() {
        return this.onContextMenuItemPressCallback;
    }

    public final void setOnContextMenuItemPressCallback(Function4 function4) {
        this.onContextMenuItemPressCallback = function4;
    }

    public final SpoilerOverlay getSpoilerOverlay() {
        return this.spoilerOverlay;
    }

    public final void setSpoilerOverlay(SpoilerOverlay value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.spoilerOverlay == value) {
            return;
        }
        this.spoilerOverlay = value;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setSpoilerOverlay(value);
        }
    }

    public final boolean getEnableTaskListItemToggle() {
        return this.enableTaskListItemToggle;
    }

    public final void setEnableTaskListItemToggle(boolean z) {
        if (this.enableTaskListItemToggle == z) {
            return;
        }
        this.enableTaskListItemToggle = z;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setEnableTaskListItemToggle(z);
        }
    }

    public final void setMarkdownContent(String markdown) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        if (Intrinsics.areEqual(this.currentMarkdown, markdown)) {
            return;
        }
        this.currentMarkdown = markdown;
        this.renderPending = true;
    }

    public final void setMarkdownStyle(ReadableMap readableMap) {
        StyleConfig styleConfig;
        this.markdownStyleMap = readableMap;
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
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
        EnumSet dirtyFlags2 = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags2, "dirtyFlags");
        dirtyFlags2.add(DirtyFlag.FORCE_HEIGHT);
        this.renderPending = true;
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
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
        this.renderPending = true;
    }

    public final void commitProps() {
        MeasurementStore measurementStore = MeasurementStore.INSTANCE;
        measurementStore.updateStreamingTableMode(getId(), this.tableStreamingMode);
        measurementStore.updateStreamingCodeBlockMode(getId(), this.codeBlockStreamingMode);
        measurementStore.updateFontScalingSettings(getId(), this.allowFontScaling, this.maxFontSizeMultiplier);
        if (this.renderPending) {
            this.renderPending = false;
            scheduleRenderIfNeeded();
        }
    }

    @Override // android.view.View
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
            EnumSet dirtyFlags = this.dirtyFlags;
            Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
            dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
            EnumSet dirtyFlags2 = this.dirtyFlags;
            Intrinsics.checkNotNullExpressionValue(dirtyFlags2, "dirtyFlags");
            dirtyFlags2.add(DirtyFlag.FORCE_HEIGHT);
            scheduleRenderIfNeeded();
        }
    }

    public final void setMd4cFlags(Md4cFlags flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        if (Intrinsics.areEqual(this.md4cFlags, flags)) {
            return;
        }
        this.md4cFlags = flags;
        this.renderPending = true;
    }

    public final void setAllowFontScaling(boolean z) {
        if (this.allowFontScaling == z) {
            return;
        }
        this.allowFontScaling = z;
        MeasurementStore.INSTANCE.updateFontScalingSettings(getId(), this.allowFontScaling, this.maxFontSizeMultiplier);
        recreateStyleConfig();
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
        EnumSet dirtyFlags2 = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags2, "dirtyFlags");
        dirtyFlags2.add(DirtyFlag.FORCE_HEIGHT);
        this.renderPending = true;
    }

    public final void setMaxFontSizeMultiplier(float f) {
        if (this.maxFontSizeMultiplier == f) {
            return;
        }
        this.maxFontSizeMultiplier = f;
        MeasurementStore.INSTANCE.updateFontScalingSettings(getId(), this.allowFontScaling, this.maxFontSizeMultiplier);
        recreateStyleConfig();
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
        EnumSet dirtyFlags2 = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags2, "dirtyFlags");
        dirtyFlags2.add(DirtyFlag.FORCE_HEIGHT);
        this.renderPending = true;
    }

    public final void setAllowTrailingMargin(boolean z) {
        if (this.allowTrailingMargin == z) {
            return;
        }
        this.allowTrailingMargin = z;
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.RECREATE_SEGMENTS);
        EnumSet dirtyFlags2 = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags2, "dirtyFlags");
        dirtyFlags2.add(DirtyFlag.FORCE_HEIGHT);
        this.renderPending = true;
    }

    public final void setIsSelectable(boolean z) {
        if (this.selectable == z) {
            return;
        }
        this.selectable = z;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setIsSelectable(z);
        }
    }

    public final void setSelectionColor(Integer num) {
        if (Intrinsics.areEqual(this.selectionColor, num)) {
            return;
        }
        this.selectionColor = num;
        applySelectionColorsToSegments();
    }

    public final void setSelectionHandleColor(Integer num) {
        if (Intrinsics.areEqual(this.selectionHandleColor, num)) {
            return;
        }
        this.selectionHandleColor = num;
        applySelectionColorsToSegments();
    }

    public final void setTextBreakStrategy(String strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        if (Intrinsics.areEqual(this.textBreakStrategy, strategy)) {
            return;
        }
        this.textBreakStrategy = strategy;
        MeasurementStore.INSTANCE.updateBreakStrategy(getId(), strategy);
        int iResolveBreakStrategy = BreakStrategyUtils.INSTANCE.resolveBreakStrategy(strategy);
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setBreakStrategy(iResolveBreakStrategy);
        }
        EnumSet dirtyFlags = this.dirtyFlags;
        Intrinsics.checkNotNullExpressionValue(dirtyFlags, "dirtyFlags");
        dirtyFlags.add(DirtyFlag.FORCE_HEIGHT);
        this.renderPending = true;
    }

    private final void applySelectionColorsToSegments() {
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TextSelectionColorsKt.applySelectionColors((EnrichedMarkdownInternalText) it.next(), this.selectionColor, this.selectionHandleColor);
        }
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
        this.onTaskListItemPressCallback = function3;
    }

    public final void setOnCopyPressCallback(Function2 function2) {
        this.onCopyPressCallback = function2;
    }

    public final void setContextMenuItems(List<String> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.contextMenuItemTexts = items;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setContextMenuItems(items, new EnrichedMarkdown$setContextMenuItems$1$1(this));
        }
    }

    public final void setSelectionMenuConfig(SelectionMenuConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (Intrinsics.areEqual(this.selectionMenuConfig, config)) {
            return;
        }
        this.selectionMenuConfig = config;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setSelectionMenuConfig(config);
        }
        pushCopyLabelsToBlockSegments();
    }

    private final void pushCopyLabelsToBlockSegments() {
        String copyLabel = this.selectionMenuConfig.getCopyLabel();
        String copyAsMarkdownLabel = this.selectionMenuConfig.getCopyAsMarkdownLabel();
        for (View view : this.segmentViews) {
            if (view instanceof TableContainerView) {
                TableContainerView tableContainerView = (TableContainerView) view;
                tableContainerView.setCopyLabel(copyLabel);
                tableContainerView.setCopyAsMarkdownLabel(copyAsMarkdownLabel);
            } else if (view instanceof CodeBlockContainerView) {
                CodeBlockContainerView codeBlockContainerView = (CodeBlockContainerView) view;
                codeBlockContainerView.setCopyLabel(copyLabel);
                codeBlockContainerView.setCopyAsMarkdownLabel(copyAsMarkdownLabel);
            } else if (isMathContainerView(view)) {
                try {
                    Result.Companion companion = Result.Companion;
                    view.getClass().getMethod("setCopyLabel", String.class).invoke(view, copyLabel);
                    Result.m5243constructorimpl(view.getClass().getMethod("setCopyAsMarkdownLabel", String.class).invoke(view, copyAsMarkdownLabel));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m5243constructorimpl(ResultKt.createFailure(th));
                }
            }
        }
    }

    public final void setAccessibilityLabels(AccessibilityLabels labels) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        if (Intrinsics.areEqual(this.accessibilityLabels, labels)) {
            return;
        }
        this.accessibilityLabels = labels;
        List list = this.segmentViews;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof EnrichedMarkdownInternalText) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((EnrichedMarkdownInternalText) it.next()).setAccessibilityLabels(labels);
        }
        List list2 = this.segmentViews;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (obj2 instanceof TableContainerView) {
                arrayList2.add(obj2);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((TableContainerView) it2.next()).setAccessibilityLabels(labels);
        }
        Class<?> mathContainerClass = getMathContainerClass();
        if (mathContainerClass != null) {
            List list3 = this.segmentViews;
            ArrayList<View> arrayList3 = new ArrayList();
            for (Object obj3 : list3) {
                if (mathContainerClass.isInstance((View) obj3)) {
                    arrayList3.add(obj3);
                }
            }
            for (View view : arrayList3) {
                try {
                    Result.Companion companion = Result.Companion;
                    Result.m5243constructorimpl(mathContainerClass.getMethod("setAccessibilityLabels", AccessibilityLabels.class).invoke(view, labels));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m5243constructorimpl(ResultKt.createFailure(th));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forwardContextMenuItemPress(String str, String str2, int i, int i2) {
        Function4 function4 = this.onContextMenuItemPressCallback;
        if (function4 != null) {
            function4.invoke(str, str2, Integer.valueOf(i), Integer.valueOf(i2));
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
        }
    }

    private final void scheduleRenderIfNeeded() {
        if (this.currentMarkdown.length() > 0) {
            scheduleRender();
        }
    }

    private final void scheduleRender() {
        final StyleConfig styleConfig = this.markdownStyle;
        if (styleConfig == null) {
            return;
        }
        String str = this.currentMarkdown;
        if (str.length() <= 0) {
            str = null;
        }
        final String str2 = str;
        if (str2 == null) {
            return;
        }
        final boolean z = this.streamingAnimation;
        final TableStreamingMode tableStreamingMode = this.tableStreamingMode;
        final CodeBlockStreamingMode codeBlockStreamingMode = this.codeBlockStreamingMode;
        final long j = this.currentRenderId + 1;
        this.currentRenderId = j;
        this.executor.execute(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EnrichedMarkdown.scheduleRender$lambda$25(z, str2, tableStreamingMode, codeBlockStreamingMode, this, j, styleConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleRender$lambda$25(boolean z, String str, TableStreamingMode tableStreamingMode, CodeBlockStreamingMode codeBlockStreamingMode, final EnrichedMarkdown enrichedMarkdown, long j, final StyleConfig styleConfig) {
        final StyleConfig styleConfig2;
        StreamingFilterResult streamingFilterResultRenderableMarkdownForStreaming;
        String markdown;
        if (z) {
            try {
                streamingFilterResultRenderableMarkdownForStreaming = StreamingMarkdownFilter.INSTANCE.renderableMarkdownForStreaming(str, tableStreamingMode, codeBlockStreamingMode);
            } catch (Exception unused) {
                styleConfig2 = styleConfig;
                enrichedMarkdown.postToMain(j, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EnrichedMarkdown.scheduleRender$lambda$25$lambda$24(this.f$0, styleConfig2);
                    }
                });
            }
        } else {
            streamingFilterResultRenderableMarkdownForStreaming = null;
        }
        if (streamingFilterResultRenderableMarkdownForStreaming != null && (markdown = streamingFilterResultRenderableMarkdownForStreaming.getMarkdown()) != null) {
            str = markdown;
        }
        final boolean endsInsideOpenCodeFence = streamingFilterResultRenderableMarkdownForStreaming != null ? streamingFilterResultRenderableMarkdownForStreaming.getEndsInsideOpenCodeFence() : false;
        if (str.length() == 0) {
            enrichedMarkdown.postToMain(j, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EnrichedMarkdown.scheduleRender$lambda$25$lambda$20(this.f$0, styleConfig);
                }
            });
            return;
        }
        MarkdownASTNode markdown2 = enrichedMarkdown.parser.parseMarkdown(str, enrichedMarkdown.md4cFlags);
        if (markdown2 == null) {
            enrichedMarkdown.postToMain(j, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EnrichedMarkdown.scheduleRender$lambda$25$lambda$22$lambda$21(this.f$0, styleConfig);
                }
            });
            return;
        }
        List listSplitASTIntoSegments = MarkdownSegmentKt.splitASTIntoSegments(markdown2);
        MarkdownSegmentRenderer markdownSegmentRenderer = MarkdownSegmentRenderer.INSTANCE;
        Context context = enrichedMarkdown.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        styleConfig2 = styleConfig;
        try {
            final List listRender = markdownSegmentRenderer.render(listSplitASTIntoSegments, styleConfig2, context, enrichedMarkdown.onLinkPressCallback, enrichedMarkdown.onLinkLongPressCallback);
            enrichedMarkdown.postToMain(j, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EnrichedMarkdown.scheduleRender$lambda$25$lambda$23(this.f$0, listRender, styleConfig2, endsInsideOpenCodeFence);
                }
            });
        } catch (Exception unused2) {
            enrichedMarkdown.postToMain(j, new Function0() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EnrichedMarkdown.scheduleRender$lambda$25$lambda$24(this.f$0, styleConfig2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleRender$lambda$25$lambda$20(EnrichedMarkdown enrichedMarkdown, StyleConfig styleConfig) {
        enrichedMarkdown.applyRenderedSegments(CollectionsKt.emptyList(), styleConfig, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleRender$lambda$25$lambda$22$lambda$21(EnrichedMarkdown enrichedMarkdown, StyleConfig styleConfig) {
        enrichedMarkdown.applyRenderedSegments(CollectionsKt.emptyList(), styleConfig, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleRender$lambda$25$lambda$23(EnrichedMarkdown enrichedMarkdown, List list, StyleConfig styleConfig, boolean z) {
        enrichedMarkdown.applyRenderedSegments(list, styleConfig, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleRender$lambda$25$lambda$24(EnrichedMarkdown enrichedMarkdown, StyleConfig styleConfig) {
        enrichedMarkdown.applyRenderedSegments(CollectionsKt.emptyList(), styleConfig, false);
        return Unit.INSTANCE;
    }

    private final void applyRenderedSegments(List list, final StyleConfig styleConfig, boolean z) {
        RenderedSegment.CodeBlock codeBlock = null;
        if (z) {
            Object objLastOrNull = CollectionsKt.lastOrNull(list);
            if (objLastOrNull instanceof RenderedSegment.CodeBlock) {
                codeBlock = (RenderedSegment.CodeBlock) objLastOrNull;
            }
        }
        this.pendingCodeBlockSegment = codeBlock;
        boolean zContains = this.dirtyFlags.contains(DirtyFlag.RECREATE_SEGMENTS);
        boolean zContains2 = this.dirtyFlags.contains(DirtyFlag.FORCE_HEIGHT);
        this.dirtyFlags.clear();
        ReconciliationResult reconciliationResultReconcile = SegmentReconciler.INSTANCE.reconcile(CollectionsKt.toList(this.segmentViews), CollectionsKt.toList(this.segmentSignatures), list, zContains, new EnrichedMarkdown$applyRenderedSegments$result$1(this), new Function1() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnrichedMarkdown.applyRenderedSegments$lambda$26(this.f$0, styleConfig, (RenderedSegment) obj);
            }
        }, new Function2() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EnrichedMarkdown.applyRenderedSegments$lambda$27(this.f$0, (View) obj, (RenderedSegment) obj2);
            }
        });
        Iterator it = reconciliationResultReconcile.getViewsToRemove().iterator();
        while (it.hasNext()) {
            removeView((View) it.next());
        }
        Iterator it2 = reconciliationResultReconcile.getViewsToAttach().iterator();
        while (it2.hasNext()) {
            addView((View) it2.next());
        }
        this.segmentViews.clear();
        this.segmentViews.addAll(reconciliationResultReconcile.getViews());
        this.segmentSignatures.clear();
        this.segmentSignatures.addAll(reconciliationResultReconcile.getSignatures());
        Iterator it3 = this.segmentViews.iterator();
        int i = 0;
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) next;
            if (view instanceof CodeBlockContainerView) {
                ((CodeBlockContainerView) view).setPending(this.pendingCodeBlockSegment != null && i == this.segmentViews.size() - 1);
            }
            i = i2;
        }
        boolean z2 = (reconciliationResultReconcile.getViewsToAttach().isEmpty() && reconciliationResultReconcile.getViewsToRemove().isEmpty()) ? false : true;
        if (getWidth() > 0) {
            int iComputeSegmentsTotalHeight = computeSegmentsTotalHeight();
            layoutSegments();
            int iComputeSegmentsTotalHeight2 = computeSegmentsTotalHeight();
            if (zContains2 || z2 || iComputeSegmentsTotalHeight != iComputeSegmentsTotalHeight2) {
                MeasurementStore.INSTANCE.invalidate(getId());
                requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View applyRenderedSegments$lambda$26(EnrichedMarkdown enrichedMarkdown, StyleConfig styleConfig, RenderedSegment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        View viewCreateSegmentView = enrichedMarkdown.createSegmentView(segment, styleConfig);
        enrichedMarkdown.animateNewView(viewCreateSegmentView, segment);
        return viewCreateSegmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyRenderedSegments$lambda$27(EnrichedMarkdown enrichedMarkdown, View view, RenderedSegment segment) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(segment, "segment");
        enrichedMarkdown.updateSegmentView(view, segment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean viewMatchesSegmentKind(View view, RenderedSegment renderedSegment) {
        if (renderedSegment instanceof RenderedSegment.Text) {
            return view instanceof EnrichedMarkdownInternalText;
        }
        if (renderedSegment instanceof RenderedSegment.Table) {
            return view instanceof TableContainerView;
        }
        if (renderedSegment instanceof RenderedSegment.Math) {
            return isMathContainerView(view);
        }
        if (renderedSegment instanceof RenderedSegment.CodeBlock) {
            return view instanceof CodeBlockContainerView;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final boolean isMathContainerView(View view) {
        Class<?> mathContainerClass = getMathContainerClass();
        return mathContainerClass != null && mathContainerClass.isInstance(view);
    }

    private final View createSegmentView(RenderedSegment renderedSegment, StyleConfig styleConfig) {
        if (renderedSegment instanceof RenderedSegment.Text) {
            return createTextView((RenderedSegment.Text) renderedSegment);
        }
        if (renderedSegment instanceof RenderedSegment.Table) {
            return createTableView((RenderedSegment.Table) renderedSegment, styleConfig);
        }
        if (renderedSegment instanceof RenderedSegment.Math) {
            return createMathView((RenderedSegment.Math) renderedSegment, styleConfig);
        }
        if (renderedSegment instanceof RenderedSegment.CodeBlock) {
            return createCodeBlockView((RenderedSegment.CodeBlock) renderedSegment, styleConfig);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void updateSegmentView(View view, RenderedSegment renderedSegment) throws IllegalAccessException, InvocationTargetException {
        Method method;
        if (renderedSegment instanceof RenderedSegment.Text) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.swmansion.enriched.markdown.EnrichedMarkdownInternalText");
            EnrichedMarkdownInternalText enrichedMarkdownInternalText = (EnrichedMarkdownInternalText) view;
            CharSequence text = enrichedMarkdownInternalText.getText();
            int length = text != null ? text.length() : 0;
            RenderedSegment.Text text2 = (RenderedSegment.Text) renderedSegment;
            enrichedMarkdownInternalText.setLastElementMarginBottom(text2.getLastElementMarginBottom());
            enrichedMarkdownInternalText.applyStyledText(text2.getStyledText());
            Iterator it = text2.getImageSpans().iterator();
            while (it.hasNext()) {
                ((ImageSpan) it.next()).registerTextView(enrichedMarkdownInternalText);
            }
            animateTextViewTail(enrichedMarkdownInternalText, length);
            return;
        }
        if (renderedSegment instanceof RenderedSegment.Table) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.swmansion.enriched.markdown.views.TableContainerView");
            TableContainerView tableContainerView = (TableContainerView) view;
            int rowCount = tableContainerView.getRowCount();
            tableContainerView.applyTableNode(((RenderedSegment.Table) renderedSegment).getNode());
            if (this.streamingAnimation) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (MotionPreferencesKt.isReducedMotionEnabled(context)) {
                    return;
                }
                tableContainerView.animateNewRows(rowCount, 200L);
                return;
            }
            return;
        }
        if (renderedSegment instanceof RenderedSegment.Math) {
            Class<?> mathContainerClass = getMathContainerClass();
            if (mathContainerClass == null || (method = mathContainerClass.getMethod("applyLatex", String.class)) == null) {
                return;
            }
            method.invoke(view, ((RenderedSegment.Math) renderedSegment).getLatex());
            return;
        }
        if (!(renderedSegment instanceof RenderedSegment.CodeBlock)) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.swmansion.enriched.markdown.views.CodeBlockContainerView");
        CodeBlockContainerView codeBlockContainerView = (CodeBlockContainerView) view;
        codeBlockContainerView.setPending(renderedSegment == this.pendingCodeBlockSegment);
        codeBlockContainerView.applyCodeBlockNode(((RenderedSegment.CodeBlock) renderedSegment).getNode());
    }

    private final void animateNewView(View view, RenderedSegment renderedSegment) {
        if (this.streamingAnimation) {
            if (renderedSegment instanceof RenderedSegment.Text) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.swmansion.enriched.markdown.EnrichedMarkdownInternalText");
                animateTextViewTail((EnrichedMarkdownInternalText) view, 0);
            } else {
                if (!(renderedSegment instanceof RenderedSegment.Table) && !(renderedSegment instanceof RenderedSegment.Math) && !(renderedSegment instanceof RenderedSegment.CodeBlock)) {
                    throw new NoWhenBranchMatchedException();
                }
                animateBlockViewFadeIn(view);
            }
        }
    }

    private final void animateTextViewTail(EnrichedMarkdownInternalText enrichedMarkdownInternalText, int i) {
        if (this.streamingAnimation) {
            CharSequence text = enrichedMarkdownInternalText.getText();
            int length = text != null ? text.length() : 0;
            if (length <= i) {
                return;
            }
            new TailFadeInAnimator(enrichedMarkdownInternalText).animate(i, length);
        }
    }

    private final void animateBlockViewFadeIn(View view) {
        if (this.streamingAnimation) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (MotionPreferencesKt.isReducedMotionEnabled(context)) {
                return;
            }
            view.setAlpha(0.0f);
            view.animate().alpha(1.0f).setDuration(200L).start();
        }
    }

    private final EnrichedMarkdownInternalText createTextView(RenderedSegment.Text text) {
        ParagraphStyle paragraphStyle;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        EnrichedMarkdownInternalText enrichedMarkdownInternalText = new EnrichedMarkdownInternalText(context, null, 0, 6, null);
        enrichedMarkdownInternalText.setSpoilerOverlay(this.spoilerOverlay);
        enrichedMarkdownInternalText.setEnableTaskListItemToggle(this.enableTaskListItemToggle);
        enrichedMarkdownInternalText.setSelectionMenuConfig(this.selectionMenuConfig);
        enrichedMarkdownInternalText.setAccessibilityLabels(this.accessibilityLabels);
        enrichedMarkdownInternalText.setIsSelectable(this.selectable);
        StyleConfig styleConfig = this.markdownStyle;
        if (styleConfig != null && (paragraphStyle = styleConfig.getParagraphStyle()) != null) {
            enrichedMarkdownInternalText.setTextSize(0, paragraphStyle.getFontSize());
        }
        int i = Build.VERSION.SDK_INT;
        enrichedMarkdownInternalText.setBreakStrategy(BreakStrategyUtils.INSTANCE.resolveBreakStrategy(this.textBreakStrategy));
        if (i >= 26 && text.getNeedsJustify()) {
            enrichedMarkdownInternalText.setJustificationMode(1);
        }
        enrichedMarkdownInternalText.setLastElementMarginBottom(text.getLastElementMarginBottom());
        enrichedMarkdownInternalText.applyStyledText(text.getStyledText());
        Iterator it = text.getImageSpans().iterator();
        while (it.hasNext()) {
            ((ImageSpan) it.next()).registerTextView(enrichedMarkdownInternalText);
        }
        enrichedMarkdownInternalText.setOnTaskListItemPressCallback(new Function3() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return EnrichedMarkdown.createTextView$lambda$36$lambda$35(this.f$0, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (String) obj3);
            }
        });
        if (!this.contextMenuItemTexts.isEmpty()) {
            enrichedMarkdownInternalText.setContextMenuItems(this.contextMenuItemTexts, new EnrichedMarkdown$createTextView$1$4(this));
        }
        TextSelectionColorsKt.applySelectionColors(enrichedMarkdownInternalText, this.selectionColor, this.selectionHandleColor);
        return enrichedMarkdownInternalText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTextView$lambda$36$lambda$35(EnrichedMarkdown enrichedMarkdown, int i, boolean z, String itemText) {
        Intrinsics.checkNotNullParameter(itemText, "itemText");
        Function3 function3 = enrichedMarkdown.onTaskListItemPressCallback;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(i), Boolean.valueOf(z), itemText);
        }
        return Unit.INSTANCE;
    }

    private final TableContainerView createTableView(RenderedSegment.Table table, StyleConfig styleConfig) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TableContainerView tableContainerView = new TableContainerView(context, styleConfig);
        tableContainerView.setAllowFontScaling(this.allowFontScaling);
        tableContainerView.setMaxFontSizeMultiplier(this.maxFontSizeMultiplier);
        tableContainerView.setAccessibilityLabels(this.accessibilityLabels);
        tableContainerView.setOnLinkPress(this.onLinkPressCallback);
        tableContainerView.setOnLinkLongPress(this.onLinkLongPressCallback);
        tableContainerView.setCopyLabel(this.selectionMenuConfig.getCopyLabel());
        tableContainerView.setCopyAsMarkdownLabel(this.selectionMenuConfig.getCopyAsMarkdownLabel());
        tableContainerView.applyTableNode(table.getNode());
        return tableContainerView;
    }

    private final CodeBlockContainerView createCodeBlockView(RenderedSegment.CodeBlock codeBlock, StyleConfig styleConfig) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CodeBlockContainerView codeBlockContainerView = new CodeBlockContainerView(context, styleConfig);
        codeBlockContainerView.setCopyLabel(this.selectionMenuConfig.getCopyLabel());
        codeBlockContainerView.setCopyAsMarkdownLabel(this.selectionMenuConfig.getCopyAsMarkdownLabel());
        codeBlockContainerView.setOnCopyPress(new Function2() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EnrichedMarkdown.createCodeBlockView$lambda$39$lambda$38(this.f$0, (String) obj, (String) obj2);
            }
        });
        codeBlockContainerView.setPending(codeBlock == this.pendingCodeBlockSegment);
        codeBlockContainerView.applyCodeBlockNode(codeBlock.getNode());
        return codeBlockContainerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createCodeBlockView$lambda$39$lambda$38(EnrichedMarkdown enrichedMarkdown, String code, String language) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(language, "language");
        Function2 function2 = enrichedMarkdown.onCopyPressCallback;
        if (function2 != null) {
            function2.invoke(code, language);
        }
        return Unit.INSTANCE;
    }

    private final View createMathView(RenderedSegment.Math math, StyleConfig styleConfig) {
        getMathContainerClass();
        return new View(getContext());
    }

    private final void postToMain(final long j, final Function0 function0) {
        this.mainHandler.post(new Runnable() { // from class: com.swmansion.enriched.markdown.EnrichedMarkdown$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                EnrichedMarkdown.postToMain$lambda$41(j, this, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postToMain$lambda$41(long j, EnrichedMarkdown enrichedMarkdown, Function0 function0) {
        if (j == enrichedMarkdown.currentRenderId) {
            function0.invoke();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutSegments();
    }

    public final void onImageLayoutChanged() {
        if (getWidth() > 0) {
            layoutSegments();
            requestLayout();
        }
        MeasurementStore.INSTANCE.invalidate(getId());
        StateWrapper stateWrapper = this.stateWrapper;
        if (stateWrapper == null) {
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        int i = this.forceHeightRecalculationCounter + 1;
        this.forceHeightRecalculationCounter = i;
        writableMapCreateMap.putInt("forceHeightRecalculationCounter", i);
        stateWrapper.updateState(writableMapCreateMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void layoutSegments() {
        boolean z;
        int width = getWidth();
        if (width <= 0) {
            return;
        }
        List list = this.segmentViews;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                View view = (View) it.next();
                if ((view instanceof TableContainerView) && ((int) Math.ceil(((TableContainerView) view).getTableStyle$react_native_enriched_markdown_release().getHorizontalOverflow())) > 0) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (getClipChildren() == z) {
            setClipChildren(!z);
        }
        int lastIndex = CollectionsKt.getLastIndex(this.segmentViews);
        int i = 1073741824;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = 0;
        int measuredHeight = 0;
        for (Object obj : this.segmentViews) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = (View) obj;
            BlockSegmentView blockSegmentView = view2 instanceof BlockSegmentView ? (BlockSegmentView) view2 : null;
            boolean z2 = i2 != lastIndex || this.allowTrailingMargin;
            int segmentMarginTop = measuredHeight + (blockSegmentView != null ? blockSegmentView.getSegmentMarginTop() : 0);
            int iMax = view2 instanceof TableContainerView ? Math.max((int) Math.ceil(((TableContainerView) view2).getTableStyle$react_native_enriched_markdown_release().getHorizontalOverflow()), 0) : 0;
            if (iMax > 0) {
                view2.measure(View.MeasureSpec.makeMeasureSpec((iMax * 2) + width, i), iMakeMeasureSpec2);
                view2.layout(-iMax, segmentMarginTop, iMax + width, segmentMarginTop + view2.getMeasuredHeight());
            } else {
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                view2.layout(0, segmentMarginTop, width, view2.getMeasuredHeight() + segmentMarginTop);
            }
            measuredHeight = segmentMarginTop + view2.getMeasuredHeight();
            if (z2) {
                measuredHeight += blockSegmentView != null ? blockSegmentView.getSegmentMarginBottom() : 0;
            }
            i2 = i3;
            i = 1073741824;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int computeSegmentsTotalHeight() {
        int lastIndex = CollectionsKt.getLastIndex(this.segmentViews);
        int segmentMarginTop = 0;
        int i = 0;
        for (Object obj : this.segmentViews) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            BlockSegmentView blockSegmentView = view instanceof BlockSegmentView ? (BlockSegmentView) view : null;
            segmentMarginTop = segmentMarginTop + (blockSegmentView != null ? blockSegmentView.getSegmentMarginTop() : 0) + view.getMeasuredHeight();
            if (i != lastIndex || this.allowTrailingMargin) {
                segmentMarginTop += blockSegmentView != null ? blockSegmentView.getSegmentMarginBottom() : 0;
            }
            i = i2;
        }
        return segmentMarginTop;
    }

    public final void cleanup() {
        this.executor.shutdownNow();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

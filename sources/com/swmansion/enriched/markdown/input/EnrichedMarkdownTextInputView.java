package com.swmansion.enriched.markdown.input;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BlendMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.enriched.markdown.input.autolink.AutoLinkDetector;
import com.swmansion.enriched.markdown.input.autolink.LinkRegexConfig;
import com.swmansion.enriched.markdown.input.detection.DetectorPipeline;
import com.swmansion.enriched.markdown.input.editing.BlockEditCoordinator;
import com.swmansion.enriched.markdown.input.editing.ClipboardCoordinator;
import com.swmansion.enriched.markdown.input.editing.EditContext;
import com.swmansion.enriched.markdown.input.editing.EditPhase;
import com.swmansion.enriched.markdown.input.editing.EditPipeline;
import com.swmansion.enriched.markdown.input.editing.EditPipelineHost;
import com.swmansion.enriched.markdown.input.editing.EditSession;
import com.swmansion.enriched.markdown.input.editing.InputConnectionWrapper;
import com.swmansion.enriched.markdown.input.editing.LinkCoordinator;
import com.swmansion.enriched.markdown.input.editing.MarkdownEditableFactory;
import com.swmansion.enriched.markdown.input.editing.MarkdownTextWatcher;
import com.swmansion.enriched.markdown.input.editing.MentionCoordinator;
import com.swmansion.enriched.markdown.input.editing.MentionEvent;
import com.swmansion.enriched.markdown.input.formatting.BlockStore;
import com.swmansion.enriched.markdown.input.formatting.FormattingStore;
import com.swmansion.enriched.markdown.input.formatting.InputFormatter;
import com.swmansion.enriched.markdown.input.formatting.InputParser;
import com.swmansion.enriched.markdown.input.formatting.ParseResult;
import com.swmansion.enriched.markdown.input.layout.InputEventEmitter;
import com.swmansion.enriched.markdown.input.layout.InputLayoutManager;
import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.StyleType;
import com.swmansion.enriched.markdown.input.styles.StyleHandler;
import com.swmansion.enriched.markdown.input.styles.StyleMergingConfig;
import com.swmansion.enriched.markdown.input.toolbar.InputContextMenu;
import com.swmansion.enriched.markdown.utils.input.AutoCapitalizeUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class EnrichedMarkdownTextInputView extends AppCompatEditText {
    private boolean autoFocusRequested;
    private final AutoLinkDetector autoLinkDetector;
    private Integer baseHintColor;
    private final BlockEditCoordinator blockCoordinator;
    private final BlockStore blockStore;
    private final ClipboardCoordinator clipboardCoordinator;
    private final InputContextMenu contextMenu;
    private boolean detectScrollMovement;
    private final DetectorPipeline detectorPipeline;
    private final EditPipeline editPipeline;
    private final EnrichedMarkdownTextInputView$editPipelineHost$1 editPipelineHost;
    private final EditSession editSession;
    private boolean emitMarkdown;
    private final InputEventEmitter eventEmitter;
    private String fontFamilyValue;
    private int fontWeightValue;
    private final InputFormatter formatter;
    private final FormattingStore formattingStore;
    private Float headingOverrideBaseSizePx;
    private InputMethodManager inputMethodManager;
    private boolean isComponentReady;
    private String lastProcessedText;
    private final InputLayoutManager layoutManager;
    private final LinkCoordinator linkCoordinator;
    private final MentionCoordinator mentionCoordinator;
    private boolean pendingAutoFocusKeyboard;
    private final Set pendingStyleRemovals;
    private final Set pendingStyles;
    private int preEditSelectionEnd;
    private int preEditSelectionStart;
    private boolean scrollEnabled;
    private StateWrapper stateWrapper;
    private MarkdownTextWatcher textWatcher;
    private boolean typefaceDirty;
    private CharSequence userHint;
    private int zwspAnchorCount;

    @Override // android.view.View
    public boolean isLayoutRequested() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$editPipelineHost$1, com.swmansion.enriched.markdown.input.editing.EditPipelineHost] */
    public EnrichedMarkdownTextInputView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FormattingStore formattingStore = new FormattingStore();
        this.formattingStore = formattingStore;
        BlockStore blockStore = new BlockStore();
        this.blockStore = blockStore;
        InputFormatter inputFormatter = new InputFormatter(getResources().getDisplayMetrics().density);
        this.formatter = inputFormatter;
        this.pendingStyles = new LinkedHashSet();
        this.pendingStyleRemovals = new LinkedHashSet();
        this.editSession = new EditSession();
        this.blockCoordinator = new BlockEditCoordinator(blockStore);
        this.lastProcessedText = "";
        this.layoutManager = new InputLayoutManager(this);
        this.fontWeightValue = -1;
        this.contextMenu = new InputContextMenu(this);
        InputEventEmitter inputEventEmitter = new InputEventEmitter(this);
        this.eventEmitter = inputEventEmitter;
        AutoLinkDetector autoLinkDetector = new AutoLinkDetector(formattingStore);
        this.autoLinkDetector = autoLinkDetector;
        DetectorPipeline detectorPipeline = new DetectorPipeline();
        this.detectorPipeline = detectorPipeline;
        this.mentionCoordinator = new MentionCoordinator(formattingStore);
        this.linkCoordinator = new LinkCoordinator(formattingStore, autoLinkDetector);
        ?? r7 = new EditPipelineHost() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$editPipelineHost$1
            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public Editable getEditable() {
                return this.this$0.getText();
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public boolean getEmitMarkdown() {
                return this.this$0.getEmitMarkdown();
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public boolean syncEmptyListAnchor(boolean z) {
                return this.this$0.syncEmptyListAnchor(z);
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public void forceScrollToSelection() {
                this.this$0.forceScrollToSelection();
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public void syncCursorSizeWithBlock() {
                this.this$0.syncCursorSizeWithBlock();
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public void updateActiveMention() {
                this.this$0.dispatchMentionUpdate();
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public void runAsATransaction(Function0 block) {
                Intrinsics.checkNotNullParameter(block, "block");
                this.this$0.runAsATransaction(block);
            }

            @Override // com.swmansion.enriched.markdown.input.editing.EditPipelineHost
            public void setViewSelection(int i) {
                this.this$0.setSelection(i);
            }
        };
        this.editPipelineHost = r7;
        this.editPipeline = new EditPipeline(formattingStore, blockStore, inputFormatter, detectorPipeline, inputEventEmitter, r7);
        this.scrollEnabled = true;
        this.clipboardCoordinator = new ClipboardCoordinator(formattingStore, blockStore, detectorPipeline, inputFormatter);
        setupDetectorPipeline();
        prepareComponent();
        this.isComponentReady = true;
    }

    public final FormattingStore getFormattingStore() {
        return this.formattingStore;
    }

    public final BlockStore getBlockStore() {
        return this.blockStore;
    }

    public final InputFormatter getFormatter() {
        return this.formatter;
    }

    public final Set<StyleType> getPendingStyles() {
        return this.pendingStyles;
    }

    public final Set<StyleType> getPendingStyleRemovals() {
        return this.pendingStyleRemovals;
    }

    public final EditSession getEditSession() {
        return this.editSession;
    }

    public final BlockEditCoordinator getBlockCoordinator() {
        return this.blockCoordinator;
    }

    public final boolean getEmitMarkdown() {
        return this.emitMarkdown;
    }

    public final void setEmitMarkdown(boolean z) {
        this.emitMarkdown = z;
    }

    public final boolean getAutoFocusRequested() {
        return this.autoFocusRequested;
    }

    public final void setAutoFocusRequested(boolean z) {
        this.autoFocusRequested = z;
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final InputLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public final InputContextMenu getContextMenu() {
        return this.contextMenu;
    }

    public final InputEventEmitter getEventEmitter() {
        return this.eventEmitter;
    }

    public final EditPipeline getEditPipeline() {
        return this.editPipeline;
    }

    public final boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    public final void setScrollEnabled(boolean z) {
        this.scrollEnabled = z;
    }

    private final void setupDetectorPipeline() {
        this.autoLinkDetector.setOnLinkDetected(new Function4() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EnrichedMarkdownTextInputView.setupDetectorPipeline$lambda$0(this.f$0, (String) obj, (String) obj2, ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
            }
        });
        this.detectorPipeline.addDetector(this.autoLinkDetector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDetectorPipeline$lambda$0(EnrichedMarkdownTextInputView enrichedMarkdownTextInputView, String text, String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(url, "url");
        enrichedMarkdownTextInputView.eventEmitter.emitLinkDetected(text, url, i, i2);
        return Unit.INSTANCE;
    }

    private final void prepareComponent() {
        setSingleLine(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(true);
        setInputType(180225);
        setGravity(8388659);
        if (Build.VERSION.SDK_INT >= 29) {
            setBreakStrategy(1);
        }
        setEditableFactory(new MarkdownEditableFactory(this));
        setPadding(0, 0, 0, 0);
        setBackground(null);
        BackgroundStyleApplicator.setBackgroundColor(this, 0);
        this.contextMenu.install();
        Object systemService = getContext().getSystemService("input_method");
        this.inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                EnrichedMarkdownTextInputView.prepareComponent$lambda$1(this.f$0, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareComponent$lambda$1(EnrichedMarkdownTextInputView enrichedMarkdownTextInputView, View view, boolean z) {
        if (z) {
            enrichedMarkdownTextInputView.eventEmitter.emitFocus();
        } else {
            enrichedMarkdownTextInputView.eventEmitter.emitBlur();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        runAsATransaction(new Function0() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnrichedMarkdownTextInputView.onAttachedToWindow$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAttachedToWindow$lambda$2(EnrichedMarkdownTextInputView enrichedMarkdownTextInputView) {
        super.setTextIsSelectable(true);
        return Unit.INSTANCE;
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        showAutoFocusKeyboardIfPending();
    }

    @Override // android.view.View
    public void clearFocus() {
        super.clearFocus();
        InputMethodManager inputMethodManager = this.inputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (inputConnectionOnCreateInputConnection == null) {
            return null;
        }
        return new InputConnectionWrapper(inputConnectionOnCreateInputConnection, this);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 61 && (keyEvent == null || keyEvent.hasNoModifiers())) {
            this.eventEmitter.emitKeyPress("Tab");
            int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(getSelectionStart(), getSelectionEnd()), 0);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast(Math.max(getSelectionStart(), getSelectionEnd()), 0);
            Editable text = getText();
            if (text != null) {
                text.replace(iCoerceAtLeast, iCoerceAtLeast2, "\t");
            }
            return true;
        }
        if ((i == 67 && deleteLinkBeforeCursor()) || handleListKey(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private final boolean handleListKey(int i, KeyEvent keyEvent) {
        Editable text;
        BlockRange blockRangeListBlockAtCursor = listBlockAtCursor();
        if (blockRangeListBlockAtCursor == null) {
            return false;
        }
        int level = blockRangeListBlockAtCursor.getLevel();
        if (i == 61) {
            if (keyEvent == null || !keyEvent.isShiftPressed()) {
                indentList();
            } else {
                outdentList();
            }
            return true;
        }
        if (i != 67 || getSelectionStart() != getSelectionEnd() || (text = getText()) == null) {
            return false;
        }
        int iLineStartOf = this.blockCoordinator.lineStartOf(text, getSelectionStart());
        String string = text.subSequence(iLineStartOf, this.blockCoordinator.lineEndOf(text, getSelectionStart())).toString();
        if (getSelectionStart() == iLineStartOf || string.length() == 0 || Intrinsics.areEqual(string, "\u200b")) {
            if (level > 0) {
                outdentList();
            } else {
                toggleListType(blockRangeListBlockAtCursor.getType());
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        ViewParent parent;
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.detectScrollMovement = true;
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 2 && this.detectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1) && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            this.detectScrollMovement = false;
        }
        return super.onTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.scrollEnabled) {
            super.scrollTo(i, i2);
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.scrollEnabled && super.canScrollVertically(i);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.scrollEnabled && super.canScrollHorizontally(i);
    }

    public final void attachTextWatcher(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        MarkdownTextWatcher markdownTextWatcher = this.textWatcher;
        if (markdownTextWatcher != null) {
            editable.removeSpan(markdownTextWatcher);
        }
        MarkdownTextWatcher markdownTextWatcher2 = new MarkdownTextWatcher(this);
        this.textWatcher = markdownTextWatcher2;
        addTextChangedListener(markdownTextWatcher2);
    }

    public final void runAsATransaction(final Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.editSession.getPhase() != EditPhase.Idle) {
            block.invoke();
        } else {
            this.editSession.scoped(EditPhase.Processing, new Function0() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EnrichedMarkdownTextInputView.runAsATransaction$lambda$3(block);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runAsATransaction$lambda$3(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public final void onBeforeTextChanged() {
        if (this.editSession.getPhase() != EditPhase.Idle) {
            return;
        }
        this.editSession.setTextChanging(true);
        this.preEditSelectionStart = getSelectionStart();
        this.preEditSelectionEnd = getSelectionEnd();
    }

    public final void onAfterTextChanged(int i, int i2, int i3) {
        String string;
        String string2;
        if (this.editSession.getPhase() != EditPhase.Idle) {
            return;
        }
        Editable text = getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        String str = string;
        if (Intrinsics.areEqual(str, this.lastProcessedText)) {
            return;
        }
        this.editSession.enter(EditPhase.Processing);
        try {
            this.editPipeline.processTextChange(new EditContext(i, i2, i3, str, this.preEditSelectionStart, this.preEditSelectionEnd, CollectionsKt.toSet(this.pendingStyles), CollectionsKt.toSet(this.pendingStyleRemovals)));
            this.editSession.setTextChanging(false);
            this.editSession.setDidTextChangeRecently(true);
            Editable text2 = getText();
            if (text2 != null && (string2 = text2.toString()) != null) {
                str = string2;
            }
            this.lastProcessedText = str;
        } finally {
            this.editSession.exit();
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (!this.isComponentReady || this.editSession.getShouldSuppressTextWatcher()) {
            return;
        }
        if (!this.editSession.isTextChanging()) {
            Pair pairSelectionAdjustedForAtomicLinks = this.formattingStore.selectionAdjustedForAtomicLinks(i, i2);
            if (pairSelectionAdjustedForAtomicLinks != null) {
                setSelection(((Number) pairSelectionAdjustedForAtomicLinks.getFirst()).intValue(), ((Number) pairSelectionAdjustedForAtomicLinks.getSecond()).intValue());
                return;
            } else if (this.editSession.getDidTextChangeRecently()) {
                this.editSession.setDidTextChangeRecently(false);
            } else {
                this.pendingStyles.clear();
                this.pendingStyleRemovals.clear();
                seedPendingStylesFromSelection(i, i2);
            }
        }
        if (!this.editSession.isTextChanging() && this.editSession.getPhase() == EditPhase.Idle) {
            syncEmptyListAnchor$default(this, false, 1, null);
        }
        this.eventEmitter.emitSelection(i, i2);
        dispatchMentionUpdate();
        this.eventEmitter.emitState();
        this.eventEmitter.emitCaretRectChangeIfNeeded();
    }

    private final void seedPendingStylesFromSelection(int i, int i2) {
        if (i == i2) {
            return;
        }
        for (StyleType styleType : StyleType.getEntries()) {
            if (styleType != StyleType.LINK && this.formattingStore.isStyleActive(styleType, i)) {
                this.pendingStyles.add(styleType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustStoresForEdit(int i, int i2, int i3) {
        this.formattingStore.adjustForEdit(i, i2, i3);
        this.blockStore.adjustForEdit(i, i2, i3);
        this.editPipeline.pruneOrphanedAnchors$react_native_enriched_markdown_release();
        Editable text = getText();
        if (text != null) {
            this.blockStore.normalizeToLineBounds(text);
        }
    }

    public final void applyFormatting() {
        Editable text = getText();
        if (text == null) {
            return;
        }
        this.formatter.applyFormatting(text, this.formattingStore.getAllRanges());
        this.formatter.applyBlockFormatting(text, this.blockStore.getAllRanges());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFormattingAndEmit() {
        applyFormatting();
        forceScrollToSelection();
        if (this.emitMarkdown) {
            this.eventEmitter.emitChangeMarkdown();
        }
        this.eventEmitter.emitState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceScrollToSelection() {
        int selectionStart;
        Layout layout = getLayout();
        if (layout != null && (selectionStart = getSelectionStart()) > 0) {
            int lineForOffset = layout.getLineForOffset(selectionStart);
            int lineTop = layout.getLineTop(lineForOffset);
            int lineBottom = layout.getLineBottom(lineForOffset);
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            if (height <= 0) {
                return;
            }
            int scrollY = getScrollY();
            int scrollY2 = getScrollY() + height;
            int scrollY3 = getScrollY();
            if (lineTop >= scrollY) {
                lineTop = lineBottom > scrollY2 ? lineBottom - height : scrollY3;
            }
            scrollTo(getScrollX(), RangesKt.coerceIn(lineTop, 0, RangesKt.coerceAtLeast(layout.getHeight() - height, 0)));
        }
    }

    public final void toggleInlineStyle(StyleType styleType) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        StyleHandler styleHandler = (StyleHandler) this.formatter.getHandlers().get(styleType);
        if (styleHandler == null) {
            return;
        }
        StyleMergingConfig mergingConfig = styleHandler.getMergingConfig();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (this.formattingStore.isToggleBlocked(styleType, selectionStart, mergingConfig.getBlockingStyles())) {
            return;
        }
        FormattingStore.ToggleResult toggleResult = this.formattingStore.toggleStyle(styleType, selectionStart, selectionEnd, mergingConfig.getConflictingStyles());
        if (selectionStart == selectionEnd) {
            if (this.pendingStyleRemovals.contains(styleType)) {
                this.pendingStyleRemovals.remove(styleType);
                this.pendingStyles.add(styleType);
            } else if (this.pendingStyles.contains(styleType)) {
                this.pendingStyles.remove(styleType);
                this.pendingStyleRemovals.add(styleType);
            } else if (toggleResult == FormattingStore.ToggleResult.WAS_ACTIVE) {
                this.pendingStyleRemovals.add(styleType);
            } else {
                this.pendingStyles.add(styleType);
            }
            this.eventEmitter.emitState();
            return;
        }
        applyFormattingAndEmit();
        this.pendingStyles.clear();
        this.pendingStyleRemovals.clear();
        seedPendingStylesFromSelection(selectionStart, selectionEnd);
    }

    private final BlockRange listBlockAtCursor() {
        Editable text = getText();
        if (text == null) {
            return null;
        }
        return this.blockCoordinator.listBlockAtPosition(text, getSelectionStart());
    }

    public final Pair listStateAtCursor(BlockType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Editable text = getText();
        return text == null ? TuplesKt.to(Boolean.FALSE, 0) : this.blockCoordinator.listStateAtPosition(text, getSelectionStart(), type);
    }

    public final void toggleUnorderedList() {
        toggleListType(BlockType.UNORDERED_LIST_ITEM);
    }

    public final void toggleOrderedList() {
        toggleListType(BlockType.ORDERED_LIST_ITEM);
    }

    private final void toggleListType(BlockType blockType) {
        Editable text = getText();
        if (text == null) {
            return;
        }
        this.blockCoordinator.toggleList(text, blockType, getSelectionStart(), getSelectionStart(), getSelectionEnd());
        applyFormattingAndEmit();
        syncEmptyListAnchor$default(this, false, 1, null);
    }

    public final void indentList() {
        changeListDepthBy(1);
    }

    public final void outdentList() {
        changeListDepthBy(-1);
    }

    private final void changeListDepthBy(int i) {
        Editable text = getText();
        if (text == null || this.blockCoordinator.changeDepth(text, getSelectionStart(), getSelectionStart(), getSelectionEnd(), i) == BlockEditCoordinator.DepthChangeResult.NO_OP) {
            return;
        }
        applyFormattingAndEmit();
        syncEmptyListAnchor$default(this, false, 1, null);
    }

    static /* synthetic */ boolean syncEmptyListAnchor$default(EnrichedMarkdownTextInputView enrichedMarkdownTextInputView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return enrichedMarkdownTextInputView.syncEmptyListAnchor(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    public final boolean syncEmptyListAnchor(boolean z) {
        final Editable text;
        boolean z2;
        if (this.editSession.getShouldSuppressAnchorSync() || (text = getText()) == null) {
            return false;
        }
        this.editSession.enter(EditPhase.ManagingAnchors);
        try {
            boolean z3 = true;
            if (this.zwspAnchorCount > 0) {
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = text.length() - 1;
                int i = 0;
                z2 = false;
                while (true) {
                    int i2 = ref$IntRef.element;
                    if (i2 < 0) {
                        break;
                    }
                    if (text.charAt(i2) == 8203) {
                        int iLineStartOf = this.blockCoordinator.lineStartOf(text, ref$IntRef.element);
                        if (this.blockCoordinator.lineEndOf(text, ref$IntRef.element) - iLineStartOf == 1 && text.charAt(iLineStartOf) == 8203 && this.blockCoordinator.listBlockAtLineStart(iLineStartOf) != null) {
                            i++;
                        } else {
                            runAsATransaction(new Function0() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return EnrichedMarkdownTextInputView.syncEmptyListAnchor$lambda$6(text, ref$IntRef);
                                }
                            });
                            this.blockStore.adjustForEdit(ref$IntRef.element, 1, 0);
                            z2 = true;
                        }
                    }
                    ref$IntRef.element--;
                }
                this.zwspAnchorCount = i;
            } else {
                z2 = false;
            }
            int selectionStart = getSelectionStart();
            if (getSelectionStart() == getSelectionEnd()) {
                final int iLineStartOf2 = this.blockCoordinator.lineStartOf(text, selectionStart);
                int iLineEndOf = this.blockCoordinator.lineEndOf(text, selectionStart);
                if (this.blockCoordinator.listBlockAtLineStart(iLineStartOf2) == null || iLineEndOf != iLineStartOf2) {
                    z3 = z2;
                } else {
                    runAsATransaction(new Function0() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return EnrichedMarkdownTextInputView.syncEmptyListAnchor$lambda$7(text, iLineStartOf2);
                        }
                    });
                    this.blockStore.adjustForEdit(iLineStartOf2, 0, 1);
                    this.blockStore.normalizeToLineBounds(text);
                    setSelection(iLineStartOf2 + 1);
                    this.zwspAnchorCount++;
                }
            } else {
                z3 = z2;
            }
            if (z3) {
                this.blockStore.normalizeToLineBounds(text);
                if (z) {
                    applyFormatting();
                }
                this.lastProcessedText = text.toString();
                if (this.emitMarkdown) {
                    this.eventEmitter.emitChangeMarkdown();
                }
            }
            syncHintVisibility();
            return z3;
        } finally {
            this.editSession.exit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncEmptyListAnchor$lambda$6(Editable editable, Ref$IntRef ref$IntRef) {
        int i = ref$IntRef.element;
        editable.delete(i, i + 1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncEmptyListAnchor$lambda$7(Editable editable, int i) {
        editable.insert(i, "\u200b");
        return Unit.INSTANCE;
    }

    private final void syncHintVisibility() {
        Editable text = getText();
        boolean z = false;
        if (text != null) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != 8203) {
                    z = true;
                    break;
                }
            }
        }
        CharSequence charSequence = (z || !this.blockStore.getAllRanges().isEmpty()) ? "" : this.userHint;
        if (Intrinsics.areEqual(getHint(), charSequence)) {
            return;
        }
        super.setHint(charSequence);
    }

    public final void setUserHint(CharSequence charSequence) {
        this.userHint = charSequence;
        syncHintVisibility();
    }

    public final void copyToClipboard() {
        Editable text = getText();
        if (text == null || text.length() == 0) {
            return;
        }
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(MarkdownClipboard.INSTANCE.newMarkdownClip(this.clipboardCoordinator.serializeFullDocument(text.toString(), text), text.toString()));
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        Editable text;
        if (i == 16908322) {
            MarkdownClipboard markdownClipboard = MarkdownClipboard.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            String strMarkdownFromClipboard = markdownClipboard.markdownFromClipboard(context);
            if (strMarkdownFromClipboard != null) {
                pasteMarkdown(strMarkdownFromClipboard);
                return true;
            }
            String strPlainTextFromClipboard = plainTextFromClipboard();
            if (strPlainTextFromClipboard != null) {
                pasteMarkdown(strPlainTextFromClipboard);
                return true;
            }
        }
        switch (i) {
            case R.id.cut:
            case R.id.copy:
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                String string = (selectionStart >= selectionEnd || (text = getText()) == null) ? null : text.subSequence(selectionStart, selectionEnd).toString();
                String strMarkdownForSelectedRange = markdownForSelectedRange();
                boolean zOnTextContextMenuItem = super.onTextContextMenuItem(i);
                if (zOnTextContextMenuItem && strMarkdownForSelectedRange != null && string != null) {
                    Object systemService = getContext().getSystemService("clipboard");
                    ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(MarkdownClipboard.INSTANCE.newMarkdownClip(strMarkdownForSelectedRange, string));
                    }
                }
                return zOnTextContextMenuItem;
            default:
                return super.onTextContextMenuItem(i);
        }
    }

    public final String markdownForSelectedRange() {
        String string;
        Editable text = getText();
        if (text == null || (string = text.toString()) == null) {
            return null;
        }
        return this.clipboardCoordinator.serializeSelectedRange(string, getSelectionStart(), getSelectionEnd(), getText());
    }

    private final String plainTextFromClipboard() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence charSequenceCoerceToText;
        String string;
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null && (primaryClip = clipboardManager.getPrimaryClip()) != null) {
            if (primaryClip.getItemCount() <= 0) {
                primaryClip = null;
            }
            if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null && (charSequenceCoerceToText = itemAt.coerceToText(getContext())) != null && (string = charSequenceCoerceToText.toString()) != null && string.length() > 0) {
                return string;
            }
        }
        return null;
    }

    public final void pasteMarkdown(String markdown) {
        String strSubstring;
        String strSubstring2;
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Editable text = getText();
        if (text == null) {
            return;
        }
        int length = markdown.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                strSubstring = markdown;
                break;
            } else {
                if (markdown.charAt(i) != '\n') {
                    strSubstring = markdown.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    break;
                }
                i++;
            }
        }
        if (markdown.length() > strSubstring.length()) {
            int lastIndex = StringsKt.getLastIndex(markdown);
            while (true) {
                if (-1 >= lastIndex) {
                    strSubstring2 = markdown;
                    break;
                } else {
                    if (markdown.charAt(lastIndex) != '\n') {
                        strSubstring2 = markdown.substring(lastIndex + 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        break;
                    }
                    lastIndex--;
                }
            }
        } else {
            strSubstring2 = "";
        }
        String strSubstring3 = markdown.substring(strSubstring.length(), markdown.length() - strSubstring2.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        ParseResult toPlainTextAndRanges = InputParser.INSTANCE.parseToPlainTextAndRanges(strSubstring3);
        int iCoerceIn = RangesKt.coerceIn(getSelectionStart(), 0, text.length());
        int iCoerceIn2 = RangesKt.coerceIn(getSelectionEnd(), iCoerceIn, text.length());
        String str = strSubstring + toPlainTextAndRanges.getPlainText() + strSubstring2;
        int length2 = strSubstring.length() + iCoerceIn;
        Editable text2 = getText();
        if (text2 == null) {
            return;
        }
        getEditSession().enter(EditPhase.Processing);
        try {
            text2.replace(iCoerceIn, iCoerceIn2, str);
            adjustStoresForEdit(iCoerceIn, iCoerceIn2 - iCoerceIn, str.length());
            for (FormattingRange formattingRange : toPlainTextAndRanges.getFormattingRanges()) {
                this.formattingStore.addRange(new FormattingRange(formattingRange.getType(), formattingRange.getStart() + length2, formattingRange.getEnd() + length2, formattingRange.getUrl()));
            }
            for (BlockRange blockRange : toPlainTextAndRanges.getBlockRanges()) {
                this.blockStore.setBlock(blockRange.getType(), blockRange.getLevel(), blockRange.getStart() + length2, blockRange.getEnd() + length2, text2);
            }
            setSelection(str.length() + iCoerceIn);
            this.detectorPipeline.processTextChange(text2, text2.toString(), iCoerceIn, str.length());
            this.lastProcessedText = text2.toString();
            applyFormattingAndEmit();
            getEventEmitter().emitChangeText();
        } finally {
            getEditSession().exit();
        }
    }

    public final void toggleHeading(int i) {
        BlockType blockTypeForHeadingLevel = BlockType.Companion.forHeadingLevel(i);
        if (blockTypeForHeadingLevel == null) {
            return;
        }
        toggleBlockType(blockTypeForHeadingLevel, i);
    }

    private final void toggleBlockType(BlockType blockType, int i) {
        Editable text = getText();
        if (text == null) {
            return;
        }
        int iCoerceIn = RangesKt.coerceIn(getSelectionStart(), 0, text.length());
        this.blockCoordinator.toggleBlock(text, blockType, i, iCoerceIn, RangesKt.coerceIn(getSelectionEnd(), iCoerceIn, text.length()));
        applyFormattingAndEmit();
        syncCursorSizeWithBlock();
    }

    private final BlockRange blockOnParagraphAt(int i) {
        Editable text = getText();
        if (text == null) {
            return null;
        }
        return this.blockCoordinator.blockAtPosition(text, i);
    }

    public final int headingLevelAtCursor() {
        Editable text = getText();
        if (text == null) {
            return 0;
        }
        return this.blockCoordinator.headingLevelAtPosition(text, getSelectionStart());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncCursorSizeWithBlock() {
        Editable text = getText();
        if (text == null) {
            return;
        }
        BlockRange blockRangeBlockOnParagraphAt = blockOnParagraphAt(getSelectionStart());
        if (blockRangeBlockOnParagraphAt != null && BlockType.Companion.getHEADINGS().contains(blockRangeBlockOnParagraphAt.getType()) && text.length() == 0) {
            Float fResolveHeadingFontSizePx = this.formatter.resolveHeadingFontSizePx(blockRangeBlockOnParagraphAt.getLevel());
            if (fResolveHeadingFontSizePx != null) {
                float fFloatValue = fResolveHeadingFontSizePx.floatValue();
                if (this.headingOverrideBaseSizePx == null) {
                    this.headingOverrideBaseSizePx = Float.valueOf(getPaint().getTextSize());
                    this.baseHintColor = Integer.valueOf(getCurrentHintTextColor());
                    setHintTextColor(0);
                }
                if (getPaint().getTextSize() == fFloatValue) {
                    return;
                }
                setTextSize(0, fFloatValue);
                return;
            }
            return;
        }
        Float f = this.headingOverrideBaseSizePx;
        if (f != null) {
            setTextSize(0, f.floatValue());
            this.headingOverrideBaseSizePx = null;
            Integer num = this.baseHintColor;
            if (num != null) {
                setHintTextColor(num.intValue());
            }
            this.baseHintColor = null;
        }
    }

    public final void setLinkForSelection(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (selectionStart == selectionEnd) {
            return;
        }
        this.linkCoordinator.setLinkForRange(url, selectionStart, selectionEnd, getText());
        applyFormattingAndEmit();
    }

    public final void insertTextAtCursor(String markdown) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        if (markdown.length() == 0) {
            return;
        }
        pasteMarkdown(markdown);
    }

    public final void insertLinkAtCursor(String displayText, String url) {
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(url, "url");
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        int length = displayText.length() + selectionStart;
        Editable text = getText();
        if (text == null) {
            return;
        }
        getEditSession().enter(EditPhase.Processing);
        try {
            text.replace(selectionStart, selectionEnd, displayText);
            adjustStoresForEdit(selectionStart, selectionEnd - selectionStart, displayText.length());
            this.linkCoordinator.addLink(url, selectionStart, length, text);
            setSelection(length);
            this.lastProcessedText = text.toString();
            applyFormattingAndEmit();
            getEventEmitter().emitChangeText();
        } finally {
            getEditSession().exit();
        }
    }

    public final void insertMention(String displayText, String url) {
        String currentIndicator;
        String str;
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(url, "url");
        if (displayText.length() == 0 || (currentIndicator = this.mentionCoordinator.getCurrentIndicator()) == null) {
            return;
        }
        int currentStart = this.mentionCoordinator.getCurrentStart();
        int currentEnd = this.mentionCoordinator.getCurrentEnd();
        Editable text = getText();
        if (text != null && currentStart >= 0 && currentEnd >= currentStart && currentEnd <= text.length()) {
            if (currentEnd >= text.length() || !CharsKt.isWhitespace(text.charAt(currentEnd))) {
                str = displayText + " ";
            } else {
                str = displayText;
            }
            int length = displayText.length() + currentStart;
            Editable text2 = getText();
            if (text2 == null) {
                return;
            }
            getEditSession().enter(EditPhase.Processing);
            try {
                text2.replace(currentStart, currentEnd, str);
                adjustStoresForEdit(currentStart, currentEnd - currentStart, str.length());
                this.linkCoordinator.addLink(url, currentStart, length, text2);
                dispatchMentionEvents(MentionCoordinator.clear$default(this.mentionCoordinator, false, currentIndicator, 1, null));
                setSelection(currentStart + str.length());
                this.lastProcessedText = text2.toString();
                applyFormattingAndEmit();
                getEventEmitter().emitChangeText();
            } finally {
                getEditSession().exit();
            }
        }
    }

    public final void startMention(String indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        if (indicator.length() != 0 && this.mentionCoordinator.containsIndicator(indicator)) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            Editable text = getText();
            if (text != null) {
                getEditSession().enter(EditPhase.Processing);
                try {
                    text.replace(selectionStart, selectionEnd, indicator);
                    adjustStoresForEdit(selectionStart, selectionEnd - selectionStart, indicator.length());
                    setSelection(selectionStart + indicator.length());
                    this.lastProcessedText = text.toString();
                    applyFormattingAndEmit();
                    getEventEmitter().emitChangeText();
                    getEditSession().exit();
                } catch (Throwable th) {
                    getEditSession().exit();
                    throw th;
                }
            }
            dispatchMentionUpdate();
        }
    }

    public final void removeLinkAtCursor() {
        if (this.linkCoordinator.removeLink(getSelectionStart())) {
            applyFormattingAndEmit();
        }
    }

    public final boolean deleteLinkBeforeCursor() {
        FormattingRange formattingRangeLinkRangeForDeletion;
        int selectionStart = getSelectionStart();
        if (selectionStart != getSelectionEnd() || selectionStart <= 0 || getText() == null || (formattingRangeLinkRangeForDeletion = this.linkCoordinator.linkRangeForDeletion(selectionStart)) == null) {
            return false;
        }
        int start = formattingRangeLinkRangeForDeletion.getStart();
        int end = formattingRangeLinkRangeForDeletion.getEnd();
        Editable text = getText();
        if (text != null) {
            getEditSession().enter(EditPhase.Processing);
            try {
                text.replace(start, end, "");
                adjustStoresForEdit(start, end - start, 0);
                setSelection(RangesKt.coerceAtMost(formattingRangeLinkRangeForDeletion.getStart(), text.length()));
                this.lastProcessedText = text.toString();
                applyFormattingAndEmit();
                getEventEmitter().emitChangeText();
                getEditSession().exit();
            } catch (Throwable th) {
                getEditSession().exit();
                throw th;
            }
        }
        dispatchMentionEvents(MentionCoordinator.clear$default(this.mentionCoordinator, false, null, 3, null));
        return true;
    }

    public final void setMentionIndicators(List<String> indicators) {
        Intrinsics.checkNotNullParameter(indicators, "indicators");
        dispatchMentionEvents(this.mentionCoordinator.setIndicators(indicators));
        dispatchMentionUpdate();
    }

    public final void dismissActiveMention() {
        MentionCoordinator.clear$default(this.mentionCoordinator, false, null, 2, null);
    }

    public final void setContextMenuItems(List<String> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.contextMenu.setContextMenuItems(items);
    }

    public final void setLinkRegex(LinkRegexConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.autoLinkDetector.setRegexConfig(config);
    }

    public final void setAutoLinkStyle(InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.autoLinkDetector.setStyle(style);
    }

    public final boolean setMarkdownStyleFromProps(InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        setAutoLinkStyle(style);
        return this.formatter.updateStyle(style);
    }

    public final List allFormattingRangesForSerialization() {
        return this.clipboardCoordinator.allRangesForSerialization(getText());
    }

    public final void setValueFromJS(String markdown) {
        String string;
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        ParseResult toPlainTextAndRanges = InputParser.INSTANCE.parseToPlainTextAndRanges(markdown);
        this.editSession.enter(EditPhase.Importing);
        try {
            this.formattingStore.clearAll();
            this.formattingStore.setRanges(toPlainTextAndRanges.getFormattingRanges());
            this.blockStore.setRanges(toPlainTextAndRanges.getBlockRanges());
            setText(toPlainTextAndRanges.getPlainText());
            Editable text = getText();
            setSelection(text != null ? text.length() : 0);
            this.zwspAnchorCount = 0;
            applyFormatting();
            forceScrollToSelection();
            this.layoutManager.invalidateLayout();
            Editable text2 = getText();
            if (text2 == null || (string = text2.toString()) == null) {
                string = "";
            }
            this.lastProcessedText = string;
        } finally {
            this.editSession.exit();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public final void setFontSizeFromProps(float f) {
        if (f <= 0.0f) {
            return;
        }
        setTextSize(0, (float) Math.ceil(PixelUtil.toPixelFromSP$default(f, 0.0f, 2, null)));
        this.layoutManager.invalidateLayout();
    }

    public final void setColorFromProps(Integer num) {
        setTextColor(num != null ? num.intValue() : -16777216);
    }

    public final void setCursorColorFromProps(Integer num) {
        Drawable textCursorDrawable;
        if (Build.VERSION.SDK_INT < 29 || (textCursorDrawable = getTextCursorDrawable()) == null) {
            return;
        }
        if (num != null) {
            BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1.m();
            textCursorDrawable.setColorFilter(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0.m(num.intValue(), BlendMode.SRC_IN));
        } else {
            textCursorDrawable.clearColorFilter();
        }
        setTextCursorDrawable(textCursorDrawable);
    }

    public final void setFontFamily(String str) {
        if (Intrinsics.areEqual(str, this.fontFamilyValue)) {
            return;
        }
        this.fontFamilyValue = str;
        this.typefaceDirty = true;
    }

    public final void setFontWeight(String str) {
        int fontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (fontWeight != this.fontWeightValue) {
            this.fontWeightValue = fontWeight;
            this.typefaceDirty = true;
        }
    }

    private final void updateTypeface() {
        if (this.typefaceDirty) {
            this.typefaceDirty = false;
            Typeface typeface = getTypeface();
            int i = this.fontWeightValue;
            String str = this.fontFamilyValue;
            AssetManager assets = getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            Typeface typefaceApplyStyles = ReactTypefaceUtils.applyStyles(typeface, -1, i, str, assets);
            setTypeface(typefaceApplyStyles);
            getPaint().setTypeface(typefaceApplyStyles);
            this.layoutManager.invalidateLayout();
        }
    }

    public final void setAutoCapitalize(String str) {
        AutoCapitalizeUtils.INSTANCE.apply(this, str);
    }

    public final void requestFocusProgrammatically() {
        requestFocus();
        InputMethodManager inputMethodManager = this.inputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this, 0);
        }
        setSelection(RangesKt.coerceAtLeast(getSelectionStart(), 0));
    }

    private final void showAutoFocusKeyboardIfPending() {
        if (this.pendingAutoFocusKeyboard && hasWindowFocus()) {
            this.pendingAutoFocusKeyboard = false;
            InputMethodManager inputMethodManager = this.inputMethodManager;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this, 0);
            }
        }
    }

    public final void afterUpdateTransaction() {
        updateTypeface();
        if (this.autoFocusRequested) {
            this.autoFocusRequested = false;
            this.pendingAutoFocusKeyboard = true;
            post(new Runnable() { // from class: com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    EnrichedMarkdownTextInputView.afterUpdateTransaction$lambda$22(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterUpdateTransaction$lambda$22(EnrichedMarkdownTextInputView enrichedMarkdownTextInputView) {
        enrichedMarkdownTextInputView.requestFocus();
        Editable text = enrichedMarkdownTextInputView.getText();
        enrichedMarkdownTextInputView.setSelection(text != null ? text.length() : 0);
        enrichedMarkdownTextInputView.showAutoFocusKeyboardIfPending();
    }

    public final void applyStyleToRange(StyleType styleType, int i, int i2) {
        StyleHandler styleHandler;
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        if (i < i2 && (styleHandler = (StyleHandler) this.formatter.getHandlers().get(styleType)) != null) {
            this.formattingStore.toggleStyle(styleType, i, i2, styleHandler.getMergingConfig().getConflictingStyles());
            applyFormattingAndEmit();
        }
    }

    public final void applyLinkToRange(String url, int i, int i2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.linkCoordinator.addLinkDirect(url, i, i2);
        applyFormattingAndEmit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchMentionUpdate() {
        MentionCoordinator mentionCoordinator = this.mentionCoordinator;
        Editable text = getText();
        dispatchMentionEvents(mentionCoordinator.update(text != null ? text.toString() : null, getSelectionStart(), getSelectionEnd()));
    }

    private final void dispatchMentionEvents(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MentionEvent mentionEvent = (MentionEvent) it.next();
            if (mentionEvent instanceof MentionEvent.Start) {
                this.eventEmitter.emitStartMention(((MentionEvent.Start) mentionEvent).getIndicator());
            } else if (mentionEvent instanceof MentionEvent.Change) {
                MentionEvent.Change change = (MentionEvent.Change) mentionEvent;
                this.eventEmitter.emitChangeMention(change.getIndicator(), change.getText());
            } else {
                if (!(mentionEvent instanceof MentionEvent.End)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.eventEmitter.emitEndMention(((MentionEvent.End) mentionEvent).getIndicator());
            }
        }
    }
}

package com.facebook.react.views.textinput;

import android.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.QwertyKeyListener;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.util.Predicate;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.Overflow;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributes;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTextPaintHolderSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class ReactEditText extends AppCompatEditText {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG_MODE;
    private static final KeyListener keyListener;
    private final String TAG;
    private boolean autoFocus;
    private boolean containsImages;
    private ContentSizeWatcher contentSizeWatcher;
    private boolean contextMenuHidden;
    private final int defaultGravityHorizontal;
    private final int defaultGravityVertical;
    private boolean detectScrollMovement;
    private boolean didAttachToWindow;
    private boolean disableFullscreen;
    private boolean disableTextDiffing;
    private List dragAndDropFilter;
    private EventDispatcher eventDispatcher;
    private String fontFamily;
    private int fontStyle;
    private int fontWeight;
    private final InputMethodManager inputMethodManager;
    private boolean isSettingTextFromJS;
    private boolean isSettingTextFromState;
    private InternalKeyListener keyListener$1;
    private CopyOnWriteArrayList listeners;
    private int nativeEventCount;
    private boolean onKeyPress;
    private Overflow overflow;
    private String placeholder;
    private String returnKeyType;
    private ScrollWatcher scrollWatcher;
    private boolean selectTextOnFocus;
    private SelectionWatcher selectionWatcher;
    private int stagedInputType;
    private StateWrapper stateWrapper;
    private String submitBehavior;
    private final TextAttributes textAttributes;
    private TextWatcherDelegator textWatcherDelegator;
    private boolean typefaceDirty;

    @Override // android.view.View
    public boolean isLayoutRequested() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        String simpleName = ReactEditText.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.TAG = simpleName;
        this.fontWeight = -1;
        this.fontStyle = -1;
        this.overflow = Overflow.VISIBLE;
        Object systemService = context.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.inputMethodManager = (InputMethodManager) systemService;
        this.defaultGravityHorizontal = getGravity() & 8388615;
        this.defaultGravityVertical = getGravity() & 112;
        this.nativeEventCount = 0;
        this.isSettingTextFromJS = false;
        this.disableFullscreen = false;
        this.listeners = null;
        this.stagedInputType = getInputType();
        if (this.keyListener$1 == null) {
            this.keyListener$1 = new InternalKeyListener();
        }
        this.scrollWatcher = null;
        this.textAttributes = new TextAttributes();
        applyTextAttributes();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 27) {
            setLayerType(1, null);
        }
        final boolean zIsFocusable = isFocusable();
        final int importantForAccessibility = getImportantForAccessibility();
        ViewCompat.setAccessibilityDelegate(this, new ReactAccessibilityDelegate(zIsFocusable, importantForAccessibility) { // from class: com.facebook.react.views.textinput.ReactEditText$editTextAccessibilityDelegate$1
            @Override // com.facebook.react.uimanager.ReactAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View host, int i2, Bundle bundle) {
                Intrinsics.checkNotNullParameter(host, "host");
                if (i2 == 16) {
                    Editable text = this.this$0.getText();
                    if (text != null) {
                        int length = text.length();
                        if (length > 0) {
                            this.this$0.setSelection(length);
                        }
                        return this.this$0.requestFocusProgrammatically();
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                return super.performAccessibilityAction(host, i2, bundle);
            }
        });
        ActionMode.Callback callback = new ActionMode.Callback() { // from class: com.facebook.react.views.textinput.ReactEditText$customActionModeCallback$1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(item, "item");
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(menu, "menu");
                if (this.this$0.contextMenuHidden) {
                    return false;
                }
                menu.removeItem(R.id.pasteAsPlainText);
                return true;
            }
        };
        setCustomSelectionActionModeCallback(callback);
        setCustomInsertionActionModeCallback(callback);
    }

    protected final boolean isSettingTextFromJS() {
        return this.isSettingTextFromJS;
    }

    protected final void setSettingTextFromJS(boolean z) {
        this.isSettingTextFromJS = z;
    }

    protected final int getNativeEventCount() {
        return this.nativeEventCount;
    }

    protected final void setNativeEventCount(int i) {
        this.nativeEventCount = i;
    }

    public final int getStagedInputType() {
        return this.stagedInputType;
    }

    public final void setStagedInputType(int i) {
        this.stagedInputType = i;
    }

    protected final boolean getContainsImages() {
        return this.containsImages;
    }

    protected final void setContainsImages(boolean z) {
        this.containsImages = z;
    }

    public final String getSubmitBehavior() {
        return this.submitBehavior;
    }

    public final void setSubmitBehavior(String str) {
        this.submitBehavior = str;
    }

    public final List<String> getDragAndDropFilter() {
        return this.dragAndDropFilter;
    }

    public final void setDragAndDropFilter(List<String> list) {
        this.dragAndDropFilter = list;
    }

    public final StateWrapper getStateWrapper() {
        return this.stateWrapper;
    }

    public final void setStateWrapper(StateWrapper stateWrapper) {
        this.stateWrapper = stateWrapper;
    }

    public final boolean getDisableTextDiffing$ReactAndroid_release() {
        return this.disableTextDiffing;
    }

    public final void setDisableTextDiffing$ReactAndroid_release(boolean z) {
        this.disableTextDiffing = z;
    }

    protected final void setSettingTextFromState(boolean z) {
        this.isSettingTextFromState = z;
    }

    private final TextWatcherDelegator getTextWatcherDelegator() {
        if (this.textWatcherDelegator == null) {
            this.textWatcherDelegator = new TextWatcherDelegator();
        }
        return this.textWatcherDelegator;
    }

    public final boolean isMultiline$ReactAndroid_release() {
        return (getInputType() & 131072) != 0;
    }

    private final boolean isSecureText() {
        return (getInputType() & 144) != 0;
    }

    public final boolean getDisableFullscreenUI() {
        return this.disableFullscreen;
    }

    public final void setDisableFullscreenUI(boolean z) {
        this.disableFullscreen = z;
        updateImeOptions();
    }

    public final String getReturnKeyType() {
        return this.returnKeyType;
    }

    public final void setReturnKeyType(String str) {
        this.returnKeyType = str;
        updateImeOptions();
    }

    public final int getGravityHorizontal$ReactAndroid_release() {
        return getGravity() & 8388615;
    }

    public final void setGravityHorizontal$ReactAndroid_release(int i) {
        if (i == 0) {
            i = this.defaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & (-8388616)));
    }

    public final int getGravityVertical$ReactAndroid_release() {
        return getGravity() & 112;
    }

    public final void setGravityVertical$ReactAndroid_release(int i) {
        if (i == 0) {
            i = this.defaultGravityVertical;
        }
        setGravity(i | (getGravity() & (-113)));
    }

    protected final void finalize() {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "finalize[" + getId() + "] delete cached spannable");
        }
        TextLayoutManager.INSTANCE.deleteCachedSpannableForTag(getId());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onContentSizeChange();
        if (this.selectTextOnFocus && isFocused()) {
            selectAll();
            this.selectTextOnFocus = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.detectScrollMovement = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2 && this.detectScrollMovement) {
            if (!canScrollVertically(-1) && !canScrollVertically(1) && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.detectScrollMovement = false;
        }
        return super.onTouchEvent(ev);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (i == 66 && !isMultiline$ReactAndroid_release()) {
            hideSoftKeyboard();
            return true;
        }
        return super.onKeyUp(i, event);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        this.textAttributes.setLineHeight(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        ScrollWatcher scrollWatcher = this.scrollWatcher;
        if (scrollWatcher != null) {
            scrollWatcher.onScrollChanged(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (inputConnectionOnCreateInputConnection != null && this.onKeyPress) {
            EventDispatcher eventDispatcher = this.eventDispatcher;
            if (eventDispatcher != null) {
                inputConnectionOnCreateInputConnection = new ReactEditTextInputConnectionWrapper(inputConnectionOnCreateInputConnection, reactContext, this, eventDispatcher);
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        if (isMultiline$ReactAndroid_release() && (shouldBlurOnReturn() || shouldSubmitOnReturn())) {
            outAttrs.imeOptions &= -1073741825;
        }
        return inputConnectionOnCreateInputConnection;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (i == 16908322) {
            i = R.id.pasteAsPlainText;
        }
        return super.onTextContextMenuItem(i);
    }

    public final void clearFocusAndMaybeRefocus$ReactAndroid_release() {
        if (Build.VERSION.SDK_INT > 28 || !isInTouchMode()) {
            super.clearFocus();
        } else {
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            int descendantFocusability = viewGroup.getDescendantFocusability();
            viewGroup.setDescendantFocusability(393216);
            super.clearFocus();
            viewGroup.setDescendantFocusability(descendantFocusability);
        }
        hideSoftKeyboard();
    }

    public final void clearFocusFromJS$ReactAndroid_release() {
        clearFocusAndMaybeRefocus$ReactAndroid_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean requestFocusProgrammatically() {
        boolean zRequestFocus = super.requestFocus(130, null);
        if (isInTouchMode() && getShowSoftInputOnFocus()) {
            showSoftKeyboard();
        }
        return zRequestFocus;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        if (this.listeners == null) {
            this.listeners = new CopyOnWriteArrayList();
            super.addTextChangedListener(getTextWatcherDelegator());
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.add(watcher);
        }
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher watcher) {
        Intrinsics.checkNotNullParameter(watcher, "watcher");
        CopyOnWriteArrayList copyOnWriteArrayList = this.listeners;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(watcher);
            if (copyOnWriteArrayList.isEmpty()) {
                this.listeners = null;
                super.removeTextChangedListener(getTextWatcherDelegator());
            }
        }
    }

    public final void setContentSizeWatcher(ContentSizeWatcher contentSizeWatcher) {
        this.contentSizeWatcher = contentSizeWatcher;
    }

    public final void setScrollWatcher(ScrollWatcher scrollWatcher) {
        this.scrollWatcher = scrollWatcher;
    }

    public final void maybeSetSelection(int i, int i2, int i3) {
        if (canUpdateWithEventCount(i)) {
            maybeSetSelection(i2, i3);
        }
    }

    private final void maybeSetSelection(int i, int i2) {
        if (i == -1 || i2 == -1) {
            return;
        }
        setSelection(clampToTextLength(i), clampToTextLength(i2));
    }

    private final int clampToTextLength(int i) {
        int length;
        if (getText() == null) {
            length = 0;
        } else {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            length = text.length();
        }
        return (int) Math.max(0.0d, Math.min(i, length));
    }

    @Override // android.widget.EditText
    public void setSelection(int i, int i2) {
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "setSelection[" + getId() + "]: " + i + " " + i2);
        }
        super.setSelection(i, i2);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        SelectionWatcher selectionWatcher;
        if (DEBUG_MODE) {
            FLog.e(this.TAG, "onSelectionChanged[" + getId() + "]: " + i + " " + i2);
        }
        super.onSelectionChanged(i, i2);
        if (this.selectionWatcher == null || !hasFocus() || (selectionWatcher = this.selectionWatcher) == null) {
            return;
        }
        selectionWatcher.onSelectionChanged(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        SelectionWatcher selectionWatcher;
        super.onFocusChanged(z, i, rect);
        if (!z || (selectionWatcher = this.selectionWatcher) == null || selectionWatcher == null) {
            return;
        }
        selectionWatcher.onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }

    public final void setSelectionWatcher$ReactAndroid_release(SelectionWatcher selectionWatcher) {
        this.selectionWatcher = selectionWatcher;
    }

    public final void setOnKeyPress(boolean z) {
        this.onKeyPress = z;
    }

    public final boolean shouldBlurOnReturn() {
        String str = this.submitBehavior;
        if (str == null) {
            return !isMultiline$ReactAndroid_release();
        }
        return Intrinsics.areEqual(str, "blurAndSubmit");
    }

    public final boolean shouldSubmitOnReturn() {
        String str = this.submitBehavior;
        if (str == null) {
            return !isMultiline$ReactAndroid_release();
        }
        return Intrinsics.areEqual(str, "submit") || Intrinsics.areEqual(str, "blurAndSubmit");
    }

    public final void commitStagedInputType$ReactAndroid_release() {
        if (getInputType() != this.stagedInputType) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            setInputType(this.stagedInputType);
            maybeSetSelection(selectionStart, selectionEnd);
        }
    }

    @Override // android.widget.TextView
    public void setInputType(int i) {
        Typeface typeface = super.getTypeface();
        super.setInputType(i);
        this.stagedInputType = i;
        super.setTypeface(typeface);
        if (isMultiline$ReactAndroid_release()) {
            setSingleLine(false);
        }
        if (this.keyListener$1 == null) {
            this.keyListener$1 = new InternalKeyListener();
        }
        InternalKeyListener internalKeyListener = this.keyListener$1;
        if (internalKeyListener != null) {
            internalKeyListener.setInputType(i);
        }
        super.setKeyListener(this.keyListener$1);
    }

    public final void setPlaceholder(String str) {
        if (Intrinsics.areEqual(str, this.placeholder)) {
            return;
        }
        this.placeholder = str;
        setHint(str);
    }

    public final void setFontFamily(String str) {
        this.fontFamily = str;
        this.typefaceDirty = true;
    }

    public final void setFontWeight(String str) {
        int fontWeight = ReactTypefaceUtils.parseFontWeight(str);
        if (fontWeight != this.fontWeight) {
            this.fontWeight = fontWeight;
            this.typefaceDirty = true;
        }
    }

    public final void setFontStyle(String str) {
        int fontStyle = ReactTypefaceUtils.parseFontStyle(str);
        if (fontStyle != this.fontStyle) {
            this.fontStyle = fontStyle;
            this.typefaceDirty = true;
        }
    }

    @Override // android.widget.TextView
    public void setFontFeatureSettings(String str) {
        if (Intrinsics.areEqual(str, getFontFeatureSettings())) {
            return;
        }
        super.setFontFeatureSettings(str);
        this.typefaceDirty = true;
    }

    public final void maybeUpdateTypeface() {
        int paintFlags;
        int paintFlags2;
        if (this.typefaceDirty) {
            this.typefaceDirty = false;
            Typeface typeface = getTypeface();
            int i = this.fontStyle;
            int i2 = this.fontWeight;
            String str = this.fontFamily;
            AssetManager assets = getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            setTypeface(ReactTypefaceUtils.applyStyles(typeface, i, i2, str, assets));
            boolean z = (this.fontStyle == -1 && this.fontWeight == -1 && this.fontFamily == null && getFontFeatureSettings() == null) ? false : true;
            if (z) {
                paintFlags = getPaintFlags() | 128;
            } else {
                paintFlags = getPaintFlags() & (-129);
            }
            setPaintFlags(paintFlags);
            if (ReactNativeFeatureFlags.enableAndroidLinearText()) {
                if (z) {
                    paintFlags2 = getPaintFlags() | 64;
                } else {
                    paintFlags2 = getPaintFlags() & (-65);
                }
                setPaintFlags(paintFlags2);
            }
        }
    }

    public final void requestFocusFromJS() {
        requestFocusProgrammatically();
    }

    public final int incrementAndGetEventCounter() {
        int i = this.nativeEventCount + 1;
        this.nativeEventCount = i;
        return i;
    }

    public final void maybeSetTextFromJS(ReactTextUpdate reactTextUpdate) {
        Intrinsics.checkNotNullParameter(reactTextUpdate, "reactTextUpdate");
        this.isSettingTextFromJS = true;
        maybeSetText(reactTextUpdate);
        this.isSettingTextFromJS = false;
    }

    public final void maybeSetTextFromState(ReactTextUpdate reactTextUpdate) {
        Intrinsics.checkNotNullParameter(reactTextUpdate, "reactTextUpdate");
        this.isSettingTextFromState = true;
        maybeSetText(reactTextUpdate);
        this.isSettingTextFromState = false;
    }

    public final boolean canUpdateWithEventCount(int i) {
        return i >= this.nativeEventCount;
    }

    private final void maybeSetText(ReactTextUpdate reactTextUpdate) {
        if (!(isSecureText() && Intrinsics.areEqual(getText(), reactTextUpdate.getText())) && canUpdateWithEventCount(reactTextUpdate.getJsEventCounter())) {
            if (DEBUG_MODE) {
                FLog.e(this.TAG, "maybeSetText[" + getId() + "]: current text: " + ((Object) getText()) + " update: " + ((Object) reactTextUpdate.getText()));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(reactTextUpdate.getText());
            manageSpans(spannableStringBuilder);
            stripStyleEquivalentSpans(spannableStringBuilder);
            this.containsImages = reactTextUpdate.containsImages();
            this.disableTextDiffing = true;
            if (reactTextUpdate.getText().length() == 0) {
                setText((CharSequence) null);
            } else {
                Editable text = getText();
                if (text == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                text.replace(0, length(), spannableStringBuilder);
            }
            this.disableTextDiffing = false;
            if (getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
                setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
            }
            updateCachedSpannable();
        }
    }

    private final void manageSpans(SpannableStringBuilder spannableStringBuilder) {
        Editable text = getText();
        if (text == null) {
            throw new IllegalStateException("Required value was null.");
        }
        for (Object obj : text.getSpans(0, length(), Object.class)) {
            int spanFlags = text.getSpanFlags(obj);
            boolean z = (spanFlags & 33) == 33;
            if (obj instanceof ReactSpan) {
                text.removeSpan(obj);
            }
            if (z) {
                int spanStart = text.getSpanStart(obj);
                int spanEnd = text.getSpanEnd(obj);
                text.removeSpan(obj);
                if (Companion.sameTextForSpan(text, spannableStringBuilder, spanStart, spanEnd)) {
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
        }
    }

    private final void stripStyleEquivalentSpans(SpannableStringBuilder spannableStringBuilder) {
        stripSpansOfKind(spannableStringBuilder, ReactAbsoluteSizeSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$1(this.f$0, (ReactAbsoluteSizeSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactBackgroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$2(this.f$0, (ReactBackgroundColorSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactForegroundColorSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$3(this.f$0, (ReactForegroundColorSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactStrikethroughSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda3
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$4(this.f$0, (ReactStrikethroughSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, ReactUnderlineSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda4
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$5(this.f$0, (ReactUnderlineSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomLetterSpacingSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda5
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$6(this.f$0, (CustomLetterSpacingSpan) obj);
            }
        });
        stripSpansOfKind(spannableStringBuilder, CustomStyleSpan.class, new Predicate() { // from class: com.facebook.react.views.textinput.ReactEditText$$ExternalSyntheticLambda6
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return ReactEditText.stripStyleEquivalentSpans$lambda$7(this.f$0, (CustomStyleSpan) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$1(ReactEditText reactEditText, ReactAbsoluteSizeSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getSize() == reactEditText.textAttributes.getEffectiveFontSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$2(ReactEditText reactEditText, ReactBackgroundColorSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        int backgroundColor = span.getBackgroundColor();
        Integer backgroundColor2 = BackgroundStyleApplicator.getBackgroundColor(reactEditText);
        return backgroundColor2 != null && backgroundColor == backgroundColor2.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$3(ReactEditText reactEditText, ReactForegroundColorSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getForegroundColor() == reactEditText.getCurrentTextColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$4(ReactEditText reactEditText, ReactStrikethroughSpan reactStrikethroughSpan) {
        return (reactEditText.getPaintFlags() & 16) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$5(ReactEditText reactEditText, ReactUnderlineSpan reactUnderlineSpan) {
        return (reactEditText.getPaintFlags() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$6(ReactEditText reactEditText, CustomLetterSpacingSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getSpacing() == reactEditText.textAttributes.getEffectiveLetterSpacing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stripStyleEquivalentSpans$lambda$7(ReactEditText reactEditText, CustomStyleSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        return span.getStyle() == reactEditText.fontStyle && Intrinsics.areEqual(span.getFontFamily(), reactEditText.fontFamily) && span.getWeight() == reactEditText.fontWeight && Intrinsics.areEqual(span.getFontFeatureSettings(), reactEditText.getFontFeatureSettings());
    }

    private final void stripSpansOfKind(SpannableStringBuilder spannableStringBuilder, Class cls, Predicate predicate) {
        Iterator it = ArrayIteratorKt.iterator(spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), cls));
        while (it.hasNext()) {
            Object next = it.next();
            if (predicate.test(next)) {
                spannableStringBuilder.removeSpan(next);
            }
        }
    }

    private final void addSpansFromStyleAttributes(SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new ReactAbsoluteSizeSpan(this.textAttributes.getEffectiveFontSize()), 0, spannableStringBuilder.length(), 16711698);
        spannableStringBuilder.setSpan(new ReactForegroundColorSpan(getCurrentTextColor()), 0, spannableStringBuilder.length(), 16711698);
        Integer backgroundColor = BackgroundStyleApplicator.getBackgroundColor(this);
        if (backgroundColor != null && backgroundColor.intValue() != 0) {
            spannableStringBuilder.setSpan(new ReactBackgroundColorSpan(backgroundColor.intValue()), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 16) != 0) {
            spannableStringBuilder.setSpan(new ReactStrikethroughSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        if ((getPaintFlags() & 8) != 0) {
            spannableStringBuilder.setSpan(new ReactUnderlineSpan(), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLetterSpacing = this.textAttributes.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            spannableStringBuilder.setSpan(new CustomLetterSpacingSpan(effectiveLetterSpacing), 0, spannableStringBuilder.length(), 16711698);
        }
        if (this.fontStyle != -1 || this.fontWeight != -1 || this.fontFamily != null || getFontFeatureSettings() != null) {
            int i = this.fontStyle;
            int i2 = this.fontWeight;
            String fontFeatureSettings = getFontFeatureSettings();
            String str = this.fontFamily;
            AssetManager assets = getContext().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            spannableStringBuilder.setSpan(new CustomStyleSpan(i, i2, fontFeatureSettings, str, assets), 0, spannableStringBuilder.length(), 16711698);
        }
        float effectiveLineHeight = this.textAttributes.getEffectiveLineHeight();
        if (Float.isNaN(effectiveLineHeight)) {
            return;
        }
        spannableStringBuilder.setSpan(new CustomLineHeightSpan(effectiveLineHeight), 0, spannableStringBuilder.length(), 16711698);
    }

    protected final boolean showSoftKeyboard() {
        return this.inputMethodManager.showSoftInput(this, 0);
    }

    protected final void hideSoftKeyboard() {
        this.inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onContentSizeChange() {
        ContentSizeWatcher contentSizeWatcher = this.contentSizeWatcher;
        if (contentSizeWatcher != null) {
            contentSizeWatcher.onLayout();
        }
        setIntrinsicContentSize();
    }

    private final void setIntrinsicContentSize() {
        ReactContext reactContext = UIManagerHelper.getReactContext(this);
        if (ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE || this.stateWrapper != null || reactContext.isBridgeless()) {
            return;
        }
        ReactTextInputLocalData reactTextInputLocalData = new ReactTextInputLocalData(this);
        UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.setViewLocalData(getId(), reactTextInputLocalData);
        }
    }

    private final void updateImeOptions() {
        String str = this.returnKeyType;
        int i = 6;
        if (str != null) {
            switch (str.hashCode()) {
                case -1273775369:
                    if (str.equals("previous")) {
                        i = 7;
                    }
                    break;
                case -906336856:
                    if (str.equals("search")) {
                        i = 3;
                    }
                    break;
                case 3304:
                    if (str.equals("go")) {
                        i = 2;
                    }
                    break;
                case 3089282:
                    str.equals("done");
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        i = 5;
                    }
                    break;
                case 3387192:
                    if (str.equals("none")) {
                        i = 1;
                    }
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        i = 4;
                    }
                    break;
            }
        }
        if (this.disableFullscreen) {
            i |= 33554432;
        }
        setImeOptions(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                if (((TextInlineImageSpan) it.next()).getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                if (((TextInlineImageSpan) it.next()).getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                ((TextInlineImageSpan) it.next()).onDetachedFromWindow();
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                ((TextInlineImageSpan) it.next()).onStartTemporaryDetach();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (ReactNativeNewArchitectureFeatureFlags.enableBridgelessArchitecture() && ReactNativeFeatureFlags.enableFontScaleChangesUpdatingLayout()) {
            applyTextAttributes();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        super.setTextIsSelectable(true);
        maybeSetSelection(selectionStart, selectionEnd);
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                ((TextInlineImageSpan) it.next()).onAttachedToWindow();
            }
        }
        if (this.autoFocus && !this.didAttachToWindow) {
            requestFocusProgrammatically();
        }
        this.didAttachToWindow = true;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.containsImages) {
            Editable text = getText();
            if (text == null) {
                throw new IllegalStateException("Required value was null.");
            }
            Iterator it = ArrayIteratorKt.iterator((TextInlineImageSpan[]) text.getSpans(0, text.length(), TextInlineImageSpan.class));
            while (it.hasNext()) {
                ((TextInlineImageSpan) it.next()).onFinishTemporaryDetach();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        BackgroundStyleApplicator.setBackgroundColor(this, Integer.valueOf(i));
    }

    public final void setBorderRadius(float f) {
        setBorderRadius(f, BorderRadiusProp.BORDER_RADIUS.ordinal());
    }

    public final void setBorderRadius(float f, int i) {
        BackgroundStyleApplicator.setBorderRadius(this, (BorderRadiusProp) BorderRadiusProp.getEntries().get(i), Float.isNaN(f) ? null : new LengthPercentage(PixelUtil.toDIPFromPixel(f), LengthPercentageType.POINT));
    }

    public final void setBorderStyle(String str) {
        BackgroundStyleApplicator.setBorderStyle(this, str == null ? null : BorderStyle.Companion.fromString(str));
    }

    public final void setLetterSpacingPt(float f) {
        this.textAttributes.setLetterSpacing(f);
        applyTextAttributes();
    }

    public final void setAllowFontScaling(boolean z) {
        if (this.textAttributes.getAllowFontScaling() != z) {
            this.textAttributes.setAllowFontScaling(z);
            applyTextAttributes();
        }
    }

    public final void setFontSize(float f) {
        this.textAttributes.setFontSize(f);
        applyTextAttributes();
    }

    public final void setMaxFontSizeMultiplier(float f) {
        if (f == this.textAttributes.getMaxFontSizeMultiplier()) {
            return;
        }
        this.textAttributes.setMaxFontSizeMultiplier(f);
        applyTextAttributes();
    }

    public final void setAutoFocus(boolean z) {
        this.autoFocus = z;
    }

    public final void setSelectTextOnFocus(boolean z) {
        super.setSelectAllOnFocus(z);
        this.selectTextOnFocus = z;
    }

    public final void setContextMenuHidden(boolean z) {
        this.contextMenuHidden = z;
    }

    protected final void applyTextAttributes() {
        setTextSize(0, this.textAttributes.getEffectiveFontSize());
        float effectiveLetterSpacing = this.textAttributes.getEffectiveLetterSpacing();
        if (Float.isNaN(effectiveLetterSpacing)) {
            return;
        }
        setLetterSpacing(effectiveLetterSpacing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    public final void updateCachedSpannable() {
        if (this.stateWrapper == null || getId() == -1) {
            return;
        }
        Editable text = getText();
        boolean z = text == null || text.length() == 0;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (text != null && !z) {
            try {
                spannableStringBuilder.append(text.subSequence(0, text.length()));
            } catch (IndexOutOfBoundsException e) {
                ReactSoftExceptionLogger.logSoftException(this.TAG, e);
            }
        }
        if (z) {
            if (getHint() != null) {
                CharSequence hint = getHint();
                Intrinsics.checkNotNullExpressionValue(hint, "getHint(...)");
                if (hint.length() > 0) {
                    spannableStringBuilder.append(getHint());
                } else if (ViewUtil.getUIManagerType(this) != 2) {
                    spannableStringBuilder.append("I");
                }
            } else if (ViewUtil.getUIManagerType(this) != 2) {
                spannableStringBuilder.append("I");
            }
        }
        addSpansFromStyleAttributes(spannableStringBuilder);
        spannableStringBuilder.setSpan(new ReactTextPaintHolderSpan(new TextPaint(getPaint())), 0, spannableStringBuilder.length(), 18);
        TextLayoutManager.INSTANCE.setCachedSpannableForTag(getId(), spannableStringBuilder);
    }

    public final void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public final void setOverflow(String str) {
        if (str == null) {
            this.overflow = Overflow.VISIBLE;
        } else {
            Overflow overflowFromString = Overflow.Companion.fromString(str);
            if (overflowFromString == null) {
                overflowFromString = Overflow.VISIBLE;
            }
            this.overflow = overflowFromString;
        }
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.overflow != Overflow.VISIBLE) {
            BackgroundStyleApplicator.clipToPaddingBox(this, canvas);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List list = this.dragAndDropFilter;
        if (list != null && event.getAction() == 1) {
            List list2 = list;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (event.getClipDescription().hasMimeType((String) it.next())) {
                }
            }
            return false;
        }
        return super.onDragEvent(event);
    }

    private final class TextWatcherDelegator implements TextWatcher {
        public TextWatcherDelegator() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.this.isSettingTextFromJS() || (copyOnWriteArrayList = ReactEditText.this.listeners) == null) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).beforeTextChanged(s, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.Companion.getDEBUG_MODE()) {
                FLog.e(ReactEditText.this.TAG, "onTextChanged[" + ReactEditText.this.getId() + "]: " + ((Object) s) + " " + i + " " + i2 + " " + i3);
            }
            if (!ReactEditText.this.isSettingTextFromJS() && (copyOnWriteArrayList = ReactEditText.this.listeners) != null) {
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    ((TextWatcher) it.next()).onTextChanged(s, i, i2, i3);
                }
            }
            ReactEditText.this.updateCachedSpannable();
            ReactEditText.this.onContentSizeChange();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            CopyOnWriteArrayList copyOnWriteArrayList;
            Intrinsics.checkNotNullParameter(s, "s");
            if (ReactEditText.this.isSettingTextFromJS() || (copyOnWriteArrayList = ReactEditText.this.listeners) == null) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TextWatcher) it.next()).afterTextChanged(s);
            }
        }
    }

    private static final class InternalKeyListener implements KeyListener {
        private int _inputType;

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return this._inputType;
        }

        public final void setInputType(int i) {
            this._inputType = i;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable text, int i, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyDown(view, text, i, event);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable text, int i, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyUp(view, text, i, event);
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyOther(View view, Editable text, KeyEvent event) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(event, "event");
            return ReactEditText.keyListener.onKeyOther(view, text, event);
        }

        @Override // android.text.method.KeyListener
        public void clearMetaKeyState(View view, Editable content, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(content, "content");
            ReactEditText.keyListener.clearMetaKeyState(view, content, i);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getDEBUG_MODE() {
            return ReactEditText.DEBUG_MODE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean sameTextForSpan(Editable editable, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            if (i > spannableStringBuilder.length() || i2 > spannableStringBuilder.length()) {
                return false;
            }
            while (i < i2) {
                if (editable.charAt(i) != spannableStringBuilder.charAt(i)) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }

    static {
        ReactBuildConfig reactBuildConfig = ReactBuildConfig.INSTANCE;
        DEBUG_MODE = false;
        QwertyKeyListener instanceForFullKeyboard = QwertyKeyListener.getInstanceForFullKeyboard();
        Intrinsics.checkNotNullExpressionValue(instanceForFullKeyboard, "getInstanceForFullKeyboard(...)");
        keyListener = instanceForFullKeyboard;
    }
}

package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager {
    private ClipboardManager clipboardManager;
    private final MutableState currentDragPosition$delegate;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private TextFieldValue oldValue;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private OffsetMapping offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
    private Function1 onValueChange = new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
        public final void invoke(TextFieldValue textFieldValue) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextFieldValue) obj);
            return Unit.INSTANCE;
        }
    };
    private final MutableState value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
    private VisualTransformation visualTransformation = VisualTransformation.Companion.getNone();

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        Boolean bool = Boolean.TRUE;
        this.editable$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.enabled$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        Offset.Companion companion = Offset.Companion;
        this.dragBeginPosition = companion.m1235getZeroF1C5BW0();
        this.dragTotalDistance = companion.m1235getZeroF1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo526onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo528onStartk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                if (this.this$0.getEnabled() && this.this$0.getDraggingHandle() == null) {
                    this.this$0.setDraggingHandle(Handle.SelectionEnd);
                    this.this$0.previousRawDragOffset = -1;
                    this.this$0.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                    if (state$foundation_release == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null || !layoutResult2.m554isPositionOnTextk4lQ0M(j)) {
                        j2 = j;
                        LegacyTextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                        if (state$foundation_release2 != null && (layoutResult = state$foundation_release2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                            int iTransformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m552getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, null));
                            TextFieldValue textFieldValueM643createTextFieldValueFDrldGo = textFieldSelectionManager.m643createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo1674performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1678getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(textFieldValueM643createTextFieldValueFDrldGo);
                        }
                    } else {
                        if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                            return;
                        }
                        this.this$0.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                        j2 = j;
                        this.this$0.dragBeginOffsetInText = Integer.valueOf(TextRange.m2217getStartimpl(textFieldSelectionManager2.m646updateSelection8UEBfa8(TextFieldValue.m2374copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.m2222getZerod9O1mEE(), (TextRange) null, 5, (Object) null), j, true, false, SelectionAdjustment.Companion.getWord(), true)));
                    }
                    this.this$0.setHandleState(HandleState.None);
                    this.this$0.dragBeginPosition = j2;
                    TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                    textFieldSelectionManager3.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(textFieldSelectionManager3.dragBeginPosition));
                    this.this$0.dragTotalDistance = Offset.Companion.m1235getZeroF1C5BW0();
                }
            }

            /* JADX WARN: Code duplicated, block: B:21:0x00b4  */
            /* JADX WARN: Code duplicated, block: B:23:0x00bb  */
            /* JADX WARN: Code duplicated, block: B:24:0x00c0  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo527onDragk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                Integer num;
                int iM553getOffsetForPosition3MmeM6k;
                long jM646updateSelection8UEBfa8;
                SelectionAdjustment word;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1228plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                    textFieldSelectionManager2.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(Offset.m1228plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                    if (textFieldSelectionManager2.dragBeginOffsetInText != null) {
                        num = textFieldSelectionManager2.dragBeginOffsetInText;
                        if (num != null) {
                            iM553getOffsetForPosition3MmeM6k = num.intValue();
                        } else {
                            iM553getOffsetForPosition3MmeM6k = layoutResult.m553getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                        }
                        Offset offsetM648getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E);
                        int iM553getOffsetForPosition3MmeM6k2 = layoutResult.m553getOffsetForPosition3MmeM6k(offsetM648getCurrentDragPosition_m7T9E.m1232unboximpl(), false);
                        if (textFieldSelectionManager2.dragBeginOffsetInText != null) {
                        }
                        TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                        Offset offsetM648getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E2);
                        jM646updateSelection8UEBfa8 = textFieldSelectionManager2.m646updateSelection8UEBfa8(value$foundation_release, offsetM648getCurrentDragPosition_m7T9E2.m1232unboximpl(), false, false, SelectionAdjustment.Companion.getWord(), true);
                    } else {
                        Offset offsetM648getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E3);
                        if (layoutResult.m554isPositionOnTextk4lQ0M(offsetM648getCurrentDragPosition_m7T9E3.m1232unboximpl())) {
                            num = textFieldSelectionManager2.dragBeginOffsetInText;
                            if (num != null) {
                                iM553getOffsetForPosition3MmeM6k = num.intValue();
                            } else {
                                iM553getOffsetForPosition3MmeM6k = layoutResult.m553getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                            }
                            Offset offsetM648getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E4);
                            int iM553getOffsetForPosition3MmeM6k3 = layoutResult.m553getOffsetForPosition3MmeM6k(offsetM648getCurrentDragPosition_m7T9E4.m1232unboximpl(), false);
                            if (textFieldSelectionManager2.dragBeginOffsetInText != null && iM553getOffsetForPosition3MmeM6k == iM553getOffsetForPosition3MmeM6k3) {
                                return;
                            }
                            TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                            Offset offsetM648getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E5);
                            jM646updateSelection8UEBfa8 = textFieldSelectionManager2.m646updateSelection8UEBfa8(value$foundation_release2, offsetM648getCurrentDragPosition_m7T9E5.m1232unboximpl(), false, false, SelectionAdjustment.Companion.getWord(), true);
                        } else {
                            int iTransformedToOriginal = textFieldSelectionManager2.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m552getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager2.dragBeginPosition, false, 2, null));
                            OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                            Offset offsetM648getCurrentDragPosition_m7T9E6 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E6);
                            if (iTransformedToOriginal == offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m552getOffsetForPosition3MmeM6k$default(layoutResult, offsetM648getCurrentDragPosition_m7T9E6.m1232unboximpl(), false, 2, null))) {
                                word = SelectionAdjustment.Companion.getNone();
                            } else {
                                word = SelectionAdjustment.Companion.getWord();
                            }
                            SelectionAdjustment selectionAdjustment = word;
                            TextFieldValue value$foundation_release3 = textFieldSelectionManager2.getValue$foundation_release();
                            Offset offsetM648getCurrentDragPosition_m7T9E7 = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E7);
                            jM646updateSelection8UEBfa8 = textFieldSelectionManager2.m646updateSelection8UEBfa8(value$foundation_release3, offsetM648getCurrentDragPosition_m7T9E7.m1232unboximpl(), false, false, selectionAdjustment, true);
                        }
                    }
                    TextRange.m2205boximpl(jM646updateSelection8UEBfa8);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            private final void onEnd() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m645setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
                this.this$0.dragBeginOffsetInText = null;
                boolean zM2211getCollapsedimpl = TextRange.m2211getCollapsedimpl(this.this$0.getValue$foundation_release().m2379getSelectiond9O1mEE());
                this.this$0.setHandleState(zM2211getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowSelectionHandleStart(!zM2211getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true));
                }
                LegacyTextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    state$foundation_release2.setShowSelectionHandleEnd(!zM2211getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, false));
                }
                LegacyTextFieldState state$foundation_release3 = this.this$0.getState$foundation_release();
                if (state$foundation_release3 == null) {
                    return;
                }
                state$foundation_release3.setShowCursorHandle(zM2211getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true));
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtend-k-4lQ0M */
            public boolean mo628onExtendk4lQ0M(long j) {
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || state$foundation_release.getLayoutResult() == null || !this.this$0.getEnabled()) {
                    return false;
                }
                this.this$0.previousRawDragOffset = -1;
                updateMouseSelection(this.this$0.getValue$foundation_release(), j, false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo629onExtendDragk4lQ0M(long j) {
                LegacyTextFieldState state$foundation_release;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation_release(), j, false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onStart-3MmeM6k */
            public boolean mo630onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState state$foundation_release;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = this.this$0.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                this.this$0.dragBeginPosition = j;
                this.this$0.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(this.this$0, false, 1, null);
                updateMouseSelection(this.this$0.getValue$foundation_release(), this.this$0.dragBeginPosition, true, selectionAdjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* JADX INFO: renamed from: onDrag-3MmeM6k */
            public boolean mo627onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState state$foundation_release;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = this.this$0.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation_release(), j, false, selectionAdjustment);
                return true;
            }

            public final void updateMouseSelection(TextFieldValue textFieldValue, long j, boolean z, SelectionAdjustment selectionAdjustment) {
                this.this$0.setHandleState(TextRange.m2211getCollapsedimpl(this.this$0.m646updateSelection8UEBfa8(textFieldValue, j, z, false, selectionAdjustment, false)) ? HandleState.Cursor : HandleState.Selection);
            }
        };
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final Function1 getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1 function1) {
        this.onValueChange = function1;
    }

    public final LegacyTextFieldState getState$foundation_release() {
        return this.state;
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value$delegate.setValue(textFieldValue);
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m645setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* JADX INFO: renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m648getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean z) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo528onStartk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo526onDownk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                this.this$0.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
                long jM632getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m632getAdjustedCoordinatesk4lQ0M(this.this$0.m650getHandlePositiontuRUvjQ$foundation_release(z));
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m556translateInnerToDecorationCoordinatesMKHz9U$foundation_release(jM632getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                this.this$0.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                this.this$0.dragTotalDistance = Offset.Companion.m1235getZeroF1C5BW0();
                this.this$0.previousRawDragOffset = -1;
                LegacyTextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    state$foundation_release2.setInTouchMode(true);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m645setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo527onDragk4lQ0M(long j) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1228plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(Offset.m1228plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, this.this$0.dragTotalDistance)));
                TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset offsetM648getCurrentDragPosition_m7T9E = this.this$0.m648getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m646updateSelection8UEBfa8(value$foundation_release, offsetM648getCurrentDragPosition_m7T9E.m1232unboximpl(), false, z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m645setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDown-k-4lQ0M */
            public void mo526onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m645setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onStart-k-4lQ0M */
            public void mo528onStartk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                long jM632getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m632getAdjustedCoordinatesk4lQ0M(this.this$0.m650getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m556translateInnerToDecorationCoordinatesMKHz9U$foundation_release(jM632getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                this.this$0.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(jM556translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                this.this$0.dragTotalDistance = Offset.Companion.m1235getZeroF1C5BW0();
                this.this$0.setDraggingHandle(Handle.Cursor);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* JADX INFO: renamed from: onDrag-k-4lQ0M */
            public void mo527onDragk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m1228plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
                LegacyTextFieldState state$foundation_release = this.this$0.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m645setCurrentDragPosition_kEHs6E(Offset.m1214boximpl(Offset.m1228plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                Offset offsetM648getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m648getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(offsetM648getCurrentDragPosition_m7T9E);
                int iTransformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m552getOffsetForPosition3MmeM6k$default(layoutResult, offsetM648getCurrentDragPosition_m7T9E.m1232unboximpl(), false, 2, null));
                long jTextRange = TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal);
                if (TextRange.m2210equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation_release().m2379getSelectiond9O1mEE())) {
                    return;
                }
                LegacyTextFieldState state$foundation_release2 = textFieldSelectionManager2.getState$foundation_release();
                if ((state$foundation_release2 == null || state$foundation_release2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo1674performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1678getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(textFieldSelectionManager2.m643createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), jTextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m645setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean z) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(z);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m644deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m647deselect_kEHs6E$foundation_release(offset);
    }

    /* JADX INFO: renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m647deselect_kEHs6E$foundation_release(Offset offset) {
        int iM2214getMaximpl;
        if (!TextRange.m2211getCollapsedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (offset != null && layoutResult != null) {
                iM2214getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m552getOffsetForPosition3MmeM6k$default(layoutResult, offset.m1232unboximpl(), false, 2, null));
            } else {
                iM2214getMaximpl = TextRange.m2214getMaximpl(getValue$foundation_release().m2379getSelectiond9O1mEE());
            }
            this.onValueChange.invoke(TextFieldValue.m2374copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(iM2214getMaximpl), (TextRange) null, 5, (Object) null));
        }
        setHandleState((offset == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* JADX INFO: renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m652setSelectionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m490setSelectionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m488setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m2222getZerod9O1mEE());
        }
        if (TextRange.m2211getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    /* JADX INFO: renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m651setDeletionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m488setDeletionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m490setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m2222getZerod9O1mEE());
        }
        if (TextRange.m2211getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m488setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m2222getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.m490setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m2222getZerod9O1mEE());
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.copy$foundation_release(z);
    }

    public final void copy$foundation_release(boolean z) {
        if (TextRange.m2211getCollapsedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (z) {
            int iM2214getMaximpl = TextRange.m2214getMaximpl(getValue$foundation_release().m2379getSelectiond9O1mEE());
            this.onValueChange.invoke(m643createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iM2214getMaximpl, iM2214getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int iM2215getMinimpl = TextRange.m2215getMinimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()) + text.length();
        this.onValueChange.invoke(m643createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM2215getMinimpl, iM2215getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void cut$foundation_release() {
        if (TextRange.m2211getCollapsedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int iM2215getMinimpl = TextRange.m2215getMinimpl(getValue$foundation_release().m2379getSelectiond9O1mEE());
        this.onValueChange.invoke(m643createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM2215getMinimpl, iM2215getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue textFieldValueM643createTextFieldValueFDrldGo = m643createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(textFieldValueM643createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m2374copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, textFieldValueM643createTextFieldValueFDrldGo.m2379getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    /* JADX INFO: renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m650getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m1234getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.Companion.m1234getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.Companion.m1234getUnspecifiedF1C5BW0();
        }
        long jM2379getSelectiond9O1mEE = getValue$foundation_release().m2379getSelectiond9O1mEE();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(z ? TextRange.m2217getStartimpl(jM2379getSelectiond9O1mEE) : TextRange.m2212getEndimpl(jM2379getSelectiond9O1mEE)), z, TextRange.m2216getReversedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()));
    }

    /* JADX INFO: renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m649getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m2217getStartimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(iOriginalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset(cursorRect.getLeft() + (density.mo231toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2), cursorRect.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean z) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(z);
        }
        if (z) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        ClipboardManager clipboardManager;
        if (getEnabled()) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            if (legacyTextFieldState == null || legacyTextFieldState.isInTouchMode()) {
                Function0 function0 = !TextRange.m2211getCollapsedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()) ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m653invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m653invoke() {
                        TextFieldSelectionManager.copy$foundation_release$default(this.this$0, false, 1, null);
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                } : null;
                Function0 function1 = (TextRange.m2211getCollapsedimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()) || !getEditable()) ? null : new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m654invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m654invoke() {
                        this.this$0.cut$foundation_release();
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                };
                Function0 function2 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m655invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m655invoke() {
                        this.this$0.paste$foundation_release();
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                } : null;
                Function0 function3 = TextRange.m2213getLengthimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()) != getValue$foundation_release().getText().length() ? new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m656invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m656invoke() {
                        this.this$0.selectAll$foundation_release();
                    }
                } : null;
                TextToolbar textToolbar = this.textToolbar;
                if (textToolbar != null) {
                    textToolbar.showMenu(getContentRect(), function0, function2, function1, function3);
                }
            }
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    private final Rect getContentRect() {
        float fM1224getYimpl;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.isLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m2217getStartimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()));
                int iOriginalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m2212getEndimpl(getValue$foundation_release().m2379getSelectiond9O1mEE()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long jM1235getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.Companion.m1235getZeroF1C5BW0() : layoutCoordinates4.mo1848localToRootMKHz9U(m650getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long jM1235getZeroF1C5BW1 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.Companion.m1235getZeroF1C5BW0() : layoutCoordinates3.mo1848localToRootMKHz9U(m650getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float fM1224getYimpl2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    fM1224getYimpl = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    fM1224getYimpl = Offset.m1224getYimpl(layoutCoordinates2.mo1848localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(iOriginalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    fM1224getYimpl2 = Offset.m1224getYimpl(layoutCoordinates.mo1848localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(iOriginalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())));
                }
                return new Rect(Math.min(Offset.m1223getXimpl(jM1235getZeroF1C5BW0), Offset.m1223getXimpl(jM1235getZeroF1C5BW1)), Math.min(fM1224getYimpl, fM1224getYimpl2), Math.max(Offset.m1223getXimpl(jM1235getZeroF1C5BW0), Offset.m1223getXimpl(jM1235getZeroF1C5BW1)), Math.max(Offset.m1224getYimpl(jM1235getZeroF1C5BW0), Offset.m1224getYimpl(jM1235getZeroF1C5BW1)) + (Dp.m2551constructorimpl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.Companion.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m646updateSelection8UEBfa8(TextFieldValue textFieldValue, long j, boolean z, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Companion.m2222getZerod9O1mEE();
        }
        long jTextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m2217getStartimpl(textFieldValue.m2379getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m2212getEndimpl(textFieldValue.m2379getSelectiond9O1mEE())));
        boolean z4 = false;
        int iM553getOffsetForPosition3MmeM6k = layoutResult.m553getOffsetForPosition3MmeM6k(j, false);
        int iM2217getStartimpl = (z2 || z) ? iM553getOffsetForPosition3MmeM6k : TextRange.m2217getStartimpl(jTextRange);
        int iM2212getEndimpl = (!z2 || z) ? iM553getOffsetForPosition3MmeM6k : TextRange.m2212getEndimpl(jTextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (z || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout selectionLayoutM633getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m633getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), iM2217getStartimpl, iM2212getEndimpl, i, jTextRange, z, z2);
        if (!selectionLayoutM633getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return textFieldValue.m2379getSelectiond9O1mEE();
        }
        this.previousSelectionLayout = selectionLayoutM633getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = iM553getOffsetForPosition3MmeM6k;
        Selection selectionAdjust = selectionAdjustment.adjust(selectionLayoutM633getTextFieldSelectionLayoutRcvTLA);
        long jTextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(selectionAdjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(selectionAdjust.getEnd().getOffset()));
        if (TextRange.m2210equalsimpl0(jTextRange2, textFieldValue.m2379getSelectiond9O1mEE())) {
            return textFieldValue.m2379getSelectiond9O1mEE();
        }
        boolean z5 = TextRange.m2216getReversedimpl(jTextRange2) != TextRange.m2216getReversedimpl(textFieldValue.m2379getSelectiond9O1mEE()) && TextRange.m2210equalsimpl0(TextRangeKt.TextRange(TextRange.m2212getEndimpl(jTextRange2), TextRange.m2217getStartimpl(jTextRange2)), textFieldValue.m2379getSelectiond9O1mEE());
        boolean z6 = TextRange.m2211getCollapsedimpl(jTextRange2) && TextRange.m2211getCollapsedimpl(textFieldValue.m2379getSelectiond9O1mEE());
        if (z3 && textFieldValue.getText().length() > 0 && !z5 && !z6 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo1674performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m1678getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m643createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), jTextRange2));
        if (!z3) {
            updateFloatingToolbar(!TextRange.m2211getCollapsedimpl(jTextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(z3);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m2211getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m2211getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 == null) {
            return jTextRange2;
        }
        if (TextRange.m2211getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
            z4 = true;
        }
        legacyTextFieldState5.setShowCursorHandle(z4);
        return jTextRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m643createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}

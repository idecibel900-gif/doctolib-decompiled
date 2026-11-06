package com.swmansion.enriched.markdown.input.editing;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputConnectionWrapper extends android.view.inputmethod.InputConnectionWrapper {
    public static final Companion Companion = new Companion(null);
    private final EnrichedMarkdownTextInputView editText;
    private boolean isBatchEdit;
    private String pendingKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputConnectionWrapper(InputConnection target, EnrichedMarkdownTextInputView editText) {
        super(target, false);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.isBatchEdit = true;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        this.isBatchEdit = false;
        String str = this.pendingKey;
        if (str != null) {
            dispatchKeyPress(str);
            this.pendingKey = null;
        }
        return super.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int i) {
        String strCodePointBeforeCursor;
        Intrinsics.checkNotNullParameter(text, "text");
        int selectionStart = this.editText.getSelectionStart();
        int selectionEnd = this.editText.getSelectionEnd();
        boolean composingText = super.setComposingText(text, i);
        int selectionStart2 = this.editText.getSelectionStart();
        boolean z = selectionStart == selectionEnd;
        boolean z2 = selectionStart2 == selectionStart;
        if (selectionStart2 < selectionStart || selectionStart2 <= 0 || (!z && z2)) {
            strCodePointBeforeCursor = "Backspace";
        } else {
            strCodePointBeforeCursor = codePointBeforeCursor(selectionStart2);
        }
        if (strCodePointBeforeCursor.length() > 0) {
            dispatchKeyPressOrEnqueue(strCodePointBeforeCursor);
        }
        return composingText;
    }

    private final String codePointBeforeCursor(int i) {
        int iCoerceAtMost;
        Editable text = this.editText.getText();
        if (text == null || (iCoerceAtMost = RangesKt.coerceAtMost(i, text.length())) < 1) {
            return "";
        }
        char[] chars = Character.toChars(Character.codePointBefore(text, iCoerceAtMost));
        Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
        return new String(chars);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        String string = text.toString();
        if (string.length() <= 2) {
            if (string.length() == 0) {
                string = "Backspace";
            }
            dispatchKeyPressOrEnqueue(string);
        }
        return super.commitText(text, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        dispatchKeyPress("Backspace");
        if (i == 1 && i2 == 0 && this.editText.deleteLinkBeforeCursor()) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            int unicodeChar = event.getUnicodeChar();
            boolean z = false;
            if (48 <= unicodeChar && unicodeChar < 58) {
                z = true;
            }
            int keyCode = event.getKeyCode();
            if (keyCode == 66) {
                dispatchKeyPress("Enter");
            } else if (keyCode == 67) {
                dispatchKeyPress("Backspace");
            } else if (z) {
                dispatchKeyPress(String.valueOf(event.getNumber()));
            }
            if (event.getKeyCode() == 67 && this.editText.deleteLinkBeforeCursor()) {
                return true;
            }
        }
        return super.sendKeyEvent(event);
    }

    private final void dispatchKeyPressOrEnqueue(String str) {
        if (this.isBatchEdit) {
            this.pendingKey = str;
        } else {
            dispatchKeyPress(str);
        }
    }

    private final void dispatchKeyPress(String str) {
        if (Intrinsics.areEqual(str, "\n")) {
            str = "Enter";
        } else if (Intrinsics.areEqual(str, "\t")) {
            str = "Tab";
        }
        this.editText.getEventEmitter().emitKeyPress(str);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

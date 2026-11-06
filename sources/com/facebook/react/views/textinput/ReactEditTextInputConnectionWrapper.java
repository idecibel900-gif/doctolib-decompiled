package com.facebook.react.views.textinput;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactEditTextInputConnectionWrapper extends InputConnectionWrapper {
    public static final Companion Companion = new Companion(null);
    private final ReactEditText editText;
    private final EventDispatcher eventDispatcher;
    private boolean isBatchEdit;
    private String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactEditTextInputConnectionWrapper(InputConnection target, ReactContext reactContext, ReactEditText editText, EventDispatcher eventDispatcher) {
        super(target, false);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        this.editText = editText;
        this.eventDispatcher = eventDispatcher;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.isBatchEdit = true;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        this.isBatchEdit = false;
        String str = this.key;
        if (str != null) {
            dispatchKeyEvent(str);
            this.key = null;
        }
        return super.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int i) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(text, "text");
        int selectionStart = this.editText.getSelectionStart();
        int selectionEnd = this.editText.getSelectionEnd();
        boolean composingText = super.setComposingText(text, i);
        int selectionStart2 = this.editText.getSelectionStart();
        boolean z = selectionStart == selectionEnd;
        boolean z2 = selectionStart2 == selectionStart;
        if (selectionStart2 < selectionStart || selectionStart2 <= 0 || (!z && z2)) {
            strValueOf = "Backspace";
        } else {
            Editable text2 = this.editText.getText();
            strValueOf = String.valueOf(text2 != null ? Character.valueOf(text2.charAt(selectionStart2 - 1)) : null);
        }
        dispatchKeyEventOrEnqueue(strValueOf);
        return composingText;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        String string = text.toString();
        if (string.length() <= 2) {
            if (string.length() == 0) {
                string = "Backspace";
            }
            dispatchKeyEventOrEnqueue(string);
        }
        return super.commitText(text, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        dispatchKeyEvent("Backspace");
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
                dispatchKeyEvent("Enter");
            } else if (keyCode == 67) {
                dispatchKeyEvent("Backspace");
            } else if (z) {
                dispatchKeyEvent(String.valueOf(event.getNumber()));
            }
        }
        return super.sendKeyEvent(event);
    }

    private final void dispatchKeyEventOrEnqueue(String str) {
        if (this.isBatchEdit) {
            this.key = str;
        } else {
            dispatchKeyEvent(str);
        }
    }

    private final void dispatchKeyEvent(String str) {
        if (Intrinsics.areEqual(str, "\n")) {
            str = "Enter";
        }
        this.eventDispatcher.dispatchEvent(new ReactTextInputKeyPressEvent(UIManagerHelper.getSurfaceId(this.editText), this.editText.getId(), str));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

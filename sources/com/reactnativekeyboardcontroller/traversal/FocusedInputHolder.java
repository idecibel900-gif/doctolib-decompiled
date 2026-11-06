package com.reactnativekeyboardcontroller.traversal;

import android.widget.EditText;
import com.reactnativekeyboardcontroller.extensions.EditTextKt;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FocusedInputHolder {
    public static final FocusedInputHolder INSTANCE = new FocusedInputHolder();
    private static WeakReference input;

    private FocusedInputHolder() {
    }

    public final void set(EditText textInput) {
        Intrinsics.checkNotNullParameter(textInput, "textInput");
        input = new WeakReference(textInput);
    }

    public final EditText get() {
        WeakReference weakReference = input;
        if (weakReference != null) {
            return (EditText) weakReference.get();
        }
        return null;
    }

    public final void focus() {
        EditText editText;
        WeakReference weakReference = input;
        if (weakReference == null || (editText = (EditText) weakReference.get()) == null) {
            return;
        }
        EditTextKt.focus(editText);
    }
}

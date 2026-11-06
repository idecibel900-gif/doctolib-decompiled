package com.reactnativekeyboardcontroller.extensions;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KeyboardControllerSelectionWatcher {
    private final Function6 action;
    private final EditText editText;
    private int lastEditTextHeight;
    private int lastSelectionEnd;
    private int lastSelectionStart;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;

    public KeyboardControllerSelectionWatcher(EditText editText, Function6 action) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(action, "action");
        this.editText = editText;
        this.action = action;
        this.lastSelectionStart = -1;
        this.lastSelectionEnd = -1;
        this.lastEditTextHeight = -1;
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.reactnativekeyboardcontroller.extensions.KeyboardControllerSelectionWatcher$preDrawListener$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                int paddingTop;
                int paddingTop2;
                Drawable textCursorDrawable;
                int selectionStart = this.this$0.editText.getSelectionStart();
                int selectionEnd = this.this$0.editText.getSelectionEnd();
                int height = this.this$0.editText.getHeight();
                EditText editText2 = this.this$0.editText;
                Layout layout = editText2.getLayout();
                if (layout == null) {
                    return true;
                }
                if (this.this$0.lastSelectionStart != selectionStart || this.this$0.lastSelectionEnd != selectionEnd || this.this$0.lastEditTextHeight != height) {
                    this.this$0.lastSelectionStart = selectionStart;
                    this.this$0.lastSelectionEnd = selectionEnd;
                    this.this$0.lastEditTextHeight = height;
                    int iMin = Math.min(selectionStart, selectionEnd);
                    int iMax = Math.max(selectionStart, selectionEnd);
                    int lineTop = layout.getLineTop(layout.getLineForOffset(iMin));
                    int height2 = layout.getHeight();
                    int intrinsicWidth = 0;
                    if (Build.VERSION.SDK_INT >= 29 && (textCursorDrawable = editText2.getTextCursorDrawable()) != null) {
                        intrinsicWidth = textCursorDrawable.getIntrinsicWidth();
                    }
                    int gravity = this.this$0.editText.getGravity() & 112;
                    int paddingTop3 = this.this$0.editText.getPaddingTop() + this.this$0.editText.getPaddingBottom();
                    int lineHeight = this.this$0.editText.getLineHeight() / 2;
                    int i = height - paddingTop3;
                    if (height2 > i) {
                        paddingTop = this.this$0.editText.getPaddingTop();
                    } else if (gravity == 16) {
                        paddingTop = ((i - height2) / 2) + this.this$0.editText.getPaddingTop();
                    } else {
                        if (gravity != 80) {
                            paddingTop = this.this$0.editText.getPaddingTop();
                        } else {
                            paddingTop2 = this.this$0.editText.getPaddingTop() + (i - height2) + lineHeight;
                        }
                        this.this$0.action.invoke(Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd), Double.valueOf(FloatKt.getDp(layout.getPrimaryHorizontal(iMin))), Double.valueOf(FloatKt.getDp((lineTop + paddingTop2) - editText2.getScrollY())), Double.valueOf(FloatKt.getDp(layout.getPrimaryHorizontal(iMax) + intrinsicWidth)), Double.valueOf(FloatKt.getDp((layout.getLineBottom(layout.getLineForOffset(iMax)) + paddingTop2) - editText2.getScrollY())));
                    }
                    paddingTop2 = paddingTop + lineHeight;
                    this.this$0.action.invoke(Integer.valueOf(selectionStart), Integer.valueOf(selectionEnd), Double.valueOf(FloatKt.getDp(layout.getPrimaryHorizontal(iMin))), Double.valueOf(FloatKt.getDp((lineTop + paddingTop2) - editText2.getScrollY())), Double.valueOf(FloatKt.getDp(layout.getPrimaryHorizontal(iMax) + intrinsicWidth)), Double.valueOf(FloatKt.getDp((layout.getLineBottom(layout.getLineForOffset(iMax)) + paddingTop2) - editText2.getScrollY())));
                }
                return true;
            }
        };
    }

    public final void setup() {
        this.editText.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
    }

    public final void destroy() {
        this.editText.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
    }
}

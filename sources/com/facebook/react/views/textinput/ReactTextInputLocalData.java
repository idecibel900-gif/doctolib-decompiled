package com.facebook.react.views.textinput;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactTextInputLocalData {
    private final int breakStrategy;
    private final int inputType;
    private final int maxLines;
    private final int minLines;
    private final CharSequence placeholder;
    private final SpannableStringBuilder text;
    private final float textSize;

    public ReactTextInputLocalData(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.text = new SpannableStringBuilder(editText.getText());
        this.textSize = editText.getTextSize();
        this.minLines = editText.getMinLines();
        this.maxLines = editText.getMaxLines();
        this.inputType = editText.getInputType();
        this.breakStrategy = editText.getBreakStrategy();
        this.placeholder = editText.getHint();
    }

    public final void apply(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.setText(this.text);
        editText.setTextSize(0, this.textSize);
        editText.setMinLines(this.minLines);
        editText.setMaxLines(this.maxLines);
        editText.setInputType(this.inputType);
        editText.setHint(this.placeholder);
        editText.setBreakStrategy(this.breakStrategy);
    }
}

package com.swmansion.enriched.markdown.input.editing;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownEditableFactory extends Editable.Factory {
    private final EnrichedMarkdownTextInputView view;

    public MarkdownEditableFactory(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence source) {
        Intrinsics.checkNotNullParameter(source, "source");
        SpannableStringBuilder spannableStringBuilder = source instanceof SpannableStringBuilder ? (SpannableStringBuilder) source : null;
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder(source);
        }
        this.view.attachTextWatcher(spannableStringBuilder);
        return spannableStringBuilder;
    }
}

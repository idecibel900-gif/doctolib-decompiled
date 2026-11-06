package com.swmansion.enriched.markdown.input.editing;

import android.text.Editable;
import android.text.TextWatcher;
import com.swmansion.enriched.markdown.input.EnrichedMarkdownTextInputView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownTextWatcher implements TextWatcher {
    private int deletedLength;
    private int editStart;
    private int insertedLength;
    private final EnrichedMarkdownTextInputView view;

    public MarkdownTextWatcher(EnrichedMarkdownTextInputView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.view.getEditSession().getShouldSuppressTextWatcher()) {
            return;
        }
        this.editStart = i;
        this.deletedLength = i2;
        this.insertedLength = i3;
        this.view.onBeforeTextChanged();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (this.view.getEditSession().getShouldSuppressTextWatcher()) {
            return;
        }
        this.view.getLayoutManager().invalidateLayout();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        if (this.view.getEditSession().getShouldSuppressTextWatcher()) {
            return;
        }
        this.view.onAfterTextChanged(this.editStart, this.deletedLength, this.insertedLength);
    }
}

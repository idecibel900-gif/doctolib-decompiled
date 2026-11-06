package com.swmansion.enriched.markdown.utils.text.view;

import android.os.Build;
import android.view.textclassifier.TextClassifier;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.swmansion.enriched.markdown.accessibility.AccessibleMarkdownTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TextViewSetupKt {
    public static final void setupAsMarkdownTextView(AccessibleMarkdownTextView accessibleMarkdownTextView) {
        Intrinsics.checkNotNullParameter(accessibleMarkdownTextView, "<this>");
        accessibleMarkdownTextView.setBackgroundColor(0);
        accessibleMarkdownTextView.setIncludeFontPadding(false);
        accessibleMarkdownTextView.setMovementMethod(LinkLongPressMovementMethod.Companion.createInstance());
        accessibleMarkdownTextView.setTextIsSelectable(true);
        accessibleMarkdownTextView.setCustomSelectionActionModeCallback(SelectionActionModeKt.createSelectionActionModeCallback$default(accessibleMarkdownTextView, null, null, null, 14, null));
        if (Build.VERSION.SDK_INT >= 26) {
            accessibleMarkdownTextView.setTextClassifier(TextClassifier.NO_OP);
        }
        accessibleMarkdownTextView.setVerticalScrollBarEnabled(false);
        accessibleMarkdownTextView.setHorizontalScrollBarEnabled(false);
        ViewCompat.setAccessibilityDelegate(accessibleMarkdownTextView, accessibleMarkdownTextView.getAccessibilityHelper());
    }

    public static final void applySelectableState(AppCompatTextView appCompatTextView, boolean z) {
        Intrinsics.checkNotNullParameter(appCompatTextView, "<this>");
        if (appCompatTextView.isTextSelectable() == z) {
            return;
        }
        appCompatTextView.setTextIsSelectable(z);
        appCompatTextView.setMovementMethod(LinkLongPressMovementMethod.Companion.createInstance());
        if (z || appCompatTextView.isClickable()) {
            return;
        }
        appCompatTextView.setClickable(true);
    }
}

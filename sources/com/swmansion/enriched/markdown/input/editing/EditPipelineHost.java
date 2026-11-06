package com.swmansion.enriched.markdown.input.editing;

import android.text.Editable;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface EditPipelineHost {
    void forceScrollToSelection();

    Editable getEditable();

    boolean getEmitMarkdown();

    void runAsATransaction(Function0 function0);

    void setViewSelection(int i);

    void syncCursorSizeWithBlock();

    boolean syncEmptyListAnchor(boolean z);

    void updateActiveMention();
}

package com.swmansion.enriched.markdown.input.editing;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EditPipelineKt {
    public static final boolean isLineBreak(char c) {
        return c == '\n' || c == '\r' || c == 133 || c == 8232 || c == 8233;
    }
}

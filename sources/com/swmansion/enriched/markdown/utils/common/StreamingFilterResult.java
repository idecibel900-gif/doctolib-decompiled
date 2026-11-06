package com.swmansion.enriched.markdown.utils.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamingFilterResult {
    private final boolean endsInsideOpenCodeFence;
    private final String markdown;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreamingFilterResult)) {
            return false;
        }
        StreamingFilterResult streamingFilterResult = (StreamingFilterResult) obj;
        return Intrinsics.areEqual(this.markdown, streamingFilterResult.markdown) && this.endsInsideOpenCodeFence == streamingFilterResult.endsInsideOpenCodeFence;
    }

    public int hashCode() {
        return (this.markdown.hashCode() * 31) + Boolean.hashCode(this.endsInsideOpenCodeFence);
    }

    public String toString() {
        return "StreamingFilterResult(markdown=" + this.markdown + ", endsInsideOpenCodeFence=" + this.endsInsideOpenCodeFence + ")";
    }

    public StreamingFilterResult(String markdown, boolean z) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        this.markdown = markdown;
        this.endsInsideOpenCodeFence = z;
    }

    public final String getMarkdown() {
        return this.markdown;
    }

    public final boolean getEndsInsideOpenCodeFence() {
        return this.endsInsideOpenCodeFence;
    }
}

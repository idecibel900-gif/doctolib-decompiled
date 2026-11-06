package com.swmansion.enriched.markdown.input.formatting;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ParseResult {
    private final List blockRanges;
    private final List formattingRanges;
    private final String plainText;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParseResult)) {
            return false;
        }
        ParseResult parseResult = (ParseResult) obj;
        return Intrinsics.areEqual(this.plainText, parseResult.plainText) && Intrinsics.areEqual(this.formattingRanges, parseResult.formattingRanges) && Intrinsics.areEqual(this.blockRanges, parseResult.blockRanges);
    }

    public int hashCode() {
        return (((this.plainText.hashCode() * 31) + this.formattingRanges.hashCode()) * 31) + this.blockRanges.hashCode();
    }

    public String toString() {
        return "ParseResult(plainText=" + this.plainText + ", formattingRanges=" + this.formattingRanges + ", blockRanges=" + this.blockRanges + ")";
    }

    public ParseResult(String plainText, List formattingRanges, List blockRanges) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Intrinsics.checkNotNullParameter(formattingRanges, "formattingRanges");
        Intrinsics.checkNotNullParameter(blockRanges, "blockRanges");
        this.plainText = plainText;
        this.formattingRanges = formattingRanges;
        this.blockRanges = blockRanges;
    }

    public final String getPlainText() {
        return this.plainText;
    }

    public final List getFormattingRanges() {
        return this.formattingRanges;
    }

    public final List getBlockRanges() {
        return this.blockRanges;
    }
}

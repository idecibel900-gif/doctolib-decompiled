package com.swmansion.enriched.markdown.input.detection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class WordResult {
    private final int end;
    private final int start;
    private final String word;

    public final String component1() {
        return this.word;
    }

    public final int component2() {
        return this.start;
    }

    public final int component3() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WordResult)) {
            return false;
        }
        WordResult wordResult = (WordResult) obj;
        return Intrinsics.areEqual(this.word, wordResult.word) && this.start == wordResult.start && this.end == wordResult.end;
    }

    public int hashCode() {
        return (((this.word.hashCode() * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end);
    }

    public String toString() {
        return "WordResult(word=" + this.word + ", start=" + this.start + ", end=" + this.end + ")";
    }

    public WordResult(String word, int i, int i2) {
        Intrinsics.checkNotNullParameter(word, "word");
        this.word = word;
        this.start = i;
        this.end = i2;
    }

    public final String getWord() {
        return this.word;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }
}

package org.commonmark.parser;

import org.commonmark.node.SourceSpan;

/* JADX INFO: loaded from: classes5.dex */
public class SourceLine {
    private final CharSequence content;
    private final SourceSpan sourceSpan;

    public static SourceLine of(CharSequence charSequence, SourceSpan sourceSpan) {
        return new SourceLine(charSequence, sourceSpan);
    }

    private SourceLine(CharSequence charSequence, SourceSpan sourceSpan) {
        if (charSequence == null) {
            throw new NullPointerException("content must not be null");
        }
        this.content = charSequence;
        this.sourceSpan = sourceSpan;
    }

    public CharSequence getContent() {
        return this.content;
    }

    public SourceSpan getSourceSpan() {
        return this.sourceSpan;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    public SourceLine substring(int i, int i2) {
        SourceSpan sourceSpanOf;
        CharSequence charSequenceSubSequence = this.content.subSequence(i, i2);
        SourceSpan sourceSpan = this.sourceSpan;
        if (sourceSpan != null) {
            int columnIndex = sourceSpan.getColumnIndex() + i;
            int i3 = i2 - i;
            if (i3 != 0) {
                sourceSpanOf = SourceSpan.of(this.sourceSpan.getLineIndex(), columnIndex, i3);
            } else {
                sourceSpanOf = null;
            }
        } else {
            sourceSpanOf = null;
        }
        return of(charSequenceSubSequence, sourceSpanOf);
    }
}

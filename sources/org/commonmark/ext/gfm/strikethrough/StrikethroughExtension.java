package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes5.dex */
public class StrikethroughExtension implements Parser.ParserExtension, Extension {
    private final boolean requireTwoTildes;

    /* JADX INFO: renamed from: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension$1, reason: invalid class name */
    abstract class AnonymousClass1 {
    }

    /* synthetic */ StrikethroughExtension(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private StrikethroughExtension(Builder builder) {
        this.requireTwoTildes = builder.requireTwoTildes;
    }

    public static Extension create() {
        return builder().build();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder builder) {
        builder.customDelimiterProcessor(new StrikethroughDelimiterProcessor(this.requireTwoTildes));
    }

    public static class Builder {
        private boolean requireTwoTildes = false;

        public Extension build() {
            return new StrikethroughExtension(this, null);
        }
    }
}

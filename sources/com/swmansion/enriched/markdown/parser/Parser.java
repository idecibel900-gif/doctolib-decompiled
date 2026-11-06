package com.swmansion.enriched.markdown.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/swmansion/enriched/markdown/parser/Parser;", "", "<init>", "()V", "parseMarkdown", "Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode;", "markdown", "", "flags", "Lcom/swmansion/enriched/markdown/parser/Md4cFlags;", "Companion", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Parser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Parser shared;

    /* JADX INFO: Access modifiers changed from: private */
    public static final native MarkdownASTNode nativeParseMarkdown(String str, Md4cFlags md4cFlags);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final MarkdownASTNode nativeParseMarkdown(String str, Md4cFlags md4cFlags) {
            return Parser.nativeParseMarkdown(str, md4cFlags);
        }

        private Companion() {
        }

        public final Parser getShared() {
            return Parser.shared;
        }
    }

    static {
        try {
            System.loadLibrary("react_codegen_EnrichedMarkdownTextSpec");
        } catch (UnsatisfiedLinkError unused) {
        }
        shared = new Parser();
    }

    public final MarkdownASTNode parseMarkdown(String markdown, Md4cFlags flags) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Intrinsics.checkNotNullParameter(flags, "flags");
        if (StringsKt.isBlank(markdown)) {
            return null;
        }
        try {
            MarkdownASTNode markdownASTNodeNativeParseMarkdown = INSTANCE.nativeParseMarkdown(markdown, flags);
            if (markdownASTNodeNativeParseMarkdown != null) {
                return markdownASTNodeNativeParseMarkdown;
            }
            return null;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}

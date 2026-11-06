package com.swmansion.enriched.markdown.utils.common;

import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082 J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ \u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u000e"}, d2 = {"Lcom/swmansion/enriched/markdown/utils/common/CodeBlockNode;", "", "<init>", "()V", "nativeDisplayLanguageName", "", "language", "extractCode", "node", "Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode;", "fenceChar", "fencedMarkdown", ResponseTypeValues.CODE, "displayLanguageName", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockNode {
    public static final CodeBlockNode INSTANCE = new CodeBlockNode();

    private final native String nativeDisplayLanguageName(String language);

    private CodeBlockNode() {
    }

    static {
        try {
            System.loadLibrary("react_codegen_EnrichedMarkdownTextSpec");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public final String extractCode(MarkdownASTNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        StringBuilder sb = new StringBuilder();
        extractCode$append(sb, node);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.trimEnd(string, '\n');
    }

    private static final void extractCode$append(StringBuilder sb, MarkdownASTNode markdownASTNode) {
        sb.append(markdownASTNode.getContent());
        Iterator<T> it = markdownASTNode.getChildren().iterator();
        while (it.hasNext()) {
            extractCode$append(sb, (MarkdownASTNode) it.next());
        }
    }

    public final String language(MarkdownASTNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        String attribute = node.getAttribute("language");
        if (attribute == null || attribute.length() <= 0) {
            return null;
        }
        return attribute;
    }

    public final String fenceChar(MarkdownASTNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        String attribute = node.getAttribute("fenceChar");
        if (attribute == null) {
            return "`";
        }
        if (attribute.length() <= 0) {
            attribute = null;
        }
        return attribute == null ? "`" : attribute;
    }

    public final String fencedMarkdown(String code, String language, String fenceChar) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(fenceChar, "fenceChar");
        String strRepeat = StringsKt.repeat(fenceChar, 3);
        if (language == null) {
            language = "";
        }
        return strRepeat + language + "\n" + code + "\n" + strRepeat;
    }

    public final String displayLanguageName(String language) {
        String strNativeDisplayLanguageName;
        if (language == null || language.length() == 0) {
            return "";
        }
        try {
            strNativeDisplayLanguageName = nativeDisplayLanguageName(language);
        } catch (UnsatisfiedLinkError unused) {
            strNativeDisplayLanguageName = null;
        }
        return strNativeDisplayLanguageName == null ? language : strNativeDisplayLanguageName;
    }
}

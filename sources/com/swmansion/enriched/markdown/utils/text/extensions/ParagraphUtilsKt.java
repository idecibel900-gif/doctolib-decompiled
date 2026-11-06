package com.swmansion.enriched.markdown.utils.text.extensions;

import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ParagraphUtilsKt {
    public static final boolean containsBlockImage(MarkdownASTNode markdownASTNode) {
        MarkdownASTNode markdownASTNode2;
        Intrinsics.checkNotNullParameter(markdownASTNode, "<this>");
        return markdownASTNode.getType() == MarkdownASTNode.NodeType.Paragraph && (markdownASTNode2 = (MarkdownASTNode) CollectionsKt.firstOrNull((List) markdownASTNode.getChildren())) != null && markdownASTNode.getChildren().size() == 1 && markdownASTNode2.getType() == MarkdownASTNode.NodeType.Image;
    }
}

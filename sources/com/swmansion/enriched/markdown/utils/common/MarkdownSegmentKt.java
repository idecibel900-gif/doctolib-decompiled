package com.swmansion.enriched.markdown.utils.common;

import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarkdownSegmentKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarkdownASTNode.NodeType.values().length];
            try {
                iArr[MarkdownASTNode.NodeType.Table.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.LatexMathDisplay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.CodeBlock.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List splitASTIntoSegments(MarkdownASTNode root) {
        String content;
        Intrinsics.checkNotNullParameter(root, "root");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (MarkdownASTNode markdownASTNode : root.getChildren()) {
            int i = WhenMappings.$EnumSwitchMapping$0[markdownASTNode.getType().ordinal()];
            if (i == 1) {
                splitASTIntoSegments$flushTextNodes(arrayList2, arrayList);
                arrayList.add(new MarkdownSegment.Table(markdownASTNode));
            } else if (i == 2) {
                splitASTIntoSegments$flushTextNodes(arrayList2, arrayList);
                if (!markdownASTNode.getChildren().isEmpty()) {
                    content = ((MarkdownASTNode) CollectionsKt.first((List) markdownASTNode.getChildren())).getContent();
                } else {
                    content = markdownASTNode.getContent();
                }
                arrayList.add(new MarkdownSegment.Math(content, markdownASTNode));
            } else if (i == 3) {
                splitASTIntoSegments$flushTextNodes(arrayList2, arrayList);
                arrayList.add(new MarkdownSegment.CodeBlock(markdownASTNode));
            } else {
                arrayList2.add(markdownASTNode);
            }
        }
        splitASTIntoSegments$flushTextNodes(arrayList2, arrayList);
        return arrayList;
    }

    private static final void splitASTIntoSegments$flushTextNodes(List list, List list2) {
        if (list.isEmpty()) {
            return;
        }
        list2.add(new MarkdownSegment.Text(CollectionsKt.toList(list)));
        list.clear();
    }
}

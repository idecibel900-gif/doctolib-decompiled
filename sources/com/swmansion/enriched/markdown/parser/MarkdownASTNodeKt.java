package com.swmansion.enriched.markdown.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarkdownASTNodeKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarkdownASTNode.NodeType.values().length];
            try {
                iArr[MarkdownASTNode.NodeType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Heading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Blockquote.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.UnorderedList.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.OrderedList.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.CodeBlock.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.ThematicBreak.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Table.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.LatexMathDisplay.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isTopLevelBlock(MarkdownASTNode.NodeType nodeType) {
        Intrinsics.checkNotNullParameter(nodeType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[nodeType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }
}

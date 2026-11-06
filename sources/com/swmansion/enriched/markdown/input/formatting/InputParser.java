package com.swmansion.enriched.markdown.input.formatting;

import com.swmansion.enriched.markdown.input.model.BlockRange;
import com.swmansion.enriched.markdown.input.model.BlockType;
import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.StyleType;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.parser.MarkdownASTNodeKt;
import com.swmansion.enriched.markdown.parser.Md4cFlags;
import com.swmansion.enriched.markdown.parser.Parser;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class InputParser {
    public static final InputParser INSTANCE = new InputParser();
    private static final Regex PARAGRAPH_BREAK_RE = new Regex("\\n[ \\t]*(?:\\n[ \\t]*)+");

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MarkdownASTNode.NodeType.values().length];
            try {
                iArr[MarkdownASTNode.NodeType.Strong.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Emphasis.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Underline.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Strikethrough.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Link.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Spoiler.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Paragraph.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.Heading.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[MarkdownASTNode.NodeType.ListItem.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InputParser() {
    }

    public final ParseResult parseToPlainTextAndRanges(String rawMarkdown) {
        Intrinsics.checkNotNullParameter(rawMarkdown, "rawMarkdown");
        String strStripZwsp = MarkdownSerializer.INSTANCE.stripZwsp(rawMarkdown);
        if (strStripZwsp.length() == 0) {
            return new ParseResult("", CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        String strComplete = InputRemend.INSTANCE.complete(strStripZwsp);
        MarkdownASTNode markdown = Parser.INSTANCE.getShared().parseMarkdown(strComplete, new Md4cFlags(true, false, false, false, false, false, false, 94, null));
        if (markdown == null) {
            return new ParseResult(strStripZwsp, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        walkNode(markdown, sb, arrayList, arrayList2, new ArrayDeque(), new ArrayDeque(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(PARAGRAPH_BREAK_RE, StringsKt.trim(strComplete).toString(), 0, 2, null), new Function1() { // from class: com.swmansion.enriched.markdown.input.formatting.InputParser$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(InputParser.parseToPlainTextAndRanges$lambda$1((MatchResult) obj));
            }
        }))), 0, false);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new ParseResult(string, arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parseToPlainTextAndRanges$lambda$1(MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        String value = match.getValue();
        int i = 0;
        for (int i2 = 0; i2 < value.length(); i2++) {
            if (value.charAt(i2) == '\n') {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0168  */
    private final void walkNode(MarkdownASTNode markdownASTNode, StringBuilder sb, List list, List list2, ArrayDeque arrayDeque, ArrayDeque arrayDeque2, int i, boolean z) {
        ArrayDeque arrayDeque3;
        boolean z2;
        int i2;
        BlockType blockType;
        int length;
        Integer intOrNull;
        InputParser inputParser = this;
        StringBuilder sb2 = sb;
        StyleType styleTypeNodeTypeToStyleType = inputParser.nodeTypeToStyleType(markdownASTNode.getType());
        if (styleTypeNodeTypeToStyleType != null) {
            arrayDeque3 = arrayDeque;
            arrayDeque3.addLast(new ActiveStyle(styleTypeNodeTypeToStyleType, sb2.length(), styleTypeNodeTypeToStyleType == StyleType.LINK ? markdownASTNode.getAttribute("url") : null));
        } else {
            arrayDeque3 = arrayDeque;
        }
        boolean z3 = markdownASTNode.getType() == MarkdownASTNode.NodeType.UnorderedList || markdownASTNode.getType() == MarkdownASTNode.NodeType.OrderedList;
        int i3 = z3 ? i + 1 : i;
        if (z3) {
            z2 = markdownASTNode.getType() == MarkdownASTNode.NodeType.OrderedList;
        } else {
            z2 = z;
        }
        MarkdownASTNode.NodeType type = markdownASTNode.getType();
        MarkdownASTNode.NodeType nodeType = MarkdownASTNode.NodeType.ListItem;
        if (type == nodeType && sb2.length() > 0 && !StringsKt.endsWith$default((CharSequence) sb2, (CharSequence) "\n", false, 2, (Object) null)) {
            sb2.append("\n");
        }
        int length2 = markdownASTNode.getType() == nodeType ? sb2.length() : -1;
        String attribute = markdownASTNode.getAttribute("level");
        int iIntValue = (attribute == null || (intOrNull = StringsKt.toIntOrNull(attribute)) == null) ? 0 : intOrNull.intValue();
        BlockType blockTypeNodeTypeToBlockType = inputParser.nodeTypeToBlockType(markdownASTNode.getType(), iIntValue);
        int length3 = sb2.length();
        if (markdownASTNode.getType() == MarkdownASTNode.NodeType.Text) {
            sb2.append(markdownASTNode.getContent());
        } else if (markdownASTNode.getType() == MarkdownASTNode.NodeType.LineBreak || markdownASTNode.getType() == MarkdownASTNode.NodeType.SoftBreak) {
            sb2.append("\n");
        }
        int i4 = 0;
        for (MarkdownASTNode markdownASTNode2 : markdownASTNode.getChildren()) {
            int i5 = i4 + 1;
            if (i4 > 0 && i == 0 && MarkdownASTNodeKt.isTopLevelBlock(markdownASTNode2.getType()) && sb2.length() > 0) {
                Integer num = (Integer) arrayDeque2.removeFirstOrNull();
                sb2.append(StringsKt.repeat("\n", num != null ? num.intValue() : 2));
            }
            inputParser.walkNode(markdownASTNode2, sb2, list, list2, arrayDeque3, arrayDeque2, i3, z2);
            inputParser = this;
            sb2 = sb;
            arrayDeque3 = arrayDeque;
            i4 = i5;
        }
        if (length2 < 0) {
            i2 = iIntValue;
            blockType = blockTypeNodeTypeToBlockType;
        } else {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) sb, '\n', length2, false, 4, (Object) null);
            if (iIndexOf$default < 0) {
                iIndexOf$default = sb.length();
            }
            if (iIndexOf$default > length2) {
                i2 = iIntValue;
                blockType = blockTypeNodeTypeToBlockType;
                list2.add(new BlockRange(z ? BlockType.ORDERED_LIST_ITEM : BlockType.UNORDERED_LIST_ITEM, length2, iIndexOf$default, RangesKt.coerceIn(i - 1, 0, 5), 0, 16, null));
            } else {
                i2 = iIntValue;
                blockType = blockTypeNodeTypeToBlockType;
            }
        }
        if (styleTypeNodeTypeToStyleType != null) {
            ActiveStyle activeStyle = (ActiveStyle) arrayDeque.removeLast();
            int length4 = sb.length();
            if (length4 > activeStyle.getStartPosition()) {
                list.add(new FormattingRange(styleTypeNodeTypeToStyleType, activeStyle.getStartPosition(), length4, activeStyle.getUrl()));
            }
        }
        if (blockType == null || blockType == BlockType.PARAGRAPH || BlockType.Companion.getLIST_ITEMS().contains(blockType) || (length = sb.length()) <= length3) {
            return;
        }
        list2.add(new BlockRange(blockType, length3, length, i2, 0, 16, null));
    }

    private final StyleType nodeTypeToStyleType(MarkdownASTNode.NodeType nodeType) {
        switch (WhenMappings.$EnumSwitchMapping$0[nodeType.ordinal()]) {
            case 1:
                return StyleType.BOLD;
            case 2:
                return StyleType.ITALIC;
            case 3:
                return StyleType.UNDERLINE;
            case 4:
                return StyleType.STRIKETHROUGH;
            case 5:
                return StyleType.LINK;
            case 6:
                return StyleType.SPOILER;
            default:
                return null;
        }
    }

    private final BlockType nodeTypeToBlockType(MarkdownASTNode.NodeType nodeType, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[nodeType.ordinal()];
        if (i2 == 7) {
            return BlockType.PARAGRAPH;
        }
        if (i2 == 8) {
            BlockType blockTypeForHeadingLevel = BlockType.Companion.forHeadingLevel(i);
            return blockTypeForHeadingLevel == null ? BlockType.PARAGRAPH : blockTypeForHeadingLevel;
        }
        if (i2 != 9) {
            return null;
        }
        return BlockType.UNORDERED_LIST_ITEM;
    }

    private static final class ActiveStyle {
        private final int startPosition;
        private final StyleType type;
        private final String url;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActiveStyle)) {
                return false;
            }
            ActiveStyle activeStyle = (ActiveStyle) obj;
            return this.type == activeStyle.type && this.startPosition == activeStyle.startPosition && Intrinsics.areEqual(this.url, activeStyle.url);
        }

        public int hashCode() {
            int iHashCode = ((this.type.hashCode() * 31) + Integer.hashCode(this.startPosition)) * 31;
            String str = this.url;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ActiveStyle(type=" + this.type + ", startPosition=" + this.startPosition + ", url=" + this.url + ")";
        }

        public ActiveStyle(StyleType type, int i, String str) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.startPosition = i;
            this.url = str;
        }

        public final int getStartPosition() {
            return this.startPosition;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}

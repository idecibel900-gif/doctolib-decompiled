package com.swmansion.enriched.markdown.parser;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001!B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode;", "", "type", "Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode$NodeType;", "content", "", "attributes", "", "children", "", "<init>", "(Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode$NodeType;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getType", "()Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode$NodeType;", "getContent", "()Ljava/lang/String;", "getAttributes", "()Ljava/util/Map;", "getChildren", "()Ljava/util/List;", "getAttribute", SubscriberAttributeKt.JSON_NAME_KEY, "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "NodeType", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MarkdownASTNode {
    private final Map<String, String> attributes;
    private final List<MarkdownASTNode> children;
    private final String content;
    private final NodeType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\"\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/swmansion/enriched/markdown/parser/MarkdownASTNode$NodeType;", "", "<init>", "(Ljava/lang/String;I)V", "Document", "Paragraph", "Text", "Link", "Heading", "LineBreak", "Strong", "Emphasis", "Strikethrough", "Underline", "Code", "Image", "Blockquote", "UnorderedList", "OrderedList", "ListItem", "CodeBlock", "ThematicBreak", "Table", "TableHead", "TableBody", "TableRow", "TableHeaderCell", "TableCell", "LatexMathInline", "LatexMathDisplay", "Spoiler", "Superscript", "Subscript", "Highlight", "SoftBreak", "react-native-enriched-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum NodeType {
        Document,
        Paragraph,
        Text,
        Link,
        Heading,
        LineBreak,
        Strong,
        Emphasis,
        Strikethrough,
        Underline,
        Code,
        Image,
        Blockquote,
        UnorderedList,
        OrderedList,
        ListItem,
        CodeBlock,
        ThematicBreak,
        Table,
        TableHead,
        TableBody,
        TableRow,
        TableHeaderCell,
        TableCell,
        LatexMathInline,
        LatexMathDisplay,
        Spoiler,
        Superscript,
        Subscript,
        Highlight,
        SoftBreak;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarkdownASTNode copy$default(MarkdownASTNode markdownASTNode, NodeType nodeType, String str, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            nodeType = markdownASTNode.type;
        }
        if ((i & 2) != 0) {
            str = markdownASTNode.content;
        }
        if ((i & 4) != 0) {
            map = markdownASTNode.attributes;
        }
        if ((i & 8) != 0) {
            list = markdownASTNode.children;
        }
        return markdownASTNode.copy(nodeType, str, map, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final NodeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> component3() {
        return this.attributes;
    }

    public final List<MarkdownASTNode> component4() {
        return this.children;
    }

    public final MarkdownASTNode copy(NodeType type, String content, Map<String, String> attributes, List<MarkdownASTNode> children) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new MarkdownASTNode(type, content, attributes, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarkdownASTNode)) {
            return false;
        }
        MarkdownASTNode markdownASTNode = (MarkdownASTNode) other;
        return this.type == markdownASTNode.type && Intrinsics.areEqual(this.content, markdownASTNode.content) && Intrinsics.areEqual(this.attributes, markdownASTNode.attributes) && Intrinsics.areEqual(this.children, markdownASTNode.children);
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.content.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.children.hashCode();
    }

    public String toString() {
        return "MarkdownASTNode(type=" + this.type + ", content=" + this.content + ", attributes=" + this.attributes + ", children=" + this.children + ")";
    }

    public MarkdownASTNode(NodeType type, String content, Map<String, String> attributes, List<MarkdownASTNode> children) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.type = type;
        this.content = content;
        this.attributes = attributes;
        this.children = children;
    }

    public final NodeType getType() {
        return this.type;
    }

    public /* synthetic */ MarkdownASTNode(NodeType nodeType, String str, Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nodeType, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getContent() {
        return this.content;
    }

    public final Map<String, String> getAttributes() {
        return this.attributes;
    }

    public final List<MarkdownASTNode> getChildren() {
        return this.children;
    }

    public final String getAttribute(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.attributes.get(key);
    }
}

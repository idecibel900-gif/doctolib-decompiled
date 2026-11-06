package com.swmansion.enriched.markdown.utils.common;

import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface MarkdownSegment {

    public static final class Text implements MarkdownSegment {
        private final List nodes;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Text) && Intrinsics.areEqual(this.nodes, ((Text) obj).nodes);
        }

        public int hashCode() {
            return this.nodes.hashCode();
        }

        public String toString() {
            return "Text(nodes=" + this.nodes + ")";
        }

        public Text(List nodes) {
            Intrinsics.checkNotNullParameter(nodes, "nodes");
            this.nodes = nodes;
        }

        public final List getNodes() {
            return this.nodes;
        }
    }

    public static final class Table implements MarkdownSegment {
        private final MarkdownASTNode node;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Table) && Intrinsics.areEqual(this.node, ((Table) obj).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "Table(node=" + this.node + ")";
        }

        public Table(MarkdownASTNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final MarkdownASTNode getNode() {
            return this.node;
        }
    }

    public static final class Math implements MarkdownSegment {
        private final String latex;
        private final MarkdownASTNode node;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Math)) {
                return false;
            }
            Math math = (Math) obj;
            return Intrinsics.areEqual(this.latex, math.latex) && Intrinsics.areEqual(this.node, math.node);
        }

        public int hashCode() {
            return (this.latex.hashCode() * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Math(latex=" + this.latex + ", node=" + this.node + ")";
        }

        public Math(String latex, MarkdownASTNode node) {
            Intrinsics.checkNotNullParameter(latex, "latex");
            Intrinsics.checkNotNullParameter(node, "node");
            this.latex = latex;
            this.node = node;
        }

        public final String getLatex() {
            return this.latex;
        }
    }

    public static final class CodeBlock implements MarkdownSegment {
        private final MarkdownASTNode node;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CodeBlock) && Intrinsics.areEqual(this.node, ((CodeBlock) obj).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "CodeBlock(node=" + this.node + ")";
        }

        public CodeBlock(MarkdownASTNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final MarkdownASTNode getNode() {
            return this.node;
        }
    }
}

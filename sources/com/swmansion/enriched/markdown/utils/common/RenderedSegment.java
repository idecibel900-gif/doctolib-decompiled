package com.swmansion.enriched.markdown.utils.common;

import android.text.SpannableString;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface RenderedSegment {
    long getSignature();

    public static final class Text implements RenderedSegment {
        private final List imageSpans;
        private final float lastElementMarginBottom;
        private final boolean needsJustify;
        private final long signature;
        private final SpannableString styledText;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text = (Text) obj;
            return Intrinsics.areEqual(this.styledText, text.styledText) && Intrinsics.areEqual(this.imageSpans, text.imageSpans) && this.needsJustify == text.needsJustify && Float.compare(this.lastElementMarginBottom, text.lastElementMarginBottom) == 0 && this.signature == text.signature;
        }

        public int hashCode() {
            return (((((((this.styledText.hashCode() * 31) + this.imageSpans.hashCode()) * 31) + Boolean.hashCode(this.needsJustify)) * 31) + Float.hashCode(this.lastElementMarginBottom)) * 31) + Long.hashCode(this.signature);
        }

        public String toString() {
            SpannableString spannableString = this.styledText;
            return "Text(styledText=" + ((Object) spannableString) + ", imageSpans=" + this.imageSpans + ", needsJustify=" + this.needsJustify + ", lastElementMarginBottom=" + this.lastElementMarginBottom + ", signature=" + this.signature + ")";
        }

        public Text(SpannableString styledText, List imageSpans, boolean z, float f, long j) {
            Intrinsics.checkNotNullParameter(styledText, "styledText");
            Intrinsics.checkNotNullParameter(imageSpans, "imageSpans");
            this.styledText = styledText;
            this.imageSpans = imageSpans;
            this.needsJustify = z;
            this.lastElementMarginBottom = f;
            this.signature = j;
        }

        public final SpannableString getStyledText() {
            return this.styledText;
        }

        public final List getImageSpans() {
            return this.imageSpans;
        }

        public final boolean getNeedsJustify() {
            return this.needsJustify;
        }

        public final float getLastElementMarginBottom() {
            return this.lastElementMarginBottom;
        }

        @Override // com.swmansion.enriched.markdown.utils.common.RenderedSegment
        public long getSignature() {
            return this.signature;
        }
    }

    public static final class Table implements RenderedSegment {
        private final MarkdownASTNode node;
        private final long signature;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Table)) {
                return false;
            }
            Table table = (Table) obj;
            return Intrinsics.areEqual(this.node, table.node) && this.signature == table.signature;
        }

        public int hashCode() {
            return (this.node.hashCode() * 31) + Long.hashCode(this.signature);
        }

        public String toString() {
            return "Table(node=" + this.node + ", signature=" + this.signature + ")";
        }

        public Table(MarkdownASTNode node, long j) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.signature = j;
        }

        public final MarkdownASTNode getNode() {
            return this.node;
        }

        @Override // com.swmansion.enriched.markdown.utils.common.RenderedSegment
        public long getSignature() {
            return this.signature;
        }
    }

    public static final class Math implements RenderedSegment {
        private final String latex;
        private final long signature;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Math)) {
                return false;
            }
            Math math = (Math) obj;
            return Intrinsics.areEqual(this.latex, math.latex) && this.signature == math.signature;
        }

        public int hashCode() {
            return (this.latex.hashCode() * 31) + Long.hashCode(this.signature);
        }

        public String toString() {
            return "Math(latex=" + this.latex + ", signature=" + this.signature + ")";
        }

        public Math(String latex, long j) {
            Intrinsics.checkNotNullParameter(latex, "latex");
            this.latex = latex;
            this.signature = j;
        }

        public final String getLatex() {
            return this.latex;
        }

        @Override // com.swmansion.enriched.markdown.utils.common.RenderedSegment
        public long getSignature() {
            return this.signature;
        }
    }

    public static final class CodeBlock implements RenderedSegment {
        private final MarkdownASTNode node;
        private final long signature;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CodeBlock)) {
                return false;
            }
            CodeBlock codeBlock = (CodeBlock) obj;
            return Intrinsics.areEqual(this.node, codeBlock.node) && this.signature == codeBlock.signature;
        }

        public int hashCode() {
            return (this.node.hashCode() * 31) + Long.hashCode(this.signature);
        }

        public String toString() {
            return "CodeBlock(node=" + this.node + ", signature=" + this.signature + ")";
        }

        public CodeBlock(MarkdownASTNode node, long j) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
            this.signature = j;
        }

        public final MarkdownASTNode getNode() {
            return this.node;
        }

        @Override // com.swmansion.enriched.markdown.utils.common.RenderedSegment
        public long getSignature() {
            return this.signature;
        }
    }
}

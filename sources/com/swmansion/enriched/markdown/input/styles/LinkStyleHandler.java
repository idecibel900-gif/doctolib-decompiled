package com.swmansion.enriched.markdown.input.styles;

import com.swmansion.enriched.markdown.input.model.FormattingRange;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.InputLinkVariantStyle;
import com.swmansion.enriched.markdown.input.model.StyleType;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class LinkStyleHandler implements StyleHandler {
    private final StyleType styleType = StyleType.LINK;
    private final StyleMergingConfig mergingConfig = new StyleMergingConfig(null, null, 3, null);

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public StyleType getStyleType() {
        return this.styleType;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public StyleMergingConfig getMergingConfig() {
        return this.mergingConfig;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public List createSpans(FormattingRange range, InputFormatterStyle style) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(style, "style");
        ResolvedLinkStyle resolvedLinkStyleResolveLinkStyle = resolveLinkStyle(range.getUrl(), style);
        List listMutableListOf = CollectionsKt.mutableListOf(new MarkdownLinkColorSpan(resolvedLinkStyleResolveLinkStyle.getColor()));
        if (resolvedLinkStyleResolveLinkStyle.getUnderline()) {
            listMutableListOf.add(new MarkdownLinkUnderlineSpan());
        }
        if (resolvedLinkStyleResolveLinkStyle.getBackgroundColor() != 0) {
            listMutableListOf.add(new MarkdownLinkBackgroundColorSpan(resolvedLinkStyleResolveLinkStyle.getBackgroundColor()));
        }
        return listMutableListOf;
    }

    @Override // com.swmansion.enriched.markdown.input.styles.StyleHandler
    public List spanClasses() {
        return CollectionsKt.listOf((Object[]) new Class[]{MarkdownLinkColorSpan.class, MarkdownLinkUnderlineSpan.class, MarkdownLinkBackgroundColorSpan.class});
    }

    private final ResolvedLinkStyle resolveLinkStyle(String str, InputFormatterStyle inputFormatterStyle) {
        InputLinkVariantStyle inputLinkVariantStyle = null;
        Object obj = null;
        if (str != null) {
            for (Object obj2 : inputFormatterStyle.getLinkVariants()) {
                Regex compiledRegex = ((InputLinkVariantStyle) obj2).getCompiledRegex();
                if (compiledRegex != null && compiledRegex.containsMatchIn(str)) {
                    obj = obj2;
                    break;
                }
            }
            inputLinkVariantStyle = (InputLinkVariantStyle) obj;
        }
        return new ResolvedLinkStyle(inputLinkVariantStyle != null ? inputLinkVariantStyle.getColor() : inputFormatterStyle.getLinkColor(), inputLinkVariantStyle != null ? inputLinkVariantStyle.getUnderline() : inputFormatterStyle.getLinkUnderline(), inputLinkVariantStyle != null ? inputLinkVariantStyle.getBackgroundColor() : inputFormatterStyle.getLinkBackgroundColor());
    }

    private static final class ResolvedLinkStyle {
        private final int backgroundColor;
        private final int color;
        private final boolean underline;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedLinkStyle)) {
                return false;
            }
            ResolvedLinkStyle resolvedLinkStyle = (ResolvedLinkStyle) obj;
            return this.color == resolvedLinkStyle.color && this.underline == resolvedLinkStyle.underline && this.backgroundColor == resolvedLinkStyle.backgroundColor;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.color) * 31) + Boolean.hashCode(this.underline)) * 31) + Integer.hashCode(this.backgroundColor);
        }

        public String toString() {
            return "ResolvedLinkStyle(color=" + this.color + ", underline=" + this.underline + ", backgroundColor=" + this.backgroundColor + ")";
        }

        public ResolvedLinkStyle(int i, boolean z, int i2) {
            this.color = i;
            this.underline = z;
            this.backgroundColor = i2;
        }

        public final int getColor() {
            return this.color;
        }

        public final boolean getUnderline() {
            return this.underline;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }
    }
}

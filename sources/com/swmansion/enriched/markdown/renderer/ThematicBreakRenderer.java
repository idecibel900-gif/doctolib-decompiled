package com.swmansion.enriched.markdown.renderer;

import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.ThematicBreakSpan;
import com.swmansion.enriched.markdown.styles.ThematicBreakStyle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThematicBreakRenderer implements NodeRenderer {
    private final RendererConfig config;

    public ThematicBreakRenderer(RendererConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.swmansion.enriched.markdown.renderer.NodeRenderer
    public void render(MarkdownASTNode node, SpannableStringBuilder builder, Function1 function1, Function1 function2, RendererFactory factory) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(factory, "factory");
        ensureNewline(builder);
        int length = builder.length();
        builder.append(" \n");
        int length2 = builder.length();
        ThematicBreakStyle thematicBreakStyle = this.config.getStyle().getThematicBreakStyle();
        builder.setSpan(new ThematicBreakSpan(thematicBreakStyle.getColor(), thematicBreakStyle.getHeight(), thematicBreakStyle.getMarginTop(), thematicBreakStyle.getMarginBottom()), length, length2, 33);
    }

    private final void ensureNewline(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }
}

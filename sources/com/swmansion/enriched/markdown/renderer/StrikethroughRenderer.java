package com.swmansion.enriched.markdown.renderer;

import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.StrikethroughSpan;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StrikethroughRenderer implements NodeRenderer {
    private final RendererConfig config;

    public StrikethroughRenderer(RendererConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.swmansion.enriched.markdown.renderer.NodeRenderer
    public void render(MarkdownASTNode node, SpannableStringBuilder builder, Function1 function1, Function1 function2, RendererFactory factory) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(factory, "factory");
        int length = builder.length();
        factory.renderChildren(node, builder, function1, function2);
        int length2 = builder.length();
        if (length2 > length) {
            factory.getBlockStyleContext().requireBlockStyle();
            builder.setSpan(new StrikethroughSpan(factory.getStyleCache().getStrikethroughColor()), length, length2, 33);
        }
    }
}

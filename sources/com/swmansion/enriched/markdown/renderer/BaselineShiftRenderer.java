package com.swmansion.enriched.markdown.renderer;

import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.BaselineShiftSpan;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaselineShiftRenderer implements NodeRenderer {
    public abstract float baselineOffsetScale(RendererFactory rendererFactory);

    public abstract float fontScale(RendererFactory rendererFactory);

    public abstract BaselineShiftSpan.SpanType spanType();

    @Override // com.swmansion.enriched.markdown.renderer.NodeRenderer
    public void render(MarkdownASTNode node, SpannableStringBuilder builder, Function1 function1, Function1 function2, RendererFactory factory) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(factory, "factory");
        int length = builder.length();
        factory.renderChildren(node, builder, function1, function2);
        int length2 = builder.length();
        if (length2 > length) {
            factory.registerDeferredSpan(new BaselineShiftSpan(fontScale(factory), baselineOffsetScale(factory), spanType()), length, length2);
        }
    }
}

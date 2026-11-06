package com.swmansion.enriched.markdown.renderer;

import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.utils.text.extensions.SpannableExtensionsKt;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageRenderer implements NodeRenderer {
    @Override // com.swmansion.enriched.markdown.renderer.NodeRenderer
    public void render(MarkdownASTNode node, SpannableStringBuilder builder, Function1 function1, Function1 function2, RendererFactory factory) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(factory, "factory");
        String attribute = node.getAttribute("url");
        if (attribute == null) {
            return;
        }
        boolean zIsInlineImage = SpannableExtensionsKt.isInlineImage(builder);
        int length = builder.length();
        builder.append((CharSequence) "￼");
        int length2 = builder.length();
        ImageSpan imageSpanCreateImageSpan = factory.createImageSpan(attribute, zIsInlineImage, extractTextFromNode(node));
        builder.setSpan(imageSpanCreateImageSpan, length, length2, 33);
        factory.registerImageSpan(imageSpanCreateImageSpan);
    }

    private final String extractTextFromNode(MarkdownASTNode markdownASTNode) {
        StringBuilder sb = new StringBuilder();
        appendChildText(markdownASTNode, sb);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.trim(string).toString();
    }

    private final void appendChildText(MarkdownASTNode markdownASTNode, StringBuilder sb) {
        sb.append(markdownASTNode.getContent());
        Iterator<T> it = markdownASTNode.getChildren().iterator();
        while (it.hasNext()) {
            appendChildText((MarkdownASTNode) it.next(), sb);
        }
    }
}

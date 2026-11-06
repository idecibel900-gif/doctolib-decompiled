package com.swmansion.enriched.markdown.renderer;

import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public interface NodeRenderer {
    void render(MarkdownASTNode markdownASTNode, SpannableStringBuilder spannableStringBuilder, Function1 function1, Function1 function2, RendererFactory rendererFactory);
}

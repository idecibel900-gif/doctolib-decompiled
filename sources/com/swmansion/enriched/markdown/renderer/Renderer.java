package com.swmansion.enriched.markdown.renderer;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spans.MarginBottomSpan;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class Renderer {
    private Context cachedContext;
    private RendererFactory cachedFactory;
    private StyleConfig cachedStyle;
    private final List collectedImageSpans = new ArrayList();
    private float lastElementMarginBottom;

    public final void configure(StyleConfig style, Context context) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.cachedStyle == style && this.cachedContext == context) {
            return;
        }
        this.cachedStyle = style;
        this.cachedContext = context;
        this.cachedFactory = new RendererFactory(new RendererConfig(style), context, new Function1() { // from class: com.swmansion.enriched.markdown.renderer.Renderer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Renderer.configure$lambda$0(this.f$0, (ImageSpan) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit configure$lambda$0(Renderer renderer, ImageSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        renderer.reportImageSpan(span);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ SpannableString renderDocument$default(Renderer renderer, MarkdownASTNode markdownASTNode, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        return renderer.renderDocument(markdownASTNode, function1, function2);
    }

    public final SpannableString renderDocument(MarkdownASTNode document, Function1 function1, Function1 function2) {
        Intrinsics.checkNotNullParameter(document, "document");
        RendererFactory rendererFactory = this.cachedFactory;
        if (rendererFactory == null) {
            throw new IllegalArgumentException("Renderer must be configured with a style before calling renderDocument.");
        }
        rendererFactory.resetForNewRender();
        this.collectedImageSpans.clear();
        this.lastElementMarginBottom = 0.0f;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        renderNode(document, spannableStringBuilder, function1, function2, rendererFactory);
        removeTrailingMargin(spannableStringBuilder);
        rendererFactory.flushDeferredSpans(spannableStringBuilder);
        return new SpannableString(spannableStringBuilder);
    }

    private final void removeTrailingMargin(SpannableStringBuilder spannableStringBuilder) {
        Object obj;
        if (spannableStringBuilder.length() == 0) {
            return;
        }
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MarginBottomSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        if (spans.length != 0) {
            obj = spans[0];
            int lastIndex = ArraysKt.getLastIndex(spans);
            if (lastIndex != 0) {
                int spanEnd = spannableStringBuilder.getSpanEnd((MarginBottomSpan) obj);
                if (1 <= lastIndex) {
                    int i = 1;
                    while (true) {
                        Object obj2 = spans[i];
                        int spanEnd2 = spannableStringBuilder.getSpanEnd((MarginBottomSpan) obj2);
                        if (spanEnd < spanEnd2) {
                            obj = obj2;
                            spanEnd = spanEnd2;
                        }
                        if (i == lastIndex) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        } else {
            obj = null;
        }
        MarginBottomSpan marginBottomSpan = (MarginBottomSpan) obj;
        this.lastElementMarginBottom = marginBottomSpan != null ? marginBottomSpan.getMarginBottom() : 0.0f;
        while (StringsKt.endsWith$default((CharSequence) spannableStringBuilder, '\n', false, 2, (Object) null)) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        if (marginBottomSpan == null || spannableStringBuilder.getSpanEnd(marginBottomSpan) < spannableStringBuilder.length()) {
            return;
        }
        spannableStringBuilder.removeSpan(marginBottomSpan);
    }

    public final float getLastElementMarginBottom() {
        return this.lastElementMarginBottom;
    }

    private final void renderNode(MarkdownASTNode markdownASTNode, SpannableStringBuilder spannableStringBuilder, Function1 function1, Function1 function2, RendererFactory rendererFactory) {
        rendererFactory.getRenderer(markdownASTNode).render(markdownASTNode, spannableStringBuilder, function1, function2, rendererFactory);
    }

    private final void reportImageSpan(ImageSpan imageSpan) {
        this.collectedImageSpans.add(imageSpan);
    }

    public final List getCollectedImageSpans() {
        return this.collectedImageSpans;
    }
}

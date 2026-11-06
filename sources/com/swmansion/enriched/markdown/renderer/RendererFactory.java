package com.swmansion.enriched.markdown.renderer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.MetricAffectingSpan;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class RendererFactory {
    private final BlockStyleContext blockStyleContext;
    private final RendererConfig config;
    private final Context context;
    private final List deferredSpans;
    private final LineBreakRenderer lineBreakRenderer;
    private final Function1 onImageSpanCreated;
    private final Lazy renderers$delegate;
    private final SoftBreakRenderer softBreakRenderer;
    private final SpanStyleCache styleCache;
    private final TextRenderer textRenderer;

    public RendererFactory(RendererConfig config, Context context, Function1 onImageSpanCreated) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onImageSpanCreated, "onImageSpanCreated");
        this.config = config;
        this.context = context;
        this.onImageSpanCreated = onImageSpanCreated;
        this.blockStyleContext = new BlockStyleContext();
        this.styleCache = new SpanStyleCache(config.getStyle());
        this.deferredSpans = new ArrayList();
        this.textRenderer = new TextRenderer();
        this.lineBreakRenderer = new LineBreakRenderer();
        this.softBreakRenderer = new SoftBreakRenderer();
        this.renderers$delegate = LazyKt.lazy(new Function0() { // from class: com.swmansion.enriched.markdown.renderer.RendererFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RendererFactory.renderers_delegate$lambda$1(this.f$0);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final BlockStyleContext getBlockStyleContext() {
        return this.blockStyleContext;
    }

    public final SpanStyleCache getStyleCache() {
        return this.styleCache;
    }

    private static final class DeferredSpan {
        private final int end;
        private final MetricAffectingSpan span;
        private final int start;

        public final MetricAffectingSpan component1() {
            return this.span;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeferredSpan)) {
                return false;
            }
            DeferredSpan deferredSpan = (DeferredSpan) obj;
            return Intrinsics.areEqual(this.span, deferredSpan.span) && this.start == deferredSpan.start && this.end == deferredSpan.end;
        }

        public int hashCode() {
            return (((this.span.hashCode() * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end);
        }

        public String toString() {
            return "DeferredSpan(span=" + this.span + ", start=" + this.start + ", end=" + this.end + ")";
        }

        public DeferredSpan(MetricAffectingSpan span, int i, int i2) {
            Intrinsics.checkNotNullParameter(span, "span");
            this.span = span;
            this.start = i;
            this.end = i2;
        }
    }

    public final void registerDeferredSpan(MetricAffectingSpan span, int i, int i2) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.deferredSpans.add(new DeferredSpan(span, i, i2));
    }

    public final void flushDeferredSpans(SpannableStringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (DeferredSpan deferredSpan : this.deferredSpans) {
            builder.setSpan(deferredSpan.component1(), deferredSpan.component2(), deferredSpan.component3(), 33);
        }
        this.deferredSpans.clear();
    }

    public final void resetForNewRender() {
        this.blockStyleContext.resetForNewRender();
        this.deferredSpans.clear();
    }

    public final ImageSpan createImageSpan(String imageUrl, boolean z, String altText) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(altText, "altText");
        return new ImageSpan(this.context, imageUrl, this.config.getStyle(), z, altText);
    }

    private final Map getRenderers() {
        return (Map) this.renderers$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map renderers_delegate$lambda$1(RendererFactory rendererFactory) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Document, new DocumentRenderer());
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Paragraph, new ParagraphRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Heading, new HeadingRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Blockquote, new BlockquoteRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.CodeBlock, new CodeBlockRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.UnorderedList, new ListRenderer(rendererFactory.config, false));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.OrderedList, new ListRenderer(rendererFactory.config, true));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.ListItem, new ListItemRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Text, rendererFactory.textRenderer);
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Link, new LinkRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Strong, new StrongRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Emphasis, new EmphasisRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Strikethrough, new StrikethroughRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Underline, new UnderlineRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Superscript, new SuperscriptRenderer());
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Subscript, new SubscriptRenderer());
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Highlight, new HighlightRenderer());
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Code, new CodeRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Image, new ImageRenderer());
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.LineBreak, rendererFactory.lineBreakRenderer);
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.SoftBreak, rendererFactory.softBreakRenderer);
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.ThematicBreak, new ThematicBreakRenderer(rendererFactory.config));
        mapCreateMapBuilder.put(MarkdownASTNode.NodeType.Spoiler, new SpoilerRenderer());
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final void registerImageSpan(ImageSpan span) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.onImageSpanCreated.invoke(span);
    }

    public final NodeRenderer getRenderer(MarkdownASTNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        NodeRenderer nodeRenderer = (NodeRenderer) getRenderers().get(node.getType());
        if (nodeRenderer != null) {
            return nodeRenderer;
        }
        Objects.toString(node.getType());
        return this.textRenderer;
    }

    public final void renderChildren(MarkdownASTNode node, SpannableStringBuilder builder, Function1 function1, Function1 function2) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(builder, "builder");
        for (MarkdownASTNode markdownASTNode : node.getChildren()) {
            getRenderer(markdownASTNode).render(markdownASTNode, builder, function1, function2, this);
        }
    }
}

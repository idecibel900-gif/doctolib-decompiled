package com.swmansion.enriched.markdown.utils.common;

import android.content.Context;
import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import com.swmansion.enriched.markdown.renderer.Renderer;
import com.swmansion.enriched.markdown.styles.StyleConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownSegmentRenderer {
    public static final MarkdownSegmentRenderer INSTANCE = new MarkdownSegmentRenderer();

    private MarkdownSegmentRenderer() {
    }

    public final List render(List segments, StyleConfig style, Context context, Function1 function1, Function1 function2) {
        StyleConfig styleConfig;
        Context context2;
        Function1 function3;
        Function1 function4;
        RenderedSegment codeBlock;
        RenderedSegment renderedSegmentRenderTextSegment;
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(context, "context");
        List<MarkdownSegment> list = segments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MarkdownSegment markdownSegment : list) {
            if (markdownSegment instanceof MarkdownSegment.Text) {
                styleConfig = style;
                context2 = context;
                function3 = function1;
                function4 = function2;
                renderedSegmentRenderTextSegment = INSTANCE.renderTextSegment(((MarkdownSegment.Text) markdownSegment).getNodes(), styleConfig, context2, function3, function4);
            } else {
                styleConfig = style;
                context2 = context;
                function3 = function1;
                function4 = function2;
                if (markdownSegment instanceof MarkdownSegment.Table) {
                    MarkdownSegment.Table table = (MarkdownSegment.Table) markdownSegment;
                    codeBlock = new RenderedSegment.Table(table.getNode(), SegmentSignature.INSTANCE.signatureForNode(table.getNode()) ^ 8386092197136564224L);
                } else if (markdownSegment instanceof MarkdownSegment.Math) {
                    SegmentSignature segmentSignature = SegmentSignature.INSTANCE;
                    MarkdownSegment.Math math = (MarkdownSegment.Math) markdownSegment;
                    codeBlock = new RenderedSegment.Math(math.getLatex(), segmentSignature.fnvMixString$react_native_enriched_markdown_release(segmentSignature.signatureForNode(null) ^ 7881708812900499456L, math.getLatex()));
                } else {
                    if (!(markdownSegment instanceof MarkdownSegment.CodeBlock)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    MarkdownSegment.CodeBlock codeBlock2 = (MarkdownSegment.CodeBlock) markdownSegment;
                    codeBlock = new RenderedSegment.CodeBlock(codeBlock2.getNode(), SegmentSignature.INSTANCE.signatureForNode(codeBlock2.getNode()) ^ 7161405564289810432L);
                }
                renderedSegmentRenderTextSegment = codeBlock;
            }
            arrayList.add(renderedSegmentRenderTextSegment);
            style = styleConfig;
            context = context2;
            function1 = function3;
            function2 = function4;
        }
        return arrayList;
    }

    private final RenderedSegment.Text renderTextSegment(List list, StyleConfig styleConfig, Context context, Function1 function1, Function1 function2) {
        MarkdownASTNode markdownASTNode = new MarkdownASTNode(MarkdownASTNode.NodeType.Document, null, null, list, 6, null);
        Renderer renderer = new Renderer();
        renderer.configure(styleConfig, context);
        return new RenderedSegment.Text(renderer.renderDocument(markdownASTNode, function1, function2), CollectionsKt.toList(renderer.getCollectedImageSpans()), styleConfig.getNeedsJustify(), renderer.getLastElementMarginBottom(), SegmentSignature.INSTANCE.signatureForNodes(list) ^ 8387242320658956288L);
    }
}

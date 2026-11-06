package com.swmansion.enriched.markdown.utils.common;

import com.swmansion.enriched.markdown.parser.MarkdownASTNode;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentSignature {
    public static final SegmentSignature INSTANCE = new SegmentSignature();

    private final long fnvMixByte(long j, byte b) {
        return (j ^ (((long) b) & 255)) * 1099511628211L;
    }

    private SegmentSignature() {
    }

    private final long fnvMixLong(long j, long j2) {
        for (int i = 0; i < 8; i++) {
            j = fnvMixByte(j, (byte) (255 & j2));
            j2 >>>= 8;
        }
        return j;
    }

    public final long fnvMixString$react_native_enriched_markdown_release(long j, String str) {
        if (str == null) {
            return j;
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        for (byte b : bytes) {
            j = fnvMixByte(j, b);
        }
        return j;
    }

    public final long signatureForNode(MarkdownASTNode markdownASTNode) {
        if (markdownASTNode == null) {
            return -3750763034362895579L;
        }
        long jFnvMixString$react_native_enriched_markdown_release = fnvMixString$react_native_enriched_markdown_release(fnvMixLong(-3750763034362895579L, markdownASTNode.getType().ordinal()), markdownASTNode.getContent());
        if (!markdownASTNode.getAttributes().isEmpty()) {
            for (String str : CollectionsKt.sorted(markdownASTNode.getAttributes().keySet())) {
                jFnvMixString$react_native_enriched_markdown_release = fnvMixString$react_native_enriched_markdown_release(fnvMixString$react_native_enriched_markdown_release(jFnvMixString$react_native_enriched_markdown_release, str), markdownASTNode.getAttributes().get(str));
            }
        }
        Iterator<MarkdownASTNode> it = markdownASTNode.getChildren().iterator();
        while (it.hasNext()) {
            jFnvMixString$react_native_enriched_markdown_release = fnvMixLong(jFnvMixString$react_native_enriched_markdown_release, signatureForNode(it.next()));
        }
        return jFnvMixString$react_native_enriched_markdown_release;
    }

    public final long signatureForNodes(List nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        Iterator it = nodes.iterator();
        long jFnvMixLong = -3750763034362895579L;
        while (it.hasNext()) {
            jFnvMixLong = fnvMixLong(jFnvMixLong, signatureForNode((MarkdownASTNode) it.next()));
        }
        return jFnvMixLong;
    }
}

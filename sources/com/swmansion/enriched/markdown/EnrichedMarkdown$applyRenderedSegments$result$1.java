package com.swmansion.enriched.markdown;

import android.view.View;
import com.swmansion.enriched.markdown.utils.common.RenderedSegment;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
/* synthetic */ class EnrichedMarkdown$applyRenderedSegments$result$1 extends FunctionReferenceImpl implements Function2 {
    EnrichedMarkdown$applyRenderedSegments$result$1(Object obj) {
        super(2, obj, EnrichedMarkdown.class, "viewMatchesSegmentKind", "viewMatchesSegmentKind(Landroid/view/View;Lcom/swmansion/enriched/markdown/utils/common/RenderedSegment;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(View p0, RenderedSegment p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return Boolean.valueOf(((EnrichedMarkdown) this.receiver).viewMatchesSegmentKind(p0, p1));
    }
}

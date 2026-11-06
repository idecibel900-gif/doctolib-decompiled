package com.swmansion.enriched.markdown.renderer;

import com.swmansion.enriched.markdown.spans.BaselineShiftSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscriptRenderer extends BaselineShiftRenderer {
    @Override // com.swmansion.enriched.markdown.renderer.BaselineShiftRenderer
    public float fontScale(RendererFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return factory.getStyleCache().getSubscriptFontScale();
    }

    @Override // com.swmansion.enriched.markdown.renderer.BaselineShiftRenderer
    public float baselineOffsetScale(RendererFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        return -factory.getStyleCache().getSubscriptBaselineOffsetScale();
    }

    @Override // com.swmansion.enriched.markdown.renderer.BaselineShiftRenderer
    public BaselineShiftSpan.SpanType spanType() {
        return BaselineShiftSpan.SpanType.SUBSCRIPT;
    }
}

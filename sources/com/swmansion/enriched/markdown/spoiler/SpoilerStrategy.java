package com.swmansion.enriched.markdown.spoiler;

import android.graphics.Canvas;
import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import com.swmansion.enriched.markdown.styles.SpoilerStyle;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface SpoilerStrategy {
    void applyStyle(SpoilerStyle spoilerStyle);

    void drawSegment(Canvas canvas, SpoilerDrawContext spoilerDrawContext, SegmentKey segmentKey, SegmentRect segmentRect);

    void pruneStaleSegments(Set set);

    void revealSpan(SpoilerSpan spoilerSpan, SpoilerDrawContext spoilerDrawContext, Function0 function0);

    void stop();
}

package com.swmansion.enriched.markdown.utils.text.span;

import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import com.swmansion.enriched.markdown.spans.CodeBlockSpan;
import com.swmansion.enriched.markdown.spans.ImageSpan;
import com.swmansion.enriched.markdown.spans.MarginBottomSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BlockSpacingKt {
    public static final LineHeightSpan createLineHeightSpan(float f) {
        return new com.swmansion.enriched.markdown.spans.LineHeightSpan(f);
    }

    public static final void applyLineHeightSkippingImages(SpannableStringBuilder builder, int i, int i2, float f) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object[] spans = builder.getSpans(i, i2, ImageSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList<ImageSpan> arrayList = new ArrayList();
        for (Object obj : spans) {
            if (!((ImageSpan) obj).isInline()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (ImageSpan imageSpan : arrayList) {
            arrayList2.add(TuplesKt.to(Integer.valueOf(builder.getSpanStart(imageSpan)), Integer.valueOf(builder.getSpanEnd(imageSpan))));
        }
        Object[] spans2 = builder.getSpans(i, i2, CodeBlockSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
        ArrayList arrayList3 = new ArrayList(spans2.length);
        for (Object obj2 : spans2) {
            CodeBlockSpan codeBlockSpan = (CodeBlockSpan) obj2;
            arrayList3.add(TuplesKt.to(Integer.valueOf(builder.getSpanStart(codeBlockSpan)), Integer.valueOf(builder.getSpanEnd(codeBlockSpan))));
        }
        for (Pair pair : CollectionsKt.sortedWith(CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3), new Comparator() { // from class: com.swmansion.enriched.markdown.utils.text.span.BlockSpacingKt$applyLineHeightSkippingImages$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj3, Object obj4) {
                return ComparisonsKt.compareValues((Integer) ((Pair) obj3).getFirst(), (Integer) ((Pair) obj4).getFirst());
            }
        })) {
            int iIntValue = ((Number) pair.getFirst()).intValue();
            int iIntValue2 = ((Number) pair.getSecond()).intValue();
            if (i < iIntValue) {
                builder.setSpan(createLineHeightSpan(f), i, iIntValue, 33);
            }
            if (iIntValue2 < i2 && builder.charAt(iIntValue2) == '\n') {
                iIntValue2++;
            }
            i = Math.max(i, iIntValue2);
        }
        if (i < i2) {
            builder.setSpan(createLineHeightSpan(f), i, i2, 33);
        }
    }

    public static final void applyMarginTop(SpannableStringBuilder builder, int i, float f) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (f <= 0.0f) {
            return;
        }
        builder.insert(i, "\n");
        builder.setSpan(new MarginBottomSpan(f), i, i + 1, 33);
    }

    public static final void applyMarginBottom(SpannableStringBuilder builder, float f) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        int length = builder.length();
        builder.append("\n");
        builder.setSpan(new MarginBottomSpan(f), length, builder.length(), 33);
    }
}

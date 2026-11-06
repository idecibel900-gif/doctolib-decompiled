package com.swmansion.enriched.markdown.spoiler;

import com.swmansion.enriched.markdown.spans.SpoilerSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SpoilerStrategyKt {
    public static final void revealSegments(SpoilerSpan span, Set segmentKeys, final Function0 onAllComplete, final Function1 cleanup, Function2 onSegment) {
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(segmentKeys, "segmentKeys");
        Intrinsics.checkNotNullParameter(onAllComplete, "onAllComplete");
        Intrinsics.checkNotNullParameter(cleanup, "cleanup");
        Intrinsics.checkNotNullParameter(onSegment, "onSegment");
        int iIdentityHashCode = System.identityHashCode(span);
        final ArrayList arrayList = new ArrayList();
        for (Object obj : segmentKeys) {
            if (((SegmentKey) obj).getSpanIdentity() == iIdentityHashCode) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            onAllComplete.invoke();
            return;
        }
        final int[] iArr = {arrayList.size()};
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            onSegment.invoke((SegmentKey) it.next(), new Function0() { // from class: com.swmansion.enriched.markdown.spoiler.SpoilerStrategyKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SpoilerStrategyKt.revealSegments$lambda$1(iArr, cleanup, arrayList, onAllComplete);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit revealSegments$lambda$1(int[] iArr, Function1 function1, List list, Function0 function0) {
        int i = iArr[0] - 1;
        iArr[0] = i;
        if (i <= 0) {
            function1.invoke(list);
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}

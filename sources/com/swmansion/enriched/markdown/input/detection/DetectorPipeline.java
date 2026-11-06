package com.swmansion.enriched.markdown.input.detection;

import android.text.Spannable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DetectorPipeline {
    private final List detectors = new ArrayList();

    public final void addDetector(TextDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        this.detectors.add(detector);
    }

    public final void processTextChange(Spannable spannable, String text, int i, int i2) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        Intrinsics.checkNotNullParameter(text, "text");
        for (WordResult wordResult : WordsUtils.INSTANCE.getAffectedWords(text, i, i2)) {
            Iterator it = this.detectors.iterator();
            while (it.hasNext()) {
                ((TextDetector) it.next()).processWord(spannable, wordResult);
            }
        }
    }

    public final List allTransientFormattingRanges(Spannable spannable) {
        Intrinsics.checkNotNullParameter(spannable, "spannable");
        List list = this.detectors;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((TextDetector) it.next()).transientFormattingRanges(spannable));
        }
        return arrayList;
    }
}

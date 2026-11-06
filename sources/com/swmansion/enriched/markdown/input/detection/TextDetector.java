package com.swmansion.enriched.markdown.input.detection;

import android.text.Spannable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface TextDetector {
    void processWord(Spannable spannable, WordResult wordResult);

    List transientFormattingRanges(Spannable spannable);
}

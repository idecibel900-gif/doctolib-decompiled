package com.swmansion.enriched.markdown.views;

/* JADX INFO: loaded from: classes4.dex */
public interface BlockSegmentView {

    public static final class DefaultImpls {
        public static int getSegmentMarginTop(BlockSegmentView blockSegmentView) {
            return 0;
        }
    }

    int getSegmentMarginBottom();

    int getSegmentMarginTop();
}

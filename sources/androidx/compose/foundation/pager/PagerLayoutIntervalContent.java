package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent {
    private final IntervalList intervals;
    private final Function1 key;
    private final Function4 pageContent;
    private final int pageCount;

    public PagerLayoutIntervalContent(Function4 function4, Function1 function1, int i) {
        this.pageContent = function4;
        this.key = function1;
        this.pageCount = i;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        mutableIntervalList.addInterval(i, new PagerIntervalContent(function1, function4));
        this.intervals = mutableIntervalList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList getIntervals() {
        return this.intervals;
    }
}

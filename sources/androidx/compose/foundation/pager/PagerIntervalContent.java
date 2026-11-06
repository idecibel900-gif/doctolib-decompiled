package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
public final class PagerIntervalContent implements LazyLayoutIntervalContent.Interval {
    private final Function4 item;
    private final Function1 key;

    public PagerIntervalContent(Function1 function1, Function4 function4) {
        this.key = function1;
        this.item = function4;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public Function1 getKey() {
        return this.key;
    }

    public final Function4 getItem() {
        return this.item;
    }
}

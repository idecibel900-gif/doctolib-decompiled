package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridInterval implements LazyLayoutIntervalContent.Interval {
    private final Function4 item;
    private final Function1 key;
    private final Function2 span;
    private final Function1 type;

    public LazyGridInterval(Function1 function1, Function2 function2, Function1 function3, Function4 function4) {
        this.key = function1;
        this.span = function2;
        this.type = function3;
        this.item = function4;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public Function1 getKey() {
        return this.key;
    }

    public final Function2 getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public Function1 getType() {
        return this.type;
    }

    public final Function4 getItem() {
        return this.item;
    }
}

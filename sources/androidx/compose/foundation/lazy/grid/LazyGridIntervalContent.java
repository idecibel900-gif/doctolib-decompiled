package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridIntervalContent extends LazyLayoutIntervalContent implements LazyGridScope {
    private boolean hasCustomSpans;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Function2 DefaultSpan = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridIntervalContent$Companion$DefaultSpan$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return GridItemSpan.m379boximpl(m388invoke_orMbw((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
        }

        /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
        public final long m388invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
            return LazyGridSpanKt.GridItemSpan(1);
        }
    };
    private final LazyGridSpanLayoutProvider spanLayoutProvider = new LazyGridSpanLayoutProvider(this);
    private final MutableIntervalList intervals = new MutableIntervalList();

    public LazyGridIntervalContent(Function1 function1) {
        function1.invoke(this);
    }

    public final LazyGridSpanLayoutProvider getSpanLayoutProvider$foundation_release() {
        return this.spanLayoutProvider;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public MutableIntervalList getIntervals() {
        return this.intervals;
    }

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridScope
    public void items(int i, Function1 function1, Function2 function2, Function1 function3, Function4 function4) {
        getIntervals().addInterval(i, new LazyGridInterval(function1, function2 == null ? DefaultSpan : function2, function3, function4));
        if (function2 != null) {
            this.hasCustomSpans = true;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

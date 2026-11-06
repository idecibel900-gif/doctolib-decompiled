package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes.dex */
public interface LazyGridScope {
    void items(int i, Function1 function1, Function2 function2, Function1 function3, Function4 function4);

    static /* synthetic */ void items$default(LazyGridScope lazyGridScope, int i, Function1 function1, Function2 function2, Function1 function3, Function4 function4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        if ((i2 & 4) != 0) {
            function2 = null;
        }
        if ((i2 & 8) != 0) {
            function3 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridScope.items.1
                public final Void invoke(int i3) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        lazyGridScope.items(i, function1, function2, function3, function4);
    }
}

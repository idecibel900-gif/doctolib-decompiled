package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutAnimateScrollScope {
    float calculateDistanceTo(int i);

    int getFirstVisibleItemIndex();

    int getLastVisibleItemIndex();

    Object scroll(Function2 function2, Continuation continuation);

    void snapToItem(ScrollScope scrollScope, int i, int i2);
}

package androidx.compose.foundation.lazy.grid;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridPrefetchStrategyKt {
    public static /* synthetic */ LazyGridPrefetchStrategy LazyGridPrefetchStrategy$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        return LazyGridPrefetchStrategy(i);
    }

    public static final LazyGridPrefetchStrategy LazyGridPrefetchStrategy(int i) {
        return new DefaultLazyGridPrefetchStrategy(i);
    }
}

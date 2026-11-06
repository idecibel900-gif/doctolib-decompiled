package androidx.compose.foundation.lazy.grid;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyGridSpanKt {
    public static final long GridItemSpan(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The span value should be higher than 0");
        }
        return GridItemSpan.m380constructorimpl(i);
    }
}

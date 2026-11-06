package androidx.compose.foundation.lazy.layout;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class LazyLayoutIntervalContent {
    public abstract IntervalList getIntervals();

    public final int getItemCount() {
        return getIntervals().getSize();
    }

    public final Object getContentType(int i) {
        IntervalList.Interval interval = getIntervals().get(i);
        return ((Interval) interval.getValue()).getType().invoke(Integer.valueOf(i - interval.getStartIndex()));
    }

    public final Object getKey(int i) {
        Object objInvoke;
        IntervalList.Interval interval = getIntervals().get(i);
        int startIndex = i - interval.getStartIndex();
        Function1 key = ((Interval) interval.getValue()).getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(startIndex))) == null) ? Lazy_androidKt.getDefaultLazyLayoutKey(i) : objInvoke;
    }

    public interface Interval {
        Function1 getKey();

        default Function1 getType() {
            return new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval$type$1
                public final Void invoke(int i) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            };
        }
    }
}

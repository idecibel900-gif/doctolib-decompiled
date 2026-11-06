package kotlin.comparisons;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    public static int maxOf(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = Math.max(i, i2);
        }
        return i;
    }

    public static int minOf(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = Math.min(i, i2);
        }
        return i;
    }
}

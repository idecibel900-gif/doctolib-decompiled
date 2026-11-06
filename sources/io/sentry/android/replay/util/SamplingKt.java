package io.sentry.android.replay.util;

import io.sentry.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SamplingKt {
    public static final boolean sample(Random random, Double d) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return d != null && d.doubleValue() >= random.nextDouble();
    }
}

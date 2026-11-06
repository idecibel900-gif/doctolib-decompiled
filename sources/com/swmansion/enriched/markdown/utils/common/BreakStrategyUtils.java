package com.swmansion.enriched.markdown.utils.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BreakStrategyUtils {
    public static final BreakStrategyUtils INSTANCE = new BreakStrategyUtils();

    private BreakStrategyUtils() {
    }

    public final int resolveBreakStrategy(String str) {
        if (Intrinsics.areEqual(str, "simple")) {
            return 0;
        }
        return Intrinsics.areEqual(str, "balanced") ? 2 : 1;
    }
}

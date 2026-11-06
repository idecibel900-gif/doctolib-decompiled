package com.facebook.yoga;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class YogaNodeFactory {
    public static final YogaNodeFactory INSTANCE = new YogaNodeFactory();

    private YogaNodeFactory() {
    }

    public static final YogaNode create(YogaConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new YogaNodeJNIFinalizer(config);
    }
}

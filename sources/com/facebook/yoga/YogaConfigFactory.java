package com.facebook.yoga;

/* JADX INFO: loaded from: classes3.dex */
public final class YogaConfigFactory {
    public static final YogaConfigFactory INSTANCE = new YogaConfigFactory();

    private YogaConfigFactory() {
    }

    public static final YogaConfig create() {
        return new YogaConfigJNIFinalizer();
    }
}

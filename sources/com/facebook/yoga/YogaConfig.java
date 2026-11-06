package com.facebook.yoga;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class YogaConfig {
    public static final Companion Companion = new Companion(null);
    private static int SPACING_TYPE = 1;

    public abstract void setErrata(YogaErrata yogaErrata);

    public abstract void setPointScaleFactor(float f);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

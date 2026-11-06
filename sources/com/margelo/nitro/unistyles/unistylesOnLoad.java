package com.margelo.nitro.unistyles;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class unistylesOnLoad {
    public static final Companion Companion = new Companion(null);
    private static boolean didLoad;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void initializeNative() {
            if (unistylesOnLoad.didLoad) {
                return;
            }
            System.loadLibrary("unistyles");
            unistylesOnLoad.didLoad = true;
        }
    }
}

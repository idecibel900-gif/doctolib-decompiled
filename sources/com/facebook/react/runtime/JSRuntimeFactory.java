package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JSRuntimeFactory {
    private static final Companion Companion = new Companion(null);

    @DoNotStrip
    private final HybridData mHybridData;

    public JSRuntimeFactory(HybridData mHybridData) {
        Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
        this.mHybridData = mHybridData;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("rninstance");
    }
}

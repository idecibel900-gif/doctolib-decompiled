package com.datadog.android.error.internal;

import android.content.Context;
import com.datadog.android.api.feature.Feature;
import com.datadog.android.api.feature.FeatureSdkCore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CrashReportsFeature implements Feature {
    public static final Companion Companion = new Companion(null);
    private final AtomicBoolean initialized;
    private final String name;
    private Thread.UncaughtExceptionHandler originalUncaughtExceptionHandler;
    private final FeatureSdkCore sdkCore;

    public CrashReportsFeature(FeatureSdkCore sdkCore) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        this.sdkCore = sdkCore;
        this.initialized = new AtomicBoolean(false);
        this.originalUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.name = "crash";
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        setupExceptionHandler(appContext);
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        resetOriginalExceptionHandler();
        this.initialized.set(false);
    }

    private final void setupExceptionHandler(Context context) {
        this.originalUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        new DatadogExceptionHandler(this.sdkCore, context).register();
    }

    private final void resetOriginalExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(this.originalUncaughtExceptionHandler);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

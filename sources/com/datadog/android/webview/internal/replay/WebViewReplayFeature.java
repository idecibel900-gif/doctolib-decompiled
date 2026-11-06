package com.datadog.android.webview.internal.replay;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.webview.internal.storage.WebViewDataWriter;
import com.datadog.android.webview.internal.storage.WebViewEventSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewReplayFeature implements StorageBackedFeature {
    public static final Companion Companion = new Companion(null);
    private static final FeatureStorageConfiguration STORAGE_CONFIGURATION = FeatureStorageConfiguration.copy$default(FeatureStorageConfiguration.Companion.getDEFAULT(), 10485760, 0, 10485760, 0, 10, null);
    private DataWriter dataWriter;
    private final AtomicBoolean initialized;
    private final String name;
    private final RequestFactory requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public WebViewReplayFeature(FeatureSdkCore sdkCore, RequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.sdkCore = sdkCore;
        this.requestFactory = requestFactory;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.name = "web-replay";
        this.storageConfiguration = STORAGE_CONFIGURATION;
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final DataWriter getDataWriter$dd_sdk_android_webview_release() {
        return this.dataWriter;
    }

    @Override // com.datadog.android.api.feature.Feature
    public String getName() {
        return this.name;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onInitialize(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.dataWriter = createDataWriter(this.sdkCore.getInternalLogger());
        this.initialized.set(true);
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.dataWriter = new NoOpDataWriter();
        this.initialized.set(false);
    }

    private final DataWriter createDataWriter(InternalLogger internalLogger) {
        return new WebViewDataWriter(new WebViewEventSerializer(), internalLogger);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

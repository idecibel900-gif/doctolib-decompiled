package com.datadog.android.webview.internal.rum;

import android.content.Context;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.feature.FeatureContextUpdateReceiver;
import com.datadog.android.api.feature.FeatureSdkCore;
import com.datadog.android.api.feature.StorageBackedFeature;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.api.storage.FeatureStorageConfiguration;
import com.datadog.android.api.storage.NoOpDataWriter;
import com.datadog.android.webview.internal.rum.domain.NativeRumViewsCache;
import com.datadog.android.webview.internal.rum.domain.WebViewNativeRumViewsCache;
import com.datadog.android.webview.internal.storage.WebViewDataWriter;
import com.datadog.android.webview.internal.storage.WebViewEventSerializer;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewRumFeature implements StorageBackedFeature, FeatureContextUpdateReceiver {
    public static final Companion Companion = new Companion(null);
    private DataWriter dataWriter;
    private final AtomicBoolean initialized;
    private final String name;
    private final NativeRumViewsCache nativeRumViewsCache;
    private final RequestFactory requestFactory;
    private final FeatureSdkCore sdkCore;
    private final FeatureStorageConfiguration storageConfiguration;

    public WebViewRumFeature(FeatureSdkCore sdkCore, RequestFactory requestFactory, NativeRumViewsCache nativeRumViewsCache) {
        Intrinsics.checkNotNullParameter(sdkCore, "sdkCore");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(nativeRumViewsCache, "nativeRumViewsCache");
        this.sdkCore = sdkCore;
        this.requestFactory = requestFactory;
        this.nativeRumViewsCache = nativeRumViewsCache;
        this.dataWriter = new NoOpDataWriter();
        this.initialized = new AtomicBoolean(false);
        this.name = "web-rum";
        this.storageConfiguration = FeatureStorageConfiguration.Companion.getDEFAULT();
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public RequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public /* synthetic */ WebViewRumFeature(FeatureSdkCore featureSdkCore, RequestFactory requestFactory, NativeRumViewsCache nativeRumViewsCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(featureSdkCore, requestFactory, (i & 4) != 0 ? new WebViewNativeRumViewsCache(0L, 1, null) : nativeRumViewsCache);
    }

    public final NativeRumViewsCache getNativeRumViewsCache$dd_sdk_android_webview_release() {
        return this.nativeRumViewsCache;
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
        this.sdkCore.setContextUpdateReceiver("web-rum", this);
        this.dataWriter = createDataWriter(this.sdkCore.getInternalLogger());
        this.initialized.set(true);
        this.nativeRumViewsCache.addToCache(this.sdkCore.getFeatureContext("rum"));
    }

    @Override // com.datadog.android.api.feature.FeatureContextUpdateReceiver
    public void onContextUpdate(String featureName, Map event) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(featureName, "rum")) {
            this.nativeRumViewsCache.addToCache(event);
        }
    }

    @Override // com.datadog.android.api.feature.StorageBackedFeature
    public FeatureStorageConfiguration getStorageConfiguration() {
        return this.storageConfiguration;
    }

    @Override // com.datadog.android.api.feature.Feature
    public void onStop() {
        this.sdkCore.removeContextUpdateReceiver("web-rum", this);
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

package com.datadog.reactnative;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class DdSdkReactNativePackage extends TurboReactPackage {
    private final DatadogSDKWrapper sdkWrapper = new DatadogSDKWrapper();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -1130275707:
                if (name.equals(NativeDdTraceSpec.NAME)) {
                    return new DdTrace(reactContext);
                }
                return null;
            case 65861066:
                if (name.equals(NativeDdRumSpec.NAME)) {
                    return new DdRum(reactContext, this.sdkWrapper);
                }
                return null;
            case 65861498:
                if (name.equals(NativeDdSdkSpec.NAME)) {
                    return new DdSdk(reactContext, this.sdkWrapper);
                }
                return null;
            case 2041508463:
                if (name.equals(NativeDdLogsSpec.NAME)) {
                    return new DdLogs(reactContext, this.sdkWrapper);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.datadog.reactnative.DdSdkReactNativePackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return DdSdkReactNativePackage.getReactModuleInfoProvider$lambda$1();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$1() {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{NativeDdSdkSpec.NAME, NativeDdRumSpec.NAME, NativeDdTraceSpec.NAME, NativeDdLogsSpec.NAME});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listListOf, 10)), 16));
        for (Object obj : listListOf) {
            String str = (String) obj;
            linkedHashMap.put(obj, new ReactModuleInfo(str, str, false, false, true, false, true));
        }
        return linkedHashMap;
    }
}

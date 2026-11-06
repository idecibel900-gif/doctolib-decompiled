package com.doctolib.apps.networking;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = "CacheModule")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0017¨\u0006\u000b"}, d2 = {"Lcom/doctolib/apps/networking/CacheModule;", "Lcom/doctolib/apps/networking/CacheModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "clear", "", "Companion", "doctolib_doctolib-apps-networking_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheModule extends CacheModuleSpec {
    public static final String NAME = "CacheModule";

    @Override // com.doctolib.apps.networking.NativeCacheModuleSpec
    @ReactMethod
    public void clear() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // com.doctolib.apps.networking.NativeCacheModuleSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CacheModule";
    }
}

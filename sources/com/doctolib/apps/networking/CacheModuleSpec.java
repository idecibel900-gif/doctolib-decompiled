package com.doctolib.apps.networking;

import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/doctolib/apps/networking/CacheModuleSpec;", "Lcom/doctolib/apps/networking/NativeCacheModuleSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "doctolib_doctolib-apps-networking_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CacheModuleSpec extends NativeCacheModuleSpec {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheModuleSpec(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }
}

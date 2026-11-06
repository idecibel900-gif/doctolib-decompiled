package com.teleport;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.teleport.host.PortalHostViewManager;
import com.teleport.portal.PortalViewManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class TeleportPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PortalHostViewManager());
        arrayList.add(new PortalViewManager());
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }
}

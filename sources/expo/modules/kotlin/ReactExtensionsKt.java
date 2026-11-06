package expo.modules.kotlin;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import expo.modules.adapters.react.NativeModulesProxy;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReactExtensionsKt {
    public static final NativeModulesProxy getUnimoduleProxy(ReactContext reactContext) {
        NativeModule nativeModule;
        Object next;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        if (!reactContext.isBridgeless()) {
            CatalystInstance catalystInstance = reactContext.getCatalystInstance();
            NativeModule nativeModule2 = catalystInstance != null ? catalystInstance.getNativeModule("NativeUnimoduleProxy") : null;
            if (nativeModule2 instanceof NativeModulesProxy) {
                return (NativeModulesProxy) nativeModule2;
            }
            return null;
        }
        Collection<NativeModule> nativeModules = ((ThemedReactContext) reactContext).getReactApplicationContext().getNativeModules();
        if (nativeModules != null) {
            Iterator<T> it = nativeModules.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((NativeModule) next) instanceof NativeModulesProxy));
            nativeModule = (NativeModule) next;
        } else {
            nativeModule = null;
        }
        if (nativeModule instanceof NativeModulesProxy) {
            return (NativeModulesProxy) nativeModule;
        }
        return null;
    }
}

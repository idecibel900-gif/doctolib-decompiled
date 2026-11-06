package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeModuleRegistryBuilder {
    private static final Companion Companion = new Companion(null);
    private final HashMap modules;
    private final ReactApplicationContext reactApplicationContext;

    public NativeModuleRegistryBuilder(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext;
        this.modules = new HashMap();
    }

    public final void processPackage(ReactPackage reactPackage) {
        Iterable<ModuleHolder> nativeModuleIterator;
        Intrinsics.checkNotNullParameter(reactPackage, "reactPackage");
        if (reactPackage instanceof BaseReactPackage) {
            nativeModuleIterator = ((BaseReactPackage) reactPackage).getNativeModuleIterator$ReactAndroid_release(this.reactApplicationContext);
        } else {
            nativeModuleIterator = ReactPackageHelper.INSTANCE.getNativeModuleIterator(reactPackage, this.reactApplicationContext);
        }
        for (ModuleHolder moduleHolder : nativeModuleIterator) {
            String name = moduleHolder.getName();
            ModuleHolder moduleHolder2 = (ModuleHolder) this.modules.get(name);
            if (moduleHolder2 != null && !moduleHolder.getCanOverrideExistingModule()) {
                throw new IllegalStateException(("\nNative module " + name + " tried to override " + moduleHolder2.getClassName() + ".\n\nCheck the getPackages() method in MainApplication.java, it might be that module is being created twice.\nIf this was your intention, set canOverrideExistingModule=true. This error may also be present if the\npackage is present only once in getPackages() but is also automatically added later during build time\nby autolinking. Try removing the existing entry and rebuild.\n").toString());
            }
            this.modules.put(name, moduleHolder);
        }
    }

    public final NativeModuleRegistry build() {
        return new NativeModuleRegistry(this.reactApplicationContext, this.modules);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("NativeModuleRegistryBuilder", LegacyArchitectureLogLevel.ERROR);
    }
}

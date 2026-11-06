package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseReactPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public abstract NativeModule getModule(String str, ReactApplicationContext reactApplicationContext);

    public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

    @Override // com.facebook.react.ReactPackage
    @Deprecated
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        throw new UnsupportedOperationException("createNativeModules method is not supported. Use getModule() method instead.");
    }

    public final Iterable<ModuleHolder> getNativeModuleIterator$ReactAndroid_release(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1(getReactModuleInfoProvider().getReactModuleInfos().entrySet().iterator(), this, reactContext);
    }

    protected List<ModuleSpec> getViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<ModuleSpec> viewManagers = getViewManagers(reactContext);
        List<ModuleSpec> list = viewManagers;
        if (list == null || list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ModuleSpec> it = viewManagers.iterator();
        while (it.hasNext()) {
            Object obj = it.next().provider().get();
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.react.uimanager.ViewManager<*, *>");
            arrayList.add((ViewManager) obj);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ModuleHolderProvider implements Provider {
        private final String name;
        private final ReactApplicationContext reactContext;
        final /* synthetic */ BaseReactPackage this$0;

        public ModuleHolderProvider(BaseReactPackage baseReactPackage, String name, ReactApplicationContext reactContext) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(reactContext, "reactContext");
            this.this$0 = baseReactPackage;
            this.name = name;
            this.reactContext = reactContext;
        }

        @Override // javax.inject.Provider
        public NativeModule get() {
            return this.this$0.getModule(this.name, this.reactContext);
        }
    }
}

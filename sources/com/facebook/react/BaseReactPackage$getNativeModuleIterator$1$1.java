package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import com.facebook.react.module.model.ReactModuleInfo;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class BaseReactPackage$getNativeModuleIterator$1$1 implements Iterator, KMappedMarker {
    final /* synthetic */ Iterator $entrySetIterator;
    final /* synthetic */ ReactApplicationContext $reactContext;
    private Map.Entry nextEntry;
    final /* synthetic */ BaseReactPackage this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    BaseReactPackage$getNativeModuleIterator$1$1(Iterator it, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.$entrySetIterator = it;
        this.this$0 = baseReactPackage;
        this.$reactContext = reactApplicationContext;
    }

    private final void findNext() {
        while (this.$entrySetIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) this.$entrySetIterator.next();
            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) entry.getValue();
            if (!ReactNativeNewArchitectureFeatureFlags.useTurboModules() || !reactModuleInfo.isTurboModule()) {
                this.nextEntry = entry;
                return;
            }
        }
        this.nextEntry = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextEntry == null) {
            findNext();
        }
        return this.nextEntry != null;
    }

    @Override // java.util.Iterator
    public ModuleHolder next() {
        if (this.nextEntry == null) {
            findNext();
        }
        Map.Entry entry = this.nextEntry;
        if (entry == null) {
            throw new NoSuchElementException("ModuleHolder not found");
        }
        findNext();
        return new ModuleHolder((ReactModuleInfo) entry.getValue(), new BaseReactPackage.ModuleHolderProvider(this.this$0, (String) entry.getKey(), this.$reactContext));
    }
}

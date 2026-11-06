package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactPackageHelper$getNativeModuleIterator$1$1 implements Iterator, KMappedMarker {
    final /* synthetic */ List $nativeModules;
    private int position;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    ReactPackageHelper$getNativeModuleIterator$1$1(List list) {
        this.$nativeModules = list;
    }

    @Override // java.util.Iterator
    public ModuleHolder next() {
        List list = this.$nativeModules;
        int i = this.position;
        this.position = i + 1;
        return new ModuleHolder((NativeModule) list.get(i));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.position < this.$nativeModules.size();
    }
}

package com.facebook.react;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1 implements Iterable, KMappedMarker {
    final /* synthetic */ List $nativeModules$inlined;

    public ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1(List list) {
        this.$nativeModules$inlined = list;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new ReactPackageHelper$getNativeModuleIterator$1$1(this.$nativeModules$inlined);
    }
}

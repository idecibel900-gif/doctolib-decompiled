package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1 implements Iterable, KMappedMarker {
    final /* synthetic */ Iterator $entrySetIterator$inlined;
    final /* synthetic */ ReactApplicationContext $reactContext$inlined;
    final /* synthetic */ BaseReactPackage this$0;

    public BaseReactPackage$getNativeModuleIterator$$inlined$Iterable$1(Iterator it, BaseReactPackage baseReactPackage, ReactApplicationContext reactApplicationContext) {
        this.$entrySetIterator$inlined = it;
        this.this$0 = baseReactPackage;
        this.$reactContext$inlined = reactApplicationContext;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new BaseReactPackage$getNativeModuleIterator$1$1(this.$entrySetIterator$inlined, this.this$0, this.$reactContext$inlined);
    }
}

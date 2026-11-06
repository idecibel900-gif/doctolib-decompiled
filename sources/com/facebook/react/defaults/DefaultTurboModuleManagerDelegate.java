package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000f\u000eB-\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/defaults/DefaultTurboModuleManagerDelegate;", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "context", "", "Lcom/facebook/react/ReactPackage;", "packages", "", "cxxReactPackages", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Ljava/util/List;)V", "Lcom/facebook/jni/HybridData;", "initHybrid", "()Lcom/facebook/jni/HybridData;", "Companion", "Builder", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private static final Companion Companion = new Companion(null);

    public /* synthetic */ DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, list, list2);
    }

    @DoNotStrip
    public static final native HybridData initHybrid(List<Object> list);

    private DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<? extends ReactPackage> list, List<Object> list2) {
        super(reactApplicationContext, list, Companion.initHybrid(list2));
    }

    @Override // com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate
    protected HybridData initHybrid() {
        throw new UnsupportedOperationException("DefaultTurboModuleManagerDelegate.initHybrid() must never be called!");
    }

    public static final class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        private final List cxxReactPackageProviders = new ArrayList();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder
        public DefaultTurboModuleManagerDelegate build(ReactApplicationContext context, List packages) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packages, "packages");
            List list = this.cxxReactPackageProviders;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, (Iterable) ((Function1) it.next()).invoke(context));
            }
            return new DefaultTurboModuleManagerDelegate(context, packages, arrayList, null);
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @DoNotStrip
        public final HybridData initHybrid(List<Object> list) {
            return DefaultTurboModuleManagerDelegate.initHybrid(list);
        }

        private Companion() {
        }
    }

    static {
        DefaultSoLoader.maybeLoadSoLibrary();
    }
}

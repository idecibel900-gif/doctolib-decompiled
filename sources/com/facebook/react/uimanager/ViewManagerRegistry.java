package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewManagerRegistry implements ComponentCallbacks2 {
    private final ViewManagerResolver viewManagerResolver;
    private final Map viewManagersMap;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    public ViewManagerRegistry(ViewManagerResolver viewManagerResolver) {
        Intrinsics.checkNotNullParameter(viewManagerResolver, "viewManagerResolver");
        this.viewManagersMap = new LinkedHashMap();
        this.viewManagerResolver = viewManagerResolver;
    }

    public ViewManagerRegistry(List viewManagerList) {
        Intrinsics.checkNotNullParameter(viewManagerList, "viewManagerList");
        List list = viewManagerList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((ViewManager) obj).getName(), obj);
        }
        this.viewManagersMap = MapsKt.toMutableMap(linkedHashMap);
        this.viewManagerResolver = null;
    }

    public final synchronized ViewManager get(String className) {
        try {
            Intrinsics.checkNotNullParameter(className, "className");
            ViewManager viewManager = (ViewManager) this.viewManagersMap.get(className);
            if (viewManager != null) {
                return viewManager;
            }
            String str = "RCT" + className;
            ViewManager viewManager2 = (ViewManager) this.viewManagersMap.get(str);
            if (viewManager2 != null) {
                return viewManager2;
            }
            if (this.viewManagerResolver != null) {
                ViewManager viewManagerFromResolver = getViewManagerFromResolver(className);
                if (viewManagerFromResolver != null) {
                    return viewManagerFromResolver;
                }
                ViewManager viewManagerFromResolver2 = getViewManagerFromResolver(str);
                if (viewManagerFromResolver2 != null) {
                    return viewManagerFromResolver2;
                }
                throw new IllegalViewOperationException("Can't find ViewManager '" + className + "' nor '" + str + "' in ViewManagerRegistry, existing names are: " + this.viewManagerResolver.getViewManagerNames());
            }
            throw new IllegalViewOperationException("No ViewManager found for class " + className);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final ViewManager getViewManagerFromResolver(String str) {
        ViewManagerResolver viewManagerResolver = this.viewManagerResolver;
        ViewManager viewManager = viewManagerResolver != null ? viewManagerResolver.getViewManager(str) : null;
        if (viewManager != null) {
            this.viewManagersMap.put(str, viewManager);
        }
        return viewManager;
    }

    public final synchronized ViewManager getViewManagerIfExists(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        ViewManager viewManager = (ViewManager) this.viewManagersMap.get(className);
        if (viewManager != null) {
            return viewManager;
        }
        return this.viewManagerResolver != null ? getViewManagerFromResolver(className) : null;
    }

    public final void onSurfaceStopped(final int i) {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.viewManagersMap.values());
        }
        final Function0 function0 = new Function0() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewManagerRegistry.onSurfaceStopped$lambda$6(arrayList, i);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            function0.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSurfaceStopped$lambda$6(List list, int i) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).onSurfaceStopped(i);
        }
        return Unit.INSTANCE;
    }

    public final void invalidate() {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.viewManagersMap.values());
        }
        final Function0 function0 = new Function0() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewManagerRegistry.invalidate$lambda$9(arrayList);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            function0.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invalidate$lambda$9(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).invalidate();
        }
        return Unit.INSTANCE;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        final ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.viewManagersMap.values());
        }
        final Function0 function0 = new Function0() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ViewManagerRegistry.onTrimMemory$lambda$12(arrayList);
            }
        };
        if (UiThreadUtil.isOnUiThread()) {
            function0.invoke();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.uimanager.ViewManagerRegistry$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onTrimMemory$lambda$12(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ViewManager) it.next()).trimMemory();
        }
        return Unit.INSTANCE;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(40);
    }
}

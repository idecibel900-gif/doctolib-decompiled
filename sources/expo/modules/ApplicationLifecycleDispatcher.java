package expo.modules;

import android.app.Application;
import android.content.res.Configuration;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.Package;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationLifecycleDispatcher {
    public static final ApplicationLifecycleDispatcher INSTANCE = new ApplicationLifecycleDispatcher();
    private static List listeners;

    private ApplicationLifecycleDispatcher() {
    }

    private final List getCachedListeners(Application application) {
        List list = listeners;
        if (list != null) {
            return list;
        }
        List packageList = ExpoModulesPackage.Companion.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator it = packageList.iterator();
        while (it.hasNext()) {
            List listCreateApplicationLifecycleListeners = ((Package) it.next()).createApplicationLifecycleListeners(application);
            Intrinsics.checkNotNullExpressionValue(listCreateApplicationLifecycleListeners, "createApplicationLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, listCreateApplicationLifecycleListeners);
        }
        listeners = arrayList;
        return arrayList;
    }

    public static final void onApplicationCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Iterator it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onCreate(application);
        }
    }

    public static final void onConfigurationChanged(Application application, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Iterator it = INSTANCE.getCachedListeners(application).iterator();
        while (it.hasNext()) {
            ((ApplicationLifecycleListener) it.next()).onConfigurationChanged(newConfig);
        }
    }
}

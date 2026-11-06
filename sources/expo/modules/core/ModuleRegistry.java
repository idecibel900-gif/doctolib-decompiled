package expo.modules.core;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.kotlin.AppContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ModuleRegistry {
    private final Map mInternalModulesMap = new HashMap();
    private final Map mSingletonModulesMap = new HashMap();
    private final List mExtraRegistryLifecycleListeners = new ArrayList();
    private volatile boolean mIsInitialized = false;
    private WeakReference mAppContextHolder = new WeakReference(null);

    public void setAppContext(AppContext appContext) {
        this.mAppContextHolder = new WeakReference(appContext);
    }

    public ModuleRegistry(Collection collection, Collection collection2) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            registerInternalModule((InternalModule) it.next());
        }
        Iterator it2 = collection2.iterator();
        while (it2.hasNext()) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it2.next());
            registerSingletonModule(null);
        }
    }

    public Object getModule(Class cls) {
        return this.mInternalModulesMap.get(cls);
    }

    public void registerInternalModule(InternalModule internalModule) {
        Iterator it = internalModule.getExportedInterfaces().iterator();
        while (it.hasNext()) {
            this.mInternalModulesMap.put((Class) it.next(), internalModule);
        }
    }

    public void registerSingletonModule(SingletonModule singletonModule) {
        this.mSingletonModulesMap.put(singletonModule.getName(), singletonModule);
    }

    public synchronized void ensureIsInitialized() {
        if (!this.mIsInitialized) {
            initialize();
            this.mIsInitialized = true;
        }
    }

    public void initialize() {
        ArrayList arrayList = new ArrayList(this.mInternalModulesMap.values());
        Iterator it = this.mExtraRegistryLifecycleListeners.iterator();
        while (it.hasNext()) {
            RegistryLifecycleListener registryLifecycleListener = (RegistryLifecycleListener) ((WeakReference) it.next()).get();
            if (registryLifecycleListener != null) {
                arrayList.add(registryLifecycleListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((RegistryLifecycleListener) it2.next()).onCreate(this);
        }
    }

    public void onDestroy() {
        ArrayList arrayList = new ArrayList(this.mInternalModulesMap.values());
        Iterator it = this.mExtraRegistryLifecycleListeners.iterator();
        while (it.hasNext()) {
            RegistryLifecycleListener registryLifecycleListener = (RegistryLifecycleListener) ((WeakReference) it.next()).get();
            if (registryLifecycleListener != null) {
                arrayList.add(registryLifecycleListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((RegistryLifecycleListener) it2.next()).onDestroy();
        }
    }
}

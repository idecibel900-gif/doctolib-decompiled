package expo.modules.kotlin;

import androidx.tracing.Trace;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ModuleRegistry implements Iterable, KMappedMarker {
    private final WeakReference appContextHolder;
    private final List eventQueue;
    private boolean isReadyForPostingEvents;
    private final Map registry;

    public ModuleRegistry(WeakReference appContextHolder) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        this.appContextHolder = appContextHolder;
        this.registry = new LinkedHashMap();
        this.eventQueue = new ArrayList();
    }

    public final Map getRegistry() {
        return this.registry;
    }

    public final void register(Module module, String str) {
        Intrinsics.checkNotNullParameter(module, "module");
        Trace.beginSection("[ExpoModulesCore] " + ("ModuleRegistry.register(" + module.getClass() + ")"));
        try {
            if (this.appContextHolder.get() != null) {
                module.set_appContextHolder$expo_modules_core_release(this.appContextHolder);
                final ModuleHolder moduleHolder = new ModuleHolder(module, str);
                module.setCoroutineScopeDelegate(LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.ModuleRegistry$register$1$2
                    @Override // kotlin.jvm.functions.Function0
                    public final CoroutineScope invoke() {
                        return CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new CoroutineName(moduleHolder.getName())));
                    }
                }));
                getRegistry().put(moduleHolder.getName(), moduleHolder);
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                return;
            }
            throw new IllegalArgumentException("Cannot register a module to an invalid app context.");
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final ModuleRegistry register(ModulesProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        for (Map.Entry entry : provider.getModulesMap().entrySet()) {
            Class cls = (Class) entry.getKey();
            String str = (String) entry.getValue();
            Module module = (Module) cls.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(module);
            register(module, str);
        }
        return this;
    }

    public final boolean hasModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.registry.containsKey(name);
    }

    public final ModuleHolder getModuleHolder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (ModuleHolder) this.registry.get(name);
    }

    public final ModuleHolder getModuleHolder(Module module) {
        Object next;
        Intrinsics.checkNotNullParameter(module, "module");
        Iterator it = this.registry.values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((ModuleHolder) next).getModule() != module);
        if (next instanceof ModuleHolder) {
            return (ModuleHolder) next;
        }
        return null;
    }

    public final ModuleHolder getModuleHolder(Class viewClass) {
        ModuleHolder moduleHolder;
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Iterator it = this.registry.entrySet().iterator();
        do {
            moduleHolder = null;
            if (!it.hasNext()) {
                break;
            }
            ModuleHolder moduleHolder2 = (ModuleHolder) ((Map.Entry) it.next()).getValue();
            if (getViewDefinition(moduleHolder2, viewClass) != null) {
                moduleHolder = moduleHolder2;
            }
        } while (moduleHolder == null);
        return moduleHolder;
    }

    public final ViewManagerDefinition getViewDefinition(ModuleHolder holder, Class viewClass) {
        Object next;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Iterator it = holder.getDefinition().getViewManagerDefinitions().values().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (Intrinsics.areEqual(((ViewManagerDefinition) next).getViewType$expo_modules_core_release(), viewClass)) {
                return (ViewManagerDefinition) next;
            }
        }
        next = null;
        return (ViewManagerDefinition) next;
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded$default(this, eventName, null, null, 6, null)) {
            return;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName);
        }
    }

    public final void post(EventName eventName, Object obj) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded$default(this, eventName, obj, null, 4, null)) {
            return;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, obj);
        }
    }

    public final void post(EventName eventName, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (addToQueueIfNeeded(eventName, obj, obj2)) {
            return;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(eventName, obj, obj2);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.registry.values().iterator();
    }

    public final void cleanUp() {
        this.registry.clear();
        CoreLoggerKt.getLogger().info("✅ ModuleRegistry was destroyed");
    }

    private final void readyForPostingEvents() {
        synchronized (this) {
            this.isReadyForPostingEvents = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void flushTheEventQueue() {
        synchronized (this) {
            try {
                for (PostponedEvent postponedEvent : this.eventQueue) {
                    Iterator it = iterator();
                    while (it.hasNext()) {
                        postponedEvent.post((ModuleHolder) it.next());
                    }
                }
                this.eventQueue.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ boolean addToQueueIfNeeded$default(ModuleRegistry moduleRegistry, EventName eventName, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 2) != 0) {
            obj = null;
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        return moduleRegistry.addToQueueIfNeeded(eventName, obj, obj2);
    }

    private final boolean addToQueueIfNeeded(EventName eventName, Object obj, Object obj2) {
        synchronized (this) {
            if (this.isReadyForPostingEvents) {
                return false;
            }
            this.eventQueue.add(new PostponedEvent(eventName, obj, obj2));
            return true;
        }
    }

    public static final class PostponedEvent {
        private final EventName eventName;
        private final Object payload;
        private final Object sender;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PostponedEvent)) {
                return false;
            }
            PostponedEvent postponedEvent = (PostponedEvent) obj;
            return this.eventName == postponedEvent.eventName && Intrinsics.areEqual(this.sender, postponedEvent.sender) && Intrinsics.areEqual(this.payload, postponedEvent.payload);
        }

        public int hashCode() {
            int iHashCode = this.eventName.hashCode() * 31;
            Object obj = this.sender;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.payload;
            return iHashCode2 + (obj2 != null ? obj2.hashCode() : 0);
        }

        public String toString() {
            return "PostponedEvent(eventName=" + this.eventName + ", sender=" + this.sender + ", payload=" + this.payload + ")";
        }

        public PostponedEvent(EventName eventName, Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.sender = obj;
            this.payload = obj2;
        }

        public final void post(ModuleHolder moduleHolder) {
            Object obj;
            Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
            Object obj2 = this.sender;
            if (obj2 != null && (obj = this.payload) != null) {
                moduleHolder.post(this.eventName, obj2, obj);
            } else if (obj2 != null) {
                moduleHolder.post(this.eventName, obj2);
            } else {
                moduleHolder.post(this.eventName);
            }
        }
    }

    public final void postOnCreate() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).post(EventName.MODULE_CREATE);
        }
        registerActivityContracts$expo_modules_core_release();
        readyForPostingEvents();
        flushTheEventQueue();
    }

    public final void registerActivityContracts$expo_modules_core_release() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((ModuleHolder) it.next()).registerContracts();
        }
    }
}

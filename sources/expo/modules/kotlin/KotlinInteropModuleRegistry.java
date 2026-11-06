package expo.modules.kotlin;

import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.views.GroupViewManagerWrapper;
import expo.modules.kotlin.views.SimpleViewManagerWrapper;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerType;
import expo.modules.kotlin.views.ViewManagerWrapperDelegate;
import expo.modules.kotlin.views.ViewWrapperDelegateHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class KotlinInteropModuleRegistry {
    private final AppContext appContext;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewManagerType.values().length];
            try {
                iArr[ViewManagerType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewManagerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KotlinInteropModuleRegistry(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, WeakReference reactContext) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.appContext = new AppContext(modulesProvider, legacyModuleRegistry, reactContext);
    }

    public final AppContext getAppContext() {
        return this.appContext;
    }

    public final List exportViewManagers() {
        BaseViewManager simpleViewManagerWrapper;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.exportViewManagers");
        try {
            ModuleRegistry<ModuleHolder> registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder moduleHolder : registry) {
                Map viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
                ArrayList arrayList2 = new ArrayList(viewManagerDefinitions.size());
                for (Map.Entry entry : viewManagerDefinitions.entrySet()) {
                    String str = (String) entry.getKey();
                    ViewManagerDefinition viewManagerDefinition = (ViewManagerDefinition) entry.getValue();
                    ViewManagerWrapperDelegate viewManagerWrapperDelegate = new ViewManagerWrapperDelegate(moduleHolder, viewManagerDefinition, Intrinsics.areEqual(str, "DEFAULT_MODULE_VIEW") ? moduleHolder.getName() : null);
                    int i = WhenMappings.$EnumSwitchMapping$0[viewManagerDefinition.getViewManagerType().ordinal()];
                    if (i == 1) {
                        simpleViewManagerWrapper = new SimpleViewManagerWrapper(viewManagerWrapperDelegate);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        simpleViewManagerWrapper = new GroupViewManagerWrapper(viewManagerWrapperDelegate);
                    }
                    arrayList2.add(simpleViewManagerWrapper);
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final List extractViewManagersDelegateHolders(List viewManagers) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.extractViewManagersDelegateHolders");
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : viewManagers) {
                if (obj instanceof ViewWrapperDelegateHolder) {
                    arrayList.add(obj);
                }
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void updateModuleHoldersInViewManagers(List viewWrapperHolders) {
        Intrinsics.checkNotNullParameter(viewWrapperHolders, "viewWrapperHolders");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.updateModuleHoldersInViewManagers");
        try {
            List list = viewWrapperHolders;
            ArrayList<ViewManagerWrapperDelegate> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ViewWrapperDelegateHolder) it.next()).getViewWrapperDelegate());
            }
            for (ViewManagerWrapperDelegate viewManagerWrapperDelegate : arrayList) {
                ModuleHolder moduleHolder = getRegistry().getModuleHolder(viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName());
                if (moduleHolder == null) {
                    throw new IllegalArgumentException(("Cannot update the module holder for " + viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName() + ".").toString());
                }
                viewManagerWrapperDelegate.setModuleHolder$expo_modules_core_release(moduleHolder);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final Map viewManagersMetadata() {
        String name;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.viewManagersMetadata");
        try {
            ModuleRegistry<ModuleHolder> registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder moduleHolder : registry) {
                Map viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
                ArrayList arrayList2 = new ArrayList(viewManagerDefinitions.size());
                for (Map.Entry entry : viewManagerDefinitions.entrySet()) {
                    String str = (String) entry.getKey();
                    ViewManagerDefinition viewManagerDefinition = (ViewManagerDefinition) entry.getValue();
                    if (Intrinsics.areEqual(str, "DEFAULT_MODULE_VIEW")) {
                        name = moduleHolder.getName();
                    } else {
                        name = moduleHolder.getName() + "_" + str;
                    }
                    arrayList2.add(TuplesKt.to(name, MapsKt.mapOf(TuplesKt.to("propsNames", viewManagerDefinition.getPropsNames()))));
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
            return MapsKt.toMap(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleRegistry getRegistry() {
        return this.appContext.getRegistry();
    }

    public final boolean hasModule(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getRegistry().hasModule(name);
    }

    public final void callMethod(String moduleName, String method, ReadableArray arguments, Promise promise) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ModuleHolder moduleHolder = getRegistry().getModuleHolder(moduleName);
            if (moduleHolder == null) {
                throw new IllegalArgumentException(("Trying to call '" + method + "' on the non-existing module '" + moduleName + "'").toString());
            }
            Object[] array = arguments.toArrayList().toArray();
            Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
            moduleHolder.call(method, array, promise);
        } catch (CodedException e) {
            promise.reject(e);
        } catch (Throwable th) {
            promise.reject(new UnexpectedException(th));
        }
    }

    public final void onDestroy() {
        this.appContext.onDestroy$expo_modules_core_release();
        CoreLoggerKt.getLogger().info("✅ KotlinInteropModuleRegistry was destroyed");
    }

    public final void installJSIInterop() {
        this.appContext.installJSIInterop();
    }

    public final void emitOnCreate() {
        this.appContext.onCreate();
    }

    public final void setLegacyModulesProxy(NativeModulesProxy proxyModule) {
        Intrinsics.checkNotNullParameter(proxyModule, "proxyModule");
        this.appContext.setLegacyModulesProxyHolder$expo_modules_core_release(new WeakReference(proxyModule));
    }
}

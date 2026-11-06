package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.UIManagerHelper;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.logging.Logger;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.DefaultAppContextActivityResultCaller;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions$IncorrectThreadException;
import expo.modules.kotlin.exception.Exceptions$MissingActivity;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import expo.modules.kotlin.runtime.MainRuntime;
import expo.modules.kotlin.runtime.WorkletRuntime;
import expo.modules.kotlin.services.AppDirectoriesService;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.services.ServicesRegistry;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AppContext implements CurrentActivityProvider {
    private final ActivityResultsManager activityResultsManager;
    private final DefaultAppContextActivityResultCaller appContextActivityResultCaller;
    private final CoroutineScope backgroundCoroutineScope;
    private final Lazy errorManager$delegate;
    private boolean hostWasDestroyed;
    private final MainRuntime hostingRuntimeContext;
    private final Lazy jsLogger$delegate;
    private final expo.modules.core.ModuleRegistry legacyModuleRegistry;
    private WeakReference legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    private final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;
    private final ServicesRegistry services;
    private final Lazy uiRuntimeHolder;

    public final void onCreate() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onCreate");
        try {
            getRegistry().postOnCreate();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void onDestroy$expo_modules_core_release() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onDestroy");
        try {
            ReactApplicationContext reactContext = getRuntime().getReactContext();
            if (reactContext != null) {
                reactContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
                reactContext.removeActivityEventListener(this.reactLifecycleDelegate);
            }
            ModuleRegistry registry = getRegistry();
            registry.post(EventName.MODULE_DESTROY);
            registry.cleanUp();
            CoroutineScopeKt.cancel(getModulesQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getMainQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getBackgroundCoroutineScope(), new ContextDestroyedException(null, 1, null));
            getRuntime().deallocate$expo_modules_core_release();
            if (this.uiRuntimeHolder.isInitialized()) {
                getUiRuntime().deallocate$expo_modules_core_release();
            }
            CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public AppContext(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, final WeakReference reactContextHolder) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyModuleRegistry = legacyModuleRegistry;
        this.hostingRuntimeContext = new MainRuntime(this, reactContextHolder);
        this.uiRuntimeHolder = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.uiRuntimeHolder$lambda$0(this.f$0, reactContextHolder);
            }
        });
        ReactLifecycleDelegate reactLifecycleDelegate = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate;
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), null, 1, null);
        this.modulesQueueDispatcher = handlerDispatcherFrom$default;
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(handlerDispatcherFrom$default.plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new CoroutineName("expo.modules.MainQueue")));
        ModuleRegistry moduleRegistry = new ModuleRegistry(UtilsKt.weak(this));
        this.registry = moduleRegistry;
        ServicesRegistry servicesRegistry = new ServicesRegistry(UtilsKt.weak(this));
        this.services = servicesRegistry;
        ActivityResultsManager activityResultsManager = new ActivityResultsManager(this);
        this.activityResultsManager = activityResultsManager;
        this.appContextActivityResultCaller = new DefaultAppContextActivityResultCaller(activityResultsManager);
        Object obj = reactContextHolder.get();
        if (obj == null) {
            throw new IllegalArgumentException("The app context should be created with valid react context.");
        }
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) obj;
        legacyModuleRegistry.setAppContext(this);
        reactApplicationContext.addLifecycleEventListener(reactLifecycleDelegate);
        reactApplicationContext.addActivityEventListener(reactLifecycleDelegate);
        servicesRegistry.register(FilePermissionService.class);
        servicesRegistry.register(AppDirectoriesService.class);
        servicesRegistry.register(modulesProvider.getServices());
        moduleRegistry.register(new NativeModulesProxyModule(), null);
        moduleRegistry.register(new JSLoggerModule(), null);
        moduleRegistry.register(modulesProvider);
        registerInlineModulesList();
        CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
        this.errorManager$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.errorManager_delegate$lambda$7(this.f$0);
            }
        });
        this.jsLogger$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.jsLogger_delegate$lambda$8(this.f$0);
            }
        });
    }

    public final expo.modules.core.ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final MainRuntime getRuntime() {
        return this.hostingRuntimeContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkletRuntime uiRuntimeHolder$lambda$0(AppContext appContext, WeakReference weakReference) {
        return new WorkletRuntime(appContext, weakReference);
    }

    public final WorkletRuntime getUiRuntime() {
        return (WorkletRuntime) this.uiRuntimeHolder.getValue();
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final ServicesRegistry getServices() {
        return this.services;
    }

    public final WeakReference getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    public final DefaultAppContextActivityResultCaller getAppContextActivityResultCaller$expo_modules_core_release() {
        return this.appContextActivityResultCaller;
    }

    private final void registerInlineModulesList() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName("inline.modules.ExpoInlineModulesList").getConstructor(null).newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
            this.registry.register((ModulesProvider) objNewInstance);
        } catch (ClassNotFoundException unused) {
        }
    }

    public final void installJSIInterop() {
        getRuntime().install$expo_modules_core_release();
    }

    public final EventEmitter eventEmitter(Module module) {
        Object module2;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            module2 = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module2 = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module2;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, getRuntime().getReactContextHolder());
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(this.registry.getRegistry().keySet(), ", ", null, null, 0, null, null, 62, null);
        throw new IllegalArgumentException(("Cannot create an event emitter for module " + module.getClass() + " that isn't present in the module registry. Available modules: [" + strJoinToString$default + "].").toString());
    }

    public final ActivityProvider getActivityProvider() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ActivityProvider) module;
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, getRuntime().getReactContextHolder());
    }

    public final Permissions getPermissions() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            module = null;
        }
        return (Permissions) module;
    }

    private final AppDirectoriesService getAppDirectories() {
        Object obj = getServices().getRegistry().get(AppDirectoriesService.class);
        if (!(obj instanceof AppDirectoriesService)) {
            obj = null;
        }
        AppDirectoriesService appDirectoriesService = (AppDirectoriesService) obj;
        if (appDirectoriesService != null) {
            return appDirectoriesService;
        }
        throw new IllegalStateException("AppDirectoriesService is not registered in the ServicesRegistry.");
    }

    public final FilePermissionService getFilePermission() {
        Object obj = getServices().getRegistry().get(FilePermissionService.class);
        if (!(obj instanceof FilePermissionService)) {
            obj = null;
        }
        FilePermissionService filePermissionService = (FilePermissionService) obj;
        if (filePermissionService != null) {
            return filePermissionService;
        }
        throw new IllegalStateException("FilePermissionService is not registered in the ServicesRegistry.");
    }

    public final File getPersistentFilesDirectory() {
        return getAppDirectories().getPersistentFilesDirectory();
    }

    public final File getCacheDirectory() {
        return getAppDirectories().getCacheDirectory();
    }

    public final Context getReactContext() {
        return getRuntime().getReactContext();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        return reactContext != null && reactContext.hasActiveReactInstance();
    }

    public final JSLoggerModule getErrorManager() {
        return (JSLoggerModule) this.errorManager$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSLoggerModule errorManager_delegate$lambda$7(AppContext appContext) {
        Object next;
        Module module;
        Iterator it = appContext.registry.getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            module = ((ModuleHolder) next).getModule();
        } while (!(module != null ? module instanceof JSLoggerModule : true));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        return (JSLoggerModule) (module2 instanceof JSLoggerModule ? module2 : null);
    }

    public final Logger getJsLogger() {
        return (Logger) this.jsLogger$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger jsLogger_delegate$lambda$8(AppContext appContext) {
        Object next;
        Iterator it = appContext.registry.getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof JSLoggerModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof JSLoggerModule)) {
            module = null;
        }
        JSLoggerModule jSLoggerModule = (JSLoggerModule) module;
        if (jSLoggerModule != null) {
            return jSLoggerModule.getLogger();
        }
        return null;
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
        }
        if (this.hostWasDestroyed) {
            this.hostWasDestroyed = false;
            this.registry.registerActivityContracts$expo_modules_core_release();
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onUserLeaveHint$expo_modules_core_release() {
        this.registry.post(EventName.ON_USER_LEAVES_ACTIVITY);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.registry.post(EventName.ACTIVITY_DESTROYS);
        this.hostWasDestroyed = true;
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(i, i2, intent);
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(i, i2, intent));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    public final View findView(int i) {
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactContext, i);
        View viewResolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(i) : null;
        if (viewResolveView != null) {
            return viewResolveView;
        }
        return null;
    }

    public final void assertMainThread$expo_modules_core_release() throws Exceptions$IncorrectThreadException {
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return;
        }
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = Looper.getMainLooper().getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        throw new Exceptions$IncorrectThreadException(name, name2);
    }

    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext != null) {
            reactContext.runOnJSQueueThread(runnable);
        }
    }

    @Override // expo.modules.kotlin.providers.CurrentActivityProvider
    public Activity getCurrentActivity() {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null) {
            return currentActivity;
        }
        Context reactContext = getReactContext();
        ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final Activity getThrowingActivity() throws Exceptions$MissingActivity {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            Context reactContext = getReactContext();
            ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
            currentActivity = reactApplicationContext != null ? reactApplicationContext.getCurrentActivity() : null;
        }
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions$MissingActivity();
    }
}

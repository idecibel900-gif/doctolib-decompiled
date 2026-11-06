package expo.modules.updates;

import android.content.Context;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.events.UpdatesEventManager;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.procedures.RecreateReactContextProcedure;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.statemachine.UpdatesStateMachine;
import expo.modules.updates.statemachine.UpdatesStateValue;
import expo.modules.updatesinterface.UpdatesInterface;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DisabledUpdatesController implements IUpdatesController, UpdatesInterface {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = DisabledUpdatesController.class.getSimpleName();
    private final Context context;
    private final CoroutineScope controllerScope;
    private final IUpdatesEventManager eventManager;
    private final Exception fatalException;
    private final boolean isActiveController;
    private boolean isStarted;
    private Launcher launcher;
    private final CompletableDeferred loaderTaskFinishedDeferred;
    private final Mutex loaderTaskFinishedMutex;
    private final UpdatesLogger logger;
    private WeakReference reactHost;
    private Long startupEndTimeMillis;
    private Long startupStartTimeMillis;
    private final UpdatesStateMachine stateMachine;
    private WeakReference weakActivity;

    @Override // expo.modules.updates.IUpdatesController
    public ReloadScreenManager getReloadScreenManager() {
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
    }

    public DisabledUpdatesController(Context context, Exception exc) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fatalException = exc;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.controllerScope = CoroutineScope;
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        this.logger = updatesLogger;
        this.eventManager = new UpdatesEventManager(updatesLogger);
        this.stateMachine = new UpdatesStateMachine(updatesLogger, getEventManager(), SetsKt.setOf((Object[]) new UpdatesStateValue[]{UpdatesStateValue.Idle, UpdatesStateValue.Restarting}), CoroutineScope);
        this.loaderTaskFinishedDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.loaderTaskFinishedMutex = MutexKt.Mutex$default(false, 1, null);
        this.reactHost = new WeakReference(null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesEventManager getEventManager() {
        return this.eventManager;
    }

    /* JADX INFO: renamed from: getLaunchDuration-FghU774, reason: not valid java name */
    private final Duration m4967getLaunchDurationFghU774() {
        Long l = this.startupStartTimeMillis;
        if (l != null) {
            long jLongValue = l.longValue();
            Long l2 = this.startupEndTimeMillis;
            if (l2 != null) {
                return Duration.m5399boximpl(DurationKt.toDuration(l2.longValue() - jLongValue, DurationUnit.MILLISECONDS));
            }
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getLaunchAssetFile() {
        BuildersKt__BuildersKt.runBlocking$default(null, new DisabledUpdatesController$launchAssetFile$1(this, null), 1, null);
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchAssetFile();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public WeakReference getReactHost() {
        return this.reactHost;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setReactHost(WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.reactHost = weakReference;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onEventListenerStartObserving() {
        this.stateMachine.sendContextToJS();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstance(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.weakActivity = new WeakReference(reactContext.getCurrentActivity());
    }

    @Override // expo.modules.updates.IUpdatesController
    public boolean isActiveController() {
        return this.isActiveController;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        this.startupStartTimeMillis = Long.valueOf(System.currentTimeMillis());
        this.launcher = new NoDatabaseLauncher(this.context, this.logger, this.fatalException, this.controllerScope);
        this.startupEndTimeMillis = Long.valueOf(System.currentTimeMillis());
        notifyController();
    }

    public static final class UpdatesDisabledException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatesDisabledException(String message) {
            super(message, null, 2, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        UpdateEntity launchedUpdate;
        Map mapMo4981getLocalAssetFiles;
        Launcher launcher = this.launcher;
        if (launcher != null) {
            launchedUpdate = launcher.getLaunchedUpdate();
            mapMo4981getLocalAssetFiles = null;
        } else {
            launchedUpdate = null;
            mapMo4981getLocalAssetFiles = null;
        }
        Duration durationM4967getLaunchDurationFghU774 = m4967getLaunchDurationFghU774();
        Exception exc = this.fatalException;
        Launcher launcher2 = this.launcher;
        boolean zIsUsingEmbeddedAssets = launcher2 != null ? launcher2.isUsingEmbeddedAssets() : false;
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration = UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER;
        Map mapEmptyMap = MapsKt.emptyMap();
        Launcher launcher3 = this.launcher;
        if (launcher3 != null) {
            mapMo4981getLocalAssetFiles = launcher3.mo4981getLocalAssetFiles();
        }
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, durationM4967getLaunchDurationFghU774, null, exc, false, zIsUsingEmbeddedAssets, null, checkAutomaticallyConfiguration, mapEmptyMap, mapMo4981getLocalAssetFiles, false, this.stateMachine.getContext(), null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object checkForUpdate(Continuation continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.checkForUpdateAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object fetchUpdate(Continuation continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.fetchUpdateAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object getExtraParams(Continuation continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.getExtraParamsAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object setExtraParam(String str, String str2, Continuation continuation) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setExtraParamAsync() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride updatesConfigurationOverride) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setUpdateURLAndRequestHeadersOverride() is not supported when expo-updates is not enabled.");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateRequestHeadersOverride(Map map) throws UpdatesDisabledException {
        throw new UpdatesDisabledException("Updates.setUpdateRequestHeadersOverride() is not supported when expo-updates is not enabled.");
    }

    /* JADX INFO: renamed from: expo.modules.updates.DisabledUpdatesController$notifyController$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DisabledUpdatesController.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            DisabledUpdatesController disabledUpdatesController;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = DisabledUpdatesController.this.loaderTaskFinishedMutex;
                DisabledUpdatesController disabledUpdatesController2 = DisabledUpdatesController.this;
                this.L$0 = mutex;
                this.L$1 = disabledUpdatesController2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                disabledUpdatesController = disabledUpdatesController2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                disabledUpdatesController = (DisabledUpdatesController) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                if (!disabledUpdatesController.loaderTaskFinishedDeferred.isCompleted()) {
                    if (disabledUpdatesController.launcher != null) {
                        disabledUpdatesController.loaderTaskFinishedDeferred.complete(Unit.INSTANCE);
                    } else {
                        throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
                    }
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    private final synchronized void notifyController() {
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object relaunchReactApplicationForModule(Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.stateMachine.queueExecution(new RecreateReactContextProcedure(this.context, this.weakActivity, new Launcher.LauncherCallback() { // from class: expo.modules.updates.DisabledUpdatesController$relaunchReactApplicationForModule$2$procedure$1
            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onFailure(Exception e) {
                CodedException unexpectedException;
                CodedException codedException;
                Intrinsics.checkNotNullParameter(e, "e");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                if (e instanceof CodedException) {
                    codedException = (CodedException) e;
                } else {
                    if (e instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) e;
                        String code = codedException2.getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException = new CodedException(code, codedException2.getMessage(), codedException2.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(e);
                    }
                    codedException = unexpectedException;
                }
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(codedException)));
            }

            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onSuccess() {
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m5243constructorimpl(Unit.INSTANCE));
            }
        }, this.controllerScope));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}

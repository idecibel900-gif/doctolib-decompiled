package expo.modules.updates;

import android.content.Context;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.easclient.EASClientID;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.updates.db.BuildData;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.events.IUpdatesEventManager;
import expo.modules.updates.events.UpdatesEventManager;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.EmbeddedManifestUtils;
import expo.modules.updates.manifest.EmbeddedUpdate;
import expo.modules.updates.procedures.CheckForUpdateProcedure;
import expo.modules.updates.procedures.FetchUpdateProcedure;
import expo.modules.updates.procedures.RelaunchProcedure;
import expo.modules.updates.procedures.StartupProcedure;
import expo.modules.updates.reloadscreen.ReloadScreenManager;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.selectionpolicy.SelectionPolicyFactory;
import expo.modules.updates.statemachine.UpdatesStateMachine;
import expo.modules.updates.statemachine.UpdatesStateValue;
import expo.modules.updatesinterface.UpdatesInterface;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class EnabledUpdatesController implements IUpdatesController, UpdatesInterface {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = EnabledUpdatesController.class.getSimpleName();
    private final Context context;
    private final CoroutineScope controllerScope;
    private final DatabaseHolder databaseHolder;
    private final IUpdatesEventManager eventManager;
    private final boolean isActiveController;
    private final boolean isEnabled;
    private boolean isStarted;
    private boolean isStartupFinished;
    private final UpdatesLogger logger;
    private WeakReference reactHost;
    private final ReloadScreenManager reloadScreenManager;
    private Long startupEndTimeMillis;
    private final CompletableDeferred startupFinishedDeferred;
    private final Mutex startupFinishedMutex;
    private final StartupProcedure startupProcedure;
    private Long startupStartTimeMillis;
    private final Map stateChangeListenerMap;
    private final UpdatesStateMachine stateMachine;
    private UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;
    private WeakReference weakActivity;

    public EnabledUpdatesController(Context context, UpdatesConfiguration updatesConfiguration, File updatesDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.updatesDirectory = updatesDirectory;
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogger updatesLogger = new UpdatesLogger(filesDir);
        this.logger = updatesLogger;
        this.eventManager = new UpdatesEventManager(updatesLogger);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.controllerScope = CoroutineScope;
        this.stateMachine = new UpdatesStateMachine(updatesLogger, getEventManager(), CollectionsKt.toSet(UpdatesStateValue.getEntries()), CoroutineScope);
        DatabaseHolder databaseHolder = new DatabaseHolder(UpdatesDatabase.INSTANCE.getInstance(context, Dispatchers.getIO()));
        this.databaseHolder = databaseHolder;
        this.startupFinishedDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.startupFinishedMutex = MutexKt.Mutex$default(false, 1, null);
        this.reloadScreenManager = new ReloadScreenManager();
        this.reactHost = new WeakReference(null);
        this.stateChangeListenerMap = new LinkedHashMap();
        this.startupProcedure = new StartupProcedure(context, this.updatesConfiguration, databaseHolder, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), updatesLogger, new StartupProcedure.StartupProcedureCallback() { // from class: expo.modules.updates.EnabledUpdatesController$startupProcedure$1
            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onFinished() {
                this.this$0.onStartupProcedureFinished();
            }

            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onRequestRelaunch(boolean z, Launcher.LauncherCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.this$0.relaunchReactApplication(z, callback);
            }
        }, CoroutineScope);
        this.isActiveController = true;
        this.isEnabled = true;
    }

    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesEventManager getEventManager() {
        return this.eventManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectionPolicy getSelectionPolicy() {
        return SelectionPolicyFactory.createFilterAwarePolicy(this.updatesConfiguration.getRuntimeVersion(), this.updatesConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileDownloader getFileDownloader() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        String string = new EASClientID(this.context).getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new FileDownloader(filesDir, string, this.updatesConfiguration, this.logger, this.databaseHolder.getDatabase());
    }

    @Override // expo.modules.updates.IUpdatesController
    public ReloadScreenManager getReloadScreenManager() {
        return this.reloadScreenManager;
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

    public final Map getStateChangeListenerMap$expo_updates_release() {
        return this.stateChangeListenerMap;
    }

    private final void purgeUpdatesLogsOlderThanOneDay() {
        File filesDir = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        UpdatesLogReader.purgeLogEntries$default(new UpdatesLogReader(filesDir), null, new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnabledUpdatesController.purgeUpdatesLogsOlderThanOneDay$lambda$0((Exception) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purgeUpdatesLogsOlderThanOneDay$lambda$0(Exception exc) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: expo.modules.updates.EnabledUpdatesController$onStartupProcedureFinished$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EnabledUpdatesController.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            EnabledUpdatesController enabledUpdatesController;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = EnabledUpdatesController.this.startupFinishedMutex;
                EnabledUpdatesController enabledUpdatesController2 = EnabledUpdatesController.this;
                this.L$0 = mutex;
                this.L$1 = enabledUpdatesController2;
                this.label = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                enabledUpdatesController = enabledUpdatesController2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                enabledUpdatesController = (EnabledUpdatesController) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                if (!enabledUpdatesController.startupFinishedDeferred.isCompleted()) {
                    enabledUpdatesController.startupFinishedDeferred.complete(Unit.INSTANCE);
                }
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutex.unlock(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onStartupProcedureFinished() {
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new AnonymousClass1(null), 3, null);
        this.isStartupFinished = true;
        this.startupEndTimeMillis = Long.valueOf(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdateEntity getLaunchedUpdate() {
        return this.startupProcedure.getLaunchedUpdate();
    }

    /* JADX INFO: renamed from: getLaunchDuration-FghU774, reason: not valid java name */
    private final Duration m4970getLaunchDurationFghU774() {
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

    private final boolean isUsingEmbeddedAssets() {
        return this.startupProcedure.isUsingEmbeddedAssets();
    }

    private final Map getLocalAssetFiles() {
        return this.startupProcedure.getLocalAssetFiles();
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getLaunchAssetFile() {
        BuildersKt__BuildersKt.runBlocking$default(null, new EnabledUpdatesController$launchAssetFile$1(this, null), 1, null);
        return this.startupProcedure.getLaunchAssetFile();
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        return this.startupProcedure.getBundleAssetName();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onEventListenerStartObserving() {
        this.stateMachine.sendContextToJS();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.startupProcedure.onDidCreateDevSupportManager(devSupportManager);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstance(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.weakActivity = new WeakReference(reactContext.getCurrentActivity());
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.startupProcedure.onReactInstanceException(exception);
    }

    @Override // expo.modules.updates.IUpdatesController
    public boolean isActiveController() {
        return this.isActiveController;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized void start() {
        try {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            this.startupStartTimeMillis = Long.valueOf(System.currentTimeMillis());
            purgeUpdatesLogsOlderThanOneDay();
            if (!this.updatesConfiguration.getHasUpdatesOverride()) {
                BuildData.INSTANCE.ensureBuildDataIsConsistent(this.updatesConfiguration, this.databaseHolder.getDatabase());
            }
            this.stateMachine.queueExecution(this.startupProcedure);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void relaunchReactApplication(boolean z, Launcher.LauncherCallback launcherCallback) {
        this.stateMachine.queueExecution(new RelaunchProcedure(this.context, this.weakActivity, this.updatesConfiguration, this.logger, this.databaseHolder, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), new Function0() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnabledUpdatesController.relaunchReactApplication$lambda$3(this.f$0);
            }
        }, new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EnabledUpdatesController.relaunchReactApplication$lambda$4(this.f$0, (Launcher) obj);
            }
        }, z, getReloadScreenManager(), launcherCallback, this.controllerScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Launcher relaunchReactApplication$lambda$3(EnabledUpdatesController enabledUpdatesController) {
        Launcher launcher = enabledUpdatesController.startupProcedure.getLauncher();
        Intrinsics.checkNotNull(launcher);
        return launcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit relaunchReactApplication$lambda$4(EnabledUpdatesController enabledUpdatesController, Launcher currentLauncher) {
        Intrinsics.checkNotNullParameter(currentLauncher, "currentLauncher");
        enabledUpdatesController.startupProcedure.setLauncher(currentLauncher);
        return Unit.INSTANCE;
    }

    private final UpdateEntity getEmbeddedUpdate() {
        EmbeddedUpdate embeddedUpdate = EmbeddedManifestUtils.INSTANCE.getEmbeddedUpdate(this.context, this.updatesConfiguration);
        if (embeddedUpdate != null) {
            return embeddedUpdate.getUpdateEntity();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        return new IUpdatesController.UpdatesModuleConstants(getLaunchedUpdate(), m4970getLaunchDurationFghU774(), getEmbeddedUpdate(), this.startupProcedure.getEmergencyLaunchException(), true, isUsingEmbeddedAssets(), this.updatesConfiguration.getRuntimeVersionRaw(), this.updatesConfiguration.getCheckOnLaunch(), this.updatesConfiguration.getRequestHeaders(), getLocalAssetFiles(), false, this.stateMachine.getContext(), null);
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object checkForUpdate(Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.stateMachine.queueExecution(new CheckForUpdateProcedure(this.context, this.updatesConfiguration, this.databaseHolder, this.logger, getFileDownloader(), getSelectionPolicy(), getLaunchedUpdate(), new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$checkForUpdate$2$procedure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IUpdatesController.CheckForUpdateResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IUpdatesController.CheckForUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(it));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object fetchUpdate(Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.stateMachine.queueExecution(new FetchUpdateProcedure(this.context, this.updatesConfiguration, this.logger, this.databaseHolder, getUpdatesDirectory(), getFileDownloader(), getSelectionPolicy(), getLaunchedUpdate(), this.controllerScope, new Function1() { // from class: expo.modules.updates.EnabledUpdatesController$fetchUpdate$2$procedure$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IUpdatesController.FetchUpdateResult) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IUpdatesController.FetchUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(it));
            }
        }));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object getExtraParams(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new EnabledUpdatesController$getExtraParams$2$1(this, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object relaunchReactApplicationForModule(Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (getLaunchedUpdate() != null) {
            relaunchReactApplication(true, new Launcher.LauncherCallback() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$2$2
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
            });
        } else {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m5243constructorimpl(ResultKt.createFailure(new CodedException() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$2$1
            })));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // expo.modules.updates.IUpdatesController
    public Object setExtraParam(String str, String str2, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(this.controllerScope, null, null, new EnabledUpdatesController$setExtraParam$2$1(this, str, str2, cancellableContinuationImpl, null), 3, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateURLAndRequestHeadersOverride(UpdatesConfigurationOverride updatesConfigurationOverride) throws CodedException {
        if (!this.updatesConfiguration.getDisableAntiBrickingMeasures()) {
            throw new CodedException("ERR_UPDATES_RUNTIME_OVERRIDE", "Must set disableAntiBrickingMeasures configuration to use updates overriding", null);
        }
        UpdatesConfigurationOverride.Companion.save$expo_updates_release(this.context, updatesConfigurationOverride);
        this.updatesConfiguration = UpdatesConfiguration.Companion.create(this.context, this.updatesConfiguration, updatesConfigurationOverride);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setUpdateRequestHeadersOverride(Map map) throws CodedException {
        UpdatesConfiguration.Companion companion = UpdatesConfiguration.Companion;
        if (!companion.isValidRequestHeadersOverride$expo_updates_release(this.updatesConfiguration.getOriginalEmbeddedRequestHeaders(), map)) {
            throw new CodedException("ERR_UPDATES_RUNTIME_OVERRIDE", "Invalid update requestHeaders override: " + map, null);
        }
        this.updatesConfiguration = companion.create(this.context, this.updatesConfiguration, UpdatesConfigurationOverride.Companion.saveRequestHeaders$expo_updates_release(this.context, map));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

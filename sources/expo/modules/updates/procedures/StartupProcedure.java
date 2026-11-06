package expo.modules.updates.procedures;

import android.content.Context;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.errorrecovery.ErrorRecovery;
import expo.modules.updates.errorrecovery.ErrorRecoveryDelegate;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import java.io.File;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
public final class StartupProcedure extends StateMachineProcedure {
    private final StartupProcedureCallback callback;
    private final Context context;
    private final DatabaseHolder databaseHolder;
    private Exception emergencyLaunchException;
    private final ErrorRecovery errorRecovery;
    private final FileDownloader fileDownloader;
    private Launcher launcher;
    private final LoaderTask loaderTask;
    private final UpdatesLogger logger;
    private final String loggerTimerLabel;
    private StateMachineProcedure.ProcedureContext procedureContext;
    private final CoroutineScope procedureScope;
    private ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
    private final SelectionPolicy selectionPolicy;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;

    public interface StartupProcedureCallback {
        void onFinished();

        void onRequestRelaunch(boolean z, Launcher.LauncherCallback launcherCallback);
    }

    public StartupProcedure(Context context, UpdatesConfiguration updatesConfiguration, DatabaseHolder databaseHolder, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, StartupProcedureCallback callback, CoroutineScope procedureScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(databaseHolder, "databaseHolder");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(procedureScope, "procedureScope");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.databaseHolder = databaseHolder;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.callback = callback;
        this.procedureScope = procedureScope;
        this.loggerTimerLabel = "timer-startup";
        this.errorRecovery = new ErrorRecovery(logger);
        this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
        this.loaderTask = new LoaderTask(context, updatesConfiguration, databaseHolder, updatesDirectory, fileDownloader, selectionPolicy, logger, new LoaderTask.LoaderTaskCallback() { // from class: expo.modules.updates.procedures.StartupProcedure$loaderTask$1

            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[UpdatesStateValue.values().length];
                    try {
                        iArr[UpdatesStateValue.Idle.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UpdatesStateValue.Checking.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[LoaderTask.RemoteUpdateStatus.values().length];
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.UPDATE_AVAILABLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.NO_UPDATE_AVAILABLE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public boolean onCachedUpdateLoaded(UpdateEntity update) {
                Intrinsics.checkNotNullParameter(update, "update");
                return true;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFailure(Exception e) {
                Intrinsics.checkNotNullParameter(e, "e");
                this.this$0.logger.error("UpdatesController loaderTask onFailure", e, UpdatesErrorCode.None);
                this.this$0.launcher = new NoDatabaseLauncher(this.this$0.context, this.this$0.logger, e, this.this$0.procedureScope);
                this.this$0.emergencyLaunchException = e;
                this.this$0.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onSuccess(Launcher launcher, boolean z) {
                Intrinsics.checkNotNullParameter(launcher, "launcher");
                if (this.this$0.remoteLoadStatus == ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING && z) {
                    this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                }
                this.this$0.launcher = launcher;
                this.this$0.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFinishedAllLoading() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                StateMachineProcedure.ProcedureContext procedureContext2 = null;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.EndStartup());
                StateMachineProcedure.ProcedureContext procedureContext3 = this.this$0.procedureContext;
                if (procedureContext3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                } else {
                    procedureContext2 = procedureContext3;
                }
                procedureContext2.onComplete();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateStarted() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Check());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateFinished(LoaderTask.RemoteCheckResult result) {
                UpdatesStateEvent checkCompleteWithRollback;
                UpdatesStateEvent checkCompleteUnavailable;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result instanceof LoaderTask.RemoteCheckResult.NoUpdateAvailable) {
                    checkCompleteUnavailable = new UpdatesStateEvent.CheckCompleteUnavailable();
                } else {
                    if (result instanceof LoaderTask.RemoteCheckResult.UpdateAvailable) {
                        checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithUpdate(((LoaderTask.RemoteCheckResult.UpdateAvailable) result).getManifest());
                    } else {
                        if (!(result instanceof LoaderTask.RemoteCheckResult.RollBackToEmbedded)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithRollback(((LoaderTask.RemoteCheckResult.RollBackToEmbedded) result).getCommitTime());
                    }
                    checkCompleteUnavailable = checkCompleteWithRollback;
                }
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(checkCompleteUnavailable);
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateManifestResponseUpdateLoaded(Update update) {
                Intrinsics.checkNotNullParameter(update, "update");
                this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateLoadStarted() {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Download());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateAssetLoaded(AssetEntity asset, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(asset, "asset");
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("assetInfo", MapsKt.mapOf(TuplesKt.to("name", asset.getEmbeddedAssetFilename()), TuplesKt.to("successfulAssetCount", Integer.valueOf(i)), TuplesKt.to("failedAssetCount", Integer.valueOf(i2)), TuplesKt.to("totalAssetCount", Integer.valueOf(i3)))));
                this.this$0.logger.info("AppController appLoaderTask didLoadAsset: " + mapMapOf, UpdatesErrorCode.None, null, asset.getExpectedHash());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateProgressChanged(double d) {
                StateMachineProcedure.ProcedureContext procedureContext = this.this$0.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.DownloadProgress(d));
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateFinished(LoaderTask.RemoteUpdateStatus status, UpdateEntity updateEntity, Exception exc) {
                Intrinsics.checkNotNullParameter(status, "status");
                int i = WhenMappings.$EnumSwitchMapping$1[status.ordinal()];
                StateMachineProcedure.ProcedureContext procedureContext = null;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                            this.this$0.logger.info("UpdatesController onBackgroundUpdateFinished: No update available", UpdatesErrorCode.NoUpdatesAvailable);
                            StateMachineProcedure.ProcedureContext procedureContext2 = this.this$0.procedureContext;
                            if (procedureContext2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                                procedureContext2 = null;
                            }
                            if (procedureContext2.getCurrentState() == UpdatesStateValue.Downloading) {
                                StateMachineProcedure.ProcedureContext procedureContext3 = this.this$0.procedureContext;
                                if (procedureContext3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                                } else {
                                    procedureContext = procedureContext3;
                                }
                                procedureContext.processStateEvent(new UpdatesStateEvent.DownloadComplete());
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else if (updateEntity != null) {
                        this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED;
                        this.this$0.logger.info("UpdatesController onBackgroundUpdateFinished: Update available", UpdatesErrorCode.None);
                        StateMachineProcedure.ProcedureContext procedureContext4 = this.this$0.procedureContext;
                        if (procedureContext4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext4;
                        }
                        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadCompleteWithUpdate(updateEntity.getManifest()));
                    } else {
                        throw new AssertionError("Background update with error status must have a nonnull update object");
                    }
                } else if (exc != null) {
                    this.this$0.logger.error("UpdatesController onBackgroundUpdateFinished", exc, UpdatesErrorCode.Unknown);
                    this.this$0.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                    StateMachineProcedure.ProcedureContext procedureContext5 = this.this$0.procedureContext;
                    if (procedureContext5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        procedureContext5 = null;
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$0[procedureContext5.getCurrentState().ordinal()];
                    if (i2 == 1) {
                        StateMachineProcedure.ProcedureContext procedureContext6 = this.this$0.procedureContext;
                        if (procedureContext6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            procedureContext6 = null;
                        }
                        procedureContext6.processStateEvent(new UpdatesStateEvent.Download());
                        StateMachineProcedure.ProcedureContext procedureContext7 = this.this$0.procedureContext;
                        if (procedureContext7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext7;
                        }
                        String message = exc.getMessage();
                        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadError(message != null ? message : ""));
                    } else if (i2 != 2) {
                        StateMachineProcedure.ProcedureContext procedureContext8 = this.this$0.procedureContext;
                        if (procedureContext8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext8;
                        }
                        String message2 = exc.getMessage();
                        procedureContext.processStateEvent(new UpdatesStateEvent.DownloadError(message2 != null ? message2 : ""));
                    } else {
                        StateMachineProcedure.ProcedureContext procedureContext9 = this.this$0.procedureContext;
                        if (procedureContext9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext = procedureContext9;
                        }
                        String message3 = exc.getMessage();
                        procedureContext.processStateEvent(new UpdatesStateEvent.CheckError(message3 != null ? message3 : ""));
                    }
                } else {
                    throw new AssertionError("Background update with error status must have a nonnull exception object");
                }
                this.this$0.errorRecovery.notifyNewRemoteLoadStatus(this.this$0.remoteLoadStatus);
            }
        }, procedureScope);
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public String getLoggerTimerLabel() {
        return this.loggerTimerLabel;
    }

    public final Launcher getLauncher() {
        return this.launcher;
    }

    public final void setLauncher(Launcher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.launcher = launcher;
    }

    public final String getLaunchAssetFile() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchAssetFile();
        }
        return null;
    }

    public final String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    public final Map getLocalAssetFiles() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.mo4981getLocalAssetFiles();
        }
        return null;
    }

    public final boolean isUsingEmbeddedAssets() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.isUsingEmbeddedAssets();
        }
        return false;
    }

    public final UpdateEntity getLaunchedUpdate() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchedUpdate();
        }
        return null;
    }

    public final Exception getEmergencyLaunchException() {
        return this.emergencyLaunchException;
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public Object run(StateMachineProcedure.ProcedureContext procedureContext, Continuation continuation) {
        this.procedureContext = procedureContext;
        procedureContext.processStateEvent(new UpdatesStateEvent.StartStartup());
        initializeErrorRecovery();
        Object objStart = this.loaderTask.start(continuation);
        return objStart == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStart : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyController() {
        if (this.launcher == null) {
            throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
        }
        this.callback.onFinished();
    }

    public final void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        if (this.emergencyLaunchException != null) {
            return;
        }
        this.errorRecovery.startMonitoring(devSupportManager);
    }

    public final void onReactInstanceException(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.errorRecovery.onReactInstanceException$expo_updates_release(exception);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus) {
        this.remoteLoadStatus = remoteLoadStatus;
        this.errorRecovery.notifyNewRemoteLoadStatus(remoteLoadStatus);
    }

    private final void initializeErrorRecovery() {
        this.errorRecovery.initialize(new ErrorRecoveryDelegate() { // from class: expo.modules.updates.procedures.StartupProcedure.initializeErrorRecovery.1
            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void loadRemoteUpdate() {
                if (StartupProcedure.this.loaderTask.isRunning()) {
                    return;
                }
                StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$loadRemoteUpdate$1(new RemoteLoader(StartupProcedure.this.context, StartupProcedure.this.updatesConfiguration, StartupProcedure.this.logger, StartupProcedure.this.databaseHolder.getDatabase(), StartupProcedure.this.fileDownloader, StartupProcedure.this.updatesDirectory, StartupProcedure.this.getLaunchedUpdate(), StartupProcedure.this.procedureScope), StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void relaunch(Launcher.LauncherCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                StartupProcedure.this.callback.onRequestRelaunch(false, callback);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void throwException(Exception exception) throws Exception {
                Intrinsics.checkNotNullParameter(exception, "exception");
                throw exception;
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void markFailedLaunchForLaunchedUpdate() {
                if (StartupProcedure.this.getEmergencyLaunchException() != null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$markFailedLaunchForLaunchedUpdate$1(StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public void markSuccessfulLaunchForLaunchedUpdate() {
                if (StartupProcedure.this.getEmergencyLaunchException() != null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(StartupProcedure.this.procedureScope, null, null, new StartupProcedure$initializeErrorRecovery$1$markSuccessfulLaunchForLaunchedUpdate$1(StartupProcedure.this, null), 3, null);
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public ErrorRecoveryDelegate.RemoteLoadStatus getRemoteLoadStatus() {
                return StartupProcedure.this.remoteLoadStatus;
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckAutomaticallyConfiguration() {
                return StartupProcedure.this.updatesConfiguration.getCheckOnLaunch();
            }

            @Override // expo.modules.updates.errorrecovery.ErrorRecoveryDelegate
            public int getLaunchedUpdateSuccessfulLaunchCount() {
                UpdateEntity launchedUpdate = StartupProcedure.this.getLaunchedUpdate();
                if (launchedUpdate != null) {
                    return launchedUpdate.getSuccessfulLaunchCount();
                }
                return 0;
            }
        });
    }
}

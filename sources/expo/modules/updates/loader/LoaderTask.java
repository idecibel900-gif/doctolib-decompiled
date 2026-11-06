package expo.modules.updates.loader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.Reaper;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.ResponseHeaderData;
import expo.modules.updates.manifest.Update;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import java.io.File;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class LoaderTask {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = LoaderTask.class.getSimpleName();
    private final LoaderTaskCallback callback;
    private Launcher candidateLauncher;
    private final UpdatesConfiguration configuration;
    private final Context context;
    private final DatabaseHolder databaseHolder;
    private final File directory;
    private final FileDownloader fileDownloader;
    private Launcher finalizedLauncher;
    private final HandlerThread handlerThread;
    private boolean hasLaunched;
    private boolean isReadyToLaunch;
    private boolean isRunning;
    private boolean isUpToDate;
    private final UpdatesLogger logger;
    private final CoroutineScope scope;
    private final SelectionPolicy selectionPolicy;
    private boolean timeoutFinished;

    public interface LoaderTaskCallback {
        boolean onCachedUpdateLoaded(UpdateEntity updateEntity);

        void onFailure(Exception exc);

        void onFinishedAllLoading();

        void onRemoteCheckForUpdateFinished(RemoteCheckResult remoteCheckResult);

        void onRemoteCheckForUpdateStarted();

        void onRemoteUpdateAssetLoaded(AssetEntity assetEntity, int i, int i2, int i3);

        void onRemoteUpdateFinished(RemoteUpdateStatus remoteUpdateStatus, UpdateEntity updateEntity, Exception exc);

        void onRemoteUpdateLoadStarted();

        void onRemoteUpdateManifestResponseUpdateLoaded(Update update);

        void onRemoteUpdateProgressChanged(double d);

        void onSuccess(Launcher launcher, boolean z);
    }

    public enum RemoteUpdateStatus {
        ERROR,
        NO_UPDATE_AVAILABLE,
        UPDATE_AVAILABLE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchFallbackUpdateFromDisk$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return LoaderTask.this.launchFallbackUpdateFromDisk(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchRemoteUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11021 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11021(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return LoaderTask.this.launchRemoteUpdate(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$launchRemoteUpdateInBackground$1, reason: invalid class name and case insensitive filesystem */
    static final class C11031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11031(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return LoaderTask.this.launchRemoteUpdateInBackground(this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.updates.loader.LoaderTask$start$1, reason: invalid class name and case insensitive filesystem */
    static final class C11041 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11041(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return LoaderTask.this.start(this);
        }
    }

    public LoaderTask(Context context, UpdatesConfiguration configuration, DatabaseHolder databaseHolder, File directory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, LoaderTaskCallback callback, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(databaseHolder, "databaseHolder");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.context = context;
        this.configuration = configuration;
        this.databaseHolder = databaseHolder;
        this.directory = directory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.callback = callback;
        this.scope = scope;
        this.handlerThread = new HandlerThread("expo-updates-timer");
    }

    public enum RemoteCheckResultNotAvailableReason {
        NO_UPDATE_AVAILABLE_ON_SERVER("noUpdateAvailableOnServer"),
        UPDATE_REJECTED_BY_SELECTION_POLICY("updateRejectedBySelectionPolicy"),
        UPDATE_PREVIOUSLY_FAILED("updatePreviouslyFailed"),
        ROLLBACK_REJECTED_BY_SELECTION_POLICY("rollbackRejectedBySelectionPolicy"),
        ROLLBACK_NO_EMBEDDED("rollbackNoEmbeddedConfiguration");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        RemoteCheckResultNotAvailableReason(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static abstract class RemoteCheckResult {
        private final Status status;

        private enum Status {
            NO_UPDATE_AVAILABLE,
            UPDATE_AVAILABLE,
            ROLL_BACK_TO_EMBEDDED;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        }

        public /* synthetic */ RemoteCheckResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private RemoteCheckResult(Status status) {
            this.status = status;
        }

        public static final class NoUpdateAvailable extends RemoteCheckResult {
            private final RemoteCheckResultNotAvailableReason reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoUpdateAvailable(RemoteCheckResultNotAvailableReason reason) {
                super(Status.NO_UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }
        }

        public static final class UpdateAvailable extends RemoteCheckResult {
            private final JSONObject manifest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAvailable(JSONObject manifest) {
                super(Status.UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(manifest, "manifest");
                this.manifest = manifest;
            }

            public final JSONObject getManifest() {
                return this.manifest;
            }
        }

        public static final class RollBackToEmbedded extends RemoteCheckResult {
            private final Date commitTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RollBackToEmbedded(Date commitTime) {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
                Intrinsics.checkNotNullParameter(commitTime, "commitTime");
                this.commitTime = commitTime;
            }

            public final Date getCommitTime() {
                return this.commitTime;
            }
        }
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [expo.modules.updates.loader.LoaderTask] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final Object start(Continuation continuation) {
        C11041 c11041;
        Exception exc;
        if (continuation instanceof C11041) {
            c11041 = (C11041) continuation;
            int i = c11041.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c11041.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c11041 = new C11041(continuation);
            }
        } else {
            c11041 = new C11041(continuation);
        }
        Object obj = c11041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c11041.label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(obj);
                this.isRunning = true;
                boolean zShouldCheckForUpdateOnLaunch = UpdatesUtils.INSTANCE.shouldCheckForUpdateOnLaunch(this.configuration, this.logger, this.context);
                int launchWaitMs = this.configuration.getLaunchWaitMs();
                if (launchWaitMs > 0 && zShouldCheckForUpdateOnLaunch) {
                    this.handlerThread.start();
                    Boxing.boxBoolean(new Handler(this.handlerThread.getLooper()).postDelayed(new Runnable() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.timeout();
                        }
                    }, launchWaitMs));
                } else {
                    this.timeoutFinished = true;
                }
                c11041.Z$0 = zShouldCheckForUpdateOnLaunch;
                c11041.label = 1;
                r2 = zShouldCheckForUpdateOnLaunch;
                if (launchFallbackUpdateFromDisk(c11041) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (r2 == 1) {
                boolean z = c11041.Z$0;
                ResultKt.throwOnFailure(obj);
                r2 = z;
            } else if (r2 == 2 || r2 == 3) {
                boolean z2 = c11041.Z$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (r2 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                exc = (Exception) c11041.L$0;
                ResultKt.throwOnFailure(obj);
                e = exc;
                this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
            }
            return Unit.INSTANCE;
            Launcher launcher = this.candidateLauncher;
            Intrinsics.checkNotNull(launcher);
            if (launcher.getLaunchedUpdate() != null) {
                LoaderTaskCallback loaderTaskCallback = this.callback;
                Launcher launcher2 = this.candidateLauncher;
                Intrinsics.checkNotNull(launcher2);
                UpdateEntity launchedUpdate = launcher2.getLaunchedUpdate();
                Intrinsics.checkNotNull(launchedUpdate);
                if (!loaderTaskCallback.onCachedUpdateLoaded(launchedUpdate)) {
                    stopTimer();
                    this.candidateLauncher = null;
                    c11041.Z$0 = r2;
                    c11041.label = 2;
                    if (launchRemoteUpdate(c11041) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            synchronized (this) {
                this.isReadyToLaunch = true;
                maybeFinish();
                Unit unit = Unit.INSTANCE;
            }
            if (r2 != 0) {
                c11041.Z$0 = r2;
                c11041.label = 3;
                if (launchRemoteUpdate(c11041) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.isRunning = false;
                runReaper();
                this.callback.onFinishedAllLoading();
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            if (r2 == 0) {
                finish(e);
                this.isRunning = false;
                this.callback.onFinishedAllLoading();
            } else {
                c11041.L$0 = e;
                c11041.label = 4;
                if (launchRemoteUpdate(c11041) != coroutine_suspended) {
                    exc = e;
                    e = exc;
                }
            }
            this.logger.error("Failed to launch embedded or launchable update", e, UpdatesErrorCode.UpdateFailedToLoad);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object launchRemoteUpdate(Continuation continuation) {
        C11021 c11021;
        if (continuation instanceof C11021) {
            c11021 = (C11021) continuation;
            int i = c11021.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c11021.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c11021 = new C11021(continuation);
            }
        } else {
            c11021 = new C11021(continuation);
        }
        Object obj = c11021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11021.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                c11021.label = 1;
                if (launchRemoteUpdateInBackground(c11021) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            synchronized (this) {
                this.isReadyToLaunch = true;
                Unit unit = Unit.INSTANCE;
            }
            finish(null);
            this.isRunning = false;
            runReaper();
            this.callback.onFinishedAllLoading();
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            finish(e2);
            this.isRunning = false;
            runReaper();
            this.callback.onFinishedAllLoading();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:3:0x0001, B:8:0x0008, B:11:0x0014, B:14:0x001e, B:22:0x003d, B:24:0x0041, B:26:0x0046, B:17:0x002d, B:19:0x0031, B:21:0x003a), top: B:31:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0039  */
    private final synchronized void finish(Exception exc) {
        Exception exc2;
        try {
            if (this.hasLaunched) {
                return;
            }
            this.hasLaunched = true;
            Launcher launcher = this.candidateLauncher;
            this.finalizedLauncher = launcher;
            if (!this.isReadyToLaunch || launcher == null) {
                LoaderTaskCallback loaderTaskCallback = this.callback;
                if (exc == null) {
                    exc2 = new Exception("LoaderTask encountered an unexpected error and could not launch an update.");
                } else {
                    exc2 = exc;
                }
                loaderTaskCallback.onFailure(exc2);
            } else {
                Intrinsics.checkNotNull(launcher);
                if (launcher.getLaunchedUpdate() == null) {
                    LoaderTaskCallback loaderTaskCallback2 = this.callback;
                    if (exc == null) {
                        exc2 = new Exception("LoaderTask encountered an unexpected error and could not launch an update.");
                    } else {
                        exc2 = exc;
                    }
                    loaderTaskCallback2.onFailure(exc2);
                } else {
                    LoaderTaskCallback loaderTaskCallback3 = this.callback;
                    Launcher launcher2 = this.finalizedLauncher;
                    Intrinsics.checkNotNull(launcher2);
                    loaderTaskCallback3.onSuccess(launcher2, this.isUpToDate);
                }
            }
            if (!this.timeoutFinished) {
                stopTimer();
            }
            if (exc != null) {
                this.logger.error("Unexpected error encountered while loading this app", exc, UpdatesErrorCode.Unknown);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void maybeFinish() {
        if (this.isReadyToLaunch && this.timeoutFinished) {
            finish(null);
        }
    }

    private final synchronized void stopTimer() {
        this.timeoutFinished = true;
        this.handlerThread.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void timeout() {
        try {
            if (!this.timeoutFinished) {
                this.timeoutFinished = true;
                maybeFinish();
            }
            stopTimer();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011b, code lost:
    
        if (r4.launch(r5, r2) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012f, code lost:
    
        if (r5.launch(r15, r2) == r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013c, code lost:
    
        if (r11.launch(r0, r2) == r3) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object launchFallbackUpdateFromDisk(kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.LoaderTask.launchFallbackUpdateFromDisk(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Loader.OnUpdateResponseLoadedResult launchFallbackUpdateFromDisk$lambda$3(UpdateResponse updateResponse) {
        Intrinsics.checkNotNullParameter(updateResponse, "<unused var>");
        return new Loader.OnUpdateResponseLoadedResult(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:128:0x01ef A[Catch: all -> 0x0171, TryCatch #5 {all -> 0x0171, blocks: (B:71:0x0158, B:78:0x0166, B:80:0x0169, B:85:0x0176, B:88:0x0183, B:89:0x0184, B:90:0x0185, B:91:0x0195, B:65:0x0118, B:67:0x0147, B:126:0x01e9, B:128:0x01ef, B:132:0x020a, B:131:0x01fa), top: B:138:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:131:0x01fa A[Catch: all -> 0x0171, TryCatch #5 {all -> 0x0171, blocks: (B:71:0x0158, B:78:0x0166, B:80:0x0169, B:85:0x0176, B:88:0x0183, B:89:0x0184, B:90:0x0185, B:91:0x0195, B:65:0x0118, B:67:0x0147, B:126:0x01e9, B:128:0x01ef, B:132:0x020a, B:131:0x01fa), top: B:138:0x002a }] */
    /* JADX WARN: Code duplicated, block: B:135:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0156  */
    /* JADX WARN: Code duplicated, block: B:74:0x015d A[Catch: all -> 0x0162, TryCatch #0 {all -> 0x0162, blocks: (B:72:0x0159, B:74:0x015d, B:77:0x0164), top: B:135:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0169 A[Catch: all -> 0x0171, Exception -> 0x0174, TryCatch #2 {Exception -> 0x0174, blocks: (B:71:0x0158, B:78:0x0166, B:80:0x0169, B:85:0x0176, B:88:0x0183, B:89:0x0184, B:67:0x0147), top: B:137:0x0147 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0176 A[Catch: all -> 0x0171, Exception -> 0x0174, TRY_LEAVE, TryCatch #2 {Exception -> 0x0174, blocks: (B:71:0x0158, B:78:0x0166, B:80:0x0169, B:85:0x0176, B:88:0x0183, B:89:0x0184, B:67:0x0147), top: B:137:0x0147 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [expo.modules.updates.loader.LoaderTask$LoaderTaskCallback] */
    /* JADX WARN: Type inference failed for: r0v46, types: [expo.modules.updates.loader.LoaderTask$LoaderTaskCallback] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v27, types: [expo.modules.updates.db.entity.UpdateEntity, java.lang.Exception, java.lang.Object, java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Object, java.util.concurrent.CancellationException] */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v33 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object launchRemoteUpdateInBackground(Continuation continuation) throws Throwable {
        C11031 c11031;
        UpdateEntity updateEntity;
        ?? r5;
        String message;
        UpdatesDatabase updatesDatabase;
        Job jobLaunch$default;
        UpdatesDatabase updatesDatabase2;
        Job job;
        Job job2;
        Object obj;
        Loader.LoaderResult loaderResult;
        RemoteLoader.Companion companion;
        Context context;
        UpdatesConfiguration updatesConfiguration;
        UpdatesLogger updatesLogger;
        SelectionPolicy selectionPolicy;
        File file;
        UpdateEntity launchedUpdate;
        UpdatesDatabase updatesDatabase3;
        Job job3;
        UpdateEntity availableUpdate;
        DatabaseLauncher databaseLauncher;
        UpdateEntity updateEntity2;
        DatabaseLauncher databaseLauncher2;
        ?? r14;
        int i;
        int i2;
        if (!(continuation instanceof C11031) || (i2 = (i = (c11031 = (C11031) continuation).label) & LinearLayoutManager.INVALID_OFFSET) == 0) {
            c11031 = new C11031(continuation);
        } else {
            c11031.label = i - LinearLayoutManager.INVALID_OFFSET;
        }
        C11031 c11032 = c11031;
        Object objLoad = c11032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c11032.label;
        ?? r15 = 2;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    if (i3 == 0) {
                                                        ResultKt.throwOnFailure(objLoad);
                                                        UpdatesDatabase database = this.databaseHolder.getDatabase();
                                                        this.callback.onRemoteCheckForUpdateStarted();
                                                        Context context2 = this.context;
                                                        UpdatesConfiguration updatesConfiguration2 = this.configuration;
                                                        UpdatesLogger updatesLogger2 = this.logger;
                                                        FileDownloader fileDownloader = this.fileDownloader;
                                                        File file2 = this.directory;
                                                        Launcher launcher = this.candidateLauncher;
                                                        RemoteLoader remoteLoader = new RemoteLoader(context2, updatesConfiguration2, updatesLogger2, database, fileDownloader, file2, launcher != null ? launcher.getLaunchedUpdate() : null, this.scope);
                                                        updatesDatabase = database;
                                                        remoteLoader.setAssetLoadProgressBlock$expo_updates_release(new Function1() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj2) {
                                                                return LoaderTask.launchRemoteUpdateInBackground$lambda$4(this.f$0, ((Double) obj2).doubleValue());
                                                            }
                                                        });
                                                        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LoaderTask$launchRemoteUpdateInBackground$progressJob$1(remoteLoader, this, null), 3, null);
                                                        Function1 function1 = new Function1() { // from class: expo.modules.updates.loader.LoaderTask$$ExternalSyntheticLambda2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj2) {
                                                                return LoaderTask.launchRemoteUpdateInBackground$lambda$5(this.f$0, (UpdateResponse) obj2);
                                                            }
                                                        };
                                                        c11032.L$0 = updatesDatabase;
                                                        c11032.L$1 = jobLaunch$default;
                                                        c11032.label = 1;
                                                        objLoad = remoteLoader.load(function1, c11032);
                                                        if (objLoad != coroutine_suspended) {
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    if (i3 != 1) {
                                                        if (i3 != 2) {
                                                            if (i3 != 3) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            databaseLauncher2 = (DatabaseLauncher) c11032.L$2;
                                                            updateEntity2 = (UpdateEntity) c11032.L$1;
                                                            job3 = (Job) c11032.L$0;
                                                            try {
                                                                ResultKt.throwOnFailure(objLoad);
                                                                r14 = 0;
                                                                synchronized (this) {
                                                                    try {
                                                                        if (!this.hasLaunched) {
                                                                            this.candidateLauncher = databaseLauncher2;
                                                                            this.isUpToDate = true;
                                                                        }
                                                                        Unit unit = Unit.INSTANCE;
                                                                    } catch (Throwable th) {
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (updateEntity2 == null) {
                                                                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.NO_UPDATE_AVAILABLE, r14, r14);
                                                                } else {
                                                                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.UPDATE_AVAILABLE, updateEntity2, r14);
                                                                }
                                                                Job.DefaultImpls.cancel$default(job3, r14, 1, r14);
                                                                return Unit.INSTANCE;
                                                            } catch (Exception e) {
                                                                e = e;
                                                                updateEntity = null;
                                                                this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                                this.logger.error("Loaded new update but it failed to launch", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                                throw e;
                                                            }
                                                        }
                                                        job3 = (Job) c11032.L$1;
                                                        updatesDatabase3 = (UpdatesDatabase) c11032.L$0;
                                                        ResultKt.throwOnFailure(objLoad);
                                                        updateEntity = null;
                                                        try {
                                                            availableUpdate = ((ProcessSuccessLoaderResult) objLoad).getAvailableUpdate();
                                                            databaseLauncher = new DatabaseLauncher(this.context, this.configuration, this.directory, this.fileDownloader, this.selectionPolicy, this.logger, this.scope, false, 128, null);
                                                            try {
                                                                c11032.L$0 = job3;
                                                                c11032.L$1 = availableUpdate;
                                                                c11032.L$2 = databaseLauncher;
                                                                c11032.label = 3;
                                                                if (databaseLauncher.launch(updatesDatabase3, c11032) != coroutine_suspended) {
                                                                    updateEntity2 = availableUpdate;
                                                                    databaseLauncher2 = databaseLauncher;
                                                                    r14 = updateEntity;
                                                                    synchronized (this) {
                                                                        if (!this.hasLaunched) {
                                                                            this.candidateLauncher = databaseLauncher2;
                                                                            this.isUpToDate = true;
                                                                        }
                                                                        Unit unit2 = Unit.INSTANCE;
                                                                        if (updateEntity2 == null) {
                                                                            this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.NO_UPDATE_AVAILABLE, r14, r14);
                                                                        } else {
                                                                            this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.UPDATE_AVAILABLE, updateEntity2, r14);
                                                                        }
                                                                        Job.DefaultImpls.cancel$default(job3, r14, 1, r14);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }
                                                                return coroutine_suspended;
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                updateEntity = updateEntity;
                                                                this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                                this.logger.error("Loaded new update but it failed to launch", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                                throw e;
                                                            }
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            message = e.getMessage();
                                                            if (message != null || !StringsKt.contains$default((CharSequence) message, (CharSequence) "Loaded new update but it failed to launch", false, 2, (Object) updateEntity)) {
                                                                this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                                this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                            }
                                                            throw e;
                                                        }
                                                    }
                                                    jobLaunch$default = (Job) c11032.L$1;
                                                    updatesDatabase = (UpdatesDatabase) c11032.L$0;
                                                    ResultKt.throwOnFailure(objLoad);
                                                    objLoad = companion.processSuccessLoaderResult(context, updatesConfiguration, updatesLogger, updatesDatabase2, selectionPolicy, file, launchedUpdate, loaderResult, c11032);
                                                    if (objLoad != coroutine_suspended) {
                                                        updatesDatabase3 = updatesDatabase2;
                                                        job3 = job2;
                                                        availableUpdate = ((ProcessSuccessLoaderResult) objLoad).getAvailableUpdate();
                                                        databaseLauncher = new DatabaseLauncher(this.context, this.configuration, this.directory, this.fileDownloader, this.selectionPolicy, this.logger, this.scope, false, 128, null);
                                                        c11032.L$0 = job3;
                                                        c11032.L$1 = availableUpdate;
                                                        c11032.L$2 = databaseLauncher;
                                                        c11032.label = 3;
                                                        if (databaseLauncher.launch(updatesDatabase3, c11032) != coroutine_suspended) {
                                                            updateEntity2 = availableUpdate;
                                                            databaseLauncher2 = databaseLauncher;
                                                            r14 = updateEntity;
                                                            synchronized (this) {
                                                                if (!this.hasLaunched) {
                                                                    this.candidateLauncher = databaseLauncher2;
                                                                    this.isUpToDate = true;
                                                                }
                                                                Unit unit3 = Unit.INSTANCE;
                                                                if (updateEntity2 == null) {
                                                                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.NO_UPDATE_AVAILABLE, r14, r14);
                                                                } else {
                                                                    this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.UPDATE_AVAILABLE, updateEntity2, r14);
                                                                }
                                                                Job.DefaultImpls.cancel$default(job3, r14, 1, r14);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }
                                                    }
                                                    return coroutine_suspended;
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    message = e.getMessage();
                                                    if (message != null) {
                                                        this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                        this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                    } else {
                                                        this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                        this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                    }
                                                    throw e;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    r5 = job2;
                                                    r15 = obj;
                                                    Job.DefaultImpls.cancel$default(r5, r15, 1, r15);
                                                    throw th;
                                                }
                                                Launcher launcher2 = this.candidateLauncher;
                                                if (launcher2 != null) {
                                                    try {
                                                        launchedUpdate = launcher2.getLaunchedUpdate();
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        updateEntity = null;
                                                        message = e.getMessage();
                                                        if (message != null) {
                                                            this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                            this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                        } else {
                                                            this.callback.onRemoteUpdateFinished(RemoteUpdateStatus.ERROR, updateEntity, e);
                                                            this.logger.error("Failed to download remote update", e, UpdatesErrorCode.UpdateFailedToLoad);
                                                        }
                                                        throw e;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        r5 = job;
                                                        r15 = 0;
                                                        Job.DefaultImpls.cancel$default(r5, r15, 1, r15);
                                                        throw th;
                                                    }
                                                } else {
                                                    launchedUpdate = null;
                                                }
                                                c11032.L$0 = updatesDatabase2;
                                                c11032.L$1 = job;
                                                c11032.label = 2;
                                                job2 = job;
                                                obj = null;
                                                updateEntity = null;
                                                updateEntity = null;
                                            } catch (Exception e6) {
                                                e = e6;
                                                job2 = job;
                                                updateEntity = null;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                job2 = job;
                                                obj = null;
                                            }
                                            file = this.directory;
                                        } catch (Exception e7) {
                                            e = e7;
                                            job2 = job;
                                            updateEntity = null;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            job2 = job;
                                            obj = null;
                                        }
                                        selectionPolicy = this.selectionPolicy;
                                    } catch (Exception e8) {
                                        e = e8;
                                        job2 = job;
                                        updateEntity = null;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        job2 = job;
                                        obj = null;
                                    }
                                    updatesLogger = this.logger;
                                } catch (Exception e9) {
                                    e = e9;
                                    job2 = job;
                                    updateEntity = null;
                                } catch (Throwable th7) {
                                    th = th7;
                                    job2 = job;
                                    obj = null;
                                }
                                updatesConfiguration = this.configuration;
                            } catch (Exception e10) {
                                e = e10;
                                job2 = job;
                                updateEntity = null;
                            } catch (Throwable th8) {
                                th = th8;
                                job2 = job;
                                obj = null;
                            }
                            context = this.context;
                        } catch (Exception e11) {
                            e = e11;
                            job2 = job;
                            updateEntity = null;
                        } catch (Throwable th9) {
                            th = th9;
                            job2 = job;
                            obj = null;
                        }
                        loaderResult = (Loader.LoaderResult) objLoad;
                        companion = RemoteLoader.Companion;
                    } catch (Exception e12) {
                        e = e12;
                        job2 = job;
                        updateEntity = null;
                    } catch (Throwable th10) {
                        th = th10;
                        job2 = job;
                        obj = null;
                    }
                    updatesDatabase2 = updatesDatabase;
                    job = jobLaunch$default;
                } catch (Throwable th11) {
                    th = th11;
                    r5 = i2;
                }
            } catch (Exception e13) {
                e = e13;
                updateEntity = null;
            }
        } catch (Throwable th12) {
            th = th12;
            r15 = 0;
            r5 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchRemoteUpdateInBackground$lambda$4(LoaderTask loaderTask, double d) {
        loaderTask.callback.onRemoteUpdateProgressChanged(d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Loader.OnUpdateResponseLoadedResult launchRemoteUpdateInBackground$lambda$5(LoaderTask loaderTask, UpdateResponse updateResponse) {
        Intrinsics.checkNotNullParameter(updateResponse, "updateResponse");
        UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
        UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
        if (updateDirective != null) {
            if (updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) {
                loaderTask.isUpToDate = true;
                loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.RollBackToEmbedded(((UpdateDirective.RollBackToEmbeddedUpdateDirective) updateDirective).getCommitTime()));
                return new Loader.OnUpdateResponseLoadedResult(false);
            }
            if (!(updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                throw new NoWhenBranchMatchedException();
            }
            loaderTask.isUpToDate = true;
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
            return new Loader.OnUpdateResponseLoadedResult(false);
        }
        UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
        Update update = manifestUpdateResponsePart != null ? manifestUpdateResponsePart.getUpdate() : null;
        if (update == null) {
            loaderTask.isUpToDate = true;
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.NO_UPDATE_AVAILABLE_ON_SERVER));
            return new Loader.OnUpdateResponseLoadedResult(false);
        }
        SelectionPolicy selectionPolicy = loaderTask.selectionPolicy;
        UpdateEntity updateEntity = update.getUpdateEntity();
        Launcher launcher = loaderTask.candidateLauncher;
        UpdateEntity launchedUpdate = launcher != null ? launcher.getLaunchedUpdate() : null;
        ResponseHeaderData responseHeaderData = updateResponse.getResponseHeaderData();
        if (selectionPolicy.shouldLoadNewUpdate(updateEntity, launchedUpdate, responseHeaderData != null ? responseHeaderData.getManifestFilters() : null)) {
            loaderTask.isUpToDate = false;
            loaderTask.callback.onRemoteUpdateManifestResponseUpdateLoaded(update);
            loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.UpdateAvailable(update.getManifest().getRawJson()));
            loaderTask.callback.onRemoteUpdateLoadStarted();
            return new Loader.OnUpdateResponseLoadedResult(true);
        }
        loaderTask.isUpToDate = true;
        loaderTask.callback.onRemoteCheckForUpdateFinished(new RemoteCheckResult.NoUpdateAvailable(RemoteCheckResultNotAvailableReason.UPDATE_REJECTED_BY_SELECTION_POLICY));
        return new Loader.OnUpdateResponseLoadedResult(false);
    }

    private final void runReaper() {
        synchronized (this) {
            try {
                Launcher launcher = this.finalizedLauncher;
                UpdateEntity launchedUpdate = launcher != null ? launcher.getLaunchedUpdate() : null;
                if (launchedUpdate != null) {
                    Reaper.reapUnusedUpdates(this.configuration, this.databaseHolder.getDatabase(), this.directory, launchedUpdate, this.selectionPolicy);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

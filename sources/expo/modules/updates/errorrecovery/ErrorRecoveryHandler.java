package expo.modules.updates.errorrecovery;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorRecoveryHandler extends Handler {
    public static final Companion Companion = new Companion(null);
    private final ErrorRecoveryDelegate delegate;
    private final ArrayList encounteredErrors;
    private boolean hasContentAppeared;
    private boolean isPipelineRunning;
    private boolean isWaitingForRemoteUpdate;
    private final UpdatesLogger logger;
    private final ArrayList pipeline;

    private enum Task {
        WAIT_FOR_REMOTE_UPDATE,
        LAUNCH_NEW_UPDATE,
        LAUNCH_CACHED_UPDATE,
        CRASH;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.values().length];
            try {
                iArr[Task.WAIT_FOR_REMOTE_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Task.LAUNCH_NEW_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Task.LAUNCH_CACHED_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Task.CRASH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ void access$setPipelineRunning$p(ErrorRecoveryHandler errorRecoveryHandler, boolean z) {
        errorRecoveryHandler.isPipelineRunning = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorRecoveryHandler(Looper looper, ErrorRecoveryDelegate delegate, UpdatesLogger logger) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.delegate = delegate;
        this.logger = logger;
        this.pipeline = CollectionsKt.arrayListOf(Task.WAIT_FOR_REMOTE_UPDATE, Task.LAUNCH_NEW_UPDATE, Task.LAUNCH_CACHED_UPDATE, Task.CRASH);
        this.encounteredErrors = new ArrayList();
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i = msg.what;
        if (i == 0) {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Exception");
            maybeStartPipeline((Exception) obj);
        } else {
            if (i == 1) {
                handleContentAppeared();
                return;
            }
            if (i == 2) {
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.updates.errorrecovery.ErrorRecoveryDelegate.RemoteLoadStatus");
                handleRemoteLoadStatusChanged((ErrorRecoveryDelegate.RemoteLoadStatus) obj2);
            } else {
                throw new RuntimeException("ErrorRecoveryHandler cannot handle message " + msg.what);
            }
        }
    }

    private final void handleContentAppeared() {
        this.hasContentAppeared = true;
        this.pipeline.retainAll(SetsKt.setOf((Object[]) new Task[]{Task.WAIT_FOR_REMOTE_UPDATE, Task.CRASH}));
        this.delegate.markSuccessfulLaunchForLaunchedUpdate();
    }

    private final void handleRemoteLoadStatusChanged(ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus) {
        if (this.isWaitingForRemoteUpdate) {
            this.isWaitingForRemoteUpdate = false;
            if (remoteLoadStatus != ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED) {
                this.pipeline.remove(Task.LAUNCH_NEW_UPDATE);
            }
            runNextTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runNextTask() {
        int i = WhenMappings.$EnumSwitchMapping$0[((Task) this.pipeline.remove(0)).ordinal()];
        if (i == 1) {
            UpdatesLogger.info$default(this.logger, "UpdatesErrorRecovery: attempting to fetch a new update, waiting", null, 2, null);
            waitForRemoteUpdate();
            return;
        }
        if (i == 2) {
            UpdatesLogger.info$default(this.logger, "UpdatesErrorRecovery: launching new update", null, 2, null);
            tryRelaunchFromCache();
            return;
        }
        if (i == 3) {
            UpdatesLogger.info$default(this.logger, "UpdatesErrorRecovery: falling back to older update", null, 2, null);
            tryRelaunchFromCache();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            UpdatesLogger updatesLogger = this.logger;
            Object obj = this.encounteredErrors.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            updatesLogger.error("UpdatesErrorRecovery: could not recover from error, crashing", (Exception) obj, UpdatesErrorCode.Unknown);
            crash();
        }
    }

    private final void maybeStartPipeline(Exception exc) {
        this.encounteredErrors.add(exc);
        if (this.delegate.getLaunchedUpdateSuccessfulLaunchCount() > 0) {
            this.pipeline.remove(Task.LAUNCH_CACHED_UPDATE);
        } else if (!this.hasContentAppeared) {
            this.delegate.markFailedLaunchForLaunchedUpdate();
        }
        if (this.isPipelineRunning) {
            return;
        }
        this.isPipelineRunning = true;
        runNextTask();
    }

    private final void waitForRemoteUpdate() {
        ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus = this.delegate.getRemoteLoadStatus();
        if (remoteLoadStatus == ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED) {
            runNextTask();
            return;
        }
        ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus2 = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
        if (remoteLoadStatus == remoteLoadStatus2 || this.delegate.getCheckAutomaticallyConfiguration() != UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER) {
            this.isWaitingForRemoteUpdate = true;
            if (this.delegate.getRemoteLoadStatus() != remoteLoadStatus2) {
                this.delegate.loadRemoteUpdate();
            }
            postDelayed(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecoveryHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ErrorRecoveryHandler.waitForRemoteUpdate$lambda$0(this.f$0);
                }
            }, HTTPTimeoutManager.SUPPORTED_FALLBACK_TIMEOUT_MS);
            return;
        }
        this.pipeline.remove(Task.LAUNCH_NEW_UPDATE);
        runNextTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void waitForRemoteUpdate$lambda$0(ErrorRecoveryHandler errorRecoveryHandler) {
        errorRecoveryHandler.handleRemoteLoadStatusChanged(ErrorRecoveryDelegate.RemoteLoadStatus.IDLE);
    }

    /* JADX INFO: renamed from: expo.modules.updates.errorrecovery.ErrorRecoveryHandler$tryRelaunchFromCache$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Launcher.LauncherCallback {
        AnonymousClass1() {
        }

        @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
        public void onFailure(final Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            final ErrorRecoveryHandler errorRecoveryHandler = ErrorRecoveryHandler.this;
            errorRecoveryHandler.post(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecoveryHandler$tryRelaunchFromCache$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ErrorRecoveryHandler.AnonymousClass1.onFailure$lambda$0(errorRecoveryHandler, e);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFailure$lambda$0(ErrorRecoveryHandler errorRecoveryHandler, Exception exc) {
            errorRecoveryHandler.encounteredErrors.add(exc);
            errorRecoveryHandler.pipeline.removeAll(SetsKt.setOf((Object[]) new Task[]{Task.LAUNCH_NEW_UPDATE, Task.LAUNCH_CACHED_UPDATE}));
            errorRecoveryHandler.runNextTask();
        }

        @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
        public void onSuccess() {
            final ErrorRecoveryHandler errorRecoveryHandler = ErrorRecoveryHandler.this;
            errorRecoveryHandler.post(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecoveryHandler$tryRelaunchFromCache$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ErrorRecoveryHandler.access$setPipelineRunning$p(errorRecoveryHandler, false);
                }
            });
        }
    }

    private final void tryRelaunchFromCache() {
        this.delegate.relaunch(new AnonymousClass1());
    }

    private final void crash() {
        ErrorRecoveryDelegate errorRecoveryDelegate = this.delegate;
        Object obj = this.encounteredErrors.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        errorRecoveryDelegate.throwException((Exception) obj);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

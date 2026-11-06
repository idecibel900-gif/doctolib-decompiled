package expo.modules.updates.errorrecovery;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorRecovery {
    private final ReactMarker.MarkerListener contentAppearedListener;
    public Handler handler;
    private final HandlerThread handlerThread;
    private final UpdatesLogger logger;
    private boolean shouldHandleReactInstanceException;

    public ErrorRecovery(UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.handlerThread = new HandlerThread("expo-updates-error-recovery");
        this.contentAppearedListener = new ReactMarker.MarkerListener() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
            public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
                ErrorRecovery.contentAppearedListener$lambda$1(this.f$0, reactMarkerConstants, str, i);
            }
        };
    }

    public final Handler getHandler$expo_updates_release() {
        Handler handler = this.handler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        return null;
    }

    public final void setHandler$expo_updates_release(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    public final void initialize(ErrorRecoveryDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.handler == null) {
            this.handlerThread.start();
            Looper looper = this.handlerThread.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
            setHandler$expo_updates_release(new ErrorRecoveryHandler(looper, delegate, this.logger));
        }
    }

    public final void startMonitoring(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        registerContentAppearedListener();
        registerErrorHandler(devSupportManager);
    }

    public final void onReactInstanceException$expo_updates_release(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (this.shouldHandleReactInstanceException) {
            handleException$expo_updates_release(exception);
        }
    }

    public final void notifyNewRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus newStatus) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        UpdatesLogger.info$default(this.logger, "ErrorRecovery: remote load status changed: " + newStatus, null, 2, null);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(2, newStatus));
    }

    public final void handleException$expo_updates_release(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.logger.error("ErrorRecovery: exception encountered: " + exception.getLocalizedMessage(), exception, UpdatesErrorCode.Unknown);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(0, exception));
    }

    public final void handleContentAppeared$expo_updates_release() {
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(1));
        unregisterContentAppearedListener();
        getHandler$expo_updates_release().postDelayed(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.unregisterErrorHandler();
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentAppearedListener$lambda$1(ErrorRecovery errorRecovery, ReactMarkerConstants name, String str, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name == ReactMarkerConstants.CONTENT_APPEARED) {
            errorRecovery.handleContentAppeared$expo_updates_release();
        }
    }

    private final void registerContentAppearedListener() {
        ReactMarker.addListener(this.contentAppearedListener);
    }

    private final void unregisterContentAppearedListener() {
        ReactMarker.removeListener(this.contentAppearedListener);
    }

    private final void registerErrorHandler(DevSupportManager devSupportManager) {
        this.shouldHandleReactInstanceException = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterErrorHandler() {
        this.shouldHandleReactInstanceException = false;
    }
}

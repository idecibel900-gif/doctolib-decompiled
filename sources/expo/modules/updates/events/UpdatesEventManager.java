package expo.modules.updates.events;

import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesEventManager implements IUpdatesEventManager {
    private final UpdatesLogger logger;
    private WeakReference observer;

    public UpdatesEventManager(UpdatesLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    public WeakReference getObserver() {
        return this.observer;
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void setObserver(WeakReference weakReference) {
        this.observer = weakReference;
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void sendStateMachineContextEvent(UpdatesStateContext context) {
        IUpdatesEventManagerObserver iUpdatesEventManagerObserver;
        Intrinsics.checkNotNullParameter(context, "context");
        UpdatesLogger.debug$default(this.logger, "Sending state machine context to observer", null, 2, null);
        WeakReference observer = getObserver();
        if (observer == null || (iUpdatesEventManagerObserver = (IUpdatesEventManagerObserver) observer.get()) == null) {
            this.logger.debug("Unable to send state machine context to observer, no observer", UpdatesErrorCode.JSRuntimeError);
            return;
        }
        try {
            iUpdatesEventManagerObserver.onStateMachineContextEvent(context);
            UpdatesLogger.debug$default(this.logger, "Sent state machine context to observer", null, 2, null);
        } catch (Exception e) {
            this.logger.error("Could not send state machine context to observer", e, UpdatesErrorCode.JSRuntimeError);
        }
    }
}

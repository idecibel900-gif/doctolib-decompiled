package expo.modules.updates.events;

import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NoOpUpdatesEventManager implements IUpdatesEventManager {
    private WeakReference observer;

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void sendStateMachineContextEvent(UpdatesStateContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // expo.modules.updates.events.IUpdatesEventManager
    public void setObserver(WeakReference weakReference) {
        this.observer = weakReference;
    }
}

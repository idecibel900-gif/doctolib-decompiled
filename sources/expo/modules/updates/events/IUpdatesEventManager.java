package expo.modules.updates.events;

import expo.modules.updates.statemachine.UpdatesStateContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdatesEventManager {
    void sendStateMachineContextEvent(UpdatesStateContext updatesStateContext);

    void setObserver(WeakReference weakReference);
}

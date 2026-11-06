package expo.modules.updates.events;

import expo.modules.updates.statemachine.UpdatesStateContext;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdatesEventManagerObserver {
    void onStateMachineContextEvent(UpdatesStateContext updatesStateContext);
}

package expo.modules.updates.procedures;

import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StateMachineProcedure {

    public interface ProcedureContext extends StateMachineProcedureContext {
        void onComplete();
    }

    public interface StateMachineProcedureContext {
        UpdatesStateValue getCurrentState();

        void processStateEvent(UpdatesStateEvent updatesStateEvent);

        void resetStateAfterRestart();
    }

    public abstract String getLoggerTimerLabel();

    public abstract Object run(ProcedureContext procedureContext, Continuation continuation);
}

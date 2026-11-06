package expo.modules.webbrowser;

import expo.modules.core.interfaces.Consumer;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class DeferredClientActionsQueue {
    private final Queue actions = new LinkedList();
    private Object client;

    public final void setClient(Object obj) {
        this.client = obj;
        executeQueuedActions();
    }

    public final boolean hasClient() {
        return this.client != null;
    }

    public final void executeOrQueueAction(Consumer action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Object obj = this.client;
        if (obj != null) {
            action.apply(obj);
        } else {
            addActionToQueue(action);
        }
    }

    public final void clear() {
        this.client = null;
        this.actions.clear();
    }

    private final void executeQueuedActions() {
        if (this.client == null) {
            return;
        }
        Consumer consumer = (Consumer) this.actions.poll();
        while (consumer != null) {
            consumer.apply(this.client);
            consumer = (Consumer) this.actions.poll();
        }
    }

    private final void addActionToQueue(Consumer consumer) {
        this.actions.add(consumer);
    }
}

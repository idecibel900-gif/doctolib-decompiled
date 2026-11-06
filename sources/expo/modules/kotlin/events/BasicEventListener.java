package expo.modules.kotlin.events;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BasicEventListener extends EventListener {
    private final Function0 body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicEventListener(EventName eventName, Function0 body) {
        super(eventName, null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    public final void call() {
        this.body.invoke();
    }
}

package expo.modules.kotlin.events;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventListenerWithSenderAndPayload extends EventListener {
    private final Function2 body;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventListenerWithSenderAndPayload(EventName eventName, Function2 body) {
        super(eventName, null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    public final void call(Object obj, Object obj2) {
        this.body.invoke(obj, obj2);
    }
}

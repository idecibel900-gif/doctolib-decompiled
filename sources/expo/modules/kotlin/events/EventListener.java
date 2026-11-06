package expo.modules.kotlin.events;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventListener {
    private final EventName eventName;

    public /* synthetic */ EventListener(EventName eventName, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventName);
    }

    private EventListener(EventName eventName) {
        this.eventName = eventName;
    }
}

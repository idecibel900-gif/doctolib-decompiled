package expo.modules.kotlin.events;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventsDefinition {
    private final String[] names;

    public EventsDefinition(String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    public final String[] getNames() {
        return this.names;
    }

    public final EventsDefinition plus(EventsDefinition eventsDefinition) {
        return eventsDefinition == null ? this : new EventsDefinition((String[]) ArraysKt.plus((Object[]) this.names, (Object[]) eventsDefinition.names));
    }
}

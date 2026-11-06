package expo.modules.kotlin.objects;

import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventObservingDefinition {
    private final Function0 body;
    private final Filter filer;
    private final Type type;

    public EventObservingDefinition(Type type, Filter filer, Function0 body) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(filer, "filer");
        Intrinsics.checkNotNullParameter(body, "body");
        this.type = type;
        this.filer = filer;
        this.body = body;
    }

    public enum Type {
        StartObserving("startObserving"),
        StopObserving("stopObserving");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String value;

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        Type(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static abstract class Filter {
        public /* synthetic */ Filter(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Filter() {
        }
    }

    public static final class SelectedEventFiler extends Filter {
        private final String event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedEventFiler(String event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final String getEvent() {
            return this.event;
        }
    }

    public final boolean shouldBeInvoked$expo_modules_core_release(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Filter filter = this.filer;
        if (filter instanceof SelectedEventFiler) {
            return Intrinsics.areEqual(((SelectedEventFiler) filter).getEvent(), eventName);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void invokedIfNeed(Type eventType, String eventName) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (eventType == this.type && shouldBeInvoked$expo_modules_core_release(eventName)) {
            this.body.invoke();
        }
    }
}

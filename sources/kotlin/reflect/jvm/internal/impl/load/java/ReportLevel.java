package kotlin.reflect.jvm.internal.impl.load.java;

import app.notifee.core.event.LogEvent;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public enum ReportLevel {
    IGNORE("ignore"),
    WARN(LogEvent.LEVEL_WARN),
    STRICT("strict");

    private final String description;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    public static final Companion Companion = new Companion(null);

    ReportLevel(String str) {
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isWarning() {
        return this == WARN;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }
}

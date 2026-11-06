package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventsNotFoundException extends CodedException {
    public /* synthetic */ EventsNotFoundException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Events could not be found" : str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventsNotFoundException(String message, Throwable th) {
        super("E_EVENTS_NOT_FOUND", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}

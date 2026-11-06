package expo.modules.calendar.next;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.sharedobjects.SharedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/calendar/next/ExpoCalendarReminder;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "", DiagnosticsEntry.ID_KEY, "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoCalendarReminder extends SharedObject {
    private final String id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCalendarReminder(String id) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }
}

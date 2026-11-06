package expo.modules.calendar.dialogs;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/calendar/dialogs/ViewedEventOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", DiagnosticsEntry.ID_KEY, "", "startNewActivityTask", "", "<init>", "(Ljava/lang/String;Z)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getStartNewActivityTask$annotations", "getStartNewActivityTask", "()Z", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewedEventOptions implements Record, Serializable {
    private final String id;
    private final boolean startNewActivityTask;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewedEventOptions() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getStartNewActivityTask$annotations() {
    }

    public ViewedEventOptions(String id, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.startNewActivityTask = z;
    }

    public final String getId() {
        return this.id;
    }

    public /* synthetic */ ViewedEventOptions(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z);
    }

    public final boolean getStartNewActivityTask() {
        return this.startNewActivityTask;
    }
}

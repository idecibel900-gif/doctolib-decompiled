package expo.modules.calendar.dialogs;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/calendar/dialogs/CreateEventIntentResult;", "Lexpo/modules/calendar/dialogs/ViewEventIntentResult;", DiagnosticsEntry.ID_KEY, "", "<init>", "(Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateEventIntentResult extends ViewEventIntentResult {
    private final String id;

    /* JADX WARN: Multi-variable type inference failed */
    public CreateEventIntentResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    public CreateEventIntentResult(String str) {
        super(null, 1, null);
        this.id = str;
    }

    public /* synthetic */ CreateEventIntentResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getId() {
        return this.id;
    }
}

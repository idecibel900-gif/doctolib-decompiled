package expo.modules.calendar.domain.calendar.records;

import expo.modules.calendar.exceptions.FieldMissingException;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u0010\u0012\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Lexpo/modules/calendar/domain/calendar/records/CalendarSource;", "Lexpo/modules/kotlin/records/Record;", "name", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getType$annotations", "getType", "jsIsLocalAccount", "", "getJsIsLocalAccount$annotations", "Ljava/lang/Boolean;", "isLocalAccount", "()Z", "resolvedType", "getResolvedType", "assertValidForNewCalendar", "", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarSource implements Record {
    private final Boolean jsIsLocalAccount;
    private final String name;
    private final String type;

    @Field(key = "isLocalAccount")
    private static /* synthetic */ void getJsIsLocalAccount$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    public CalendarSource(String str, String str2) {
        this.name = str;
        this.type = str2;
        this.jsIsLocalAccount = Boolean.valueOf(Intrinsics.areEqual(str2, "LOCAL"));
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isLocalAccount() {
        Boolean bool = this.jsIsLocalAccount;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final String getResolvedType() {
        return isLocalAccount() ? "LOCAL" : this.type;
    }

    public final void assertValidForNewCalendar() throws FieldMissingException {
        if (this.name == null) {
            throw new FieldMissingException("new calendars require a `source` object with a `name`", null, 2, null);
        }
        if (this.type == null && !isLocalAccount()) {
            throw new FieldMissingException("new calendars require a `source` object with a `type`, or `isLocalAccount`: true", null, 2, null);
        }
    }
}

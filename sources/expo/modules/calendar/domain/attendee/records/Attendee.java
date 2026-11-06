package expo.modules.calendar.domain.attendee.records;

import android.content.ContentValues;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.calendar.domain.attendee.enums.AttendeeRole;
import expo.modules.calendar.domain.attendee.enums.AttendeeStatus;
import expo.modules.calendar.domain.attendee.enums.AttendeeType;
import expo.modules.calendar.exceptions.FieldMissingException;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BE\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020(H\u0002R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u000fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u000fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b\"\u0010$¨\u0006)"}, d2 = {"Lexpo/modules/calendar/domain/attendee/records/Attendee;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "name", AuthorizationRequest.Scope.EMAIL, "role", "Lexpo/modules/calendar/domain/attendee/enums/AttendeeRole;", "status", "Lexpo/modules/calendar/domain/attendee/enums/AttendeeStatus;", "type", "Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/domain/attendee/enums/AttendeeRole;Lexpo/modules/calendar/domain/attendee/enums/AttendeeStatus;Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getName$annotations", "getName", "getEmail$annotations", "getEmail", "jsRole", "getJsRole$annotations", "jsStatus", "getJsStatus$annotations", "jsType", "getJsType$annotations", "getRole", "()Lexpo/modules/calendar/domain/attendee/enums/AttendeeRole;", "getStatus", "()Lexpo/modules/calendar/domain/attendee/enums/AttendeeStatus;", "getType", "()Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;", "isNewAttendeePayload", "", "()Z", "toContentValues", "Landroid/content/ContentValues;", "assertNewAttendeValid", "", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Attendee implements Record {
    private final String email;
    private final String id;
    private final String jsRole;
    private final String jsStatus;
    private final String jsType;
    private final String name;

    @Field
    public static /* synthetic */ void getEmail$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field(key = "role")
    private static /* synthetic */ void getJsRole$annotations() {
    }

    @Field(key = "status")
    private static /* synthetic */ void getJsStatus$annotations() {
    }

    @Field(key = "type")
    private static /* synthetic */ void getJsType$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final AttendeeRole getRole() {
        String str = this.jsRole;
        if (str != null) {
            return AttendeeRole.INSTANCE.fromString(str);
        }
        return null;
    }

    public final AttendeeStatus getStatus() {
        String str = this.jsStatus;
        if (str != null) {
            return AttendeeStatus.INSTANCE.fromString(str);
        }
        return null;
    }

    public final AttendeeType getType() {
        String str = this.jsType;
        if (str != null) {
            return AttendeeType.INSTANCE.fromString(str);
        }
        return null;
    }

    public Attendee(String str, String str2, String str3, AttendeeRole attendeeRole, AttendeeStatus attendeeStatus, AttendeeType attendeeType) {
        this.id = str;
        this.name = str2;
        this.email = str3;
        this.jsRole = attendeeRole != null ? attendeeRole.getValue() : null;
        this.jsStatus = attendeeStatus != null ? attendeeStatus.getValue() : null;
        this.jsType = attendeeType != null ? attendeeType.getValue() : null;
    }

    public final boolean isNewAttendeePayload() {
        String str = this.id;
        return str == null || str.length() == 0;
    }

    public final ContentValues toContentValues() throws FieldMissingException {
        ContentValues contentValues = new ContentValues();
        assertNewAttendeValid();
        String str = this.name;
        if (str != null) {
            contentValues.put("attendeeName", str);
        }
        String str2 = this.email;
        if (str2 != null) {
            contentValues.put("attendeeEmail", str2);
        }
        AttendeeRole role = getRole();
        if (role != null) {
            contentValues.put("attendeeRelationship", Integer.valueOf(role.getContentProviderValue()));
        }
        AttendeeType type = getType();
        if (type != null) {
            contentValues.put("attendeeType", Integer.valueOf(type.getContentProviderValue()));
        }
        AttendeeStatus status = getStatus();
        if (status != null) {
            contentValues.put("attendeeStatus", Integer.valueOf(status.getContentProviderValue()));
        }
        return contentValues;
    }

    private final void assertNewAttendeValid() throws FieldMissingException {
        if (isNewAttendeePayload()) {
            if (this.email == null) {
                throw new FieldMissingException("new attendees require `email`", null, 2, null);
            }
            if (getRole() == null) {
                throw new FieldMissingException("new attendees require `role`", null, 2, null);
            }
            if (getType() == null) {
                throw new FieldMissingException("new attendees require `type`", null, 2, null);
            }
            if (getStatus() == null) {
                throw new FieldMissingException("new attendees require `status`", null, 2, null);
            }
        }
    }
}

package expo.modules.calendar.next.records;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011¨\u0006/"}, d2 = {"Lexpo/modules/calendar/next/records/AttendeeRecord;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "name", "role", "Lexpo/modules/calendar/next/records/AttendeeRole;", "status", "Lexpo/modules/calendar/next/records/AttendeeStatus;", "type", "Lexpo/modules/calendar/next/records/AttendeeType;", AuthorizationRequest.Scope.EMAIL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/next/records/AttendeeRole;Lexpo/modules/calendar/next/records/AttendeeStatus;Lexpo/modules/calendar/next/records/AttendeeType;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName$annotations", "getName", "getRole$annotations", "getRole", "()Lexpo/modules/calendar/next/records/AttendeeRole;", "getStatus$annotations", "getStatus", "()Lexpo/modules/calendar/next/records/AttendeeStatus;", "getType$annotations", "getType", "()Lexpo/modules/calendar/next/records/AttendeeType;", "getEmail$annotations", "getEmail", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AttendeeRecord implements Record {
    private final String email;
    private String id;
    private final String name;
    private final AttendeeRole role;
    private final AttendeeStatus status;
    private final AttendeeType type;

    public AttendeeRecord() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ AttendeeRecord copy$default(AttendeeRecord attendeeRecord, String str, String str2, AttendeeRole attendeeRole, AttendeeStatus attendeeStatus, AttendeeType attendeeType, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attendeeRecord.id;
        }
        if ((i & 2) != 0) {
            str2 = attendeeRecord.name;
        }
        if ((i & 4) != 0) {
            attendeeRole = attendeeRecord.role;
        }
        if ((i & 8) != 0) {
            attendeeStatus = attendeeRecord.status;
        }
        if ((i & 16) != 0) {
            attendeeType = attendeeRecord.type;
        }
        if ((i & 32) != 0) {
            str3 = attendeeRecord.email;
        }
        AttendeeType attendeeType2 = attendeeType;
        String str4 = str3;
        return attendeeRecord.copy(str, str2, attendeeRole, attendeeStatus, attendeeType2, str4);
    }

    @Field
    public static /* synthetic */ void getEmail$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getRole$annotations() {
    }

    @Field
    public static /* synthetic */ void getStatus$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AttendeeRole getRole() {
        return this.role;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AttendeeStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final AttendeeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final AttendeeRecord copy(String id, String name, AttendeeRole role, AttendeeStatus status, AttendeeType type, String email) {
        return new AttendeeRecord(id, name, role, status, type, email);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttendeeRecord)) {
            return false;
        }
        AttendeeRecord attendeeRecord = (AttendeeRecord) other;
        return Intrinsics.areEqual(this.id, attendeeRecord.id) && Intrinsics.areEqual(this.name, attendeeRecord.name) && this.role == attendeeRecord.role && this.status == attendeeRecord.status && this.type == attendeeRecord.type && Intrinsics.areEqual(this.email, attendeeRecord.email);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        AttendeeRole attendeeRole = this.role;
        int iHashCode3 = (iHashCode2 + (attendeeRole == null ? 0 : attendeeRole.hashCode())) * 31;
        AttendeeStatus attendeeStatus = this.status;
        int iHashCode4 = (iHashCode3 + (attendeeStatus == null ? 0 : attendeeStatus.hashCode())) * 31;
        AttendeeType attendeeType = this.type;
        int iHashCode5 = (iHashCode4 + (attendeeType == null ? 0 : attendeeType.hashCode())) * 31;
        String str3 = this.email;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AttendeeRecord(id=" + this.id + ", name=" + this.name + ", role=" + this.role + ", status=" + this.status + ", type=" + this.type + ", email=" + this.email + ")";
    }

    public AttendeeRecord(String str, String str2, AttendeeRole attendeeRole, AttendeeStatus attendeeStatus, AttendeeType attendeeType, String str3) {
        this.id = str;
        this.name = str2;
        this.role = attendeeRole;
        this.status = attendeeStatus;
        this.type = attendeeType;
        this.email = str3;
    }

    public /* synthetic */ AttendeeRecord(String str, String str2, AttendeeRole attendeeRole, AttendeeStatus attendeeStatus, AttendeeType attendeeType, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : attendeeRole, (i & 8) != 0 ? null : attendeeStatus, (i & 16) != 0 ? null : attendeeType, (i & 32) != 0 ? null : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final AttendeeRole getRole() {
        return this.role;
    }

    public final AttendeeStatus getStatus() {
        return this.status;
    }

    public final AttendeeType getType() {
        return this.type;
    }

    public final String getEmail() {
        return this.email;
    }
}

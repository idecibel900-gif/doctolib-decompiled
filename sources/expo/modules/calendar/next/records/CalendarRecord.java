package expo.modules.calendar.next.records;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0018HÆ\u0003JÆ\u0001\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020\u000b2\b\u0010S\u001a\u0004\u0018\u00010THÖ\u0003J\t\u0010U\u001a\u00020\tHÖ\u0001J\t\u0010V\u001a\u00020\u0003HÖ\u0001R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010'R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010+\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010*R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001c\u001a\u0004\b\n\u0010-R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001c\u001a\u0004\b\f\u0010-R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010\u001eR\u001c\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b\u000e\u0010-R\u001c\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001c\u001a\u0004\b3\u0010-R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001c\u001a\u0004\b5\u00106R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u001c\u001a\u0004\b8\u00106R\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001c\u001a\u0004\b:\u00106R&\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001c\u001a\u0004\b?\u0010@¨\u0006W"}, d2 = {"Lexpo/modules/calendar/next/records/CalendarRecord;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", b.S, "name", Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/calendar/next/records/Source;", "color", "", "isVisible", "", "isSynced", "timeZone", "isPrimary", "allowsModifications", "allowedAvailabilities", "", "allowedReminders", "Lexpo/modules/calendar/next/records/AlarmMethod;", "allowedAttendeeTypes", "Lexpo/modules/calendar/next/records/AttendeeType;", "ownerAccount", "accessLevel", "Lexpo/modules/calendar/next/records/CalendarAccessLevel;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/next/records/Source;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lexpo/modules/calendar/next/records/CalendarAccessLevel;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTitle$annotations", "getTitle", "getName$annotations", "getName", "getSource$annotations", "getSource", "()Lexpo/modules/calendar/next/records/Source;", "getColor$annotations", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isVisible$annotations", "()Z", "isSynced$annotations", "getTimeZone$annotations", "getTimeZone", "isPrimary$annotations", "getAllowsModifications$annotations", "getAllowsModifications", "getAllowedAvailabilities$annotations", "getAllowedAvailabilities", "()Ljava/util/List;", "getAllowedReminders$annotations", "getAllowedReminders", "getAllowedAttendeeTypes$annotations", "getAllowedAttendeeTypes", "getOwnerAccount$annotations", "getOwnerAccount", "setOwnerAccount", "getAccessLevel$annotations", "getAccessLevel", "()Lexpo/modules/calendar/next/records/CalendarAccessLevel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/next/records/Source;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lexpo/modules/calendar/next/records/CalendarAccessLevel;)Lexpo/modules/calendar/next/records/CalendarRecord;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CalendarRecord implements Record {
    private final CalendarAccessLevel accessLevel;
    private final List<AttendeeType> allowedAttendeeTypes;
    private final List<String> allowedAvailabilities;
    private final List<AlarmMethod> allowedReminders;
    private final boolean allowsModifications;
    private final Integer color;
    private String id;
    private final boolean isPrimary;
    private final boolean isSynced;
    private final boolean isVisible;
    private final String name;
    private String ownerAccount;
    private final Source source;
    private final String timeZone;
    private final String title;

    public CalendarRecord() {
        this(null, null, null, null, null, false, false, null, false, false, null, null, null, null, null, 32767, null);
    }

    @Field
    public static /* synthetic */ void getAccessLevel$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowedAttendeeTypes$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowedAvailabilities$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowedReminders$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllowsModifications$annotations() {
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getOwnerAccount$annotations() {
    }

    @Field
    public static /* synthetic */ void getSource$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    @Field
    public static /* synthetic */ void isPrimary$annotations() {
    }

    @Field
    public static /* synthetic */ void isSynced$annotations() {
    }

    @Field
    public static /* synthetic */ void isVisible$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    public final List<String> component11() {
        return this.allowedAvailabilities;
    }

    public final List<AlarmMethod> component12() {
        return this.allowedReminders;
    }

    public final List<AttendeeType> component13() {
        return this.allowedAttendeeTypes;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSynced() {
        return this.isSynced;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsPrimary() {
        return this.isPrimary;
    }

    public final CalendarRecord copy(String id, String title, String name, Source source, Integer color, boolean isVisible, boolean isSynced, String timeZone, boolean isPrimary, boolean allowsModifications, List<String> allowedAvailabilities, List<? extends AlarmMethod> allowedReminders, List<? extends AttendeeType> allowedAttendeeTypes, String ownerAccount, CalendarAccessLevel accessLevel) {
        Intrinsics.checkNotNullParameter(allowedAvailabilities, "allowedAvailabilities");
        Intrinsics.checkNotNullParameter(allowedReminders, "allowedReminders");
        Intrinsics.checkNotNullParameter(allowedAttendeeTypes, "allowedAttendeeTypes");
        return new CalendarRecord(id, title, name, source, color, isVisible, isSynced, timeZone, isPrimary, allowsModifications, allowedAvailabilities, allowedReminders, allowedAttendeeTypes, ownerAccount, accessLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarRecord)) {
            return false;
        }
        CalendarRecord calendarRecord = (CalendarRecord) other;
        return Intrinsics.areEqual(this.id, calendarRecord.id) && Intrinsics.areEqual(this.title, calendarRecord.title) && Intrinsics.areEqual(this.name, calendarRecord.name) && Intrinsics.areEqual(this.source, calendarRecord.source) && Intrinsics.areEqual(this.color, calendarRecord.color) && this.isVisible == calendarRecord.isVisible && this.isSynced == calendarRecord.isSynced && Intrinsics.areEqual(this.timeZone, calendarRecord.timeZone) && this.isPrimary == calendarRecord.isPrimary && this.allowsModifications == calendarRecord.allowsModifications && Intrinsics.areEqual(this.allowedAvailabilities, calendarRecord.allowedAvailabilities) && Intrinsics.areEqual(this.allowedReminders, calendarRecord.allowedReminders) && Intrinsics.areEqual(this.allowedAttendeeTypes, calendarRecord.allowedAttendeeTypes) && Intrinsics.areEqual(this.ownerAccount, calendarRecord.ownerAccount) && this.accessLevel == calendarRecord.accessLevel;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Source source = this.source;
        int iHashCode4 = (iHashCode3 + (source == null ? 0 : source.hashCode())) * 31;
        Integer num = this.color;
        int iHashCode5 = (((((iHashCode4 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isVisible)) * 31) + Boolean.hashCode(this.isSynced)) * 31;
        String str4 = this.timeZone;
        int iHashCode6 = (((((((((((iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.isPrimary)) * 31) + Boolean.hashCode(this.allowsModifications)) * 31) + this.allowedAvailabilities.hashCode()) * 31) + this.allowedReminders.hashCode()) * 31) + this.allowedAttendeeTypes.hashCode()) * 31;
        String str5 = this.ownerAccount;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        CalendarAccessLevel calendarAccessLevel = this.accessLevel;
        return iHashCode7 + (calendarAccessLevel != null ? calendarAccessLevel.hashCode() : 0);
    }

    public String toString() {
        return "CalendarRecord(id=" + this.id + ", title=" + this.title + ", name=" + this.name + ", source=" + this.source + ", color=" + this.color + ", isVisible=" + this.isVisible + ", isSynced=" + this.isSynced + ", timeZone=" + this.timeZone + ", isPrimary=" + this.isPrimary + ", allowsModifications=" + this.allowsModifications + ", allowedAvailabilities=" + this.allowedAvailabilities + ", allowedReminders=" + this.allowedReminders + ", allowedAttendeeTypes=" + this.allowedAttendeeTypes + ", ownerAccount=" + this.ownerAccount + ", accessLevel=" + this.accessLevel + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CalendarRecord(String str, String str2, String str3, Source source, Integer num, boolean z, boolean z2, String str4, boolean z3, boolean z4, List<String> allowedAvailabilities, List<? extends AlarmMethod> allowedReminders, List<? extends AttendeeType> allowedAttendeeTypes, String str5, CalendarAccessLevel calendarAccessLevel) {
        Intrinsics.checkNotNullParameter(allowedAvailabilities, "allowedAvailabilities");
        Intrinsics.checkNotNullParameter(allowedReminders, "allowedReminders");
        Intrinsics.checkNotNullParameter(allowedAttendeeTypes, "allowedAttendeeTypes");
        this.id = str;
        this.title = str2;
        this.name = str3;
        this.source = source;
        this.color = num;
        this.isVisible = z;
        this.isSynced = z2;
        this.timeZone = str4;
        this.isPrimary = z3;
        this.allowsModifications = z4;
        this.allowedAvailabilities = allowedAvailabilities;
        this.allowedReminders = allowedReminders;
        this.allowedAttendeeTypes = allowedAttendeeTypes;
        this.ownerAccount = str5;
        this.accessLevel = calendarAccessLevel;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getName() {
        return this.name;
    }

    public final Source getSource() {
        return this.source;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final boolean isPrimary() {
        return this.isPrimary;
    }

    public final boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    public final List<String> getAllowedAvailabilities() {
        return this.allowedAvailabilities;
    }

    public /* synthetic */ CalendarRecord(String str, String str2, String str3, Source source, Integer num, boolean z, boolean z2, String str4, boolean z3, boolean z4, List list, List list2, List list3, String str5, CalendarAccessLevel calendarAccessLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : source, (i & 16) != 0 ? null : num, (i & 32) != 0 ? true : z, (i & 64) != 0 ? true : z2, (i & 128) != 0 ? null : str4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? false : z3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0 ? z4 : true, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? CollectionsKt.emptyList() : list, (i & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i & 4096) != 0 ? CollectionsKt.emptyList() : list3, (i & 8192) != 0 ? null : str5, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : calendarAccessLevel);
    }

    public final List<AlarmMethod> getAllowedReminders() {
        return this.allowedReminders;
    }

    public final List<AttendeeType> getAllowedAttendeeTypes() {
        return this.allowedAttendeeTypes;
    }

    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    public final void setOwnerAccount(String str) {
        this.ownerAccount = str;
    }

    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }
}

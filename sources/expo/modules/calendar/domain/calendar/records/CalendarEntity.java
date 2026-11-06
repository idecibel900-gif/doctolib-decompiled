package expo.modules.calendar.domain.calendar.records;

import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.calendar.domain.attendee.enums.AttendeeType;
import expo.modules.calendar.domain.calendar.enums.CalendarAccessLevel;
import expo.modules.calendar.domain.event.enums.AlarmMethod;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bHÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010I\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010K\u001a\u0004\u0018\u00010\u0018HÆ\u0003JÔ\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\u00062\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\u0005\u0010\"R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010\u001eR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001eR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u0010&R$\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010&R \u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b3\u0010\u001c\u001a\u0004\b\u0012\u0010\"R \u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b4\u0010\u001c\u001a\u0004\b\u0013\u0010\"R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001c\u001a\u0004\b6\u00107R \u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b8\u0010\u001c\u001a\u0004\b9\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001c\u001a\u0004\b;\u0010<¨\u0006T"}, d2 = {"Lexpo/modules/calendar/domain/calendar/records/CalendarEntity;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", b.S, "isPrimary", "", "allowedAvailabilities", "", "Lexpo/modules/calendar/domain/event/enums/Availability;", "name", "color", "ownerAccount", "timeZone", "allowedReminders", "Lexpo/modules/calendar/domain/event/enums/AlarmMethod;", "allowedAttendeeTypes", "Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;", "isVisible", "isSynced", "accessLevel", "Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;", "allowsModifications", Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/calendar/domain/calendar/records/CalendarSource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;Ljava/lang/Boolean;Lexpo/modules/calendar/domain/calendar/records/CalendarSource;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "isPrimary$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowedAvailabilities$annotations", "getAllowedAvailabilities", "()Ljava/util/List;", "getName$annotations", "getName", "getColor$annotations", "getColor", "getOwnerAccount$annotations", "getOwnerAccount", "getTimeZone$annotations", "getTimeZone", "getAllowedReminders$annotations", "getAllowedReminders", "getAllowedAttendeeTypes$annotations", "getAllowedAttendeeTypes", "isVisible$annotations", "isSynced$annotations", "getAccessLevel$annotations", "getAccessLevel", "()Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;", "getAllowsModifications$annotations", "getAllowsModifications", "getSource$annotations", "getSource", "()Lexpo/modules/calendar/domain/calendar/records/CalendarSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;Ljava/lang/Boolean;Lexpo/modules/calendar/domain/calendar/records/CalendarSource;)Lexpo/modules/calendar/domain/calendar/records/CalendarEntity;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CalendarEntity implements Record {
    private final CalendarAccessLevel accessLevel;
    private final List<AttendeeType> allowedAttendeeTypes;
    private final List<Availability> allowedAvailabilities;
    private final List<AlarmMethod> allowedReminders;
    private final Boolean allowsModifications;
    private final String color;
    private final String id;
    private final Boolean isPrimary;
    private final Boolean isSynced;
    private final Boolean isVisible;
    private final String name;
    private final String ownerAccount;
    private final CalendarSource source;
    private final String timeZone;
    private final String title;

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

    public final List<AttendeeType> component10() {
        return this.allowedAttendeeTypes;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getIsSynced() {
        return this.isSynced;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final CalendarSource getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsPrimary() {
        return this.isPrimary;
    }

    public final List<Availability> component4() {
        return this.allowedAvailabilities;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    public final List<AlarmMethod> component9() {
        return this.allowedReminders;
    }

    public final CalendarEntity copy(String id, String title, Boolean isPrimary, List<? extends Availability> allowedAvailabilities, String name, String color, String ownerAccount, String timeZone, List<? extends AlarmMethod> allowedReminders, List<? extends AttendeeType> allowedAttendeeTypes, Boolean isVisible, Boolean isSynced, CalendarAccessLevel accessLevel, Boolean allowsModifications, CalendarSource source) {
        return new CalendarEntity(id, title, isPrimary, allowedAvailabilities, name, color, ownerAccount, timeZone, allowedReminders, allowedAttendeeTypes, isVisible, isSynced, accessLevel, allowsModifications, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarEntity)) {
            return false;
        }
        CalendarEntity calendarEntity = (CalendarEntity) other;
        return Intrinsics.areEqual(this.id, calendarEntity.id) && Intrinsics.areEqual(this.title, calendarEntity.title) && Intrinsics.areEqual(this.isPrimary, calendarEntity.isPrimary) && Intrinsics.areEqual(this.allowedAvailabilities, calendarEntity.allowedAvailabilities) && Intrinsics.areEqual(this.name, calendarEntity.name) && Intrinsics.areEqual(this.color, calendarEntity.color) && Intrinsics.areEqual(this.ownerAccount, calendarEntity.ownerAccount) && Intrinsics.areEqual(this.timeZone, calendarEntity.timeZone) && Intrinsics.areEqual(this.allowedReminders, calendarEntity.allowedReminders) && Intrinsics.areEqual(this.allowedAttendeeTypes, calendarEntity.allowedAttendeeTypes) && Intrinsics.areEqual(this.isVisible, calendarEntity.isVisible) && Intrinsics.areEqual(this.isSynced, calendarEntity.isSynced) && this.accessLevel == calendarEntity.accessLevel && Intrinsics.areEqual(this.allowsModifications, calendarEntity.allowsModifications) && Intrinsics.areEqual(this.source, calendarEntity.source);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isPrimary;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<Availability> list = this.allowedAvailabilities;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.name;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.color;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ownerAccount;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.timeZone;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<AlarmMethod> list2 = this.allowedReminders;
        int iHashCode9 = (iHashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<AttendeeType> list3 = this.allowedAttendeeTypes;
        int iHashCode10 = (iHashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool2 = this.isVisible;
        int iHashCode11 = (iHashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isSynced;
        int iHashCode12 = (iHashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        CalendarAccessLevel calendarAccessLevel = this.accessLevel;
        int iHashCode13 = (iHashCode12 + (calendarAccessLevel == null ? 0 : calendarAccessLevel.hashCode())) * 31;
        Boolean bool4 = this.allowsModifications;
        int iHashCode14 = (iHashCode13 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        CalendarSource calendarSource = this.source;
        return iHashCode14 + (calendarSource != null ? calendarSource.hashCode() : 0);
    }

    public String toString() {
        return "CalendarEntity(id=" + this.id + ", title=" + this.title + ", isPrimary=" + this.isPrimary + ", allowedAvailabilities=" + this.allowedAvailabilities + ", name=" + this.name + ", color=" + this.color + ", ownerAccount=" + this.ownerAccount + ", timeZone=" + this.timeZone + ", allowedReminders=" + this.allowedReminders + ", allowedAttendeeTypes=" + this.allowedAttendeeTypes + ", isVisible=" + this.isVisible + ", isSynced=" + this.isSynced + ", accessLevel=" + this.accessLevel + ", allowsModifications=" + this.allowsModifications + ", source=" + this.source + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CalendarEntity(String str, String str2, Boolean bool, List<? extends Availability> list, String str3, String str4, String str5, String str6, List<? extends AlarmMethod> list2, List<? extends AttendeeType> list3, Boolean bool2, Boolean bool3, CalendarAccessLevel calendarAccessLevel, Boolean bool4, CalendarSource calendarSource) {
        this.id = str;
        this.title = str2;
        this.isPrimary = bool;
        this.allowedAvailabilities = list;
        this.name = str3;
        this.color = str4;
        this.ownerAccount = str5;
        this.timeZone = str6;
        this.allowedReminders = list2;
        this.allowedAttendeeTypes = list3;
        this.isVisible = bool2;
        this.isSynced = bool3;
        this.accessLevel = calendarAccessLevel;
        this.allowsModifications = bool4;
        this.source = calendarSource;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isPrimary() {
        return this.isPrimary;
    }

    public final List<Availability> getAllowedAvailabilities() {
        return this.allowedAvailabilities;
    }

    public final String getName() {
        return this.name;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final List<AlarmMethod> getAllowedReminders() {
        return this.allowedReminders;
    }

    public final List<AttendeeType> getAllowedAttendeeTypes() {
        return this.allowedAttendeeTypes;
    }

    public final Boolean isVisible() {
        return this.isVisible;
    }

    public final Boolean isSynced() {
        return this.isSynced;
    }

    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final Boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    public final CalendarSource getSource() {
        return this.source;
    }
}

package expo.modules.calendar.domain.calendar.records.input;

import android.content.ContentValues;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import expo.modules.calendar.domain.attendee.enums.AttendeeType;
import expo.modules.calendar.domain.calendar.enums.CalendarAccessLevel;
import expo.modules.calendar.domain.calendar.records.CalendarSource;
import expo.modules.calendar.domain.event.enums.AlarmMethod;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.exceptions.FieldMissingException;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.Required;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010<\u001a\u00020=J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fHÆ\u0003J\u0011\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010J\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010K\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010-J¼\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\bHÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u001c\u001a\u0004\b*\u0010+R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b,\u0010\u001c\u001a\u0004\b\f\u0010-R$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u001c\u001a\u0004\b0\u00101R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001c\u001a\u0004\b3\u0010\u001eR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001c\u001a\u0004\b5\u00101R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001c\u001a\u0004\b7\u00101R \u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b8\u0010\u001c\u001a\u0004\b\u0016\u0010-R \u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b9\u0010\u001c\u001a\u0004\b\u0017\u0010-R \u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010.\u0012\u0004\b:\u0010\u001c\u001a\u0004\b;\u0010-¨\u0006S"}, d2 = {"Lexpo/modules/calendar/domain/calendar/records/input/NewCalendarInput;", "Lexpo/modules/kotlin/records/Record;", "name", "", b.S, Constants.ScionAnalytics.PARAM_SOURCE, "Lexpo/modules/calendar/domain/calendar/records/CalendarSource;", "color", "", "ownerAccount", "accessLevel", "Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;", "isPrimary", "", "allowedAvailabilities", "", "Lexpo/modules/calendar/domain/event/enums/Availability;", "timeZone", "allowedReminders", "Lexpo/modules/calendar/domain/event/enums/AlarmMethod;", "allowedAttendeeTypes", "Lexpo/modules/calendar/domain/attendee/enums/AttendeeType;", "isVisible", "isSynced", "allowsModifications", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/domain/calendar/records/CalendarSource;ILjava/lang/String;Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getTitle$annotations", "getTitle", "getSource$annotations", "getSource", "()Lexpo/modules/calendar/domain/calendar/records/CalendarSource;", "getColor$annotations", "getColor", "()I", "getOwnerAccount$annotations", "getOwnerAccount", "getAccessLevel$annotations", "getAccessLevel", "()Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;", "isPrimary$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowedAvailabilities$annotations", "getAllowedAvailabilities", "()Ljava/util/List;", "getTimeZone$annotations", "getTimeZone", "getAllowedReminders$annotations", "getAllowedReminders", "getAllowedAttendeeTypes$annotations", "getAllowedAttendeeTypes", "isVisible$annotations", "isSynced$annotations", "getAllowsModifications$annotations", "getAllowsModifications", "toContentValues", "Landroid/content/ContentValues;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/domain/calendar/records/CalendarSource;ILjava/lang/String;Lexpo/modules/calendar/domain/calendar/enums/CalendarAccessLevel;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lexpo/modules/calendar/domain/calendar/records/input/NewCalendarInput;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class NewCalendarInput implements Record {
    private final CalendarAccessLevel accessLevel;
    private final List<AttendeeType> allowedAttendeeTypes;
    private final List<Availability> allowedAvailabilities;
    private final List<AlarmMethod> allowedReminders;
    private final Boolean allowsModifications;
    private final int color;
    private final Boolean isPrimary;
    private final Boolean isSynced;
    private final Boolean isVisible;
    private final String name;
    private final String ownerAccount;
    private final CalendarSource source;
    private final String timeZone;
    private final String title;

    @Field
    @Required
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
    @Required
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    @Required
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    @Required
    public static /* synthetic */ void getOwnerAccount$annotations() {
    }

    @Field
    @Required
    public static /* synthetic */ void getSource$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeZone$annotations() {
    }

    @Field
    @Required
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
    public final String getName() {
        return this.name;
    }

    public final List<AlarmMethod> component10() {
        return this.allowedReminders;
    }

    public final List<AttendeeType> component11() {
        return this.allowedAttendeeTypes;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getIsVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getIsSynced() {
        return this.isSynced;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CalendarSource getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsPrimary() {
        return this.isPrimary;
    }

    public final List<Availability> component8() {
        return this.allowedAvailabilities;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    public final NewCalendarInput copy(String name, String title, CalendarSource source, int color, String ownerAccount, CalendarAccessLevel accessLevel, Boolean isPrimary, List<? extends Availability> allowedAvailabilities, String timeZone, List<? extends AlarmMethod> allowedReminders, List<? extends AttendeeType> allowedAttendeeTypes, Boolean isVisible, Boolean isSynced, Boolean allowsModifications) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(accessLevel, "accessLevel");
        return new NewCalendarInput(name, title, source, color, ownerAccount, accessLevel, isPrimary, allowedAvailabilities, timeZone, allowedReminders, allowedAttendeeTypes, isVisible, isSynced, allowsModifications);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewCalendarInput)) {
            return false;
        }
        NewCalendarInput newCalendarInput = (NewCalendarInput) other;
        return Intrinsics.areEqual(this.name, newCalendarInput.name) && Intrinsics.areEqual(this.title, newCalendarInput.title) && Intrinsics.areEqual(this.source, newCalendarInput.source) && this.color == newCalendarInput.color && Intrinsics.areEqual(this.ownerAccount, newCalendarInput.ownerAccount) && this.accessLevel == newCalendarInput.accessLevel && Intrinsics.areEqual(this.isPrimary, newCalendarInput.isPrimary) && Intrinsics.areEqual(this.allowedAvailabilities, newCalendarInput.allowedAvailabilities) && Intrinsics.areEqual(this.timeZone, newCalendarInput.timeZone) && Intrinsics.areEqual(this.allowedReminders, newCalendarInput.allowedReminders) && Intrinsics.areEqual(this.allowedAttendeeTypes, newCalendarInput.allowedAttendeeTypes) && Intrinsics.areEqual(this.isVisible, newCalendarInput.isVisible) && Intrinsics.areEqual(this.isSynced, newCalendarInput.isSynced) && Intrinsics.areEqual(this.allowsModifications, newCalendarInput.allowsModifications);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.name.hashCode() * 31) + this.title.hashCode()) * 31) + this.source.hashCode()) * 31) + Integer.hashCode(this.color)) * 31) + this.ownerAccount.hashCode()) * 31) + this.accessLevel.hashCode()) * 31;
        Boolean bool = this.isPrimary;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        List<Availability> list = this.allowedAvailabilities;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.timeZone;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        List<AlarmMethod> list2 = this.allowedReminders;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<AttendeeType> list3 = this.allowedAttendeeTypes;
        int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        Boolean bool2 = this.isVisible;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isSynced;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.allowsModifications;
        return iHashCode8 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "NewCalendarInput(name=" + this.name + ", title=" + this.title + ", source=" + this.source + ", color=" + this.color + ", ownerAccount=" + this.ownerAccount + ", accessLevel=" + this.accessLevel + ", isPrimary=" + this.isPrimary + ", allowedAvailabilities=" + this.allowedAvailabilities + ", timeZone=" + this.timeZone + ", allowedReminders=" + this.allowedReminders + ", allowedAttendeeTypes=" + this.allowedAttendeeTypes + ", isVisible=" + this.isVisible + ", isSynced=" + this.isSynced + ", allowsModifications=" + this.allowsModifications + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewCalendarInput(String name, String title, CalendarSource source, int i, String ownerAccount, CalendarAccessLevel accessLevel, Boolean bool, List<? extends Availability> list, String str, List<? extends AlarmMethod> list2, List<? extends AttendeeType> list3, Boolean bool2, Boolean bool3, Boolean bool4) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(ownerAccount, "ownerAccount");
        Intrinsics.checkNotNullParameter(accessLevel, "accessLevel");
        this.name = name;
        this.title = title;
        this.source = source;
        this.color = i;
        this.ownerAccount = ownerAccount;
        this.accessLevel = accessLevel;
        this.isPrimary = bool;
        this.allowedAvailabilities = list;
        this.timeZone = str;
        this.allowedReminders = list2;
        this.allowedAttendeeTypes = list3;
        this.isVisible = bool2;
        this.isSynced = bool3;
        this.allowsModifications = bool4;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CalendarSource getSource() {
        return this.source;
    }

    public final int getColor() {
        return this.color;
    }

    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    public final CalendarAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final Boolean isPrimary() {
        return this.isPrimary;
    }

    public final List<Availability> getAllowedAvailabilities() {
        return this.allowedAvailabilities;
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

    public final Boolean getAllowsModifications() {
        return this.allowsModifications;
    }

    public final ContentValues toContentValues() throws FieldMissingException {
        ContentValues contentValues = new ContentValues();
        this.source.assertValidForNewCalendar();
        contentValues.put("name", this.name);
        contentValues.put("calendar_displayName", this.title);
        contentValues.put("visible", this.isVisible);
        contentValues.put("sync_events", this.isSynced);
        contentValues.put("account_name", this.source.getName());
        contentValues.put("account_type", this.source.getResolvedType());
        contentValues.put("calendar_color", Integer.valueOf(this.color));
        contentValues.put("calendar_access_level", Integer.valueOf(this.accessLevel.getContentProviderValue()));
        contentValues.put("ownerAccount", this.ownerAccount);
        String id = this.timeZone;
        if (id == null) {
            id = TimeZone.getDefault().getID();
        }
        contentValues.put("calendar_timezone", id);
        List<AlarmMethod> list = this.allowedReminders;
        if (list != null) {
            List<AlarmMethod> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((AlarmMethod) it.next()).getContentProviderValue()));
            }
            contentValues.put("allowedReminders", CollectionsKt.joinToString$default(arrayList, f.a, null, null, 0, null, null, 62, null));
        }
        List<Availability> list3 = this.allowedAvailabilities;
        if (list3 != null) {
            List<Availability> list4 = list3;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(((Availability) it2.next()).getContentProviderValue()));
            }
            contentValues.put("allowedAvailability", CollectionsKt.joinToString$default(arrayList2, f.a, null, null, 0, null, null, 62, null));
        }
        List<AttendeeType> list5 = this.allowedAttendeeTypes;
        if (list5 != null) {
            List<AttendeeType> list6 = list5;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
            Iterator<T> it3 = list6.iterator();
            while (it3.hasNext()) {
                arrayList3.add(Integer.valueOf(((AttendeeType) it3.next()).getContentProviderValue()));
            }
            contentValues.put("allowedAttendeeTypes", CollectionsKt.joinToString$default(arrayList3, f.a, null, null, 0, null, null, 62, null));
        }
        return contentValues;
    }
}

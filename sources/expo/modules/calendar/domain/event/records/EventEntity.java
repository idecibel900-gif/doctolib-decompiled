package expo.modules.calendar.domain.event.records;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.domain.event.enums.EventAccessLevel;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bJ\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010V\u001a\u00020\u000fHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u000fHÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jñ\u0001\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010c\u001a\u00020\u000f2\b\u0010d\u001a\u0004\u0018\u00010eHÖ\u0003J\t\u0010f\u001a\u00020gHÖ\u0001J\t\u0010h\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010\"R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010 \u001a\u0004\b*\u0010\"R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010 \u001a\u0004\b,\u0010\"R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010 \u001a\u0004\b.\u0010/R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010 \u001a\u0004\b1\u00102R\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010 \u001a\u0004\b4\u00105R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010 \u001a\u0004\b7\u0010\"R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010 \u001a\u0004\b9\u0010\"R\u001c\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010 \u001a\u0004\b;\u00105R\u001c\u0010\u0013\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010 \u001a\u0004\b=\u00105R\u001c\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010 \u001a\u0004\b?\u00105R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010 \u001a\u0004\bA\u0010\"R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010 \u001a\u0004\bC\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010 \u001a\u0004\bE\u0010FR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010 \u001a\u0004\bH\u0010IR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010 \u001a\u0004\bK\u0010\"R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010 \u001a\u0004\bM\u0010\"¨\u0006i"}, d2 = {"Lexpo/modules/calendar/domain/event/records/EventEntity;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "calendarId", b.S, "notes", b.P, b.d, "alarms", "", "Lexpo/modules/calendar/domain/event/records/Alarm;", "availability", "Lexpo/modules/calendar/domain/event/enums/Availability;", "allDay", "", "location", "organizerEmail", "guestsCanModify", "guestsCanInviteOthers", "guestsCanSeeGuests", "timeZone", "endTimeZone", "accessLevel", "Lexpo/modules/calendar/domain/event/enums/EventAccessLevel;", "recurrenceRule", "Lexpo/modules/calendar/domain/event/records/RecurrenceRuleEntity;", "originalId", "instanceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lexpo/modules/calendar/domain/event/enums/Availability;ZLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Lexpo/modules/calendar/domain/event/enums/EventAccessLevel;Lexpo/modules/calendar/domain/event/records/RecurrenceRuleEntity;Ljava/lang/String;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getCalendarId$annotations", "getCalendarId", "getTitle$annotations", "getTitle", "getNotes$annotations", "getNotes", "getStartDate$annotations", "getStartDate", "getEndDate$annotations", "getEndDate", "getAlarms$annotations", "getAlarms", "()Ljava/util/List;", "getAvailability$annotations", "getAvailability", "()Lexpo/modules/calendar/domain/event/enums/Availability;", "getAllDay$annotations", "getAllDay", "()Z", "getLocation$annotations", "getLocation", "getOrganizerEmail$annotations", "getOrganizerEmail", "getGuestsCanModify$annotations", "getGuestsCanModify", "getGuestsCanInviteOthers$annotations", "getGuestsCanInviteOthers", "getGuestsCanSeeGuests$annotations", "getGuestsCanSeeGuests", "getTimeZone$annotations", "getTimeZone", "getEndTimeZone$annotations", "getEndTimeZone", "getAccessLevel$annotations", "getAccessLevel", "()Lexpo/modules/calendar/domain/event/enums/EventAccessLevel;", "getRecurrenceRule$annotations", "getRecurrenceRule", "()Lexpo/modules/calendar/domain/event/records/RecurrenceRuleEntity;", "getOriginalId$annotations", "getOriginalId", "getInstanceId$annotations", "getInstanceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EventEntity implements Record {
    private final EventAccessLevel accessLevel;
    private final List<Alarm> alarms;
    private final boolean allDay;
    private final Availability availability;
    private final String calendarId;
    private final String endDate;
    private final String endTimeZone;
    private final boolean guestsCanInviteOthers;
    private final boolean guestsCanModify;
    private final boolean guestsCanSeeGuests;
    private final String id;
    private final String instanceId;
    private final String location;
    private final String notes;
    private final String organizerEmail;
    private final String originalId;
    private final RecurrenceRuleEntity recurrenceRule;
    private final String startDate;
    private final String timeZone;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventEntity copy$default(EventEntity eventEntity, String str, String str2, String str3, String str4, String str5, String str6, List list, Availability availability, boolean z, String str7, String str8, boolean z2, boolean z3, boolean z4, String str9, String str10, EventAccessLevel eventAccessLevel, RecurrenceRuleEntity recurrenceRuleEntity, String str11, String str12, int i, Object obj) {
        String str13;
        String str14;
        String str15 = (i & 1) != 0 ? eventEntity.id : str;
        String str16 = (i & 2) != 0 ? eventEntity.calendarId : str2;
        String str17 = (i & 4) != 0 ? eventEntity.title : str3;
        String str18 = (i & 8) != 0 ? eventEntity.notes : str4;
        String str19 = (i & 16) != 0 ? eventEntity.startDate : str5;
        String str20 = (i & 32) != 0 ? eventEntity.endDate : str6;
        List list2 = (i & 64) != 0 ? eventEntity.alarms : list;
        Availability availability2 = (i & 128) != 0 ? eventEntity.availability : availability;
        boolean z5 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? eventEntity.allDay : z;
        String str21 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? eventEntity.location : str7;
        String str22 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? eventEntity.organizerEmail : str8;
        boolean z6 = (i & 2048) != 0 ? eventEntity.guestsCanModify : z2;
        boolean z7 = (i & 4096) != 0 ? eventEntity.guestsCanInviteOthers : z3;
        boolean z8 = (i & 8192) != 0 ? eventEntity.guestsCanSeeGuests : z4;
        String str23 = str15;
        String str24 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? eventEntity.timeZone : str9;
        String str25 = (i & 32768) != 0 ? eventEntity.endTimeZone : str10;
        EventAccessLevel eventAccessLevel2 = (i & 65536) != 0 ? eventEntity.accessLevel : eventAccessLevel;
        RecurrenceRuleEntity recurrenceRuleEntity2 = (i & 131072) != 0 ? eventEntity.recurrenceRule : recurrenceRuleEntity;
        String str26 = (i & 262144) != 0 ? eventEntity.originalId : str11;
        if ((i & 524288) != 0) {
            str14 = str26;
            str13 = eventEntity.instanceId;
        } else {
            str13 = str12;
            str14 = str26;
        }
        return eventEntity.copy(str23, str16, str17, str18, str19, str20, list2, availability2, z5, str21, str22, z6, z7, z8, str24, str25, eventAccessLevel2, recurrenceRuleEntity2, str14, str13);
    }

    @Field
    public static /* synthetic */ void getAccessLevel$annotations() {
    }

    @Field
    public static /* synthetic */ void getAlarms$annotations() {
    }

    @Field
    public static /* synthetic */ void getAllDay$annotations() {
    }

    @Field
    public static /* synthetic */ void getAvailability$annotations() {
    }

    @Field
    public static /* synthetic */ void getCalendarId$annotations() {
    }

    @Field
    public static /* synthetic */ void getEndDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getEndTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanInviteOthers$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanModify$annotations() {
    }

    @Field
    public static /* synthetic */ void getGuestsCanSeeGuests$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getInstanceId$annotations() {
    }

    @Field
    public static /* synthetic */ void getLocation$annotations() {
    }

    @Field
    public static /* synthetic */ void getNotes$annotations() {
    }

    @Field
    public static /* synthetic */ void getOrganizerEmail$annotations() {
    }

    @Field
    public static /* synthetic */ void getOriginalId$annotations() {
    }

    @Field
    public static /* synthetic */ void getRecurrenceRule$annotations() {
    }

    @Field
    public static /* synthetic */ void getStartDate$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeZone$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitle$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getOrganizerEmail() {
        return this.organizerEmail;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getGuestsCanSeeGuests() {
        return this.guestsCanSeeGuests;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final EventAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final RecurrenceRuleEntity getRecurrenceRule() {
        return this.recurrenceRule;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getOriginalId() {
        return this.originalId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCalendarId() {
        return this.calendarId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    public final List<Alarm> component7() {
        return this.alarms;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Availability getAvailability() {
        return this.availability;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAllDay() {
        return this.allDay;
    }

    public final EventEntity copy(String id, String calendarId, String title, String notes, String startDate, String endDate, List<Alarm> alarms, Availability availability, boolean allDay, String location, String organizerEmail, boolean guestsCanModify, boolean guestsCanInviteOthers, boolean guestsCanSeeGuests, String timeZone, String endTimeZone, EventAccessLevel accessLevel, RecurrenceRuleEntity recurrenceRule, String originalId, String instanceId) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        return new EventEntity(id, calendarId, title, notes, startDate, endDate, alarms, availability, allDay, location, organizerEmail, guestsCanModify, guestsCanInviteOthers, guestsCanSeeGuests, timeZone, endTimeZone, accessLevel, recurrenceRule, originalId, instanceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventEntity)) {
            return false;
        }
        EventEntity eventEntity = (EventEntity) other;
        return Intrinsics.areEqual(this.id, eventEntity.id) && Intrinsics.areEqual(this.calendarId, eventEntity.calendarId) && Intrinsics.areEqual(this.title, eventEntity.title) && Intrinsics.areEqual(this.notes, eventEntity.notes) && Intrinsics.areEqual(this.startDate, eventEntity.startDate) && Intrinsics.areEqual(this.endDate, eventEntity.endDate) && Intrinsics.areEqual(this.alarms, eventEntity.alarms) && this.availability == eventEntity.availability && this.allDay == eventEntity.allDay && Intrinsics.areEqual(this.location, eventEntity.location) && Intrinsics.areEqual(this.organizerEmail, eventEntity.organizerEmail) && this.guestsCanModify == eventEntity.guestsCanModify && this.guestsCanInviteOthers == eventEntity.guestsCanInviteOthers && this.guestsCanSeeGuests == eventEntity.guestsCanSeeGuests && Intrinsics.areEqual(this.timeZone, eventEntity.timeZone) && Intrinsics.areEqual(this.endTimeZone, eventEntity.endTimeZone) && this.accessLevel == eventEntity.accessLevel && Intrinsics.areEqual(this.recurrenceRule, eventEntity.recurrenceRule) && Intrinsics.areEqual(this.originalId, eventEntity.originalId) && Intrinsics.areEqual(this.instanceId, eventEntity.instanceId);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.calendarId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.notes;
        int iHashCode4 = (((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.startDate.hashCode()) * 31) + this.endDate.hashCode()) * 31;
        List<Alarm> list = this.alarms;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Availability availability = this.availability;
        int iHashCode6 = (((iHashCode5 + (availability == null ? 0 : availability.hashCode())) * 31) + Boolean.hashCode(this.allDay)) * 31;
        String str4 = this.location;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.organizerEmail;
        int iHashCode8 = (((((((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.guestsCanModify)) * 31) + Boolean.hashCode(this.guestsCanInviteOthers)) * 31) + Boolean.hashCode(this.guestsCanSeeGuests)) * 31;
        String str6 = this.timeZone;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endTimeZone;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        EventAccessLevel eventAccessLevel = this.accessLevel;
        int iHashCode11 = (iHashCode10 + (eventAccessLevel == null ? 0 : eventAccessLevel.hashCode())) * 31;
        RecurrenceRuleEntity recurrenceRuleEntity = this.recurrenceRule;
        int iHashCode12 = (iHashCode11 + (recurrenceRuleEntity == null ? 0 : recurrenceRuleEntity.hashCode())) * 31;
        String str8 = this.originalId;
        int iHashCode13 = (iHashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.instanceId;
        return iHashCode13 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "EventEntity(id=" + this.id + ", calendarId=" + this.calendarId + ", title=" + this.title + ", notes=" + this.notes + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", alarms=" + this.alarms + ", availability=" + this.availability + ", allDay=" + this.allDay + ", location=" + this.location + ", organizerEmail=" + this.organizerEmail + ", guestsCanModify=" + this.guestsCanModify + ", guestsCanInviteOthers=" + this.guestsCanInviteOthers + ", guestsCanSeeGuests=" + this.guestsCanSeeGuests + ", timeZone=" + this.timeZone + ", endTimeZone=" + this.endTimeZone + ", accessLevel=" + this.accessLevel + ", recurrenceRule=" + this.recurrenceRule + ", originalId=" + this.originalId + ", instanceId=" + this.instanceId + ")";
    }

    public EventEntity(String id, String str, String str2, String str3, String startDate, String endDate, List<Alarm> list, Availability availability, boolean z, String str4, String str5, boolean z2, boolean z3, boolean z4, String str6, String str7, EventAccessLevel eventAccessLevel, RecurrenceRuleEntity recurrenceRuleEntity, String str8, String str9) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        this.id = id;
        this.calendarId = str;
        this.title = str2;
        this.notes = str3;
        this.startDate = startDate;
        this.endDate = endDate;
        this.alarms = list;
        this.availability = availability;
        this.allDay = z;
        this.location = str4;
        this.organizerEmail = str5;
        this.guestsCanModify = z2;
        this.guestsCanInviteOthers = z3;
        this.guestsCanSeeGuests = z4;
        this.timeZone = str6;
        this.endTimeZone = str7;
        this.accessLevel = eventAccessLevel;
        this.recurrenceRule = recurrenceRuleEntity;
        this.originalId = str8;
        this.instanceId = str9;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCalendarId() {
        return this.calendarId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final List<Alarm> getAlarms() {
        return this.alarms;
    }

    public final Availability getAvailability() {
        return this.availability;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getOrganizerEmail() {
        return this.organizerEmail;
    }

    public final boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    public final boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    public final boolean getGuestsCanSeeGuests() {
        return this.guestsCanSeeGuests;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    public final EventAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final RecurrenceRuleEntity getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final String getOriginalId() {
        return this.originalId;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }
}

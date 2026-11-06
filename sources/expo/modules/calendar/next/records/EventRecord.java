package expo.modules.calendar.next.records;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010`\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010e\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010f\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0090\u0002\u0010i\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\u00122\b\u0010l\u001a\u0004\u0018\u00010mHÖ\u0003J\t\u0010n\u001a\u00020oHÖ\u0001J\t\u0010p\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\"\u001a\u0004\b(\u0010$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\"\u001a\u0004\b,\u0010$R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\"\u001a\u0004\b.\u0010$R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\"\u001a\u0004\b0\u0010$R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\"\u001a\u0004\b2\u00103R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\"\u001a\u0004\b5\u00106R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\"\u001a\u0004\b8\u0010$R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\"\u001a\u0004\b:\u0010$R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\b;\u0010\"\u001a\u0004\b<\u0010=R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010\"\u001a\u0004\b@\u0010AR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\"\u001a\u0004\bC\u0010DR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010\"\u001a\u0004\bF\u0010$R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010\"\u001a\u0004\bH\u0010IR \u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\bJ\u0010\"\u001a\u0004\bK\u0010=R \u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\bL\u0010\"\u001a\u0004\bM\u0010=R \u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010>\u0012\u0004\bN\u0010\"\u001a\u0004\bO\u0010=R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010\"\u001a\u0004\bQ\u0010$R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\"\u001a\u0004\bS\u0010$¨\u0006q"}, d2 = {"Lexpo/modules/calendar/next/records/EventRecord;", "Lexpo/modules/kotlin/records/Record;", DiagnosticsEntry.ID_KEY, "", "calendarId", b.S, "location", "timeZone", "endTimeZone", "notes", "alarms", "", "Lexpo/modules/calendar/next/records/AlarmRecord;", "recurrenceRule", "Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;", b.P, b.d, "allDay", "", "availability", "Lexpo/modules/calendar/next/records/EventAvailability;", "status", "Lexpo/modules/calendar/next/records/EventStatus;", "organizerEmail", "accessLevel", "Lexpo/modules/calendar/next/records/EventAccessLevel;", "guestsCanModify", "guestsCanInviteOthers", "guestsCanSeeGuests", "originalId", "instanceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lexpo/modules/calendar/next/records/EventAvailability;Lexpo/modules/calendar/next/records/EventStatus;Ljava/lang/String;Lexpo/modules/calendar/next/records/EventAccessLevel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getCalendarId$annotations", "getCalendarId", "getTitle$annotations", "getTitle", "getLocation$annotations", "getLocation", "getTimeZone$annotations", "getTimeZone", "getEndTimeZone$annotations", "getEndTimeZone", "getNotes$annotations", "getNotes", "getAlarms$annotations", "getAlarms", "()Ljava/util/List;", "getRecurrenceRule$annotations", "getRecurrenceRule", "()Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;", "getStartDate$annotations", "getStartDate", "getEndDate$annotations", "getEndDate", "getAllDay$annotations", "getAllDay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAvailability$annotations", "getAvailability", "()Lexpo/modules/calendar/next/records/EventAvailability;", "getStatus$annotations", "getStatus", "()Lexpo/modules/calendar/next/records/EventStatus;", "getOrganizerEmail$annotations", "getOrganizerEmail", "getAccessLevel$annotations", "getAccessLevel", "()Lexpo/modules/calendar/next/records/EventAccessLevel;", "getGuestsCanModify$annotations", "getGuestsCanModify", "getGuestsCanInviteOthers$annotations", "getGuestsCanInviteOthers", "getGuestsCanSeeGuests$annotations", "getGuestsCanSeeGuests", "getOriginalId$annotations", "getOriginalId", "getInstanceId$annotations", "getInstanceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lexpo/modules/calendar/next/records/RecurrenceRuleRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lexpo/modules/calendar/next/records/EventAvailability;Lexpo/modules/calendar/next/records/EventStatus;Ljava/lang/String;Lexpo/modules/calendar/next/records/EventAccessLevel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lexpo/modules/calendar/next/records/EventRecord;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EventRecord implements Record {
    private final EventAccessLevel accessLevel;
    private final List<AlarmRecord> alarms;
    private final Boolean allDay;
    private final EventAvailability availability;
    private final String calendarId;
    private final String endDate;
    private final String endTimeZone;
    private final Boolean guestsCanInviteOthers;
    private final Boolean guestsCanModify;
    private final Boolean guestsCanSeeGuests;
    private final String id;
    private final String instanceId;
    private final String location;
    private final String notes;
    private final String organizerEmail;
    private final String originalId;
    private final RecurrenceRuleRecord recurrenceRule;
    private final String startDate;
    private final EventStatus status;
    private final String timeZone;
    private final String title;

    public EventRecord() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventRecord copy$default(EventRecord eventRecord, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, RecurrenceRuleRecord recurrenceRuleRecord, String str8, String str9, Boolean bool, EventAvailability eventAvailability, EventStatus eventStatus, String str10, EventAccessLevel eventAccessLevel, Boolean bool2, Boolean bool3, Boolean bool4, String str11, String str12, int i, Object obj) {
        String str13;
        String str14;
        String str15 = (i & 1) != 0 ? eventRecord.id : str;
        String str16 = (i & 2) != 0 ? eventRecord.calendarId : str2;
        String str17 = (i & 4) != 0 ? eventRecord.title : str3;
        String str18 = (i & 8) != 0 ? eventRecord.location : str4;
        String str19 = (i & 16) != 0 ? eventRecord.timeZone : str5;
        String str20 = (i & 32) != 0 ? eventRecord.endTimeZone : str6;
        String str21 = (i & 64) != 0 ? eventRecord.notes : str7;
        List list2 = (i & 128) != 0 ? eventRecord.alarms : list;
        RecurrenceRuleRecord recurrenceRuleRecord2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? eventRecord.recurrenceRule : recurrenceRuleRecord;
        String str22 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? eventRecord.startDate : str8;
        String str23 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? eventRecord.endDate : str9;
        Boolean bool5 = (i & 2048) != 0 ? eventRecord.allDay : bool;
        EventAvailability eventAvailability2 = (i & 4096) != 0 ? eventRecord.availability : eventAvailability;
        EventStatus eventStatus2 = (i & 8192) != 0 ? eventRecord.status : eventStatus;
        String str24 = str15;
        String str25 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? eventRecord.organizerEmail : str10;
        EventAccessLevel eventAccessLevel2 = (i & 32768) != 0 ? eventRecord.accessLevel : eventAccessLevel;
        Boolean bool6 = (i & 65536) != 0 ? eventRecord.guestsCanModify : bool2;
        Boolean bool7 = (i & 131072) != 0 ? eventRecord.guestsCanInviteOthers : bool3;
        Boolean bool8 = (i & 262144) != 0 ? eventRecord.guestsCanSeeGuests : bool4;
        String str26 = (i & 524288) != 0 ? eventRecord.originalId : str11;
        if ((i & 1048576) != 0) {
            str14 = str26;
            str13 = eventRecord.instanceId;
        } else {
            str13 = str12;
            str14 = str26;
        }
        return eventRecord.copy(str24, str16, str17, str18, str19, str20, str21, list2, recurrenceRuleRecord2, str22, str23, bool5, eventAvailability2, eventStatus2, str25, eventAccessLevel2, bool6, bool7, bool8, str14, str13);
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
    public static /* synthetic */ void getStatus$annotations() {
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
    public final String getStartDate() {
        return this.startDate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getAllDay() {
        return this.allDay;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final EventAvailability getAvailability() {
        return this.availability;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final EventStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getOrganizerEmail() {
        return this.organizerEmail;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final EventAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Boolean getGuestsCanSeeGuests() {
        return this.guestsCanSeeGuests;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCalendarId() {
        return this.calendarId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getOriginalId() {
        return this.originalId;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    public final List<AlarmRecord> component8() {
        return this.alarms;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RecurrenceRuleRecord getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final EventRecord copy(String id, String calendarId, String title, String location, String timeZone, String endTimeZone, String notes, List<AlarmRecord> alarms, RecurrenceRuleRecord recurrenceRule, String startDate, String endDate, Boolean allDay, EventAvailability availability, EventStatus status, String organizerEmail, EventAccessLevel accessLevel, Boolean guestsCanModify, Boolean guestsCanInviteOthers, Boolean guestsCanSeeGuests, String originalId, String instanceId) {
        return new EventRecord(id, calendarId, title, location, timeZone, endTimeZone, notes, alarms, recurrenceRule, startDate, endDate, allDay, availability, status, organizerEmail, accessLevel, guestsCanModify, guestsCanInviteOthers, guestsCanSeeGuests, originalId, instanceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventRecord)) {
            return false;
        }
        EventRecord eventRecord = (EventRecord) other;
        return Intrinsics.areEqual(this.id, eventRecord.id) && Intrinsics.areEqual(this.calendarId, eventRecord.calendarId) && Intrinsics.areEqual(this.title, eventRecord.title) && Intrinsics.areEqual(this.location, eventRecord.location) && Intrinsics.areEqual(this.timeZone, eventRecord.timeZone) && Intrinsics.areEqual(this.endTimeZone, eventRecord.endTimeZone) && Intrinsics.areEqual(this.notes, eventRecord.notes) && Intrinsics.areEqual(this.alarms, eventRecord.alarms) && Intrinsics.areEqual(this.recurrenceRule, eventRecord.recurrenceRule) && Intrinsics.areEqual(this.startDate, eventRecord.startDate) && Intrinsics.areEqual(this.endDate, eventRecord.endDate) && Intrinsics.areEqual(this.allDay, eventRecord.allDay) && this.availability == eventRecord.availability && this.status == eventRecord.status && Intrinsics.areEqual(this.organizerEmail, eventRecord.organizerEmail) && this.accessLevel == eventRecord.accessLevel && Intrinsics.areEqual(this.guestsCanModify, eventRecord.guestsCanModify) && Intrinsics.areEqual(this.guestsCanInviteOthers, eventRecord.guestsCanInviteOthers) && Intrinsics.areEqual(this.guestsCanSeeGuests, eventRecord.guestsCanSeeGuests) && Intrinsics.areEqual(this.originalId, eventRecord.originalId) && Intrinsics.areEqual(this.instanceId, eventRecord.instanceId);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.calendarId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.location;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.timeZone;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.endTimeZone;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.notes;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<AlarmRecord> list = this.alarms;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        RecurrenceRuleRecord recurrenceRuleRecord = this.recurrenceRule;
        int iHashCode9 = (iHashCode8 + (recurrenceRuleRecord == null ? 0 : recurrenceRuleRecord.hashCode())) * 31;
        String str8 = this.startDate;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.endDate;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.allDay;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        EventAvailability eventAvailability = this.availability;
        int iHashCode13 = (iHashCode12 + (eventAvailability == null ? 0 : eventAvailability.hashCode())) * 31;
        EventStatus eventStatus = this.status;
        int iHashCode14 = (iHashCode13 + (eventStatus == null ? 0 : eventStatus.hashCode())) * 31;
        String str10 = this.organizerEmail;
        int iHashCode15 = (iHashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        EventAccessLevel eventAccessLevel = this.accessLevel;
        int iHashCode16 = (iHashCode15 + (eventAccessLevel == null ? 0 : eventAccessLevel.hashCode())) * 31;
        Boolean bool2 = this.guestsCanModify;
        int iHashCode17 = (iHashCode16 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.guestsCanInviteOthers;
        int iHashCode18 = (iHashCode17 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.guestsCanSeeGuests;
        int iHashCode19 = (iHashCode18 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str11 = this.originalId;
        int iHashCode20 = (iHashCode19 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.instanceId;
        return iHashCode20 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        return "EventRecord(id=" + this.id + ", calendarId=" + this.calendarId + ", title=" + this.title + ", location=" + this.location + ", timeZone=" + this.timeZone + ", endTimeZone=" + this.endTimeZone + ", notes=" + this.notes + ", alarms=" + this.alarms + ", recurrenceRule=" + this.recurrenceRule + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", allDay=" + this.allDay + ", availability=" + this.availability + ", status=" + this.status + ", organizerEmail=" + this.organizerEmail + ", accessLevel=" + this.accessLevel + ", guestsCanModify=" + this.guestsCanModify + ", guestsCanInviteOthers=" + this.guestsCanInviteOthers + ", guestsCanSeeGuests=" + this.guestsCanSeeGuests + ", originalId=" + this.originalId + ", instanceId=" + this.instanceId + ")";
    }

    public EventRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<AlarmRecord> list, RecurrenceRuleRecord recurrenceRuleRecord, String str8, String str9, Boolean bool, EventAvailability eventAvailability, EventStatus eventStatus, String str10, EventAccessLevel eventAccessLevel, Boolean bool2, Boolean bool3, Boolean bool4, String str11, String str12) {
        this.id = str;
        this.calendarId = str2;
        this.title = str3;
        this.location = str4;
        this.timeZone = str5;
        this.endTimeZone = str6;
        this.notes = str7;
        this.alarms = list;
        this.recurrenceRule = recurrenceRuleRecord;
        this.startDate = str8;
        this.endDate = str9;
        this.allDay = bool;
        this.availability = eventAvailability;
        this.status = eventStatus;
        this.organizerEmail = str10;
        this.accessLevel = eventAccessLevel;
        this.guestsCanModify = bool2;
        this.guestsCanInviteOthers = bool3;
        this.guestsCanSeeGuests = bool4;
        this.originalId = str11;
        this.instanceId = str12;
    }

    public /* synthetic */ EventRecord(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, RecurrenceRuleRecord recurrenceRuleRecord, String str8, String str9, Boolean bool, EventAvailability eventAvailability, EventStatus eventStatus, String str10, EventAccessLevel eventAccessLevel, Boolean bool2, Boolean bool3, Boolean bool4, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : list, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : recurrenceRuleRecord, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : str8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : str9, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : eventAvailability, (i & 8192) != 0 ? null : eventStatus, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str10, (i & 32768) != 0 ? null : eventAccessLevel, (i & 65536) != 0 ? null : bool2, (i & 131072) != 0 ? null : bool3, (i & 262144) != 0 ? null : bool4, (i & 524288) != 0 ? null : str11, (i & 1048576) != 0 ? null : str12);
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

    public final String getLocation() {
        return this.location;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final String getEndTimeZone() {
        return this.endTimeZone;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final List<AlarmRecord> getAlarms() {
        return this.alarms;
    }

    public final RecurrenceRuleRecord getRecurrenceRule() {
        return this.recurrenceRule;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final Boolean getAllDay() {
        return this.allDay;
    }

    public final EventAvailability getAvailability() {
        return this.availability;
    }

    public final EventStatus getStatus() {
        return this.status;
    }

    public final String getOrganizerEmail() {
        return this.organizerEmail;
    }

    public final EventAccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public final Boolean getGuestsCanModify() {
        return this.guestsCanModify;
    }

    public final Boolean getGuestsCanInviteOthers() {
        return this.guestsCanInviteOthers;
    }

    public final Boolean getGuestsCanSeeGuests() {
        return this.guestsCanSeeGuests;
    }

    public final String getOriginalId() {
        return this.originalId;
    }

    public final String getInstanceId() {
        return this.instanceId;
    }
}

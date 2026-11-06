package expo.modules.calendar.next;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.calendar.next.exceptions.EventNotFoundException;
import expo.modules.calendar.next.exceptions.EventsCouldNotBeCreatedException;
import expo.modules.calendar.next.extensions.CursorExtensionsKt;
import expo.modules.calendar.next.records.CalendarAccessLevel;
import expo.modules.calendar.next.records.CalendarRecord;
import expo.modules.calendar.next.records.EventRecord;
import expo.modules.calendar.next.records.Source;
import expo.modules.calendar.next.utils.CalendarNextUtilsKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions$AppContextLost;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\"\u001a\u00020#H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lexpo/modules/calendar/next/ExpoCalendar;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "context", "Lexpo/modules/kotlin/AppContext;", "calendarRecord", "Lexpo/modules/calendar/next/records/CalendarRecord;", "<init>", "(Lexpo/modules/kotlin/AppContext;Lexpo/modules/calendar/next/records/CalendarRecord;)V", "getCalendarRecord", "()Lexpo/modules/calendar/next/records/CalendarRecord;", "setCalendarRecord", "(Lexpo/modules/calendar/next/records/CalendarRecord;)V", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "getEvents", "", "Lexpo/modules/calendar/next/ExpoCalendarEvent;", b.P, "", b.d, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCalendar", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEvent", "record", "Lexpo/modules/calendar/next/records/EventRecord;", "(Lexpo/modules/calendar/next/records/EventRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpdatedRecord", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "nullableFields", "serializeExpoCalendarEvents", b.b, "Landroid/database/Cursor;", "Companion", "expo-calendar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoCalendar extends SharedObject {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CalendarRecord calendarRecord;

    /* JADX INFO: renamed from: expo.modules.calendar.next.ExpoCalendar$createEvent$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ExpoCalendar.this.createEvent(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.calendar.next.ExpoCalendar$getEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C10791 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10791(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return ExpoCalendar.this.getEvents(null, null, this);
        }
    }

    public final CalendarRecord getCalendarRecord() {
        return this.calendarRecord;
    }

    public final void setCalendarRecord(CalendarRecord calendarRecord) {
        this.calendarRecord = calendarRecord;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoCalendar(AppContext context, CalendarRecord calendarRecord) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.calendarRecord = calendarRecord;
    }

    public final Context getReactContext() throws Exceptions$ReactContextLost {
        Context reactContext;
        AppContext appContext = getAppContext();
        if (appContext == null || (reactContext = appContext.getReactContext()) == null) {
            throw new Exceptions$ReactContextLost();
        }
        return reactContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object getEvents(String str, String str2, Continuation continuation) throws EventNotFoundException {
        C10791 c10791;
        String id;
        if (continuation instanceof C10791) {
            c10791 = (C10791) continuation;
            int i = c10791.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10791.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10791 = new C10791(continuation);
            }
        } else {
            c10791 = new C10791(continuation);
        }
        Object objFindEvents = c10791.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10791.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objFindEvents);
                CalendarRecord calendarRecord = this.calendarRecord;
                if ((calendarRecord != null ? calendarRecord.getId() : null) == null) {
                    throw new EventNotFoundException("Calendar id is null", null, 2, null);
                }
                ContentResolver contentResolver = getReactContext().getContentResolver();
                Intrinsics.checkNotNull(contentResolver);
                CalendarRecord calendarRecord2 = this.calendarRecord;
                if (calendarRecord2 == null || (id = calendarRecord2.getId()) == null) {
                    id = "";
                }
                List listListOf = CollectionsKt.listOf(id);
                c10791.label = 1;
                objFindEvents = CalendarNextUtilsKt.findEvents(contentResolver, str, str2, listListOf, c10791);
                if (objFindEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objFindEvents);
            }
            Closeable closeable = (Closeable) objFindEvents;
            try {
                List listSerializeExpoCalendarEvents = serializeExpoCalendarEvents((Cursor) closeable);
                CloseableKt.closeFinally(closeable, null);
                return listSerializeExpoCalendarEvents;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            throw new EventNotFoundException("Events could not be found", e);
        }
    }

    /* JADX INFO: renamed from: expo.modules.calendar.next.ExpoCalendar$deleteCalendar$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ExpoCalendar.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws EventNotFoundException {
            String id;
            Long longOrNull;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CalendarRecord calendarRecord = ExpoCalendar.this.getCalendarRecord();
            if (calendarRecord == null || (id = calendarRecord.getId()) == null || (longOrNull = StringsKt.toLongOrNull(id)) == null) {
                throw new EventNotFoundException("Calendar id is null", null, 2, null);
            }
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, longOrNull.longValue());
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            int iDelete = ExpoCalendar.this.getReactContext().getContentResolver().delete(uriWithAppendedId, null, null);
            ExpoCalendar.this.setCalendarRecord(null);
            return Boxing.boxBoolean(iDelete > 0);
        }
    }

    public final Object deleteCalendar(Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object createEvent(EventRecord eventRecord, Continuation continuation) throws EventsCouldNotBeCreatedException {
        AnonymousClass1 anonymousClass1;
        ExpoCalendarEvent expoCalendarEvent;
        String id;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                anonymousClass1.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objSaveEvent$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass2.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objSaveEvent$default);
                AppContext appContext = getAppContext();
                if (appContext != null) {
                    expoCalendarEvent = new ExpoCalendarEvent(appContext, eventRecord, null, 4, null);
                    CalendarRecord calendarRecord = this.calendarRecord;
                    if (calendarRecord == null || (id = calendarRecord.getId()) == null) {
                        throw new EventsCouldNotBeCreatedException("Calendar id is null", null, 2, null);
                    }
                    anonymousClass2.L$0 = expoCalendarEvent;
                    anonymousClass2.label = 1;
                    objSaveEvent$default = ExpoCalendarEvent.saveEvent$default(expoCalendarEvent, eventRecord, id, null, anonymousClass2, 4, null);
                    if (objSaveEvent$default == coroutine_suspended) {
                    }
                }
                throw new Exceptions$AppContextLost();
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ExpoCalendarEvent expoCalendarEvent2 = (ExpoCalendarEvent) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objSaveEvent$default);
                return expoCalendarEvent2;
            }
            expoCalendarEvent = (ExpoCalendarEvent) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objSaveEvent$default);
            String strValueOf = String.valueOf((Long) objSaveEvent$default);
            anonymousClass2.L$0 = expoCalendarEvent;
            anonymousClass2.label = 2;
            return expoCalendarEvent.reloadEvent(strValueOf, anonymousClass2) == coroutine_suspended ? coroutine_suspended : expoCalendarEvent;
        } catch (Exception e) {
            throw new EventsCouldNotBeCreatedException("Event could not be created", e);
        }
    }

    public static /* synthetic */ CalendarRecord getUpdatedRecord$default(ExpoCalendar expoCalendar, CalendarRecord calendarRecord, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        return expoCalendar.getUpdatedRecord(calendarRecord, list);
    }

    public final CalendarRecord getUpdatedRecord(CalendarRecord other, List nullableFields) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(other, "other");
        if (nullableFields == null || (setEmptySet = CollectionsKt.toSet(nullableFields)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        CalendarRecord calendarRecord = this.calendarRecord;
        if (calendarRecord == null) {
            calendarRecord = new CalendarRecord(null, null, null, null, null, false, false, null, false, false, null, null, null, null, null, 32767, null);
        }
        CalendarRecord calendarRecord2 = calendarRecord;
        return new CalendarRecord((String) getUpdatedRecord$getNullableValue(setEmptySet, DiagnosticsEntry.ID_KEY, other.getId(), calendarRecord.getId()), (String) getUpdatedRecord$getNullableValue(setEmptySet, b.S, other.getTitle(), calendarRecord.getTitle()), (String) getUpdatedRecord$getNullableValue(setEmptySet, "name", other.getName(), calendarRecord.getName()), (Source) getUpdatedRecord$getNullableValue(setEmptySet, Constants.ScionAnalytics.PARAM_SOURCE, other.getSource(), calendarRecord.getSource()), (Integer) getUpdatedRecord$getNullableValue(setEmptySet, "color", other.getColor(), calendarRecord.getColor()), ((Boolean) getUpdatedRecord$getValue(setEmptySet, "isVisible", Boolean.valueOf(other.isVisible()), Boolean.valueOf(calendarRecord.isVisible()))).booleanValue(), ((Boolean) getUpdatedRecord$getValue(setEmptySet, "isSynced", Boolean.valueOf(other.isSynced()), Boolean.valueOf(calendarRecord.isSynced()))).booleanValue(), (String) getUpdatedRecord$getNullableValue(setEmptySet, "timeZone", other.getTimeZone(), calendarRecord.getTimeZone()), ((Boolean) getUpdatedRecord$getValue(setEmptySet, "isPrimary", Boolean.valueOf(other.isPrimary()), Boolean.valueOf(calendarRecord.isPrimary()))).booleanValue(), ((Boolean) getUpdatedRecord$getValue(setEmptySet, "allowsModifications", Boolean.valueOf(other.getAllowsModifications()), Boolean.valueOf(calendarRecord.getAllowsModifications()))).booleanValue(), (List) getUpdatedRecord$getValue(setEmptySet, "allowedAvailabilities", other.getAllowedAvailabilities(), calendarRecord.getAllowedAvailabilities()), (List) getUpdatedRecord$getValue(setEmptySet, "allowedReminders", other.getAllowedReminders(), calendarRecord.getAllowedReminders()), (List) getUpdatedRecord$getValue(setEmptySet, "allowedAttendeeTypes", other.getAllowedAttendeeTypes(), calendarRecord2.getAllowedAttendeeTypes()), (String) getUpdatedRecord$getNullableValue(setEmptySet, "ownerAccount", other.getOwnerAccount(), calendarRecord2.getOwnerAccount()), (CalendarAccessLevel) getUpdatedRecord$getNullableValue(setEmptySet, "accessLevel", other.getAccessLevel(), calendarRecord2.getAccessLevel()));
    }

    private static final Object getUpdatedRecord$getValue(Set set, String str, Object obj, Object obj2) {
        return (set.contains(str) || obj == null) ? obj2 : obj;
    }

    private static final Object getUpdatedRecord$getNullableValue(Set set, String str, Object obj, Object obj2) {
        if (set.contains(str)) {
            return null;
        }
        return obj == null ? obj2 : obj;
    }

    private final List serializeExpoCalendarEvents(Cursor cursor) throws Exceptions$AppContextLost {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = getReactContext().getContentResolver();
        while (cursor.moveToNext()) {
            AppContext appContext = getAppContext();
            if (appContext == null) {
                throw new Exceptions$AppContextLost();
            }
            Intrinsics.checkNotNull(contentResolver);
            arrayList.add(new ExpoCalendarEvent(appContext, CursorExtensionsKt.toEventRecord(cursor, contentResolver), null, 4, null));
        }
        return arrayList;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object updateCalendar(AppContext appContext, CalendarRecord calendarRecord, boolean z, Continuation continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new ExpoCalendar$Companion$updateCalendar$2(z, calendarRecord, appContext, null), continuation);
        }

        public final Object findExpoCalendars(AppContext appContext, String str, Continuation continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new ExpoCalendar$Companion$findExpoCalendars$2(str, appContext, null), continuation);
        }

        public final Object findExpoCalendarById(AppContext appContext, String str, Continuation continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new ExpoCalendar$Companion$findExpoCalendarById$2(str, appContext, null), continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object listEvents(AppContext appContext, List list, String str, String str2, Continuation continuation) throws EventNotFoundException {
            ExpoCalendar$Companion$listEvents$1 expoCalendar$Companion$listEvents$1;
            ContentResolver contentResolver;
            AppContext appContext2;
            List list2;
            if (continuation instanceof ExpoCalendar$Companion$listEvents$1) {
                expoCalendar$Companion$listEvents$1 = (ExpoCalendar$Companion$listEvents$1) continuation;
                int i = expoCalendar$Companion$listEvents$1.label;
                if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                    expoCalendar$Companion$listEvents$1.label = i - LinearLayoutManager.INVALID_OFFSET;
                } else {
                    expoCalendar$Companion$listEvents$1 = new ExpoCalendar$Companion$listEvents$1(this, continuation);
                }
            } else {
                expoCalendar$Companion$listEvents$1 = new ExpoCalendar$Companion$listEvents$1(this, continuation);
            }
            Object obj = expoCalendar$Companion$listEvents$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = expoCalendar$Companion$listEvents$1.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Context reactContext = appContext.getReactContext();
                    if (reactContext == null) {
                        throw new Exceptions$ReactContextLost();
                    }
                    ContentResolver contentResolver2 = reactContext.getContentResolver();
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNull(contentResolver2);
                    expoCalendar$Companion$listEvents$1.L$0 = appContext;
                    expoCalendar$Companion$listEvents$1.L$1 = contentResolver2;
                    expoCalendar$Companion$listEvents$1.L$2 = arrayList;
                    expoCalendar$Companion$listEvents$1.label = 1;
                    Object objFindEvents = CalendarNextUtilsKt.findEvents(contentResolver2, str, str2, list, expoCalendar$Companion$listEvents$1);
                    if (objFindEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objFindEvents;
                    contentResolver = contentResolver2;
                    appContext2 = appContext;
                    list2 = arrayList;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list2 = (List) expoCalendar$Companion$listEvents$1.L$2;
                    contentResolver = (ContentResolver) expoCalendar$Companion$listEvents$1.L$1;
                    AppContext appContext3 = (AppContext) expoCalendar$Companion$listEvents$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    appContext2 = appContext3;
                }
                Cursor cursor = (Cursor) obj;
                while (cursor.moveToNext()) {
                    try {
                        Intrinsics.checkNotNull(contentResolver);
                        list2.add(new ExpoCalendarEvent(appContext2, CursorExtensionsKt.toEventRecord(cursor, contentResolver), null, 4, null));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(cursor, th);
                            throw th2;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return list2;
            } catch (Exception e) {
                throw new EventNotFoundException("Events could not be found", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List serializeExpoCalendars(AppContext appContext, Cursor cursor) {
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(new ExpoCalendar(appContext, CursorExtensionsKt.toCalendarRecord(cursor)));
            }
            return arrayList;
        }
    }
}

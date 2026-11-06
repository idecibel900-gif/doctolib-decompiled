package expo.modules.calendar.domain.calendar;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b;
import expo.modules.calendar.domain.calendar.extensions.CursorExtensionsKt;
import expo.modules.calendar.domain.calendar.records.CalendarEntity;
import expo.modules.calendar.domain.calendar.records.input.CalendarUpdateInput;
import expo.modules.calendar.domain.calendar.records.input.NewCalendarInput;
import expo.modules.kotlin.exception.Exceptions$ReactContextLost;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarRepository {
    public static final Companion Companion = new Companion(null);
    private static final String[] findCalendarByIdQueryFields = {"_id", "calendar_displayName", "account_name", "isPrimary", "calendar_access_level", "allowedAvailability", "name", "account_type", "calendar_color", "ownerAccount", "calendar_timezone", "allowedReminders", "allowedAttendeeTypes", "visible", "sync_events"};
    private static final String[] findCalendarsQueryParameters = {"_id", "calendar_displayName", "account_name", "isPrimary", "calendar_access_level", "allowedAvailability", "name", "account_type", "calendar_color", "ownerAccount", "calendar_timezone", "allowedReminders", "allowedAttendeeTypes", "visible", "sync_events"};
    private final WeakReference contextRef;

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$createCalendar$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return CalendarRepository.this.createCalendar(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$deleteCalendar$1, reason: invalid class name and case insensitive filesystem */
    static final class C10691 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10691(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return CalendarRepository.this.deleteCalendar(null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$updateCalendar$1, reason: invalid class name and case insensitive filesystem */
    static final class C10711 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C10711(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return CalendarRepository.this.updateCalendar(null, this);
        }
    }

    public CalendarRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new WeakReference(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentResolver getContentResolver() throws Exceptions$ReactContextLost {
        ContentResolver contentResolver;
        Context context = (Context) this.contextRef.get();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            throw new Exceptions$ReactContextLost();
        }
        return contentResolver;
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$findCalendars$2, reason: invalid class name and case insensitive filesystem */
    static final class C10702 extends SuspendLambda implements Function2 {
        int label;

        C10702(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CalendarRepository.this.new C10702(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10702) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final Cursor cursorQuery = CalendarRepository.this.getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, CalendarRepository.Companion.getFindCalendarsQueryParameters(), null, null, null);
            if (cursorQuery == null) {
                throw new IllegalArgumentException("Cursor shouldn't be null");
            }
            try {
                List list = SequencesKt.toList(SequencesKt.generateSequence(new Function0() { // from class: expo.modules.calendar.domain.calendar.CalendarRepository$findCalendars$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CalendarRepository.C10702.invokeSuspend$lambda$2$lambda$1(cursorQuery);
                    }
                }));
                CloseableKt.closeFinally(cursorQuery, null);
                return list;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CalendarEntity invokeSuspend$lambda$2$lambda$1(Cursor cursor) {
            if (cursor.moveToNext()) {
                return CursorExtensionsKt.extractCalendar(cursor);
            }
            return null;
        }
    }

    public final Object findCalendars(Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C10702(null), continuation);
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$findCalendarById$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $calendarId;
        int label;
        final /* synthetic */ CalendarRepository this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, CalendarRepository calendarRepository, Continuation continuation) {
            super(2, continuation);
            this.$calendarId = str;
            this.this$0 = calendarRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$calendarId, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, Long.parseLong(this.$calendarId));
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            Cursor cursorQuery = this.this$0.getContentResolver().query(uriWithAppendedId, CalendarRepository.Companion.getFindCalendarByIdQueryFields(), null, null, null);
            if (cursorQuery == null) {
                throw new IllegalArgumentException("Cursor shouldn't be null");
            }
            try {
                Cursor cursor = cursorQuery.moveToFirst() ? cursorQuery : null;
                CalendarEntity calendarEntityExtractCalendar = cursor != null ? CursorExtensionsKt.extractCalendar(cursor) : null;
                CloseableKt.closeFinally(cursorQuery, null);
                return calendarEntityExtractCalendar;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

    public final Object findCalendarById(String str, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object createCalendar(NewCalendarInput newCalendarInput, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            Uri uriBuild = CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", b.af).appendQueryParameter("account_name", newCalendarInput.getSource().getName()).appendQueryParameter("account_type", newCalendarInput.getSource().getResolvedType()).build();
            CoroutineDispatcher io2 = Dispatchers.getIO();
            CalendarRepository$createCalendar$calendarUri$1 calendarRepository$createCalendar$calendarUri$1 = new CalendarRepository$createCalendar$calendarUri$1(this, uriBuild, newCalendarInput, null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, calendarRepository$createCalendar$calendarUri$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Uri uri = (Uri) objWithContext;
        String lastPathSegment = uri != null ? uri.getLastPathSegment() : null;
        if (lastPathSegment == null) {
            throw new IllegalArgumentException("Couldn't decode calendar ID from inserted content URI");
        }
        return Boxing.boxLong(Long.parseLong(lastPathSegment));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object updateCalendar(CalendarUpdateInput calendarUpdateInput, Continuation continuation) {
        C10711 c10711;
        long j;
        if (continuation instanceof C10711) {
            c10711 = (C10711) continuation;
            int i = c10711.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10711.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10711 = new C10711(continuation);
            }
        } else {
            c10711 = new C10711(continuation);
        }
        Object obj = c10711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10711.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            long j2 = Long.parseLong(calendarUpdateInput.getId());
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, j2);
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C10722 c10722 = new C10722(uriWithAppendedId, calendarUpdateInput, null);
            c10711.J$0 = j2;
            c10711.label = 1;
            if (BuildersKt.withContext(io2, c10722, c10711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = j2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c10711.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(j);
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.calendar.CalendarRepository$updateCalendar$2, reason: invalid class name and case insensitive filesystem */
    static final class C10722 extends SuspendLambda implements Function2 {
        final /* synthetic */ CalendarUpdateInput $updateInput;
        final /* synthetic */ Uri $updateUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10722(Uri uri, CalendarUpdateInput calendarUpdateInput, Continuation continuation) {
            super(2, continuation);
            this.$updateUri = uri;
            this.$updateInput = calendarUpdateInput;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CalendarRepository.this.new C10722(this.$updateUri, this.$updateInput, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxInt(CalendarRepository.this.getContentResolver().update(this.$updateUri, this.$updateInput.toContentValues(), null, null));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deleteCalendar(String str, Continuation continuation) {
        C10691 c10691;
        if (continuation instanceof C10691) {
            c10691 = (C10691) continuation;
            int i = c10691.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10691.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10691 = new C10691(continuation);
            }
        } else {
            c10691 = new C10691(continuation);
        }
        Object objWithContext = c10691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10691.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Calendars.CONTENT_URI, Long.parseLong(str));
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            CoroutineDispatcher io2 = Dispatchers.getIO();
            CalendarRepository$deleteCalendar$rows$1 calendarRepository$deleteCalendar$rows$1 = new CalendarRepository$deleteCalendar$rows$1(this, uriWithAppendedId, null);
            c10691.label = 1;
            objWithContext = BuildersKt.withContext(io2, calendarRepository$deleteCalendar$rows$1, c10691);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return Boxing.boxBoolean(((Number) objWithContext).intValue() > 0);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String[] getFindCalendarByIdQueryFields() {
            return CalendarRepository.findCalendarByIdQueryFields;
        }

        public final String[] getFindCalendarsQueryParameters() {
            return CalendarRepository.findCalendarsQueryParameters;
        }
    }
}

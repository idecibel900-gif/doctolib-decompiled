package expo.modules.calendar.next.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import expo.modules.calendar.domain.event.EventRepository;
import expo.modules.calendar.next.exceptions.EventDateTimeInvalidException;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CalendarNextUtilsKt {
    private static final SimpleDateFormat allDayRrFormat;
    private static final SimpleDateFormat rrFormat;
    private static final SimpleDateFormat sdf;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        sdf = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        rrFormat = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat3.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        allDayRrFormat = simpleDateFormat3;
    }

    public static final SimpleDateFormat getSdf() {
        return sdf;
    }

    public static final SimpleDateFormat getRrFormat() {
        return rrFormat;
    }

    public static final Date parseRrDate(String dateString) {
        Object objM5243constructorimpl;
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            Result.Companion companion = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(rrFormat.parse(dateString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m5246exceptionOrNullimpl(objM5243constructorimpl) != null) {
            objM5243constructorimpl = Result.m5243constructorimpl(allDayRrFormat.parse(dateString));
        }
        if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
            objM5243constructorimpl = null;
        }
        return (Date) objM5243constructorimpl;
    }

    /* JADX INFO: renamed from: expo.modules.calendar.next.utils.CalendarNextUtilsKt$findEvents$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $calendars;
        final /* synthetic */ ContentResolver $contentResolver;
        final /* synthetic */ Object $endDate;
        final /* synthetic */ Object $startDate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, Object obj2, List list, ContentResolver contentResolver, Continuation continuation) {
            super(2, continuation);
            this.$startDate = obj;
            this.$endDate = obj2;
            this.$calendars = list;
            this.$contentResolver = contentResolver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$startDate, this.$endDate, this.$calendars, this.$contentResolver, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws EventDateTimeInvalidException, ParseException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            Intrinsics.checkNotNull(calendar);
            CalendarNextUtilsKt.setDateInCalendar(calendar, this.$startDate);
            Intrinsics.checkNotNull(calendar2);
            CalendarNextUtilsKt.setDateInCalendar(calendar2, this.$endDate);
            Uri.Builder builderBuildUpon = CalendarContract.Instances.CONTENT_URI.buildUpon();
            ContentUris.appendId(builderBuildUpon, calendar.getTimeInMillis());
            ContentUris.appendId(builderBuildUpon, calendar2.getTimeInMillis());
            Uri uriBuild = builderBuildUpon.build();
            String str = "((begin >= " + calendar.getTimeInMillis() + ") AND (end <= " + calendar2.getTimeInMillis() + ") AND (visible = 1) ";
            if (!this.$calendars.isEmpty()) {
                str = str + ("AND (" + CollectionsKt.joinToString$default(this.$calendars, " OR ", null, null, 0, null, new Function1() { // from class: expo.modules.calendar.next.utils.CalendarNextUtilsKt$findEvents$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CalendarNextUtilsKt.AnonymousClass2.invokeSuspend$lambda$0((String) obj2);
                    }
                }, 30, null) + ")");
            }
            Cursor cursorQuery = this.$contentResolver.query(uriBuild, EventRepository.Companion.getFindEventsQueryParameters(), str + ")", null, "begin ASC");
            if (cursorQuery != null) {
                return cursorQuery;
            }
            throw new IllegalArgumentException("Cursor shouldn't be null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0(String str) {
            return "calendar_id = '" + str + "'";
        }
    }

    public static final Object findEvents(ContentResolver contentResolver, Object obj, Object obj2, List list, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(obj, obj2, list, contentResolver, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDateInCalendar(Calendar calendar, Object obj) throws EventDateTimeInvalidException, ParseException {
        if (obj instanceof String) {
            Date date = sdf.parse((String) obj);
            if (date != null) {
                calendar.setTime(date);
                return;
            }
            throw new EventDateTimeInvalidException("Error parsing date", null, 2, null);
        }
        if (obj instanceof Number) {
            calendar.setTimeInMillis(((Number) obj).longValue());
            return;
        }
        throw new EventDateTimeInvalidException("Date has unsupported type", null, 2, null);
    }
}

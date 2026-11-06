package expo.modules.calendar.domain.attendee;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.calendar.domain.attendee.extensions.CursorExtensionsKt;
import expo.modules.calendar.domain.attendee.records.Attendee;
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
public final class AttendeeRepository {
    public static final Companion Companion = new Companion(null);
    private static final String[] findAttendeesByEventIdQueryParameters = {"_id", "attendeeName", "attendeeEmail", "attendeeRelationship", "attendeeType", "attendeeStatus"};
    private final WeakReference contextRef;

    /* JADX INFO: renamed from: expo.modules.calendar.domain.attendee.AttendeeRepository$deleteAttendee$1, reason: invalid class name */
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
            return AttendeeRepository.this.deleteAttendee(null, this);
        }
    }

    public AttendeeRepository(Context context) {
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

    /* JADX INFO: renamed from: expo.modules.calendar.domain.attendee.AttendeeRepository$findAttendeesByEventId$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $eventId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation continuation) {
            super(2, continuation);
            this.$eventId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AttendeeRepository.this.new AnonymousClass2(this.$eventId, continuation);
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
            final Cursor cursorQuery = CalendarContract.Attendees.query(AttendeeRepository.this.getContentResolver(), Long.parseLong(this.$eventId), AttendeeRepository.Companion.getFindAttendeesByEventIdQueryParameters());
            try {
                List list = SequencesKt.toList(SequencesKt.generateSequence(new Function0() { // from class: expo.modules.calendar.domain.attendee.AttendeeRepository$findAttendeesByEventId$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AttendeeRepository.AnonymousClass2.invokeSuspend$lambda$1$lambda$0(cursorQuery);
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
        public static final Attendee invokeSuspend$lambda$1$lambda$0(Cursor cursor) {
            if (!cursor.moveToNext()) {
                return null;
            }
            Intrinsics.checkNotNull(cursor);
            return CursorExtensionsKt.extractAttendee(cursor);
        }
    }

    public final Object findAttendeesByEventId(String str, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, null), continuation);
    }

    public final Object saveAttendeeForEvent(Attendee attendee, String str, Continuation continuation) {
        return attendee.isNewAttendeePayload() ? AttendeeRepositoryKt.insertAttendee(getContentResolver(), attendee, str, continuation) : AttendeeRepositoryKt.updateAttendee(getContentResolver(), attendee, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object deleteAttendee(String str, Continuation continuation) {
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
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Attendees.CONTENT_URI, Long.parseLong(str));
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AttendeeRepository$deleteAttendee$rows$1 attendeeRepository$deleteAttendee$rows$1 = new AttendeeRepository$deleteAttendee$rows$1(this, uriWithAppendedId, null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, attendeeRepository$deleteAttendee$rows$1, anonymousClass1);
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

        public final String[] getFindAttendeesByEventIdQueryParameters() {
            return AttendeeRepository.findAttendeesByEventIdQueryParameters;
        }
    }
}

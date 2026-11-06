package expo.modules.calendar.domain.attendee;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.recyclerview.widget.LinearLayoutManager;
import expo.modules.calendar.domain.attendee.records.Attendee;
import expo.modules.calendar.exceptions.FieldMissingException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AttendeeRepositoryKt {

    /* JADX INFO: renamed from: expo.modules.calendar.domain.attendee.AttendeeRepositoryKt$insertAttendee$1, reason: invalid class name */
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
            return AttendeeRepositoryKt.insertAttendee(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.attendee.AttendeeRepositoryKt$updateAttendee$1, reason: invalid class name and case insensitive filesystem */
    static final class C10681 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C10681(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= LinearLayoutManager.INVALID_OFFSET;
            return AttendeeRepositoryKt.updateAttendee(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object insertAttendee(ContentResolver contentResolver, Attendee attendee, String str, Continuation continuation) throws FieldMissingException {
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
            ContentValues contentValues = attendee.toContentValues();
            contentValues.put("event_id", str != null ? Boxing.boxLong(Long.parseLong(str)) : null);
            Uri uri = CalendarContract.Attendees.CONTENT_URI;
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AttendeeRepositoryKt$insertAttendee$attendeeUri$1 attendeeRepositoryKt$insertAttendee$attendeeUri$1 = new AttendeeRepositoryKt$insertAttendee$attendeeUri$1(contentResolver, uri, contentValues, null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, attendeeRepositoryKt$insertAttendee$attendeeUri$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Uri uri2 = (Uri) objWithContext;
        String lastPathSegment = uri2 != null ? uri2.getLastPathSegment() : null;
        if (lastPathSegment == null) {
            throw new IllegalArgumentException("Couldn't decode attendee ID from inserted content URI");
        }
        return Boxing.boxLong(Long.parseLong(lastPathSegment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object updateAttendee(ContentResolver contentResolver, Attendee attendee, Continuation continuation) {
        C10681 c10681;
        long j;
        if (continuation instanceof C10681) {
            c10681 = (C10681) continuation;
            int i = c10681.label;
            if ((i & LinearLayoutManager.INVALID_OFFSET) != 0) {
                c10681.label = i - LinearLayoutManager.INVALID_OFFSET;
            } else {
                c10681 = new C10681(continuation);
            }
        } else {
            c10681 = new C10681(continuation);
        }
        Object obj = c10681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10681.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String id = attendee.getId();
            Long lBoxLong = id != null ? Boxing.boxLong(Long.parseLong(id)) : null;
            if (lBoxLong == null) {
                throw new IllegalArgumentException("Attendee ID must be present when updating");
            }
            long jLongValue = lBoxLong.longValue();
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Attendees.CONTENT_URI, jLongValue);
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(contentResolver, uriWithAppendedId, attendee, null);
            c10681.J$0 = jLongValue;
            c10681.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass2, c10681) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jLongValue;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c10681.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxLong(j);
    }

    /* JADX INFO: renamed from: expo.modules.calendar.domain.attendee.AttendeeRepositoryKt$updateAttendee$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Attendee $attendee;
        final /* synthetic */ ContentResolver $this_updateAttendee;
        final /* synthetic */ Uri $updateUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ContentResolver contentResolver, Uri uri, Attendee attendee, Continuation continuation) {
            super(2, continuation);
            this.$this_updateAttendee = contentResolver;
            this.$updateUri = uri;
            this.$attendee = attendee;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$this_updateAttendee, this.$updateUri, this.$attendee, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(this.$this_updateAttendee.update(this.$updateUri, this.$attendee.toContentValues(), null, null));
        }
    }
}

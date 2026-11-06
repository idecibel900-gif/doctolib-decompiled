package expo.modules.calendar.domain.attendee;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class AttendeeRepositoryKt$insertAttendee$attendeeUri$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Uri $attendeesUri;
    final /* synthetic */ ContentValues $contentValues;
    final /* synthetic */ ContentResolver $this_insertAttendee;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AttendeeRepositoryKt$insertAttendee$attendeeUri$1(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Continuation continuation) {
        super(2, continuation);
        this.$this_insertAttendee = contentResolver;
        this.$attendeesUri = uri;
        this.$contentValues = contentValues;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AttendeeRepositoryKt$insertAttendee$attendeeUri$1(this.$this_insertAttendee, this.$attendeesUri, this.$contentValues, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AttendeeRepositoryKt$insertAttendee$attendeeUri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$this_insertAttendee.insert(this.$attendeesUri, this.$contentValues);
    }
}

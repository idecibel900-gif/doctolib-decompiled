package expo.modules.image;

import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
final class ExpoImageModule$definition$1$generatePlaceholder$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function1 $encoder;
    final /* synthetic */ Image $image;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExpoImageModule$definition$1$generatePlaceholder$2(Function1 function1, Image image, Continuation continuation) {
        super(2, continuation);
        this.$encoder = function1;
        this.$image = image;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ExpoImageModule$definition$1$generatePlaceholder$2(this.$encoder, this.$image, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ExpoImageModule$definition$1$generatePlaceholder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$encoder.invoke(DrawableKt.toBitmap$default((Drawable) this.$image.getRef(), 0, 0, null, 7, null));
    }
}

package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.Offering;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$2$map$1", f = "OfferingsMapper.kt", l = {}, m = "invokeSuspend")
final class OfferingsMapperKt$mapAsync$2$map$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Offering $this_mapAsync;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfferingsMapperKt$mapAsync$2$map$1(Offering offering, Continuation continuation) {
        super(2, continuation);
        this.$this_mapAsync = offering;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OfferingsMapperKt$mapAsync$2$map$1(this.$this_mapAsync, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OfferingsMapperKt$mapAsync$2$map$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return OfferingsMapperKt.map(this.$this_mapAsync);
    }
}

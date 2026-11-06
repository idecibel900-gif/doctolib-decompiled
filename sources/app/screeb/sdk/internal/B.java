package app.screeb.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B extends FunctionReferenceImpl implements Function1 {
    public B(K0 k0) {
        super(1, k0, K0.class, "postFrame", "postFrame(Lapp/screeb/sdk/Mirror/EncodedFrameMessage;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C0316o p0 = (C0316o) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((K0) this.receiver).a(p0);
        return Unit.INSTANCE;
    }
}

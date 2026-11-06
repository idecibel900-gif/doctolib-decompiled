package app.screeb.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r extends FunctionReferenceImpl implements Function1 {
    public r(C0319s c0319s) {
        super(1, c0319s, C0319s.class, "recycleMessage", "recycleMessage([B)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        byte[] p0 = (byte[]) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        C0319s.a((C0319s) this.receiver, p0);
        return Unit.INSTANCE;
    }
}

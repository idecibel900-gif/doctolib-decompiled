package app.screeb.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C extends FunctionReferenceImpl implements Function1 {
    public C(J j) {
        super(1, j, J.class, "onFrame", "onFrame(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((J) this.receiver).a(((Number) obj).longValue());
        return Unit.INSTANCE;
    }
}

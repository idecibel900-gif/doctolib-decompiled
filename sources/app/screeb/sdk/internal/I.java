package app.screeb.sdk.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class I extends FunctionReferenceImpl implements Function3 {
    public I(J j) {
        super(3, j, J.class, "emitPointer", "emitPointer(III)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        int iIntValue3 = ((Number) obj3).intValue();
        J j = (J) this.receiver;
        if (j.d) {
            synchronized (j.F0) {
                O o = j.F0;
                o.a(1);
                o.a.put((byte) 6);
                O o2 = j.F0;
                o2.a(1);
                o2.a.put((byte) iIntValue);
                j.F0.a(iIntValue2);
                j.F0.a(iIntValue3);
                Unit unit = Unit.INSTANCE;
            }
            j.i.c();
        }
        return Unit.INSTANCE;
    }
}

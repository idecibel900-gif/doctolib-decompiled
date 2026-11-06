package app.screeb.sdk.internal;

import app.screeb.sdk.Screeb;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class X extends FunctionReferenceImpl implements Function0 {
    public X(Screeb screeb) {
        super(0, screeb, Screeb.class, "onRecover", "onRecover()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Throwable {
        ((Screeb) this.receiver).onRecover();
        return Unit.INSTANCE;
    }
}

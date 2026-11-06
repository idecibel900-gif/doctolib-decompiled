package j$.time.temporal;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements n {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ o(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    @Override // j$.time.temporal.n
    public final m c(m mVar) {
        switch (this.a) {
            case 0:
                int iE = mVar.e(a.DAY_OF_WEEK);
                int i = this.b;
                if (iE == i) {
                    return mVar;
                }
                int i2 = iE - i;
                return mVar.l(i2 >= 0 ? 7 - i2 : -i2, b.DAYS);
            default:
                int iE2 = mVar.e(a.DAY_OF_WEEK);
                int i3 = this.b;
                if (iE2 == i3) {
                    return mVar;
                }
                int i4 = i3 - iE2;
                return mVar.a(i4 >= 0 ? 7 - i4 : -i4, b.DAYS);
        }
    }
}

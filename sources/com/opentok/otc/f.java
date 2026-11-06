package com.opentok.otc;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;
    private static f[] h;
    private static int i;
    private final int a;
    private final String b;

    static {
        f fVar = new f("OTC_DEGRADATION_PREFERENCE_NOT_SET", opentokJNI.OTC_DEGRADATION_PREFERENCE_NOT_SET_get());
        c = fVar;
        f fVar2 = new f("OTC_DEGRADATION_PREFERENCE_MAINTAIN_FRAMERATE_AND_RESOLUTION", opentokJNI.OTC_DEGRADATION_PREFERENCE_MAINTAIN_FRAMERATE_AND_RESOLUTION_get());
        d = fVar2;
        f fVar3 = new f("OTC_DEGRADATION_PREFERENCE_MAINTAIN_FRAMERATE", opentokJNI.OTC_DEGRADATION_PREFERENCE_MAINTAIN_FRAMERATE_get());
        e = fVar3;
        f fVar4 = new f("OTC_DEGRADATION_PREFERENCE_MAINTAIN_RESOLUTION", opentokJNI.OTC_DEGRADATION_PREFERENCE_MAINTAIN_RESOLUTION_get());
        f = fVar4;
        f fVar5 = new f("OTC_DEGRADATION_PREFERENCE_BALANCED", opentokJNI.OTC_DEGRADATION_PREFERENCE_BALANCED_get());
        g = fVar5;
        h = new f[]{fVar, fVar2, fVar3, fVar4, fVar5};
        i = 0;
    }

    private f(String str, int i2) {
        this.b = str;
        this.a = i2;
        i = i2 + 1;
    }

    public final int a() {
        return this.a;
    }

    public String toString() {
        return this.b;
    }

    public static f a(int i2) {
        f[] fVarArr = h;
        if (i2 < fVarArr.length && i2 >= 0) {
            f fVar = fVarArr[i2];
            if (fVar.a == i2) {
                return fVar;
            }
        }
        int i3 = 0;
        while (true) {
            f[] fVarArr2 = h;
            if (i3 >= fVarArr2.length) {
                throw new IllegalArgumentException("No enum " + f.class + " with value " + i2);
            }
            f fVar2 = fVarArr2[i3];
            if (fVar2.a == i2) {
                return fVar2;
            }
            i3++;
        }
    }
}

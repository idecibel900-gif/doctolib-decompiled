package com.reactnativekeyboardcontroller.interactive.interpolators;

/* JADX INFO: loaded from: classes4.dex */
public final class IosInterpolator implements Interpolator {
    @Override // com.reactnativekeyboardcontroller.interactive.interpolators.Interpolator
    public int interpolate(int i, int i2, int i3, int i4) {
        if (i2 <= i3 + i4 || i <= 0) {
            return i;
        }
        return 0;
    }
}

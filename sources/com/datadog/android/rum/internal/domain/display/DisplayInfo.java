package com.datadog.android.rum.internal.domain.display;

import com.datadog.android.rum.internal.domain.InfoData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DisplayInfo implements InfoData {
    private final Number screenBrightness;

    public final DisplayInfo copy(Number number) {
        return new DisplayInfo(number);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisplayInfo) && Intrinsics.areEqual(this.screenBrightness, ((DisplayInfo) obj).screenBrightness);
    }

    public int hashCode() {
        Number number = this.screenBrightness;
        if (number == null) {
            return 0;
        }
        return number.hashCode();
    }

    public String toString() {
        return "DisplayInfo(screenBrightness=" + this.screenBrightness + ")";
    }

    public DisplayInfo(Number number) {
        this.screenBrightness = number;
    }

    public /* synthetic */ DisplayInfo(Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : number);
    }

    public final Number getScreenBrightness() {
        return this.screenBrightness;
    }
}

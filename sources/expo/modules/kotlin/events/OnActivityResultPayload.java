package expo.modules.kotlin.events;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class OnActivityResultPayload {
    private final Intent data;
    private final int requestCode;
    private final int resultCode;

    public final int component1() {
        return this.requestCode;
    }

    public final int component2() {
        return this.resultCode;
    }

    public final Intent component3() {
        return this.data;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnActivityResultPayload)) {
            return false;
        }
        OnActivityResultPayload onActivityResultPayload = (OnActivityResultPayload) obj;
        return this.requestCode == onActivityResultPayload.requestCode && this.resultCode == onActivityResultPayload.resultCode && Intrinsics.areEqual(this.data, onActivityResultPayload.data);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.requestCode) * 31) + Integer.hashCode(this.resultCode)) * 31;
        Intent intent = this.data;
        return iHashCode + (intent == null ? 0 : intent.hashCode());
    }

    public String toString() {
        return "OnActivityResultPayload(requestCode=" + this.requestCode + ", resultCode=" + this.resultCode + ", data=" + this.data + ")";
    }

    public OnActivityResultPayload(int i, int i2, Intent intent) {
        this.requestCode = i;
        this.resultCode = i2;
        this.data = intent;
    }
}

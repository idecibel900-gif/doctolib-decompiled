package com.datadog.android.rum.tracking;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class AcceptAllActivities implements ComponentPredicate {
    @Override // com.datadog.android.rum.tracking.ComponentPredicate
    public boolean accept(Activity component) {
        Intrinsics.checkNotNullParameter(component, "component");
        return true;
    }

    @Override // com.datadog.android.rum.tracking.ComponentPredicate
    public String getViewName(Activity component) {
        Intrinsics.checkNotNullParameter(component, "component");
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null);
    }

    public int hashCode() {
        return getClass().hashCode();
    }
}

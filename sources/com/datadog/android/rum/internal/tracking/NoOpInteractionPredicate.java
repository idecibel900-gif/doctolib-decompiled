package com.datadog.android.rum.internal.tracking;

import com.datadog.android.rum.tracking.InteractionPredicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class NoOpInteractionPredicate implements InteractionPredicate {
    @Override // com.datadog.android.rum.tracking.InteractionPredicate
    public String getTargetName(Object target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj instanceof NoOpInteractionPredicate;
    }
}

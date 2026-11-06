package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class InAppMessageParams {
    private final ArrayList zza;

    public static final class Builder {
        private final Set zza = new HashSet();

        public Builder addInAppMessageCategoryToShow(int i) {
            this.zza.add(Integer.valueOf(i));
            return this;
        }

        public InAppMessageParams build() {
            return new InAppMessageParams(this.zza, null);
        }
    }

    /* synthetic */ InAppMessageParams(Set set, zzdq zzdqVar) {
        this.zza = new ArrayList(Collections.unmodifiableList(new ArrayList(set)));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    final ArrayList zza() {
        return this.zza;
    }
}

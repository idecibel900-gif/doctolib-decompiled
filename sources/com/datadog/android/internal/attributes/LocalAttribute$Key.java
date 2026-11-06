package com.datadog.android.internal.attributes;

/* JADX INFO: loaded from: classes3.dex */
public enum LocalAttribute$Key {
    CREATION_SAMPLING_RATE("_dd.local.head_sampling_rate_key"),
    REPORTING_SAMPLING_RATE("_dd.local.tail_sampling_rate_key"),
    VIEW_SCOPE_INSTRUMENTATION_TYPE("_dd.local.view_instrumentation_type_key");

    private final String string;

    LocalAttribute$Key(String str) {
        this.string = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}

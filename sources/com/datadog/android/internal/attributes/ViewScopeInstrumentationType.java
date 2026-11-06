package com.datadog.android.internal.attributes;

/* JADX INFO: loaded from: classes3.dex */
public enum ViewScopeInstrumentationType implements LocalAttribute$Constant {
    MANUAL,
    COMPOSE,
    ACTIVITY,
    FRAGMENT;

    private final LocalAttribute$Key key = LocalAttribute$Key.VIEW_SCOPE_INSTRUMENTATION_TYPE;

    ViewScopeInstrumentationType() {
    }

    @Override // com.datadog.android.internal.attributes.LocalAttribute$Constant
    public LocalAttribute$Key getKey() {
        return this.key;
    }
}

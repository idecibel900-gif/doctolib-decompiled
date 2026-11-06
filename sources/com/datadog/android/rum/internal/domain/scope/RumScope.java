package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.api.storage.DataWriter;
import com.datadog.android.rum.internal.domain.RumContext;

/* JADX INFO: loaded from: classes3.dex */
public interface RumScope {
    RumContext getRumContext();

    RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter dataWriter);

    boolean isActive();
}

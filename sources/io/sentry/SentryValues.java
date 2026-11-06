package io.sentry;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class SentryValues {
    private final List values;

    SentryValues(List list) {
        this.values = new ArrayList(list == null ? new ArrayList(0) : list);
    }

    public List getValues() {
        return this.values;
    }
}

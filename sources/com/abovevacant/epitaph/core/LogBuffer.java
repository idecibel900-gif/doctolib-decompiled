package com.abovevacant.epitaph.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class LogBuffer {
    public final List logs;
    public final String name;

    public LogBuffer(String str, List list) {
        this.name = str;
        this.logs = Collections.unmodifiableList(list);
    }
}

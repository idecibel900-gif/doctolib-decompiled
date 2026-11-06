package com.datadog.android.rum.tracking;

/* JADX INFO: loaded from: classes3.dex */
public interface ComponentPredicate {
    boolean accept(Object obj);

    String getViewName(Object obj);
}

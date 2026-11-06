package com.datadog.android.log.internal.utils;

import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LogUtilsKt {
    public static final SimpleDateFormat buildLogDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }
}

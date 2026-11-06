package com.google.android.gms.common.util;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}

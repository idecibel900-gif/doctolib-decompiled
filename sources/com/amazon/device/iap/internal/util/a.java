package com.amazon.device.iap.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.a.a.o.f;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String a = a.class.getName() + "_PREFS";

    public static String a(String str) {
        f.a((Object) str, "userId");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        return contextB.getSharedPreferences(a, 0).getString(str, null);
    }

    public static void a(String str, String str2) {
        f.a((Object) str, "userId");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        f.a(contextB, "context");
        SharedPreferences.Editor editorEdit = contextB.getSharedPreferences(a, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}

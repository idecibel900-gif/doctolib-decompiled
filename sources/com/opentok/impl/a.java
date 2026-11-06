package com.opentok.impl;

import com.opentok.android.OpentokError;
import com.opentok.otc.d;

/* JADX INFO: loaded from: classes4.dex */
public class a extends OpentokError {
    public a(OpentokError.Domain domain, int i) {
        super(domain, i, a(i));
    }

    public static String a(int i) {
        String strA = d.a(i);
        return strA != null ? strA : "Unknown error";
    }
}

package com.amazon.device.iap.internal.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class c {
    private static final String a = "KEY_TIMESTAMP";
    private static final String b = "KEY_REQUEST_ID";
    private static final String c = "KEY_USER_ID";
    private static final String d = "KEY_RECEIPT_STRING";
    private final String e;
    private final String f;
    private final long g;
    private final String h;

    public String a() {
        return this.e;
    }

    public String b() {
        return this.h;
    }

    public String c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    public c(String str, String str2, String str3, long j) {
        this.e = str;
        this.f = str2;
        this.h = str3;
        this.g = j;
    }

    public static c a(String str) throws b {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.getString(c), jSONObject.getString(d), jSONObject.getString(b), jSONObject.getLong(a));
        } catch (Throwable th) {
            throw new b("Input invalid for PendingReceipt Object:" + str, th);
        }
    }

    public String e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(c, this.e);
        jSONObject.put(d, this.f);
        jSONObject.put(b, this.h);
        jSONObject.put(a, this.g);
        return jSONObject.toString();
    }
}

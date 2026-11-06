package com.adjust.sdk.sig;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.openid.appauth.AuthorizationManagementUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 {
    public final Context a;
    public final d1 b;
    public final NativeLibHelper c;
    public final Map d;
    public final Map e;
    public final Map f;
    public final x1 g;

    public u2(Context context, t1 t1Var, NativeLibHelper nativeLibHelper, Map map, Map map2, Map map3) {
        this.a = context;
        this.b = t1Var;
        this.c = nativeLibHelper;
        this.d = map;
        this.e = map2;
        this.f = map3;
        if (map.isEmpty()) {
            throw new IllegalArgumentException("sign: Empty input parameters");
        }
        this.g = new x1(map);
    }

    public final void a() throws Exception {
        byte[] bArrA;
        this.g.a("Signature execution begin: ");
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.d);
        f fVar = new f(new String[]{"activity_kind", "client_sdk"});
        while (fVar.hasNext()) {
            String str = (String) fVar.next();
            Object obj = this.e.get(str);
            if (obj == null) {
                throw new IllegalArgumentException(("sign: " + str + " is null").toString());
            }
            linkedHashMap.put(str, obj);
        }
        if (!"b".equals(this.e.get("a"))) {
            linkedHashMap.put("adj_verification", o3.a(new a0()));
            this.g.a("Signing all the parameters begin: ");
            Context context = this.a;
            d1 d1Var = this.b;
            int i = 2;
            while (true) {
                if (i <= 0) {
                    bArrA = null;
                    break;
                }
                try {
                    t1 t1Var = (t1) d1Var;
                    t1Var.b(context);
                    bArrA = t1Var.a(context, d3.a(linkedHashMap.toString()));
                    break;
                } catch (s1 unused) {
                    throw new b2("sign: API is less than JellyBean-4-18");
                } catch (Exception e) {
                    if (!(e instanceof UnrecoverableKeyException) && !(e instanceof InvalidKeyException)) {
                        e.getMessage();
                        throw e;
                    }
                    e.getMessage();
                    i--;
                    ((t1) d1Var).a(context);
                }
            }
            if (i == 0) {
                throw new b2("sign: Reached maximum retries");
            }
            this.g.a("Calling native begin: ");
            byte[] bArrA2 = this.c.a(this.a, linkedHashMap, bArrA, Build.VERSION.SDK_INT);
            this.g.a("Calling native end: ");
            if (bArrA2 == null) {
                throw new IllegalArgumentException("sign: Returned a null signature. Exiting...");
            }
            this.g.a("Signing all the parameters end: ");
            this.f.put(AuthorizationManagementUtil.REQUEST_TYPE_AUTHORIZATION, a(linkedHashMap, bArrA2));
        }
        this.f.putAll(this.d);
        f fVar2 = new f(new String[]{"network_payload", "endpoint"});
        while (fVar2.hasNext()) {
            String str2 = (String) fVar2.next();
            String str3 = (String) this.e.get(str2);
            if (str3 != null) {
                this.f.put(str2, str3);
            }
        }
        this.g.a("Signature execution end: ");
    }

    public static String a(LinkedHashMap linkedHashMap, byte[] bArr) {
        String strEncodeToString = Base64.encodeToString(bArr, 2);
        Object obj = linkedHashMap.get("adj_signing_id");
        if (obj != null) {
            String str = (String) obj;
            Object obj2 = linkedHashMap.get("headers_id");
            if (obj2 != null) {
                String str2 = (String) obj2;
                Object obj3 = linkedHashMap.get("algorithm");
                if (obj3 != null) {
                    String str3 = (String) obj3;
                    Object obj4 = linkedHashMap.get("native_version");
                    if (obj4 != null) {
                        String str4 = (String) obj4;
                        Object obj5 = linkedHashMap.get("adj_verification");
                        if (obj5 != null) {
                            Locale locale = Locale.US;
                            return String.format(locale, "Signature %s,%s,%s,%s,%s,%s", Arrays.copyOf(new Object[]{String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"signature", strEncodeToString}, 2)), String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"adj_signing_id", str}, 2)), String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"algorithm", str3}, 2)), String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"headers_id", str2}, 2)), String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"native_version", str4}, 2)), String.format(locale, "%s=\"%s\"", Arrays.copyOf(new Object[]{"adj_verification", (String) obj5}, 2))}, 6));
                        }
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}

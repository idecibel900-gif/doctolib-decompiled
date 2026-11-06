package com.amazon.device.simplesignin.a.d;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.Token;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String a = "b";

    private b() {
    }

    public static List<Link> a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                a.a(a, "No links available, links object received is empty.");
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                    Link link = new Link();
                    link.setAmazonUserId(str);
                    link.setIdentityProviderName(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.z));
                    link.setLinkId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.y));
                    link.setPartnerUserId(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.A));
                    link.setLinkedTimestamp(jSONObject.getLong(com.amazon.device.simplesignin.a.a.a.B));
                    Token token = new Token();
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString(com.amazon.device.simplesignin.a.a.a.C));
                    token.setToken(jSONObject2.getString("token"));
                    token.setSchema(jSONObject2.getString(com.amazon.device.simplesignin.a.a.a.E));
                    link.setSsiToken(token);
                    arrayList.add(link);
                } catch (JSONException e) {
                    a.b(a, "Failure generating Link object from response." + e);
                    return null;
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            a.b(a, "Failure generating Link object from Kiwi response." + e2);
            return null;
        }
    }

    public static String a(String str) {
        try {
            return new JSONObject(str).getString(com.amazon.device.simplesignin.a.a.a.y);
        } catch (JSONException e) {
            a.b(a, "Failure extracting Link ID object from response." + e);
            return null;
        }
    }
}

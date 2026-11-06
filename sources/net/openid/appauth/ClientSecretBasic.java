package net.openid.appauth;

import android.util.Base64;
import com.revenuecat.purchases.common.Constants;
import java.util.Collections;
import java.util.Map;
import net.openid.appauth.internal.UriUtil;

/* JADX INFO: loaded from: classes5.dex */
public class ClientSecretBasic implements ClientAuthentication {
    public static final String NAME = "client_secret_basic";
    private String mClientSecret;

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestParameters(String str) {
        return null;
    }

    public ClientSecretBasic(String str) {
        this.mClientSecret = (String) Preconditions.checkNotNull(str, "mClientSecret cannot be null");
    }

    @Override // net.openid.appauth.ClientAuthentication
    public final Map<String, String> getRequestHeaders(String str) {
        return Collections.singletonMap("Authorization", "Basic " + Base64.encodeToString((UriUtil.formUrlEncodeValue(str) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + UriUtil.formUrlEncodeValue(this.mClientSecret)).getBytes(), 2));
    }
}

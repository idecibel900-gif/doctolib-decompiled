package net.openid.appauth.connectivity;

import android.net.Uri;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnectionBuilder {
    HttpURLConnection openConnection(Uri uri) throws IOException;
}

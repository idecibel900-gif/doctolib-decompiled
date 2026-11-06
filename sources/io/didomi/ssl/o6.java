package io.didomi.ssl;

import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0016J*\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018¨\u0006\u001c"}, d2 = {"Lio/didomi/sdk/o6;", "", "", "method", "urlString", "", "bytes", "Lio/didomi/sdk/q6;", "listener", "", "timeout", "", "ifModifiedSince", "", "a", "Ljava/net/URLConnection;", "connection", "response", "b", "Lio/didomi/sdk/p6;", "Ljava/net/HttpURLConnection;", "Ljava/io/BufferedReader;", "content", "Lio/didomi/sdk/gh;", "Lio/didomi/sdk/gh;", "userAgentRepository", "<init>", "(Lio/didomi/sdk/gh;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public class o6 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final gh userAgentRepository;

    public o6(gh userAgentRepository) {
        Intrinsics.checkNotNullParameter(userAgentRepository, "userAgentRepository");
        this.userAgentRepository = userAgentRepository;
    }

    public static /* synthetic */ void a(o6 o6Var, String str, q6 q6Var, int i, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doGetCall");
        }
        if ((i2 & 4) != 0) {
            i = Constants.CONNECTION_TIMEOUT_VERIFY;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = 0;
        }
        o6Var.a(str, q6Var, i3, j);
    }

    private final void b(q6 listener, String response) {
        if (listener instanceof r6) {
            ((r6) listener).a(response);
        } else if (listener instanceof p6) {
            b((p6) listener, response);
        }
    }

    public void a(String urlString, q6 listener, int timeout, long ifModifiedSince) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(listener, "listener");
        a("GET", urlString, null, listener, timeout, ifModifiedSince);
    }

    public static /* synthetic */ void a(o6 o6Var, String str, String str2, q6 q6Var, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doPostCall");
        }
        if ((i2 & 8) != 0) {
            i = Constants.CONNECTION_TIMEOUT_VERIFY;
        }
        o6Var.a(str, str2, q6Var, i);
    }

    private final void b(p6 listener, String response) {
        try {
            if (StringsKt.isBlank(response)) {
                listener.b(new JSONObject());
            } else {
                listener.b(new JSONObject(response));
            }
        } catch (Exception e) {
            Log.e("Cannot parse JSON response", e);
            listener.b(new JSONObject());
        }
    }

    public void a(String urlString, String content, q6 listener, int timeout) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(listener, "listener");
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a(this, "POST", urlString, bytes, listener, timeout, 0L, 32, null);
    }

    static /* synthetic */ void a(o6 o6Var, String str, String str2, byte[] bArr, q6 q6Var, int i, long j, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doCall");
        }
        if ((i2 & 16) != 0) {
            i = Constants.CONNECTION_TIMEOUT_VERIFY;
        }
        o6Var.a(str, str2, bArr, q6Var, i, (i2 & 32) != 0 ? 0L : j);
    }

    private final void a(String method, String urlString, byte[] bytes, q6 listener, int timeout, long ifModifiedSince) {
        try {
            URLConnection uRLConnectionOpenConnection = new URL(urlString).openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                Log.e$default("Invalid connection type : " + uRLConnectionOpenConnection, null, 2, null);
                a(listener, (String) null);
                return;
            }
            ((HttpURLConnection) uRLConnectionOpenConnection).setConnectTimeout(timeout);
            ((HttpURLConnection) uRLConnectionOpenConnection).setReadTimeout(timeout);
            ((HttpURLConnection) uRLConnectionOpenConnection).setRequestMethod(method);
            uRLConnectionOpenConnection.setRequestProperty("User-agent", this.userAgentRepository.a());
            uRLConnectionOpenConnection.setRequestProperty("Content-Type", "application/json");
            if (ifModifiedSince > 0) {
                uRLConnectionOpenConnection.setRequestProperty("If-Modified-Since", t1.a.a(ifModifiedSince));
            }
            if (Intrinsics.areEqual(method, "POST") && bytes != null) {
                a(uRLConnectionOpenConnection, bytes);
            }
            BufferedReader bufferedReaderA = a((HttpURLConnection) uRLConnectionOpenConnection);
            if (bufferedReaderA == null) {
                a(listener, (String) null);
                return;
            }
            try {
                String text = TextStreamsKt.readText(bufferedReaderA);
                CloseableKt.closeFinally(bufferedReaderA, null);
                if (((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode() < 400 && ((HttpURLConnection) uRLConnectionOpenConnection).getResponseCode() >= 200) {
                    b(listener, text);
                    return;
                }
                a(listener, text);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReaderA, th);
                    throw th2;
                }
            }
        } catch (MalformedURLException e) {
            Log.e("URL is malformed", e);
            a(listener, (String) null);
        } catch (IOException e2) {
            Log.e("Error opening HTTP connection", e2);
            a(listener, (String) null);
        } catch (Exception e3) {
            Log.e("Error sending the HTTP request", e3);
            a(listener, (String) null);
        }
    }

    private final void a(URLConnection connection, byte[] bytes) throws IOException {
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    private final void a(q6 listener, String response) {
        if (!(listener instanceof r6)) {
            if (listener instanceof p6) {
                a((p6) listener, response);
            }
        } else {
            r6 r6Var = (r6) listener;
            if (response == null) {
                response = "Unknown error";
            }
            r6Var.b(response);
        }
    }

    private final void a(p6 listener, String response) {
        if (response != null) {
            try {
                if (!StringsKt.isBlank(response)) {
                    listener.a(new JSONObject(response));
                    return;
                }
            } catch (Exception e) {
                Log.e("Cannot parse JSON error response", e);
                listener.a(null);
                return;
            }
        }
        listener.a(null);
    }

    private final BufferedReader a(HttpURLConnection connection) {
        try {
            int responseCode = connection.getResponseCode();
            if (responseCode < 400 && responseCode >= 200) {
                InputStream inputStream = connection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                return new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192);
            }
            InputStream errorStream = connection.getErrorStream();
            Intrinsics.checkNotNullExpressionValue(errorStream, "connection.errorStream");
            return new BufferedReader(new InputStreamReader(errorStream, Charsets.UTF_8), 8192);
        } catch (IOException e) {
            Log.e("Error opening HTTP connection", e);
            return null;
        }
    }
}

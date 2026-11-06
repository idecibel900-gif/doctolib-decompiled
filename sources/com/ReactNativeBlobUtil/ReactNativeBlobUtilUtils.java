package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.util.Base64;
import app.notifee.core.event.LogEvent;
import com.ReactNativeBlobUtil.Utils.PathResolver;
import com.adjust.sdk.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactNativeBlobUtilUtils {
    public static X509TrustManager sharedTrustManager;

    public static String getMD5(String str) {
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : bArrDigest) {
                    sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b & 255)));
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void emitWarningEvent(String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("event", LogEvent.LEVEL_WARN);
        writableMapCreateMap.putString("detail", str);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilMessage", writableMapCreateMap);
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient(OkHttpClient okHttpClient) {
        try {
            X509TrustManager x509TrustManager = sharedTrustManager;
            if (x509TrustManager == null) {
                throw new IllegalStateException("Use of own trust manager but none defined");
            }
            TrustManager[] trustManagerArr = {x509TrustManager};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            OkHttpClient.Builder builderNewBuilder = okHttpClient.newBuilder();
            builderNewBuilder.sslSocketFactory(socketFactory, sharedTrustManager);
            builderNewBuilder.hostnameVerifier(new HostnameVerifier() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            });
            return builderNewBuilder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] stringToBytes(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName("US-ASCII"));
        }
        if (str2.toLowerCase(Locale.ROOT).contains("base64")) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase("utf8")) {
            return str.getBytes(Charset.forName(Constants.ENCODING));
        }
        return str.getBytes(Charset.forName("US-ASCII"));
    }

    public static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        if (str.matches("\\w+\\:.*")) {
            if (str.startsWith("file://")) {
                return str.replace("file://", "");
            }
            Uri uri = Uri.parse(str);
            if (!str.startsWith("bundle-assets://")) {
                return PathResolver.getRealPathFromURI(ReactNativeBlobUtilImpl.RCTContext, uri);
            }
        }
        return str;
    }

    public static boolean isAsset(String str) {
        return str != null && str.startsWith("bundle-assets://");
    }

    public static boolean isContentUri(String str) {
        return str != null && str.startsWith("content://");
    }
}

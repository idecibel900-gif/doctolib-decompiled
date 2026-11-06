package com.swmansion.worklets;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Build;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingNativeLoadLibrary"})
public class ScriptBufferWrapper {

    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybridFromAssets(AssetManager assetManager, String str);

    private native HybridData initHybridFromFile(String str);

    private native HybridData initHybridFromString(String str, String str2);

    public ScriptBufferWrapper(String str, AssetManager assetManager) {
        if (str.startsWith("file://")) {
            this.mHybridData = initHybridFromFile(str.substring(7));
        } else {
            if (str.startsWith("assets://")) {
                this.mHybridData = initHybridFromAssets(assetManager, str.substring(9));
                return;
            }
            try {
                this.mHybridData = initHybridFromString(downloadScript(str), str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String downloadScript(String str) throws IOException {
        byte[] bytes;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                bytes = httpURLConnection.getInputStream().readAllBytes();
            } else {
                bytes = readBytes(httpURLConnection.getInputStream());
            }
            return new String(bytes, StandardCharsets.UTF_8);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    private static byte[] readBytes(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}

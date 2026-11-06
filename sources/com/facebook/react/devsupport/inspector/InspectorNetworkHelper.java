package com.facebook.react.devsupport.inspector;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class InspectorNetworkHelper {
    public static final InspectorNetworkHelper INSTANCE = new InspectorNetworkHelper();

    private InspectorNetworkHelper() {
    }

    public static final void loadNetworkResource(String url, final InspectorNetworkRequestListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            DevSupportHttpClient.INSTANCE.getHttpClient$ReactAndroid_release().newCall(new Request.Builder().url(url).build()).enqueue(new Callback() { // from class: com.facebook.react.devsupport.inspector.InspectorNetworkHelper.loadNetworkResource.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException e) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (call.getCanceled()) {
                        return;
                    }
                    listener.onError(e.getMessage());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    Headers headers = response.getHeaders();
                    HashMap map = new HashMap();
                    for (String str : headers.names()) {
                        map.put(str, headers.get(str));
                    }
                    listener.onHeaders(response.getCode(), map);
                    try {
                        ResponseBody body = response.getBody();
                        InspectorNetworkRequestListener inspectorNetworkRequestListener = listener;
                        if (body != null) {
                            try {
                                InputStream inputStreamByteStream = body.byteStream();
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    try {
                                        int i = inputStreamByteStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        } else {
                                            inspectorNetworkRequestListener.onData(new String(bArr, 0, i, Charsets.UTF_8));
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            CloseableKt.closeFinally(inputStreamByteStream, th);
                                            throw th2;
                                        }
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(body, th);
                                        throw th3;
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamByteStream, null);
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                        inspectorNetworkRequestListener.onCompletion();
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(body, null);
                    } catch (IOException e) {
                        listener.onError(e.getMessage());
                    }
                }
            });
        } catch (IllegalArgumentException unused) {
            listener.onError("Not a valid URL: " + url);
        }
    }
}

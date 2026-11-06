package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class FileIoHandler implements Runnable {
    private static final Companion Companion = new Companion(null);
    private static final String TAG;
    private final Map requestHandlers;
    private int nextHandle = 1;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Map openFiles = new LinkedHashMap();

    public FileIoHandler() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.requestHandlers = linkedHashMap;
        linkedHashMap.put("fopen", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.1
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                Intrinsics.checkNotNullParameter(responder, "responder");
                Map map = FileIoHandler.this.openFiles;
                FileIoHandler fileIoHandler = FileIoHandler.this;
                synchronized (map) {
                    try {
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject == null) {
                                throw new Exception("params must be an object { mode: string, filename: string }");
                            }
                            String strOptString = jSONObject.optString("mode");
                            if (strOptString == null) {
                                throw new Exception("missing params.mode");
                            }
                            String strOptString2 = jSONObject.optString("filename");
                            if (strOptString2 == null) {
                                throw new Exception("missing params.filename");
                            }
                            if (Intrinsics.areEqual(strOptString, "r")) {
                                responder.respond(Integer.valueOf(fileIoHandler.addOpenFile(strOptString2)));
                                Unit unit = Unit.INSTANCE;
                            } else {
                                throw new IllegalArgumentException(("unsupported mode: " + strOptString).toString());
                            }
                        } catch (Exception e) {
                            responder.error(e.toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        linkedHashMap.put("fclose", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.2
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                Intrinsics.checkNotNullParameter(responder, "responder");
                Map map = FileIoHandler.this.openFiles;
                FileIoHandler fileIoHandler = FileIoHandler.this;
                synchronized (map) {
                    try {
                        try {
                            if (obj instanceof Number) {
                                TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) fileIoHandler.openFiles.get(obj);
                                if (ttlFileInputStream != null) {
                                    TypeIntrinsics.asMutableMap(fileIoHandler.openFiles).remove(obj);
                                    ttlFileInputStream.close();
                                    responder.respond("");
                                    Unit unit = Unit.INSTANCE;
                                } else {
                                    throw new Exception("invalid file handle, it might have timed out");
                                }
                            } else {
                                throw new Exception("params must be a file handle");
                            }
                        } catch (Exception e) {
                            responder.error(e.toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        linkedHashMap.put("fread", new RequestOnlyHandler() { // from class: com.facebook.react.packagerconnection.FileIoHandler.3
            @Override // com.facebook.react.packagerconnection.RequestHandler
            public void onRequest(Object obj, Responder responder) {
                Intrinsics.checkNotNullParameter(responder, "responder");
                Map map = FileIoHandler.this.openFiles;
                FileIoHandler fileIoHandler = FileIoHandler.this;
                synchronized (map) {
                    try {
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (jSONObject == null) {
                                throw new Exception("params must be an object { file: handle, size: number }");
                            }
                            int iOptInt = jSONObject.optInt("file");
                            if (iOptInt == 0) {
                                throw new Exception("invalid or missing file handle");
                            }
                            int iOptInt2 = jSONObject.optInt("size");
                            if (iOptInt2 != 0) {
                                TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) fileIoHandler.openFiles.get(Integer.valueOf(iOptInt));
                                if (ttlFileInputStream == null) {
                                    throw new Exception("invalid file handle, it might have timed out");
                                }
                                responder.respond(ttlFileInputStream.read(iOptInt2));
                                Unit unit = Unit.INSTANCE;
                            } else {
                                throw new Exception("invalid or missing read size");
                            }
                        } catch (Exception e) {
                            responder.error(e.toString());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    private static final class TtlFileInputStream {
        private final FileInputStream stream;
        private long ttl = System.currentTimeMillis() + HTTPTimeoutManager.DEFAULT_TIMEOUT_MS;

        public TtlFileInputStream(String str) {
            this.stream = new FileInputStream(str);
        }

        private final void extendTtl() {
            this.ttl = System.currentTimeMillis() + HTTPTimeoutManager.DEFAULT_TIMEOUT_MS;
        }

        public final boolean expiredTtl() {
            return System.currentTimeMillis() >= this.ttl;
        }

        public final String read(int i) {
            extendTtl();
            byte[] bArr = new byte[i];
            String strEncodeToString = Base64.encodeToString(bArr, 0, this.stream.read(bArr), 0);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        public final void close() throws IOException {
            this.stream.close();
        }
    }

    public final Map handlers() {
        return this.requestHandlers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int addOpenFile(String str) {
        int i = this.nextHandle;
        this.nextHandle = i + 1;
        this.openFiles.put(Integer.valueOf(i), new TtlFileInputStream(str));
        if (this.openFiles.size() == 1) {
            this.handler.postDelayed(this, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS);
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.openFiles) {
            try {
                CollectionsKt.removeAll(this.openFiles.entrySet(), new Function1() { // from class: com.facebook.react.packagerconnection.FileIoHandler$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(FileIoHandler.run$lambda$1$lambda$0((Map.Entry) obj));
                    }
                });
                if (!this.openFiles.isEmpty()) {
                    this.handler.postDelayed(this, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean run$lambda$1$lambda$0(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        TtlFileInputStream ttlFileInputStream = (TtlFileInputStream) entry.getValue();
        if (!ttlFileInputStream.expiredTtl()) {
            return false;
        }
        try {
            ttlFileInputStream.close();
            return true;
        } catch (IOException e) {
            FLog.e(TAG, "Failed to close expired file", e);
            return true;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = JSPackagerClient.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        TAG = simpleName;
    }
}

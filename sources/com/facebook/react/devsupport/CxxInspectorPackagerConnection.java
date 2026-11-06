package com.facebook.react.devsupport;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.devsupport.inspector.DevSupportHttpClient;
import com.facebook.soloader.SoLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096 J\t\u0010\f\u001a\u00020\u000bH\u0096 J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0096 R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/devsupport/CxxInspectorPackagerConnection;", "Lcom/facebook/react/devsupport/IInspectorPackagerConnection;", "url", "", "deviceName", "packageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "connect", "", "closeQuietly", "sendEventToAllConnections", "event", "WebSocketDelegate", "IWebSocket", "InspectorPackagerWebSocketImpl", "DelegateImpl", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CxxInspectorPackagerConnection implements IInspectorPackagerConnection {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MAX_QUEUE_SIZE = 16777216;

    @DoNotStrip
    private final HybridData mHybridData;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bc\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/facebook/react/devsupport/CxxInspectorPackagerConnection$IWebSocket;", "Ljava/io/Closeable;", "send", "", "chunk", "Ljava/nio/ByteBuffer;", "close", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface IWebSocket extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();

        void send(ByteBuffer chunk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final native HybridData initHybrid(String str, String str2, String str3, DelegateImpl delegateImpl);

    @Override // com.facebook.react.devsupport.IInspectorPackagerConnection
    public native void closeQuietly();

    public native void connect();

    @Override // com.facebook.react.devsupport.IInspectorPackagerConnection
    public native void sendEventToAllConnections(String event);

    public CxxInspectorPackagerConnection(String url, String deviceName, String packageName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.mHybridData = INSTANCE.initHybrid(url, deviceName, packageName, new DelegateImpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DoNotStrip
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086 ¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0086 J\t\u0010\u000f\u001a\u00020\u0007H\u0086 J\t\u0010\u0010\u001a\u00020\u0007H\u0086 J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/react/devsupport/CxxInspectorPackagerConnection$WebSocketDelegate;", "Ljava/io/Closeable;", "mHybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "didFailWithError", "", "posixCode", "", "error", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "didReceiveMessage", "message", "didOpen", "didClose", "close", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class WebSocketDelegate implements Closeable {
        private final HybridData mHybridData;

        public final native void didClose();

        public final native void didFailWithError(Integer posixCode, String error);

        public final native void didOpen();

        public final native void didReceiveMessage(String message);

        @DoNotStrip
        public WebSocketDelegate(HybridData mHybridData) {
            Intrinsics.checkNotNullParameter(mHybridData, "mHybridData");
            this.mHybridData = mHybridData;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mHybridData.resetNative();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class InspectorPackagerWebSocketImpl implements IWebSocket {
        public static final Companion Companion = new Companion(null);
        private static final String TAG;
        private final CxxInspectorPackagerConnection$InspectorPackagerWebSocketImpl$drainRunnable$1 drainRunnable;
        private final Handler handler;
        private final Queue messageQueue;
        private final WebSocket nativeWebSocket;
        private final Object queueLock;

        /* JADX WARN: Type inference failed for: r2v3, types: [com.facebook.react.devsupport.CxxInspectorPackagerConnection$InspectorPackagerWebSocketImpl$drainRunnable$1] */
        public InspectorPackagerWebSocketImpl(WebSocket nativeWebSocket, Handler handler) {
            Intrinsics.checkNotNullParameter(nativeWebSocket, "nativeWebSocket");
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.nativeWebSocket = nativeWebSocket;
            this.handler = handler;
            this.messageQueue = new ArrayDeque();
            this.queueLock = new Object();
            this.drainRunnable = new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection$InspectorPackagerWebSocketImpl$drainRunnable$1
                @Override // java.lang.Runnable
                public void run() {
                    FLog.d(CxxInspectorPackagerConnection.InspectorPackagerWebSocketImpl.TAG, "Attempting to drain the message queue after 100ms");
                    this.this$0.tryDrainQueue();
                }
            };
        }

        @Override // com.facebook.react.devsupport.CxxInspectorPackagerConnection.IWebSocket
        public void send(ByteBuffer chunk) {
            Intrinsics.checkNotNullParameter(chunk, "chunk");
            synchronized (this.queueLock) {
                try {
                    int iCapacity = chunk.capacity();
                    String string = StandardCharsets.UTF_8.decode(chunk).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    if (this.nativeWebSocket.queueSize() + ((long) iCapacity) > CxxInspectorPackagerConnection.MAX_QUEUE_SIZE) {
                        FLog.d(TAG, "Reached queue size limit. Queueing the message.");
                        this.messageQueue.offer(new Pair(string, Integer.valueOf(iCapacity)));
                        scheduleDrain();
                        Unit unit = Unit.INSTANCE;
                    } else if (this.messageQueue.isEmpty()) {
                        this.nativeWebSocket.send(string);
                    } else {
                        this.messageQueue.offer(new Pair(string, Integer.valueOf(iCapacity)));
                        tryDrainQueue();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.facebook.react.devsupport.CxxInspectorPackagerConnection.IWebSocket, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            synchronized (this.queueLock) {
                this.handler.removeCallbacks(this.drainRunnable);
                this.messageQueue.clear();
                this.nativeWebSocket.close(1000, "End of session");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void tryDrainQueue() {
            Pair pair;
            synchronized (this.queueLock) {
                while (!this.messageQueue.isEmpty() && (pair = (Pair) this.messageQueue.peek()) != null) {
                    try {
                        String str = (String) pair.getFirst();
                        if (this.nativeWebSocket.queueSize() + ((long) ((Number) pair.getSecond()).intValue()) <= CxxInspectorPackagerConnection.MAX_QUEUE_SIZE) {
                            this.messageQueue.poll();
                            if (!this.nativeWebSocket.send(str)) {
                                this.handler.removeCallbacks(this.drainRunnable);
                                this.messageQueue.clear();
                                break;
                            }
                        } else {
                            scheduleDrain();
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void scheduleDrain() {
            FLog.d(TAG, "Scheduled a task to drain messages queue.");
            this.handler.removeCallbacks(this.drainRunnable);
            this.handler.postDelayed(this.drainRunnable, 100L);
        }

        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        static {
            String simpleName = InspectorPackagerWebSocketImpl.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            TAG = simpleName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class DelegateImpl {
        private final OkHttpClient httpClient = DevSupportHttpClient.INSTANCE.getWebsocketClient$ReactAndroid_release();
        private final Handler handler = new Handler(Looper.getMainLooper());

        @DoNotStrip
        public final IWebSocket connectWebSocket(String str, WebSocketDelegate delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
            if (str == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            return new InspectorPackagerWebSocketImpl(this.httpClient.newWebSocket(new Request.Builder().url(str).build(), new CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1(this, delegate)), this.handler);
        }

        @DoNotStrip
        public final void scheduleCallback(Runnable runnable, long j) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.handler.postDelayed(runnable, j);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HybridData initHybrid(String str, String str2, String str3, DelegateImpl delegateImpl) {
            return CxxInspectorPackagerConnection.initHybrid(str, str2, str3, delegateImpl);
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("react_devsupportjni");
    }
}

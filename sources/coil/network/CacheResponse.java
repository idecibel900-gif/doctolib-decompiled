package coil.network;

import coil.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Response;
import okio.BufferedSink;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheResponse {
    private final Lazy cacheControl$delegate;
    private final Lazy contentType$delegate;
    private final boolean isTls;
    private final long receivedResponseAtMillis;
    private final Headers responseHeaders;
    private final long sentRequestAtMillis;

    public final CacheControl getCacheControl() {
        return (CacheControl) this.cacheControl$delegate.getValue();
    }

    public final MediaType getContentType() {
        return (MediaType) this.contentType$delegate.getValue();
    }

    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public CacheResponse(BufferedSource bufferedSource) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: coil.network.CacheResponse$cacheControl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CacheControl invoke() {
                return CacheControl.INSTANCE.parse(this.this$0.getResponseHeaders());
            }
        });
        this.contentType$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: coil.network.CacheResponse$contentType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MediaType invoke() {
                String str = this.this$0.getResponseHeaders().get("Content-Type");
                if (str != null) {
                    return MediaType.INSTANCE.parse(str);
                }
                return null;
            }
        });
        this.sentRequestAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.receivedResponseAtMillis = Long.parseLong(bufferedSource.readUtf8LineStrict());
        this.isTls = Integer.parseInt(bufferedSource.readUtf8LineStrict()) > 0;
        int i = Integer.parseInt(bufferedSource.readUtf8LineStrict());
        Headers.Builder builder = new Headers.Builder();
        for (int i2 = 0; i2 < i; i2++) {
            Utils.addUnsafeNonAscii(builder, bufferedSource.readUtf8LineStrict());
        }
        this.responseHeaders = builder.build();
    }

    public CacheResponse(Response response) {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.cacheControl$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: coil.network.CacheResponse$cacheControl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CacheControl invoke() {
                return CacheControl.INSTANCE.parse(this.this$0.getResponseHeaders());
            }
        });
        this.contentType$delegate = LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: coil.network.CacheResponse$contentType$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MediaType invoke() {
                String str = this.this$0.getResponseHeaders().get("Content-Type");
                if (str != null) {
                    return MediaType.INSTANCE.parse(str);
                }
                return null;
            }
        });
        this.sentRequestAtMillis = response.sentRequestAtMillis();
        this.receivedResponseAtMillis = response.receivedResponseAtMillis();
        this.isTls = response.handshake() != null;
        this.responseHeaders = response.headers();
    }

    public final void writeTo(BufferedSink bufferedSink) {
        bufferedSink.writeDecimalLong(this.sentRequestAtMillis).writeByte(10);
        bufferedSink.writeDecimalLong(this.receivedResponseAtMillis).writeByte(10);
        bufferedSink.writeDecimalLong(this.isTls ? 1L : 0L).writeByte(10);
        bufferedSink.writeDecimalLong(this.responseHeaders.size()).writeByte(10);
        int size = this.responseHeaders.size();
        for (int i = 0; i < size; i++) {
            bufferedSink.writeUtf8(this.responseHeaders.name(i)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i)).writeByte(10);
        }
    }
}

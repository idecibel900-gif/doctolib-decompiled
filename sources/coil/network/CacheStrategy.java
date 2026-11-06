package coil.network;

import coil.util.Time;
import coil.util.Utils;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    private final CacheResponse cacheResponse;
    private final Request networkRequest;

    public /* synthetic */ CacheStrategy(Request request, CacheResponse cacheResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, cacheResponse);
    }

    private CacheStrategy(Request request, CacheResponse cacheResponse) {
        this.networkRequest = request;
        this.cacheResponse = cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    public final CacheResponse getCacheResponse() {
        return this.cacheResponse;
    }

    public static final class Factory {
        private int ageSeconds;
        private final CacheResponse cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(Request request, CacheResponse cacheResponse) {
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (cacheResponse != null) {
                this.sentRequestMillis = cacheResponse.getSentRequestAtMillis();
                this.receivedResponseMillis = cacheResponse.getReceivedResponseAtMillis();
                Headers responseHeaders = cacheResponse.getResponseHeaders();
                int size = responseHeaders.size();
                for (int i = 0; i < size; i++) {
                    String strName = responseHeaders.name(i);
                    if (StringsKt.equals(strName, "Date", true)) {
                        this.servedDate = responseHeaders.getDate("Date");
                        this.servedDateString = responseHeaders.value(i);
                    } else if (StringsKt.equals(strName, "Expires", true)) {
                        this.expires = responseHeaders.getDate("Expires");
                    } else if (StringsKt.equals(strName, "Last-Modified", true)) {
                        this.lastModified = responseHeaders.getDate("Last-Modified");
                        this.lastModifiedString = responseHeaders.value(i);
                    } else if (StringsKt.equals(strName, "ETag", true)) {
                        this.etag = responseHeaders.value(i);
                    } else if (StringsKt.equals(strName, "Age", true)) {
                        this.ageSeconds = Utils.toNonNegativeInt(responseHeaders.value(i), -1);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CacheStrategy compute() {
            String str;
            CacheResponse cacheResponse = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, cacheResponse, objArr12 == true ? 1 : 0);
            }
            if (this.request.isHttps() && !this.cacheResponse.isTls()) {
                return new CacheStrategy(this.request, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            CacheControl cacheControl = this.cacheResponse.getCacheControl();
            if (!CacheStrategy.Companion.isCacheable(this.request, this.cacheResponse)) {
                return new CacheStrategy(this.request, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            CacheControl cacheControl2 = this.request.cacheControl();
            if (cacheControl2.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            if (cacheControl2.maxAgeSeconds() != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl2.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl2.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl2.minFreshSeconds()) : 0L;
            if (!cacheControl.mustRevalidate() && cacheControl2.maxStaleSeconds() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControl2.maxStaleSeconds());
            }
            if (!cacheControl.noCache() && jCacheResponseAge + millis2 < jComputeFreshnessLifetime + millis) {
                return new CacheStrategy(objArr7 == true ? 1 : 0, this.cacheResponse, objArr6 == true ? 1 : 0);
            }
            String str2 = this.etag;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                    Intrinsics.checkNotNull(str2);
                } else if (this.servedDate != null) {
                    str2 = this.servedDateString;
                    Intrinsics.checkNotNull(str2);
                } else {
                    return new CacheStrategy(this.request, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                }
            }
            return new CacheStrategy(this.request.newBuilder().addHeader(str, str2).build(), this.cacheResponse, objArr5 == true ? 1 : 0);
        }

        private final long computeFreshnessLifetime() {
            CacheResponse cacheResponse = this.cacheResponse;
            Intrinsics.checkNotNull(cacheResponse);
            CacheControl cacheControl = cacheResponse.getCacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.request.url().query() == null) {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                Intrinsics.checkNotNull(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / ((long) 10);
                }
            }
            return 0L;
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            return jMax + (this.receivedResponseMillis - this.sentRequestMillis) + (Time.INSTANCE.currentMillis() - this.receivedResponseMillis);
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(Request request, Response response) {
            return (request.cacheControl().noStore() || response.cacheControl().noStore() || Intrinsics.areEqual(response.headers().get("Vary"), "*")) ? false : true;
        }

        public final boolean isCacheable(Request request, CacheResponse cacheResponse) {
            return (request.cacheControl().noStore() || cacheResponse.getCacheControl().noStore() || Intrinsics.areEqual(cacheResponse.getResponseHeaders().get("Vary"), "*")) ? false : true;
        }

        public final Headers combineHeaders(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                String strValue = headers.value(i);
                if ((!StringsKt.equals("Warning", strName, true) || !StringsKt.startsWith$default(strValue, "1", false, 2, (Object) null)) && (isContentSpecificHeader(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                    builder.add(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strName2 = headers2.name(i2);
                if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                    builder.add(strName2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isEndToEnd(String str) {
            return (StringsKt.equals("Connection", str, true) || StringsKt.equals("Keep-Alive", str, true) || StringsKt.equals("Proxy-Authenticate", str, true) || StringsKt.equals("Proxy-Authorization", str, true) || StringsKt.equals("TE", str, true) || StringsKt.equals("Trailers", str, true) || StringsKt.equals("Transfer-Encoding", str, true) || StringsKt.equals("Upgrade", str, true)) ? false : true;
        }

        private final boolean isContentSpecificHeader(String str) {
            return StringsKt.equals("Content-Length", str, true) || StringsKt.equals("Content-Encoding", str, true) || StringsKt.equals("Content-Type", str, true);
        }
    }
}

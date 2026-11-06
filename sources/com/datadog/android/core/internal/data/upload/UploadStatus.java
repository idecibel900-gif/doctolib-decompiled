package com.datadog.android.core.internal.data.upload;

import com.datadog.android.api.InternalLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class UploadStatus {
    public static final Companion Companion = new Companion(null);
    private final int code;
    private final boolean shouldRetry;
    private final Throwable throwable;

    public /* synthetic */ UploadStatus(boolean z, int i, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, th);
    }

    private UploadStatus(boolean z, int i, Throwable th) {
        this.shouldRetry = z;
        this.code = i;
        this.throwable = th;
    }

    public /* synthetic */ UploadStatus(boolean z, int i, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : th, null);
    }

    public final boolean getShouldRetry() {
        return this.shouldRetry;
    }

    public final int getCode() {
        return this.code;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public static final class Success extends UploadStatus {
        public Success(int i) {
            super(false, i, null, 4, null);
        }
    }

    public static final class NetworkError extends UploadStatus {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkError(Throwable throwable) {
            super(true, 0, throwable, 2, null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }
    }

    public static final class DNSError extends UploadStatus {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DNSError(Throwable throwable) {
            super(true, 0, throwable, 2, null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }
    }

    public static final class RequestCreationError extends UploadStatus {
        public RequestCreationError(Throwable th) {
            super(false, 0, th, 2, null);
        }
    }

    public static final class InvalidTokenError extends UploadStatus {
        public InvalidTokenError(int i) {
            super(false, i, null, 4, null);
        }
    }

    public static final class HttpClientError extends UploadStatus {
        public HttpClientError(int i) {
            super(false, i, null, 4, null);
        }
    }

    public static final class HttpServerError extends UploadStatus {
        public HttpServerError(int i) {
            super(true, i, null, 4, null);
        }
    }

    public static final class HttpClientRateLimiting extends UploadStatus {
        public HttpClientRateLimiting(int i) {
            super(true, i, null, 4, null);
        }
    }

    public static final class UnknownHttpError extends UploadStatus {
        public UnknownHttpError(int i) {
            super(false, i, null, 4, null);
        }
    }

    public static final class UnknownException extends UploadStatus {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownException(Throwable throwable) {
            super(true, 0, throwable, 2, null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }
    }

    public static final class UnknownStatus extends UploadStatus {
        public static final UnknownStatus INSTANCE = new UnknownStatus();

        private UnknownStatus() {
            super(false, 0, null, 4, null);
        }
    }

    public final void logStatus(final String context, final int i, InternalLogger logger, final int i2, final String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        InternalLogger.DefaultImpls.log$default(logger, resolveInternalLogLevel(), resolveInternalLogTarget(), new Function0() { // from class: com.datadog.android.core.internal.data.upload.UploadStatus.logStatus.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                UploadStatus uploadStatus = UploadStatus.this;
                return uploadStatus.buildStatusMessage(str, i, context, uploadStatus.getThrowable(), i2);
            }
        }, (Throwable) null, false, (Map) null, 56, (Object) null);
    }

    private final List resolveInternalLogTarget() {
        if (this instanceof HttpClientError ? true : this instanceof HttpClientRateLimiting ? true : this instanceof UnknownStatus) {
            return CollectionsKt.listOf((Object[]) new InternalLogger.Target[]{InternalLogger.Target.USER, InternalLogger.Target.TELEMETRY});
        }
        if (this instanceof DNSError ? true : this instanceof HttpServerError ? true : this instanceof InvalidTokenError ? true : this instanceof NetworkError ? true : this instanceof RequestCreationError ? true : this instanceof Success ? true : this instanceof UnknownException ? true : this instanceof UnknownHttpError) {
            return CollectionsKt.listOf(InternalLogger.Target.USER);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final InternalLogger.Level resolveInternalLogLevel() {
        if (this instanceof HttpClientError ? true : this instanceof HttpServerError ? true : this instanceof InvalidTokenError ? true : this instanceof RequestCreationError ? true : this instanceof UnknownException ? true : this instanceof UnknownHttpError) {
            return InternalLogger.Level.ERROR;
        }
        if (this instanceof DNSError ? true : this instanceof HttpClientRateLimiting ? true : this instanceof UnknownStatus ? true : this instanceof NetworkError) {
            return InternalLogger.Level.WARN;
        }
        if (this instanceof Success) {
            return InternalLogger.Level.INFO;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildStatusMessage(String str, int i, String str2, Throwable th, int i2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            sb.append("Batch [" + i + " bytes] (" + str2 + ")");
        } else {
            sb.append("Batch " + str + " [" + i + " bytes] (" + str2 + ")");
        }
        if (this instanceof DNSError) {
            sb.append(" failed because of a DNS error");
        } else if (this instanceof HttpClientError) {
            sb.append(" failed because of a processing error or invalid data");
        } else if (this instanceof HttpClientRateLimiting) {
            sb.append(" failed because of an intake rate limitation");
        } else if (this instanceof HttpServerError) {
            sb.append(" failed because of a server processing error");
        } else if (this instanceof InvalidTokenError) {
            sb.append(" failed because your token is invalid");
        } else if (this instanceof NetworkError) {
            sb.append(" failed because of a network error");
        } else if (this instanceof RequestCreationError) {
            sb.append(" failed because of an error when creating the request");
        } else if (this instanceof UnknownException) {
            sb.append(" failed because of an unknown error");
        } else if (this instanceof UnknownHttpError) {
            sb.append(" failed because of an unexpected HTTP error (status code = " + this.code + ")");
        } else if (this instanceof UnknownStatus) {
            sb.append(" status is unknown");
        } else if (this instanceof Success) {
            sb.append(" sent successfully.");
        }
        if (th != null) {
            sb.append(" (");
            sb.append(th.getClass().getName());
            sb.append(": ");
            sb.append(th.getMessage());
            sb.append(")");
        }
        if (this.shouldRetry) {
            sb.append("; we will retry later.");
        } else if (!(this instanceof Success)) {
            sb.append("; the batch was dropped.");
        }
        if (this instanceof InvalidTokenError) {
            sb.append(" Make sure that the provided token still exists and you're targeting the relevant Datadog site.");
        }
        String str3 = String.format(Locale.US, " This request was attempted %d time(s).", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(this.code)}, 2));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        sb.append(str3);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

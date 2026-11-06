package com.datadog.android.log.internal.net;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.net.Request;
import com.datadog.android.api.net.RequestExecutionContext;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class LogsRequestFactory implements RequestFactory {
    public static final Companion Companion = new Companion(null);
    private static final byte[] PAYLOAD_PREFIX;
    private static final byte[] PAYLOAD_SEPARATOR;
    private static final byte[] PAYLOAD_SUFFIX;
    private final String customEndpointUrl;
    private final InternalLogger internalLogger;

    public LogsRequestFactory(String str, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.customEndpointUrl = str;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.api.net.RequestFactory
    public Request create(DatadogContext context, RequestExecutionContext executionContext, List batchData, byte[] bArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(batchData, "batchData");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        String strBuildUrl = buildUrl(context.getSource(), context);
        Map mapBuildHeaders = buildHeaders(string, context.getClientToken(), context.getSource(), context.getSdkVersion());
        List list = batchData;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RawBatchEvent) it.next()).getData());
        }
        return new Request(string, "Logs Request", strBuildUrl, mapBuildHeaders, ByteArrayExtKt.join(arrayList, PAYLOAD_SEPARATOR, PAYLOAD_PREFIX, PAYLOAD_SUFFIX, this.internalLogger), "application/json");
    }

    private final String buildUrl(String str, DatadogContext datadogContext) {
        Locale locale = Locale.US;
        String intakeEndpoint = this.customEndpointUrl;
        if (intakeEndpoint == null) {
            intakeEndpoint = datadogContext.getSite().getIntakeEndpoint();
        }
        String str2 = String.format(locale, "%s/api/v2/logs?%s=%s", Arrays.copyOf(new Object[]{intakeEndpoint, "ddsource", str}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    private final Map buildHeaders(String str, String str2, String str3, String str4) {
        return MapsKt.mapOf(TuplesKt.to("DD-API-KEY", str2), TuplesKt.to("DD-EVP-ORIGIN", str3), TuplesKt.to("DD-EVP-ORIGIN-VERSION", str4), TuplesKt.to("DD-REQUEST-ID", str));
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = f.a.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        PAYLOAD_SEPARATOR = bytes;
        byte[] bytes2 = "[".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        PAYLOAD_PREFIX = bytes2;
        byte[] bytes3 = "]".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        PAYLOAD_SUFFIX = bytes3;
    }
}

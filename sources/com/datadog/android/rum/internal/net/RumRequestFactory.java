package com.datadog.android.rum.internal.net;

import com.amazon.a.a.o.b.f;
import com.datadog.android.api.InternalLogger;
import com.datadog.android.api.context.DatadogContext;
import com.datadog.android.api.net.Request;
import com.datadog.android.api.net.RequestExecutionContext;
import com.datadog.android.api.net.RequestFactory;
import com.datadog.android.api.storage.RawBatchEvent;
import com.datadog.android.core.internal.utils.ByteArrayExtKt;
import com.datadog.android.rum.internal.domain.event.RumViewEventFilter;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class RumRequestFactory implements RequestFactory {
    public static final Companion Companion = new Companion(null);
    private static final byte[] PAYLOAD_SEPARATOR;
    private final String customEndpointUrl;
    private final InternalLogger internalLogger;
    private final RumViewEventFilter viewEventFilter;

    public RumRequestFactory(String str, RumViewEventFilter viewEventFilter, InternalLogger internalLogger) {
        Intrinsics.checkNotNullParameter(viewEventFilter, "viewEventFilter");
        Intrinsics.checkNotNullParameter(internalLogger, "internalLogger");
        this.customEndpointUrl = str;
        this.viewEventFilter = viewEventFilter;
        this.internalLogger = internalLogger;
    }

    @Override // com.datadog.android.api.net.RequestFactory
    public Request create(DatadogContext context, RequestExecutionContext executionContext, List batchData, byte[] bArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(batchData, "batchData");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        List listFilterOutRedundantViewEvents = this.viewEventFilter.filterOutRedundantViewEvents(batchData);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterOutRedundantViewEvents, 10));
        Iterator it = listFilterOutRedundantViewEvents.iterator();
        while (it.hasNext()) {
            arrayList.add(((RawBatchEvent) it.next()).getData());
        }
        byte[] bArrJoin$default = ByteArrayExtKt.join$default(arrayList, PAYLOAD_SEPARATOR, null, null, this.internalLogger, 6, null);
        return new Request(string, "RUM Request", buildUrl(context, executionContext), buildHeaders(string, idempotencyKey(bArrJoin$default), context), bArrJoin$default, "text/plain;charset=UTF-8");
    }

    private final String buildUrl(DatadogContext datadogContext, RequestExecutionContext requestExecutionContext) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("ddsource", datadogContext.getSource());
        String strBuildTags = buildTags(requestExecutionContext);
        if (strBuildTags.length() > 0) {
            mapCreateMapBuilder.put("ddtags", strBuildTags);
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        Locale locale = Locale.US;
        String intakeEndpoint = this.customEndpointUrl;
        if (intakeEndpoint == null) {
            intakeEndpoint = datadogContext.getSite().getIntakeEndpoint();
        }
        String str = String.format(locale, "%s/api/v2/rum", Arrays.copyOf(new Object[]{intakeEndpoint}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        ArrayList arrayList = new ArrayList(mapBuild.size());
        for (Map.Entry entry : mapBuild.entrySet()) {
            arrayList.add(entry.getKey() + f.b + entry.getValue());
        }
        return str + CollectionsKt.joinToString$default(arrayList, "&", "?", null, 0, null, null, 60, null);
    }

    private final Map buildHeaders(String str, String str2, DatadogContext datadogContext) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("DD-API-KEY", datadogContext.getClientToken()), TuplesKt.to("DD-EVP-ORIGIN", datadogContext.getSource()), TuplesKt.to("DD-EVP-ORIGIN-VERSION", datadogContext.getSdkVersion()), TuplesKt.to("DD-REQUEST-ID", str));
        if (str2 != null) {
            mapMutableMapOf.put("DD-IDEMPOTENCY-KEY", str2);
        }
        return mapMutableMapOf;
    }

    private final String buildTags(RequestExecutionContext requestExecutionContext) {
        StringBuilder sb = new StringBuilder();
        if (requestExecutionContext.getPreviousResponseCode() != null) {
            sb.append("retry_count:" + requestExecutionContext.getAttemptNumber());
            sb.append(f.a);
            sb.append("last_failure_status:" + requestExecutionContext.getPreviousResponseCode());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String idempotencyKey(byte[] bArr) {
        try {
            byte[] hashBytes = MessageDigest.getInstance("SHA-1").digest(bArr);
            Intrinsics.checkNotNullExpressionValue(hashBytes, "hashBytes");
            return com.datadog.android.internal.utils.ByteArrayExtKt.toHexString(hashBytes);
        } catch (IllegalArgumentException e) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot generate SHA-1 hash for rum request idempotency key.";
                }
            }, (Throwable) e, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NullPointerException e2) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot generate SHA-1 hash for rum request idempotency key.";
                }
            }, (Throwable) e2, false, (Map) null, 48, (Object) null);
            return null;
        } catch (DigestException e3) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cannot generate SHA-1 hash for rum request idempotency key.";
                }
            }, (Throwable) e3, false, (Map) null, 48, (Object) null);
            return null;
        } catch (NoSuchAlgorithmException e4) {
            InternalLogger.DefaultImpls.log$default(this.internalLogger, InternalLogger.Level.ERROR, InternalLogger.Target.MAINTAINER, (Function0) new Function0() { // from class: com.datadog.android.rum.internal.net.RumRequestFactory.idempotencyKey.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "SHA-1 algorithm could not be found in MessageDigest.";
                }
            }, (Throwable) e4, false, (Map) null, 48, (Object) null);
            return null;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        byte[] bytes = "\n".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        PAYLOAD_SEPARATOR = bytes;
    }
}

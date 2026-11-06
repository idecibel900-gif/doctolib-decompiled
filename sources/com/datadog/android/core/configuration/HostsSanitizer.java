package com.datadog.android.core.configuration;

import com.datadog.android.api.InternalLogger;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class HostsSanitizer {
    public static final Companion Companion = new Companion(null);

    public final List sanitizeHosts(List hosts, final String feature) {
        Intrinsics.checkNotNullParameter(hosts, "hosts");
        Intrinsics.checkNotNullParameter(feature, "feature");
        Regex regex = new Regex("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$|^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)+([A-Za-z]|[A-Za-z][A-Za-z0-9-]*[A-Za-z0-9])$");
        Regex regex2 = new Regex("^(http|https)://(.*)");
        ArrayList arrayList = new ArrayList();
        Iterator it = hosts.iterator();
        while (it.hasNext()) {
            final String host = (String) it.next();
            if (regex2.matches(host)) {
                try {
                    final URL url = new URL(host);
                    InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.WARN, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizeHosts$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "You are using a url \"%s\" instead of a host to setup %s tracking. You should use instead a valid host name: \"%s\"", Arrays.copyOf(new Object[]{host, feature, url.getHost()}, 3));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    host = url.getHost();
                } catch (MalformedURLException e) {
                    InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizeHosts$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "You are using a malformed url \"%s\" to setup %s tracking. It will be dropped. Please try using a host name instead, e.g.: \"example.com\"", Arrays.copyOf(new Object[]{host, feature}, 2));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, (Throwable) e, false, (Map) null, 48, (Object) null);
                    host = null;
                }
            } else if (!regex.matches(host)) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = host.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "localhost")) {
                    InternalLogger.DefaultImpls.log$default(RuntimeUtilsKt.getUnboundInternalLogger(), InternalLogger.Level.ERROR, InternalLogger.Target.USER, new Function0() { // from class: com.datadog.android.core.configuration.HostsSanitizer$sanitizeHosts$1$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            String str = String.format(Locale.US, "You are using a malformed host or ip address \"%s\" to setup %s tracking. It will be dropped.", Arrays.copyOf(new Object[]{host, feature}, 2));
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            return str;
                        }
                    }, (Throwable) null, false, (Map) null, 56, (Object) null);
                    host = null;
                }
            }
            if (host != null) {
                arrayList.add(host);
            }
        }
        return arrayList;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

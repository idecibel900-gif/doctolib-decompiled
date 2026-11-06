package io.didomi.ssl;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0002R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/r7;", "", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "a", "b", "c", "d", "", "Ljava/util/Map;", DiagnosticsEntry.PROPERTIES_KEY, "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class r7 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Map<String, Object> properties = new LinkedHashMap();

    public final void a(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            this.properties.put(key, value);
        } else {
            this.properties.remove(key);
        }
    }

    public final String b() {
        Object obj = this.properties.get("configParamRegion");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String c() {
        Object obj = this.properties.get("configParamRegulation");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String d() {
        Object obj = this.properties.get("configParamVersion");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final String a() {
        Object obj = this.properties.get("configParamCountry");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}

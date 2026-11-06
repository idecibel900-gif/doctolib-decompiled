package expo.modules.updates.manifest;

import expo.modules.structuredheaders.BooleanItem;
import expo.modules.structuredheaders.Item;
import expo.modules.structuredheaders.ListElement;
import expo.modules.structuredheaders.NumberItem;
import expo.modules.structuredheaders.ParseException;
import expo.modules.structuredheaders.Parser;
import expo.modules.structuredheaders.StringItem;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class ResponseHeaderData {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = ResponseHeaderData.class.getSimpleName();
    private final Lazy manifestFilters$delegate;
    private final String manifestFiltersRaw;
    private final Integer protocolVersion;
    private final String protocolVersionRaw;
    private final Lazy serverDefinedHeaders$delegate;
    private final String serverDefinedHeadersRaw;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseHeaderData)) {
            return false;
        }
        ResponseHeaderData responseHeaderData = (ResponseHeaderData) obj;
        return Intrinsics.areEqual(this.protocolVersionRaw, responseHeaderData.protocolVersionRaw) && Intrinsics.areEqual(this.serverDefinedHeadersRaw, responseHeaderData.serverDefinedHeadersRaw) && Intrinsics.areEqual(this.manifestFiltersRaw, responseHeaderData.manifestFiltersRaw);
    }

    public int hashCode() {
        String str = this.protocolVersionRaw;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.serverDefinedHeadersRaw;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.manifestFiltersRaw;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ResponseHeaderData(protocolVersionRaw=" + this.protocolVersionRaw + ", serverDefinedHeadersRaw=" + this.serverDefinedHeadersRaw + ", manifestFiltersRaw=" + this.manifestFiltersRaw + ")";
    }

    public ResponseHeaderData(String str, String str2, String str3) {
        this.protocolVersionRaw = str;
        this.serverDefinedHeadersRaw = str2;
        this.manifestFiltersRaw = str3;
        this.protocolVersion = str != null ? Integer.valueOf(str) : null;
        this.serverDefinedHeaders$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ResponseHeaderData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResponseHeaderData.serverDefinedHeaders_delegate$lambda$2(this.f$0);
            }
        });
        this.manifestFilters$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.manifest.ResponseHeaderData$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResponseHeaderData.manifestFilters_delegate$lambda$4(this.f$0);
            }
        });
    }

    public final Integer getProtocolVersion() {
        return this.protocolVersion;
    }

    public final JSONObject getServerDefinedHeaders() {
        return (JSONObject) this.serverDefinedHeaders$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject serverDefinedHeaders_delegate$lambda$2(ResponseHeaderData responseHeaderData) {
        String str = responseHeaderData.serverDefinedHeadersRaw;
        if (str != null) {
            return Companion.headerDictionaryToJSONObject(str);
        }
        return null;
    }

    public final JSONObject getManifestFilters() {
        return (JSONObject) this.manifestFilters$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject manifestFilters_delegate$lambda$4(ResponseHeaderData responseHeaderData) {
        String str = responseHeaderData.manifestFiltersRaw;
        if (str != null) {
            return Companion.headerDictionaryToJSONObject(str);
        }
        return null;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JSONObject headerDictionaryToJSONObject(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                Map map = new Parser(str).parseDictionary().get();
                for (String str2 : map.keySet()) {
                    Object obj = map.get(str2);
                    Intrinsics.checkNotNull(obj);
                    ListElement listElement = (ListElement) obj;
                    if ((listElement instanceof StringItem) || (listElement instanceof BooleanItem) || (listElement instanceof NumberItem)) {
                        jSONObject.put(str2, ((Item) listElement).get());
                    }
                }
                return jSONObject;
            } catch (ParseException unused) {
                String unused2 = ResponseHeaderData.TAG;
                return null;
            } catch (JSONException unused3) {
                String unused4 = ResponseHeaderData.TAG;
                return null;
            }
        }
    }
}

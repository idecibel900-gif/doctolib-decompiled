package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes5.dex */
public final class SdkVersion implements JsonSerializable {
    private Set deserializedIntegrations;
    private Set deserializedPackages;
    private String name;
    private Map unknown;
    private String version;

    public SdkVersion(String str, String str2) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
        this.version = (String) Objects.requireNonNull(str2, "version is required.");
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = (String) Objects.requireNonNull(str, "version is required.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
    }

    public void addPackage(String str, String str2) {
        SentryIntegrationPackageStorage.getInstance().addPackage(str, str2);
    }

    public Set getPackageSet() {
        Set set = this.deserializedPackages;
        return set != null ? set : SentryIntegrationPackageStorage.getInstance().getPackages();
    }

    public Set getIntegrationSet() {
        Set set = this.deserializedIntegrations;
        return set != null ? set : SentryIntegrationPackageStorage.getInstance().getIntegrations();
    }

    public static SdkVersion updateSdkVersion(SdkVersion sdkVersion, String str, String str2) {
        Objects.requireNonNull(str, "name is required.");
        Objects.requireNonNull(str2, "version is required.");
        if (sdkVersion == null) {
            return new SdkVersion(str, str2);
        }
        sdkVersion.setName(str);
        sdkVersion.setVersion(str2);
        return sdkVersion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SdkVersion.class == obj.getClass()) {
            SdkVersion sdkVersion = (SdkVersion) obj;
            if (this.name.equals(sdkVersion.name) && this.version.equals(sdkVersion.version)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("name").value(this.name);
        objectWriter.name(DiagnosticsEntry.VERSION_KEY).value(this.version);
        Set packageSet = getPackageSet();
        Set integrationSet = getIntegrationSet();
        if (!packageSet.isEmpty()) {
            objectWriter.name("packages").value(iLogger, packageSet);
        }
        if (!integrationSet.isEmpty()) {
            objectWriter.name("integrations").value(iLogger, integrationSet);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public SdkVersion deserialize(ObjectReader objectReader, ILogger iLogger) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            objectReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            HashMap map = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "name":
                        strNextString = objectReader.nextString();
                        break;
                    case "version":
                        strNextString2 = objectReader.nextString();
                        break;
                    case "packages":
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new SentryPackage.Deserializer());
                        if (listNextListOrNull == null) {
                            break;
                        } else {
                            arrayList.addAll(listNextListOrNull);
                            break;
                        }
                        break;
                    case "integrations":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                        break;
                    default:
                        if (map == null) {
                            map = new HashMap();
                        }
                        objectReader.nextUnknown(iLogger, map, strNextName);
                        break;
                }
            }
            objectReader.endObject();
            if (strNextString == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"name\"", illegalStateException);
                throw illegalStateException;
            }
            if (strNextString2 == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"version\"", illegalStateException2);
                throw illegalStateException2;
            }
            SdkVersion sdkVersion = new SdkVersion(strNextString, strNextString2);
            sdkVersion.deserializedPackages = new CopyOnWriteArraySet(arrayList);
            sdkVersion.deserializedIntegrations = new CopyOnWriteArraySet(arrayList2);
            sdkVersion.setUnknown(map);
            return sdkVersion;
        }
    }
}

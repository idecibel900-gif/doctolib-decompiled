package io.sentry;

import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ProfilingTraceData implements JsonSerializable {
    private int androidApiLevel;
    private String buildId;
    private String cpuArchitecture;
    private List deviceCpuFrequencies;
    private final Callable deviceCpuFrequenciesReader;
    private boolean deviceIsEmulator;
    private String deviceLocale;
    private String deviceManufacturer;
    private String deviceModel;
    private String deviceOsBuildNumber;
    private String deviceOsName;
    private String deviceOsVersion;
    private String devicePhysicalMemoryBytes;
    private String durationNs;
    private String environment;
    private final Map measurementsMap;
    private String platform;
    private String profileId;
    private String release;
    private String sampledProfile;
    private Date timestamp;
    private final File traceFile;
    private String traceId;
    private String transactionId;
    private String transactionName;
    private List transactions;
    private String truncationReason;
    private Map unknown;
    private String versionCode;

    private ProfilingTraceData() {
        this(new File("dummy"), NoOpTransaction.getInstance());
    }

    public ProfilingTraceData(File file, ITransaction iTransaction) {
        this(file, DateUtils.getCurrentDateTime(), new ArrayList(), iTransaction.getName(), iTransaction.getEventId().toString(), iTransaction.getSpanContext().getTraceId().toString(), "0", 0, "", new Callable() { // from class: io.sentry.ProfilingTraceData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ProfilingTraceData.$r8$lambda$lqGfC4o4cQG7BoqJ_xtBt7y3bC4();
            }
        }, null, null, null, null, null, null, null, null, Constants.NORMAL, new HashMap());
    }

    public static /* synthetic */ List $r8$lambda$lqGfC4o4cQG7BoqJ_xtBt7y3bC4() {
        return new ArrayList();
    }

    public ProfilingTraceData(File file, Date date, List list, String str, String str2, String str3, String str4, int i, String str5, Callable callable, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, Map map) {
        this.deviceCpuFrequencies = new ArrayList();
        this.sampledProfile = null;
        this.traceFile = file;
        this.timestamp = date;
        this.cpuArchitecture = str5;
        this.deviceCpuFrequenciesReader = callable;
        this.androidApiLevel = i;
        this.deviceLocale = Locale.getDefault().toString();
        this.deviceManufacturer = str6 == null ? "" : str6;
        this.deviceModel = str7 == null ? "" : str7;
        this.deviceOsVersion = str8 == null ? "" : str8;
        this.deviceIsEmulator = bool != null ? bool.booleanValue() : false;
        this.devicePhysicalMemoryBytes = str9 != null ? str9 : "0";
        this.deviceOsBuildNumber = "";
        this.deviceOsName = "android";
        this.platform = "android";
        this.buildId = str10 != null ? str10 : "";
        this.transactions = list;
        this.transactionName = str.isEmpty() ? "unknown" : str;
        this.durationNs = str4;
        this.versionCode = "";
        this.release = str11 != null ? str11 : "";
        this.transactionId = str2;
        this.traceId = str3;
        this.profileId = SentryUUID.generateSentryId();
        this.environment = str12 != null ? str12 : AdjustConfig.ENVIRONMENT_PRODUCTION;
        this.truncationReason = str13;
        if (!isTruncationReasonValid()) {
            this.truncationReason = Constants.NORMAL;
        }
        this.measurementsMap = map;
    }

    private boolean isTruncationReasonValid() {
        return this.truncationReason.equals(Constants.NORMAL) || this.truncationReason.equals("timeout") || this.truncationReason.equals("backgrounded");
    }

    public File getTraceFile() {
        return this.traceFile;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public void setSampledProfile(String str) {
        this.sampledProfile = str;
    }

    public void readDeviceCpuFrequencies() {
        try {
            this.deviceCpuFrequencies = (List) this.deviceCpuFrequenciesReader.call();
        } catch (Throwable unused) {
        }
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        objectWriter.name("android_api_level").value(iLogger, Integer.valueOf(this.androidApiLevel));
        objectWriter.name("device_locale").value(iLogger, this.deviceLocale);
        objectWriter.name("device_manufacturer").value(this.deviceManufacturer);
        objectWriter.name("device_model").value(this.deviceModel);
        objectWriter.name("device_os_build_number").value(this.deviceOsBuildNumber);
        objectWriter.name("device_os_name").value(this.deviceOsName);
        objectWriter.name("device_os_version").value(this.deviceOsVersion);
        objectWriter.name("device_is_emulator").value(this.deviceIsEmulator);
        objectWriter.name("architecture").value(iLogger, this.cpuArchitecture);
        objectWriter.name("device_cpu_frequencies").value(iLogger, this.deviceCpuFrequencies);
        objectWriter.name("device_physical_memory_bytes").value(this.devicePhysicalMemoryBytes);
        objectWriter.name("platform").value(this.platform);
        objectWriter.name("build_id").value(this.buildId);
        objectWriter.name("transaction_name").value(this.transactionName);
        objectWriter.name("duration_ns").value(this.durationNs);
        objectWriter.name("version_name").value(this.release);
        objectWriter.name("version_code").value(this.versionCode);
        if (!this.transactions.isEmpty()) {
            objectWriter.name("transactions").value(iLogger, this.transactions);
        }
        objectWriter.name("transaction_id").value(this.transactionId);
        objectWriter.name("trace_id").value(this.traceId);
        objectWriter.name("profile_id").value(this.profileId);
        objectWriter.name("environment").value(this.environment);
        objectWriter.name("truncation_reason").value(this.truncationReason);
        if (this.sampledProfile != null) {
            objectWriter.name("sampled_profile").value(this.sampledProfile);
        }
        String indent = objectWriter.getIndent();
        objectWriter.setIndent("");
        objectWriter.name("measurements").value(iLogger, this.measurementsMap);
        objectWriter.setIndent(indent);
        objectWriter.name(DiagnosticsEntry.TIMESTAMP_KEY).value(iLogger, this.timestamp);
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.unknown.get(str);
                objectWriter.name(str);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.sentry.JsonDeserializer
        public ProfilingTraceData deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            ProfilingTraceData profilingTraceData = new ProfilingTraceData();
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "device_manufacturer":
                        String strNextStringOrNull = objectReader.nextStringOrNull();
                        if (strNextStringOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.deviceManufacturer = strNextStringOrNull;
                            break;
                        }
                        break;
                    case "android_api_level":
                        Integer numNextIntegerOrNull = objectReader.nextIntegerOrNull();
                        if (numNextIntegerOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.androidApiLevel = numNextIntegerOrNull.intValue();
                            break;
                        }
                        break;
                    case "build_id":
                        String strNextStringOrNull2 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull2 == null) {
                            break;
                        } else {
                            profilingTraceData.buildId = strNextStringOrNull2;
                            break;
                        }
                        break;
                    case "device_locale":
                        String strNextStringOrNull3 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull3 == null) {
                            break;
                        } else {
                            profilingTraceData.deviceLocale = strNextStringOrNull3;
                            break;
                        }
                        break;
                    case "profile_id":
                        String strNextStringOrNull4 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull4 == null) {
                            break;
                        } else {
                            profilingTraceData.profileId = strNextStringOrNull4;
                            break;
                        }
                        break;
                    case "device_os_build_number":
                        String strNextStringOrNull5 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull5 == null) {
                            break;
                        } else {
                            profilingTraceData.deviceOsBuildNumber = strNextStringOrNull5;
                            break;
                        }
                        break;
                    case "device_model":
                        String strNextStringOrNull6 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull6 == null) {
                            break;
                        } else {
                            profilingTraceData.deviceModel = strNextStringOrNull6;
                            break;
                        }
                        break;
                    case "device_is_emulator":
                        Boolean boolNextBooleanOrNull = objectReader.nextBooleanOrNull();
                        if (boolNextBooleanOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.deviceIsEmulator = boolNextBooleanOrNull.booleanValue();
                            break;
                        }
                        break;
                    case "duration_ns":
                        String strNextStringOrNull7 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull7 == null) {
                            break;
                        } else {
                            profilingTraceData.durationNs = strNextStringOrNull7;
                            break;
                        }
                        break;
                    case "measurements":
                        Map mapNextMapOrNull = objectReader.nextMapOrNull(iLogger, new ProfileMeasurement.Deserializer());
                        if (mapNextMapOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.measurementsMap.putAll(mapNextMapOrNull);
                            break;
                        }
                        break;
                    case "device_physical_memory_bytes":
                        String strNextStringOrNull8 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull8 == null) {
                            break;
                        } else {
                            profilingTraceData.devicePhysicalMemoryBytes = strNextStringOrNull8;
                            break;
                        }
                        break;
                    case "device_cpu_frequencies":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            profilingTraceData.deviceCpuFrequencies = list;
                            break;
                        }
                        break;
                    case "version_code":
                        String strNextStringOrNull9 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull9 == null) {
                            break;
                        } else {
                            profilingTraceData.versionCode = strNextStringOrNull9;
                            break;
                        }
                        break;
                    case "version_name":
                        String strNextStringOrNull10 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull10 == null) {
                            break;
                        } else {
                            profilingTraceData.release = strNextStringOrNull10;
                            break;
                        }
                        break;
                    case "environment":
                        String strNextStringOrNull11 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull11 == null) {
                            break;
                        } else {
                            profilingTraceData.environment = strNextStringOrNull11;
                            break;
                        }
                        break;
                    case "timestamp":
                        Date dateNextDateOrNull = objectReader.nextDateOrNull(iLogger);
                        if (dateNextDateOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.timestamp = dateNextDateOrNull;
                            break;
                        }
                        break;
                    case "transaction_name":
                        String strNextStringOrNull12 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull12 == null) {
                            break;
                        } else {
                            profilingTraceData.transactionName = strNextStringOrNull12;
                            break;
                        }
                        break;
                    case "device_os_name":
                        String strNextStringOrNull13 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull13 == null) {
                            break;
                        } else {
                            profilingTraceData.deviceOsName = strNextStringOrNull13;
                            break;
                        }
                        break;
                    case "architecture":
                        String strNextStringOrNull14 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull14 == null) {
                            break;
                        } else {
                            profilingTraceData.cpuArchitecture = strNextStringOrNull14;
                            break;
                        }
                        break;
                    case "transaction_id":
                        String strNextStringOrNull15 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull15 == null) {
                            break;
                        } else {
                            profilingTraceData.transactionId = strNextStringOrNull15;
                            break;
                        }
                        break;
                    case "device_os_version":
                        String strNextStringOrNull16 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull16 == null) {
                            break;
                        } else {
                            profilingTraceData.deviceOsVersion = strNextStringOrNull16;
                            break;
                        }
                        break;
                    case "truncation_reason":
                        String strNextStringOrNull17 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull17 == null) {
                            break;
                        } else {
                            profilingTraceData.truncationReason = strNextStringOrNull17;
                            break;
                        }
                        break;
                    case "trace_id":
                        String strNextStringOrNull18 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull18 == null) {
                            break;
                        } else {
                            profilingTraceData.traceId = strNextStringOrNull18;
                            break;
                        }
                        break;
                    case "platform":
                        String strNextStringOrNull19 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull19 == null) {
                            break;
                        } else {
                            profilingTraceData.platform = strNextStringOrNull19;
                            break;
                        }
                        break;
                    case "sampled_profile":
                        String strNextStringOrNull20 = objectReader.nextStringOrNull();
                        if (strNextStringOrNull20 == null) {
                            break;
                        } else {
                            profilingTraceData.sampledProfile = strNextStringOrNull20;
                            break;
                        }
                        break;
                    case "transactions":
                        List listNextListOrNull = objectReader.nextListOrNull(iLogger, new ProfilingTransactionData.Deserializer());
                        if (listNextListOrNull == null) {
                            break;
                        } else {
                            profilingTraceData.transactions.addAll(listNextListOrNull);
                            break;
                        }
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            profilingTraceData.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return profilingTraceData;
        }
    }
}

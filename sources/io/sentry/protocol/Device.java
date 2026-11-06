package io.sentry.protocol;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Device implements JsonSerializable {
    private String[] archs;
    private Float batteryLevel;
    private Float batteryTemperature;
    private Date bootTime;
    private String brand;
    private Boolean charging;
    private String chipset;
    private String connectionType;
    private String cpuDescription;
    private Long externalFreeStorage;
    private Long externalStorageSize;
    private String family;
    private Long freeMemory;
    private Long freeStorage;
    private String id;
    private String locale;
    private Boolean lowMemory;
    private String manufacturer;
    private Long memorySize;
    private String model;
    private String modelId;
    private String name;
    private Boolean online;
    private DeviceOrientation orientation;
    private Integer processorCount;
    private Double processorFrequency;
    private Float screenDensity;
    private Integer screenDpi;
    private Integer screenHeightPixels;
    private Integer screenWidthPixels;
    private Boolean simulator;
    private Long storageSize;
    private TimeZone timezone;
    private Map unknown;
    private Long usableMemory;

    public Device() {
    }

    Device(Device device) {
        this.name = device.name;
        this.manufacturer = device.manufacturer;
        this.brand = device.brand;
        this.family = device.family;
        this.model = device.model;
        this.modelId = device.modelId;
        this.charging = device.charging;
        this.online = device.online;
        this.orientation = device.orientation;
        this.simulator = device.simulator;
        this.memorySize = device.memorySize;
        this.freeMemory = device.freeMemory;
        this.usableMemory = device.usableMemory;
        this.lowMemory = device.lowMemory;
        this.storageSize = device.storageSize;
        this.freeStorage = device.freeStorage;
        this.externalStorageSize = device.externalStorageSize;
        this.externalFreeStorage = device.externalFreeStorage;
        this.screenWidthPixels = device.screenWidthPixels;
        this.screenHeightPixels = device.screenHeightPixels;
        this.screenDensity = device.screenDensity;
        this.screenDpi = device.screenDpi;
        this.bootTime = device.bootTime;
        this.id = device.id;
        this.connectionType = device.connectionType;
        this.batteryTemperature = device.batteryTemperature;
        this.batteryLevel = device.batteryLevel;
        String[] strArr = device.archs;
        this.archs = strArr != null ? (String[]) strArr.clone() : null;
        this.locale = device.locale;
        TimeZone timeZone = device.timezone;
        this.timezone = timeZone != null ? (TimeZone) timeZone.clone() : null;
        this.processorCount = device.processorCount;
        this.processorFrequency = device.processorFrequency;
        this.cpuDescription = device.cpuDescription;
        this.chipset = device.chipset;
        this.unknown = CollectionUtils.newConcurrentHashMap(device.unknown);
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setFamily(String str) {
        this.family = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setBatteryLevel(Float f) {
        this.batteryLevel = f;
    }

    public void setCharging(Boolean bool) {
        this.charging = bool;
    }

    public void setOnline(Boolean bool) {
        this.online = bool;
    }

    public void setOrientation(DeviceOrientation deviceOrientation) {
        this.orientation = deviceOrientation;
    }

    public void setSimulator(Boolean bool) {
        this.simulator = bool;
    }

    public void setMemorySize(Long l) {
        this.memorySize = l;
    }

    public void setFreeMemory(Long l) {
        this.freeMemory = l;
    }

    public void setLowMemory(Boolean bool) {
        this.lowMemory = bool;
    }

    public void setStorageSize(Long l) {
        this.storageSize = l;
    }

    public void setFreeStorage(Long l) {
        this.freeStorage = l;
    }

    public void setExternalStorageSize(Long l) {
        this.externalStorageSize = l;
    }

    public void setExternalFreeStorage(Long l) {
        this.externalFreeStorage = l;
    }

    public void setScreenDensity(Float f) {
        this.screenDensity = f;
    }

    public void setScreenDpi(Integer num) {
        this.screenDpi = num;
    }

    public void setBootTime(Date date) {
        this.bootTime = date;
    }

    public void setTimezone(TimeZone timeZone) {
        this.timezone = timeZone;
    }

    public void setArchs(String[] strArr) {
        this.archs = strArr;
    }

    public void setScreenWidthPixels(Integer num) {
        this.screenWidthPixels = num;
    }

    public void setScreenHeightPixels(Integer num) {
        this.screenHeightPixels = num;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public void setConnectionType(String str) {
        this.connectionType = str;
    }

    public void setBatteryTemperature(Float f) {
        this.batteryTemperature = f;
    }

    public void setProcessorCount(Integer num) {
        this.processorCount = num;
    }

    public void setProcessorFrequency(Double d) {
        this.processorFrequency = d;
    }

    public void setChipset(String str) {
        this.chipset = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Device.class == obj.getClass()) {
            Device device = (Device) obj;
            if (Objects.equals(this.name, device.name) && Objects.equals(this.manufacturer, device.manufacturer) && Objects.equals(this.brand, device.brand) && Objects.equals(this.family, device.family) && Objects.equals(this.model, device.model) && Objects.equals(this.modelId, device.modelId) && Arrays.equals(this.archs, device.archs) && Objects.equals(this.batteryLevel, device.batteryLevel) && Objects.equals(this.charging, device.charging) && Objects.equals(this.online, device.online) && this.orientation == device.orientation && Objects.equals(this.simulator, device.simulator) && Objects.equals(this.memorySize, device.memorySize) && Objects.equals(this.freeMemory, device.freeMemory) && Objects.equals(this.usableMemory, device.usableMemory) && Objects.equals(this.lowMemory, device.lowMemory) && Objects.equals(this.storageSize, device.storageSize) && Objects.equals(this.freeStorage, device.freeStorage) && Objects.equals(this.externalStorageSize, device.externalStorageSize) && Objects.equals(this.externalFreeStorage, device.externalFreeStorage) && Objects.equals(this.screenWidthPixels, device.screenWidthPixels) && Objects.equals(this.screenHeightPixels, device.screenHeightPixels) && Objects.equals(this.screenDensity, device.screenDensity) && Objects.equals(this.screenDpi, device.screenDpi) && Objects.equals(this.bootTime, device.bootTime) && Objects.equals(this.id, device.id) && Objects.equals(this.locale, device.locale) && Objects.equals(this.connectionType, device.connectionType) && Objects.equals(this.batteryTemperature, device.batteryTemperature) && Objects.equals(this.processorCount, device.processorCount) && Objects.equals(this.processorFrequency, device.processorFrequency) && Objects.equals(this.cpuDescription, device.cpuDescription) && Objects.equals(this.chipset, device.chipset)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Objects.hash(this.name, this.manufacturer, this.brand, this.family, this.model, this.modelId, this.batteryLevel, this.charging, this.online, this.orientation, this.simulator, this.memorySize, this.freeMemory, this.usableMemory, this.lowMemory, this.storageSize, this.freeStorage, this.externalStorageSize, this.externalFreeStorage, this.screenWidthPixels, this.screenHeightPixels, this.screenDensity, this.screenDpi, this.bootTime, this.timezone, this.id, this.locale, this.connectionType, this.batteryTemperature, this.processorCount, this.processorFrequency, this.cpuDescription, this.chipset) * 31) + Arrays.hashCode(this.archs);
    }

    public enum DeviceOrientation implements JsonSerializable {
        PORTRAIT,
        LANDSCAPE;

        @Override // io.sentry.JsonSerializable
        public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            objectWriter.value(toString().toLowerCase(Locale.ROOT));
        }

        public static final class Deserializer implements JsonDeserializer {
            @Override // io.sentry.JsonDeserializer
            public DeviceOrientation deserialize(ObjectReader objectReader, ILogger iLogger) {
                return DeviceOrientation.valueOf(objectReader.nextString().toUpperCase(Locale.ROOT));
            }
        }
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.manufacturer != null) {
            objectWriter.name("manufacturer").value(this.manufacturer);
        }
        if (this.brand != null) {
            objectWriter.name("brand").value(this.brand);
        }
        if (this.family != null) {
            objectWriter.name("family").value(this.family);
        }
        if (this.model != null) {
            objectWriter.name("model").value(this.model);
        }
        if (this.modelId != null) {
            objectWriter.name("model_id").value(this.modelId);
        }
        if (this.archs != null) {
            objectWriter.name("archs").value(iLogger, this.archs);
        }
        if (this.batteryLevel != null) {
            objectWriter.name("battery_level").value(this.batteryLevel);
        }
        if (this.charging != null) {
            objectWriter.name("charging").value(this.charging);
        }
        if (this.online != null) {
            objectWriter.name("online").value(this.online);
        }
        if (this.orientation != null) {
            objectWriter.name("orientation").value(iLogger, this.orientation);
        }
        if (this.simulator != null) {
            objectWriter.name("simulator").value(this.simulator);
        }
        if (this.memorySize != null) {
            objectWriter.name("memory_size").value(this.memorySize);
        }
        if (this.freeMemory != null) {
            objectWriter.name("free_memory").value(this.freeMemory);
        }
        if (this.usableMemory != null) {
            objectWriter.name("usable_memory").value(this.usableMemory);
        }
        if (this.lowMemory != null) {
            objectWriter.name("low_memory").value(this.lowMemory);
        }
        if (this.storageSize != null) {
            objectWriter.name("storage_size").value(this.storageSize);
        }
        if (this.freeStorage != null) {
            objectWriter.name("free_storage").value(this.freeStorage);
        }
        if (this.externalStorageSize != null) {
            objectWriter.name("external_storage_size").value(this.externalStorageSize);
        }
        if (this.externalFreeStorage != null) {
            objectWriter.name("external_free_storage").value(this.externalFreeStorage);
        }
        if (this.screenWidthPixels != null) {
            objectWriter.name("screen_width_pixels").value(this.screenWidthPixels);
        }
        if (this.screenHeightPixels != null) {
            objectWriter.name("screen_height_pixels").value(this.screenHeightPixels);
        }
        if (this.screenDensity != null) {
            objectWriter.name("screen_density").value(this.screenDensity);
        }
        if (this.screenDpi != null) {
            objectWriter.name("screen_dpi").value(this.screenDpi);
        }
        if (this.bootTime != null) {
            objectWriter.name("boot_time").value(iLogger, this.bootTime);
        }
        if (this.timezone != null) {
            objectWriter.name("timezone").value(iLogger, this.timezone);
        }
        if (this.id != null) {
            objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
        }
        if (this.connectionType != null) {
            objectWriter.name("connection_type").value(this.connectionType);
        }
        if (this.batteryTemperature != null) {
            objectWriter.name("battery_temperature").value(this.batteryTemperature);
        }
        if (this.locale != null) {
            objectWriter.name("locale").value(this.locale);
        }
        if (this.processorCount != null) {
            objectWriter.name("processor_count").value(this.processorCount);
        }
        if (this.processorFrequency != null) {
            objectWriter.name("processor_frequency").value(this.processorFrequency);
        }
        if (this.cpuDescription != null) {
            objectWriter.name("cpu_description").value(this.cpuDescription);
        }
        if (this.chipset != null) {
            objectWriter.name("chipset").value(this.chipset);
        }
        Map map = this.unknown;
        if (map != null) {
            for (String str : map.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public Device deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Device device = new Device();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "timezone":
                        device.timezone = objectReader.nextTimeZoneOrNull(iLogger);
                        break;
                    case "boot_time":
                        if (objectReader.peek() != JsonToken.STRING) {
                            break;
                        } else {
                            device.bootTime = objectReader.nextDateOrNull(iLogger);
                            break;
                        }
                        break;
                    case "simulator":
                        device.simulator = objectReader.nextBooleanOrNull();
                        break;
                    case "manufacturer":
                        device.manufacturer = objectReader.nextStringOrNull();
                        break;
                    case "processor_count":
                        device.processorCount = objectReader.nextIntegerOrNull();
                        break;
                    case "orientation":
                        device.orientation = (DeviceOrientation) objectReader.nextOrNull(iLogger, new DeviceOrientation.Deserializer());
                        break;
                    case "battery_temperature":
                        device.batteryTemperature = objectReader.nextFloatOrNull();
                        break;
                    case "family":
                        device.family = objectReader.nextStringOrNull();
                        break;
                    case "locale":
                        device.locale = objectReader.nextStringOrNull();
                        break;
                    case "online":
                        device.online = objectReader.nextBooleanOrNull();
                        break;
                    case "battery_level":
                        device.batteryLevel = objectReader.nextFloatOrNull();
                        break;
                    case "model_id":
                        device.modelId = objectReader.nextStringOrNull();
                        break;
                    case "screen_density":
                        device.screenDensity = objectReader.nextFloatOrNull();
                        break;
                    case "screen_dpi":
                        device.screenDpi = objectReader.nextIntegerOrNull();
                        break;
                    case "free_memory":
                        device.freeMemory = objectReader.nextLongOrNull();
                        break;
                    case "id":
                        device.id = objectReader.nextStringOrNull();
                        break;
                    case "name":
                        device.name = objectReader.nextStringOrNull();
                        break;
                    case "low_memory":
                        device.lowMemory = objectReader.nextBooleanOrNull();
                        break;
                    case "archs":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            String[] strArr = new String[list.size()];
                            list.toArray(strArr);
                            device.archs = strArr;
                            break;
                        }
                        break;
                    case "brand":
                        device.brand = objectReader.nextStringOrNull();
                        break;
                    case "model":
                        device.model = objectReader.nextStringOrNull();
                        break;
                    case "cpu_description":
                        device.cpuDescription = objectReader.nextStringOrNull();
                        break;
                    case "processor_frequency":
                        device.processorFrequency = objectReader.nextDoubleOrNull();
                        break;
                    case "connection_type":
                        device.connectionType = objectReader.nextStringOrNull();
                        break;
                    case "chipset":
                        device.chipset = objectReader.nextStringOrNull();
                        break;
                    case "screen_width_pixels":
                        device.screenWidthPixels = objectReader.nextIntegerOrNull();
                        break;
                    case "external_storage_size":
                        device.externalStorageSize = objectReader.nextLongOrNull();
                        break;
                    case "storage_size":
                        device.storageSize = objectReader.nextLongOrNull();
                        break;
                    case "usable_memory":
                        device.usableMemory = objectReader.nextLongOrNull();
                        break;
                    case "memory_size":
                        device.memorySize = objectReader.nextLongOrNull();
                        break;
                    case "charging":
                        device.charging = objectReader.nextBooleanOrNull();
                        break;
                    case "external_free_storage":
                        device.externalFreeStorage = objectReader.nextLongOrNull();
                        break;
                    case "free_storage":
                        device.freeStorage = objectReader.nextLongOrNull();
                        break;
                    case "screen_height_pixels":
                        device.screenHeightPixels = objectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            device.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return device;
        }
    }
}

package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class App implements JsonSerializable {
    private String appBuild;
    private String appIdentifier;
    private String appName;
    private Date appStartTime;
    private String appVersion;
    private String buildType;
    private String deviceAppHash;
    private Boolean inForeground;
    private Boolean isSplitApks;
    private Map permissions;
    private List splitNames;
    private String startType;
    private Map unknown;
    private List viewNames;

    public App() {
    }

    App(App app2) {
        this.appBuild = app2.appBuild;
        this.appIdentifier = app2.appIdentifier;
        this.appName = app2.appName;
        this.appStartTime = app2.appStartTime;
        this.appVersion = app2.appVersion;
        this.buildType = app2.buildType;
        this.deviceAppHash = app2.deviceAppHash;
        this.permissions = CollectionUtils.newConcurrentHashMap(app2.permissions);
        this.inForeground = app2.inForeground;
        this.viewNames = CollectionUtils.newArrayList(app2.viewNames);
        this.startType = app2.startType;
        this.isSplitApks = app2.isSplitApks;
        this.splitNames = app2.splitNames;
        this.unknown = CollectionUtils.newConcurrentHashMap(app2.unknown);
    }

    public void setAppIdentifier(String str) {
        this.appIdentifier = str;
    }

    public void setAppStartTime(Date date) {
        this.appStartTime = date;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    public void setPermissions(Map map) {
        this.permissions = map;
    }

    public Boolean getInForeground() {
        return this.inForeground;
    }

    public void setInForeground(Boolean bool) {
        this.inForeground = bool;
    }

    public void setViewNames(List list) {
        this.viewNames = list;
    }

    public void setStartType(String str) {
        this.startType = str;
    }

    public void setSplitApks(Boolean bool) {
        this.isSplitApks = bool;
    }

    public void setSplitNames(List list) {
        this.splitNames = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && App.class == obj.getClass()) {
            App app2 = (App) obj;
            if (Objects.equals(this.appIdentifier, app2.appIdentifier) && Objects.equals(this.appStartTime, app2.appStartTime) && Objects.equals(this.deviceAppHash, app2.deviceAppHash) && Objects.equals(this.buildType, app2.buildType) && Objects.equals(this.appName, app2.appName) && Objects.equals(this.appVersion, app2.appVersion) && Objects.equals(this.appBuild, app2.appBuild) && Objects.equals(this.permissions, app2.permissions) && Objects.equals(this.inForeground, app2.inForeground) && Objects.equals(this.viewNames, app2.viewNames) && Objects.equals(this.startType, app2.startType) && Objects.equals(this.isSplitApks, app2.isSplitApks) && Objects.equals(this.splitNames, app2.splitNames)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.appIdentifier, this.appStartTime, this.deviceAppHash, this.buildType, this.appName, this.appVersion, this.appBuild, this.permissions, this.inForeground, this.viewNames, this.startType, this.isSplitApks, this.splitNames);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.appIdentifier != null) {
            objectWriter.name("app_identifier").value(this.appIdentifier);
        }
        if (this.appStartTime != null) {
            objectWriter.name("app_start_time").value(iLogger, this.appStartTime);
        }
        if (this.deviceAppHash != null) {
            objectWriter.name("device_app_hash").value(this.deviceAppHash);
        }
        if (this.buildType != null) {
            objectWriter.name("build_type").value(this.buildType);
        }
        if (this.appName != null) {
            objectWriter.name("app_name").value(this.appName);
        }
        if (this.appVersion != null) {
            objectWriter.name("app_version").value(this.appVersion);
        }
        if (this.appBuild != null) {
            objectWriter.name("app_build").value(this.appBuild);
        }
        Map map = this.permissions;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("permissions").value(iLogger, this.permissions);
        }
        if (this.inForeground != null) {
            objectWriter.name("in_foreground").value(this.inForeground);
        }
        if (this.viewNames != null) {
            objectWriter.name("view_names").value(iLogger, this.viewNames);
        }
        if (this.startType != null) {
            objectWriter.name("start_type").value(this.startType);
        }
        if (this.isSplitApks != null) {
            objectWriter.name("is_split_apks").value(this.isSplitApks);
        }
        List list = this.splitNames;
        if (list != null && !list.isEmpty()) {
            objectWriter.name("split_names").value(iLogger, this.splitNames);
        }
        Map map2 = this.unknown;
        if (map2 != null) {
            for (String str : map2.keySet()) {
                objectWriter.name(str).value(iLogger, this.unknown.get(str));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public App deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            App app2 = new App();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "split_names":
                        List list = (List) objectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            app2.setSplitNames(list);
                            break;
                        }
                        break;
                    case "device_app_hash":
                        app2.deviceAppHash = objectReader.nextStringOrNull();
                        break;
                    case "start_type":
                        app2.startType = objectReader.nextStringOrNull();
                        break;
                    case "view_names":
                        List list2 = (List) objectReader.nextObjectOrNull();
                        if (list2 == null) {
                            break;
                        } else {
                            app2.setViewNames(list2);
                            break;
                        }
                        break;
                    case "app_version":
                        app2.appVersion = objectReader.nextStringOrNull();
                        break;
                    case "in_foreground":
                        app2.inForeground = objectReader.nextBooleanOrNull();
                        break;
                    case "build_type":
                        app2.buildType = objectReader.nextStringOrNull();
                        break;
                    case "app_identifier":
                        app2.appIdentifier = objectReader.nextStringOrNull();
                        break;
                    case "app_start_time":
                        app2.appStartTime = objectReader.nextDateOrNull(iLogger);
                        break;
                    case "permissions":
                        app2.permissions = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "app_name":
                        app2.appName = objectReader.nextStringOrNull();
                        break;
                    case "app_build":
                        app2.appBuild = objectReader.nextStringOrNull();
                        break;
                    case "is_split_apks":
                        app2.isSplitApks = objectReader.nextBooleanOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            app2.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return app2;
        }
    }
}

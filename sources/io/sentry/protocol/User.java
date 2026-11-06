package io.sentry.protocol;

import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.ObjectReader;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
public final class User implements JsonSerializable {
    private Map data;
    private String email;
    private Geo geo;
    private String id;
    private String ipAddress;
    private String name;
    private Map unknown;
    private String username;

    public User() {
    }

    public User(User user) {
        this.email = user.email;
        this.username = user.username;
        this.id = user.id;
        this.ipAddress = user.ipAddress;
        this.name = user.name;
        this.geo = user.geo;
        this.data = CollectionUtils.newConcurrentHashMap(user.data);
        this.unknown = CollectionUtils.newConcurrentHashMap(user.unknown);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public void setData(Map map) {
        this.data = CollectionUtils.newConcurrentHashMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && User.class == obj.getClass()) {
            User user = (User) obj;
            if (Objects.equals(this.email, user.email) && Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username) && Objects.equals(this.ipAddress, user.ipAddress)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.email, this.id, this.username, this.ipAddress);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.email != null) {
            objectWriter.name(AuthorizationRequest.Scope.EMAIL).value(this.email);
        }
        if (this.id != null) {
            objectWriter.name(DiagnosticsEntry.ID_KEY).value(this.id);
        }
        if (this.username != null) {
            objectWriter.name("username").value(this.username);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(this.ipAddress);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.geo != null) {
            objectWriter.name("geo");
            this.geo.serialize(objectWriter, iLogger);
        }
        if (this.data != null) {
            objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        }
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

    public static final class Deserializer implements JsonDeserializer {
        @Override // io.sentry.JsonDeserializer
        public User deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            User user = new User();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "username":
                        user.username = objectReader.nextStringOrNull();
                        break;
                    case "id":
                        user.id = objectReader.nextStringOrNull();
                        break;
                    case "geo":
                        user.geo = new Geo.Deserializer().deserialize(objectReader, iLogger);
                        break;
                    case "data":
                        user.data = CollectionUtils.newConcurrentHashMap((Map) objectReader.nextObjectOrNull());
                        break;
                    case "name":
                        user.name = objectReader.nextStringOrNull();
                        break;
                    case "email":
                        user.email = objectReader.nextStringOrNull();
                        break;
                    case "ip_address":
                        user.ipAddress = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            user.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return user;
        }
    }
}

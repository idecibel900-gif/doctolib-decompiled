package io.sentry.protocol;

import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
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
public final class Request implements JsonSerializable {
    private String apiTarget;
    private Long bodySize;
    private String cookies;
    private Object data;
    private Map env;
    private String fragment;
    private Map headers;
    private String method;
    private Map other;
    private String queryString;
    private Map unknown;
    private String url;

    public Request() {
    }

    public Request(Request request) {
        this.url = request.url;
        this.cookies = request.cookies;
        this.method = request.method;
        this.queryString = request.queryString;
        this.headers = CollectionUtils.newConcurrentHashMap(request.headers);
        this.env = CollectionUtils.newConcurrentHashMap(request.env);
        this.other = CollectionUtils.newConcurrentHashMap(request.other);
        this.unknown = CollectionUtils.newConcurrentHashMap(request.unknown);
        this.data = request.data;
        this.fragment = request.fragment;
        this.bodySize = request.bodySize;
        this.apiTarget = request.apiTarget;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Request.class == obj.getClass()) {
            Request request = (Request) obj;
            if (Objects.equals(this.url, request.url) && Objects.equals(this.method, request.method) && Objects.equals(this.queryString, request.queryString) && Objects.equals(this.cookies, request.cookies) && Objects.equals(this.headers, request.headers) && Objects.equals(this.env, request.env) && Objects.equals(this.bodySize, request.bodySize) && Objects.equals(this.fragment, request.fragment) && Objects.equals(this.apiTarget, request.apiTarget)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.url, this.method, this.queryString, this.cookies, this.headers, this.env, this.bodySize, this.fragment, this.apiTarget);
    }

    public void setUnknown(Map map) {
        this.unknown = map;
    }

    @Override // io.sentry.JsonSerializable
    public void serialize(ObjectWriter objectWriter, ILogger iLogger) {
        objectWriter.beginObject();
        if (this.url != null) {
            objectWriter.name("url").value(this.url);
        }
        if (this.method != null) {
            objectWriter.name("method").value(this.method);
        }
        if (this.queryString != null) {
            objectWriter.name("query_string").value(this.queryString);
        }
        if (this.data != null) {
            objectWriter.name(Constants.ScionAnalytics.MessageType.DATA_MESSAGE).value(iLogger, this.data);
        }
        if (this.cookies != null) {
            objectWriter.name("cookies").value(this.cookies);
        }
        if (this.headers != null) {
            objectWriter.name("headers").value(iLogger, this.headers);
        }
        if (this.env != null) {
            objectWriter.name("env").value(iLogger, this.env);
        }
        if (this.other != null) {
            objectWriter.name(PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER).value(iLogger, this.other);
        }
        if (this.fragment != null) {
            objectWriter.name(AuthorizationRequest.ResponseMode.FRAGMENT).value(iLogger, this.fragment);
        }
        if (this.bodySize != null) {
            objectWriter.name("body_size").value(iLogger, this.bodySize);
        }
        if (this.apiTarget != null) {
            objectWriter.name("api_target").value(iLogger, this.apiTarget);
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
        public Request deserialize(ObjectReader objectReader, ILogger iLogger) {
            objectReader.beginObject();
            Request request = new Request();
            ConcurrentHashMap concurrentHashMap = null;
            while (objectReader.peek() == JsonToken.NAME) {
                String strNextName = objectReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "fragment":
                        request.fragment = objectReader.nextStringOrNull();
                        break;
                    case "method":
                        request.method = objectReader.nextStringOrNull();
                        break;
                    case "env":
                        Map map = (Map) objectReader.nextObjectOrNull();
                        if (map == null) {
                            break;
                        } else {
                            request.env = CollectionUtils.newConcurrentHashMap(map);
                            break;
                        }
                        break;
                    case "url":
                        request.url = objectReader.nextStringOrNull();
                        break;
                    case "data":
                        request.data = objectReader.nextObjectOrNull();
                        break;
                    case "other":
                        Map map2 = (Map) objectReader.nextObjectOrNull();
                        if (map2 == null) {
                            break;
                        } else {
                            request.other = CollectionUtils.newConcurrentHashMap(map2);
                            break;
                        }
                        break;
                    case "headers":
                        Map map3 = (Map) objectReader.nextObjectOrNull();
                        if (map3 == null) {
                            break;
                        } else {
                            request.headers = CollectionUtils.newConcurrentHashMap(map3);
                            break;
                        }
                        break;
                    case "cookies":
                        request.cookies = objectReader.nextStringOrNull();
                        break;
                    case "body_size":
                        request.bodySize = objectReader.nextLongOrNull();
                        break;
                    case "query_string":
                        request.queryString = objectReader.nextStringOrNull();
                        break;
                    case "api_target":
                        request.apiTarget = objectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        objectReader.nextUnknown(iLogger, concurrentHashMap, strNextName);
                        break;
                }
            }
            request.setUnknown(concurrentHashMap);
            objectReader.endObject();
            return request;
        }
    }
}

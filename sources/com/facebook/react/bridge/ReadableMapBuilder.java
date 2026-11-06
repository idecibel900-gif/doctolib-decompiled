package com.facebook.react.bridge;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\n\u0010\rJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0012¢\u0006\u0004\b\n\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0016¢\u0006\u0004\b\n\u0010\u0017J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0018¢\u0006\u0004\b\n\u0010\u0019J)\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 ¨\u0006!"}, d2 = {"Lcom/facebook/react/bridge/ReadableMapBuilder;", "", "Lcom/facebook/react/bridge/WritableMap;", "map", "<init>", "(Lcom/facebook/react/bridge/WritableMap;)V", "", SubscriberAttributeKt.JSON_NAME_KEY, "value", "", "put", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/lang/String;I)V", "", "(Ljava/lang/String;Z)V", "", "(Ljava/lang/String;D)V", "", "(Ljava/lang/String;J)V", "putNull", "(Ljava/lang/String;)V", "Lcom/facebook/react/bridge/ReadableMap;", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "Lcom/facebook/react/bridge/ReadableArray;", "(Ljava/lang/String;Lcom/facebook/react/bridge/ReadableArray;)V", "Lkotlin/Function1;", "builder", "putMap", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/facebook/react/bridge/ReadableArrayBuilder;", "putArray", "Lcom/facebook/react/bridge/WritableMap;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableMapBuilder {
    private final WritableMap map;

    public ReadableMapBuilder(WritableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public final void put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putString(key, value);
    }

    public final void put(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putInt(key, value);
    }

    public final void put(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putBoolean(key, value);
    }

    public final void put(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putDouble(key, value);
    }

    public final void put(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putDouble(key, value);
    }

    public final void putNull(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.map.putNull(key);
    }

    public final void put(String key, ReadableMap value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.map.putMap(key, value);
    }

    public final void put(String key, ReadableArray value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.map.putArray(key, value);
    }

    public final void putMap(String key, Function1 builder) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(builder, "builder");
        WritableMap writableMap = this.map;
        WritableMap writableMapCreateMap = Arguments.createMap();
        builder.invoke(new ReadableMapBuilder(writableMapCreateMap));
        writableMap.putMap(key, writableMapCreateMap);
    }

    public final void putArray(String key, Function1 builder) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(builder, "builder");
        WritableMap writableMap = this.map;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        builder.invoke(new ReadableArrayBuilder(writableArrayCreateArray));
        writableMap.putArray(key, writableArrayCreateArray);
    }
}

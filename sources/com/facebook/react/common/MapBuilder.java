package com.facebook.react.common;

import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class MapBuilder {
    public static final MapBuilder INSTANCE = new MapBuilder();

    private MapBuilder() {
    }

    public static final HashMap newHashMap() {
        return new HashMap();
    }

    public static final Map of(Object obj, Object obj2) {
        return MapsKt.hashMapOf(TuplesKt.to(obj, obj2));
    }

    public static final Map of(Object obj, Object obj2, Object obj3, Object obj4) {
        return MapsKt.hashMapOf(TuplesKt.to(obj, obj2), TuplesKt.to(obj3, obj4));
    }

    public static final Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return MapsKt.hashMapOf(TuplesKt.to(obj, obj2), TuplesKt.to(obj3, obj4), TuplesKt.to(obj5, obj6));
    }

    public static final Map of(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        return MapsKt.hashMapOf(TuplesKt.to(obj, obj2), TuplesKt.to(obj3, obj4), TuplesKt.to(obj5, obj6), TuplesKt.to(obj7, obj8), TuplesKt.to(obj9, obj10), TuplesKt.to(obj11, obj12), TuplesKt.to(obj13, obj14));
    }

    public static final Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private final Map map = MapBuilder.newHashMap();
        private boolean underConstruction = true;

        public final Builder put(Object obj, Object obj2) {
            if (!this.underConstruction) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.map.put(obj, obj2);
            return this;
        }

        public final Map build() {
            if (!this.underConstruction) {
                throw new IllegalStateException("Underlying map has already been built");
            }
            this.underConstruction = false;
            return this.map;
        }
    }
}

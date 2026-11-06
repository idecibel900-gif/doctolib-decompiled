package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ReactStylesDiffMap {
    private final ReadableMap backingMap;

    public ReactStylesDiffMap(ReadableMap props) {
        Intrinsics.checkNotNullParameter(props, "props");
        this.backingMap = props;
    }

    public final ReadableMap internal_backingMap() {
        return this.backingMap;
    }

    public final Map toMap() {
        return this.backingMap.toHashMap();
    }

    public final boolean hasKey(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.hasKey(name);
    }

    public final boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name);
    }

    public final boolean getBoolean(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name) ? z : this.backingMap.getBoolean(name);
    }

    public final float getFloat(String name, float f) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name) ? f : (float) this.backingMap.getDouble(name);
    }

    public final int getInt(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.isNull(name) ? i : this.backingMap.getInt(name);
    }

    public final String getString(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.getString(name);
    }

    public String toString() {
        return "{ " + ReactStylesDiffMap.class.getSimpleName() + ": " + this.backingMap + " }";
    }
}

package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscriptStyle {
    public static final Companion Companion = new Companion(null);
    private final float baselineOffsetScale;
    private final float fontScale;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptStyle)) {
            return false;
        }
        SubscriptStyle subscriptStyle = (SubscriptStyle) obj;
        return Float.compare(this.fontScale, subscriptStyle.fontScale) == 0 && Float.compare(this.baselineOffsetScale, subscriptStyle.baselineOffsetScale) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.fontScale) * 31) + Float.hashCode(this.baselineOffsetScale);
    }

    public String toString() {
        return "SubscriptStyle(fontScale=" + this.fontScale + ", baselineOffsetScale=" + this.baselineOffsetScale + ")";
    }

    public SubscriptStyle(float f, float f2) {
        this.fontScale = f;
        this.baselineOffsetScale = f2;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final float getBaselineOffsetScale() {
        return this.baselineOffsetScale;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubscriptStyle fromReadableMap(ReadableMap map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new SubscriptStyle((float) map.getDouble("fontScale"), (float) map.getDouble("baselineOffsetScale"));
        }
    }
}

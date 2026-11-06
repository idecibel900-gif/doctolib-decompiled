package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SuperscriptStyle {
    public static final Companion Companion = new Companion(null);
    private final float baselineOffsetScale;
    private final float fontScale;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuperscriptStyle)) {
            return false;
        }
        SuperscriptStyle superscriptStyle = (SuperscriptStyle) obj;
        return Float.compare(this.fontScale, superscriptStyle.fontScale) == 0 && Float.compare(this.baselineOffsetScale, superscriptStyle.baselineOffsetScale) == 0;
    }

    public int hashCode() {
        return (Float.hashCode(this.fontScale) * 31) + Float.hashCode(this.baselineOffsetScale);
    }

    public String toString() {
        return "SuperscriptStyle(fontScale=" + this.fontScale + ", baselineOffsetScale=" + this.baselineOffsetScale + ")";
    }

    public SuperscriptStyle(float f, float f2) {
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

        public final SuperscriptStyle fromReadableMap(ReadableMap map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new SuperscriptStyle((float) map.getDouble("fontScale"), (float) map.getDouble("baselineOffsetScale"));
        }
    }
}

package com.swmansion.enriched.markdown.styles;

import com.facebook.react.bridge.ReadableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SpoilerStyle {
    public static final Companion Companion = new Companion(null);
    private final int color;
    private final float particleDensity;
    private final float particleSpeed;
    private final float solidBorderRadius;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpoilerStyle)) {
            return false;
        }
        SpoilerStyle spoilerStyle = (SpoilerStyle) obj;
        return this.color == spoilerStyle.color && Float.compare(this.particleDensity, spoilerStyle.particleDensity) == 0 && Float.compare(this.particleSpeed, spoilerStyle.particleSpeed) == 0 && Float.compare(this.solidBorderRadius, spoilerStyle.solidBorderRadius) == 0;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.color) * 31) + Float.hashCode(this.particleDensity)) * 31) + Float.hashCode(this.particleSpeed)) * 31) + Float.hashCode(this.solidBorderRadius);
    }

    public String toString() {
        return "SpoilerStyle(color=" + this.color + ", particleDensity=" + this.particleDensity + ", particleSpeed=" + this.particleSpeed + ", solidBorderRadius=" + this.solidBorderRadius + ")";
    }

    public SpoilerStyle(int i, float f, float f2, float f3) {
        this.color = i;
        this.particleDensity = f;
        this.particleSpeed = f2;
        this.solidBorderRadius = f3;
    }

    public final int getColor() {
        return this.color;
    }

    public final float getParticleDensity() {
        return this.particleDensity;
    }

    public final float getParticleSpeed() {
        return this.particleSpeed;
    }

    public final float getSolidBorderRadius() {
        return this.solidBorderRadius;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpoilerStyle fromReadableMap(ReadableMap map, StyleParser parser) {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(parser, "parser");
            int color = parser.parseColor(map, "color");
            ReadableMap map2 = map.getMap("particles");
            Intrinsics.checkNotNull(map2);
            ReadableMap map3 = map.getMap("solid");
            Intrinsics.checkNotNull(map3);
            return new SpoilerStyle(color, (float) map2.getDouble("density"), (float) map2.getDouble("speed"), (float) map3.getDouble("borderRadius"));
        }
    }
}

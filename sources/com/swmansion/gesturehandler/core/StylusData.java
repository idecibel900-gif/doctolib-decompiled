package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class StylusData {
    public static final Companion Companion = new Companion(null);
    private final double altitudeAngle;
    private final double azimuthAngle;
    private final double pressure;
    private final double tiltX;
    private final double tiltY;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StylusData)) {
            return false;
        }
        StylusData stylusData = (StylusData) obj;
        return Double.compare(this.tiltX, stylusData.tiltX) == 0 && Double.compare(this.tiltY, stylusData.tiltY) == 0 && Double.compare(this.altitudeAngle, stylusData.altitudeAngle) == 0 && Double.compare(this.azimuthAngle, stylusData.azimuthAngle) == 0 && Double.compare(this.pressure, stylusData.pressure) == 0;
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.tiltX) * 31) + Double.hashCode(this.tiltY)) * 31) + Double.hashCode(this.altitudeAngle)) * 31) + Double.hashCode(this.azimuthAngle)) * 31) + Double.hashCode(this.pressure);
    }

    public String toString() {
        return "StylusData(tiltX=" + this.tiltX + ", tiltY=" + this.tiltY + ", altitudeAngle=" + this.altitudeAngle + ", azimuthAngle=" + this.azimuthAngle + ", pressure=" + this.pressure + ")";
    }

    public StylusData(double d, double d2, double d3, double d4, double d5) {
        this.tiltX = d;
        this.tiltY = d2;
        this.altitudeAngle = d3;
        this.azimuthAngle = d4;
        this.pressure = d5;
    }

    public /* synthetic */ StylusData(double d, double d2, double d3, double d4, double d5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3, (i & 8) != 0 ? 0.0d : d4, (i & 16) != 0 ? -1.0d : d5);
    }

    public final double getPressure() {
        return this.pressure;
    }

    public final ReadableMap toReadableMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("tiltX", this.tiltX);
        writableMapCreateMap.putDouble("tiltY", this.tiltY);
        writableMapCreateMap.putDouble("altitudeAngle", this.altitudeAngle);
        writableMapCreateMap.putDouble("azimuthAngle", this.azimuthAngle);
        writableMapCreateMap.putDouble("pressure", this.pressure);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final Pair spherical2tilt(double d, double d2) {
            double dAtan;
            double dAtan2;
            if (d < 1.0E-9d) {
                dAtan = 1.5707963267948966d;
                double d3 = (d2 < 1.0E-9d || Math.abs(d2 - 6.283185307179586d) < 1.0E-9d) ? 1.5707963267948966d : 0.0d;
                double d4 = d2 - 1.5707963267948966d;
                double d5 = Math.abs(d4) < 1.0E-9d ? 1.5707963267948966d : 0.0d;
                double d6 = d2 - 3.141592653589793d;
                dAtan2 = -1.5707963267948966d;
                if (Math.abs(d6) < 1.0E-9d) {
                    d3 = -1.5707963267948966d;
                }
                double d7 = d2 - 4.71238898038469d;
                if (Math.abs(d7) < 1.0E-9d) {
                    d5 = -1.5707963267948966d;
                }
                if (d2 > 1.0E-9d && Math.abs(d4) < 1.0E-9d) {
                    d5 = 1.5707963267948966d;
                    d3 = 1.5707963267948966d;
                }
                if (Math.abs(d4) > 1.0E-9d && Math.abs(d6) < 1.0E-9d) {
                    d5 = 1.5707963267948966d;
                    d3 = -1.5707963267948966d;
                }
                if (Math.abs(d6) > 1.0E-9d && Math.abs(d7) < 1.0E-9d) {
                    d5 = -1.5707963267948966d;
                    d3 = -1.5707963267948966d;
                }
                if (Math.abs(d7) <= 1.0E-9d || Math.abs(d2 - 6.283185307179586d) >= 1.0E-9d) {
                    dAtan2 = d5;
                    dAtan = d3;
                }
            } else {
                double dTan = Math.tan(d);
                dAtan = Math.atan(Math.cos(d2) / dTan);
                dAtan2 = Math.atan(Math.sin(d2) / dTan);
            }
            return new Pair(Double.valueOf(Math.rint(dAtan * 57.29577951308232d)), Double.valueOf(Math.rint(dAtan2 * 57.29577951308232d)));
        }

        public final StylusData fromEvent(MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            double axisValue = 1.5707963267948966d - ((double) event.getAxisValue(25));
            double pressure = event.getPressure(0);
            double orientation = (((double) event.getOrientation(0)) + 1.5707963267948966d) % 6.283185307179586d;
            if (orientation != 0.0d && Math.signum(orientation) != Math.signum(6.283185307179586d)) {
                orientation += 6.283185307179586d;
            }
            double d = orientation;
            Pair pairSpherical2tilt = spherical2tilt(axisValue, d);
            return new StylusData(((Number) pairSpherical2tilt.getFirst()).doubleValue(), ((Number) pairSpherical2tilt.getSecond()).doubleValue(), axisValue, d, pressure);
        }
    }
}

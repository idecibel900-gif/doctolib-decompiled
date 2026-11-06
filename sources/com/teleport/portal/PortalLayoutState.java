package com.teleport.portal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
final class PortalLayoutState {
    public static final Companion Companion = new Companion(null);
    private static final PortalLayoutState EMPTY = new PortalLayoutState(0.0d, 0.0d, 0.0d, 0.0d);
    private final double hostHeight;
    private final double hostWidth;
    private final double offsetX;
    private final double offsetY;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PortalLayoutState)) {
            return false;
        }
        PortalLayoutState portalLayoutState = (PortalLayoutState) obj;
        return Double.compare(this.hostWidth, portalLayoutState.hostWidth) == 0 && Double.compare(this.hostHeight, portalLayoutState.hostHeight) == 0 && Double.compare(this.offsetX, portalLayoutState.offsetX) == 0 && Double.compare(this.offsetY, portalLayoutState.offsetY) == 0;
    }

    public int hashCode() {
        return (((((Double.hashCode(this.hostWidth) * 31) + Double.hashCode(this.hostHeight)) * 31) + Double.hashCode(this.offsetX)) * 31) + Double.hashCode(this.offsetY);
    }

    public String toString() {
        return "PortalLayoutState(hostWidth=" + this.hostWidth + ", hostHeight=" + this.hostHeight + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ")";
    }

    public PortalLayoutState(double d, double d2, double d3, double d4) {
        this.hostWidth = d;
        this.hostHeight = d2;
        this.offsetX = d3;
        this.offsetY = d4;
    }

    public final WritableMap toMap() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putDouble("hostWidth", this.hostWidth);
        writableMapCreateMap.putDouble("hostHeight", this.hostHeight);
        writableMapCreateMap.putDouble("offsetX", this.offsetX);
        writableMapCreateMap.putDouble("offsetY", this.offsetY);
        return writableMapCreateMap;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PortalLayoutState getEMPTY() {
            return PortalLayoutState.EMPTY;
        }
    }
}

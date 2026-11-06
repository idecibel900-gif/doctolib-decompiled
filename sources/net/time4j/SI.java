package net.time4j;

import net.time4j.engine.ChronoUnit;

/* JADX INFO: loaded from: classes5.dex */
public enum SI implements ChronoUnit {
    SECONDS(1.0d),
    NANOSECONDS(1.0E-9d);

    private final double length;

    SI(double d) {
        this.length = d;
    }

    @Override // net.time4j.engine.ChronoUnit
    public double getLength() {
        return this.length;
    }
}

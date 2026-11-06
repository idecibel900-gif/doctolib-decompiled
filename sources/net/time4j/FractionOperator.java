package net.time4j;

import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
final class FractionOperator implements ChronoOperator {
    private final char fraction;
    private final boolean up;

    FractionOperator(char c, boolean z) {
        this.fraction = c;
        this.up = z;
    }

    @Override // net.time4j.engine.ChronoOperator
    public ChronoEntity apply(ChronoEntity chronoEntity) {
        if (this.fraction == '9') {
            return chronoEntity;
        }
        ProportionalElement proportionalElement = PlainTime.NANO_OF_SECOND;
        int iIntValue = ((Integer) chronoEntity.get(proportionalElement)).intValue();
        int iIntValue2 = ((Integer) chronoEntity.getMaximum(proportionalElement)).intValue();
        char c = this.fraction;
        if (c == '3') {
            return chronoEntity.with((ChronoElement) proportionalElement, Math.min(iIntValue2, ((iIntValue / 1000000) * 1000000) + (this.up ? 999999 : 0)));
        }
        if (c == '6') {
            return chronoEntity.with((ChronoElement) proportionalElement, Math.min(iIntValue2, ((iIntValue / 1000) * 1000) + (this.up ? 999 : 0)));
        }
        throw new UnsupportedOperationException("Unknown: " + this.fraction);
    }
}

package net.time4j;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class PlainTime$BigDecimalElementRule$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ BigDecimal m(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}

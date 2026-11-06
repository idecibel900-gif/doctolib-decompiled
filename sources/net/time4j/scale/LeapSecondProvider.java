package net.time4j.scale;

import java.util.Map;
import net.time4j.base.GregorianDate;

/* JADX INFO: loaded from: classes5.dex */
public interface LeapSecondProvider {
    GregorianDate getDateOfExpiration();

    Map getLeapSecondTable();

    boolean supportsNegativeLS();
}

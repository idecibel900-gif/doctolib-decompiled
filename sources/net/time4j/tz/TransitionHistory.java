package net.time4j.tz;

import java.util.List;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;

/* JADX INFO: loaded from: classes5.dex */
public interface TransitionHistory {
    ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime);

    ZonalOffset getInitialOffset();

    ZonalTransition getStartTransition(UnixTime unixTime);

    List getValidOffsets(GregorianDate gregorianDate, WallTime wallTime);

    boolean hasNegativeDST();

    boolean isEmpty();
}

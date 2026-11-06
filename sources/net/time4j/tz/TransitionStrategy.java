package net.time4j.tz;

import net.time4j.base.GregorianDate;
import net.time4j.base.WallTime;

/* JADX INFO: loaded from: classes5.dex */
public interface TransitionStrategy {
    long resolve(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone);

    TransitionStrategy using(OverlapResolver overlapResolver);
}

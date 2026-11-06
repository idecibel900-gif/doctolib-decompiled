package net.time4j.scale;

import net.time4j.base.UnixTime;

/* JADX INFO: loaded from: classes5.dex */
public interface UniversalTime extends UnixTime {
    long getElapsedTime(TimeScale timeScale);

    int getNanosecond(TimeScale timeScale);
}

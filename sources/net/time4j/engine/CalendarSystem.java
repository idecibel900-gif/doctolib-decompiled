package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public interface CalendarSystem {
    long getMaximumSinceUTC();

    long getMinimumSinceUTC();

    long transform(Object obj);

    Object transform(long j);
}

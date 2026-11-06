package net.time4j.scale;

import net.time4j.base.GregorianDate;

/* JADX INFO: loaded from: classes5.dex */
public interface LeapSecondEvent {
    GregorianDate getDate();

    int getShift();
}

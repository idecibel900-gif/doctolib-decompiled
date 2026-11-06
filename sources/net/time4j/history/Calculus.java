package net.time4j.history;

/* JADX INFO: loaded from: classes5.dex */
interface Calculus {
    HistoricDate fromMJD(long j);

    int getMaximumDayOfMonth(HistoricDate historicDate);

    boolean isValid(HistoricDate historicDate);

    long toMJD(HistoricDate historicDate);
}

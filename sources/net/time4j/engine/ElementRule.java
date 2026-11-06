package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public interface ElementRule {
    ChronoElement getChildAtCeiling(Object obj);

    ChronoElement getChildAtFloor(Object obj);

    Object getMaximum(Object obj);

    Object getMinimum(Object obj);

    Object getValue(Object obj);

    boolean isValid(Object obj, Object obj2);

    Object withValue(Object obj, Object obj2, boolean z);
}

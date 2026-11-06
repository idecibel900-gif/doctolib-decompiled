package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public enum FlagElement implements ChronoElement {
    LEAP_SECOND,
    DAYLIGHT_SAVING;

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return (char) 0;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isDateElement() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isLenient() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isTimeElement() {
        return false;
    }

    @Override // net.time4j.engine.ChronoElement
    public Class getType() {
        return Boolean.class;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        boolean zContains = chronoDisplay.contains(this);
        if (zContains == chronoDisplay2.contains(this)) {
            return 0;
        }
        return zContains ? 1 : -1;
    }

    @Override // net.time4j.engine.ChronoElement
    public Boolean getDefaultMinimum() {
        return Boolean.FALSE;
    }

    @Override // net.time4j.engine.ChronoElement
    public Boolean getDefaultMaximum() {
        return Boolean.TRUE;
    }
}

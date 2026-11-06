package net.time4j.engine;

import java.io.Serializable;
import net.time4j.base.UnixTime;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicElement implements ChronoElement, Serializable {
    private final int hash;
    private final int identity;
    private final String name;

    protected ElementRule derive(Chronology chronology) {
        return null;
    }

    protected boolean doEquals(BasicElement basicElement) {
        return true;
    }

    protected ChronoElement getParent() {
        return null;
    }

    @Override // net.time4j.engine.ChronoElement
    public char getSymbol() {
        return (char) 0;
    }

    @Override // net.time4j.engine.ChronoElement
    public boolean isLenient() {
        return false;
    }

    public boolean isLocal() {
        return true;
    }

    protected boolean isSingleton() {
        return false;
    }

    protected BasicElement(String str) {
        if (str.trim().isEmpty()) {
            throw new IllegalArgumentException("Element name is empty or contains only white space.");
        }
        this.name = str;
        int iHashCode = str.hashCode();
        this.hash = iHashCode;
        if (!isSingleton()) {
            iHashCode = -1;
        } else if (iHashCode == -1) {
            iHashCode = ~iHashCode;
        }
        this.identity = iHashCode;
    }

    @Override // net.time4j.engine.ChronoElement
    public final String name() {
        return this.name;
    }

    @Override // java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((Comparable) chronoDisplay.get(this)).compareTo(chronoDisplay2.get(this));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BasicElement basicElement = (BasicElement) obj;
            int i = this.identity;
            if (i == basicElement.identity && (i != -1 || (name().equals(basicElement.name()) && doEquals(basicElement)))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.hash;
    }

    public String toString() {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 32);
        sb.append(name);
        sb.append('@');
        sb.append(this.name);
        return sb.toString();
    }

    protected String getVeto(Chronology chronology) {
        if (!isLocal() || !UnixTime.class.isAssignableFrom(chronology.getChronoType())) {
            return null;
        }
        return "Accessing the local element [" + this.name + "] from a global type requires a timezone.\n- Try to apply a zonal query like \"" + this.name + ".atUTC()\".\n- Or try to first convert the global type to a zonal timestamp: \"moment.toZonalTimestamp(...)\".\n- If used in formatting then consider \"ChronoFormatter.withTimezone(TZID)\".";
    }
}

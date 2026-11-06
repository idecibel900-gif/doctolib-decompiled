package net.time4j.tz.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

/* JADX INFO: loaded from: classes5.dex */
final class EmptyTransitionModel implements TransitionHistory, Serializable {
    private static final long serialVersionUID = 1374714021808040253L;
    private final ZonalOffset offset;

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return null;
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getStartTransition(UnixTime unixTime) {
        return null;
    }

    @Override // net.time4j.tz.TransitionHistory
    public boolean hasNegativeDST() {
        return false;
    }

    @Override // net.time4j.tz.TransitionHistory
    public boolean isEmpty() {
        return true;
    }

    EmptyTransitionModel(ZonalOffset zonalOffset) {
        this.offset = zonalOffset;
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalOffset getInitialOffset() {
        return this.offset;
    }

    @Override // net.time4j.tz.TransitionHistory
    public List getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return Collections.singletonList(this.offset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyTransitionModel) {
            return this.offset.equals(((EmptyTransitionModel) obj).offset);
        }
        return false;
    }

    public int hashCode() {
        return this.offset.hashCode();
    }

    public String toString() {
        return "EmptyTransitionModel=" + this.offset.canonical();
    }
}

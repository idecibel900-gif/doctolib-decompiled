package net.time4j.tz.model;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.List;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

/* JADX INFO: loaded from: classes5.dex */
final class CompositeTransitionModel extends TransitionModel {
    private static final long serialVersionUID = 1749643877954103721L;
    private final transient ArrayTransitionModel arrayModel;
    private transient int hash = 0;
    private final transient ZonalTransition last;
    private final transient RuleBasedTransitionModel ruleModel;
    private final transient int size;

    CompositeTransitionModel(int i, List list, List list2, boolean z, boolean z2) {
        this.size = i;
        ArrayTransitionModel arrayTransitionModel = new ArrayTransitionModel(list, z, z2);
        this.arrayModel = arrayTransitionModel;
        ZonalTransition lastTransition = arrayTransitionModel.getLastTransition();
        this.last = lastTransition;
        this.ruleModel = new RuleBasedTransitionModel(lastTransition, list2, z);
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalOffset getInitialOffset() {
        return this.arrayModel.getInitialOffset();
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getStartTransition(UnixTime unixTime) {
        if (unixTime.getPosixTime() < this.last.getPosixTime()) {
            return this.arrayModel.getStartTransition(unixTime);
        }
        ZonalTransition startTransition = this.ruleModel.getStartTransition(unixTime);
        return startTransition == null ? this.last : startTransition;
    }

    @Override // net.time4j.tz.TransitionHistory
    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return this.arrayModel.getConflictTransition(gregorianDate, wallTime, this.ruleModel);
    }

    @Override // net.time4j.tz.TransitionHistory
    public List getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return this.arrayModel.getValidOffsets(gregorianDate, wallTime, this.ruleModel);
    }

    @Override // net.time4j.tz.TransitionHistory
    public boolean hasNegativeDST() {
        return this.ruleModel.hasNegativeDST() || this.arrayModel.hasNegativeDST();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompositeTransitionModel) {
            CompositeTransitionModel compositeTransitionModel = (CompositeTransitionModel) obj;
            if (this.arrayModel.equals(compositeTransitionModel.arrayModel, this.size, compositeTransitionModel.size) && this.ruleModel.getRules().equals(compositeTransitionModel.ruleModel.getRules())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.hash;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.arrayModel.hashCode(this.size) + (this.ruleModel.getRules().hashCode() * 37);
        this.hash = iHashCode;
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(CompositeTransitionModel.class.getName());
        sb.append("[transition-count=");
        sb.append(this.size);
        sb.append(",hash=");
        sb.append(hashCode());
        sb.append(",last-rules=");
        sb.append(this.ruleModel.getRules());
        sb.append(']');
        return sb.toString();
    }

    void writeTransitions(ObjectOutput objectOutput) {
        this.arrayModel.writeTransitions(this.size, objectOutput);
    }

    List getRules() {
        return this.ruleModel.getRules();
    }

    private Object writeReplace() {
        return new SPX(this, 127);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}

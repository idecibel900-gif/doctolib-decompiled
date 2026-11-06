package net.time4j.history;

import androidx.recyclerview.widget.LinearLayoutManager;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class NewYearStrategy {
    static final NewYearStrategy DEFAULT = new NewYearStrategy(NewYearRule.BEGIN_OF_JANUARY, Integer.MAX_VALUE);
    private static final Comparator STD_ORDER = new NYSComparator();
    private final int lastAnnoDomini;
    private final NewYearRule lastRule;
    private final List strategies;

    NewYearStrategy(NewYearRule newYearRule, int i) {
        this.strategies = Collections.EMPTY_LIST;
        this.lastRule = newYearRule;
        this.lastAnnoDomini = i;
    }

    NewYearStrategy(List list) {
        Collections.sort(list, STD_ORDER);
        Iterator it = list.iterator();
        NewYearStrategy newYearStrategy = null;
        while (it.hasNext()) {
            NewYearStrategy newYearStrategy2 = (NewYearStrategy) it.next();
            if (newYearStrategy == null || newYearStrategy2.lastAnnoDomini != newYearStrategy.lastAnnoDomini) {
                newYearStrategy = newYearStrategy2;
            } else if (newYearStrategy2.lastRule == newYearStrategy.lastRule) {
                it.remove();
            } else {
                throw new IllegalArgumentException("Multiple strategies with overlapping validity range: " + list);
            }
        }
        this.strategies = Collections.unmodifiableList(list);
        this.lastRule = NewYearRule.BEGIN_OF_JANUARY;
        this.lastAnnoDomini = Integer.MAX_VALUE;
    }

    public NewYearStrategy and(NewYearStrategy newYearStrategy) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.strategies);
        if (arrayList.isEmpty()) {
            arrayList.add(this);
        }
        if (newYearStrategy.strategies.isEmpty()) {
            arrayList.add(newYearStrategy);
        } else {
            arrayList.addAll(newYearStrategy.strategies);
        }
        return new NewYearStrategy(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NewYearStrategy) {
            NewYearStrategy newYearStrategy = (NewYearStrategy) obj;
            if (this.strategies.equals(newYearStrategy.strategies) && this.lastRule == newYearStrategy.lastRule && this.lastAnnoDomini == newYearStrategy.lastAnnoDomini) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.strategies.hashCode() * 17) + (this.lastRule.hashCode() * 37) + this.lastAnnoDomini;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.strategies.isEmpty()) {
            sb.append('[');
            sb.append(this.lastRule);
            if (this.lastAnnoDomini != Integer.MAX_VALUE) {
                sb.append("->");
                sb.append(this.lastAnnoDomini);
            }
        } else {
            boolean z = true;
            for (NewYearStrategy newYearStrategy : this.strategies) {
                if (z) {
                    sb.append('[');
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(newYearStrategy.lastRule);
                sb.append("->");
                sb.append(newYearStrategy.lastAnnoDomini);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    HistoricDate newYear(HistoricEra historicEra, int i) {
        return rule(historicEra, i).newYear(historicEra, i);
    }

    NewYearRule rule(HistoricEra historicEra, int i) {
        int iAnnoDomini = historicEra.annoDomini(i);
        int size = this.strategies.size();
        int i2 = LinearLayoutManager.INVALID_OFFSET;
        NewYearRule newYearRule = null;
        for (int i3 = 0; i3 < size; i3++) {
            NewYearStrategy newYearStrategy = (NewYearStrategy) this.strategies.get(i3);
            if (iAnnoDomini >= i2 && iAnnoDomini < newYearStrategy.lastAnnoDomini) {
                return newYearStrategy.lastRule;
            }
            i2 = newYearStrategy.lastAnnoDomini;
            newYearRule = newYearStrategy.lastRule;
        }
        return (iAnnoDomini == i2 && historicEra == HistoricEra.BYZANTINE && newYearRule == NewYearRule.BEGIN_OF_SEPTEMBER) ? newYearRule : this.lastRule;
    }

    int displayedYear(HistoricDate historicDate) {
        int iAnnoDomini = historicDate.getEra().annoDomini(historicDate.getYearOfEra());
        int size = this.strategies.size();
        int i = LinearLayoutManager.INVALID_OFFSET;
        for (int i2 = 0; i2 < size; i2++) {
            NewYearStrategy newYearStrategy = (NewYearStrategy) this.strategies.get(i2);
            if (iAnnoDomini >= i && iAnnoDomini < newYearStrategy.lastAnnoDomini) {
                return newYearStrategy.lastRule.displayedYear(this, historicDate);
            }
            i = newYearStrategy.lastAnnoDomini;
        }
        return this.lastRule.displayedYear(this, historicDate);
    }

    void writeToStream(DataOutput dataOutput) throws IOException {
        int size = this.strategies.size();
        dataOutput.writeInt(size);
        if (size == 0) {
            dataOutput.writeUTF(this.lastRule.name());
            dataOutput.writeInt(this.lastAnnoDomini);
            return;
        }
        for (int i = 0; i < size; i++) {
            NewYearStrategy newYearStrategy = (NewYearStrategy) this.strategies.get(i);
            dataOutput.writeUTF(newYearStrategy.lastRule.name());
            dataOutput.writeInt(newYearStrategy.lastAnnoDomini);
        }
    }

    static NewYearStrategy readFromStream(DataInput dataInput) throws IOException {
        int i = dataInput.readInt();
        if (i == 0) {
            NewYearRule newYearRuleValueOf = NewYearRule.valueOf(dataInput.readUTF());
            int i2 = dataInput.readInt();
            if (i2 == Integer.MAX_VALUE && newYearRuleValueOf == NewYearRule.BEGIN_OF_JANUARY) {
                return DEFAULT;
            }
            return new NewYearStrategy(newYearRuleValueOf, i2);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(new NewYearStrategy(NewYearRule.valueOf(dataInput.readUTF()), dataInput.readInt()));
        }
        return new NewYearStrategy(arrayList);
    }

    private static class NYSComparator implements Comparator {
        private NYSComparator() {
        }

        @Override // java.util.Comparator
        public int compare(NewYearStrategy newYearStrategy, NewYearStrategy newYearStrategy2) {
            if (newYearStrategy.lastAnnoDomini < newYearStrategy2.lastAnnoDomini) {
                return -1;
            }
            return newYearStrategy.lastAnnoDomini > newYearStrategy2.lastAnnoDomini ? 1 : 0;
        }
    }
}

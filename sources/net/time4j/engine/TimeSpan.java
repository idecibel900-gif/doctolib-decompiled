package net.time4j.engine;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface TimeSpan {
    List getTotalLength();

    public static final class Item implements Serializable {
        private static final long serialVersionUID = 1564804888291509484L;
        private final long amount;
        private final Object unit;

        private Item(long j, Object obj) {
            if (obj == null) {
                throw new NullPointerException("Missing chronological unit.");
            }
            if (j < 0) {
                throw new IllegalArgumentException("Temporal amount must be positive or zero: " + j);
            }
            this.amount = j;
            this.unit = obj;
        }

        public static Item of(long j, Object obj) {
            return new Item(j, obj);
        }

        public long getAmount() {
            return this.amount;
        }

        public Object getUnit() {
            return this.unit;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) Item.class.cast(obj);
                if (this.amount == item.amount && this.unit.equals(item.unit)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.unit.hashCode() * 29;
            long j = this.amount;
            return iHashCode + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(this.amount);
            sb.append('{');
            sb.append(this.unit);
            sb.append('}');
            return sb.toString();
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            if (this.unit == null || this.amount < 0) {
                throw new InvalidObjectException("Inconsistent state.");
            }
        }
    }
}

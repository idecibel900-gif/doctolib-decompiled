package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Serializable {
    public static final ConcurrentMap g = new ConcurrentHashMap(4, 0.75f, 2);
    public static final i h;
    private static final long serialVersionUID = -1177360819670808121L;
    public final j$.time.e a;
    public final int b;
    public final transient v c;
    public final transient v d;
    public final transient v e;
    public final transient v f;

    static {
        new w(j$.time.e.MONDAY, 4);
        a(j$.time.e.SUNDAY, 1);
        h = j.d;
    }

    public static w a(j$.time.e eVar, int i) {
        String str = eVar.toString() + i;
        ConcurrentMap concurrentMap = g;
        w wVar = (w) concurrentMap.get(str);
        if (wVar != null) {
            return wVar;
        }
        concurrentMap.putIfAbsent(str, new w(eVar, i));
        return (w) concurrentMap.get(str);
    }

    public w(j$.time.e eVar, int i) {
        b bVar = b.DAYS;
        b bVar2 = b.WEEKS;
        this.c = new v("DayOfWeek", this, bVar, bVar2, v.f);
        this.d = new v("WeekOfMonth", this, bVar2, b.MONTHS, v.g);
        i iVar = j.d;
        this.e = new v("WeekOfWeekBasedYear", this, bVar2, iVar, v.i);
        this.f = new v("WeekBasedYear", this, iVar, b.FOREVER, a.YEAR.b);
        Objects.requireNonNull(eVar, "firstDayOfWeek");
        if (i < 1 || i > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.a = eVar;
        this.b = i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.a == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i = this.b;
        if (i < 1 || i > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return a(this.a, this.b);
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + e.getMessage());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof w) && hashCode() == obj.hashCode();
    }

    public final int hashCode() {
        return (this.a.ordinal() * 7) + this.b;
    }

    public final String toString() {
        return "WeekFields[" + this.a + com.amazon.a.a.o.b.f.a + this.b + "]";
    }
}

package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectQueue implements Iterable, Closeable {

    public interface Converter {
        Object from(byte[] bArr);

        void toStream(Object obj, OutputStream outputStream);
    }

    public abstract void add(Object obj);

    public abstract void remove(int i);

    public abstract int size();

    public static ObjectQueue create(QueueFile queueFile, Converter converter) {
        return new FileObjectQueue(queueFile, converter);
    }

    public static ObjectQueue createEmpty() {
        return new EmptyObjectQueue();
    }

    public List peek(int i) {
        int iMin = Math.min(i, size());
        ArrayList arrayList = new ArrayList(iMin);
        Iterator it = iterator();
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(it.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List asList() {
        return peek(size());
    }

    public void clear() {
        remove(size());
    }
}

package io.sentry.cache.tape;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
final class FileObjectQueue extends ObjectQueue {
    private final DirectByteArrayOutputStream bytes = new DirectByteArrayOutputStream();
    final ObjectQueue.Converter converter;
    private final QueueFile queueFile;

    FileObjectQueue(QueueFile queueFile, ObjectQueue.Converter converter) {
        this.queueFile = queueFile;
        this.converter = converter;
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public int size() {
        return this.queueFile.size();
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public void add(Object obj) throws IOException {
        this.bytes.reset();
        this.converter.toStream(obj, this.bytes);
        this.queueFile.add(this.bytes.getArray(), 0, this.bytes.size());
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public void remove(int i) throws IOException {
        this.queueFile.remove(i);
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public void clear() throws IOException {
        this.queueFile.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.queueFile.close();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new QueueFileIterator(this.queueFile.iterator());
    }

    public String toString() {
        return "FileObjectQueue{queueFile=" + this.queueFile + '}';
    }

    private final class QueueFileIterator implements Iterator {
        final Iterator iterator;

        QueueFileIterator(Iterator it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            try {
                return FileObjectQueue.this.converter.from((byte[]) this.iterator.next());
            } catch (IOException e) {
                throw ((Error) QueueFile.getSneakyThrowable(e));
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    private static final class DirectByteArrayOutputStream extends ByteArrayOutputStream {
        DirectByteArrayOutputStream() {
        }

        byte[] getArray() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }
}

package io.sentry.cache.tape;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class QueueFile implements Closeable, Iterable {
    private static final byte[] ZEROES = new byte[4096];
    boolean closed;
    int elementCount;
    final File file;
    long fileLength;
    Element first;
    private Element last;
    private final int maxElements;
    RandomAccessFile raf;
    private final boolean zero;
    final int headerLength = 32;
    private final byte[] buffer = new byte[32];
    int modCount = 0;

    static RandomAccessFile initializeFromFile(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFileOpen = open(file2);
            try {
                randomAccessFileOpen.setLength(4096L);
                randomAccessFileOpen.seek(0L);
                randomAccessFileOpen.writeInt(-2147483647);
                randomAccessFileOpen.writeLong(4096L);
                randomAccessFileOpen.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFileOpen.close();
                throw th;
            }
        }
        return open(file);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    QueueFile(File file, RandomAccessFile randomAccessFile, boolean z, int i) throws IOException {
        this.file = file;
        this.raf = randomAccessFile;
        this.zero = z;
        this.maxElements = i;
        readInitialData();
    }

    private void readInitialData() throws IOException {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        this.fileLength = readLong(this.buffer, 4);
        this.elementCount = readInt(this.buffer, 12);
        long j = readLong(this.buffer, 16);
        long j2 = readLong(this.buffer, 24);
        if (this.fileLength > this.raf.length()) {
            throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
        }
        if (this.fileLength <= 32) {
            throw new IOException("File is corrupt; length stored in header (" + this.fileLength + ") is invalid.");
        }
        this.first = readElement(j);
        this.last = readElement(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFile() throws IOException {
        this.raf.close();
        this.file.delete();
        this.raf = initializeFromFile(this.file);
        readInitialData();
    }

    private static void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private static void writeLong(byte[] bArr, int i, long j) {
        bArr[i] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) j;
    }

    private static long readLong(byte[] bArr, int i) {
        return ((((long) bArr[i]) & 255) << 56) + ((((long) bArr[i + 1]) & 255) << 48) + ((((long) bArr[i + 2]) & 255) << 40) + ((((long) bArr[i + 3]) & 255) << 32) + ((((long) bArr[i + 4]) & 255) << 24) + ((((long) bArr[i + 5]) & 255) << 16) + ((((long) bArr[i + 6]) & 255) << 8) + (((long) bArr[i + 7]) & 255);
    }

    private void writeHeader(long j, int i, long j2, long j3) throws IOException {
        this.raf.seek(0L);
        writeInt(this.buffer, 0, -2147483647);
        writeLong(this.buffer, 4, j);
        writeInt(this.buffer, 12, i);
        writeLong(this.buffer, 16, j2);
        writeLong(this.buffer, 24, j3);
        this.raf.write(this.buffer, 0, 32);
    }

    Element readElement(long j) {
        if (j == 0) {
            return Element.NULL;
        }
        if (!ringRead(j, this.buffer, 0, 4)) {
            return Element.NULL;
        }
        return new Element(j, readInt(this.buffer, 0));
    }

    long wrapPosition(long j) {
        long j2 = this.fileLength;
        return j < j2 ? j : (j + 32) - j2;
    }

    private void ringWrite(long j, byte[] bArr, int i, int i2) throws IOException {
        long jWrapPosition = wrapPosition(j);
        long j2 = ((long) i2) + jWrapPosition;
        long j3 = this.fileLength;
        if (j2 <= j3) {
            this.raf.seek(jWrapPosition);
            this.raf.write(bArr, i, i2);
            return;
        }
        int i3 = (int) (j3 - jWrapPosition);
        this.raf.seek(jWrapPosition);
        this.raf.write(bArr, i, i3);
        this.raf.seek(32L);
        this.raf.write(bArr, i + i3, i2 - i3);
    }

    private void ringErase(long j, long j2) throws IOException {
        long j3 = j;
        while (j2 > 0) {
            byte[] bArr = ZEROES;
            int iMin = (int) Math.min(j2, bArr.length);
            ringWrite(j3, bArr, 0, iMin);
            long j4 = iMin;
            j2 -= j4;
            j3 += j4;
        }
    }

    boolean ringRead(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            long jWrapPosition = wrapPosition(j);
            long j2 = ((long) i2) + jWrapPosition;
            long j3 = this.fileLength;
            if (j2 <= j3) {
                this.raf.seek(jWrapPosition);
                this.raf.readFully(bArr, i, i2);
                return true;
            }
            int i3 = (int) (j3 - jWrapPosition);
            this.raf.seek(jWrapPosition);
            this.raf.readFully(bArr, i, i3);
            this.raf.seek(32L);
            this.raf.readFully(bArr, i + i3, i2 - i3);
            return true;
        } catch (EOFException unused) {
            resetFile();
            return false;
        } catch (IOException e) {
            throw e;
        } catch (Throwable unused2) {
            resetFile();
            return false;
        }
    }

    public void add(byte[] bArr, int i, int i2) throws IOException {
        long jWrapPosition;
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (isAtFullCapacity()) {
            remove();
        }
        expandIfNecessary(i2);
        boolean zIsEmpty = isEmpty();
        if (zIsEmpty) {
            jWrapPosition = 32;
        } else {
            Element element = this.last;
            jWrapPosition = wrapPosition(element.position + 4 + ((long) element.length));
        }
        Element element2 = new Element(jWrapPosition, i2);
        writeInt(this.buffer, 0, i2);
        ringWrite(element2.position, this.buffer, 0, 4);
        ringWrite(element2.position + 4, bArr, i, i2);
        writeHeader(this.fileLength, this.elementCount + 1, zIsEmpty ? element2.position : this.first.position, element2.position);
        this.last = element2;
        this.elementCount++;
        this.modCount++;
        if (zIsEmpty) {
            this.first = element2;
        }
    }

    private long usedBytes() {
        if (this.elementCount == 0) {
            return 32L;
        }
        Element element = this.last;
        long j = element.position;
        long j2 = this.first.position;
        if (j >= j2) {
            return (j - j2) + 4 + ((long) element.length) + 32;
        }
        return (((j + 4) + ((long) element.length)) + this.fileLength) - j2;
    }

    private long remainingBytes() {
        return this.fileLength - usedBytes();
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    private void expandIfNecessary(long j) throws IOException {
        long j2;
        long j3;
        long j4 = j + 4;
        long jRemainingBytes = remainingBytes();
        if (jRemainingBytes >= j4) {
            return;
        }
        long j5 = this.fileLength;
        do {
            jRemainingBytes += j5;
            j5 <<= 1;
        } while (jRemainingBytes < j4);
        setLength(j5);
        Element element = this.last;
        long jWrapPosition = wrapPosition(element.position + 4 + ((long) element.length));
        if (jWrapPosition <= this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            j2 = jWrapPosition - 32;
            if (channel.transferTo(32L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        } else {
            j2 = 0;
        }
        long j6 = this.last.position;
        long j7 = this.first.position;
        if (j6 < j7) {
            long j8 = (this.fileLength + j6) - 32;
            writeHeader(j5, this.elementCount, j7, j8);
            this.last = new Element(j8, this.last.length);
            j3 = j5;
        } else {
            writeHeader(j5, this.elementCount, j7, j6);
            j3 = j5;
        }
        this.fileLength = j3;
        if (this.zero) {
            ringErase(32L, j2);
        }
    }

    private void setLength(long j) throws IOException {
        this.raf.setLength(j);
        this.raf.getChannel().force(true);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new ElementIterator();
    }

    private final class ElementIterator implements Iterator {
        int expectedModCount;
        int nextElementIndex = 0;
        private long nextElementPosition;

        ElementIterator() {
            this.nextElementPosition = QueueFile.this.first.position;
            this.expectedModCount = QueueFile.this.modCount;
        }

        private void checkForComodification() {
            if (QueueFile.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (QueueFile.this.closed) {
                throw new IllegalStateException("closed");
            }
            checkForComodification();
            return this.nextElementIndex != QueueFile.this.elementCount;
        }

        @Override // java.util.Iterator
        public byte[] next() {
            if (QueueFile.this.closed) {
                throw new IllegalStateException("closed");
            }
            checkForComodification();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            int i = this.nextElementIndex;
            QueueFile queueFile = QueueFile.this;
            if (i >= queueFile.elementCount) {
                throw new NoSuchElementException();
            }
            try {
                try {
                    Element element = queueFile.readElement(this.nextElementPosition);
                    byte[] bArr = new byte[element.length];
                    long jWrapPosition = QueueFile.this.wrapPosition(element.position + 4);
                    this.nextElementPosition = jWrapPosition;
                    if (!QueueFile.this.ringRead(jWrapPosition, bArr, 0, element.length)) {
                        this.nextElementIndex = QueueFile.this.elementCount;
                        return QueueFile.ZEROES;
                    }
                    this.nextElementPosition = QueueFile.this.wrapPosition(element.position + 4 + ((long) element.length));
                    this.nextElementIndex++;
                    return bArr;
                } catch (IOException e) {
                    throw ((Error) QueueFile.getSneakyThrowable(e));
                }
            } catch (IOException e2) {
                throw ((Error) QueueFile.getSneakyThrowable(e2));
            } catch (OutOfMemoryError unused) {
                QueueFile.this.resetFile();
                this.nextElementIndex = QueueFile.this.elementCount;
                return QueueFile.ZEROES;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForComodification();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.nextElementIndex != 1) {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
            try {
                QueueFile.this.remove();
                this.expectedModCount = QueueFile.this.modCount;
                this.nextElementIndex--;
            } catch (IOException e) {
                throw ((Error) QueueFile.getSneakyThrowable(e));
            }
        }
    }

    public int size() {
        return this.elementCount;
    }

    public void remove() throws IOException {
        remove(1);
    }

    public void remove(int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Cannot remove negative (" + i + ") number of elements.");
        }
        if (i == 0) {
            return;
        }
        if (i == this.elementCount) {
            clear();
            return;
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (i > this.elementCount) {
            throw new IllegalArgumentException("Cannot remove more elements (" + i + ") than present in queue (" + this.elementCount + ").");
        }
        Element element = this.first;
        long j = element.position;
        int i2 = element.length;
        long j2 = 0;
        int i3 = 0;
        long j3 = j;
        while (i3 < i) {
            j2 += (long) (i2 + 4);
            long jWrapPosition = wrapPosition(j3 + 4 + ((long) i2));
            if (!ringRead(jWrapPosition, this.buffer, 0, 4)) {
                return;
            }
            i2 = readInt(this.buffer, 0);
            i3++;
            j3 = jWrapPosition;
        }
        writeHeader(this.fileLength, this.elementCount - i, j3, this.last.position);
        this.elementCount -= i;
        this.modCount++;
        this.first = new Element(j3, i2);
        if (this.zero) {
            ringErase(j, j2);
        }
    }

    public void clear() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        writeHeader(4096L, 0, 0L, 0L);
        if (this.zero) {
            this.raf.seek(32L);
            this.raf.write(ZEROES, 0, 4064);
        }
        this.elementCount = 0;
        Element element = Element.NULL;
        this.first = element;
        this.last = element;
        if (this.fileLength > 4096) {
            setLength(4096L);
        }
        this.fileLength = 4096L;
        this.modCount++;
    }

    public boolean isAtFullCapacity() {
        return this.maxElements != -1 && size() == this.maxElements;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.raf.close();
    }

    public String toString() {
        return "QueueFile{file=" + this.file + ", zero=" + this.zero + ", length=" + this.fileLength + ", size=" + this.elementCount + ", first=" + this.first + ", last=" + this.last + '}';
    }

    static final class Element {
        static final Element NULL = new Element(0, 0);
        final int length;
        final long position;

        Element(long j, int i) {
            this.position = j;
            this.length = i;
        }

        public String toString() {
            return Element.class.getSimpleName() + "[position=" + this.position + ", length=" + this.length + "]";
        }
    }

    public static final class Builder {
        final File file;
        boolean zero = true;
        int size = -1;

        public Builder(File file) {
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            this.file = file;
        }

        public Builder size(int i) {
            this.size = i;
            return this;
        }

        public QueueFile build() throws IOException {
            RandomAccessFile randomAccessFileInitializeFromFile = QueueFile.initializeFromFile(this.file);
            try {
                return new QueueFile(this.file, randomAccessFileInitializeFromFile, this.zero, this.size);
            } catch (Throwable th) {
                randomAccessFileInitializeFromFile.close();
                throw th;
            }
        }
    }

    static Throwable getSneakyThrowable(Throwable th) throws Throwable {
        throw th;
    }
}

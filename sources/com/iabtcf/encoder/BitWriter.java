package com.iabtcf.encoder;

import com.iabtcf.utils.Base64;
import com.iabtcf.utils.FieldDefs;
import com.iabtcf.utils.IntIterable;
import com.iabtcf.utils.IntIterator;
import com.iabtcf.utils.PrimitiveIterator;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
class BitWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long DAY_AS_DECISECONDS = 864000;
    private static final long[] LONG_MASKS = new long[65];
    private int bitsRemaining;
    private final OfLongIterable buffer;
    private long pending;
    private int precision;

    public BitWriter() {
        this(0);
    }

    protected void enforcePrecision(int i) {
        if (i <= 0) {
            return;
        }
        for (int i2 = 0; i2 < i / 64; i2++) {
            write(0L, 64);
        }
        write(0L, i % 64);
    }

    public int length() {
        int size = (this.buffer.size() * 64) + (64 - this.bitsRemaining);
        int i = this.precision;
        if (i < 0) {
            i = 0;
        }
        return size + i;
    }

    public String toBase64() {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(toByteArray());
    }

    public byte[] toByteArray() {
        enforcePrecision();
        int i = (71 - this.bitsRemaining) >>> 3;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.buffer.size() * 8) + i);
        PrimitiveIterator.OfLong ofLongLongIterator = this.buffer.longIterator();
        while (ofLongLongIterator.hasNext()) {
            byteBufferAllocate.putLong(ofLongLongIterator.nextLong());
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBufferAllocate.put((byte) (this.pending >>> (56 - (i2 * 8))));
        }
        return byteBufferAllocate.array();
    }

    public void write(boolean z) {
        write(z ? 1L : 0L, 1);
    }

    public void writeDays(Date date, FieldDefs fieldDefs) {
        long time = date.getTime() / 100;
        write(time - (time % DAY_AS_DECISECONDS), fieldDefs);
    }

    public void writeV(long j, FieldDefs fieldDefs) {
        Bounds.checkBounds(j, fieldDefs);
        write(j, fieldDefs);
    }

    static {
        for (int i = 0; i < 64; i++) {
            LONG_MASKS[i] = (1 << i) - 1;
        }
        LONG_MASKS[64] = -1;
    }

    public BitWriter(int i) {
        this.buffer = new OfLongIterable();
        this.bitsRemaining = 64;
        this.pending = 0L;
        this.precision = 0;
        if (i < 0) {
            throw new IllegalArgumentException("precision must be non-negative");
        }
        this.precision = i;
    }

    public void write(boolean z, FieldDefs fieldDefs) {
        write(z);
    }

    private void enforcePrecision() {
        enforcePrecision(this.precision);
        this.precision = 0;
    }

    public void write(String str) {
        for (byte b : str.toUpperCase().getBytes(Charset.forName("US-ASCII"))) {
            writeV(b - 65, FieldDefs.CHAR);
        }
    }

    public void write(String str, FieldDefs fieldDefs) {
        write(str);
    }

    public void write(IntIterable intIterable, FieldDefs fieldDefs) {
        write(intIterable, fieldDefs.getLength());
    }

    public void write(Date date, FieldDefs fieldDefs) {
        write(date.getTime() / 100, fieldDefs);
    }

    public void write(IntIterable intIterable, int i) {
        if (i >= 0) {
            BitWriter bitWriter = new BitWriter(i);
            BitSet bitSet = new BitSet();
            IntIterator intIterator = intIterable.intIterator();
            while (intIterator.hasNext()) {
                int iNextInt = intIterator.nextInt();
                if (iNextInt <= 0) {
                    throw new IndexOutOfBoundsException("invalid index: " + iNextInt);
                }
                if (iNextInt <= i) {
                    bitSet.set(iNextInt - 1);
                }
            }
            for (int i2 = 0; i2 < i; i2++) {
                bitWriter.write(bitSet.get(i2));
            }
            write(bitWriter);
            return;
        }
        throw new IllegalArgumentException("length must be non-negative");
    }

    public void write(Date date) {
        write(date, FieldDefs.TIMESTAMP);
    }

    public void write(long j, FieldDefs fieldDefs) {
        write(j, fieldDefs.getLength());
    }

    public void write(long j, int i) {
        if (i == 0) {
            return;
        }
        if (i >= 0 && i <= 64) {
            long j2 = j & LONG_MASKS[i];
            int i2 = this.bitsRemaining - i;
            this.bitsRemaining = i2;
            this.precision -= i;
            if (i2 > 0) {
                this.pending = (j2 << i2) | this.pending;
                return;
            }
            this.buffer.add(this.pending | (j2 >>> (-i2)));
            int i3 = this.bitsRemaining + 64;
            this.bitsRemaining = i3;
            this.pending = i3 == 64 ? 0L : j2 << i3;
            return;
        }
        throw new IllegalArgumentException("length is invalid: " + i);
    }

    public void write(BitWriter bitWriter) {
        PrimitiveIterator.OfLong ofLongLongIterator = bitWriter.buffer.longIterator();
        while (ofLongLongIterator.hasNext()) {
            write(ofLongLongIterator.nextLong(), 64);
        }
        long j = bitWriter.pending;
        int i = bitWriter.bitsRemaining;
        write(j >>> i, 64 - i);
        enforcePrecision(bitWriter.precision);
    }
}

package com.iabtcf.encoder;

import com.iabtcf.utils.FieldDefs;
import com.iabtcf.utils.IntIterable;
import com.iabtcf.utils.IntIterator;
import java.util.BitSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class VendorFieldEncoder {
    private boolean defaultConsent;
    private boolean emitIsRangeEncoding;
    private boolean emitMaxVendorId;
    private boolean emitRangeEncoding;
    private int maxVendorId;
    private final BitSet vendors;

    public VendorFieldEncoder() {
        this(new BitSet(), 0, false, false, true, true);
    }

    public VendorFieldEncoder add(int i) {
        if (i > 0) {
            this.vendors.set(i - 1);
            return this;
        }
        throw new IndexOutOfBoundsException("vendorId < 1: " + i);
    }

    public BitWriter build() {
        return build(false);
    }

    public BitWriter buildV1() {
        return build(true);
    }

    public VendorFieldEncoder defaultConsent(boolean z) {
        this.defaultConsent = z;
        return this;
    }

    public VendorFieldEncoder emitIsRangeEncoding(boolean z) {
        this.emitIsRangeEncoding = z;
        return this;
    }

    public VendorFieldEncoder emitMaxVendorId(boolean z) {
        this.emitMaxVendorId = z;
        return this;
    }

    public VendorFieldEncoder emitRangeEncoding(boolean z) {
        this.emitRangeEncoding = z;
        return this;
    }

    VendorFieldEncoder setMaxVendorId(int i) {
        this.maxVendorId = i;
        return this;
    }

    public VendorFieldEncoder(VendorFieldEncoder vendorFieldEncoder) {
        BitSet bitSet;
        if (vendorFieldEncoder.vendors.length() == 0) {
            bitSet = new BitSet();
        } else {
            BitSet bitSet2 = vendorFieldEncoder.vendors;
            bitSet = bitSet2.get(0, bitSet2.length());
        }
        this(bitSet, vendorFieldEncoder.maxVendorId, vendorFieldEncoder.defaultConsent, vendorFieldEncoder.emitRangeEncoding, vendorFieldEncoder.emitMaxVendorId, vendorFieldEncoder.emitIsRangeEncoding);
    }

    private BitWriter build(boolean z) {
        BitWriter bitWriter = new BitWriter();
        if (this.vendors.length() == 0) {
            bitWriter.writeV(0L, FieldDefs.CORE_VENDOR_MAX_VENDOR_ID);
            bitWriter.write(false, FieldDefs.CORE_VENDOR_IS_RANGE_ENCODING);
            return bitWriter;
        }
        this.maxVendorId = Math.max(this.vendors.length(), this.maxVendorId);
        BitWriter bitWriter2 = new BitWriter();
        int iNextSetBit = this.vendors.get(0) ? 0 : this.vendors.nextSetBit(0);
        int i = 0;
        while (true) {
            int iNextClearBit = this.vendors.nextClearBit(iNextSetBit);
            if (iNextClearBit - iNextSetBit == 1) {
                bitWriter2.write(false, FieldDefs.CORE_VENDOR_IS_RANGE_ENCODING);
                bitWriter2.writeV(iNextSetBit + 1, FieldDefs.START_OR_ONLY_VENDOR_ID);
            } else {
                bitWriter2.write(true, FieldDefs.CORE_VENDOR_IS_RANGE_ENCODING);
                bitWriter2.writeV(iNextSetBit + 1, FieldDefs.START_OR_ONLY_VENDOR_ID);
                bitWriter2.writeV(iNextClearBit, FieldDefs.END_VENDOR_ID);
            }
            i++;
            iNextSetBit = this.vendors.nextSetBit(iNextClearBit);
            if (iNextSetBit <= 0 || (bitWriter2.length() >= this.vendors.length() && !this.emitRangeEncoding)) {
                break;
            }
        }
        if (this.emitMaxVendorId) {
            bitWriter.writeV(this.maxVendorId, FieldDefs.CORE_VENDOR_MAX_VENDOR_ID);
        }
        if (bitWriter2.length() < this.vendors.length() || this.emitRangeEncoding) {
            if (this.emitIsRangeEncoding) {
                bitWriter.write(true, FieldDefs.IS_A_RANGE);
            }
            if (z) {
                bitWriter.write(this.defaultConsent, FieldDefs.V1_VENDOR_DEFAULT_CONSENT);
            }
            bitWriter.writeV(i, FieldDefs.NUM_ENTRIES);
            bitWriter.write(bitWriter2);
            return bitWriter;
        }
        bitWriter.write(false, FieldDefs.IS_A_RANGE);
        int length = this.vendors.length() % 64;
        if (length == 0) {
            length = 64;
        }
        long[] longArray = this.vendors.toLongArray();
        for (int i2 = 0; i2 < longArray.length - 1; i2++) {
            bitWriter.write(Long.reverse(longArray[i2]), 64);
        }
        bitWriter.write(Long.reverse(longArray[longArray.length - 1]) >>> (64 - length), length);
        bitWriter.enforcePrecision(this.maxVendorId - this.vendors.length());
        return bitWriter;
    }

    public VendorFieldEncoder add(Iterable<Integer> iterable) {
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().intValue());
        }
        return this;
    }

    public VendorFieldEncoder add(int... iArr) {
        for (int i : iArr) {
            add(i);
        }
        return this;
    }

    private VendorFieldEncoder(BitSet bitSet, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        this.vendors = bitSet;
        this.maxVendorId = i;
        this.defaultConsent = z;
        this.emitRangeEncoding = z2;
        this.emitMaxVendorId = z3;
        this.emitIsRangeEncoding = z4;
    }

    public VendorFieldEncoder add(IntIterable intIterable) {
        IntIterator intIterator = intIterable.intIterator();
        while (intIterator.hasNext()) {
            add(intIterator.nextInt());
        }
        return this;
    }
}

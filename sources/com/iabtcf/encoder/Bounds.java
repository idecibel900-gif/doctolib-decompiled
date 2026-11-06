package com.iabtcf.encoder;

import com.iabtcf.encoder.exceptions.ValueOverflowException;
import com.iabtcf.utils.BitSetIntIterable;
import com.iabtcf.utils.FieldDefs;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class Bounds {
    Bounds() {
    }

    public static List<PublisherRestrictionEntry> checkBounds(List<PublisherRestrictionEntry> list) {
        long size = list.size();
        FieldDefs fieldDefs = FieldDefs.CORE_NUM_PUB_RESTRICTION;
        checkBounds(size, (1 << fieldDefs.getLength()) - 1, fieldDefs);
        return list;
    }

    public static BitSetIntIterable.Builder checkBoundsBits(BitSetIntIterable.Builder builder, FieldDefs fieldDefs) {
        checkBounds(builder.max(), fieldDefs.getLength(), fieldDefs);
        return builder;
    }

    public static BitSetIntIterable.Builder checkBounds(BitSetIntIterable.Builder builder, FieldDefs fieldDefs) {
        checkBounds(builder.max(), (1 << fieldDefs.getLength()) - 1, fieldDefs);
        return builder;
    }

    public static int checkBounds(int i, FieldDefs fieldDefs) {
        if (fieldDefs.getLength() <= 32) {
            checkBounds(((long) i) & 4294967295L, fieldDefs);
            return i;
        }
        throw new ValueOverflowException(32L, fieldDefs.getLength());
    }

    public static long checkBounds(long j, FieldDefs fieldDefs) {
        int length = fieldDefs.getLength();
        if (length <= 64) {
            return length == 64 ? j : checkBounds(j, (1 << length) - 1, fieldDefs);
        }
        throw new ValueOverflowException(64L, length);
    }

    private static long checkBounds(long j, long j2, FieldDefs fieldDefs) {
        if (Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) <= 0) {
            return j;
        }
        throw new ValueOverflowException(j, j2, fieldDefs);
    }
}

package com.iabtcf.utils;

import com.iabtcf.utils.function.Function;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CORE_VENDOR_BITRANGE_FIELD' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class FieldDefs {
    private static final /* synthetic */ FieldDefs[] $VALUES;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final FieldDefs AV_IS_RANGE_ENCODING;
    public static final FieldDefs AV_MAX_VENDOR_ID;
    public static final FieldDefs AV_VENDOR_BITRANGE_FIELD;
    public static final FieldDefs CHAR;
    public static final FieldDefs CORE_CMP_ID;
    public static final FieldDefs CORE_CMP_VERSION;
    public static final FieldDefs CORE_CONSENT_LANGUAGE;
    public static final FieldDefs CORE_CONSENT_SCREEN;
    public static final FieldDefs CORE_CREATED;
    public static final FieldDefs CORE_IS_SERVICE_SPECIFIC;
    public static final FieldDefs CORE_LAST_UPDATED;
    public static final FieldDefs CORE_NUM_PUB_RESTRICTION;
    public static final FieldDefs CORE_PUBLISHER_CC;
    public static final FieldDefs CORE_PUB_RESTRICTION_ENTRY;
    public static final FieldDefs CORE_PURPOSES_CONSENT;
    public static final FieldDefs CORE_PURPOSES_LI_TRANSPARENCY;
    public static final FieldDefs CORE_PURPOSE_ONE_TREATMENT;
    public static final FieldDefs CORE_SPECIAL_FEATURE_OPT_INS;
    public static final FieldDefs CORE_TCF_POLICY_VERSION;
    public static final FieldDefs CORE_USE_NON_STANDARD_STOCKS;
    public static final FieldDefs CORE_VENDOR_BITRANGE_FIELD;
    public static final FieldDefs CORE_VENDOR_IS_RANGE_ENCODING;
    public static final FieldDefs CORE_VENDOR_LIST_VERSION;
    public static final FieldDefs CORE_VENDOR_LI_BITRANGE_FIELD;
    public static final FieldDefs CORE_VENDOR_LI_IS_RANGE_ENCODING;
    public static final FieldDefs CORE_VENDOR_LI_MAX_VENDOR_ID;
    public static final FieldDefs CORE_VENDOR_MAX_VENDOR_ID;
    public static final FieldDefs CORE_VERSION;
    public static final FieldDefs DV_IS_RANGE_ENCODING;
    public static final FieldDefs DV_MAX_VENDOR_ID;
    public static final FieldDefs DV_VENDOR_BITRANGE_FIELD;
    public static final FieldDefs END_VENDOR_ID;
    public static final FieldDefs IS_A_RANGE;
    public static final FieldDefs NUM_ENTRIES;
    public static final FieldDefs OOB_SEGMENT_TYPE;
    public static final FieldDefs PPTC_CUSTOM_PURPOSES_CONSENT;
    public static final FieldDefs PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY;
    public static final FieldDefs PPTC_NUM_CUSTOM_PURPOSES;
    public static final FieldDefs PPTC_PUB_PURPOSES_CONSENT;
    public static final FieldDefs PPTC_PUB_PURPOSES_LI_TRANSPARENCY;
    public static final FieldDefs PPTC_SEGMENT_TYPE;
    public static final FieldDefs PURPOSE_ID;
    public static final FieldDefs RESTRICTION_TYPE;
    public static final FieldDefs START_OR_ONLY_VENDOR_ID;
    public static final FieldDefs TIMESTAMP;
    public static final FieldDefs V1_CMP_ID;
    public static final FieldDefs V1_CMP_VERSION;
    public static final FieldDefs V1_CONSENT_LANGUAGE;
    public static final FieldDefs V1_CONSENT_SCREEN;
    public static final FieldDefs V1_CREATED;
    public static final FieldDefs V1_LAST_UPDATED;
    public static final FieldDefs V1_PPC_CUSTOM_PURPOSES_BITFIELD;
    public static final FieldDefs V1_PPC_NUMBER_CUSTOM_PURPOSES;
    public static final FieldDefs V1_PPC_PUBLISHER_PURPOSES_VERSION;
    public static final FieldDefs V1_PPC_STANDARD_PURPOSES_ALLOWED;
    public static final FieldDefs V1_PURPOSES_ALLOW;
    public static final FieldDefs V1_VENDOR_BITRANGE_FIELD;
    public static final FieldDefs V1_VENDOR_DEFAULT_CONSENT;
    public static final FieldDefs V1_VENDOR_IS_RANGE_ENCODING;
    public static final FieldDefs V1_VENDOR_LIST_VERSION;
    public static final FieldDefs V1_VENDOR_MAX_VENDOR_ID;
    public static final FieldDefs V1_VENDOR_NUM_ENTRIES;
    public static final FieldDefs V1_VERSION;
    private volatile boolean isDynamic;
    private volatile boolean isDynamicInit;
    private LengthSupplier length;
    private OffsetSupplier offset;

    private static class BitRangeFieldUtils {
        private BitRangeFieldUtils() {
        }

        public static int calculateBitLength(BitReader bitReader, int i) {
            return bitReader.readBits16(i);
        }

        public static int calculateBitRangeLength(BitReader bitReader, int i, int i2) {
            return !bitReader.readBits1(i) ? calculateBitLength(bitReader, i2) : calculateRangeLength(bitReader, i + 1);
        }

        public static int calculateRangeLength(BitReader bitReader, int i) {
            int bits12 = bitReader.readBits12(i);
            int length = FieldDefs.NUM_ENTRIES.getLength(bitReader) + i;
            for (int i2 = 0; i2 < bits12; i2++) {
                length += FieldDefs.IS_A_RANGE.getLength(bitReader) + FieldDefs.START_OR_ONLY_VENDOR_ID.getLength(bitReader) + (bitReader.readBits1(length) ? FieldDefs.END_VENDOR_ID.getLength(bitReader) : 0);
            }
            return length - i;
        }

        public static LengthSupplier lengthSupplier(final FieldDefs fieldDefs, final FieldDefs fieldDefs2) {
            return new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.BitRangeFieldUtils.1
                @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
                public boolean isDynamic() {
                    return true;
                }

                @Override // com.iabtcf.utils.function.Function
                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(BitRangeFieldUtils.calculateBitRangeLength(bitReader, fieldDefs.getOffset(bitReader), fieldDefs2.getOffset(bitReader)));
                }
            };
        }

        public static LengthSupplier lengthSupplierV1() {
            return new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.BitRangeFieldUtils.2
                @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
                public boolean isDynamic() {
                    return true;
                }

                @Override // com.iabtcf.utils.function.Function
                public Integer apply(BitReader bitReader) {
                    return !bitReader.readBits1(FieldDefs.V1_VENDOR_IS_RANGE_ENCODING.getOffset(bitReader)) ? Integer.valueOf(BitRangeFieldUtils.calculateBitLength(bitReader, FieldDefs.V1_VENDOR_MAX_VENDOR_ID.getOffset(bitReader))) : Integer.valueOf(BitRangeFieldUtils.calculateRangeLength(bitReader, FieldDefs.V1_VENDOR_NUM_ENTRIES.getOffset(bitReader)));
                }
            };
        }
    }

    private interface LengthSupplier extends Function<BitReader, Integer> {
        boolean isDynamic();
    }

    private static abstract class MemoizingFunction implements LengthSupplier, OffsetSupplier, Function<BitReader, Integer> {
        private volatile boolean dynamicInitialized;
        private volatile boolean isDynamic;
        private volatile Integer value;

        private MemoizingFunction() {
            this.dynamicInitialized = false;
            this.isDynamic = false;
        }

        private boolean isDynamicPvt() {
            if (!this.dynamicInitialized) {
                this.isDynamic = isDynamic();
                this.dynamicInitialized = true;
            }
            return this.isDynamic;
        }

        public abstract Integer doCompute(BitReader bitReader);

        @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
        public abstract boolean isDynamic();

        @Override // com.iabtcf.utils.function.Function
        public Integer apply(BitReader bitReader) {
            if (isDynamicPvt()) {
                return doCompute(bitReader);
            }
            if (this.value == null) {
                this.value = doCompute(bitReader);
            }
            return this.value;
        }
    }

    private interface OffsetSupplier extends Function<BitReader, Integer> {
        public static final OffsetSupplier NOT_SUPPORTED = new OffsetSupplier() { // from class: com.iabtcf.utils.FieldDefs.OffsetSupplier.1
            @Override // com.iabtcf.utils.FieldDefs.OffsetSupplier
            public boolean isDynamic() {
                return false;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                throw new UnsupportedOperationException();
            }
        };

        boolean isDynamic();
    }

    private static class PublisherRestrictionUtils {
        private PublisherRestrictionUtils() {
        }

        public static int calculateBitRangelength(BitReader bitReader, int i) {
            int bits12 = bitReader.readBits12(i);
            int length = FieldDefs.CORE_NUM_PUB_RESTRICTION.getLength(bitReader) + i;
            for (int i2 = 0; i2 < bits12; i2++) {
                int length2 = length + FieldDefs.PURPOSE_ID.getLength(bitReader) + FieldDefs.RESTRICTION_TYPE.getLength(bitReader);
                length = length2 + BitRangeFieldUtils.calculateRangeLength(bitReader, length2);
            }
            return length - i;
        }

        public static LengthSupplier lengthSupplier(final FieldDefs fieldDefs) {
            return new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.PublisherRestrictionUtils.1
                @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
                public boolean isDynamic() {
                    return true;
                }

                @Override // com.iabtcf.utils.function.Function
                public Integer apply(BitReader bitReader) {
                    return Integer.valueOf(PublisherRestrictionUtils.calculateBitRangelength(bitReader, fieldDefs.getOffset(bitReader)));
                }
            };
        }
    }

    private FieldDefs(String str, int i, int i2, FieldDefs fieldDefs) {
        super(str, i);
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplierConstant(i2);
        this.offset = offsetSupplierFrom(fieldDefs);
    }

    static LengthSupplier lengthSupplierConstant(final int i) {
        return new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.7
            @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return false;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                return Integer.valueOf(i);
            }
        };
    }

    static OffsetSupplier offsetSupplierConstant(final int i) {
        return new OffsetSupplier() { // from class: com.iabtcf.utils.FieldDefs.4
            @Override // com.iabtcf.utils.FieldDefs.OffsetSupplier
            public boolean isDynamic() {
                return false;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                return Integer.valueOf(i);
            }
        };
    }

    static OffsetSupplier offsetSupplierFrom(FieldDefs fieldDefs) {
        return new MemoizingFunction() { // from class: com.iabtcf.utils.FieldDefs.5
            {
                super();
            }

            @Override // com.iabtcf.utils.FieldDefs.MemoizingFunction
            public Integer doCompute(BitReader bitReader) {
                return Integer.valueOf(FieldDefs.this.getLength(bitReader) + FieldDefs.this.getOffset(bitReader));
            }

            @Override // com.iabtcf.utils.FieldDefs.MemoizingFunction, com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return FieldDefs.this.isDynamic();
            }
        };
    }

    static OffsetSupplier offsetSupplierFromPrevious(FieldDefs fieldDefs) {
        return new MemoizingFunction() { // from class: com.iabtcf.utils.FieldDefs.6
            {
                super();
            }

            @Override // com.iabtcf.utils.FieldDefs.MemoizingFunction
            public Integer doCompute(BitReader bitReader) {
                FieldDefs fieldDefs2 = FieldDefs.values()[FieldDefs.this.ordinal() - 1];
                return Integer.valueOf(fieldDefs2.getLength(bitReader) + fieldDefs2.getOffset(bitReader));
            }

            @Override // com.iabtcf.utils.FieldDefs.MemoizingFunction, com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return FieldDefs.values()[FieldDefs.this.ordinal() - 1].isDynamic();
            }
        };
    }

    public static FieldDefs valueOf(String str) {
        return (FieldDefs) Enum.valueOf(FieldDefs.class, str);
    }

    public static FieldDefs[] values() {
        return (FieldDefs[]) $VALUES.clone();
    }

    public int getEnd(BitReader bitReader) {
        return getLength(bitReader) + getOffset(bitReader);
    }

    public int getOffset(BitReader bitReader) {
        return bitReader.cache.getOffset(this, this.offset).intValue();
    }

    protected boolean isDynamic() {
        if (!this.isDynamicInit) {
            this.isDynamic = this.offset.isDynamic() || this.length.isDynamic();
            this.isDynamicInit = true;
        }
        return this.isDynamic;
    }

    static {
        FieldDefs fieldDefs = new FieldDefs("CORE_VERSION", 0, 6, 0);
        CORE_VERSION = fieldDefs;
        FieldDefs fieldDefs2 = new FieldDefs("CORE_CREATED", 1, 36);
        CORE_CREATED = fieldDefs2;
        FieldDefs fieldDefs3 = new FieldDefs("CORE_LAST_UPDATED", 2, 36);
        CORE_LAST_UPDATED = fieldDefs3;
        FieldDefs fieldDefs4 = new FieldDefs("CORE_CMP_ID", 3, 12);
        CORE_CMP_ID = fieldDefs4;
        FieldDefs fieldDefs5 = new FieldDefs("CORE_CMP_VERSION", 4, 12);
        CORE_CMP_VERSION = fieldDefs5;
        FieldDefs fieldDefs6 = new FieldDefs("CORE_CONSENT_SCREEN", 5, 6);
        CORE_CONSENT_SCREEN = fieldDefs6;
        FieldDefs fieldDefs7 = new FieldDefs("CORE_CONSENT_LANGUAGE", 6, 12);
        CORE_CONSENT_LANGUAGE = fieldDefs7;
        FieldDefs fieldDefs8 = new FieldDefs("CORE_VENDOR_LIST_VERSION", 7, 12);
        CORE_VENDOR_LIST_VERSION = fieldDefs8;
        FieldDefs fieldDefs9 = new FieldDefs("CORE_TCF_POLICY_VERSION", 8, 6);
        CORE_TCF_POLICY_VERSION = fieldDefs9;
        FieldDefs fieldDefs10 = new FieldDefs("CORE_IS_SERVICE_SPECIFIC", 9, 1);
        CORE_IS_SERVICE_SPECIFIC = fieldDefs10;
        FieldDefs fieldDefs11 = new FieldDefs("CORE_USE_NON_STANDARD_STOCKS", 10, 1);
        CORE_USE_NON_STANDARD_STOCKS = fieldDefs11;
        FieldDefs fieldDefs12 = new FieldDefs("CORE_SPECIAL_FEATURE_OPT_INS", 11, 12);
        CORE_SPECIAL_FEATURE_OPT_INS = fieldDefs12;
        FieldDefs fieldDefs13 = new FieldDefs("CORE_PURPOSES_CONSENT", 12, 24);
        CORE_PURPOSES_CONSENT = fieldDefs13;
        FieldDefs fieldDefs14 = new FieldDefs("CORE_PURPOSES_LI_TRANSPARENCY", 13, 24);
        CORE_PURPOSES_LI_TRANSPARENCY = fieldDefs14;
        FieldDefs fieldDefs15 = new FieldDefs("CORE_PURPOSE_ONE_TREATMENT", 14, 1);
        CORE_PURPOSE_ONE_TREATMENT = fieldDefs15;
        FieldDefs fieldDefs16 = new FieldDefs("CORE_PUBLISHER_CC", 15, 12);
        CORE_PUBLISHER_CC = fieldDefs16;
        FieldDefs fieldDefs17 = new FieldDefs("CORE_VENDOR_MAX_VENDOR_ID", 16, 16);
        CORE_VENDOR_MAX_VENDOR_ID = fieldDefs17;
        FieldDefs fieldDefs18 = new FieldDefs("CORE_VENDOR_IS_RANGE_ENCODING", 17, 1);
        CORE_VENDOR_IS_RANGE_ENCODING = fieldDefs18;
        FieldDefs fieldDefs19 = new FieldDefs("CORE_VENDOR_BITRANGE_FIELD", 18, BitRangeFieldUtils.lengthSupplier(fieldDefs18, fieldDefs17));
        CORE_VENDOR_BITRANGE_FIELD = fieldDefs19;
        FieldDefs fieldDefs20 = new FieldDefs("CORE_VENDOR_LI_MAX_VENDOR_ID", 19, 16);
        CORE_VENDOR_LI_MAX_VENDOR_ID = fieldDefs20;
        FieldDefs fieldDefs21 = new FieldDefs("CORE_VENDOR_LI_IS_RANGE_ENCODING", 20, 1);
        CORE_VENDOR_LI_IS_RANGE_ENCODING = fieldDefs21;
        FieldDefs fieldDefs22 = new FieldDefs("CORE_VENDOR_LI_BITRANGE_FIELD", 21, BitRangeFieldUtils.lengthSupplier(fieldDefs21, fieldDefs20));
        CORE_VENDOR_LI_BITRANGE_FIELD = fieldDefs22;
        FieldDefs fieldDefs23 = new FieldDefs("CORE_NUM_PUB_RESTRICTION", 22, 12);
        CORE_NUM_PUB_RESTRICTION = fieldDefs23;
        FieldDefs fieldDefs24 = new FieldDefs("CORE_PUB_RESTRICTION_ENTRY", 23, PublisherRestrictionUtils.lengthSupplier(fieldDefs23));
        CORE_PUB_RESTRICTION_ENTRY = fieldDefs24;
        FieldDefs fieldDefs25 = new FieldDefs("OOB_SEGMENT_TYPE", 24, 3, 0);
        OOB_SEGMENT_TYPE = fieldDefs25;
        FieldDefs fieldDefs26 = new FieldDefs("DV_MAX_VENDOR_ID", 25, 16, fieldDefs25);
        DV_MAX_VENDOR_ID = fieldDefs26;
        FieldDefs fieldDefs27 = new FieldDefs("DV_IS_RANGE_ENCODING", 26, 1);
        DV_IS_RANGE_ENCODING = fieldDefs27;
        FieldDefs fieldDefs28 = new FieldDefs("DV_VENDOR_BITRANGE_FIELD", 27, BitRangeFieldUtils.lengthSupplier(fieldDefs27, fieldDefs26));
        DV_VENDOR_BITRANGE_FIELD = fieldDefs28;
        FieldDefs fieldDefs29 = new FieldDefs("AV_MAX_VENDOR_ID", 28, 16, fieldDefs25);
        AV_MAX_VENDOR_ID = fieldDefs29;
        FieldDefs fieldDefs30 = new FieldDefs("AV_IS_RANGE_ENCODING", 29, 1);
        AV_IS_RANGE_ENCODING = fieldDefs30;
        FieldDefs fieldDefs31 = new FieldDefs("AV_VENDOR_BITRANGE_FIELD", 30, BitRangeFieldUtils.lengthSupplier(fieldDefs30, fieldDefs29));
        AV_VENDOR_BITRANGE_FIELD = fieldDefs31;
        FieldDefs fieldDefs32 = new FieldDefs("PPTC_SEGMENT_TYPE", 31, 3, 0);
        PPTC_SEGMENT_TYPE = fieldDefs32;
        FieldDefs fieldDefs33 = new FieldDefs("PPTC_PUB_PURPOSES_CONSENT", 32, 24);
        PPTC_PUB_PURPOSES_CONSENT = fieldDefs33;
        FieldDefs fieldDefs34 = new FieldDefs("PPTC_PUB_PURPOSES_LI_TRANSPARENCY", 33, 24);
        PPTC_PUB_PURPOSES_LI_TRANSPARENCY = fieldDefs34;
        FieldDefs fieldDefs35 = new FieldDefs("PPTC_NUM_CUSTOM_PURPOSES", 34, 6);
        PPTC_NUM_CUSTOM_PURPOSES = fieldDefs35;
        FieldDefs fieldDefs36 = new FieldDefs("PPTC_CUSTOM_PURPOSES_CONSENT", 35, new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.1
            @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return true;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                return Integer.valueOf(bitReader.readBits6(FieldDefs.PPTC_NUM_CUSTOM_PURPOSES.getOffset(bitReader)));
            }
        });
        PPTC_CUSTOM_PURPOSES_CONSENT = fieldDefs36;
        FieldDefs fieldDefs37 = new FieldDefs("PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY", 36, new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.2
            @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return true;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                return Integer.valueOf(FieldDefs.PPTC_CUSTOM_PURPOSES_CONSENT.getLength(bitReader));
            }
        });
        PPTC_CUSTOM_PURPOSES_LI_TRANSPARENCY = fieldDefs37;
        OffsetSupplier offsetSupplier = OffsetSupplier.NOT_SUPPORTED;
        FieldDefs fieldDefs38 = new FieldDefs("NUM_ENTRIES", 37, 12, offsetSupplier);
        NUM_ENTRIES = fieldDefs38;
        FieldDefs fieldDefs39 = new FieldDefs("IS_A_RANGE", 38, 1, offsetSupplier);
        IS_A_RANGE = fieldDefs39;
        FieldDefs fieldDefs40 = new FieldDefs("START_OR_ONLY_VENDOR_ID", 39, 16, offsetSupplier);
        START_OR_ONLY_VENDOR_ID = fieldDefs40;
        FieldDefs fieldDefs41 = new FieldDefs("END_VENDOR_ID", 40, 16, offsetSupplier);
        END_VENDOR_ID = fieldDefs41;
        FieldDefs fieldDefs42 = new FieldDefs("TIMESTAMP", 41, 36, offsetSupplier);
        TIMESTAMP = fieldDefs42;
        FieldDefs fieldDefs43 = new FieldDefs("PURPOSE_ID", 42, 6, offsetSupplier);
        PURPOSE_ID = fieldDefs43;
        FieldDefs fieldDefs44 = new FieldDefs("RESTRICTION_TYPE", 43, 2, offsetSupplier);
        RESTRICTION_TYPE = fieldDefs44;
        FieldDefs fieldDefs45 = new FieldDefs("CHAR", 44, 6, offsetSupplier);
        CHAR = fieldDefs45;
        FieldDefs fieldDefs46 = new FieldDefs("V1_VERSION", 45, 6, 0);
        V1_VERSION = fieldDefs46;
        FieldDefs fieldDefs47 = new FieldDefs("V1_CREATED", 46, 36);
        V1_CREATED = fieldDefs47;
        FieldDefs fieldDefs48 = new FieldDefs("V1_LAST_UPDATED", 47, 36);
        V1_LAST_UPDATED = fieldDefs48;
        FieldDefs fieldDefs49 = new FieldDefs("V1_CMP_ID", 48, 12);
        V1_CMP_ID = fieldDefs49;
        FieldDefs fieldDefs50 = new FieldDefs("V1_CMP_VERSION", 49, 12);
        V1_CMP_VERSION = fieldDefs50;
        FieldDefs fieldDefs51 = new FieldDefs("V1_CONSENT_SCREEN", 50, 6);
        V1_CONSENT_SCREEN = fieldDefs51;
        FieldDefs fieldDefs52 = new FieldDefs("V1_CONSENT_LANGUAGE", 51, 12);
        V1_CONSENT_LANGUAGE = fieldDefs52;
        FieldDefs fieldDefs53 = new FieldDefs("V1_VENDOR_LIST_VERSION", 52, 12);
        V1_VENDOR_LIST_VERSION = fieldDefs53;
        FieldDefs fieldDefs54 = new FieldDefs("V1_PURPOSES_ALLOW", 53, 24);
        V1_PURPOSES_ALLOW = fieldDefs54;
        FieldDefs fieldDefs55 = new FieldDefs("V1_VENDOR_MAX_VENDOR_ID", 54, 16);
        V1_VENDOR_MAX_VENDOR_ID = fieldDefs55;
        FieldDefs fieldDefs56 = new FieldDefs("V1_VENDOR_IS_RANGE_ENCODING", 55, 1);
        V1_VENDOR_IS_RANGE_ENCODING = fieldDefs56;
        FieldDefs fieldDefs57 = new FieldDefs("V1_VENDOR_BITRANGE_FIELD", 56, BitRangeFieldUtils.lengthSupplierV1());
        V1_VENDOR_BITRANGE_FIELD = fieldDefs57;
        FieldDefs fieldDefs58 = new FieldDefs("V1_VENDOR_DEFAULT_CONSENT", 57, 1, fieldDefs56);
        V1_VENDOR_DEFAULT_CONSENT = fieldDefs58;
        FieldDefs fieldDefs59 = new FieldDefs("V1_VENDOR_NUM_ENTRIES", 58, 12);
        V1_VENDOR_NUM_ENTRIES = fieldDefs59;
        FieldDefs fieldDefs60 = new FieldDefs("V1_PPC_PUBLISHER_PURPOSES_VERSION", 59, 12, fieldDefs53);
        V1_PPC_PUBLISHER_PURPOSES_VERSION = fieldDefs60;
        FieldDefs fieldDefs61 = new FieldDefs("V1_PPC_STANDARD_PURPOSES_ALLOWED", 60, 24);
        V1_PPC_STANDARD_PURPOSES_ALLOWED = fieldDefs61;
        FieldDefs fieldDefs62 = new FieldDefs("V1_PPC_NUMBER_CUSTOM_PURPOSES", 61, 6);
        V1_PPC_NUMBER_CUSTOM_PURPOSES = fieldDefs62;
        FieldDefs fieldDefs63 = new FieldDefs("V1_PPC_CUSTOM_PURPOSES_BITFIELD", 62, new LengthSupplier() { // from class: com.iabtcf.utils.FieldDefs.3
            @Override // com.iabtcf.utils.FieldDefs.LengthSupplier
            public boolean isDynamic() {
                return true;
            }

            @Override // com.iabtcf.utils.function.Function
            public Integer apply(BitReader bitReader) {
                return Integer.valueOf(Byte.toUnsignedInt(bitReader.readBits6(FieldDefs.V1_PPC_NUMBER_CUSTOM_PURPOSES.getOffset(bitReader))));
            }
        });
        V1_PPC_CUSTOM_PURPOSES_BITFIELD = fieldDefs63;
        $VALUES = new FieldDefs[]{fieldDefs, fieldDefs2, fieldDefs3, fieldDefs4, fieldDefs5, fieldDefs6, fieldDefs7, fieldDefs8, fieldDefs9, fieldDefs10, fieldDefs11, fieldDefs12, fieldDefs13, fieldDefs14, fieldDefs15, fieldDefs16, fieldDefs17, fieldDefs18, fieldDefs19, fieldDefs20, fieldDefs21, fieldDefs22, fieldDefs23, fieldDefs24, fieldDefs25, fieldDefs26, fieldDefs27, fieldDefs28, fieldDefs29, fieldDefs30, fieldDefs31, fieldDefs32, fieldDefs33, fieldDefs34, fieldDefs35, fieldDefs36, fieldDefs37, fieldDefs38, fieldDefs39, fieldDefs40, fieldDefs41, fieldDefs42, fieldDefs43, fieldDefs44, fieldDefs45, fieldDefs46, fieldDefs47, fieldDefs48, fieldDefs49, fieldDefs50, fieldDefs51, fieldDefs52, fieldDefs53, fieldDefs54, fieldDefs55, fieldDefs56, fieldDefs57, fieldDefs58, fieldDefs59, fieldDefs60, fieldDefs61, fieldDefs62, fieldDefs63};
    }

    public int getLength() {
        return this.length.apply(null).intValue();
    }

    public int getLength(BitReader bitReader) {
        return bitReader.cache.getLength(this, this.length).intValue();
    }

    private FieldDefs(String str, int i, int i2, OffsetSupplier offsetSupplier) {
        super(str, i);
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplierConstant(i2);
        this.offset = offsetSupplier;
    }

    private FieldDefs(String str, int i, int i2, int i3) {
        super(str, i);
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplierConstant(i2);
        this.offset = offsetSupplierConstant(i3);
    }

    private FieldDefs(String str, int i, LengthSupplier lengthSupplier) {
        super(str, i);
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplier;
        this.offset = offsetSupplierFromPrevious(this);
    }

    private FieldDefs(String str, int i, int i2) {
        super(str, i);
        this.isDynamic = false;
        this.isDynamicInit = false;
        this.length = lengthSupplierConstant(i2);
        this.offset = offsetSupplierFromPrevious(this);
    }
}

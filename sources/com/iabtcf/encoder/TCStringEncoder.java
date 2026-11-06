package com.iabtcf.encoder;

import com.iabtcf.decoder.DecoderOption;
import com.iabtcf.decoder.TCString;
import com.iabtcf.encoder.exceptions.ValueOverflowException;
import com.iabtcf.utils.BitSetIntIterable;
import com.iabtcf.utils.FieldDefs;
import com.iabtcf.utils.IntIterable;
import com.iabtcf.utils.Objects;
import com.iabtcf.v2.SegmentType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface TCStringEncoder {

    /* JADX INFO: renamed from: com.iabtcf.encoder.TCStringEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$iabtcf$v2$SegmentType;

        static {
            int[] iArr = new int[SegmentType.values().length];
            $SwitchMap$com$iabtcf$v2$SegmentType = iArr;
            try {
                iArr[SegmentType.DISCLOSED_VENDOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iabtcf$v2$SegmentType[SegmentType.ALLOWED_VENDOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class Builder implements TCStringEncoder {
        private BitSetIntIterable.Builder allowedVendors;
        private int cmpId;
        private int cmpVersion;
        private String consentLanguage;
        private int consentScreen;
        private Date created;
        private BitSetIntIterable.Builder customPurposesConsent;
        private BitSetIntIterable.Builder customPurposesLITransparency;
        private boolean defaultConsent;
        private BitSetIntIterable.Builder disclosedVendors;
        private boolean isServiceSpecific;
        private BitSetIntIterable.Builder pubPurposesConsent;
        private BitSetIntIterable.Builder pubPurposesLITransparency;
        private String publisherCC;
        private final List<PublisherRestrictionEntry> publisherRestrictions;
        private boolean purposeOneTreatment;
        private BitSetIntIterable.Builder purposesConsent;
        private BitSetIntIterable.Builder purposesLITransparency;
        private BitSetIntIterable.Builder specialFeatureOptIns;
        private int tcfPolicyVersion;
        private Date updated;
        private boolean useNonStandardStacks;
        private BitSetIntIterable.Builder vendorConsent;
        private BitSetIntIterable.Builder vendorLegitimateInterest;
        private int vendorListVersion;
        private int version;

        /* synthetic */ Builder(Builder builder, AnonymousClass1 anonymousClass1) {
            this(builder);
        }

        private String validateString(String str, FieldDefs fieldDefs) {
            if (str.length() == fieldDefs.getLength() / FieldDefs.CHAR.getLength()) {
                return str.toUpperCase();
            }
            throw new IllegalArgumentException(str + " must be length 2 but is " + str.length());
        }

        private int validateVersion(int i) {
            if (i >= 1 && i <= 2) {
                return i;
            }
            throw new IllegalArgumentException(i + " not supported");
        }

        public Builder addAllowedVendors(int i) {
            this.allowedVendors.add(i);
            return this;
        }

        public Builder addCustomPurposesConsent(int i) {
            this.customPurposesConsent.add(i);
            return this;
        }

        public Builder addCustomPurposesLITransparency(int i) {
            this.customPurposesLITransparency.add(i);
            return this;
        }

        public Builder addDisclosedVendors(int i) {
            this.disclosedVendors.add(i);
            return this;
        }

        public Builder addPubPurposesConsent(int i) {
            this.pubPurposesConsent.add(i);
            return this;
        }

        public Builder addPubPurposesLITransparency(int i) {
            this.pubPurposesLITransparency.add(i);
            return this;
        }

        public Builder addPublisherRestrictionEntry(PublisherRestrictionEntry publisherRestrictionEntry) {
            this.publisherRestrictions.add(publisherRestrictionEntry);
            return this;
        }

        public Builder addPurposesConsent(int i) {
            this.purposesConsent.add(i);
            return this;
        }

        public Builder addPurposesLITransparency(int i) {
            this.purposesLITransparency.add(i);
            return this;
        }

        public Builder addSpecialFeatureOptIns(int i) {
            this.specialFeatureOptIns.add(i);
            return this;
        }

        public Builder addVendorConsent(int i) {
            this.vendorConsent.add(i);
            return this;
        }

        public Builder addVendorLegitimateInterest(int i) {
            this.vendorLegitimateInterest.add(i);
            return this;
        }

        public Builder clearAllowedVendors() {
            this.allowedVendors.clear();
            return this;
        }

        public Builder clearCustomPurposesConsent() {
            this.customPurposesConsent.clear();
            return this;
        }

        public Builder clearCustomPurposesLITransparency() {
            this.customPurposesLITransparency.clear();
            return this;
        }

        public Builder clearDisclosedVendors() {
            this.disclosedVendors.clear();
            return this;
        }

        public Builder clearPubPurposesConsent() {
            this.pubPurposesConsent.clear();
            return this;
        }

        public Builder clearPubPurposesLITransparency() {
            this.pubPurposesLITransparency.clear();
            return this;
        }

        public Builder clearPublisherRestrictionEntry() {
            this.publisherRestrictions.clear();
            return this;
        }

        public Builder clearPurposesConsent() {
            this.purposesConsent.clear();
            return this;
        }

        public Builder clearPurposesLITransparency() {
            this.purposesLITransparency.clear();
            return this;
        }

        public Builder clearSpecialFeatureOptIns() {
            this.specialFeatureOptIns.clear();
            return this;
        }

        public Builder clearVendorConsent() {
            this.vendorConsent.clear();
            return this;
        }

        public Builder clearVendorLegitimateInterest() {
            this.vendorLegitimateInterest.clear();
            return this;
        }

        public Builder cmpId(int i) {
            this.cmpId = i;
            return this;
        }

        public Builder cmpVersion(int i) {
            this.cmpVersion = i;
            return this;
        }

        public Builder consentLanguage(String str) throws IllegalArgumentException {
            this.consentLanguage = validateString(str, FieldDefs.CORE_CONSENT_LANGUAGE);
            return this;
        }

        public Builder consentScreen(int i) {
            this.consentScreen = i;
            return this;
        }

        public Builder created(Date date) {
            this.created = date;
            return this;
        }

        public Builder defaultConsent(boolean z) {
            this.defaultConsent = z;
            return this;
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public String encode() {
            return this.version == 1 ? new TCStringEncoderV1(this).encode() : new TCStringEncoderV2(this, null).encode();
        }

        public Builder isServiceSpecific(boolean z) {
            this.isServiceSpecific = z;
            return this;
        }

        public Builder lastUpdated(Date date) {
            this.updated = date;
            return this;
        }

        public Builder publisherCC(String str) {
            this.publisherCC = validateString(str, FieldDefs.CORE_PUBLISHER_CC);
            return this;
        }

        public Builder purposeOneTreatment(boolean z) {
            this.purposeOneTreatment = z;
            return this;
        }

        public Builder tcfPolicyVersion(int i) {
            this.tcfPolicyVersion = i;
            return this;
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public TCString toTCString() {
            return TCString.Util.decode(encode(), new DecoderOption[0]);
        }

        public Builder useNonStandardStacks(boolean z) {
            this.useNonStandardStacks = z;
            return this;
        }

        public Builder vendorListVersion(int i) {
            this.vendorListVersion = i;
            return this;
        }

        public Builder version(int i) throws IllegalArgumentException {
            this.version = validateVersion(i);
            return this;
        }

        public Builder() {
            this.version = 0;
            Date date = new Date();
            this.created = date;
            this.updated = date;
            this.cmpId = 0;
            this.cmpVersion = 0;
            this.consentScreen = 0;
            this.consentLanguage = "EN";
            this.vendorListVersion = 0;
            this.purposesConsent = BitSetIntIterable.newBuilder();
            this.vendorConsent = BitSetIntIterable.newBuilder();
            this.tcfPolicyVersion = 0;
            this.isServiceSpecific = false;
            this.useNonStandardStacks = false;
            this.specialFeatureOptIns = BitSetIntIterable.newBuilder();
            this.purposesLITransparency = BitSetIntIterable.newBuilder();
            this.purposeOneTreatment = false;
            this.publisherCC = "US";
            this.vendorLegitimateInterest = BitSetIntIterable.newBuilder();
            this.disclosedVendors = BitSetIntIterable.newBuilder();
            this.allowedVendors = BitSetIntIterable.newBuilder();
            this.pubPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.pubPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.defaultConsent = false;
            this.publisherRestrictions = new ArrayList();
        }

        public Builder addAllowedVendors(IntIterable intIterable) {
            this.allowedVendors.add(intIterable);
            return this;
        }

        public Builder addCustomPurposesConsent(IntIterable intIterable) {
            this.customPurposesConsent.add(intIterable);
            return this;
        }

        public Builder addCustomPurposesLITransparency(IntIterable intIterable) {
            this.customPurposesLITransparency.add(intIterable);
            return this;
        }

        public Builder addDisclosedVendors(IntIterable intIterable) {
            this.disclosedVendors.add(intIterable);
            return this;
        }

        public Builder addPubPurposesConsent(IntIterable intIterable) {
            this.pubPurposesConsent.add(intIterable);
            return this;
        }

        public Builder addPubPurposesLITransparency(IntIterable intIterable) {
            this.pubPurposesLITransparency.add(intIterable);
            return this;
        }

        public Builder addPublisherRestrictionEntry(PublisherRestrictionEntry... publisherRestrictionEntryArr) {
            for (PublisherRestrictionEntry publisherRestrictionEntry : publisherRestrictionEntryArr) {
                addPublisherRestrictionEntry(publisherRestrictionEntry);
            }
            return this;
        }

        public Builder addPurposesConsent(IntIterable intIterable) {
            this.purposesConsent.add(intIterable);
            return this;
        }

        public Builder addPurposesLITransparency(IntIterable intIterable) {
            this.purposesLITransparency.add(intIterable);
            return this;
        }

        public Builder addSpecialFeatureOptIns(IntIterable intIterable) {
            this.specialFeatureOptIns.add(intIterable);
            return this;
        }

        public Builder addVendorConsent(IntIterable intIterable) {
            this.vendorConsent.add(intIterable);
            return this;
        }

        public Builder addVendorLegitimateInterest(IntIterable intIterable) {
            this.vendorLegitimateInterest.add(intIterable);
            return this;
        }

        public Builder addPublisherRestrictionEntry(Collection<PublisherRestrictionEntry> collection) {
            this.publisherRestrictions.addAll(collection);
            return this;
        }

        private Builder(Builder builder) {
            this.version = 0;
            Date date = new Date();
            this.created = date;
            this.updated = date;
            this.cmpId = 0;
            this.cmpVersion = 0;
            this.consentScreen = 0;
            this.consentLanguage = "EN";
            this.vendorListVersion = 0;
            this.purposesConsent = BitSetIntIterable.newBuilder();
            this.vendorConsent = BitSetIntIterable.newBuilder();
            this.tcfPolicyVersion = 0;
            this.isServiceSpecific = false;
            this.useNonStandardStacks = false;
            this.specialFeatureOptIns = BitSetIntIterable.newBuilder();
            this.purposesLITransparency = BitSetIntIterable.newBuilder();
            this.purposeOneTreatment = false;
            this.publisherCC = "US";
            this.vendorLegitimateInterest = BitSetIntIterable.newBuilder();
            this.disclosedVendors = BitSetIntIterable.newBuilder();
            this.allowedVendors = BitSetIntIterable.newBuilder();
            this.pubPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.pubPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.defaultConsent = false;
            this.publisherRestrictions = new ArrayList();
            this.version = builder.version;
            this.created = builder.created;
            this.updated = builder.updated;
            this.cmpId = builder.cmpId;
            this.cmpVersion = builder.cmpVersion;
            this.consentScreen = builder.consentScreen;
            this.consentLanguage = builder.consentLanguage;
            this.vendorListVersion = builder.vendorListVersion;
            this.purposesConsent = builder.purposesConsent;
            this.vendorConsent = builder.vendorConsent;
            this.tcfPolicyVersion = builder.tcfPolicyVersion;
            this.isServiceSpecific = builder.isServiceSpecific;
            this.useNonStandardStacks = builder.useNonStandardStacks;
            this.specialFeatureOptIns = builder.specialFeatureOptIns;
            this.purposesLITransparency = builder.purposesLITransparency;
            this.purposeOneTreatment = builder.purposeOneTreatment;
            this.publisherCC = builder.publisherCC;
            this.vendorLegitimateInterest = builder.vendorLegitimateInterest;
            this.disclosedVendors = builder.disclosedVendors;
            this.allowedVendors = builder.allowedVendors;
        }

        public Builder(TCString tCString) {
            this.version = 0;
            Date date = new Date();
            this.created = date;
            this.updated = date;
            this.cmpId = 0;
            this.cmpVersion = 0;
            this.consentScreen = 0;
            this.consentLanguage = "EN";
            this.vendorListVersion = 0;
            this.purposesConsent = BitSetIntIterable.newBuilder();
            this.vendorConsent = BitSetIntIterable.newBuilder();
            this.tcfPolicyVersion = 0;
            this.isServiceSpecific = false;
            this.useNonStandardStacks = false;
            this.specialFeatureOptIns = BitSetIntIterable.newBuilder();
            this.purposesLITransparency = BitSetIntIterable.newBuilder();
            this.purposeOneTreatment = false;
            this.publisherCC = "US";
            this.vendorLegitimateInterest = BitSetIntIterable.newBuilder();
            this.disclosedVendors = BitSetIntIterable.newBuilder();
            this.allowedVendors = BitSetIntIterable.newBuilder();
            this.pubPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesConsent = BitSetIntIterable.newBuilder();
            this.customPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.pubPurposesLITransparency = BitSetIntIterable.newBuilder();
            this.defaultConsent = false;
            this.publisherRestrictions = new ArrayList();
            this.version = tCString.getVersion();
            this.created = tCString.getCreated();
            this.updated = tCString.getLastUpdated();
            this.cmpId = tCString.getCmpId();
            this.cmpVersion = tCString.getCmpVersion();
            this.consentScreen = tCString.getConsentScreen();
            this.consentLanguage = tCString.getConsentLanguage();
            this.vendorListVersion = tCString.getVendorListVersion();
            this.purposesConsent = BitSetIntIterable.newBuilder(tCString.getPurposesConsent());
            this.vendorConsent = BitSetIntIterable.newBuilder(tCString.getVendorConsent());
            if (this.version != 1) {
                this.tcfPolicyVersion = tCString.getTcfPolicyVersion();
                this.isServiceSpecific = tCString.isServiceSpecific();
                this.useNonStandardStacks = tCString.getUseNonStandardStacks();
                this.specialFeatureOptIns = BitSetIntIterable.newBuilder(tCString.getSpecialFeatureOptIns());
                this.purposesLITransparency = BitSetIntIterable.newBuilder(tCString.getPurposesLITransparency());
                this.purposeOneTreatment = tCString.getPurposeOneTreatment();
                this.publisherCC = tCString.getPublisherCC();
                this.vendorLegitimateInterest = BitSetIntIterable.newBuilder(tCString.getVendorLegitimateInterest());
                this.disclosedVendors = BitSetIntIterable.newBuilder(tCString.getDisclosedVendors());
                this.allowedVendors = BitSetIntIterable.newBuilder(tCString.getAllowedVendors());
            }
        }
    }

    public static class TCStringEncoderV1 implements TCStringEncoder {
        private final int cmpId;
        private final int cmpVersion;
        private final String consentLanguage;
        private final int consentScreen;
        private final Date created;
        private final boolean defaultConsent;
        private final IntIterable purposesConsent;
        private final Date updated;
        private final int vendorListVersion;
        private final IntIterable vendorsConsent;
        private final int version;

        public TCStringEncoderV1(Builder builder) {
            if (builder.version != 1) {
                throw new IllegalArgumentException("version must be 1: " + builder.version);
            }
            this.version = builder.version;
            this.created = builder.created;
            this.updated = builder.updated;
            this.cmpId = builder.cmpId;
            this.cmpVersion = builder.cmpVersion;
            this.consentScreen = builder.consentScreen;
            this.consentLanguage = builder.consentLanguage;
            this.vendorListVersion = builder.vendorListVersion;
            this.purposesConsent = builder.purposesConsent.build();
            this.vendorsConsent = builder.vendorConsent.build();
            this.defaultConsent = builder.defaultConsent;
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public String encode() {
            BitWriter bitWriter = new BitWriter();
            bitWriter.write(this.version, FieldDefs.V1_VERSION);
            bitWriter.write(this.created, FieldDefs.V1_CREATED);
            bitWriter.write(this.updated, FieldDefs.V1_LAST_UPDATED);
            bitWriter.write(this.cmpId, FieldDefs.V1_CMP_ID);
            bitWriter.write(this.cmpVersion, FieldDefs.V1_CMP_VERSION);
            bitWriter.write(this.consentScreen, FieldDefs.V1_CONSENT_SCREEN);
            bitWriter.write(this.consentLanguage, FieldDefs.V1_CONSENT_LANGUAGE);
            bitWriter.write(this.vendorListVersion, FieldDefs.V1_VENDOR_LIST_VERSION);
            bitWriter.write(this.purposesConsent, FieldDefs.V1_PURPOSES_ALLOW);
            bitWriter.write(new VendorFieldEncoder().defaultConsent(this.defaultConsent).add(this.vendorsConsent).buildV1());
            return bitWriter.toBase64();
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public TCString toTCString() {
            return TCString.Util.decode(encode(), new DecoderOption[0]);
        }
    }

    public static class TCStringEncoderV2 implements TCStringEncoder {
        private final IntIterable allowedVendors;
        private final int cmpId;
        private final int cmpVersion;
        private final String consentLanguage;
        private final int consentScreen;
        private final Date created;
        private final IntIterable customPurposesConsent;
        private final IntIterable customPurposesLITransparency;
        private final IntIterable disclosedVendors;
        private final boolean isServiceSpecific;
        private final int numberOfCustomPurposes;
        private final IntIterable pubPurposesConsent;
        private final IntIterable pubPurposesLITransparency;
        private final String publisherCC;
        private final List<PublisherRestrictionEntry> publisherRestrictions;
        private final boolean purposeOneTreatment;
        private final IntIterable purposesConsent;
        private final IntIterable purposesLITransparency;
        private final IntIterable specialFeatureOptIns;
        private final int tcfPolicyVersion;
        private final Date updated;
        private final boolean useNonStandardStacks;
        private final IntIterable vendorLegitimateInterest;
        private final int vendorListVersion;
        private final IntIterable vendorsConsent;
        private final int version;

        /* synthetic */ TCStringEncoderV2(Builder builder, AnonymousClass1 anonymousClass1) throws ValueOverflowException, IllegalArgumentException {
            this(builder);
        }

        private String encodeAllowedVendors() {
            return encodeSegment(SegmentType.ALLOWED_VENDOR);
        }

        private String encodeCoreString() {
            BitWriter bitWriter = new BitWriter();
            bitWriter.write(this.version, FieldDefs.CORE_VERSION);
            bitWriter.writeDays(this.created, FieldDefs.CORE_CREATED);
            bitWriter.writeDays(this.updated, FieldDefs.CORE_LAST_UPDATED);
            bitWriter.write(this.cmpId, FieldDefs.CORE_CMP_ID);
            bitWriter.write(this.cmpVersion, FieldDefs.CORE_CMP_VERSION);
            bitWriter.write(this.consentScreen, FieldDefs.CORE_CONSENT_SCREEN);
            bitWriter.write(this.consentLanguage, FieldDefs.CORE_CONSENT_LANGUAGE);
            bitWriter.write(this.vendorListVersion, FieldDefs.CORE_VENDOR_LIST_VERSION);
            bitWriter.write(this.tcfPolicyVersion, FieldDefs.CORE_TCF_POLICY_VERSION);
            bitWriter.write(this.isServiceSpecific, FieldDefs.CORE_IS_SERVICE_SPECIFIC);
            bitWriter.write(this.useNonStandardStacks, FieldDefs.CORE_USE_NON_STANDARD_STOCKS);
            bitWriter.write(this.specialFeatureOptIns, FieldDefs.CORE_SPECIAL_FEATURE_OPT_INS);
            bitWriter.write(this.purposesConsent, FieldDefs.CORE_PURPOSES_CONSENT);
            bitWriter.write(this.purposesLITransparency, FieldDefs.CORE_PURPOSES_LI_TRANSPARENCY);
            bitWriter.write(this.purposeOneTreatment, FieldDefs.CORE_PURPOSE_ONE_TREATMENT);
            bitWriter.write(this.publisherCC, FieldDefs.CORE_PUBLISHER_CC);
            bitWriter.write(new VendorFieldEncoder().add(this.vendorsConsent).build());
            bitWriter.write(new VendorFieldEncoder().add(this.vendorLegitimateInterest).build());
            bitWriter.write(this.publisherRestrictions.size(), FieldDefs.CORE_NUM_PUB_RESTRICTION);
            for (PublisherRestrictionEntry publisherRestrictionEntry : this.publisherRestrictions) {
                bitWriter.write(publisherRestrictionEntry.getPurposeId(), FieldDefs.PURPOSE_ID);
                bitWriter.write(publisherRestrictionEntry.getRestrictionType().ordinal(), FieldDefs.RESTRICTION_TYPE);
                bitWriter.write(new VendorFieldEncoder().emitRangeEncoding(true).emitMaxVendorId(false).emitIsRangeEncoding(false).add(publisherRestrictionEntry.getVendors()).build());
            }
            return bitWriter.toBase64();
        }

        private String encodeDisclosedVendors() {
            return encodeSegment(SegmentType.DISCLOSED_VENDOR);
        }

        private String encodePPTC() {
            if (this.pubPurposesConsent.isEmpty() && this.pubPurposesLITransparency.isEmpty() && this.numberOfCustomPurposes == 0) {
                return "";
            }
            BitWriter bitWriter = new BitWriter();
            bitWriter.write(SegmentType.PUBLISHER_TC.value(), FieldDefs.PPTC_SEGMENT_TYPE);
            bitWriter.write(this.pubPurposesConsent, FieldDefs.PPTC_PUB_PURPOSES_CONSENT);
            bitWriter.write(this.pubPurposesLITransparency, FieldDefs.PPTC_PUB_PURPOSES_LI_TRANSPARENCY);
            bitWriter.write(this.numberOfCustomPurposes, FieldDefs.PPTC_NUM_CUSTOM_PURPOSES);
            bitWriter.write(this.customPurposesConsent, this.numberOfCustomPurposes);
            bitWriter.write(this.customPurposesLITransparency, this.numberOfCustomPurposes);
            return bitWriter.toBase64();
        }

        private String encodeSegment(SegmentType segmentType) {
            IntIterable intIterable;
            BitSetIntIterable bitSetIntIterable = BitSetIntIterable.EMPTY;
            int i = AnonymousClass1.$SwitchMap$com$iabtcf$v2$SegmentType[segmentType.ordinal()];
            if (i == 1) {
                intIterable = this.disclosedVendors;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("invalid segment type: " + segmentType);
                }
                intIterable = this.allowedVendors;
            }
            if (intIterable.isEmpty()) {
                return "";
            }
            BitWriter bitWriter = new BitWriter();
            bitWriter.write(segmentType.value(), FieldDefs.OOB_SEGMENT_TYPE);
            bitWriter.write(new VendorFieldEncoder().add(intIterable).build());
            return bitWriter.toBase64();
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public String encode() {
            List<String> listAsList = Arrays.asList(encodeCoreString(), encodeDisclosedVendors(), encodeAllowedVendors(), encodePPTC());
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : listAsList) {
                if (str != null && !str.isEmpty()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(".");
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }

        @Override // com.iabtcf.encoder.TCStringEncoder
        public TCString toTCString() {
            return TCString.Util.decode(encode(), new DecoderOption[0]);
        }

        private TCStringEncoderV2(Builder builder) throws ValueOverflowException, IllegalArgumentException {
            if (builder.version != 2) {
                throw new IllegalArgumentException("version must be 2: " + builder.version);
            }
            int i = builder.version;
            FieldDefs fieldDefs = FieldDefs.CORE_CMP_VERSION;
            this.version = Bounds.checkBounds(i, fieldDefs);
            this.created = (Date) Objects.requireNonNull(builder.created);
            this.updated = (Date) Objects.requireNonNull(builder.updated);
            this.cmpId = Bounds.checkBounds(builder.cmpId, FieldDefs.CORE_CMP_ID);
            this.cmpVersion = Bounds.checkBounds(builder.cmpVersion, fieldDefs);
            this.consentScreen = Bounds.checkBounds(builder.consentScreen, FieldDefs.CORE_CONSENT_SCREEN);
            this.consentLanguage = (String) Objects.requireNonNull(builder.consentLanguage);
            this.vendorListVersion = Bounds.checkBounds(builder.vendorListVersion, FieldDefs.CORE_VENDOR_LIST_VERSION);
            this.purposesConsent = Bounds.checkBoundsBits(builder.purposesConsent, FieldDefs.CORE_PURPOSES_CONSENT).build();
            BitSetIntIterable.Builder builder2 = builder.vendorConsent;
            FieldDefs fieldDefs2 = FieldDefs.CORE_VENDOR_MAX_VENDOR_ID;
            this.vendorsConsent = Bounds.checkBounds(builder2, fieldDefs2).build();
            this.tcfPolicyVersion = Bounds.checkBounds(builder.tcfPolicyVersion, FieldDefs.CORE_TCF_POLICY_VERSION);
            this.isServiceSpecific = builder.isServiceSpecific;
            this.useNonStandardStacks = builder.useNonStandardStacks;
            this.specialFeatureOptIns = Bounds.checkBoundsBits(builder.specialFeatureOptIns, FieldDefs.CORE_SPECIAL_FEATURE_OPT_INS).build();
            this.purposesLITransparency = Bounds.checkBoundsBits(builder.purposesLITransparency, FieldDefs.CORE_PURPOSES_LI_TRANSPARENCY).build();
            this.purposeOneTreatment = builder.purposeOneTreatment;
            this.publisherCC = (String) Objects.requireNonNull(builder.publisherCC);
            this.vendorLegitimateInterest = Bounds.checkBounds(builder.vendorLegitimateInterest, fieldDefs2).build();
            this.disclosedVendors = Bounds.checkBounds(builder.disclosedVendors, fieldDefs2).build();
            this.allowedVendors = Bounds.checkBounds(builder.allowedVendors, fieldDefs2).build();
            this.pubPurposesLITransparency = Bounds.checkBoundsBits(builder.pubPurposesLITransparency, FieldDefs.PPTC_PUB_PURPOSES_LI_TRANSPARENCY).build();
            this.pubPurposesConsent = Bounds.checkBoundsBits(builder.pubPurposesConsent, FieldDefs.PPTC_PUB_PURPOSES_CONSENT).build();
            this.numberOfCustomPurposes = Bounds.checkBounds(Math.max(builder.customPurposesLITransparency.max(), builder.customPurposesConsent.max()), FieldDefs.PPTC_NUM_CUSTOM_PURPOSES);
            this.customPurposesLITransparency = builder.customPurposesLITransparency.build();
            this.customPurposesConsent = builder.customPurposesConsent.build();
            this.publisherRestrictions = Bounds.checkBounds(new ArrayList(builder.publisherRestrictions));
        }
    }

    public static class Util {
        public static Builder newBuilder() {
            return new Builder();
        }

        public static Builder newBuilder(Builder builder) {
            return new Builder(builder, null);
        }

        public static Builder newBuilder(TCString tCString) {
            return new Builder(tCString);
        }
    }

    String encode() throws ValueOverflowException, IllegalArgumentException;

    TCString toTCString() throws ValueOverflowException, IllegalArgumentException;
}

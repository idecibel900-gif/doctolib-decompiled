package com.iabtcf.decoder;

import com.iabtcf.exceptions.ByteParseException;
import com.iabtcf.exceptions.UnsupportedVersionException;
import com.iabtcf.utils.Base64;
import com.iabtcf.utils.BitReader;
import com.iabtcf.utils.FieldDefs;
import com.iabtcf.utils.IntIterable;
import com.iabtcf.utils.Objects;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class PPCString {
    private final BitReader bbv;

    private PPCString(BitReader bitReader) {
        this.bbv = bitReader;
    }

    public static PPCString decode(String str) throws ByteParseException, IllegalArgumentException, UnsupportedVersionException {
        return new PPCString(new BitReader(Base64.getUrlDecoder().decode(str)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PPCString pPCString = (PPCString) obj;
        return getVersion() == pPCString.getVersion() && Objects.equals(getCreated(), pPCString.getCreated()) && Objects.equals(getLastUpdated(), pPCString.getLastUpdated()) && getCmpId() == pPCString.getCmpId() && getCmpVersion() == pPCString.getCmpVersion() && getConsentScreen() == pPCString.getConsentScreen() && Objects.equals(getConsentLanguage(), pPCString.getConsentLanguage()) && getVendorListVersion() == pPCString.getVendorListVersion() && Objects.equals(Integer.valueOf(getPublisherPurposesVersion()), Integer.valueOf(pPCString.getPublisherPurposesVersion())) && Objects.equals(getStandardPurposesAllowed(), pPCString.getStandardPurposesAllowed()) && Objects.equals(getCustomPurposesBitField(), pPCString.getCustomPurposesBitField());
    }

    public int getCmpId() {
        return this.bbv.readBits12(FieldDefs.V1_CMP_ID);
    }

    public int getCmpVersion() {
        return this.bbv.readBits12(FieldDefs.V1_CMP_VERSION);
    }

    public String getConsentLanguage() {
        return this.bbv.readStr2(FieldDefs.V1_CONSENT_LANGUAGE);
    }

    public int getConsentScreen() {
        return this.bbv.readBits6(FieldDefs.V1_CONSENT_SCREEN);
    }

    public Date getCreated() {
        return new Date(this.bbv.readBits36(FieldDefs.V1_CREATED) * 100);
    }

    public IntIterable getCustomPurposesBitField() {
        return TCStringV2.fillBitSet(this.bbv, FieldDefs.V1_PPC_CUSTOM_PURPOSES_BITFIELD);
    }

    public Date getLastUpdated() {
        return new Date(this.bbv.readBits36(FieldDefs.V1_LAST_UPDATED) * 100);
    }

    public int getPublisherPurposesVersion() {
        return this.bbv.readBits12(FieldDefs.V1_PPC_PUBLISHER_PURPOSES_VERSION);
    }

    public IntIterable getStandardPurposesAllowed() {
        return TCStringV2.fillBitSet(this.bbv, FieldDefs.V1_PPC_STANDARD_PURPOSES_ALLOWED);
    }

    public int getVendorListVersion() {
        return this.bbv.readBits12(FieldDefs.V1_VENDOR_LIST_VERSION);
    }

    public int getVersion() {
        return this.bbv.readBits6(FieldDefs.V1_VERSION);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getVersion()), getCreated(), getLastUpdated(), Integer.valueOf(getCmpId()), Integer.valueOf(getCmpVersion()), Integer.valueOf(getConsentScreen()), getConsentLanguage(), Integer.valueOf(getVendorListVersion()), Integer.valueOf(getPublisherPurposesVersion()), getStandardPurposesAllowed(), getCustomPurposesBitField());
    }

    public String toString() {
        return "PPCString [getVersion()=" + getVersion() + ", getCreated()=" + getCreated() + ", getLastUpdated()=" + getLastUpdated() + ", getCmpId()=" + getCmpId() + ", getCmpVersion()=" + getCmpVersion() + ", getConsentScreen()=" + getConsentScreen() + ", getConsentLanguage()=" + getConsentLanguage() + ", getVendorListVersion()=" + getVendorListVersion() + ", getPublisherPurposesVersion()=" + getPublisherPurposesVersion() + ", getStandardPurposesAllowed()=" + getStandardPurposesAllowed() + ", getCustomPurposesBitField()=" + getCustomPurposesBitField() + "]";
    }
}

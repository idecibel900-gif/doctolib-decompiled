package com.iabtcf.decoder;

import com.iabtcf.exceptions.ByteParseException;
import com.iabtcf.exceptions.UnsupportedVersionException;
import com.iabtcf.utils.IntIterable;
import com.iabtcf.v2.PublisherRestriction;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface TCString {

    public static class Util {
        public static TCString decode(String str, DecoderOption... decoderOptionArr) throws ByteParseException, IllegalArgumentException, UnsupportedVersionException {
            return TCStringDecoder.decode(str, decoderOptionArr);
        }
    }

    IntIterable getAllowedVendors();

    int getCmpId();

    int getCmpVersion();

    String getConsentLanguage();

    int getConsentScreen();

    Date getCreated();

    IntIterable getCustomPurposesConsent();

    IntIterable getCustomPurposesLITransparency();

    boolean getDefaultVendorConsent();

    IntIterable getDisclosedVendors();

    Date getLastUpdated();

    IntIterable getPubPurposesConsent();

    IntIterable getPubPurposesLITransparency();

    String getPublisherCC();

    List<PublisherRestriction> getPublisherRestrictions();

    boolean getPurposeOneTreatment();

    IntIterable getPurposesConsent();

    IntIterable getPurposesLITransparency();

    IntIterable getSpecialFeatureOptIns();

    int getTcfPolicyVersion();

    boolean getUseNonStandardStacks();

    IntIterable getVendorConsent();

    IntIterable getVendorLegitimateInterest();

    int getVendorListVersion();

    int getVersion();

    boolean isServiceSpecific();
}

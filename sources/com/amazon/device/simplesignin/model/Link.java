package com.amazon.device.simplesignin.model;

/* JADX INFO: loaded from: classes3.dex */
public class Link {
    private String amazonUserId;
    private String identityProviderName;
    private String linkId;
    private long linkedTimestamp;
    private String partnerUserId;
    private Token ssiToken;

    public void setAmazonUserId(String str) {
        this.amazonUserId = str;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setLinkedTimestamp(long j) {
        this.linkedTimestamp = j;
    }

    public void setPartnerUserId(String str) {
        this.partnerUserId = str;
    }

    public void setSsiToken(Token token) {
        this.ssiToken = token;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof Link;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        if (!link.canEqual(this) || getLinkedTimestamp() != link.getLinkedTimestamp()) {
            return false;
        }
        String linkId = getLinkId();
        String linkId2 = link.getLinkId();
        if (linkId != null ? !linkId.equals(linkId2) : linkId2 != null) {
            return false;
        }
        String amazonUserId = getAmazonUserId();
        String amazonUserId2 = link.getAmazonUserId();
        if (amazonUserId != null ? !amazonUserId.equals(amazonUserId2) : amazonUserId2 != null) {
            return false;
        }
        String partnerUserId = getPartnerUserId();
        String partnerUserId2 = link.getPartnerUserId();
        if (partnerUserId != null ? !partnerUserId.equals(partnerUserId2) : partnerUserId2 != null) {
            return false;
        }
        String identityProviderName = getIdentityProviderName();
        String identityProviderName2 = link.getIdentityProviderName();
        if (identityProviderName != null ? !identityProviderName.equals(identityProviderName2) : identityProviderName2 != null) {
            return false;
        }
        Token ssiToken = getSsiToken();
        Token ssiToken2 = link.getSsiToken();
        return ssiToken != null ? ssiToken.equals(ssiToken2) : ssiToken2 == null;
    }

    public int hashCode() {
        long linkedTimestamp = getLinkedTimestamp();
        String linkId = getLinkId();
        int iHashCode = ((((int) (linkedTimestamp ^ (linkedTimestamp >>> 32))) + 59) * 59) + (linkId == null ? 43 : linkId.hashCode());
        String amazonUserId = getAmazonUserId();
        int iHashCode2 = (iHashCode * 59) + (amazonUserId == null ? 43 : amazonUserId.hashCode());
        String partnerUserId = getPartnerUserId();
        int iHashCode3 = (iHashCode2 * 59) + (partnerUserId == null ? 43 : partnerUserId.hashCode());
        String identityProviderName = getIdentityProviderName();
        int iHashCode4 = (iHashCode3 * 59) + (identityProviderName == null ? 43 : identityProviderName.hashCode());
        Token ssiToken = getSsiToken();
        return (iHashCode4 * 59) + (ssiToken != null ? ssiToken.hashCode() : 43);
    }

    public String getLinkId() {
        return this.linkId;
    }

    public String getAmazonUserId() {
        return this.amazonUserId;
    }

    public String getPartnerUserId() {
        return this.partnerUserId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
    }

    public Token getSsiToken() {
        return this.ssiToken;
    }

    public long getLinkedTimestamp() {
        return this.linkedTimestamp;
    }
}

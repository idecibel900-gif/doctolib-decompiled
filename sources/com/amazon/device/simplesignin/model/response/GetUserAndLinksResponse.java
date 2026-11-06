package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GetUserAndLinksResponse {
    private String amazonUserId;
    private List<Link> links;
    private RequestId requestId;
    private RequestStatus requestStatus;

    public void setAmazonUserId(String str) {
        this.amazonUserId = str;
    }

    public void setLinks(List<Link> list) {
        this.links = list;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof GetUserAndLinksResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserAndLinksResponse)) {
            return false;
        }
        GetUserAndLinksResponse getUserAndLinksResponse = (GetUserAndLinksResponse) obj;
        if (!getUserAndLinksResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId = getRequestId();
        RequestId requestId2 = getUserAndLinksResponse.getRequestId();
        if (requestId != null ? !requestId.equals(requestId2) : requestId2 != null) {
            return false;
        }
        RequestStatus requestStatus = getRequestStatus();
        RequestStatus requestStatus2 = getUserAndLinksResponse.getRequestStatus();
        if (requestStatus != null ? !requestStatus.equals(requestStatus2) : requestStatus2 != null) {
            return false;
        }
        String amazonUserId = getAmazonUserId();
        String amazonUserId2 = getUserAndLinksResponse.getAmazonUserId();
        if (amazonUserId != null ? !amazonUserId.equals(amazonUserId2) : amazonUserId2 != null) {
            return false;
        }
        List<Link> links = getLinks();
        List<Link> links2 = getUserAndLinksResponse.getLinks();
        return links != null ? links.equals(links2) : links2 == null;
    }

    public int hashCode() {
        RequestId requestId = getRequestId();
        int iHashCode = requestId == null ? 43 : requestId.hashCode();
        RequestStatus requestStatus = getRequestStatus();
        int iHashCode2 = ((iHashCode + 59) * 59) + (requestStatus == null ? 43 : requestStatus.hashCode());
        String amazonUserId = getAmazonUserId();
        int iHashCode3 = (iHashCode2 * 59) + (amazonUserId == null ? 43 : amazonUserId.hashCode());
        List<Link> links = getLinks();
        return (iHashCode3 * 59) + (links != null ? links.hashCode() : 43);
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public String getAmazonUserId() {
        return this.amazonUserId;
    }

    public List<Link> getLinks() {
        return this.links;
    }
}

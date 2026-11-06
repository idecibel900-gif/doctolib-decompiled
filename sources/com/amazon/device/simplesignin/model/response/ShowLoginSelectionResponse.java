package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

/* JADX INFO: loaded from: classes3.dex */
public class ShowLoginSelectionResponse {
    private String linkId;
    private RequestId requestId;
    private RequestStatus requestStatus;
    private UserSelection userSelection;

    public enum UserSelection {
        ManualSignIn,
        LoginSelected
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public void setUserSelection(UserSelection userSelection) {
        this.userSelection = userSelection;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof ShowLoginSelectionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShowLoginSelectionResponse)) {
            return false;
        }
        ShowLoginSelectionResponse showLoginSelectionResponse = (ShowLoginSelectionResponse) obj;
        if (!showLoginSelectionResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId = getRequestId();
        RequestId requestId2 = showLoginSelectionResponse.getRequestId();
        if (requestId != null ? !requestId.equals(requestId2) : requestId2 != null) {
            return false;
        }
        RequestStatus requestStatus = getRequestStatus();
        RequestStatus requestStatus2 = showLoginSelectionResponse.getRequestStatus();
        if (requestStatus != null ? !requestStatus.equals(requestStatus2) : requestStatus2 != null) {
            return false;
        }
        UserSelection userSelection = getUserSelection();
        UserSelection userSelection2 = showLoginSelectionResponse.getUserSelection();
        if (userSelection != null ? !userSelection.equals(userSelection2) : userSelection2 != null) {
            return false;
        }
        String linkId = getLinkId();
        String linkId2 = showLoginSelectionResponse.getLinkId();
        return linkId != null ? linkId.equals(linkId2) : linkId2 == null;
    }

    public int hashCode() {
        RequestId requestId = getRequestId();
        int iHashCode = requestId == null ? 43 : requestId.hashCode();
        RequestStatus requestStatus = getRequestStatus();
        int iHashCode2 = ((iHashCode + 59) * 59) + (requestStatus == null ? 43 : requestStatus.hashCode());
        UserSelection userSelection = getUserSelection();
        int iHashCode3 = (iHashCode2 * 59) + (userSelection == null ? 43 : userSelection.hashCode());
        String linkId = getLinkId();
        return (iHashCode3 * 59) + (linkId != null ? linkId.hashCode() : 43);
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public UserSelection getUserSelection() {
        return this.userSelection;
    }

    public String getLinkId() {
        return this.linkId;
    }
}

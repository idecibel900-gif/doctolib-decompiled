package com.amazon.device.simplesignin.model.response;

import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;

/* JADX INFO: loaded from: classes3.dex */
public class RecordMetricsEventResponse {
    private RequestId requestId;
    private RequestStatus requestStatus;

    public void setRequestId(RequestId requestId) {
        this.requestId = requestId;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof RecordMetricsEventResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecordMetricsEventResponse)) {
            return false;
        }
        RecordMetricsEventResponse recordMetricsEventResponse = (RecordMetricsEventResponse) obj;
        if (!recordMetricsEventResponse.canEqual(this)) {
            return false;
        }
        RequestId requestId = getRequestId();
        RequestId requestId2 = recordMetricsEventResponse.getRequestId();
        if (requestId != null ? !requestId.equals(requestId2) : requestId2 != null) {
            return false;
        }
        RequestStatus requestStatus = getRequestStatus();
        RequestStatus requestStatus2 = recordMetricsEventResponse.getRequestStatus();
        return requestStatus != null ? requestStatus.equals(requestStatus2) : requestStatus2 == null;
    }

    public int hashCode() {
        RequestId requestId = getRequestId();
        int iHashCode = requestId == null ? 43 : requestId.hashCode();
        RequestStatus requestStatus = getRequestStatus();
        return ((iHashCode + 59) * 59) + (requestStatus != null ? requestStatus.hashCode() : 43);
    }

    public RequestId getRequestId() {
        return this.requestId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }
}

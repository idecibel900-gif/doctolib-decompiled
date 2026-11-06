package com.amazon.device.iap.model;

/* JADX INFO: loaded from: classes3.dex */
public class UserDataRequest {
    private boolean fetchLWAConsentStatus;

    public UserDataRequest(Builder builder) {
        this.fetchLWAConsentStatus = builder.fetchLWAConsentStatus;
    }

    public boolean getFetchLWAConsentStatus() {
        return this.fetchLWAConsentStatus;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private boolean fetchLWAConsentStatus;

        private Builder() {
        }

        public Builder setFetchLWAConsentStatus(boolean z) {
            this.fetchLWAConsentStatus = z;
            return this;
        }

        public UserDataRequest build() {
            return new UserDataRequest(this);
        }
    }
}

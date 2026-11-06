package com.revenuecat.purchases.models;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleInstallmentsInfo;", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "commitmentPaymentsCount", "", "renewalCommitmentPaymentsCount", "(II)V", "getCommitmentPaymentsCount", "()I", "getRenewalCommitmentPaymentsCount", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GoogleInstallmentsInfo implements InstallmentsInfo {
    private final int commitmentPaymentsCount;
    private final int renewalCommitmentPaymentsCount;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleInstallmentsInfo)) {
            return false;
        }
        GoogleInstallmentsInfo googleInstallmentsInfo = (GoogleInstallmentsInfo) obj;
        return this.commitmentPaymentsCount == googleInstallmentsInfo.commitmentPaymentsCount && this.renewalCommitmentPaymentsCount == googleInstallmentsInfo.renewalCommitmentPaymentsCount;
    }

    public int hashCode() {
        return (this.commitmentPaymentsCount * 31) + this.renewalCommitmentPaymentsCount;
    }

    public String toString() {
        return "GoogleInstallmentsInfo(commitmentPaymentsCount=" + this.commitmentPaymentsCount + ", renewalCommitmentPaymentsCount=" + this.renewalCommitmentPaymentsCount + ')';
    }

    public GoogleInstallmentsInfo(int i, int i2) {
        this.commitmentPaymentsCount = i;
        this.renewalCommitmentPaymentsCount = i2;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getCommitmentPaymentsCount() {
        return this.commitmentPaymentsCount;
    }

    @Override // com.revenuecat.purchases.models.InstallmentsInfo
    public int getRenewalCommitmentPaymentsCount() {
        return this.renewalCommitmentPaymentsCount;
    }
}

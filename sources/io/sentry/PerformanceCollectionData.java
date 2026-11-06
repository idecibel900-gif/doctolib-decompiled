package io.sentry;

/* JADX INFO: loaded from: classes5.dex */
public final class PerformanceCollectionData {
    private final long nanoTimestamp;
    private Double cpuUsagePercentage = null;
    private Long usedHeapMemory = null;
    private Long usedNativeMemory = null;

    public PerformanceCollectionData(long j) {
        this.nanoTimestamp = j;
    }

    public void setCpuUsagePercentage(Double d) {
        this.cpuUsagePercentage = d;
    }

    public Double getCpuUsagePercentage() {
        return this.cpuUsagePercentage;
    }

    public void setUsedHeapMemory(Long l) {
        this.usedHeapMemory = l;
    }

    public Long getUsedHeapMemory() {
        return this.usedHeapMemory;
    }

    public void setUsedNativeMemory(Long l) {
        this.usedNativeMemory = l;
    }

    public Long getUsedNativeMemory() {
        return this.usedNativeMemory;
    }

    public long getNanoTimestamp() {
        return this.nanoTimestamp;
    }
}

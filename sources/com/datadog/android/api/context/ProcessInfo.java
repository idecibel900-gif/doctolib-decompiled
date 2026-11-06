package com.datadog.android.api.context;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessInfo {
    private final boolean isMainProcess;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProcessInfo) && this.isMainProcess == ((ProcessInfo) obj).isMainProcess;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isMainProcess);
    }

    public String toString() {
        return "ProcessInfo(isMainProcess=" + this.isMainProcess + ")";
    }

    public ProcessInfo(boolean z) {
        this.isMainProcess = z;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }
}

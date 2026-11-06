package io.sentry.ndk;

import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class DebugImage {
    private String arch;
    private String codeFile;
    private String codeId;
    private String debugFile;
    private String debugId;
    private String imageAddr;
    private Long imageSize;
    private String type;
    private Map<String, Object> unknown;
    private String uuid;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(Long l) {
        this.imageSize = l;
    }

    public void setImageSize(long j) {
        this.imageSize = Long.valueOf(j);
    }

    public String getArch() {
        return this.arch;
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }
}

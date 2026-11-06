package io.sentry;

import io.sentry.protocol.ViewHierarchy;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class Attachment {
    private final boolean addToTransactions;
    private String attachmentType;
    private final Callable byteProvider;
    private byte[] bytes;
    private final String contentType;
    private final String filename;
    private String pathname;
    private final JsonSerializable serializable;

    public Attachment(byte[] bArr, String str, String str2, boolean z) {
        this(bArr, str, str2, "event.attachment", z);
    }

    public Attachment(byte[] bArr, String str, String str2, String str3, boolean z) {
        this.bytes = bArr;
        this.serializable = null;
        this.byteProvider = null;
        this.filename = str;
        this.contentType = str2;
        this.attachmentType = str3;
        this.addToTransactions = z;
    }

    public Attachment(JsonSerializable jsonSerializable, String str, String str2, String str3, boolean z) {
        this.bytes = null;
        this.serializable = jsonSerializable;
        this.byteProvider = null;
        this.filename = str;
        this.contentType = str2;
        this.attachmentType = str3;
        this.addToTransactions = z;
    }

    public Attachment(Callable callable, String str, String str2, String str3, boolean z) {
        this.bytes = null;
        this.serializable = null;
        this.byteProvider = callable;
        this.filename = str;
        this.contentType = str2;
        this.attachmentType = str3;
        this.addToTransactions = z;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public JsonSerializable getSerializable() {
        return this.serializable;
    }

    public String getPathname() {
        return this.pathname;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getContentType() {
        return this.contentType;
    }

    boolean isAddToTransactions() {
        return this.addToTransactions;
    }

    public String getAttachmentType() {
        return this.attachmentType;
    }

    public Callable getByteProvider() {
        return this.byteProvider;
    }

    public static Attachment fromByteProvider(Callable callable, String str, String str2, boolean z) {
        return new Attachment(callable, str, str2, "event.attachment", z);
    }

    public static Attachment fromViewHierarchy(ViewHierarchy viewHierarchy) {
        return new Attachment((JsonSerializable) viewHierarchy, "view-hierarchy.json", "application/json", "event.view_hierarchy", false);
    }

    public static Attachment fromThreadDump(byte[] bArr) {
        return new Attachment(bArr, "thread-dump.txt", "text/plain", false);
    }

    public static Attachment fromTombstone(byte[] bArr) {
        return new Attachment(bArr, "tombstone.pb", "application/x-protobuf", false);
    }
}

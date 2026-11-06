package androidx.webkit;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WebMessageCompat {
    private final byte[] mArrayBuffer;
    private final WebMessagePortCompat[] mPorts;
    private final String mString;
    private final int mType;

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.mString = str;
        this.mArrayBuffer = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 0;
    }

    public WebMessageCompat(byte[] bArr) {
        this(bArr, (WebMessagePortCompat[]) null);
    }

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.mArrayBuffer = bArr;
        this.mString = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 1;
    }

    public int getType() {
        return this.mType;
    }

    public byte[] getArrayBuffer() {
        checkType(1);
        Objects.requireNonNull(this.mArrayBuffer);
        return this.mArrayBuffer;
    }

    public String getData() {
        checkType(0);
        return this.mString;
    }

    public WebMessagePortCompat[] getPorts() {
        return this.mPorts;
    }

    private String typeToString(int i) {
        if (i == 0) {
            return "String";
        }
        if (i == 1) {
            return "ArrayBuffer";
        }
        return "Unknown";
    }

    private void checkType(int i) {
        if (i == this.mType) {
            return;
        }
        throw new IllegalStateException("Wrong data accessor type detected. " + typeToString(this.mType) + " expected, but got " + typeToString(i));
    }
}

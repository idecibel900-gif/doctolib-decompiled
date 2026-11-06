package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayOutputStream;
import okhttp3.internal.http2.Settings;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes5.dex */
public class Composer {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private Composer() {
    }

    public static Composer compose() {
        return new Composer();
    }

    public Composer bool(boolean z) {
        this.bos.write(z ? 1 : 0);
        return this;
    }

    public byte[] build() {
        return this.bos.toByteArray();
    }

    public Composer bytes(Encodable encodable) {
        try {
            this.bos.write(encodable.getEncoded());
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Composer bytes(byte[] bArr) {
        try {
            this.bos.write(bArr);
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Composer bytes(byte[][] bArr) {
        try {
            for (byte[] bArr2 : bArr) {
                this.bos.write(bArr2);
            }
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Composer padUntil(int i, int i2) {
        while (this.bos.size() < i2) {
            this.bos.write(i);
        }
        return this;
    }

    public Composer u16str(int i) {
        int i2 = i & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        this.bos.write((byte) (i2 >>> 8));
        this.bos.write((byte) i2);
        return this;
    }

    public Composer u32str(int i) {
        this.bos.write((byte) (i >>> 24));
        this.bos.write((byte) (i >>> 16));
        this.bos.write((byte) (i >>> 8));
        this.bos.write((byte) i);
        return this;
    }

    public Composer u64str(long j) {
        u32str((int) (j >>> 32));
        u32str((int) j);
        return this;
    }
}

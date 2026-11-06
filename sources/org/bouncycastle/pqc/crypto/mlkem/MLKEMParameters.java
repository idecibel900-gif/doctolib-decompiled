package org.bouncycastle.pqc.crypto.mlkem;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes5.dex */
public class MLKEMParameters implements CipherParameters {
    private final int k;
    private final String name;
    private final int sessionKeySize;
    public static final MLKEMParameters ml_kem_512 = new MLKEMParameters("ML-KEM-512", 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final MLKEMParameters ml_kem_768 = new MLKEMParameters("ML-KEM-768", 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final MLKEMParameters ml_kem_1024 = new MLKEMParameters("ML-KEM-1024", 4, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);

    private MLKEMParameters(String str, int i, int i2) {
        this.name = str;
        this.k = i;
        this.sessionKeySize = i2;
    }

    public MLKEMEngine getEngine() {
        return new MLKEMEngine(this.k);
    }

    public String getName() {
        return this.name;
    }
}

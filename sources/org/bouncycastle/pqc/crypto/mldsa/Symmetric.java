package org.bouncycastle.pqc.crypto.mldsa;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes5.dex */
abstract class Symmetric {
    final int stream128BlockBytes;
    final int stream256BlockBytes;

    static class ShakeSymmetric extends Symmetric {
        private final SHAKEDigest digest128;
        private final SHAKEDigest digest256;

        ShakeSymmetric() {
            super(168, 136);
            this.digest128 = new SHAKEDigest(128);
            this.digest256 = new SHAKEDigest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        }

        private void streamInit(SHAKEDigest sHAKEDigest, byte[] bArr, short s) {
            sHAKEDigest.reset();
            sHAKEDigest.update(bArr, 0, bArr.length);
            sHAKEDigest.update(new byte[]{(byte) s, (byte) (s >> 8)}, 0, 2);
        }

        @Override // org.bouncycastle.pqc.crypto.mldsa.Symmetric
        void stream128init(byte[] bArr, short s) {
            streamInit(this.digest128, bArr, s);
        }

        @Override // org.bouncycastle.pqc.crypto.mldsa.Symmetric
        void stream128squeezeBlocks(byte[] bArr, int i, int i2) {
            this.digest128.doOutput(bArr, i, i2);
        }

        @Override // org.bouncycastle.pqc.crypto.mldsa.Symmetric
        void stream256init(byte[] bArr, short s) {
            streamInit(this.digest256, bArr, s);
        }

        @Override // org.bouncycastle.pqc.crypto.mldsa.Symmetric
        void stream256squeezeBlocks(byte[] bArr, int i, int i2) {
            this.digest256.doOutput(bArr, i, i2);
        }
    }

    Symmetric(int i, int i2) {
        this.stream128BlockBytes = i;
        this.stream256BlockBytes = i2;
    }

    abstract void stream128init(byte[] bArr, short s);

    abstract void stream128squeezeBlocks(byte[] bArr, int i, int i2);

    abstract void stream256init(byte[] bArr, short s);

    abstract void stream256squeezeBlocks(byte[] bArr, int i, int i2);
}

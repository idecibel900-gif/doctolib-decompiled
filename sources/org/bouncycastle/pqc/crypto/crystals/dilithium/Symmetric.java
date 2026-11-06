package org.bouncycastle.pqc.crypto.crystals.dilithium;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.SICBlockCipher;

/* JADX INFO: loaded from: classes5.dex */
abstract class Symmetric {
    final int stream128BlockBytes;
    final int stream256BlockBytes;

    static class AesSymmetric extends Symmetric {
        private final StreamCipher cipher;

        AesSymmetric() {
            super(64, 64);
            this.cipher = SICBlockCipher.newInstance(AESEngine.newInstance());
        }
    }

    static class ShakeSymmetric extends Symmetric {
        private final SHAKEDigest digest128;
        private final SHAKEDigest digest256;

        ShakeSymmetric() {
            super(168, 136);
            this.digest128 = new SHAKEDigest(128);
            this.digest256 = new SHAKEDigest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        }
    }

    Symmetric(int i, int i2) {
        this.stream128BlockBytes = i;
        this.stream256BlockBytes = i2;
    }
}

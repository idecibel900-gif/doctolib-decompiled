package org.bouncycastle.pqc.crypto.saber;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.SICBlockCipher;

/* JADX INFO: loaded from: classes5.dex */
abstract class Symmetric {

    static class AesSymmetric extends Symmetric {
        private final SHA256Digest sha256Digest = new SHA256Digest();
        private final SHA512Digest sha512Digest = new SHA512Digest();
        private final StreamCipher cipher = SICBlockCipher.newInstance(AESEngine.newInstance());

        AesSymmetric() {
        }
    }

    static class ShakeSymmetric extends Symmetric {
        private final Xof shakeDigest = new SHAKEDigest(128);
        private final SHA3Digest sha3Digest256 = new SHA3Digest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        private final SHA3Digest sha3Digest512 = new SHA3Digest(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);

        ShakeSymmetric() {
        }
    }

    Symmetric() {
    }
}

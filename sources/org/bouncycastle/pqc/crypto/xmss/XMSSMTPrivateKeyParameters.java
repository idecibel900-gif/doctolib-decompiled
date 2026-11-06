package org.bouncycastle.pqc.crypto.xmss;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes5.dex */
public final class XMSSMTPrivateKeyParameters extends XMSSMTKeyParameters implements Encodable {
    private volatile BDSStateMap bdsState;
    private volatile long index;
    private final XMSSMTParameters params;
    private final byte[] publicSeed;
    private final byte[] root;
    private final byte[] secretKeyPRF;
    private final byte[] secretKeySeed;

    public static class Builder {
        private final XMSSMTParameters params;
        private long index = 0;
        private long maxIndex = -1;
        private byte[] secretKeySeed = null;
        private byte[] secretKeyPRF = null;
        private byte[] publicSeed = null;
        private byte[] root = null;
        private BDSStateMap bdsState = null;
        private byte[] privateKey = null;
        private XMSSParameters xmss = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.params = xMSSMTParameters;
        }

        public XMSSMTPrivateKeyParameters build() {
            return new XMSSMTPrivateKeyParameters(this);
        }

        public Builder withBDSState(BDSStateMap bDSStateMap) {
            if (bDSStateMap.getMaxIndex() == 0) {
                this.bdsState = new BDSStateMap(bDSStateMap, (1 << this.params.getHeight()) - 1);
                return this;
            }
            this.bdsState = bDSStateMap;
            return this;
        }

        public Builder withIndex(long j) {
            this.index = j;
            return this;
        }

        public Builder withMaxIndex(long j) {
            this.maxIndex = j;
            return this;
        }

        public Builder withPublicSeed(byte[] bArr) {
            this.publicSeed = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withRoot(byte[] bArr) {
            this.root = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeyPRF(byte[] bArr) {
            this.secretKeyPRF = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSecretKeySeed(byte[] bArr) {
            this.secretKeySeed = XMSSUtil.cloneArray(bArr);
            return this;
        }
    }

    private XMSSMTPrivateKeyParameters(Builder builder) {
        super(true, builder.params.getTreeDigest());
        XMSSMTParameters xMSSMTParameters = builder.params;
        this.params = xMSSMTParameters;
        if (xMSSMTParameters == null) {
            throw new NullPointerException("params == null");
        }
        int treeDigestSize = xMSSMTParameters.getTreeDigestSize();
        byte[] bArr = builder.privateKey;
        if (bArr != null) {
            if (builder.xmss == null) {
                throw new NullPointerException("xmss == null");
            }
            int height = xMSSMTParameters.getHeight();
            int i = (height + 7) / 8;
            this.index = XMSSUtil.bytesToXBigEndian(bArr, 0, i);
            if (!XMSSUtil.isIndexValid(height, this.index)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.secretKeySeed = XMSSUtil.extractBytesAtOffset(bArr, i, treeDigestSize);
            int i2 = i + treeDigestSize;
            this.secretKeyPRF = XMSSUtil.extractBytesAtOffset(bArr, i2, treeDigestSize);
            int i3 = i2 + treeDigestSize;
            this.publicSeed = XMSSUtil.extractBytesAtOffset(bArr, i3, treeDigestSize);
            int i4 = i3 + treeDigestSize;
            this.root = XMSSUtil.extractBytesAtOffset(bArr, i4, treeDigestSize);
            int i5 = i4 + treeDigestSize;
            try {
                this.bdsState = ((BDSStateMap) XMSSUtil.deserialize(XMSSUtil.extractBytesAtOffset(bArr, i5, bArr.length - i5), BDSStateMap.class)).withWOTSDigest(builder.xmss.getTreeDigestOID());
                return;
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }
        this.index = builder.index;
        byte[] bArr2 = builder.secretKeySeed;
        if (bArr2 == null) {
            this.secretKeySeed = new byte[treeDigestSize];
        } else {
            if (bArr2.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.secretKeySeed = bArr2;
        }
        byte[] bArr3 = builder.secretKeyPRF;
        if (bArr3 == null) {
            this.secretKeyPRF = new byte[treeDigestSize];
        } else {
            if (bArr3.length != treeDigestSize) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.secretKeyPRF = bArr3;
        }
        byte[] bArr4 = builder.publicSeed;
        if (bArr4 == null) {
            this.publicSeed = new byte[treeDigestSize];
        } else {
            if (bArr4.length != treeDigestSize) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.publicSeed = bArr4;
        }
        byte[] bArr5 = builder.root;
        if (bArr5 == null) {
            this.root = new byte[treeDigestSize];
        } else {
            if (bArr5.length != treeDigestSize) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.root = bArr5;
        }
        BDSStateMap bDSStateMap = builder.bdsState;
        if (bDSStateMap != null) {
            this.bdsState = bDSStateMap;
        } else {
            if (!XMSSUtil.isIndexValid(xMSSMTParameters.getHeight(), builder.index) || bArr4 == null || bArr2 == null) {
                bDSStateMap = new BDSStateMap(builder.maxIndex + 1);
                this.bdsState = bDSStateMap;
            } else {
                this.bdsState = new BDSStateMap(xMSSMTParameters, builder.index, bArr4, bArr2);
            }
        }
        if (builder.maxIndex >= 0 && builder.maxIndex != this.bdsState.getMaxIndex()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        byte[] byteArray;
        synchronized (this) {
            byteArray = toByteArray();
        }
        return byteArray;
    }

    public XMSSMTParameters getParameters() {
        return this.params;
    }

    public byte[] toByteArray() {
        byte[] bArrConcatenate;
        synchronized (this) {
            try {
                int treeDigestSize = this.params.getTreeDigestSize();
                int height = (this.params.getHeight() + 7) / 8;
                byte[] bArr = new byte[height + treeDigestSize + treeDigestSize + treeDigestSize + treeDigestSize];
                XMSSUtil.copyBytesAtOffset(bArr, XMSSUtil.toBytesBigEndian(this.index, height), 0);
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeySeed, height);
                int i = height + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.secretKeyPRF, i);
                int i2 = i + treeDigestSize;
                XMSSUtil.copyBytesAtOffset(bArr, this.publicSeed, i2);
                XMSSUtil.copyBytesAtOffset(bArr, this.root, i2 + treeDigestSize);
                try {
                    bArrConcatenate = Arrays.concatenate(bArr, XMSSUtil.serialize(this.bdsState));
                } catch (IOException e) {
                    throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrConcatenate;
    }
}

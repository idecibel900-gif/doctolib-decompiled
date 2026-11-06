package org.bouncycastle.pqc.crypto.lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes5.dex */
public class HSSPrivateKeyParameters extends LMSKeyParameters {
    private long index;
    private final long indexLimit;
    private final boolean isShard;
    private List keys;
    private final int l;
    private HSSPublicKeyParameters publicKey;
    private List sig;

    private HSSPrivateKeyParameters(int i, List list, List list2, long j, long j2, boolean z) {
        super(true);
        this.index = 0L;
        this.l = i;
        this.keys = Collections.unmodifiableList(list);
        this.sig = Collections.unmodifiableList(list2);
        this.index = j;
        this.indexLimit = j2;
        this.isShard = z;
    }

    public HSSPrivateKeyParameters(LMSPrivateKeyParameters lMSPrivateKeyParameters, long j, long j2) {
        super(true);
        this.index = 0L;
        this.l = 1;
        this.keys = Collections.singletonList(lMSPrivateKeyParameters);
        this.sig = Collections.EMPTY_LIST;
        this.index = j;
        this.indexLimit = j2;
        this.isShard = false;
        resetKeyToIndex();
    }

    public static HSSPrivateKeyParameters getInstance(Object obj) throws Throwable {
        Throwable th;
        if (obj instanceof HSSPrivateKeyParameters) {
            return (HSSPrivateKeyParameters) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i = dataInputStream.readInt();
            long j = dataInputStream.readLong();
            long j2 = dataInputStream.readLong();
            boolean z = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(LMSPrivateKeyParameters.getInstance(obj));
            }
            for (int i3 = 0; i3 < i - 1; i3++) {
                arrayList2.add(LMSSignature.getInstance(obj));
            }
            return new HSSPrivateKeyParameters(i, arrayList, arrayList2, j, j2, z);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(Streams.readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                try {
                    HSSPrivateKeyParameters hSSPrivateKeyParameters = getInstance(dataInputStream3);
                    dataInputStream3.close();
                    return hSSPrivateKeyParameters;
                } catch (Exception unused) {
                    LMSPrivateKeyParameters lMSPrivateKeyParameters = LMSPrivateKeyParameters.getInstance(obj);
                    HSSPrivateKeyParameters hSSPrivateKeyParameters2 = new HSSPrivateKeyParameters(lMSPrivateKeyParameters, lMSPrivateKeyParameters.getIndex(), lMSPrivateKeyParameters.getIndexLimit());
                    dataInputStream3.close();
                    return hSSPrivateKeyParameters2;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 == null) {
                    throw th;
                }
                dataInputStream2.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static HSSPrivateKeyParameters getInstance(byte[] bArr, byte[] bArr2) throws Throwable {
        HSSPrivateKeyParameters hSSPrivateKeyParameters = getInstance(bArr);
        hSSPrivateKeyParameters.publicKey = HSSPublicKeyParameters.getInstance(bArr2);
        return hSSPrivateKeyParameters;
    }

    private static HSSPrivateKeyParameters makeCopy(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        try {
            return getInstance(hSSPrivateKeyParameters.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    protected Object clone() {
        return makeCopy(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters) obj;
        if (this.l == hSSPrivateKeyParameters.l && this.isShard == hSSPrivateKeyParameters.isShard && this.indexLimit == hSSPrivateKeyParameters.indexLimit && this.index == hSSPrivateKeyParameters.index && this.keys.equals(hSSPrivateKeyParameters.keys)) {
            return this.sig.equals(hSSPrivateKeyParameters.sig);
        }
        return false;
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public synchronized byte[] getEncoded() {
        Composer composerBool;
        try {
            composerBool = Composer.compose().u32str(0).u32str(this.l).u64str(this.index).u64str(this.indexLimit).bool(this.isShard);
            Iterator it = this.keys.iterator();
            while (it.hasNext()) {
                composerBool.bytes((LMSPrivateKeyParameters) it.next());
            }
            Iterator it2 = this.sig.iterator();
            while (it2.hasNext()) {
                composerBool.bytes((LMSSignature) it2.next());
            }
        } catch (Throwable th) {
            throw th;
        }
        return composerBool.build();
    }

    public synchronized long getIndex() {
        return this.index;
    }

    synchronized List getKeys() {
        return this.keys;
    }

    public int getL() {
        return this.l;
    }

    public synchronized HSSPublicKeyParameters getPublicKey() {
        return new HSSPublicKeyParameters(this.l, getRootKey().getPublicKey());
    }

    LMSPrivateKeyParameters getRootKey() {
        return (LMSPrivateKeyParameters) this.keys.get(0);
    }

    public int hashCode() {
        int iHashCode = ((((((this.l * 31) + (this.isShard ? 1 : 0)) * 31) + this.keys.hashCode()) * 31) + this.sig.hashCode()) * 31;
        long j = this.indexLimit;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.index;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    void resetKeyToIndex() {
        boolean z;
        List keys = getKeys();
        int size = keys.size();
        long[] jArr = new long[size];
        long index = getIndex();
        for (int size2 = keys.size() - 1; size2 >= 0; size2--) {
            LMSigParameters sigParameters = ((LMSPrivateKeyParameters) keys.get(size2)).getSigParameters();
            jArr[size2] = ((long) ((1 << sigParameters.getH()) - 1)) & index;
            index >>>= sigParameters.getH();
        }
        LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr = (LMSPrivateKeyParameters[]) keys.toArray(new LMSPrivateKeyParameters[keys.size()]);
        List list = this.sig;
        LMSSignature[] lMSSignatureArr = (LMSSignature[]) list.toArray(new LMSSignature[list.size()]);
        LMSPrivateKeyParameters rootKey = getRootKey();
        if (lMSPrivateKeyParametersArr[0].getIndex() - 1 != jArr[0]) {
            lMSPrivateKeyParametersArr[0] = LMS.generateKeys(rootKey.getSigParameters(), rootKey.getOtsParameters(), (int) jArr[0], rootKey.getI(), rootKey.getMasterSecret());
            z = true;
        } else {
            z = false;
        }
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            LMSPrivateKeyParameters lMSPrivateKeyParameters = lMSPrivateKeyParametersArr[i2];
            int n = lMSPrivateKeyParameters.getOtsParameters().getN();
            byte[] bArr = new byte[16];
            byte[] bArr2 = new byte[n];
            SeedDerive seedDerive = new SeedDerive(lMSPrivateKeyParameters.getI(), lMSPrivateKeyParameters.getMasterSecret(), DigestUtil.getDigest(lMSPrivateKeyParameters.getOtsParameters()));
            seedDerive.setQ((int) jArr[i2]);
            seedDerive.setJ(-2);
            seedDerive.deriveSeed(bArr2, true);
            byte[] bArr3 = new byte[n];
            seedDerive.deriveSeed(bArr3, false);
            System.arraycopy(bArr3, 0, bArr, 0, 16);
            boolean z2 = i >= size + (-1) ? jArr[i] == ((long) lMSPrivateKeyParametersArr[i].getIndex()) : jArr[i] == ((long) (lMSPrivateKeyParametersArr[i].getIndex() - 1));
            if (Arrays.areEqual(bArr, lMSPrivateKeyParametersArr[i].getI()) && Arrays.areEqual(bArr2, lMSPrivateKeyParametersArr[i].getMasterSecret())) {
                if (!z2) {
                    lMSPrivateKeyParametersArr[i] = LMS.generateKeys(((LMSPrivateKeyParameters) keys.get(i)).getSigParameters(), ((LMSPrivateKeyParameters) keys.get(i)).getOtsParameters(), (int) jArr[i], bArr, bArr2);
                }
                i++;
            } else {
                LMSPrivateKeyParameters lMSPrivateKeyParametersGenerateKeys = LMS.generateKeys(((LMSPrivateKeyParameters) keys.get(i)).getSigParameters(), ((LMSPrivateKeyParameters) keys.get(i)).getOtsParameters(), (int) jArr[i], bArr, bArr2);
                lMSPrivateKeyParametersArr[i] = lMSPrivateKeyParametersGenerateKeys;
                lMSSignatureArr[i2] = LMS.generateSign(lMSPrivateKeyParametersArr[i2], lMSPrivateKeyParametersGenerateKeys.getPublicKey().toByteArray());
            }
            z = true;
            i++;
        }
        if (z) {
            updateHierarchy(lMSPrivateKeyParametersArr, lMSSignatureArr);
        }
    }

    protected void updateHierarchy(LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr, LMSSignature[] lMSSignatureArr) {
        synchronized (this) {
            this.keys = Collections.unmodifiableList(java.util.Arrays.asList(lMSPrivateKeyParametersArr));
            this.sig = Collections.unmodifiableList(java.util.Arrays.asList(lMSSignatureArr));
        }
    }
}

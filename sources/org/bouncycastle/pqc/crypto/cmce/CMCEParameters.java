package org.bouncycastle.pqc.crypto.cmce;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes5.dex */
public class CMCEParameters implements CipherParameters {
    public static final CMCEParameters mceliece348864fr3;
    public static final CMCEParameters mceliece348864r3;
    private static int[] poly3488;
    private final int defaultKeySize;
    private final CMCEEngine engine;
    private final int m;
    private final int n;
    private final String name;
    private final int t;
    private final boolean usePivots;
    private static int[] poly4608 = {10, 9, 6, 0};
    private static int[] poly6688 = {7, 2, 1, 0};
    private static int[] poly6960 = {8, 0};
    private static int[] poly8192 = {7, 2, 1, 0};
    public static final CMCEParameters mceliece460896r3 = new CMCEParameters("mceliece460896", 13, 4608, 96, poly4608, false, JfifUtil.MARKER_SOFn);
    public static final CMCEParameters mceliece460896fr3 = new CMCEParameters("mceliece460896f", 13, 4608, 96, poly4608, true, JfifUtil.MARKER_SOFn);
    public static final CMCEParameters mceliece6688128r3 = new CMCEParameters("mceliece6688128", 13, 6688, 128, poly6688, false, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final CMCEParameters mceliece6688128fr3 = new CMCEParameters("mceliece6688128f", 13, 6688, 128, poly6688, true, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final CMCEParameters mceliece6960119r3 = new CMCEParameters("mceliece6960119", 13, 6960, 119, poly6960, false, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final CMCEParameters mceliece6960119fr3 = new CMCEParameters("mceliece6960119f", 13, 6960, 119, poly6960, true, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final CMCEParameters mceliece8192128r3 = new CMCEParameters("mceliece8192128", 13, 8192, 128, poly8192, false, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public static final CMCEParameters mceliece8192128fr3 = new CMCEParameters("mceliece8192128f", 13, 8192, 128, poly8192, true, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);

    static {
        int[] iArr = {3, 1, 0};
        poly3488 = iArr;
        mceliece348864r3 = new CMCEParameters("mceliece348864", 12, 3488, 64, iArr, false, 128);
        mceliece348864fr3 = new CMCEParameters("mceliece348864f", 12, 3488, 64, poly3488, true, 128);
    }

    private CMCEParameters(String str, int i, int i2, int i3, int[] iArr, boolean z, int i4) {
        this.name = str;
        this.m = i;
        this.n = i2;
        this.t = i3;
        this.usePivots = z;
        this.defaultKeySize = i4;
        this.engine = new CMCEEngine(i, i2, i3, iArr, z, i4);
    }

    CMCEEngine getEngine() {
        return this.engine;
    }

    public String getName() {
        return this.name;
    }

    public int getT() {
        return this.t;
    }
}

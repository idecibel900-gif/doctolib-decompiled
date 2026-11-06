package org.bouncycastle.pqc.crypto.bike;

import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes5.dex */
public class BIKEParameters implements CipherParameters {
    public static final BIKEParameters bike128 = new BIKEParameters("bike128", 12323, 142, 134, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, 5, 3, 128);
    public static final BIKEParameters bike192 = new BIKEParameters("bike192", 24659, 206, 199, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, 5, 3, JfifUtil.MARKER_SOFn);
    public static final BIKEParameters bike256 = new BIKEParameters("bike256", 40973, TiffUtil.TIFF_TAG_ORIENTATION, 264, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, 5, 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    private BIKEEngine bikeEngine;
    private final int defaultKeySize;
    private int l;
    private String name;
    private int nbIter;
    private int r;
    private int t;
    private int tau;
    private int w;

    private BIKEParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.name = str;
        this.r = i;
        this.w = i2;
        this.t = i3;
        this.l = i4;
        this.nbIter = i5;
        this.tau = i6;
        this.defaultKeySize = i7;
        this.bikeEngine = new BIKEEngine(i, i2, i3, i4, i5, i6);
    }

    public String getName() {
        return this.name;
    }

    public int getRByte() {
        return (this.r + 7) / 8;
    }
}

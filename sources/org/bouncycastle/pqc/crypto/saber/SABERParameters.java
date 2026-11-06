package org.bouncycastle.pqc.crypto.saber;

import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes5.dex */
public class SABERParameters implements CipherParameters {
    private final int defaultKeySize;
    private final SABEREngine engine;
    private final int l;
    private final String name;
    public static final SABERParameters lightsaberkem128r3 = new SABERParameters("lightsaberkem128r3", 2, 128, false, false);
    public static final SABERParameters saberkem128r3 = new SABERParameters("saberkem128r3", 3, 128, false, false);
    public static final SABERParameters firesaberkem128r3 = new SABERParameters("firesaberkem128r3", 4, 128, false, false);
    public static final SABERParameters lightsaberkem192r3 = new SABERParameters("lightsaberkem192r3", 2, JfifUtil.MARKER_SOFn, false, false);
    public static final SABERParameters saberkem192r3 = new SABERParameters("saberkem192r3", 3, JfifUtil.MARKER_SOFn, false, false);
    public static final SABERParameters firesaberkem192r3 = new SABERParameters("firesaberkem192r3", 4, JfifUtil.MARKER_SOFn, false, false);
    public static final SABERParameters lightsaberkem256r3 = new SABERParameters("lightsaberkem256r3", 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, false);
    public static final SABERParameters saberkem256r3 = new SABERParameters("saberkem256r3", 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, false);
    public static final SABERParameters firesaberkem256r3 = new SABERParameters("firesaberkem256r3", 4, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, false);
    public static final SABERParameters lightsaberkem90sr3 = new SABERParameters("lightsaberkem90sr3", 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, false);
    public static final SABERParameters saberkem90sr3 = new SABERParameters("saberkem90sr3", 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, false);
    public static final SABERParameters firesaberkem90sr3 = new SABERParameters("firesaberkem90sr3", 4, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, false);
    public static final SABERParameters ulightsaberkemr3 = new SABERParameters("ulightsaberkemr3", 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, true);
    public static final SABERParameters usaberkemr3 = new SABERParameters("usaberkemr3", 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, true);
    public static final SABERParameters ufiresaberkemr3 = new SABERParameters("ufiresaberkemr3", 4, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, false, true);
    public static final SABERParameters ulightsaberkem90sr3 = new SABERParameters("ulightsaberkem90sr3", 2, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, true);
    public static final SABERParameters usaberkem90sr3 = new SABERParameters("usaberkem90sr3", 3, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, true);
    public static final SABERParameters ufiresaberkem90sr3 = new SABERParameters("ufiresaberkem90sr3", 4, IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER, true, true);

    public SABERParameters(String str, int i, int i2, boolean z, boolean z2) {
        this.name = str;
        this.l = i;
        this.defaultKeySize = i2;
        this.engine = new SABEREngine(i, i2, z, z2);
    }
}

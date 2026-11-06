package com.github.penfeizhou.animation.webp.decode;

import com.github.penfeizhou.animation.webp.io.WebPReader;

/* JADX INFO: loaded from: classes3.dex */
public class ANIMChunk extends BaseChunk {
    static final int ID = BaseChunk.fourCCToInt("ANIM");
    int backgroundColor;
    int loopCount;

    @Override // com.github.penfeizhou.animation.webp.decode.BaseChunk
    void innerParse(WebPReader webPReader) {
        this.backgroundColor = webPReader.getUInt32();
        this.loopCount = webPReader.getUInt16();
    }
}

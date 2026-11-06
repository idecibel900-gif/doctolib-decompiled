package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;

/* JADX INFO: loaded from: classes3.dex */
class ACTLChunk extends Chunk {
    static final int ID = Chunk.fourCCToInt("acTL");
    int num_frames;
    int num_plays;

    ACTLChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) {
        this.num_frames = aPNGReader.readInt();
        this.num_plays = aPNGReader.readInt();
    }
}

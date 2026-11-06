package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;

/* JADX INFO: loaded from: classes3.dex */
class FDATChunk extends Chunk {
    static final int ID = Chunk.fourCCToInt("fdAT");
    int sequence_number;

    FDATChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) {
        this.sequence_number = aPNGReader.readInt();
    }
}

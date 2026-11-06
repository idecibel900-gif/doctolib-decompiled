package com.github.penfeizhou.animation.webp.decode;

import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WebPParser {

    static class FormatException extends IOException {
        FormatException() {
            super("WebP Format error");
        }
    }

    public static boolean isAWebP(Reader reader) {
        WebPReader webPReader = reader instanceof WebPReader ? (WebPReader) reader : new WebPReader(reader);
        try {
            if (!webPReader.matchFourCC("RIFF")) {
                return false;
            }
            webPReader.skip(4L);
            if (!webPReader.matchFourCC("WEBP")) {
                return false;
            }
            while (webPReader.available() > 0) {
                BaseChunk chunk = parseChunk(webPReader);
                if (chunk instanceof VP8XChunk) {
                    return ((VP8XChunk) chunk).animation();
                }
            }
        } catch (IOException e) {
            if (!(e instanceof FormatException)) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static List parse(WebPReader webPReader) throws IOException {
        if (!webPReader.matchFourCC("RIFF")) {
            throw new FormatException();
        }
        webPReader.skip(4L);
        if (!webPReader.matchFourCC("WEBP")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (webPReader.available() > 0) {
            arrayList.add(parseChunk(webPReader));
        }
        return arrayList;
    }

    static BaseChunk parseChunk(WebPReader webPReader) {
        BaseChunk baseChunk;
        int iPosition = webPReader.position();
        int fourCC = webPReader.getFourCC();
        int uInt32 = webPReader.getUInt32();
        if (VP8XChunk.ID == fourCC) {
            baseChunk = new VP8XChunk();
        } else if (ANIMChunk.ID == fourCC) {
            baseChunk = new ANIMChunk();
        } else if (ANMFChunk.ID == fourCC) {
            baseChunk = new ANMFChunk();
        } else if (ALPHChunk.ID == fourCC) {
            baseChunk = new ALPHChunk();
        } else if (VP8Chunk.ID == fourCC) {
            baseChunk = new VP8Chunk();
        } else if (VP8LChunk.ID == fourCC) {
            baseChunk = new VP8LChunk();
        } else if (ICCPChunk.ID == fourCC) {
            baseChunk = new ICCPChunk();
        } else if (XMPChunk.ID == fourCC) {
            baseChunk = new XMPChunk();
        } else if (EXIFChunk.ID == fourCC) {
            baseChunk = new EXIFChunk();
        } else {
            baseChunk = new BaseChunk();
        }
        baseChunk.chunkFourCC = fourCC;
        baseChunk.payloadSize = uInt32;
        baseChunk.offset = iPosition;
        baseChunk.parse(webPReader);
        return baseChunk;
    }
}

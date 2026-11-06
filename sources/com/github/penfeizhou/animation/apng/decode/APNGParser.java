package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.io.APNGReader;
import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class APNGParser {

    static class FormatException extends IOException {
        FormatException() {
            super("APNG Format error");
        }
    }

    public static boolean isAPNG(Reader reader) {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
                throw new FormatException();
            }
            while (aPNGReader.available() > 0) {
                if (parseChunk(aPNGReader) instanceof ACTLChunk) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List parse(APNGReader aPNGReader) throws FormatException {
        if (!aPNGReader.matchFourCC("\u0089PNG") || !aPNGReader.matchFourCC("\r\n\u001a\n")) {
            throw new FormatException();
        }
        ArrayList arrayList = new ArrayList();
        while (aPNGReader.available() > 0) {
            arrayList.add(parseChunk(aPNGReader));
        }
        return arrayList;
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        Chunk chunk;
        int iPosition = aPNGReader.position();
        int i = aPNGReader.readInt();
        int fourCC = aPNGReader.readFourCC();
        if (fourCC == ACTLChunk.ID) {
            chunk = new ACTLChunk();
        } else if (fourCC == FCTLChunk.ID) {
            chunk = new FCTLChunk();
        } else if (fourCC == FDATChunk.ID) {
            chunk = new FDATChunk();
        } else if (fourCC == IDATChunk.ID) {
            chunk = new IDATChunk();
        } else if (fourCC == IENDChunk.ID) {
            chunk = new IENDChunk();
        } else if (fourCC == IHDRChunk.ID) {
            chunk = new IHDRChunk();
        } else {
            chunk = new Chunk();
        }
        chunk.offset = iPosition;
        chunk.fourcc = fourCC;
        chunk.length = i;
        chunk.parse(aPNGReader);
        chunk.crc = aPNGReader.readInt();
        return chunk;
    }
}

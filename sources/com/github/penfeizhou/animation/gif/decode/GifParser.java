package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.io.GifReader;
import com.github.penfeizhou.animation.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GifParser {

    static class FormatException extends IOException {
        FormatException() {
            super("Gif Format error");
        }
    }

    public static boolean isGif(Reader reader) {
        try {
            checkHeader(reader instanceof GifReader ? (GifReader) reader : new GifReader(reader));
            return true;
        } catch (IOException e) {
            if (e instanceof FormatException) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static List parse(GifReader gifReader) throws IOException {
        Block blockRetrieve;
        checkHeader(gifReader);
        ArrayList arrayList = new ArrayList();
        LogicalScreenDescriptor logicalScreenDescriptor = new LogicalScreenDescriptor();
        logicalScreenDescriptor.receive(gifReader);
        arrayList.add(logicalScreenDescriptor);
        if (logicalScreenDescriptor.gColorTableFlag()) {
            ColorTable colorTable = new ColorTable(logicalScreenDescriptor.gColorTableSize());
            colorTable.receive(gifReader);
            arrayList.add(colorTable);
        }
        while (true) {
            try {
                byte bPeek = gifReader.peek();
                if (bPeek == 59) {
                    return arrayList;
                }
                if (bPeek == 33) {
                    blockRetrieve = ExtensionBlock.retrieve(gifReader);
                } else {
                    blockRetrieve = bPeek != 44 ? null : new ImageDescriptor();
                }
                if (blockRetrieve != null) {
                    blockRetrieve.receive(gifReader);
                    arrayList.add(blockRetrieve);
                } else {
                    throw new FormatException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return arrayList;
            }
        }
    }

    private static void checkHeader(GifReader gifReader) throws FormatException {
        byte bPeek;
        if (gifReader.peek() != 71 || gifReader.peek() != 73 || gifReader.peek() != 70 || gifReader.peek() != 56 || (((bPeek = gifReader.peek()) != 55 && bPeek != 57) || gifReader.peek() != 97)) {
            throw new FormatException();
        }
    }
}

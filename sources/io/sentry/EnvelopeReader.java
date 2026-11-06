package io.sentry;

import com.adjust.sdk.Constants;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public final class EnvelopeReader implements IEnvelopeReader {
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    private final ISerializer serializer;

    public EnvelopeReader(ISerializer iSerializer) {
        this.serializer = iSerializer;
    }

    @Override // io.sentry.IEnvelopeReader
    public SentryEnvelope read(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = -1;
        while (true) {
            try {
                int i3 = inputStream.read(bArr);
                if (i3 <= 0) {
                    break;
                }
                for (int i4 = 0; i2 == -1 && i4 < i3; i4++) {
                    if (bArr[i4] == 10) {
                        i2 = i + i4;
                        break;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, i3);
                i += i3;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length == 0) {
            throw new IllegalArgumentException("Empty stream.");
        }
        if (i2 == -1) {
            throw new IllegalArgumentException("Envelope contains no header.");
        }
        SentryEnvelopeHeader sentryEnvelopeHeaderDeserializeEnvelopeHeader = deserializeEnvelopeHeader(byteArray, 0, i2);
        if (sentryEnvelopeHeaderDeserializeEnvelopeHeader == null) {
            throw new IllegalArgumentException("Envelope header is null.");
        }
        int i5 = i2 + 1;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i6 = i5;
            while (true) {
                if (i6 >= byteArray.length) {
                    i6 = -1;
                    break;
                }
                if (byteArray[i6] == 10) {
                    break;
                }
                i6++;
            }
            if (i6 == -1) {
                throw new IllegalArgumentException("Invalid envelope. Item at index '" + arrayList.size() + "'. has no header delimiter.");
            }
            SentryEnvelopeItemHeader sentryEnvelopeItemHeaderDeserializeEnvelopeItemHeader = deserializeEnvelopeItemHeader(byteArray, i5, i6 - i5);
            if (sentryEnvelopeItemHeaderDeserializeEnvelopeItemHeader == null || sentryEnvelopeItemHeaderDeserializeEnvelopeItemHeader.getLength() <= 0) {
                throw new IllegalArgumentException("Item header at index '" + arrayList.size() + "' is null or empty.");
            }
            int length = sentryEnvelopeItemHeaderDeserializeEnvelopeItemHeader.getLength() + i6;
            int i7 = length + 1;
            if (i7 > byteArray.length) {
                throw new IllegalArgumentException("Invalid length for item at index '" + arrayList.size() + "'. Item is '" + i7 + "' bytes. There are '" + byteArray.length + "' in the buffer.");
            }
            arrayList.add(new SentryEnvelopeItem(sentryEnvelopeItemHeaderDeserializeEnvelopeItemHeader, Arrays.copyOfRange(byteArray, i6 + 1, i7)));
            if (i7 == byteArray.length) {
                break;
            }
            i5 = length + 2;
            if (i5 == byteArray.length) {
                if (byteArray[i7] == 10) {
                    break;
                }
                throw new IllegalArgumentException("Envelope has invalid data following an item.");
            }
        }
        SentryEnvelope sentryEnvelope = new SentryEnvelope(sentryEnvelopeHeaderDeserializeEnvelopeHeader, arrayList);
        byteArrayOutputStream.close();
        return sentryEnvelope;
    }

    private SentryEnvelopeHeader deserializeEnvelopeHeader(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, UTF_8));
        try {
            SentryEnvelopeHeader sentryEnvelopeHeader = (SentryEnvelopeHeader) this.serializer.deserialize(stringReader, SentryEnvelopeHeader.class);
            stringReader.close();
            return sentryEnvelopeHeader;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private SentryEnvelopeItemHeader deserializeEnvelopeItemHeader(byte[] bArr, int i, int i2) {
        StringReader stringReader = new StringReader(new String(bArr, i, i2, UTF_8));
        try {
            SentryEnvelopeItemHeader sentryEnvelopeItemHeader = (SentryEnvelopeItemHeader) this.serializer.deserialize(stringReader, SentryEnvelopeItemHeader.class);
            stringReader.close();
            return sentryEnvelopeItemHeader;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}

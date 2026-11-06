package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class FlacFrameReader {

    public static final class SampleNumberHolder {
        public long sampleNumber;
    }

    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        int position = parsableByteArray.getPosition();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long j = unsignedInt >>> 16;
        if (j != i) {
            return false;
        }
        return checkChannelAssignment((int) ((unsignedInt >> 4) & 15), flacStreamMetadata) && checkBitsPerSample((int) ((unsignedInt >> 1) & 7), flacStreamMetadata) && !(((unsignedInt & 1) > 1L ? 1 : ((unsignedInt & 1) == 1L ? 0 : -1)) == 0) && checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, sampleNumberHolder) && checkAndReadBlockSizeSamples(parsableByteArray, flacStreamMetadata, (int) ((unsignedInt >> 12) & 15)) && checkAndReadSampleRate(parsableByteArray, flacStreamMetadata, (int) ((unsignedInt >> 8) & 15)) && checkAndReadCrc(parsableByteArray, position);
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i, SampleNumberHolder sampleNumberHolder) {
        long peekPosition = extractorInput.getPeekPosition();
        byte[] bArr = new byte[2];
        extractorInput.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            extractorInput.resetPeekPosition();
            extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.getData(), 0, 2);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 2, 14));
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition((int) (peekPosition - extractorInput.getPosition()));
        return checkAndReadFrameHeader(parsableByteArray, flacStreamMetadata, i, sampleNumberHolder);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws ParserException {
        extractorInput.resetPeekPosition();
        extractorInput.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        extractorInput.peekFully(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        extractorInput.advancePeekPosition(2);
        int i = z ? 7 : 6;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i);
        parsableByteArray.setLimit(ExtractorUtil.peekToLength(extractorInput, parsableByteArray.getData(), 0, i));
        extractorInput.resetPeekPosition();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (!checkAndReadFirstSampleNumber(parsableByteArray, flacStreamMetadata, z, sampleNumberHolder)) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        return sampleNumberHolder.sampleNumber;
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray, int i) {
        switch (i) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return parsableByteArray.readUnsignedByte() + 1;
            case 7:
                return parsableByteArray.readUnsignedShort() + 1;
            case 8:
            case 9:
            case 10:
            case BaseVideoCapturer.RGBA /* 11 */:
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
            case 13:
            case 14:
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean checkChannelAssignment(int i, FlacStreamMetadata flacStreamMetadata) {
        if (i <= 7) {
            return i == flacStreamMetadata.channels - 1;
        }
        return i <= 10 && flacStreamMetadata.channels == 2;
    }

    private static boolean checkBitsPerSample(int i, FlacStreamMetadata flacStreamMetadata) {
        return i == 0 || i == flacStreamMetadata.bitsPerSampleLookupKey;
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z, SampleNumberHolder sampleNumberHolder) {
        try {
            long utf8EncodedLong = parsableByteArray.readUtf8EncodedLong();
            if (!z) {
                utf8EncodedLong *= (long) flacStreamMetadata.maxBlockSizeSamples;
            }
            sampleNumberHolder.sampleNumber = utf8EncodedLong;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int frameBlockSizeSamplesFromKey = readFrameBlockSizeSamplesFromKey(parsableByteArray, i);
        return frameBlockSizeSamplesFromKey != -1 && frameBlockSizeSamplesFromKey <= flacStreamMetadata.maxBlockSizeSamples;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i) {
        int i2 = flacStreamMetadata.sampleRate;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == flacStreamMetadata.sampleRateLookupKey;
        }
        if (i == 12) {
            return parsableByteArray.readUnsignedByte() * 1000 == i2;
        }
        if (i <= 14) {
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (i == 14) {
                unsignedShort *= 10;
            }
            if (unsignedShort == i2) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray, int i) {
        return parsableByteArray.readUnsignedByte() == Util.crc8(parsableByteArray.getData(), i, parsableByteArray.getPosition() - 1, 0);
    }
}

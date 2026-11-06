package androidx.media3.common.util;

import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.common.collect.ImmutableList;
import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodecSpecificDataUtil {
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final String[] HEVC_GENERAL_PROFILE_SPACE_STRINGS = {"", "A", "B", "C"};
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");

    private static int ac4BitstreamAndPresentationVersionsToProfileConst(int i, int i2) {
        if (i == 0) {
            return i2 == 0 ? 257 : -1;
        }
        if (i == 1) {
            if (i2 == 0) {
                return 513;
            }
            return i2 == 1 ? 514 : -1;
        }
        if (i != 2) {
            return -1;
        }
        if (i2 == 1) {
            return 1026;
        }
        return i2 == 2 ? 1028 : -1;
    }

    private static int ac4LevelNumberToConst(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 4;
        }
        if (i != 3) {
            return i != 4 ? -1 : 16;
        }
        return 8;
    }

    private static int av1LevelNumberToConst(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
            case 9:
                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
            case 10:
                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
            case BaseVideoCapturer.RGBA /* 11 */:
                return 2048;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return Http2.INITIAL_MAX_FRAME_SIZE;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int avcLevelNumberToConst(int i) {
        switch (i) {
            case 10:
                return 1;
            case BaseVideoCapturer.RGBA /* 11 */:
                return 4;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
                            case 32:
                                return IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return Http2.INITIAL_MAX_FRAME_SIZE;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int avcProfileNumberToConst(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    private static int mp4aAudioObjectTypeToProfile(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    private static int vp9LevelNumberToConst(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
        }
        if (i == 51) {
            return IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        }
        switch (i) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int vp9ProfileNumberToConst(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    public static Pair parseAlacAudioSpecificConfig(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(unsignedByte));
    }

    public static List buildCea708InitializationData(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static String buildIamfCodecString(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.skipLeb128();
        parsableByteArray.skipBytes(4);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        parsableByteArray.skipLeb128();
        parsableByteArray.skipLeb128();
        String string = parsableByteArray.readString(4);
        if (string.equals("mp4a")) {
            parsableByteArray.skipLeb128();
            parsableByteArray.skipBytes(2);
            ParsableBitArray parsableBitArray = new ParsableBitArray();
            parsableBitArray.reset(parsableByteArray);
            int bits = parsableBitArray.readBits(5);
            if (bits == 31) {
                bits = parsableBitArray.readBits(6) + 32;
            }
            string = string + ".40." + bits;
        }
        return Util.formatInvariant("iamf.%03X.%03X.%s", Integer.valueOf(unsignedByte), Integer.valueOf(unsignedByte2), string);
    }

    public static boolean parseCea708InitializationData(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static ImmutableList buildVp9CodecPrivateInitializationData(byte b, byte b2, byte b3, byte b4) {
        return ImmutableList.of((Object) new byte[]{1, 1, b, 2, 1, b2, 3, 1, b3, 4, 1, b4});
    }

    public static String buildAvcCodecString(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String buildHevcCodecString(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        StringBuilder sb = new StringBuilder(Util.formatInvariant("hvc1.%s%d.%X.%c%d", HEVC_GENERAL_PROFILE_SPACE_STRINGS[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i4)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static Pair getCodecProfileAndLevel(Format format) {
        String str = format.codecs;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(format.sampleMimeType)) {
            return getDolbyVisionProfileAndLevel(format.codecs, strArrSplit);
        }
        byte b = 0;
        String str2 = strArrSplit[0];
        str2.getClass();
        switch (str2.hashCode()) {
            case 2986313:
                if (!str2.equals("ac-4")) {
                    b = -1;
                }
                break;
            case 3004662:
                b = !str2.equals("av01") ? (byte) -1 : (byte) 1;
                break;
            case 3006243:
                b = !str2.equals("avc1") ? (byte) -1 : (byte) 2;
                break;
            case 3006244:
                b = !str2.equals("avc2") ? (byte) -1 : (byte) 3;
                break;
            case 3199032:
                b = !str2.equals("hev1") ? (byte) -1 : (byte) 4;
                break;
            case 3214780:
                b = !str2.equals("hvc1") ? (byte) -1 : (byte) 5;
                break;
            case 3224753:
                b = !str2.equals("iamf") ? (byte) -1 : (byte) 6;
                break;
            case 3356560:
                b = !str2.equals("mp4a") ? (byte) -1 : (byte) 7;
                break;
            case 3475740:
                b = !str2.equals("s263") ? (byte) -1 : (byte) 8;
                break;
            case 3624515:
                b = !str2.equals("vp09") ? (byte) -1 : (byte) 9;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return getAc4CodecProfileAndLevel(format.codecs, strArrSplit);
            case 1:
                return getAv1ProfileAndLevel(format.codecs, strArrSplit, format.colorInfo);
            case 2:
            case 3:
                return getAvcProfileAndLevel(format.codecs, strArrSplit);
            case 4:
            case 5:
                return getHevcProfileAndLevel(format.codecs, strArrSplit, format.colorInfo);
            case 6:
                return getIamfCodecProfileAndLevel(format.codecs, strArrSplit);
            case 7:
                return getAacCodecProfileAndLevel(format.codecs, strArrSplit);
            case 8:
                return getH263ProfileAndLevel(format.codecs, strArrSplit);
            case 9:
                return getVp9ProfileAndLevel(format.codecs, strArrSplit);
            default:
                return null;
        }
    }

    public static Pair getHevcProfileAndLevel(String str, String[] strArr, ColorInfo colorInfo) {
        if (strArr.length < 4) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            i = 6;
            if ("2".equals(strGroup)) {
                i = (colorInfo == null || colorInfo.colorTransfer != 6) ? 2 : 4096;
            } else if (!"6".equals(strGroup)) {
                Log.w("CodecSpecificDataUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer numHevcCodecStringToProfileLevel = hevcCodecStringToProfileLevel(str2);
        if (numHevcCodecStringToProfileLevel == null) {
            Log.w("CodecSpecificDataUtil", "Unknown HEVC level string: " + str2);
            return null;
        }
        return new Pair(Integer.valueOf(i), numHevcCodecStringToProfileLevel);
    }

    public static byte[] buildNalUnit(byte[] bArr, int i, int i2) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    private static Pair getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numDolbyVisionStringToProfile = dolbyVisionStringToProfile(strGroup);
        if (numDolbyVisionStringToProfile == null) {
            Log.w("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numDolbyVisionStringToLevel = dolbyVisionStringToLevel(str2);
        if (numDolbyVisionStringToLevel == null) {
            Log.w("CodecSpecificDataUtil", "Unknown Dolby Vision level string: " + str2);
            return null;
        }
        return new Pair(numDolbyVisionStringToProfile, numDolbyVisionStringToLevel);
    }

    private static Pair getH263ProfileAndLevel(String str, String[] strArr) {
        Pair pair = new Pair(1, 1);
        if (strArr.length < 3) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
        try {
            return new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
    }

    private static Pair getAvcProfileAndLevel(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int i3 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = i3;
            } else {
                Log.w("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int iAvcProfileNumberToConst = avcProfileNumberToConst(i2);
            if (iAvcProfileNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int iAvcLevelNumberToConst = avcLevelNumberToConst(i);
            if (iAvcLevelNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown AVC level: " + i);
                return null;
            }
            return new Pair(Integer.valueOf(iAvcProfileNumberToConst), Integer.valueOf(iAvcLevelNumberToConst));
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    private static Pair getVp9ProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int iVp9ProfileNumberToConst = vp9ProfileNumberToConst(i);
            if (iVp9ProfileNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown VP9 profile: " + i);
                return null;
            }
            int iVp9LevelNumberToConst = vp9LevelNumberToConst(i2);
            if (iVp9LevelNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown VP9 level: " + i2);
                return null;
            }
            return new Pair(Integer.valueOf(iVp9ProfileNumberToConst), Integer.valueOf(iVp9LevelNumberToConst));
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Pair getAv1ProfileAndLevel(String str, String[] strArr, ColorInfo colorInfo) {
        int i;
        if (strArr.length < 4) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i2 = 1;
        try {
            int i3 = Integer.parseInt(strArr[1]);
            int i4 = Integer.parseInt(strArr[2].substring(0, 2));
            int i5 = Integer.parseInt(strArr[3]);
            if (i3 != 0) {
                Log.w("CodecSpecificDataUtil", "Unknown AV1 profile: " + i3);
                return null;
            }
            if (i5 != 8 && i5 != 10) {
                Log.w("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + i5);
                return null;
            }
            if (i5 != 8) {
                i2 = (colorInfo == null || !(colorInfo.hdrStaticInfo != null || (i = colorInfo.colorTransfer) == 7 || i == 6)) ? 2 : 4096;
            }
            int iAv1LevelNumberToConst = av1LevelNumberToConst(i4);
            if (iAv1LevelNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown AV1 level: " + i4);
                return null;
            }
            return new Pair(Integer.valueOf(i2), Integer.valueOf(iAv1LevelNumberToConst));
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair getAacCodecProfileAndLevel(String str, String[] strArr) {
        int iMp4aAudioObjectTypeToProfile;
        if (strArr.length != 3) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(strArr[1], 16))) && (iMp4aAudioObjectTypeToProfile = mp4aAudioObjectTypeToProfile(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iMp4aAudioObjectTypeToProfile), 0);
            }
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static Pair getAc4CodecProfileAndLevel(String str, String[] strArr) {
        if (strArr.length != 4) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int i3 = Integer.parseInt(strArr[3]);
            int iAc4BitstreamAndPresentationVersionsToProfileConst = ac4BitstreamAndPresentationVersionsToProfileConst(i, i2);
            if (iAc4BitstreamAndPresentationVersionsToProfileConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown AC-4 profile: " + i + "." + i2);
                return null;
            }
            int iAc4LevelNumberToConst = ac4LevelNumberToConst(i3);
            if (iAc4LevelNumberToConst == -1) {
                Log.w("CodecSpecificDataUtil", "Unknown AC-4 level: " + i3);
                return null;
            }
            return new Pair(Integer.valueOf(iAc4BitstreamAndPresentationVersionsToProfileConst), Integer.valueOf(iAc4LevelNumberToConst));
        } catch (NumberFormatException unused) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
    }

    private static Pair getIamfCodecProfileAndLevel(String str, String[] strArr) {
        int i = 4;
        if (strArr.length < 4) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed IAMF codec string: " + str);
            return null;
        }
        try {
            int i2 = 1 << (Integer.parseInt(strArr[1]) + 16);
            String str2 = strArr[3];
            str2.getClass();
            switch (str2) {
                case "Opus":
                    i = 1;
                    break;
                case "fLaC":
                    break;
                case "ipcm":
                    i = 8;
                    break;
                case "mp4a":
                    i = 2;
                    break;
                default:
                    Log.w("CodecSpecificDataUtil", "Ignoring unknown codec identifier for IAMF auxiliary profile: " + strArr[3]);
                    return null;
            }
            return new Pair(Integer.valueOf(16777216 | i2 | i), 0);
        } catch (NumberFormatException e) {
            Log.w("CodecSpecificDataUtil", "Ignoring malformed primary profile in IAMF codec string: " + strArr[1], e);
            return null;
        }
    }

    private static Integer hevcCodecStringToProfileLevel(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "H30":
                return 2;
            case "H60":
                return 8;
            case "H63":
                return 32;
            case "H90":
                return 128;
            case "H93":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
            case "L30":
                return 1;
            case "L60":
                return 4;
            case "L63":
                return 16;
            case "L90":
                return 64;
            case "L93":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
            case "H120":
                return 2048;
            case "H123":
                return 8192;
            case "H150":
                return 32768;
            case "H153":
                return 131072;
            case "H156":
                return 524288;
            case "H180":
                return 2097152;
            case "H183":
                return 8388608;
            case "H186":
                return 33554432;
            case "L120":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            case "L123":
                return 4096;
            case "L150":
                return Integer.valueOf(Http2.INITIAL_MAX_FRAME_SIZE);
            case "L153":
                return 65536;
            case "L156":
                return 262144;
            case "L180":
                return 1048576;
            case "L183":
                return 4194304;
            case "L186":
                return Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            default:
                return null;
        }
    }

    private static Integer dolbyVisionStringToProfile(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "00":
                return 1;
            case "01":
                return 2;
            case "02":
                return 4;
            case "03":
                return 8;
            case "04":
                return 16;
            case "05":
                return 32;
            case "06":
                return 64;
            case "07":
                return 128;
            case "08":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
            case "09":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
            case "10":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            default:
                return null;
        }
    }

    private static Integer dolbyVisionStringToLevel(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
            case "01":
                return 1;
            case "02":
                return 2;
            case "03":
                return 4;
            case "04":
                return 8;
            case "05":
                return 16;
            case "06":
                return 32;
            case "07":
                return 64;
            case "08":
                return 128;
            case "09":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
            case "10":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
            case "11":
                return Integer.valueOf(IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
            case "12":
                return 2048;
            case "13":
                return 4096;
            default:
                return null;
        }
    }
}

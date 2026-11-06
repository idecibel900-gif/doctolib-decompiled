package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidBlendMode_androidKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[android.graphics.BlendMode.values().length];
            try {
                iArr[android.graphics.BlendMode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[android.graphics.BlendMode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[android.graphics.BlendMode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[android.graphics.BlendMode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[android.graphics.BlendMode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[android.graphics.BlendMode.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[android.graphics.BlendMode.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[android.graphics.BlendMode.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[android.graphics.BlendMode.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[android.graphics.BlendMode.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[android.graphics.BlendMode.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[android.graphics.BlendMode.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[android.graphics.BlendMode.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[android.graphics.BlendMode.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[android.graphics.BlendMode.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[android.graphics.BlendMode.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[android.graphics.BlendMode.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[android.graphics.BlendMode.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[android.graphics.BlendMode.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[android.graphics.BlendMode.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m1271toPorterDuffModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        if (BlendMode.m1313equalsimpl0(i, companion.m1316getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1339getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1322getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1343getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1326getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1341getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1324getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1342getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1325getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1340getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1323getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1344getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1335getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1337getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1334getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1320getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1330getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1332getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m1270toAndroidBlendModes9anfk8(int i) {
        BlendMode.Companion companion = BlendMode.Companion;
        if (BlendMode.m1313equalsimpl0(i, companion.m1316getClear0nO6VwU())) {
            return android.graphics.BlendMode.CLEAR;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1339getSrc0nO6VwU())) {
            return android.graphics.BlendMode.SRC;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1322getDst0nO6VwU())) {
            return android.graphics.BlendMode.DST;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1343getSrcOver0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OVER;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1326getDstOver0nO6VwU())) {
            return android.graphics.BlendMode.DST_OVER;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1341getSrcIn0nO6VwU())) {
            return android.graphics.BlendMode.SRC_IN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1324getDstIn0nO6VwU())) {
            return android.graphics.BlendMode.DST_IN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1342getSrcOut0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OUT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1325getDstOut0nO6VwU())) {
            return android.graphics.BlendMode.DST_OUT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1340getSrcAtop0nO6VwU())) {
            return android.graphics.BlendMode.SRC_ATOP;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1323getDstAtop0nO6VwU())) {
            return android.graphics.BlendMode.DST_ATOP;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1344getXor0nO6VwU())) {
            return android.graphics.BlendMode.XOR;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1335getPlus0nO6VwU())) {
            return android.graphics.BlendMode.PLUS;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1332getModulate0nO6VwU())) {
            return android.graphics.BlendMode.MODULATE;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1337getScreen0nO6VwU())) {
            return android.graphics.BlendMode.SCREEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1334getOverlay0nO6VwU())) {
            return android.graphics.BlendMode.OVERLAY;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1320getDarken0nO6VwU())) {
            return android.graphics.BlendMode.DARKEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1330getLighten0nO6VwU())) {
            return android.graphics.BlendMode.LIGHTEN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1319getColorDodge0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1318getColorBurn0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_BURN;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1328getHardlight0nO6VwU())) {
            return android.graphics.BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1338getSoftlight0nO6VwU())) {
            return android.graphics.BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1321getDifference0nO6VwU())) {
            return android.graphics.BlendMode.DIFFERENCE;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1327getExclusion0nO6VwU())) {
            return android.graphics.BlendMode.EXCLUSION;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1333getMultiply0nO6VwU())) {
            return android.graphics.BlendMode.MULTIPLY;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1329getHue0nO6VwU())) {
            return android.graphics.BlendMode.HUE;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1336getSaturation0nO6VwU())) {
            return android.graphics.BlendMode.SATURATION;
        }
        if (BlendMode.m1313equalsimpl0(i, companion.m1317getColor0nO6VwU())) {
            return android.graphics.BlendMode.COLOR;
        }
        return BlendMode.m1313equalsimpl0(i, companion.m1331getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode blendMode) {
        switch (WhenMappings.$EnumSwitchMapping$0[blendMode.ordinal()]) {
            case 1:
                return BlendMode.Companion.m1316getClear0nO6VwU();
            case 2:
                return BlendMode.Companion.m1339getSrc0nO6VwU();
            case 3:
                return BlendMode.Companion.m1322getDst0nO6VwU();
            case 4:
                return BlendMode.Companion.m1343getSrcOver0nO6VwU();
            case 5:
                return BlendMode.Companion.m1326getDstOver0nO6VwU();
            case 6:
                return BlendMode.Companion.m1341getSrcIn0nO6VwU();
            case 7:
                return BlendMode.Companion.m1324getDstIn0nO6VwU();
            case 8:
                return BlendMode.Companion.m1342getSrcOut0nO6VwU();
            case 9:
                return BlendMode.Companion.m1325getDstOut0nO6VwU();
            case 10:
                return BlendMode.Companion.m1340getSrcAtop0nO6VwU();
            case BaseVideoCapturer.RGBA /* 11 */:
                return BlendMode.Companion.m1323getDstAtop0nO6VwU();
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return BlendMode.Companion.m1344getXor0nO6VwU();
            case 13:
                return BlendMode.Companion.m1335getPlus0nO6VwU();
            case 14:
                return BlendMode.Companion.m1332getModulate0nO6VwU();
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return BlendMode.Companion.m1337getScreen0nO6VwU();
            case 16:
                return BlendMode.Companion.m1334getOverlay0nO6VwU();
            case 17:
                return BlendMode.Companion.m1320getDarken0nO6VwU();
            case 18:
                return BlendMode.Companion.m1330getLighten0nO6VwU();
            case 19:
                return BlendMode.Companion.m1319getColorDodge0nO6VwU();
            case 20:
                return BlendMode.Companion.m1318getColorBurn0nO6VwU();
            case 21:
                return BlendMode.Companion.m1328getHardlight0nO6VwU();
            case 22:
                return BlendMode.Companion.m1338getSoftlight0nO6VwU();
            case 23:
                return BlendMode.Companion.m1321getDifference0nO6VwU();
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                return BlendMode.Companion.m1327getExclusion0nO6VwU();
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                return BlendMode.Companion.m1333getMultiply0nO6VwU();
            case 26:
                return BlendMode.Companion.m1329getHue0nO6VwU();
            case 27:
                return BlendMode.Companion.m1336getSaturation0nO6VwU();
            case 28:
                return BlendMode.Companion.m1317getColor0nO6VwU();
            case 29:
                return BlendMode.Companion.m1331getLuminosity0nO6VwU();
            default:
                return BlendMode.Companion.m1343getSrcOver0nO6VwU();
        }
    }
}

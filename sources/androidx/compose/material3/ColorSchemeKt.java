package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.ui.revenuecatui.composables.BackgroundUIConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.jvm.functions.Function0;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class ColorSchemeKt {
    private static final ProvidableCompositionLocal LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        @Override // kotlin.jvm.functions.Function0
        public final ColorScheme invoke() {
            return ColorSchemeKt.m758lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    });
    private static final ProvidableCompositionLocal LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.ColorSchemeKt$LocalTonalElevationEnabled$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m758lightColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long jM927getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m927getPrimary0d7_KjU() : j;
        long jM917getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m917getOnPrimary0d7_KjU() : j2;
        long jM928getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m928getPrimaryContainer0d7_KjU() : j3;
        long jM918getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m918getOnPrimaryContainer0d7_KjU() : j4;
        long jM912getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m912getInversePrimary0d7_KjU() : j5;
        long jM930getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m930getSecondary0d7_KjU() : j6;
        long jM919getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m919getOnSecondary0d7_KjU() : j7;
        long jM931getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m931getSecondaryContainer0d7_KjU() : j8;
        long j37 = jM927getPrimary0d7_KjU;
        long jM920getOnSecondaryContainer0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? ColorLightTokens.INSTANCE.m920getOnSecondaryContainer0d7_KjU() : j9;
        long jM941getTertiary0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? ColorLightTokens.INSTANCE.m941getTertiary0d7_KjU() : j10;
        long jM923getOnTertiary0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? ColorLightTokens.INSTANCE.m923getOnTertiary0d7_KjU() : j11;
        long jM942getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m942getTertiaryContainer0d7_KjU() : j12;
        long jM924getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m924getOnTertiaryContainer0d7_KjU() : j13;
        long jM908getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m908getBackground0d7_KjU() : j14;
        long jM914getOnBackground0d7_KjU = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? ColorLightTokens.INSTANCE.m914getOnBackground0d7_KjU() : j15;
        long jM932getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m932getSurface0d7_KjU() : j16;
        long jM921getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m921getOnSurface0d7_KjU() : j17;
        long jM940getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m940getSurfaceVariant0d7_KjU() : j18;
        long jM922getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m922getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long jM913getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m913getInverseSurface0d7_KjU() : j21;
        long jM911getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m911getInverseOnSurface0d7_KjU() : j22;
        long jM909getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m909getError0d7_KjU() : j23;
        long jM915getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m915getOnError0d7_KjU() : j24;
        long jM910getErrorContainer0d7_KjU = (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? ColorLightTokens.INSTANCE.m910getErrorContainer0d7_KjU() : j25;
        long jM916getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m916getOnErrorContainer0d7_KjU() : j26;
        long jM925getOutline0d7_KjU = (i & 67108864) != 0 ? ColorLightTokens.INSTANCE.m925getOutline0d7_KjU() : j27;
        long jM926getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m926getOutlineVariant0d7_KjU() : j28;
        long jM929getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m929getScrim0d7_KjU() : j29;
        long jM933getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m933getSurfaceBright0d7_KjU() : j30;
        long jM934getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorLightTokens.INSTANCE.m934getSurfaceContainer0d7_KjU() : j31;
        long jM935getSurfaceContainerHigh0d7_KjU = (i & LinearLayoutManager.INVALID_OFFSET) != 0 ? ColorLightTokens.INSTANCE.m935getSurfaceContainerHigh0d7_KjU() : j32;
        long jM936getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorLightTokens.INSTANCE.m936getSurfaceContainerHighest0d7_KjU() : j33;
        long jM937getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorLightTokens.INSTANCE.m937getSurfaceContainerLow0d7_KjU() : j34;
        long jM938getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorLightTokens.INSTANCE.m938getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorLightTokens.INSTANCE.m939getSurfaceDim0d7_KjU();
        }
        return m757lightColorSchemeCXl9yA(j37, jM917getOnPrimary0d7_KjU, jM928getPrimaryContainer0d7_KjU, jM918getOnPrimaryContainer0d7_KjU, jM912getInversePrimary0d7_KjU, jM930getSecondary0d7_KjU, jM919getOnSecondary0d7_KjU, jM931getSecondaryContainer0d7_KjU, jM920getOnSecondaryContainer0d7_KjU, jM941getTertiary0d7_KjU, jM923getOnTertiary0d7_KjU, jM942getTertiaryContainer0d7_KjU, jM924getOnTertiaryContainer0d7_KjU, jM908getBackground0d7_KjU, jM914getOnBackground0d7_KjU, jM932getSurface0d7_KjU, jM921getOnSurface0d7_KjU, jM940getSurfaceVariant0d7_KjU, jM922getOnSurfaceVariant0d7_KjU, j38, jM913getInverseSurface0d7_KjU, jM911getInverseOnSurface0d7_KjU, jM909getError0d7_KjU, jM915getOnError0d7_KjU, jM910getErrorContainer0d7_KjU, jM916getOnErrorContainer0d7_KjU, jM925getOutline0d7_KjU, jM926getOutlineVariant0d7_KjU, jM929getScrim0d7_KjU, jM933getSurfaceBright0d7_KjU, jM934getSurfaceContainer0d7_KjU, jM935getSurfaceContainerHigh0d7_KjU, jM936getSurfaceContainerHighest0d7_KjU, jM937getSurfaceContainerLow0d7_KjU, jM938getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m757lightColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m756darkColorSchemeCXl9yA$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long jM892getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m892getPrimary0d7_KjU() : j;
        long jM882getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m882getOnPrimary0d7_KjU() : j2;
        long jM893getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m893getPrimaryContainer0d7_KjU() : j3;
        long jM883getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m883getOnPrimaryContainer0d7_KjU() : j4;
        long jM877getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m877getInversePrimary0d7_KjU() : j5;
        long jM895getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m895getSecondary0d7_KjU() : j6;
        long jM884getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m884getOnSecondary0d7_KjU() : j7;
        long jM896getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m896getSecondaryContainer0d7_KjU() : j8;
        long j37 = jM892getPrimary0d7_KjU;
        long jM885getOnSecondaryContainer0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? ColorDarkTokens.INSTANCE.m885getOnSecondaryContainer0d7_KjU() : j9;
        long jM906getTertiary0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? ColorDarkTokens.INSTANCE.m906getTertiary0d7_KjU() : j10;
        long jM888getOnTertiary0d7_KjU = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? ColorDarkTokens.INSTANCE.m888getOnTertiary0d7_KjU() : j11;
        long jM907getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m907getTertiaryContainer0d7_KjU() : j12;
        long jM889getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m889getOnTertiaryContainer0d7_KjU() : j13;
        long jM873getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m873getBackground0d7_KjU() : j14;
        long jM879getOnBackground0d7_KjU = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? ColorDarkTokens.INSTANCE.m879getOnBackground0d7_KjU() : j15;
        long jM897getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m897getSurface0d7_KjU() : j16;
        long jM886getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m886getOnSurface0d7_KjU() : j17;
        long jM905getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m905getSurfaceVariant0d7_KjU() : j18;
        long jM887getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m887getOnSurfaceVariant0d7_KjU() : j19;
        long j38 = (i & 524288) != 0 ? j37 : j20;
        long jM878getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m878getInverseSurface0d7_KjU() : j21;
        long jM876getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m876getInverseOnSurface0d7_KjU() : j22;
        long jM874getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m874getError0d7_KjU() : j23;
        long jM880getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m880getOnError0d7_KjU() : j24;
        long jM875getErrorContainer0d7_KjU = (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? ColorDarkTokens.INSTANCE.m875getErrorContainer0d7_KjU() : j25;
        long jM881getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m881getOnErrorContainer0d7_KjU() : j26;
        long jM890getOutline0d7_KjU = (i & 67108864) != 0 ? ColorDarkTokens.INSTANCE.m890getOutline0d7_KjU() : j27;
        long jM891getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m891getOutlineVariant0d7_KjU() : j28;
        long jM894getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m894getScrim0d7_KjU() : j29;
        long jM898getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m898getSurfaceBright0d7_KjU() : j30;
        long jM899getSurfaceContainer0d7_KjU = (i & 1073741824) != 0 ? ColorDarkTokens.INSTANCE.m899getSurfaceContainer0d7_KjU() : j31;
        long jM900getSurfaceContainerHigh0d7_KjU = (i & LinearLayoutManager.INVALID_OFFSET) != 0 ? ColorDarkTokens.INSTANCE.m900getSurfaceContainerHigh0d7_KjU() : j32;
        long jM901getSurfaceContainerHighest0d7_KjU = (i2 & 1) != 0 ? ColorDarkTokens.INSTANCE.m901getSurfaceContainerHighest0d7_KjU() : j33;
        long jM902getSurfaceContainerLow0d7_KjU = (i2 & 2) != 0 ? ColorDarkTokens.INSTANCE.m902getSurfaceContainerLow0d7_KjU() : j34;
        long jM903getSurfaceContainerLowest0d7_KjU = (i2 & 4) != 0 ? ColorDarkTokens.INSTANCE.m903getSurfaceContainerLowest0d7_KjU() : j35;
        if ((i2 & 8) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m904getSurfaceDim0d7_KjU();
        }
        return m755darkColorSchemeCXl9yA(j37, jM882getOnPrimary0d7_KjU, jM893getPrimaryContainer0d7_KjU, jM883getOnPrimaryContainer0d7_KjU, jM877getInversePrimary0d7_KjU, jM895getSecondary0d7_KjU, jM884getOnSecondary0d7_KjU, jM896getSecondaryContainer0d7_KjU, jM885getOnSecondaryContainer0d7_KjU, jM906getTertiary0d7_KjU, jM888getOnTertiary0d7_KjU, jM907getTertiaryContainer0d7_KjU, jM889getOnTertiaryContainer0d7_KjU, jM873getBackground0d7_KjU, jM879getOnBackground0d7_KjU, jM897getSurface0d7_KjU, jM886getOnSurface0d7_KjU, jM905getSurfaceVariant0d7_KjU, jM887getOnSurfaceVariant0d7_KjU, j38, jM878getInverseSurface0d7_KjU, jM876getInverseOnSurface0d7_KjU, jM874getError0d7_KjU, jM880getOnError0d7_KjU, jM875getErrorContainer0d7_KjU, jM881getOnErrorContainer0d7_KjU, jM890getOutline0d7_KjU, jM891getOutlineVariant0d7_KjU, jM894getScrim0d7_KjU, jM898getSurfaceBright0d7_KjU, jM899getSurfaceContainer0d7_KjU, jM900getSurfaceContainerHigh0d7_KjU, jM901getSurfaceContainerHighest0d7_KjU, jM902getSurfaceContainerLow0d7_KjU, jM903getSurfaceContainerLowest0d7_KjU, j36);
    }

    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m755darkColorSchemeCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m753contentColorFor4WTKRHQ(ColorScheme colorScheme, long j) {
        if (Color.m1367equalsimpl0(j, colorScheme.m735getPrimary0d7_KjU())) {
            return colorScheme.m725getOnPrimary0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m738getSecondary0d7_KjU())) {
            return colorScheme.m727getOnSecondary0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m750getTertiary0d7_KjU())) {
            return colorScheme.m731getOnTertiary0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m716getBackground0d7_KjU())) {
            return colorScheme.m722getOnBackground0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m717getError0d7_KjU())) {
            return colorScheme.m723getOnError0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m736getPrimaryContainer0d7_KjU())) {
            return colorScheme.m726getOnPrimaryContainer0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m739getSecondaryContainer0d7_KjU())) {
            return colorScheme.m728getOnSecondaryContainer0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m751getTertiaryContainer0d7_KjU())) {
            return colorScheme.m732getOnTertiaryContainer0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m718getErrorContainer0d7_KjU())) {
            return colorScheme.m724getOnErrorContainer0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m721getInverseSurface0d7_KjU())) {
            return colorScheme.m719getInverseOnSurface0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m740getSurface0d7_KjU())) {
            return colorScheme.m729getOnSurface0d7_KjU();
        }
        if (Color.m1367equalsimpl0(j, colorScheme.m749getSurfaceVariant0d7_KjU())) {
            return colorScheme.m730getOnSurfaceVariant0d7_KjU();
        }
        if (!Color.m1367equalsimpl0(j, colorScheme.m741getSurfaceBright0d7_KjU()) && !Color.m1367equalsimpl0(j, colorScheme.m742getSurfaceContainer0d7_KjU()) && !Color.m1367equalsimpl0(j, colorScheme.m743getSurfaceContainerHigh0d7_KjU()) && !Color.m1367equalsimpl0(j, colorScheme.m744getSurfaceContainerHighest0d7_KjU()) && !Color.m1367equalsimpl0(j, colorScheme.m745getSurfaceContainerLow0d7_KjU()) && !Color.m1367equalsimpl0(j, colorScheme.m746getSurfaceContainerLowest0d7_KjU())) {
            return Color.Companion.m1385getUnspecified0d7_KjU();
        }
        return colorScheme.m729getOnSurface0d7_KjU();
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m754contentColorForek8zF_U(long j, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        long jM753contentColorFor4WTKRHQ = m753contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j);
        if (jM753contentColorFor4WTKRHQ == 16) {
            jM753contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1375unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM753contentColorFor4WTKRHQ;
    }

    /* JADX INFO: renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m752applyTonalElevationRFCenO8(ColorScheme colorScheme, long j, float f, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        boolean zBooleanValue = ((Boolean) composer.consume(LocalTonalElevationEnabled)).booleanValue();
        if (Color.m1367equalsimpl0(j, colorScheme.m740getSurface0d7_KjU()) && zBooleanValue) {
            j = m759surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j;
    }

    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.m716getBackground0d7_KjU();
            case 2:
                return colorScheme.m717getError0d7_KjU();
            case 3:
                return colorScheme.m718getErrorContainer0d7_KjU();
            case 4:
                return colorScheme.m719getInverseOnSurface0d7_KjU();
            case 5:
                return colorScheme.m720getInversePrimary0d7_KjU();
            case 6:
                return colorScheme.m721getInverseSurface0d7_KjU();
            case 7:
                return colorScheme.m722getOnBackground0d7_KjU();
            case 8:
                return colorScheme.m723getOnError0d7_KjU();
            case 9:
                return colorScheme.m724getOnErrorContainer0d7_KjU();
            case 10:
                return colorScheme.m725getOnPrimary0d7_KjU();
            case BaseVideoCapturer.RGBA /* 11 */:
                return colorScheme.m726getOnPrimaryContainer0d7_KjU();
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return colorScheme.m727getOnSecondary0d7_KjU();
            case 13:
                return colorScheme.m728getOnSecondaryContainer0d7_KjU();
            case 14:
                return colorScheme.m729getOnSurface0d7_KjU();
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return colorScheme.m730getOnSurfaceVariant0d7_KjU();
            case 16:
                return colorScheme.m748getSurfaceTint0d7_KjU();
            case 17:
                return colorScheme.m731getOnTertiary0d7_KjU();
            case 18:
                return colorScheme.m732getOnTertiaryContainer0d7_KjU();
            case 19:
                return colorScheme.m733getOutline0d7_KjU();
            case 20:
                return colorScheme.m734getOutlineVariant0d7_KjU();
            case 21:
                return colorScheme.m735getPrimary0d7_KjU();
            case 22:
                return colorScheme.m736getPrimaryContainer0d7_KjU();
            case 23:
                return colorScheme.m737getScrim0d7_KjU();
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                return colorScheme.m738getSecondary0d7_KjU();
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                return colorScheme.m739getSecondaryContainer0d7_KjU();
            case 26:
                return colorScheme.m740getSurface0d7_KjU();
            case 27:
                return colorScheme.m749getSurfaceVariant0d7_KjU();
            case 28:
                return colorScheme.m741getSurfaceBright0d7_KjU();
            case 29:
                return colorScheme.m742getSurfaceContainer0d7_KjU();
            case 30:
                return colorScheme.m743getSurfaceContainerHigh0d7_KjU();
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                return colorScheme.m744getSurfaceContainerHighest0d7_KjU();
            case 32:
                return colorScheme.m745getSurfaceContainerLow0d7_KjU();
            case 33:
                return colorScheme.m746getSurfaceContainerLowest0d7_KjU();
            case 34:
                return colorScheme.m747getSurfaceDim0d7_KjU();
            case 35:
                return colorScheme.m750getTertiary0d7_KjU();
            case 36:
                return colorScheme.m751getTertiaryContainer0d7_KjU();
            default:
                return Color.Companion.m1385getUnspecified0d7_KjU();
        }
    }

    public static final ProvidableCompositionLocal getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jFromToken;
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m759surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m2553equalsimpl0(f, Dp.m2551constructorimpl(0))) {
            return colorScheme.m740getSurface0d7_KjU();
        }
        return ColorKt.m1390compositeOverOWjLjI(Color.m1365copywmQWz5c$default(colorScheme.m748getSurfaceTint0d7_KjU(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.m740getSurface0d7_KjU());
    }
}

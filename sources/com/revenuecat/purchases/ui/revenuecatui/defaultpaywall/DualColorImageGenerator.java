package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.helpers.AppStyleExtractor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J*\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\bR\u001b\u0010\u000f\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator;", "", "()V", "DEFAULT_IMAGE_SIZE", "", "blueGreen", "Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;", "getBlueGreen", "()Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;", "blueGreen$delegate", "Lkotlin/Lazy;", "purpleOrange", "getPurpleOrange$annotations", "getPurpleOrange", "purpleOrange$delegate", "redGreen", "getRedGreen", "redGreen$delegate", "create", "color1", "Landroidx/compose/ui/graphics/Color;", "color2", "width", "height", "create-RFnl5yQ", "(JJII)Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;", "createBitmap", "Landroid/graphics/Bitmap;", "PreviewAppIcon", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DualColorImageGenerator {
    private static final int DEFAULT_IMAGE_SIZE = 200;
    public static final DualColorImageGenerator INSTANCE = new DualColorImageGenerator();

    /* JADX INFO: renamed from: redGreen$delegate, reason: from kotlin metadata */
    private static final Lazy redGreen = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$redGreen$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator dualColorImageGenerator = DualColorImageGenerator.INSTANCE;
            Color.Companion companion = Color.Companion;
            DualColorImageGenerator.PreviewAppIcon previewAppIconM4469createRFnl5yQ$default = DualColorImageGenerator.m4469createRFnl5yQ$default(dualColorImageGenerator, companion.m1383getRed0d7_KjU(), companion.m1381getGreen0d7_KjU(), 0, 0, 12, null);
            if (previewAppIconM4469createRFnl5yQ$default != null) {
                return previewAppIconM4469createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate redGreen preview icon");
        }
    });

    /* JADX INFO: renamed from: blueGreen$delegate, reason: from kotlin metadata */
    private static final Lazy blueGreen = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$blueGreen$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator dualColorImageGenerator = DualColorImageGenerator.INSTANCE;
            Color.Companion companion = Color.Companion;
            DualColorImageGenerator.PreviewAppIcon previewAppIconM4469createRFnl5yQ$default = DualColorImageGenerator.m4469createRFnl5yQ$default(dualColorImageGenerator, companion.m1377getBlue0d7_KjU(), companion.m1381getGreen0d7_KjU(), 0, 0, 12, null);
            if (previewAppIconM4469createRFnl5yQ$default != null) {
                return previewAppIconM4469createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate blueGreen preview icon");
        }
    });

    /* JADX INFO: renamed from: purpleOrange$delegate, reason: from kotlin metadata */
    private static final Lazy purpleOrange = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DualColorImageGenerator$purpleOrange$2
        @Override // kotlin.jvm.functions.Function0
        public final DualColorImageGenerator.PreviewAppIcon invoke() {
            DualColorImageGenerator.PreviewAppIcon previewAppIconM4469createRFnl5yQ$default = DualColorImageGenerator.m4469createRFnl5yQ$default(DualColorImageGenerator.INSTANCE, ColorKt.Color(4286578816L), ColorKt.Color(4294944000L), 0, 0, 12, null);
            if (previewAppIconM4469createRFnl5yQ$default != null) {
                return previewAppIconM4469createRFnl5yQ$default;
            }
            throw new IllegalStateException("Failed to generate purpleOrange preview icon");
        }
    });
    public static final int $stable = 8;

    public static /* synthetic */ void getPurpleOrange$annotations() {
    }

    private DualColorImageGenerator() {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/defaultpaywall/DualColorImageGenerator$PreviewAppIcon;", "", "bitmap", "Landroid/graphics/Bitmap;", "prominentColors", "", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Bitmap;Ljava/util/List;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getProminentColors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PreviewAppIcon {
        public static final int $stable = 8;
        private final Bitmap bitmap;
        private final List<Color> prominentColors;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreviewAppIcon copy$default(PreviewAppIcon previewAppIcon, Bitmap bitmap, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = previewAppIcon.bitmap;
            }
            if ((i & 2) != 0) {
                list = previewAppIcon.prominentColors;
            }
            return previewAppIcon.copy(bitmap, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final List<Color> component2() {
            return this.prominentColors;
        }

        public final PreviewAppIcon copy(Bitmap bitmap, List<Color> prominentColors) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(prominentColors, "prominentColors");
            return new PreviewAppIcon(bitmap, prominentColors);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreviewAppIcon)) {
                return false;
            }
            PreviewAppIcon previewAppIcon = (PreviewAppIcon) other;
            return Intrinsics.areEqual(this.bitmap, previewAppIcon.bitmap) && Intrinsics.areEqual(this.prominentColors, previewAppIcon.prominentColors);
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.prominentColors.hashCode();
        }

        public String toString() {
            return "PreviewAppIcon(bitmap=" + this.bitmap + ", prominentColors=" + this.prominentColors + ')';
        }

        public PreviewAppIcon(Bitmap bitmap, List<Color> prominentColors) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(prominentColors, "prominentColors");
            this.bitmap = bitmap;
            this.prominentColors = prominentColors;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final List<Color> getProminentColors() {
            return this.prominentColors;
        }
    }

    public final PreviewAppIcon getRedGreen() {
        return (PreviewAppIcon) redGreen.getValue();
    }

    public final PreviewAppIcon getBlueGreen() {
        return (PreviewAppIcon) blueGreen.getValue();
    }

    public final PreviewAppIcon getPurpleOrange() {
        return (PreviewAppIcon) purpleOrange.getValue();
    }

    /* JADX INFO: renamed from: create-RFnl5yQ$default, reason: not valid java name */
    public static /* synthetic */ PreviewAppIcon m4469createRFnl5yQ$default(DualColorImageGenerator dualColorImageGenerator, long j, long j2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 200;
        }
        if ((i3 & 8) != 0) {
            i2 = 200;
        }
        return dualColorImageGenerator.m4470createRFnl5yQ(j, j2, i, i2);
    }

    /* JADX INFO: renamed from: create-RFnl5yQ, reason: not valid java name */
    public final PreviewAppIcon m4470createRFnl5yQ(long color1, long color2, int width, int height) {
        Bitmap bitmapCreateBitmap = createBitmap(ColorKt.m1393toArgb8_81llA(color1), ColorKt.m1393toArgb8_81llA(color2), width, height);
        if (bitmapCreateBitmap == null) {
            return null;
        }
        return new PreviewAppIcon(bitmapCreateBitmap, AppStyleExtractor.INSTANCE.extractProminentColors$revenuecatui_defaultsBc8Release(bitmapCreateBitmap, 2));
    }

    private final Bitmap createBitmap(int color1, int color2, int width, int height) {
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, heig… Bitmap.Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        float f = width;
        float f2 = f / 2.0f;
        paint.setColor(color1);
        float f3 = height;
        canvas.drawRect(0.0f, 0.0f, f2, f3, paint);
        paint.setColor(color2);
        canvas.drawRect(f2, 0.0f, f, f3, paint);
        return bitmapCreateBitmap;
    }
}

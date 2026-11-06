package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeVideoUrls;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "", "Color", "Image", "Video", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Color;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Image;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Video;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BackgroundStyle {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Color;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "constructor-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "getColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)I", "toString", "", "toString-impl", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)Ljava/lang/String;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Color implements BackgroundStyle {
        private final ColorStyle color;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ Color m4097boximpl(ColorStyle colorStyle) {
            return new Color(colorStyle);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        public static ColorStyle m4098constructorimpl(ColorStyle color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m4099equalsimpl(ColorStyle colorStyle, Object obj) {
            return (obj instanceof Color) && Intrinsics.areEqual(colorStyle, ((Color) obj).m4103unboximpl());
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4100equalsimpl0(ColorStyle colorStyle, ColorStyle colorStyle2) {
            return Intrinsics.areEqual(colorStyle, colorStyle2);
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m4101hashCodeimpl(ColorStyle colorStyle) {
            return colorStyle.hashCode();
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m4102toStringimpl(ColorStyle colorStyle) {
            return "Color(color=" + colorStyle + ')';
        }

        public boolean equals(Object obj) {
            return m4099equalsimpl(this.color, obj);
        }

        public int hashCode() {
            return m4101hashCodeimpl(this.color);
        }

        public String toString() {
            return m4102toStringimpl(this.color);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ ColorStyle m4103unboximpl() {
            return this.color;
        }

        private /* synthetic */ Color(ColorStyle colorStyle) {
            this.color = colorStyle;
        }

        public final /* synthetic */ ColorStyle getColor() {
            return this.color;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Image;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "colorOverlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)V", "getColorOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Image implements BackgroundStyle {
        public static final int $stable = 8;
        private final ColorStyle colorOverlay;
        private final ContentScale contentScale;
        private final Painter painter;

        public static /* synthetic */ Image copy$default(Image image, Painter painter, ContentScale contentScale, ColorStyle colorStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                painter = image.painter;
            }
            if ((i & 2) != 0) {
                contentScale = image.contentScale;
            }
            if ((i & 4) != 0) {
                colorStyle = image.colorOverlay;
            }
            return image.copy(painter, contentScale, colorStyle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Painter getPainter() {
            return this.painter;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ContentScale getContentScale() {
            return this.contentScale;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ColorStyle getColorOverlay() {
            return this.colorOverlay;
        }

        public final Image copy(Painter painter, ContentScale contentScale, ColorStyle colorOverlay) {
            Intrinsics.checkNotNullParameter(painter, "painter");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            return new Image(painter, contentScale, colorOverlay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return Intrinsics.areEqual(this.painter, image.painter) && Intrinsics.areEqual(this.contentScale, image.contentScale) && Intrinsics.areEqual(this.colorOverlay, image.colorOverlay);
        }

        public int hashCode() {
            int iHashCode = ((this.painter.hashCode() * 31) + this.contentScale.hashCode()) * 31;
            ColorStyle colorStyle = this.colorOverlay;
            return iHashCode + (colorStyle == null ? 0 : colorStyle.hashCode());
        }

        public String toString() {
            return "Image(painter=" + this.painter + ", contentScale=" + this.contentScale + ", colorOverlay=" + this.colorOverlay + ')';
        }

        public Image(Painter painter, ContentScale contentScale, ColorStyle colorStyle) {
            Intrinsics.checkNotNullParameter(painter, "painter");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            this.painter = painter;
            this.contentScale = contentScale;
            this.colorOverlay = colorStyle;
        }

        public final /* synthetic */ Painter getPainter() {
            return this.painter;
        }

        public final /* synthetic */ ContentScale getContentScale() {
            return this.contentScale;
        }

        public final /* synthetic */ ColorStyle getColorOverlay() {
            return this.colorOverlay;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle$Video;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "sources", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "fallbackImage", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "loop", "", "muteAudio", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "colorOverlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "(Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;ZZLandroidx/compose/ui/layout/ContentScale;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;)V", "getColorOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getFallbackImage", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getLoop", "()Z", "getMuteAudio", "getSources", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeVideoUrls;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Video implements BackgroundStyle {
        public static final int $stable = 0;
        private final ColorStyles colorOverlay;
        private final ContentScale contentScale;
        private final ThemeImageUrls fallbackImage;
        private final boolean loop;
        private final boolean muteAudio;
        private final ThemeVideoUrls sources;

        public static /* synthetic */ Video copy$default(Video video, ThemeVideoUrls themeVideoUrls, ThemeImageUrls themeImageUrls, boolean z, boolean z2, ContentScale contentScale, ColorStyles colorStyles, int i, Object obj) {
            if ((i & 1) != 0) {
                themeVideoUrls = video.sources;
            }
            if ((i & 2) != 0) {
                themeImageUrls = video.fallbackImage;
            }
            if ((i & 4) != 0) {
                z = video.loop;
            }
            if ((i & 8) != 0) {
                z2 = video.muteAudio;
            }
            if ((i & 16) != 0) {
                contentScale = video.contentScale;
            }
            if ((i & 32) != 0) {
                colorStyles = video.colorOverlay;
            }
            ContentScale contentScale2 = contentScale;
            ColorStyles colorStyles2 = colorStyles;
            return video.copy(themeVideoUrls, themeImageUrls, z, z2, contentScale2, colorStyles2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThemeVideoUrls getSources() {
            return this.sources;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getLoop() {
            return this.loop;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getMuteAudio() {
            return this.muteAudio;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ContentScale getContentScale() {
            return this.contentScale;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ColorStyles getColorOverlay() {
            return this.colorOverlay;
        }

        public final Video copy(ThemeVideoUrls sources, ThemeImageUrls fallbackImage, boolean loop, boolean muteAudio, ContentScale contentScale, ColorStyles colorOverlay) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            return new Video(sources, fallbackImage, loop, muteAudio, contentScale, colorOverlay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.sources, video.sources) && Intrinsics.areEqual(this.fallbackImage, video.fallbackImage) && this.loop == video.loop && this.muteAudio == video.muteAudio && Intrinsics.areEqual(this.contentScale, video.contentScale) && Intrinsics.areEqual(this.colorOverlay, video.colorOverlay);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.sources.hashCode() * 31) + this.fallbackImage.hashCode()) * 31) + Boolean.hashCode(this.loop)) * 31) + Boolean.hashCode(this.muteAudio)) * 31) + this.contentScale.hashCode()) * 31;
            ColorStyles colorStyles = this.colorOverlay;
            return iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode());
        }

        public String toString() {
            return "Video(sources=" + this.sources + ", fallbackImage=" + this.fallbackImage + ", loop=" + this.loop + ", muteAudio=" + this.muteAudio + ", contentScale=" + this.contentScale + ", colorOverlay=" + this.colorOverlay + ')';
        }

        public Video(ThemeVideoUrls sources, ThemeImageUrls fallbackImage, boolean z, boolean z2, ContentScale contentScale, ColorStyles colorStyles) {
            Intrinsics.checkNotNullParameter(sources, "sources");
            Intrinsics.checkNotNullParameter(fallbackImage, "fallbackImage");
            Intrinsics.checkNotNullParameter(contentScale, "contentScale");
            this.sources = sources;
            this.fallbackImage = fallbackImage;
            this.loop = z;
            this.muteAudio = z2;
            this.contentScale = contentScale;
            this.colorOverlay = colorStyles;
        }

        public final /* synthetic */ ThemeVideoUrls getSources() {
            return this.sources;
        }

        public final /* synthetic */ ThemeImageUrls getFallbackImage() {
            return this.fallbackImage;
        }

        public final /* synthetic */ boolean getLoop() {
            return this.loop;
        }

        public final /* synthetic */ boolean getMuteAudio() {
            return this.muteAudio;
        }

        public final /* synthetic */ ContentScale getContentScale() {
            return this.contentScale;
        }

        public final /* synthetic */ ColorStyles getColorOverlay() {
            return this.colorOverlay;
        }
    }
}

package expo.modules.updates.reloadscreen;

import android.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ReloadScreenConfiguration {
    public static final Companion Companion = new Companion(null);
    private final int backgroundColor;
    private final boolean fade;
    private final ReloadScreenImageSource image;
    private final boolean imageFullScreen;
    private final ImageResizeMode imageResizeMode;
    private final SpinnerConfiguration spinner;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReloadScreenConfiguration)) {
            return false;
        }
        ReloadScreenConfiguration reloadScreenConfiguration = (ReloadScreenConfiguration) obj;
        return this.backgroundColor == reloadScreenConfiguration.backgroundColor && Intrinsics.areEqual(this.image, reloadScreenConfiguration.image) && this.imageResizeMode == reloadScreenConfiguration.imageResizeMode && this.imageFullScreen == reloadScreenConfiguration.imageFullScreen && this.fade == reloadScreenConfiguration.fade && Intrinsics.areEqual(this.spinner, reloadScreenConfiguration.spinner);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.backgroundColor) * 31;
        ReloadScreenImageSource reloadScreenImageSource = this.image;
        return ((((((((iHashCode + (reloadScreenImageSource == null ? 0 : reloadScreenImageSource.hashCode())) * 31) + this.imageResizeMode.hashCode()) * 31) + Boolean.hashCode(this.imageFullScreen)) * 31) + Boolean.hashCode(this.fade)) * 31) + this.spinner.hashCode();
    }

    public String toString() {
        return "ReloadScreenConfiguration(backgroundColor=" + this.backgroundColor + ", image=" + this.image + ", imageResizeMode=" + this.imageResizeMode + ", imageFullScreen=" + this.imageFullScreen + ", fade=" + this.fade + ", spinner=" + this.spinner + ")";
    }

    public ReloadScreenConfiguration(int i, ReloadScreenImageSource reloadScreenImageSource, ImageResizeMode imageResizeMode, boolean z, boolean z2, SpinnerConfiguration spinner) {
        Intrinsics.checkNotNullParameter(imageResizeMode, "imageResizeMode");
        Intrinsics.checkNotNullParameter(spinner, "spinner");
        this.backgroundColor = i;
        this.image = reloadScreenImageSource;
        this.imageResizeMode = imageResizeMode;
        this.imageFullScreen = z;
        this.fade = z2;
        this.spinner = spinner;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ReloadScreenImageSource getImage() {
        return this.image;
    }

    public final ImageResizeMode getImageResizeMode() {
        return this.imageResizeMode;
    }

    public final boolean getImageFullScreen() {
        return this.imageFullScreen;
    }

    public final boolean getFade() {
        return this.fade;
    }

    public final SpinnerConfiguration getSpinner() {
        return this.spinner;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReloadScreenConfiguration fromOptions(ReloadScreenOptions reloadScreenOptions) {
            String backgroundColor;
            ImageResizeMode imageResizeMode;
            String color;
            SpinnerSize size;
            SpinnerOptions spinner;
            SpinnerOptions spinner2;
            SpinnerOptions spinner3;
            Boolean enabled;
            Boolean fade;
            Boolean imageFullScreen;
            boolean zBooleanValue = true;
            boolean z = (reloadScreenOptions != null ? reloadScreenOptions.getImage() : null) != null;
            if (reloadScreenOptions == null || (backgroundColor = reloadScreenOptions.getBackgroundColor()) == null) {
                backgroundColor = "#ffffff";
            }
            int color2 = Color.parseColor(backgroundColor);
            ReloadScreenImageSource image = reloadScreenOptions != null ? reloadScreenOptions.getImage() : null;
            if (reloadScreenOptions == null || (imageResizeMode = reloadScreenOptions.getImageResizeMode()) == null) {
                imageResizeMode = ImageResizeMode.CONTAIN;
            }
            ImageResizeMode imageResizeMode2 = imageResizeMode;
            boolean zBooleanValue2 = (reloadScreenOptions == null || (imageFullScreen = reloadScreenOptions.getImageFullScreen()) == null) ? false : imageFullScreen.booleanValue();
            boolean zBooleanValue3 = (reloadScreenOptions == null || (fade = reloadScreenOptions.getFade()) == null) ? false : fade.booleanValue();
            if (reloadScreenOptions != null && (spinner3 = reloadScreenOptions.getSpinner()) != null && (enabled = spinner3.getEnabled()) != null) {
                zBooleanValue = enabled.booleanValue();
            } else if (z) {
                zBooleanValue = false;
            }
            if (reloadScreenOptions == null || (spinner2 = reloadScreenOptions.getSpinner()) == null || (color = spinner2.getColor()) == null) {
                color = "#007aff";
            }
            int color3 = Color.parseColor(color);
            if (reloadScreenOptions == null || (spinner = reloadScreenOptions.getSpinner()) == null || (size = spinner.getSize()) == null) {
                size = SpinnerSize.MEDIUM;
            }
            return new ReloadScreenConfiguration(color2, image, imageResizeMode2, zBooleanValue2, zBooleanValue3, new SpinnerConfiguration(zBooleanValue, color3, size));
        }
    }
}

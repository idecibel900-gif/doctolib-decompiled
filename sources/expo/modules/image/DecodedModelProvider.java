package expo.modules.image;

import android.graphics.drawable.Drawable;
import expo.modules.image.decodedsource.DecodedModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DecodedModelProvider implements GlideModelProvider {
    private final Drawable drawable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DecodedModelProvider) && Intrinsics.areEqual(this.drawable, ((DecodedModelProvider) obj).drawable);
    }

    public int hashCode() {
        return this.drawable.hashCode();
    }

    public String toString() {
        return "DecodedModelProvider(drawable=" + this.drawable + ")";
    }

    public DecodedModelProvider(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
    }

    @Override // expo.modules.image.GlideModelProvider
    public DecodedModel getGlideModel() {
        return new DecodedModel(this.drawable);
    }
}

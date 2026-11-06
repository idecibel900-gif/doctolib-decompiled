package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class TypefaceBuilderCompat {
    public static final TypefaceBuilderCompat INSTANCE = new TypefaceBuilderCompat();

    private TypefaceBuilderCompat() {
    }

    public final android.graphics.Typeface createFromAssets(AssetManager assetManager, String str, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline1.m(assetManager, str).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    public final android.graphics.Typeface createFromFile(File file, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline0.m(file).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    public final android.graphics.Typeface createFromFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, Context context, FontVariation.Settings settings) {
        if (context == null) {
            return null;
        }
        TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline5.m();
        return TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline4.m(parcelFileDescriptor.getFileDescriptor()).setFontVariationSettings(toVariationSettings(settings, context)).build();
    }

    private final FontVariationAxis[] toVariationSettings(FontVariation.Settings settings, Context context) {
        Density Density;
        if (context != null) {
            Density = AndroidDensity_androidKt.Density(context);
        } else if (!settings.getNeedsDensity$ui_text_release()) {
            Density = DensityKt.Density(1.0f, 1.0f);
        } else {
            throw new IllegalStateException("Required density, but not provided");
        }
        List settings2 = settings.getSettings();
        ArrayList arrayList = new ArrayList(settings2.size());
        int size = settings2.size();
        for (int i = 0; i < size; i++) {
            FontVariation.Setting setting = (FontVariation.Setting) settings2.get(i);
            TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline3.m();
            arrayList.add(TypefaceBuilderCompat$$ExternalSyntheticApiModelOutline2.m(setting.getAxisName(), setting.toVariationValue(Density)));
        }
        return (FontVariationAxis[]) arrayList.toArray(new FontVariationAxis[0]);
    }
}

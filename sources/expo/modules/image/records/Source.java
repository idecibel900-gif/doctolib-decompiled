package expo.modules.image.records;

import android.content.Context;
import com.bumptech.glide.request.RequestOptions;
import expo.modules.image.GlideModelProvider;

/* JADX INFO: loaded from: classes4.dex */
public interface Source {
    GlideModelProvider createGlideModelProvider(Context context);

    RequestOptions createGlideOptions(Context context);

    int getHeight();

    double getPixelCount();

    double getScale();

    int getWidth();

    boolean usesPlaceholderContentFit();

    public static final class DefaultImpls {
        public static boolean usesPlaceholderContentFit(Source source) {
            return true;
        }

        public static double getPixelCount(Source source) {
            return ((double) (source.getWidth() * source.getHeight())) * source.getScale() * source.getScale();
        }
    }
}

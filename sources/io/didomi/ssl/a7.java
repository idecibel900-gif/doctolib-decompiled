package io.didomi.ssl;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import android.widget.ImageView;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Landroid/widget/ImageView;", "", "color", "", "a", "android_release"}, k = 2, mv = {1, 8, 0})
public final class a7 {
    public static final void a(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (Build.VERSION.SDK_INT < 29) {
            imageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        } else {
            BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline1.m();
            imageView.setColorFilter(BlendModeColorFilterHelper$$ExternalSyntheticApiModelOutline0.m(i, BlendMode.SRC_IN));
        }
    }
}

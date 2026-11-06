package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: loaded from: classes.dex */
final class DefaultFontsContractCompatLoader implements FontsContractCompatLoader {
    public static final DefaultFontsContractCompatLoader INSTANCE = new DefaultFontsContractCompatLoader();

    private DefaultFontsContractCompatLoader() {
    }

    @Override // androidx.compose.ui.text.googlefonts.FontsContractCompatLoader
    public void requestFont(Context context, FontRequest fontRequest, int i, Handler handler, FontsContractCompat.FontRequestCallback fontRequestCallback) {
        FontsContractCompat.requestFont(context, fontRequest, i, false, 0, handler, fontRequestCallback);
    }
}

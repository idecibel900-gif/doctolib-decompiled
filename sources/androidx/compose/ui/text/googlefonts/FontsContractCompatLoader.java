package androidx.compose.ui.text.googlefonts;

import android.content.Context;
import android.os.Handler;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: loaded from: classes.dex */
public interface FontsContractCompatLoader {
    void requestFont(Context context, FontRequest fontRequest, int i, Handler handler, FontsContractCompat.FontRequestCallback fontRequestCallback);
}

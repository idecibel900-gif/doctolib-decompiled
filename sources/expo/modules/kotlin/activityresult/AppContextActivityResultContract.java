package expo.modules.kotlin.activityresult;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public interface AppContextActivityResultContract {
    Intent createIntent(Context context, Serializable serializable);

    Object parseResult(Serializable serializable, int i, Intent intent);
}

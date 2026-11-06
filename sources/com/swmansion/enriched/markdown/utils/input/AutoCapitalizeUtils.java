package com.swmansion.enriched.markdown.utils.input;

import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoCapitalizeUtils {
    public static final AutoCapitalizeUtils INSTANCE = new AutoCapitalizeUtils();

    private AutoCapitalizeUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    public final void apply(EditText editText, String str) {
        int i;
        Intrinsics.checkNotNullParameter(editText, "editText");
        if (str != null) {
            switch (str.hashCode()) {
                case 3387192:
                    str.equals("none");
                    i = 0;
                    break;
                case 113318569:
                    if (!str.equals("words")) {
                        i = 0;
                    } else {
                        i = 8192;
                    }
                    break;
                case 490141296:
                    if (!str.equals("sentences")) {
                        i = 0;
                    } else {
                        i = Http2.INITIAL_MAX_FRAME_SIZE;
                    }
                    break;
                case 1245424234:
                    if (!str.equals("characters")) {
                        i = 0;
                    } else {
                        i = 4096;
                    }
                    break;
                default:
                    i = 0;
                    break;
            }
        } else {
            i = 0;
        }
        editText.setInputType((editText.getInputType() & (-28673)) | (i != 0 ? i : 0));
    }
}

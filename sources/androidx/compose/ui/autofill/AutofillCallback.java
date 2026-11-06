package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillManager$AutofillCallback;

/* JADX INFO: loaded from: classes.dex */
public final class AutofillCallback extends AutofillManager$AutofillCallback {
    public static final AutofillCallback INSTANCE = new AutofillCallback();

    private AutofillCallback() {
    }

    public void onAutofillEvent(View view, int i, int i2) {
        super.onAutofillEvent(view, i, i2);
    }

    public final void register(AndroidAutofill androidAutofill) {
        androidAutofill.getAutofillManager().registerCallback(this);
    }

    public final void unregister(AndroidAutofill androidAutofill) {
        androidAutofill.getAutofillManager().unregisterCallback(this);
    }
}

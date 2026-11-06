package io.didomi.ssl;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/zc;", "Lio/didomi/sdk/se;", "Landroid/content/Context;", "context", "", "onAttach", "d", "c", "b", "Lio/didomi/sdk/uc;", "Lio/didomi/sdk/uc;", "e", "()Lio/didomi/sdk/uc;", "setModel", "(Lio/didomi/sdk/uc;)V", "model", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class zc extends se {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public uc model;

    @Override // io.didomi.ssl.se
    public void b() {
        ImageView imageView;
        b3 binding = getBinding();
        if (binding == null || (imageView = binding.b) == null) {
            return;
        }
        imageView.setImageBitmap(e().a(imageView.getResources().getDimensionPixelSize(R.dimen.didomi_tv_preferences_qr_code_size)));
    }

    @Override // io.didomi.ssl.se
    public void c() {
        b3 binding = getBinding();
        TextView textView = binding != null ? binding.d : null;
        if (textView == null) {
            return;
        }
        textView.setText(e().E());
    }

    @Override // io.didomi.ssl.se
    public void d() {
        b3 binding = getBinding();
        TextView textView = binding != null ? binding.e : null;
        if (textView == null) {
            return;
        }
        textView.setText(e().F());
    }

    public final uc e() {
        uc ucVar = this.model;
        if (ucVar != null) {
            return ucVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }
}

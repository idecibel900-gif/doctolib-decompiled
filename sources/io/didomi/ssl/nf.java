package io.didomi.ssl;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import io.didomi.ssl.view.ctv.DidomiTVSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lio/didomi/sdk/nf;", "Lio/didomi/sdk/zf;", "Lio/didomi/sdk/wf$b;", AuthorizationRequest.Prompt.CONSENT, "Lio/didomi/sdk/lf$a;", "callback", "", "a", "Lio/didomi/sdk/u4;", "Lio/didomi/sdk/u4;", "binding", "<init>", "(Lio/didomi/sdk/u4;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class nf extends zf {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final u4 binding;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/nf$a", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch$a;", "Lio/didomi/sdk/view/ctv/DidomiTVSwitch;", "switch", "", "isChecked", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements DidomiTVSwitch.a {
        final /* synthetic */ wf.Consent b;
        final /* synthetic */ lf.a c;

        a(wf.Consent consent, lf.a aVar) {
            this.b = consent;
            this.c = aVar;
        }

        @Override // io.didomi.sdk.view.ctv.DidomiTVSwitch.a
        public void a(DidomiTVSwitch didomiTVSwitch, boolean isChecked) {
            Intrinsics.checkNotNullParameter(didomiTVSwitch, "switch");
            TextView textView = nf.this.binding.d;
            wf.Consent consent = this.b;
            textView.setText(isChecked ? consent.getStatusOn() : consent.getStatusOff());
            this.c.a(isChecked);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf(u4 binding) {
        super(binding);
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final void a(wf.Consent consent, final lf.a callback) {
        Intrinsics.checkNotNullParameter(consent, "consent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        u4 u4Var = this.binding;
        u4Var.e.setText(consent.getText());
        u4Var.d.setText(consent.getIsChecked() ? consent.getStatusOn() : consent.getStatusOff());
        final DidomiTVSwitch didomiTVSwitch = this.binding.c;
        didomiTVSwitch.setCallback(null);
        didomiTVSwitch.setAnimate(false);
        didomiTVSwitch.setChecked(consent.getIsChecked());
        didomiTVSwitch.setCallback(new a(consent, callback));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.nf$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nf.a(didomiTVSwitch, view);
            }
        });
        didomiTVSwitch.post(new Runnable() { // from class: io.didomi.sdk.nf$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                nf.a(didomiTVSwitch);
            }
        });
        this.itemView.setOnKeyListener(new View.OnKeyListener() { // from class: io.didomi.sdk.nf$$ExternalSyntheticLambda2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return nf.a(callback, view, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DidomiTVSwitch this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setAnimate(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(lf.a callback, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i != 22 || keyEvent.getAction() != 1) {
            return false;
        }
        callback.a();
        return true;
    }
}

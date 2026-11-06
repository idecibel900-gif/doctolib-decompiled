package io.didomi.ssl.notice.ctv;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.FragmentManager;
import io.didomi.ssl.R;
import io.didomi.ssl.e2;
import io.didomi.ssl.o;
import io.didomi.ssl.zc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/notice/ctv/TVNoticeDialogActivity;", "Lio/didomi/sdk/o;", "Lio/didomi/sdk/notice/ctv/a$a;", "", "l", "m", "", "hasPrivacyDialog", "a", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", "b", "io/didomi/sdk/notice/ctv/TVNoticeDialogActivity$a", "d", "Lio/didomi/sdk/notice/ctv/TVNoticeDialogActivity$a;", "backPressedCallback", "Lio/didomi/sdk/e2;", "e", "Lio/didomi/sdk/e2;", "binding", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class TVNoticeDialogActivity extends o implements io.didomi.ssl.notice.ctv.a.InterfaceC0153a {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final a backPressedCallback = new a();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private e2 binding;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"io/didomi/sdk/notice/ctv/TVNoticeDialogActivity$a", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends OnBackPressedCallback {
        a() {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (TVNoticeDialogActivity.this.getSupportFragmentManager().getFragments().size() == 1) {
                return;
            }
            TVNoticeDialogActivity.this.getSupportFragmentManager().popBackStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TVNoticeDialogActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(this$0.getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.QR_CODE") != null);
    }

    private final void l() {
        if (getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.CONSENT_POPUP") != null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container_ctv_notice_primary, new io.didomi.ssl.notice.ctv.a(), "io.didomi.dialog.CONSENT_POPUP").commit();
    }

    private final void m() {
        if (getSupportFragmentManager().findFragmentByTag("io.didomi.dialog.QR_CODE") != null) {
            return;
        }
        a(true);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_fade_out, R.anim.didomi_fade_in, R.anim.didomi_exit_to_right).add(R.id.container_ctv_notice_secondary, new zc(), "io.didomi.dialog.QR_CODE").addToBackStack("io.didomi.dialog.QR_CODE").commit();
    }

    @Override // io.didomi.ssl.notice.ctv.a.InterfaceC0153a
    public void b() {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        e2 e2VarA = e2.a(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(e2VarA, "inflate(layoutInflater)");
        this.binding = e2VarA;
        e2 e2Var = null;
        if (e2VarA == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            e2VarA = null;
        }
        setContentView(e2VarA.getRoot());
        e2 e2Var2 = this.binding;
        if (e2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            e2Var = e2Var2;
        }
        View view = e2Var.d;
        Intrinsics.checkNotNullExpressionValue(view, "binding.viewCtvNoticeBackground");
        a(view);
        getOnBackPressedDispatcher().addCallback(this, this.backPressedCallback);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: io.didomi.sdk.notice.ctv.TVNoticeDialogActivity$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                TVNoticeDialogActivity.a(this.f$0);
            }
        });
        l();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
    }

    @Override // io.didomi.ssl.notice.ctv.a.InterfaceC0153a
    public void a() {
        m();
    }

    private final void a(boolean hasPrivacyDialog) {
        int i;
        e2 e2Var = this.binding;
        if (e2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            e2Var = null;
        }
        FrameLayout frameLayout = e2Var.b;
        frameLayout.setFocusable(hasPrivacyDialog);
        frameLayout.setFocusableInTouchMode(hasPrivacyDialog);
        if (hasPrivacyDialog) {
            frameLayout.clearFocus();
            g();
            i = 393216;
        } else {
            h();
            i = 131072;
        }
        frameLayout.setDescendantFocusability(i);
    }
}

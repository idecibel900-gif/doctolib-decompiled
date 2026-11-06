package io.didomi.ssl;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0017\u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010-\u001a\u0004\b\u001f\u0010.\"\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lio/didomi/sdk/o0;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/Context;", "context", "", "onAttach", "", "getTheme", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onStart", "onResume", "onPause", "onDestroyView", "Lio/didomi/sdk/eh;", "a", "Lio/didomi/sdk/eh;", "d", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/q0;", "b", "Lio/didomi/sdk/q0;", "()Lio/didomi/sdk/q0;", "setModel", "(Lio/didomi/sdk/q0;)V", "model", "Lio/didomi/sdk/ah;", "c", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/a8;", "Lio/didomi/sdk/a8;", "()Lio/didomi/sdk/a8;", "setNavigationManager", "(Lio/didomi/sdk/a8;)V", "navigationManager", "Lio/didomi/sdk/l2;", "e", "Lio/didomi/sdk/l2;", "binding", "Lio/didomi/sdk/n0;", "f", "Lio/didomi/sdk/n0;", "helper", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "job", "<init>", "()V", "h", "android_release"}, k = 1, mv = {1, 8, 0})
public final class o0 extends DialogFragment {

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public q0 model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public a8 navigationManager;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private l2 binding;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private n0 helper;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private Job job;

    /* JADX INFO: renamed from: io.didomi.sdk.o0$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/o0$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (fragmentManager.findFragmentByTag("ConsentNoticePopupFragment") != null) {
                Log.w$default("Fragment with tag 'ConsentNoticePopupFragment' is already present", null, 2, null);
                return;
            }
            o0 o0Var = new o0();
            o0Var.setCancelable(false);
            o0Var.show(fragmentManager, "ConsentNoticePopupFragment");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isVisible", "", "a", "(Z)V"}, k = 3, mv = {1, 8, 0})
    static final class b extends Lambda implements Function1 {
        b() {
            super(1);
        }

        public final void a(boolean z) {
            if (z) {
                return;
            }
            o0.this.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    public final q0 a() {
        q0 q0Var = this.model;
        if (q0Var != null) {
            return q0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    public final a8 b() {
        a8 a8Var = this.navigationManager;
        if (a8Var != null) {
            return a8Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigationManager");
        return null;
    }

    public final ah c() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    public final eh d() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.Didomi_Theme_Dialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        h2 h2VarA = d2.a(this);
        if (h2VarA != null) {
            h2VarA.a(this);
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        l2 l2VarA = l2.a(inflater, parent, false);
        this.binding = l2VarA;
        LinearLayout root = l2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, parent…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        u7 logoProvider = a().getLogoProvider();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        logoProvider.a(viewLifecycleOwner);
        n0 n0Var = this.helper;
        if (n0Var != null) {
            n0Var.j();
        }
        this.helper = null;
        this.binding = null;
        Job job = this.job;
        if (job != null) {
            job.cancel(null);
        }
        this.job = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Job job = this.job;
        if (job != null) {
            job.cancel(null);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.job = c6.a(this, d().e(), new b());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        int iWidth;
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window == null) {
            return;
        }
        WindowManager windowManager = requireActivity().getWindowManager();
        if (Build.VERSION.SDK_INT >= 30) {
            iWidth = windowManager.getCurrentWindowMetrics().getBounds().width();
        } else {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            iWidth = point.x;
        }
        int dimensionPixelOffset = requireContext().getResources().getDimensionPixelOffset(R.dimen.didomi_content_max_width_without_padding);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (iWidth < dimensionPixelOffset) {
            dimensionPixelOffset = -1;
        }
        attributes.width = dimensionPixelOffset;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        Drawable background = (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.getBackground();
        if (background != null) {
            background.setColorFilter(new PorterDuffColorFilter(c().a(), PorterDuff.Mode.SRC_IN));
        }
        FragmentActivity activity = getActivity();
        l2 l2Var = this.binding;
        Intrinsics.checkNotNull(l2Var, "null cannot be cast to non-null type io.didomi.sdk.databinding.DidomiFragmentConsentNoticeBinding");
        q0 q0VarA = a();
        ah ahVarC = c();
        a8 a8VarB = b();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        this.helper = new n0(activity, l2Var, q0VarA, ahVarC, a8VarB, viewLifecycleOwner);
    }
}

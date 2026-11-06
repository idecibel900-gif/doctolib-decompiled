package io.didomi.ssl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.view.mobile.HeaderView;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020!8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b\u0014\u0010#\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lio/didomi/sdk/lh;", "Lio/didomi/sdk/g2;", "", "b", "d", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lio/didomi/sdk/h3;", "a", "Lio/didomi/sdk/h3;", "binding", "Ljava/util/Timer;", "Ljava/util/Timer;", "timer", "Lio/didomi/sdk/nh;", "c", "Lio/didomi/sdk/nh;", "()Lio/didomi/sdk/nh;", "setModel", "(Lio/didomi/sdk/nh;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "<init>", "()V", "e", "android_release"}, k = 1, mv = {1, 8, 0})
public final class lh extends g2 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private h3 binding;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Timer timer;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public nh model;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: io.didomi.sdk.lh$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087T¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/lh$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "a", "", "DELAY_REVERT", "J", "getDELAY_REVERT$annotations", "()V", "DURATION_ANIMATION", "", "TAG", "Ljava/lang/String;", "<init>", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (fragmentManager.findFragmentByTag("UserInfoFragment") == null) {
                new lh().show(fragmentManager, "UserInfoFragment");
            } else {
                Log.w$default("Fragment with tag 'UserInfoFragment' is already present", null, 2, null);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"io/didomi/sdk/lh$b", "Ljava/util/TimerTask;", "", "run", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0})
    public static final class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            lh.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(lh this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        final h3 h3Var = this.binding;
        if (h3Var != null) {
            requireActivity().runOnUiThread(new Runnable() { // from class: io.didomi.sdk.lh$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    lh.a(h3Var);
                }
            });
        }
    }

    public final nh c() {
        nh nhVar = this.model;
        if (nhVar != null) {
            return nhVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        h3 h3VarA = h3.a(inflater, container, false);
        this.binding = h3VarA;
        ConstraintLayout root = h3VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        u7 logoProvider = c().getLogoProvider();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        logoProvider.a(viewLifecycleOwner);
        this.binding = null;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        h3 h3Var = this.binding;
        if (h3Var != null) {
            HeaderView headerView = h3Var.g;
            Intrinsics.checkNotNullExpressionValue(headerView, "binding.userInfoHeader");
            u7 logoProvider = c().getLogoProvider();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            HeaderView.a(headerView, logoProvider, viewLifecycleOwner, c().f(), null, 8, null);
            AppCompatImageButton onViewCreated$lambda$8$lambda$2 = h3Var.b;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$2, "onViewCreated$lambda$8$lambda$2");
            mi.a(onViewCreated$lambda$8$lambda$2, c().a());
            a7.a(onViewCreated$lambda$8$lambda$2, a().j());
            onViewCreated$lambda$8$lambda$2.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.lh$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    lh.a(this.f$0, view2);
                }
            });
            TextView onViewCreated$lambda$8$lambda$3 = h3Var.i;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$3, "onViewCreated$lambda$8$lambda$3");
            zg.a(onViewCreated$lambda$8$lambda$3, a().i().n());
            onViewCreated$lambda$8$lambda$3.setText(c().c());
            TextView onViewCreated$lambda$8$lambda$4 = h3Var.d;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$4, "onViewCreated$lambda$8$lambda$4");
            zg.a(onViewCreated$lambda$8$lambda$4, a().i().d());
            onViewCreated$lambda$8$lambda$4.setText(c().getContentText());
            AppCompatButton onViewCreated$lambda$8$lambda$6 = h3Var.c;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$6, "onViewCreated$lambda$8$lambda$6");
            mi.a(onViewCreated$lambda$8$lambda$6, c().h());
            s.a(onViewCreated$lambda$8$lambda$6, a().r());
            onViewCreated$lambda$8$lambda$6.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.lh$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    lh.b(this.f$0, view2);
                }
            });
            AppCompatImageView appCompatImageView = h3Var.e;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.userInfoCopiedImage");
            a7.a(appCompatImageView, a().j());
            TextView onViewCreated$lambda$8$lambda$7 = h3Var.f;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$7, "onViewCreated$lambda$8$lambda$7");
            zg.a(onViewCreated$lambda$8$lambda$7, a().i().c());
            onViewCreated$lambda$8$lambda$7.setText(c().d());
            onViewCreated$lambda$8$lambda$7.setVisibility(4);
        }
    }

    private final void b() {
        h3 h3Var = this.binding;
        if (h3Var != null) {
            AppCompatImageView appCompatImageView = h3Var.e;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "binding.userInfoCopiedImage");
            ni.a(appCompatImageView, 50L, 0, null, 6, null);
            TextView copyInfoToClipBoard$lambda$10$lambda$9 = h3Var.f;
            copyInfoToClipBoard$lambda$10$lambda$9.announceForAccessibility(c().d());
            Intrinsics.checkNotNullExpressionValue(copyInfoToClipBoard$lambda$10$lambda$9, "copyInfoToClipBoard$lambda$10$lambda$9");
            ni.a(copyInfoToClipBoard$lambda$10$lambda$9, 50L, (Function0) null, 2, (Object) null);
        }
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(requireContext(), ClipboardManager.class);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(c().c(), c().getContentText()));
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        timer2.schedule(new b(), 2000L);
        this.timer = timer2;
    }

    @Override // io.didomi.ssl.g2
    public ah a() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lh this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(h3 this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        TextView userInfoCopiedText = this_apply.f;
        Intrinsics.checkNotNullExpressionValue(userInfoCopiedText, "userInfoCopiedText");
        ni.a(userInfoCopiedText, 50L, 4, null, 4, null);
        AppCompatImageView userInfoCopiedImage = this_apply.e;
        Intrinsics.checkNotNullExpressionValue(userInfoCopiedImage, "userInfoCopiedImage");
        ni.a(userInfoCopiedImage, 50L, (Function0) null, 2, (Object) null);
    }
}

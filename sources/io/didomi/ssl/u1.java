package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.view.mobile.HeaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u001d8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u0005\u0010\u001f\"\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lio/didomi/sdk/u1;", "Lio/didomi/sdk/g2;", "", "isPrevious", "", "a", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "onDestroyView", "Lio/didomi/sdk/a2;", "Lio/didomi/sdk/a2;", "b", "()Lio/didomi/sdk/a2;", "setModel", "(Lio/didomi/sdk/a2;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/eh;", "c", "Lio/didomi/sdk/eh;", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/v8;", "d", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/m2;", "e", "Lio/didomi/sdk/m2;", "binding", "<init>", "()V", "f", "android_release"}, k = 1, mv = {1, 8, 0})
public final class u1 extends g2 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public a2 model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private m2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.u1$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lio/didomi/sdk/u1$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            if (fragmentManager.findFragmentByTag("DeviceStorageDisclosureFragment") == null) {
                new u1().show(fragmentManager, "DeviceStorageDisclosureFragment");
            } else {
                Log.w$default("Fragment with tag 'DeviceStorageDisclosureFragment' is already present", null, 2, null);
            }
        }

        private Companion() {
        }
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

    public final a2 b() {
        a2 a2Var = this.model;
        if (a2Var != null) {
            return a2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    public final eh c() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
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
        m2 m2VarA = m2.a(inflater, container, false);
        this.binding = m2VarA;
        ConstraintLayout root = m2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        u7 logoProvider = b().getLogoProvider();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        logoProvider.a(viewLifecycleOwner);
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.dismissHelper.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.dismissHelper.a(this, c());
    }

    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        m2 m2Var = this.binding;
        if (m2Var != null) {
            HeaderView headerView = m2Var.c;
            Intrinsics.checkNotNullExpressionValue(headerView, "binding.disclosureHeader");
            u7 logoProvider = b().getLogoProvider();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            HeaderView.a(headerView, logoProvider, viewLifecycleOwner, b().o(), null, 8, null);
            AppCompatImageButton onViewCreated$lambda$7$lambda$2 = m2Var.b;
            String strB = b().b();
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$7$lambda$2, "onViewCreated$lambda$7$lambda$2");
            mi.a(onViewCreated$lambda$7$lambda$2, strB, strB, null, false, null, 0, null, null, 252, null);
            a7.a(onViewCreated$lambda$7$lambda$2, a().j());
            onViewCreated$lambda$7$lambda$2.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.u1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    u1.a(this.f$0, view2);
                }
            });
            View view2 = m2Var.g;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewDisclosuresBottomDivider");
            ni.a(view2, a());
            Button onViewCreated$lambda$7$lambda$4 = m2Var.e;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$7$lambda$4, "onViewCreated$lambda$7$lambda$4");
            zg.a(onViewCreated$lambda$7$lambda$4, a().i().k());
            onViewCreated$lambda$7$lambda$4.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.u1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    u1.b(this.f$0, view3);
                }
            });
            onViewCreated$lambda$7$lambda$4.setText(b().k());
            Button onViewCreated$lambda$7$lambda$6 = m2Var.d;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$7$lambda$6, "onViewCreated$lambda$7$lambda$6");
            zg.a(onViewCreated$lambda$7$lambda$6, a().i().k());
            onViewCreated$lambda$7$lambda$6.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.u1$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    u1.c(this.f$0, view3);
                }
            });
            onViewCreated$lambda$7$lambda$6.setText(b().j());
        }
        getChildFragmentManager().beginTransaction().add(R.id.selected_disclosure_container, new ob(), "io.didomi.dialog.DISCLOSURE_CONTENT").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(u1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(u1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b().s();
        this$0.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(u1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b().r();
        this$0.a(false);
    }

    private final void a(boolean isPrevious) {
        if (!b().a()) {
            dismiss();
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        if (isPrevious) {
            fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.didomi_enter_from_left, R.anim.didomi_exit_to_right);
        } else {
            fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.didomi_enter_from_right, R.anim.didomi_exit_to_left);
        }
        fragmentTransactionBeginTransaction.replace(R.id.selected_disclosure_container, new ob(), "io.didomi.dialog.DISCLOSURE_CONTENT");
        fragmentTransactionBeginTransaction.commit();
    }
}

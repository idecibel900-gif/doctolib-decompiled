package io.didomi.ssl;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.DidomiToggle;
import io.didomi.ssl.view.mobile.HeaderView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0006\u0010 \u001a\u0004\b\u0006\u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020%8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b\u0005\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010,¨\u00061"}, d2 = {"Lio/didomi/sdk/m9;", "Lio/didomi/sdk/g2;", "Lio/didomi/sdk/Purpose;", "purpose", "", "a", "b", "c", "d", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "Landroid/content/DialogInterface;", "dialog", "onCancel", "onDestroyView", "Lio/didomi/sdk/v8;", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/ra;", "Lio/didomi/sdk/ra;", "()Lio/didomi/sdk/ra;", "setModel", "(Lio/didomi/sdk/ra;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/n2;", "Lio/didomi/sdk/n2;", "binding", "<init>", "()V", "e", "android_release"}, k = 1, mv = {1, 8, 0})
public final class m9 extends g2 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ra model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private n2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.m9$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/m9$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/didomi/sdk/Purpose;", "purpose", "", "a", "", "PURPOSE", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, Purpose purpose) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            if (fragmentManager.findFragmentByTag("PurposeDetailFragment") != null) {
                Log.w$default("Fragment with tag 'PurposeDetailFragment' is already present", null, 2, null);
                return;
            }
            m9 m9Var = new m9();
            Bundle bundle = new Bundle();
            bundle.putParcelable("purpose", purpose);
            m9Var.setArguments(bundle);
            m9Var.show(fragmentManager, "PurposeDetailFragment");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/m9$b", "Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "Lio/didomi/sdk/view/mobile/DidomiToggle;", "toggle", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements DidomiToggle.a {
        final /* synthetic */ Purpose b;
        final /* synthetic */ DidomiToggle c;

        b(Purpose purpose, DidomiToggle didomiToggle) {
            this.b = purpose;
            this.c = didomiToggle;
        }

        @Override // io.didomi.sdk.view.mobile.DidomiToggle.a
        public void a(DidomiToggle toggle, DidomiToggle.b state) {
            Intrinsics.checkNotNullParameter(toggle, "toggle");
            Intrinsics.checkNotNullParameter(state, "state");
            m9.this.b().b(this.b, state);
            m9.this.d();
            DidomiToggle onStateChange = this.c;
            Intrinsics.checkNotNullExpressionValue(onStateChange, "onStateChange");
            mi.b(onStateChange, m9.this.b().u0());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"io/didomi/sdk/m9$c", "Lio/didomi/sdk/view/mobile/DidomiToggle$a;", "Lio/didomi/sdk/view/mobile/DidomiToggle;", "toggle", "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements DidomiToggle.a {
        final /* synthetic */ Purpose b;
        final /* synthetic */ DidomiToggle c;

        c(Purpose purpose, DidomiToggle didomiToggle) {
            this.b = purpose;
            this.c = didomiToggle;
        }

        @Override // io.didomi.sdk.view.mobile.DidomiToggle.a
        public void a(DidomiToggle toggle, DidomiToggle.b state) {
            Intrinsics.checkNotNullParameter(toggle, "toggle");
            Intrinsics.checkNotNullParameter(state, "state");
            m9.this.b().c(this.b, state);
            DidomiToggle onStateChange = this.c;
            Intrinsics.checkNotNullExpressionValue(onStateChange, "onStateChange");
            mi.b(onStateChange, m9.this.b().w0());
        }
    }

    private final void c() {
        b().d1();
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        n2 n2Var = this.binding;
        if (n2Var != null) {
            if (b().S0()) {
                View viewPurposeDetailBottomDivider = n2Var.q;
                Intrinsics.checkNotNullExpressionValue(viewPurposeDetailBottomDivider, "viewPurposeDetailBottomDivider");
                viewPurposeDetailBottomDivider.setVisibility(8);
                PurposeSaveView savePurposeDetail = n2Var.h;
                Intrinsics.checkNotNullExpressionValue(savePurposeDetail, "savePurposeDetail");
                savePurposeDetail.setVisibility(8);
                return;
            }
            View viewPurposeDetailBottomDivider2 = n2Var.q;
            Intrinsics.checkNotNullExpressionValue(viewPurposeDetailBottomDivider2, "viewPurposeDetailBottomDivider");
            viewPurposeDetailBottomDivider2.setVisibility(0);
            PurposeSaveView updateButtons$lambda$25$lambda$24 = n2Var.h;
            Intrinsics.checkNotNullExpressionValue(updateButtons$lambda$25$lambda$24, "updateButtons$lambda$25$lambda$24");
            updateButtons$lambda$25$lambda$24.setVisibility(0);
            if (b().R0()) {
                updateButtons$lambda$25$lambda$24.b();
            } else {
                updateButtons$lambda$25$lambda$24.a();
            }
        }
    }

    public final ra b() {
        ra raVar = this.model;
        if (raVar != null) {
            return raVar;
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        c();
        super.onCancel(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        n2 n2VarA = n2.a(inflater, container, false);
        this.binding = n2VarA;
        ConstraintLayout root = n2VarA.getRoot();
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
        this.dismissHelper.a();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ScrollView scrollView;
        super.onResume();
        n2 n2Var = this.binding;
        if (n2Var != null && (scrollView = n2Var.i) != null) {
            scrollView.scrollTo(0, 0);
        }
        this.dismissHelper.a(this, b().getUiProvider());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Purpose purpose;
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                purpose = (Purpose) arguments.getParcelable("purpose", Purpose.class);
            } else {
                purpose = null;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                purpose = (Purpose) arguments2.getParcelable("purpose");
            } else {
                purpose = null;
            }
        }
        if (purpose == null) {
            Log.e$default("Purpose not initialized, abort.", null, 2, null);
            dismiss();
            return;
        }
        ra raVarB = b();
        raVarB.u(purpose);
        raVarB.o(purpose);
        raVarB.e1();
        n2 n2Var = this.binding;
        if (n2Var != null) {
            AppCompatImageButton onViewCreated$lambda$11$lambda$3 = n2Var.b;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$3, "onViewCreated$lambda$11$lambda$3");
            mi.a(onViewCreated$lambda$11$lambda$3, b().G());
            a7.a(onViewCreated$lambda$11$lambda$3, a().j());
            onViewCreated$lambda$11$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.m9$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m9.b(this.f$0, view2);
                }
            });
            HeaderView headerView = n2Var.g;
            Intrinsics.checkNotNullExpressionValue(headerView, "binding.headerPurposeDetail");
            u7 logoProvider = b().getLogoProvider();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            HeaderView.a(headerView, logoProvider, viewLifecycleOwner, b().D0(), null, 8, null);
            TextView onViewCreated$lambda$11$lambda$4 = n2Var.p;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$4, "onViewCreated$lambda$11$lambda$4");
            zg.a(onViewCreated$lambda$11$lambda$4, a().i().n());
            onViewCreated$lambda$11$lambda$4.setText(b().k(purpose));
            TextView onViewCreated$lambda$11$lambda$5 = n2Var.m;
            if (StringsKt.isBlank(purpose.getDescription())) {
                i = 8;
            } else {
                Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$5, "onViewCreated$lambda$11$lambda$5");
                zg.a(onViewCreated$lambda$11$lambda$5, a().i().c());
                onViewCreated$lambda$11$lambda$5.setText(b().i(purpose));
                i = 0;
            }
            onViewCreated$lambda$11$lambda$5.setVisibility(i);
            TextView onViewCreated$lambda$11$lambda$6 = n2Var.n;
            if (b().s1()) {
                Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$6, "onViewCreated$lambda$11$lambda$6");
                zg.a(onViewCreated$lambda$11$lambda$6, a().i().c());
                onViewCreated$lambda$11$lambda$6.setText(b().h0());
                onViewCreated$lambda$11$lambda$6.setVisibility(0);
            } else {
                Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$11$lambda$6, "onViewCreated$lambda$11$lambda$6");
                onViewCreated$lambda$11$lambda$6.setVisibility(8);
            }
            List<String> listA0 = b().a0();
            if (listA0.isEmpty()) {
                LinearLayout root = n2Var.s.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.viewPurposeDetailIllustrations.root");
                root.setVisibility(8);
            } else {
                p5 p5Var = n2Var.s;
                p5Var.d.setText(b().b0());
                TextView textPurposeIllustrationsHeader = p5Var.d;
                Intrinsics.checkNotNullExpressionValue(textPurposeIllustrationsHeader, "textPurposeIllustrationsHeader");
                zg.a(textPurposeIllustrationsHeader, a().i().c());
                p5Var.b.setText((CharSequence) CollectionsKt.first((List) listA0));
                TextView textPurposeIllustration1 = p5Var.b;
                Intrinsics.checkNotNullExpressionValue(textPurposeIllustration1, "textPurposeIllustration1");
                zg.a(textPurposeIllustration1, a().i().c());
                if (listA0.size() > 1) {
                    p5Var.c.setText(listA0.get(1));
                    TextView textPurposeIllustration2 = p5Var.c;
                    Intrinsics.checkNotNullExpressionValue(textPurposeIllustration2, "textPurposeIllustration2");
                    zg.a(textPurposeIllustration2, a().i().c());
                    p5Var.e.setBackgroundColor(a().q());
                } else {
                    View viewPurposeIllustrationsDivider = p5Var.e;
                    Intrinsics.checkNotNullExpressionValue(viewPurposeIllustrationsDivider, "viewPurposeIllustrationsDivider");
                    viewPurposeIllustrationsDivider.setVisibility(8);
                    TextView textPurposeIllustration3 = p5Var.c;
                    Intrinsics.checkNotNullExpressionValue(textPurposeIllustration3, "textPurposeIllustration2");
                    textPurposeIllustration3.setVisibility(8);
                }
                p5Var.getRoot().setBackground(a().o());
                LinearLayout root2 = p5Var.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "root");
                root2.setVisibility(0);
            }
            if (b().m1()) {
                a(purpose);
            } else {
                Group group = n2Var.e;
                Intrinsics.checkNotNullExpressionValue(group, "binding.groupPurposeDetailConsent");
                group.setVisibility(8);
            }
            if (b().n1()) {
                b(purpose);
            } else {
                Group group2 = n2Var.f;
                Intrinsics.checkNotNullExpressionValue(group2, "binding.groupPurposeDetailLegitimateInterest");
                group2.setVisibility(8);
            }
            PurposeSaveView purposeSaveView = n2Var.h;
            purposeSaveView.setDescriptionText(b().o0());
            Button saveButton$android_release = purposeSaveView.getSaveButton$android_release();
            if (saveButton$android_release != null) {
                zg.a(saveButton$android_release, purposeSaveView.getThemeProvider().i().j());
                saveButton$android_release.setText(b().p0());
                saveButton$android_release.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.m9$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        m9.a(this.f$0, view2);
                    }
                });
                purposeSaveView.a(b().p0(), b().y());
            }
            ImageView logoImage$android_release = purposeSaveView.getLogoImage$android_release();
            if (logoImage$android_release != null) {
                logoImage$android_release.setVisibility(b().c(false) ? 4 : 0);
            }
            View view2 = n2Var.q;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewPurposeDetailBottomDivider");
            ni.a(view2, a());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(m9 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
        this$0.dismiss();
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
    public static final void a(m9 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void a(final Purpose purpose) {
        n2 n2Var = this.binding;
        if (n2Var != null) {
            DidomiToggle updatePurposeConsent$lambda$17$lambda$12 = n2Var.j;
            Intrinsics.checkNotNullExpressionValue(updatePurposeConsent$lambda$17$lambda$12, "updatePurposeConsent$lambda$17$lambda$12");
            mi.a(updatePurposeConsent$lambda$17$lambda$12, b().u0());
            DidomiToggle.b bVar = (DidomiToggle.b) b().getSelectedPurposeConsentState().getValue();
            if (bVar == null) {
                bVar = DidomiToggle.b.UNKNOWN;
            } else {
                Intrinsics.checkNotNullExpressionValue(bVar, "model.selectedPurposeCon…idomiToggle.State.UNKNOWN");
            }
            updatePurposeConsent$lambda$17$lambda$12.setState(bVar);
            updatePurposeConsent$lambda$17$lambda$12.setCallback(new b(purpose, updatePurposeConsent$lambda$17$lambda$12));
            TextView updatePurposeConsent$lambda$17$lambda$13 = n2Var.l;
            Intrinsics.checkNotNullExpressionValue(updatePurposeConsent$lambda$17$lambda$13, "updatePurposeConsent$lambda$17$lambda$13");
            zg.a(updatePurposeConsent$lambda$17$lambda$13, a().i().c());
            updatePurposeConsent$lambda$17$lambda$13.setText(b().J());
            String strM = b().m(purpose);
            if (strM != null) {
                AppCompatButton updatePurposeConsent$lambda$17$lambda$16$lambda$15 = n2Var.c;
                Intrinsics.checkNotNullExpressionValue(updatePurposeConsent$lambda$17$lambda$16$lambda$15, "updatePurposeConsent$lambda$17$lambda$16$lambda$15");
                zg.a(updatePurposeConsent$lambda$17$lambda$16$lambda$15, a().i().s());
                updatePurposeConsent$lambda$17$lambda$16$lambda$15.setText(strM);
                updatePurposeConsent$lambda$17$lambda$16$lambda$15.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.m9$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        m9.a(this.f$0, purpose, view);
                    }
                });
                updatePurposeConsent$lambda$17$lambda$16$lambda$15.setVisibility(0);
            }
            Group group = n2Var.e;
            Intrinsics.checkNotNullExpressionValue(group, "binding.groupPurposeDetailConsent");
            group.setVisibility(0);
            View view = n2Var.r;
            Intrinsics.checkNotNullExpressionValue(view, "binding.viewPurposeDetailConsentDivider");
            ni.a(view, a(), true);
        }
    }

    private final void b(final Purpose purpose) {
        DidomiToggle.b bVar;
        n2 n2Var = this.binding;
        if (n2Var != null) {
            DidomiToggle updatePurposeLegInt$lambda$23$lambda$18 = n2Var.k;
            Intrinsics.checkNotNullExpressionValue(updatePurposeLegInt$lambda$23$lambda$18, "updatePurposeLegInt$lambda$23$lambda$18");
            mi.a(updatePurposeLegInt$lambda$23$lambda$18, b().w0());
            if (b().q(purpose)) {
                bVar = DidomiToggle.b.ENABLED;
            } else {
                bVar = DidomiToggle.b.DISABLED;
            }
            updatePurposeLegInt$lambda$23$lambda$18.setState(bVar);
            updatePurposeLegInt$lambda$23$lambda$18.setCallback(new c(purpose, updatePurposeLegInt$lambda$23$lambda$18));
            TextView updatePurposeLegInt$lambda$23$lambda$19 = n2Var.o;
            Intrinsics.checkNotNullExpressionValue(updatePurposeLegInt$lambda$23$lambda$19, "updatePurposeLegInt$lambda$23$lambda$19");
            zg.a(updatePurposeLegInt$lambda$23$lambda$19, a().i().c());
            updatePurposeLegInt$lambda$23$lambda$19.setText(b().d0());
            String strN = b().n(purpose);
            if (strN != null) {
                AppCompatButton updatePurposeLegInt$lambda$23$lambda$22$lambda$21 = n2Var.d;
                Intrinsics.checkNotNullExpressionValue(updatePurposeLegInt$lambda$23$lambda$22$lambda$21, "updatePurposeLegInt$lambda$23$lambda$22$lambda$21");
                zg.a(updatePurposeLegInt$lambda$23$lambda$22$lambda$21, a().i().s());
                updatePurposeLegInt$lambda$23$lambda$22$lambda$21.setText(strN);
                updatePurposeLegInt$lambda$23$lambda$22$lambda$21.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.m9$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        m9.b(this.f$0, purpose, view);
                    }
                });
                updatePurposeLegInt$lambda$23$lambda$22$lambda$21.setVisibility(0);
            }
            Group group = n2Var.f;
            Intrinsics.checkNotNullExpressionValue(group, "binding.groupPurposeDetailLegitimateInterest");
            group.setVisibility(0);
            View view = n2Var.t;
            Intrinsics.checkNotNullExpressionValue(view, "binding.viewPurposeDetailLegitimateInterestDivider");
            ni.a(view, a(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(m9 this$0, Purpose purpose, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(purpose, "$purpose");
        ga.Companion companion = ga.INSTANCE;
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.a(parentFragmentManager, purpose, gi.PurposeLI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(m9 this$0, Purpose purpose, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(purpose, "$purpose");
        ga.Companion companion = ga.INSTANCE;
        FragmentManager parentFragmentManager = this$0.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.a(parentFragmentManager, purpose, gi.PurposeConsent);
    }
}

package io.didomi.ssl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.HeaderView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0014\u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\u001f\u0010(\"\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lio/didomi/sdk/c;", "Lio/didomi/sdk/g2;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "onDestroyView", "Lio/didomi/sdk/v8;", "a", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/n1;", "b", "Lio/didomi/sdk/n1;", "()Lio/didomi/sdk/n1;", "setModel", "(Lio/didomi/sdk/n1;)V", "model", "Lio/didomi/sdk/ah;", "c", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/eh;", "d", "Lio/didomi/sdk/eh;", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/n2;", "e", "Lio/didomi/sdk/n2;", "binding", "<init>", "()V", "f", "android_release"}, k = 1, mv = {1, 8, 0})
public final class c extends g2 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public n1 model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private n2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.c$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/c$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/didomi/sdk/m1;", "dataProcessing", "", "a", "", "KEY_DATA_PROCESSING", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, m1 dataProcessing) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(dataProcessing, "dataProcessing");
            if (fragmentManager.findFragmentByTag("AdditionalDataProcessingDetailFragment") != null) {
                Log.w$default("Fragment with tag 'AdditionalDataProcessingDetailFragment' is already present", null, 2, null);
                return;
            }
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putParcelable("data_processing", dataProcessing);
            cVar.setArguments(bundle);
            cVar.show(fragmentManager, "AdditionalDataProcessingDetailFragment");
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

    public final n1 b() {
        n1 n1Var = this.model;
        if (n1Var != null) {
            return n1Var;
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
        this.dismissHelper.a(this, c());
        n2 n2Var = this.binding;
        if (n2Var == null || (scrollView = n2Var.i) == null) {
            return;
        }
        scrollView.scrollTo(0, 0);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m1 m1Var;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                m1Var = (m1) arguments.getParcelable("data_processing", m1.class);
            } else {
                m1Var = null;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                m1Var = (m1) arguments2.getParcelable("data_processing");
            } else {
                m1Var = null;
            }
        }
        if (m1Var == null) {
            Log.e$default("Data Processing not initialized, abort.", null, 2, null);
            dismiss();
            return;
        }
        b().a(m1Var);
        n2 n2Var = this.binding;
        if (n2Var != null) {
            AppCompatImageButton onViewCreated$lambda$8$lambda$2 = n2Var.b;
            String strA = b().a();
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$2, "onViewCreated$lambda$8$lambda$2");
            mi.a(onViewCreated$lambda$8$lambda$2, strA, strA, null, false, null, 0, null, null, 252, null);
            a7.a(onViewCreated$lambda$8$lambda$2, a().j());
            onViewCreated$lambda$8$lambda$2.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(this.f$0, view2);
                }
            });
            HeaderView onViewCreated$lambda$8$lambda$3 = n2Var.g;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$3, "onViewCreated$lambda$8$lambda$3");
            u7 logoProvider = b().getLogoProvider();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            HeaderView.a(onViewCreated$lambda$8$lambda$3, logoProvider, viewLifecycleOwner, b().j(), null, 8, null);
            onViewCreated$lambda$8$lambda$3.a();
            TextView onViewCreated$lambda$8$lambda$4 = n2Var.p;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$4, "onViewCreated$lambda$8$lambda$4");
            zg.a(onViewCreated$lambda$8$lambda$4, a().i().n());
            onViewCreated$lambda$8$lambda$4.setText(b().h());
            TextView onViewCreated$lambda$8$lambda$5 = n2Var.m;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$5, "onViewCreated$lambda$8$lambda$5");
            zg.a(onViewCreated$lambda$8$lambda$5, a().i().c());
            onViewCreated$lambda$8$lambda$5.setText(b().b());
            onViewCreated$lambda$8$lambda$5.setVisibility(onViewCreated$lambda$8$lambda$5.length() > 0 ? 0 : 8);
            TextView onViewCreated$lambda$8$lambda$6 = n2Var.n;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$6, "onViewCreated$lambda$8$lambda$6");
            zg.a(onViewCreated$lambda$8$lambda$6, a().i().c());
            onViewCreated$lambda$8$lambda$6.setText(b().c());
            onViewCreated$lambda$8$lambda$6.setVisibility(onViewCreated$lambda$8$lambda$6.length() > 0 ? 0 : 8);
            List<String> listD = b().d();
            if (listD.isEmpty()) {
                LinearLayout root = n2Var.s.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.viewPurposeDetailIllustrations.root");
                root.setVisibility(8);
            } else {
                p5 p5Var = n2Var.s;
                p5Var.d.setText(b().e());
                TextView textPurposeIllustrationsHeader = p5Var.d;
                Intrinsics.checkNotNullExpressionValue(textPurposeIllustrationsHeader, "textPurposeIllustrationsHeader");
                zg.a(textPurposeIllustrationsHeader, a().i().c());
                p5Var.b.setText((CharSequence) CollectionsKt.first((List) listD));
                TextView textPurposeIllustration1 = p5Var.b;
                Intrinsics.checkNotNullExpressionValue(textPurposeIllustration1, "textPurposeIllustration1");
                zg.a(textPurposeIllustration1, a().i().c());
                if (listD.size() > 1) {
                    p5Var.c.setText(listD.get(1));
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
            Group group = n2Var.e;
            Intrinsics.checkNotNullExpressionValue(group, "binding.groupPurposeDetailConsent");
            group.setVisibility(8);
            Group group2 = n2Var.f;
            Intrinsics.checkNotNullExpressionValue(group2, "binding.groupPurposeDetailLegitimateInterest");
            group2.setVisibility(8);
            View view2 = n2Var.q;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewPurposeDetailBottomDivider");
            view2.setVisibility(8);
            PurposeSaveView purposeSaveView = n2Var.h;
            Intrinsics.checkNotNullExpressionValue(purposeSaveView, "binding.savePurposeDetail");
            purposeSaveView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(c this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }
}

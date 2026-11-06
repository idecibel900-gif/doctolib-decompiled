package io.didomi.ssl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import io.didomi.ssl.models.DeviceStorageDisclosure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0007\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u0006\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010$¨\u0006("}, d2 = {"Lio/didomi/sdk/ob;", "Landroidx/fragment/app/Fragment;", "", "c", "Lio/didomi/sdk/models/DeviceStorageDisclosure;", "disclosure", "b", "a", "e", "d", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "Lio/didomi/sdk/a2;", "Lio/didomi/sdk/a2;", "()Lio/didomi/sdk/a2;", "setModel", "(Lio/didomi/sdk/a2;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/r2;", "Lio/didomi/sdk/r2;", "binding", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ob extends Fragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public a2 model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private r2 binding;

    private final void c() {
        TextView textView;
        r2 r2Var = this.binding;
        if (r2Var == null || (textView = r2Var.k) == null) {
            return;
        }
        zg.a(textView, b().i().n());
        textView.setText(a().d());
    }

    private final void d(DeviceStorageDisclosure disclosure) {
        r2 r2Var = this.binding;
        if (r2Var != null) {
            String strD = a().d(disclosure);
            if (strD == null) {
                TextView textView = r2Var.h;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.disclosureNameTitle");
                textView.setVisibility(8);
                TextView textView2 = r2Var.g;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.disclosureName");
                textView2.setVisibility(8);
                return;
            }
            TextView setupTitle$lambda$17$lambda$15 = r2Var.h;
            Intrinsics.checkNotNullExpressionValue(setupTitle$lambda$17$lambda$15, "setupTitle$lambda$17$lambda$15");
            zg.a(setupTitle$lambda$17$lambda$15, b().i().n());
            setupTitle$lambda$17$lambda$15.setText(a().i());
            TextView setupTitle$lambda$17$lambda$16 = r2Var.g;
            Intrinsics.checkNotNullExpressionValue(setupTitle$lambda$17$lambda$16, "setupTitle$lambda$17$lambda$16");
            zg.a(setupTitle$lambda$17$lambda$16, b().i().c());
            setupTitle$lambda$17$lambda$16.setText(strD);
        }
    }

    private final void e(DeviceStorageDisclosure disclosure) {
        r2 r2Var = this.binding;
        if (r2Var != null) {
            String strG = a().g(disclosure);
            if (strG == null) {
                TextView textView = r2Var.m;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.disclosureTypeTitle");
                textView.setVisibility(8);
                TextView textView2 = r2Var.l;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.disclosureType");
                textView2.setVisibility(8);
                return;
            }
            TextView setupType$lambda$14$lambda$12 = r2Var.m;
            Intrinsics.checkNotNullExpressionValue(setupType$lambda$14$lambda$12, "setupType$lambda$14$lambda$12");
            zg.a(setupType$lambda$14$lambda$12, b().i().n());
            setupType$lambda$14$lambda$12.setText(a().p());
            TextView setupType$lambda$14$lambda$13 = r2Var.l;
            Intrinsics.checkNotNullExpressionValue(setupType$lambda$14$lambda$13, "setupType$lambda$14$lambda$13");
            zg.a(setupType$lambda$14$lambda$13, b().i().c());
            setupType$lambda$14$lambda$13.setText(strG);
        }
    }

    public final a2 a() {
        a2 a2Var = this.model;
        if (a2Var != null) {
            return a2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    public final ah b() {
        ah ahVar = this.themeProvider;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("themeProvider");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        r2 r2VarA = r2.a(inflater, container, false);
        this.binding = r2VarA;
        ScrollView root = r2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DeviceStorageDisclosure selectedDisclosure = a().getSelectedDisclosure();
        if (selectedDisclosure != null) {
            c();
            d(selectedDisclosure);
            e(selectedDisclosure);
            a(selectedDisclosure);
            b(selectedDisclosure);
            c(selectedDisclosure);
        }
    }

    private final void a(DeviceStorageDisclosure disclosure) {
        r2 r2Var = this.binding;
        if (r2Var != null) {
            String strB = a().b(disclosure);
            if (strB == null) {
                TextView textView = r2Var.d;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.disclosureDomainTitle");
                textView.setVisibility(8);
                TextView textView2 = r2Var.c;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.disclosureDomain");
                textView2.setVisibility(8);
                return;
            }
            TextView setupDomain$lambda$11$lambda$9 = r2Var.d;
            Intrinsics.checkNotNullExpressionValue(setupDomain$lambda$11$lambda$9, "setupDomain$lambda$11$lambda$9");
            zg.a(setupDomain$lambda$11$lambda$9, b().i().n());
            setupDomain$lambda$11$lambda$9.setText(a().f());
            TextView setupDomain$lambda$11$lambda$10 = r2Var.c;
            Intrinsics.checkNotNullExpressionValue(setupDomain$lambda$11$lambda$10, "setupDomain$lambda$11$lambda$10");
            zg.a(setupDomain$lambda$11$lambda$10, b().i().c());
            setupDomain$lambda$11$lambda$10.setText(strB);
        }
    }

    private final void b(DeviceStorageDisclosure disclosure) {
        r2 r2Var = this.binding;
        if (r2Var != null) {
            String strC = a().c(disclosure);
            if (strC == null) {
                TextView textView = r2Var.f;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.disclosureExpirationTitle");
                textView.setVisibility(8);
                TextView textView2 = r2Var.e;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.disclosureExpiration");
                textView2.setVisibility(8);
                return;
            }
            TextView setupExpiration$lambda$8$lambda$6 = r2Var.f;
            Intrinsics.checkNotNullExpressionValue(setupExpiration$lambda$8$lambda$6, "setupExpiration$lambda$8$lambda$6");
            zg.a(setupExpiration$lambda$8$lambda$6, b().i().n());
            setupExpiration$lambda$8$lambda$6.setText(a().g());
            TextView setupExpiration$lambda$8$lambda$7 = r2Var.e;
            Intrinsics.checkNotNullExpressionValue(setupExpiration$lambda$8$lambda$7, "setupExpiration$lambda$8$lambda$7");
            zg.a(setupExpiration$lambda$8$lambda$7, b().i().c());
            setupExpiration$lambda$8$lambda$7.setText(strC);
        }
    }

    private final void c(DeviceStorageDisclosure disclosure) {
        r2 r2Var = this.binding;
        if (r2Var != null) {
            String strF = a().f(disclosure);
            if (strF.length() > 0) {
                TextView setupPurposes$lambda$5$lambda$3 = r2Var.j;
                Intrinsics.checkNotNullExpressionValue(setupPurposes$lambda$5$lambda$3, "setupPurposes$lambda$5$lambda$3");
                zg.a(setupPurposes$lambda$5$lambda$3, b().i().n());
                setupPurposes$lambda$5$lambda$3.setText(a().l());
                TextView setupPurposes$lambda$5$lambda$4 = r2Var.i;
                Intrinsics.checkNotNullExpressionValue(setupPurposes$lambda$5$lambda$4, "setupPurposes$lambda$5$lambda$4");
                zg.a(setupPurposes$lambda$5$lambda$4, b().i().c());
                setupPurposes$lambda$5$lambda$4.setText(strF);
                return;
            }
            TextView textView = r2Var.j;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.disclosurePurposesTitle");
            textView.setVisibility(8);
            TextView textView2 = r2Var.i;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.disclosurePurposes");
            textView2.setVisibility(8);
        }
    }
}

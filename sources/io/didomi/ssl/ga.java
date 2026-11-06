package io.didomi.ssl;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0014\u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\u001f\u0010(\"\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lio/didomi/sdk/ga;", "Lio/didomi/sdk/g2;", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "onDestroyView", "Lio/didomi/sdk/v8;", "a", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/ja;", "b", "Lio/didomi/sdk/ja;", "()Lio/didomi/sdk/ja;", "setModel", "(Lio/didomi/sdk/ja;)V", "model", "Lio/didomi/sdk/ah;", "c", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/eh;", "d", "Lio/didomi/sdk/eh;", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/o2;", "e", "Lio/didomi/sdk/o2;", "binding", "<init>", "()V", "f", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ga extends g2 {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public ja model;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private o2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.ga$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/ga$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/didomi/sdk/Purpose;", "purpose", "Lio/didomi/sdk/gi;", "infoType", "", "a", "", "KEY_CATEGORY", "Ljava/lang/String;", "KEY_INFO_TYPE", "KEY_PURPOSE", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, Purpose purpose, gi infoType) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(purpose, "purpose");
            Intrinsics.checkNotNullParameter(infoType, "infoType");
            if (fragmentManager.findFragmentByTag("PurposeVendorsFragment") != null) {
                Log.w$default("Fragment with tag 'PurposeVendorsFragment' is already present", null, 2, null);
                return;
            }
            ga gaVar = new ga();
            Bundle bundle = new Bundle();
            bundle.putParcelable("purpose", purpose);
            bundle.putInt("info_type", infoType.ordinal());
            gaVar.setArguments(bundle);
            gaVar.show(fragmentManager, "PurposeVendorsFragment");
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

    public final ja b() {
        ja jaVar = this.model;
        if (jaVar != null) {
            return jaVar;
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
        o2 o2VarA = o2.a(inflater, container, false);
        this.binding = o2VarA;
        ConstraintLayout root = o2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.dismissHelper.a();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.dismissHelper.a(this, c());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        PurposeCategory purposeCategory;
        Purpose purpose;
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i2 = Build.VERSION.SDK_INT;
        gi giVar = null;
        if (i2 >= 33) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                purposeCategory = (PurposeCategory) arguments.getParcelable("category", PurposeCategory.class);
            } else {
                purposeCategory = null;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                purposeCategory = (PurposeCategory) arguments2.getParcelable("category");
            } else {
                purposeCategory = null;
            }
        }
        if (purposeCategory != null) {
            b().a(purposeCategory);
        } else {
            if (i2 >= 33) {
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    purpose = (Purpose) arguments3.getParcelable("purpose", Purpose.class);
                } else {
                    purpose = null;
                }
            } else {
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    purpose = (Purpose) arguments4.getParcelable("purpose");
                } else {
                    purpose = null;
                }
            }
            Bundle arguments5 = getArguments();
            if (arguments5 != null && (i = arguments5.getInt("info_type")) < gi.values().length) {
                giVar = gi.values()[i];
            }
            if (purpose == null || giVar == null) {
                dismiss();
                return;
            }
            b().a(purpose, giVar);
        }
        o2 o2Var = this.binding;
        if (o2Var != null) {
            AppCompatImageButton onViewCreated$lambda$8$lambda$3 = o2Var.b;
            String strA = b().a();
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$3, "onViewCreated$lambda$8$lambda$3");
            mi.a(onViewCreated$lambda$8$lambda$3, strA, strA, null, false, null, 0, null, null, 252, null);
            a7.a(onViewCreated$lambda$8$lambda$3, a().j());
            onViewCreated$lambda$8$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.ga$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ga.a(this.f$0, view2);
                }
            });
            TextView onViewCreated$lambda$8$lambda$4 = o2Var.f;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$4, "onViewCreated$lambda$8$lambda$4");
            zg.a(onViewCreated$lambda$8$lambda$4, a().i().n());
            onViewCreated$lambda$8$lambda$4.setText(b().g());
            TextView onViewCreated$lambda$8$lambda$5 = o2Var.d;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$5, "onViewCreated$lambda$8$lambda$5");
            zg.a(onViewCreated$lambda$8$lambda$5, a().i().s());
            onViewCreated$lambda$8$lambda$5.setText(b().d());
            CharSequence text = onViewCreated$lambda$8$lambda$5.getText();
            onViewCreated$lambda$8$lambda$5.setVisibility((text == null || StringsKt.isBlank(text)) ? 8 : 0);
            TextView onViewCreated$lambda$8$lambda$6 = o2Var.c;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$8$lambda$6, "onViewCreated$lambda$8$lambda$6");
            zg.a(onViewCreated$lambda$8$lambda$6, a().i().s());
            onViewCreated$lambda$8$lambda$6.setText(b().b());
            CharSequence text2 = onViewCreated$lambda$8$lambda$6.getText();
            if (text2 == null || StringsKt.isBlank(text2)) {
                onViewCreated$lambda$8$lambda$6.setVisibility(8);
            } else {
                TextView textView = o2Var.d;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.buttonPurposeVendorsNonIabCount");
                if (textView.getVisibility() == 0) {
                    ViewGroup.LayoutParams layoutParams = onViewCreated$lambda$8$lambda$6.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    layoutParams2.setMarginStart(onViewCreated$lambda$8$lambda$6.getResources().getDimensionPixelSize(R.dimen.didomi_notice_padding_horizontal));
                    onViewCreated$lambda$8$lambda$6.setLayoutParams(layoutParams2);
                }
                onViewCreated$lambda$8$lambda$6.setVisibility(0);
            }
            RecyclerView recyclerView = o2Var.e;
            recyclerView.setAdapter(new fa(b().h(), a()));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(R.dimen.didomi_content_max_width);
            int i3 = recyclerView.getResources().getDisplayMetrics().widthPixels;
            if (i3 > dimensionPixelSize) {
                int i4 = (i3 - dimensionPixelSize) / 2;
                recyclerView.setPadding(i4, 0, i4, recyclerView.getResources().getDimensionPixelSize(R.dimen.didomi_purpose_list_padding_bottom));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ga this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }
}

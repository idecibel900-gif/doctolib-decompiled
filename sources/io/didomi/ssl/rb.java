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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import io.didomi.ssl.purpose.mobile.PurposeSaveView;
import io.didomi.ssl.view.mobile.DidomiToggle;
import io.didomi.ssl.view.mobile.HeaderView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 82\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010$R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0004\u0010'\u001a\u0004\b \u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020,8\u0016@\u0016X\u0097.¢\u0006\u0012\n\u0004\b\u0003\u0010-\u001a\u0004\b\u001a\u0010.\"\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00069"}, d2 = {"Lio/didomi/sdk/rb;", "Lio/didomi/sdk/g2;", "", "e", "d", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "Landroid/content/DialogInterface;", "dialog", "onCancel", "dismiss", "onDestroyView", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "a", "Lkotlin/Lazy;", "c", "()Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "selectedCategory", "Lio/didomi/sdk/v8;", "b", "Lio/didomi/sdk/v8;", "dismissHelper", "Lio/didomi/sdk/qb$a;", "Lio/didomi/sdk/qb$a;", "personalDataCallback", "Lio/didomi/sdk/ac;", "Lio/didomi/sdk/ac;", "()Lio/didomi/sdk/ac;", "setModel", "(Lio/didomi/sdk/ac;)V", "model", "Lio/didomi/sdk/ah;", "Lio/didomi/sdk/ah;", "()Lio/didomi/sdk/ah;", "setThemeProvider", "(Lio/didomi/sdk/ah;)V", "themeProvider", "Lio/didomi/sdk/t2;", "f", "Lio/didomi/sdk/t2;", "binding", "<init>", "()V", "g", "android_release"}, k = 1, mv = {1, 8, 0})
public final class rb extends g2 {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Lazy selectedCategory = LazyKt.lazy(new c());

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final v8 dismissHelper = new v8();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final qb.a personalDataCallback = new b();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public ac model;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public ah themeProvider;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private t2 binding;

    /* JADX INFO: renamed from: io.didomi.sdk.rb$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lio/didomi/sdk/rb$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "category", "", "a", "", "PURPOSE_CATEGORY", "Ljava/lang/String;", "TAG", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, PurposeCategory category) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(category, "category");
            if (fragmentManager.findFragmentByTag("SensitivePersonalInfoCategoryFragment") != null) {
                Log.w$default("Fragment with tag 'SensitivePersonalInfoCategoryFragment' is already present", null, 2, null);
                return;
            }
            rb rbVar = new rb();
            Bundle bundle = new Bundle();
            bundle.putParcelable("purpose_category", category);
            rbVar.setArguments(bundle);
            rbVar.show(fragmentManager, "SensitivePersonalInfoCategoryFragment");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "a", "()Lio/didomi/sdk/purpose/common/model/PurposeCategory;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0 {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PurposeCategory invoke() {
            if (Build.VERSION.SDK_INT >= 33) {
                Bundle arguments = rb.this.getArguments();
                if (arguments != null) {
                    return (PurposeCategory) arguments.getParcelable("purpose_category", PurposeCategory.class);
                }
                return null;
            }
            Bundle arguments2 = rb.this.getArguments();
            if (arguments2 != null) {
                return (PurposeCategory) arguments2.getParcelable("purpose_category");
            }
            return null;
        }
    }

    private final PurposeCategory c() {
        return (PurposeCategory) this.selectedCategory.getValue();
    }

    private final void d() {
        b().t();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
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
        d();
        super.onCancel(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        t2 t2VarA = t2.a(inflater, container, false);
        this.binding = t2VarA;
        ConstraintLayout root = t2VarA.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…g = it\n            }.root");
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        super.onDestroyView();
        u7 logoProvider = b().getLogoProvider();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        logoProvider.a(viewLifecycleOwner);
        t2 t2Var = this.binding;
        if (t2Var != null && (recyclerView = t2Var.d) != null) {
            recyclerView.setAdapter(null);
            recyclerView.setLayoutManager(null);
        }
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
        this.dismissHelper.a(this, b().getUiProvider());
    }

    @Override // io.didomi.ssl.g2, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) throws Throwable {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final PurposeCategory purposeCategoryC = c();
        if (purposeCategoryC == null) {
            throw new Throwable("Category is invalid");
        }
        b().j(purposeCategoryC);
        t2 t2Var = this.binding;
        if (t2Var != null) {
            AppCompatImageButton onViewCreated$lambda$9$lambda$2 = t2Var.b;
            String strD = b().d();
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$9$lambda$2, "onViewCreated$lambda$9$lambda$2");
            mi.a(onViewCreated$lambda$9$lambda$2, strD, strD, null, false, null, 0, null, null, 252, null);
            a7.a(onViewCreated$lambda$9$lambda$2, a().j());
            onViewCreated$lambda$9$lambda$2.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.rb$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    rb.a(this.f$0, view2);
                }
            });
            HeaderView onViewCreated$lambda$9$lambda$3 = t2Var.c;
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$9$lambda$3, "onViewCreated$lambda$9$lambda$3");
            HeaderView.a(onViewCreated$lambda$9$lambda$3, b().e(purposeCategoryC), null, 0, 6, null);
            onViewCreated$lambda$9$lambda$3.a();
            List<o8> listA = b().a(purposeCategoryC);
            RecyclerView onViewCreated$lambda$9$lambda$4 = t2Var.d;
            onViewCreated$lambda$9$lambda$4.setAdapter(new qb(listA, a(), this.personalDataCallback));
            onViewCreated$lambda$9$lambda$4.setLayoutManager(new LinearLayoutManager(onViewCreated$lambda$9$lambda$4.getContext(), 1, false));
            Context context = onViewCreated$lambda$9$lambda$4.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            onViewCreated$lambda$9$lambda$4.addItemDecoration(new aa(context, a(), false, 4, null));
            Intrinsics.checkNotNullExpressionValue(onViewCreated$lambda$9$lambda$4, "onViewCreated$lambda$9$lambda$4");
            ya.a(onViewCreated$lambda$9$lambda$4, q7.a(listA, PersonalDataDisplayItem.class));
            HeaderView headerView = t2Var.c;
            Intrinsics.checkNotNullExpressionValue(headerView, "binding.headerSpiCategory");
            ya.a(onViewCreated$lambda$9$lambda$4, headerView);
            PurposeSaveView purposeSaveView = t2Var.e;
            final Button saveButton$android_release = purposeSaveView.getSaveButton$android_release();
            if (saveButton$android_release != null) {
                zg.a(saveButton$android_release, a().i().j());
                saveButton$android_release.setText(b().l());
                saveButton$android_release.setOnClickListener(new View.OnClickListener() { // from class: io.didomi.sdk.rb$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        rb.a(this.f$0, purposeCategoryC, saveButton$android_release, view2);
                    }
                });
            }
            ImageView logoImage$android_release = purposeSaveView.getLogoImage$android_release();
            if (logoImage$android_release != null) {
                logoImage$android_release.setVisibility(b().a(false) ? 4 : 0);
            }
            View view2 = t2Var.f;
            Intrinsics.checkNotNullExpressionValue(view2, "binding.viewSpiCategoryBottomDivider");
            ni.a(view2, a());
        }
        b().u();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(rb this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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

    public final ac b() {
        ac acVar = this.model;
        if (acVar != null) {
            return acVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("model");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(rb this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final rb this$0, PurposeCategory selectedCategory, Button this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedCategory, "$selectedCategory");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.b().i(selectedCategory);
        this_apply.post(new Runnable() { // from class: io.didomi.sdk.rb$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                rb.c(this.f$0);
            }
        });
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"io/didomi/sdk/rb$b", "Lio/didomi/sdk/qb$a;", "Lio/didomi/sdk/o8$a;", "type", "", DiagnosticsEntry.ID_KEY, "Lio/didomi/sdk/view/mobile/DidomiToggle$b;", "state", "", "a", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements qb.a {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[o8.a.values().length];
                try {
                    iArr[o8.a.Category.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                a = iArr;
            }
        }

        b() {
        }

        @Override // io.didomi.sdk.qb.a
        public void a(o8.a type, String id, DidomiToggle.b state) {
            RecyclerView recyclerView;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Purpose purposeB = rb.this.b().b(id);
            if (purposeB != null) {
                rb rbVar = rb.this;
                if (type == o8.a.PersonalData) {
                    rbVar.b().a(purposeB, state);
                    t2 t2Var = rbVar.binding;
                    RecyclerView.Adapter adapter = (t2Var == null || (recyclerView = t2Var.d) == null) ? null : recyclerView.getAdapter();
                    qb qbVar = adapter instanceof qb ? (qb) adapter : null;
                    if (qbVar != null) {
                        qbVar.b(id, state, true);
                    }
                }
            }
            rb.this.e();
        }

        @Override // io.didomi.sdk.qb.a
        public void a(o8.a type, String id) throws Throwable {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            if (a.a[type.ordinal()] == 1) {
                PurposeCategory purposeCategoryA = rb.this.b().a(id);
                if (purposeCategoryA == null) {
                    return;
                }
                Companion companion = rb.INSTANCE;
                FragmentManager parentFragmentManager = rb.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.a(parentFragmentManager, purposeCategoryA);
                return;
            }
            throw new Throwable("Invalid type (" + type + ')');
        }
    }
}

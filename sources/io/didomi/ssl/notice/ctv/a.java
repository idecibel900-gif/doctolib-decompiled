package io.didomi.ssl.notice.ctv;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import io.didomi.ssl.AppConfiguration;
import io.didomi.ssl.Didomi;
import io.didomi.ssl.R;
import io.didomi.ssl.a8;
import io.didomi.ssl.c6;
import io.didomi.ssl.eh;
import io.didomi.ssl.fc;
import io.didomi.ssl.ic;
import io.didomi.ssl.ni;
import io.didomi.ssl.q0;
import io.didomi.ssl.u2;
import io.didomi.ssl.u7;
import io.didomi.ssl.uc;
import io.didomi.ssl.wg;
import io.didomi.ssl.z6;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 D2\u00020\u0001:\u0002\f\tB\u0007¢\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016R\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010!\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00102\u001a\u00020-8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010.\u001a\u0004\b\t\u0010/\"\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010:R\u0014\u0010=\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010:R\u0014\u0010?\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010:R\u0014\u0010A\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010:¨\u0006E"}, d2 = {"Lio/didomi/sdk/notice/ctv/a;", "Landroidx/fragment/app/DialogFragment;", "", "h", "e", "d", "f", "", "noticeText", "b", "g", "partnersLabel", "a", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onResume", "onPause", "dismiss", "onDestroyView", "Lio/didomi/sdk/uc;", "Lio/didomi/sdk/uc;", "()Lio/didomi/sdk/uc;", "setModel", "(Lio/didomi/sdk/uc;)V", "model", "Lio/didomi/sdk/eh;", "Lio/didomi/sdk/eh;", "c", "()Lio/didomi/sdk/eh;", "setUiProvider", "(Lio/didomi/sdk/eh;)V", "uiProvider", "Lio/didomi/sdk/a8;", "Lio/didomi/sdk/a8;", "()Lio/didomi/sdk/a8;", "setNavigationManager", "(Lio/didomi/sdk/a8;)V", "navigationManager", "Lio/didomi/sdk/u2;", "Lio/didomi/sdk/u2;", "binding", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "job", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "agreeButtonListener", "disagreeButtonListener", "manageButtonListener", "i", "privacyButtonListener", "j", "partnersButtonListener", "<init>", "()V", "k", "android_release"}, k = 1, mv = {1, 8, 0})
public final class a extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public uc model;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public eh uiProvider;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public a8 navigationManager;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private u2 binding;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private Job job;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final View.OnClickListener agreeButtonListener = new View.OnClickListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.a(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final View.OnClickListener disagreeButtonListener = new View.OnClickListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.b(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final View.OnClickListener manageButtonListener = new View.OnClickListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda2
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.c(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final View.OnClickListener privacyButtonListener = new View.OnClickListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda3
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.e(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final View.OnClickListener partnersButtonListener = new View.OnClickListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda4
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.d(this.f$0, view);
        }
    };

    /* JADX INFO: renamed from: io.didomi.sdk.notice.ctv.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lio/didomi/sdk/notice/ctv/a$a;", "", "", "a", "b", "android_release"}, k = 1, mv = {1, 8, 0})
    public interface InterfaceC0153a {
        void a();

        void b();
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Z)V"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function1 {
        c() {
            super(1);
        }

        public final void a(boolean z) {
            if (z) {
                return;
            }
            a.this.dismiss();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a().D();
        this$0.b().a(this$0.getActivity(), ic.Vendors);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a().I();
        KeyEventDispatcher.Component activity = this$0.getActivity();
        InterfaceC0153a interfaceC0153a = activity instanceof InterfaceC0153a ? (InterfaceC0153a) activity : null;
        if (interfaceC0153a != null) {
            interfaceC0153a.a();
        }
    }

    private final void f() {
        Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.d) == null) {
            return;
        }
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(button, i, 0, i, 0, 10, null);
        button.setOnClickListener(this.manageButtonListener);
        button.setText(a().l());
    }

    private final void g() {
        Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.f) == null) {
            return;
        }
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(button, i, 0, i, 0, 10, null);
        button.setOnClickListener(this.privacyButtonListener);
        button.setText(a().u());
    }

    private final void h() {
        final Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.g) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            button.setFocusedByDefault(true);
        }
        button.post(new Runnable() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                a.a(button);
            }
        });
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(button, i, 0, i, 0, 10, null);
        button.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.didomi.sdk.notice.ctv.a$$ExternalSyntheticLambda6
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                a.a(view, z);
            }
        });
        button.setText(a().G());
    }

    public final uc a() {
        uc ucVar = this.model;
        if (ucVar != null) {
            return ucVar;
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

    public final eh c() {
        eh ehVar = this.uiProvider;
        if (ehVar != null) {
            return ehVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiProvider");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        KeyEventDispatcher.Component activity = getActivity();
        InterfaceC0153a interfaceC0153a = activity instanceof InterfaceC0153a ? (InterfaceC0153a) activity : null;
        if (interfaceC0153a != null) {
            interfaceC0153a.b();
        }
        a().H();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Didomi.INSTANCE.getInstance().getComponent$android_release().a(this);
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext(), R.style.Didomi_Theme_TVDialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        u2 u2VarA = u2.a(inflater, parent, false);
        this.binding = u2VarA;
        ConstraintLayout root = u2VarA.getRoot();
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
        this.binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.job = c6.a(this, c().e(), new c());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        h();
        e();
        d();
        f();
        g();
        q0.NoticeAndPartnersProperties noticeAndPartnersPropertiesR = a().r();
        b(noticeAndPartnersPropertiesR.getNoticeText());
        a(noticeAndPartnersPropertiesR.getPartnersButtonText());
        u2 u2Var = this.binding;
        if (u2Var == null || (imageView = u2Var.h) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        z6.a(imageView, viewLifecycleOwner, a().getLogoProvider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a().A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a().B();
        a8.a(this$0.b(), this$0.getActivity(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Button this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.requestFocus();
    }

    private final void b(String noticeText) {
        TextView textView;
        u2 u2Var = this.binding;
        if (u2Var == null || (textView = u2Var.i) == null) {
            return;
        }
        textView.setMaxHeight(textView.getResources().getDisplayMetrics().heightPixels - ((int) (300 * textView.getResources().getDisplayMetrics().scaledDensity)));
        textView.setText(wg.a.a(StringsKt.trim(fc.h(noticeText)).toString()));
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, 3, 14, 1, 2);
    }

    private final void d() {
        Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.b) == null) {
            return;
        }
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(button, i, 0, i, 0, 10, null);
        button.setOnClickListener(this.agreeButtonListener);
        button.setText(a().b());
    }

    private final void e() {
        Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.c) == null) {
            return;
        }
        if (a().e() != AppConfiguration.Theme.a.NONE) {
            button.setOnClickListener(this.disagreeButtonListener);
            int dimensionPixelSize = button.getResources().getDimensionPixelSize(R.dimen.didomi_tv_button_padding);
            button.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
            button.setText(a().b(false));
            button.setVisibility(0);
            return;
        }
        button.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view, boolean z) {
        if (z) {
            return;
        }
        view.setEnabled(false);
    }

    private final void a(String partnersLabel) {
        Button button;
        u2 u2Var = this.binding;
        if (u2Var == null || (button = u2Var.e) == null) {
            return;
        }
        int i = R.dimen.didomi_tv_button_padding;
        ni.a(button, i, 0, i, 0, 10, null);
        button.setOnClickListener(this.partnersButtonListener);
        button.setText(partnersLabel);
    }
}

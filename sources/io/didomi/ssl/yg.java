package io.didomi.ssl;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0007*\u00020\u0000H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¨\u0006\n"}, d2 = {"Landroid/widget/TextView;", "Lio/didomi/sdk/k7;", "parameters", "", "a", "", "isFontFamilyCustomized", "", "", "b", "android_release"}, k = 2, mv = {1, 8, 0})
public final class yg {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"io/didomi/sdk/yg$a", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements View.OnLayoutChangeListener {
        final /* synthetic */ TextView a;
        final /* synthetic */ boolean b;

        public a(TextView textView, boolean z) {
            this.a = textView;
            this.b = z;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            JustificationParameters justificationParametersA = yg.a(this.a, this.b);
            if (justificationParametersA == null) {
                return;
            }
            Log.d$default("shrunkContent:\n" + justificationParametersA.getShrunkContent(), null, 2, null);
            this.a.setText(justificationParametersA.getShrunkContent());
            TextView textView = this.a;
            textView.post(new b(textView, justificationParametersA));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b implements Runnable {
        final /* synthetic */ TextView a;
        final /* synthetic */ JustificationParameters b;

        b(TextView textView, JustificationParameters justificationParameters) {
            this.a = textView;
            this.b = justificationParameters;
        }

        @Override // java.lang.Runnable
        public final void run() {
            yg.a(this.a, this.b);
            TextView textView = this.a;
            textView.setLineSpacing(textView.getLineSpacingExtra(), this.a.getLineSpacingMultiplier() - 0.06f);
        }
    }

    public static final void a(TextView textView, JustificationParameters parameters) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(parameters.getOriginalContent());
        int iA = parameters.getIsFontFamilyCustomized() ? a(textView) - 3 : a(textView);
        for (JustificationParameters.LineInfo lineInfo : parameters.a()) {
            int iMax = Math.max(1, (int) Math.floor((iA - textView.getLayout().getLineWidth(lineInfo.getLineIndex())) / (lineInfo.b().size() - 1)));
            Log.d$default("Space for line #" + lineInfo.getLineIndex() + ": " + iMax, null, 2, null);
            int i = 0;
            ColorDrawable colorDrawable = new ColorDrawable(0);
            colorDrawable.setBounds(0, 0, iMax, 1);
            for (Object obj : lineInfo.b()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int iIntValue = ((Number) obj).intValue();
                if (i == CollectionsKt.getLastIndex(lineInfo.b())) {
                    spannableStringBuilder = spannableStringBuilder.replace(iIntValue, iIntValue + 1, (CharSequence) "\n");
                    Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "finalContent.replace(spa…ex, spaceIndex + 1, \"\\n\")");
                } else {
                    spannableStringBuilder.setSpan(Build.VERSION.SDK_INT >= 29 ? new ImageSpan(colorDrawable, 2) : new ImageSpan(colorDrawable), iIntValue, iIntValue + 1, 18);
                }
                i = i2;
            }
        }
        textView.setText(spannableStringBuilder);
    }

    public static final void b(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.addOnLayoutChangeListener(new a(textView, z));
    }

    public static final JustificationParameters a(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        CharSequence text = textView.getText();
        if (text == null || StringsKt.isBlank(text) || textView.getLineCount() == 1) {
            return null;
        }
        CharSequence text2 = textView.getText();
        Spanned spanned = text2 instanceof Spanned ? (Spanned) text2 : null;
        if (spanned == null) {
            return null;
        }
        int iA = a(textView);
        ArrayList arrayList = new ArrayList();
        int lineCount = textView.getLineCount();
        String str = "";
        for (int i = 0; i < lineCount; i++) {
            float lineWidth = textView.getLayout().getLineWidth(i);
            int lineStart = textView.getLayout().getLineStart(i);
            CharSequence charSequenceSubSequence = spanned.subSequence(lineStart, textView.getLayout().getLineEnd(i));
            if (i < textView.getLineCount() - 1 && !StringsKt.endsWith$default(charSequenceSubSequence, (CharSequence) "\n", false, 2, (Object) null) && !a(charSequenceSubSequence) && lineWidth < iA) {
                Log.d$default("line #" + i + " is large enough", null, 2, null);
                ArrayList arrayList2 = new ArrayList();
                for (int iIndexOf$default = StringsKt.indexOf$default(charSequenceSubSequence, " ", 0, false, 6, (Object) null); iIndexOf$default >= 0; iIndexOf$default = StringsKt.indexOf$default(charSequenceSubSequence, " ", iIndexOf$default + 1, false, 4, (Object) null)) {
                    arrayList2.add(Integer.valueOf(lineStart + iIndexOf$default));
                }
                JustificationParameters.LineInfo lineInfo = new JustificationParameters.LineInfo(i, arrayList2);
                arrayList.add(lineInfo);
                Log.d$default("lineInfo: " + lineInfo, null, 2, null);
                str = str + CollectionsKt.joinToString$default(new Regex("\\s+").split(StringsKt.trim(charSequenceSubSequence), 0), "", null, "\n", 0, null, null, 58, null);
            } else {
                Log.d$default("line #" + i + " is not large enough or the last one", null, 2, null);
                str = str + ((Object) StringsKt.trim(charSequenceSubSequence)) + '\n';
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new JustificationParameters(arrayList, spanned, str, z);
    }

    public static final int a(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return (textView.getMeasuredWidth() - textView.getPaddingEnd()) - textView.getPaddingStart();
    }

    public static final boolean a(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new Regex("^(•|\\d+\\.)\\s.+").matches(charSequence);
    }
}

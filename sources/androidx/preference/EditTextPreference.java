package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    private String mText;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EditTextPreference, i, i2);
        int i3 = R$styleable.EditTextPreference_useSimpleSummaryProvider;
        if (TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i3, i3, false)) {
            setSummaryProvider(SimpleSummaryProvider.getInstance());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R$attr.editTextPreferenceStyle, R.attr.editTextPreferenceStyle));
    }

    public String getText() {
        return this.mText;
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public boolean shouldDisableDependents() {
        return TextUtils.isEmpty(this.mText) || super.shouldDisableDependents();
    }

    public static final class SimpleSummaryProvider implements Preference.SummaryProvider {
        private static SimpleSummaryProvider sSimpleSummaryProvider;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider getInstance() {
            if (sSimpleSummaryProvider == null) {
                sSimpleSummaryProvider = new SimpleSummaryProvider();
            }
            return sSimpleSummaryProvider;
        }

        @Override // androidx.preference.Preference.SummaryProvider
        public CharSequence provideSummary(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.getText())) {
                return editTextPreference.getContext().getString(R$string.not_set);
            }
            return editTextPreference.getText();
        }
    }
}

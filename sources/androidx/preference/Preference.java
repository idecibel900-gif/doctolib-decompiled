package androidx.preference;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.TypedArrayUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private final View.OnClickListener mClickListener;
    private final Context mContext;
    private boolean mCopyingEnabled;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List mDependents;
    private boolean mEnabled;
    private String mFragment;
    private boolean mHasSingleLineTitleAttr;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private int mOrder;
    private boolean mParentDependencyMet;
    private boolean mPersistent;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private SummaryProvider mSummaryProvider;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private int mWidgetLayoutResId;

    public interface SummaryProvider {
        CharSequence provideSummary(Preference preference);
    }

    public boolean callChangeListener(Object obj) {
        return true;
    }

    public PreferenceDataStore getPreferenceDataStore() {
        return null;
    }

    public PreferenceManager getPreferenceManager() {
        return null;
    }

    protected void notifyChanged() {
    }

    protected void onClick() {
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return null;
    }

    protected boolean shouldPersist() {
        return false;
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = R$layout.preference;
        this.mClickListener = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Preference.this.performClick(view);
            }
        };
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, i2);
        this.mIconResId = TypedArrayUtils.getResourceId(typedArrayObtainStyledAttributes, R$styleable.Preference_icon, R$styleable.Preference_android_icon, 0);
        this.mKey = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R$styleable.Preference_key, R$styleable.Preference_android_key);
        this.mTitle = TypedArrayUtils.getText(typedArrayObtainStyledAttributes, R$styleable.Preference_title, R$styleable.Preference_android_title);
        this.mSummary = TypedArrayUtils.getText(typedArrayObtainStyledAttributes, R$styleable.Preference_summary, R$styleable.Preference_android_summary);
        this.mOrder = TypedArrayUtils.getInt(typedArrayObtainStyledAttributes, R$styleable.Preference_order, R$styleable.Preference_android_order, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R$styleable.Preference_fragment, R$styleable.Preference_android_fragment);
        this.mLayoutResId = TypedArrayUtils.getResourceId(typedArrayObtainStyledAttributes, R$styleable.Preference_layout, R$styleable.Preference_android_layout, R$layout.preference);
        this.mWidgetLayoutResId = TypedArrayUtils.getResourceId(typedArrayObtainStyledAttributes, R$styleable.Preference_widgetLayout, R$styleable.Preference_android_widgetLayout, 0);
        this.mEnabled = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_enabled, R$styleable.Preference_android_enabled, true);
        this.mSelectable = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_selectable, R$styleable.Preference_android_selectable, true);
        this.mPersistent = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_persistent, R$styleable.Preference_android_persistent, true);
        this.mDependencyKey = TypedArrayUtils.getString(typedArrayObtainStyledAttributes, R$styleable.Preference_dependency, R$styleable.Preference_android_dependency);
        int i3 = R$styleable.Preference_allowDividerAbove;
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i3, i3, this.mSelectable);
        int i4 = R$styleable.Preference_allowDividerBelow;
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i4, i4, this.mSelectable);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.Preference_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(typedArrayObtainStyledAttributes, R$styleable.Preference_defaultValue);
        } else if (typedArrayObtainStyledAttributes.hasValue(R$styleable.Preference_android_defaultValue)) {
            this.mDefaultValue = onGetDefaultValue(typedArrayObtainStyledAttributes, R$styleable.Preference_android_defaultValue);
        }
        this.mShouldDisableView = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_shouldDisableView, R$styleable.Preference_android_shouldDisableView, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.Preference_singleLineTitle);
        this.mHasSingleLineTitleAttr = zHasValue;
        if (zHasValue) {
            this.mSingleLineTitle = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_singleLineTitle, R$styleable.Preference_android_singleLineTitle, true);
        }
        this.mIconSpaceReserved = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, R$styleable.Preference_iconSpaceReserved, R$styleable.Preference_android_iconSpaceReserved, false);
        int i5 = R$styleable.Preference_isPreferenceVisible;
        this.mVisible = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i5, i5, true);
        int i6 = R$styleable.Preference_enableCopying;
        this.mCopyingEnabled = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i6, i6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R$attr.preferenceStyle, R.attr.preferenceStyle));
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSummary() {
        if (getSummaryProvider() != null) {
            return getSummaryProvider().provideSummary(this);
        }
        return this.mSummary;
    }

    public boolean isEnabled() {
        return this.mEnabled && this.mDependencyMet && this.mParentDependencyMet;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public final void setSummaryProvider(SummaryProvider summaryProvider) {
        this.mSummaryProvider = summaryProvider;
        notifyChanged();
    }

    public final SummaryProvider getSummaryProvider() {
        return this.mSummaryProvider;
    }

    protected void performClick(View view) {
        performClick();
    }

    public void performClick() {
        if (isEnabled() && isSelectable()) {
            onClick();
            getPreferenceManager();
            if (this.mIntent != null) {
                getContext().startActivity(this.mIntent);
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // java.lang.Comparable
    public int compareTo(Preference preference) {
        int i = this.mOrder;
        int i2 = preference.mOrder;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    public void notifyDependencyChange(boolean z) {
        List list = this.mDependents;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).onDependencyChanged(this, z);
        }
    }

    public void onDependencyChanged(Preference preference, boolean z) {
        if (this.mDependencyMet == z) {
            this.mDependencyMet = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onParentChanged(Preference preference, boolean z) {
        if (this.mParentDependencyMet == z) {
            this.mParentDependencyMet = !z;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    protected boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        Object obj = null;
        if (TextUtils.equals(str, getPersistedString(null))) {
            return true;
        }
        getPreferenceDataStore();
        obj.getClass();
        throw null;
    }

    protected String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        getPreferenceDataStore();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    protected boolean persistInt(int i) {
        if (!shouldPersist()) {
            return false;
        }
        if (i == getPersistedInt(~i)) {
            return true;
        }
        getPreferenceDataStore();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    protected int getPersistedInt(int i) {
        if (!shouldPersist()) {
            return i;
        }
        getPreferenceDataStore();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    protected boolean persistBoolean(boolean z) {
        if (!shouldPersist()) {
            return false;
        }
        if (z == getPersistedBoolean(!z)) {
            return true;
        }
        getPreferenceDataStore();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    protected boolean getPersistedBoolean(boolean z) {
        if (!shouldPersist()) {
            return z;
        }
        getPreferenceDataStore();
        Object obj = null;
        obj.getClass();
        throw null;
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder sb = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb.append(title);
            sb.append(' ');
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb.append(summary);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }
}

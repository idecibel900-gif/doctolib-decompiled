package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    final SimpleArrayMap mIdRecycleCache;
    private int mInitialExpandedChildrenCount;
    private boolean mOrderingAsAdded;
    private final List mPreferences;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIdRecycleCache = new SimpleArrayMap();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mClearRecycleCacheRunnable = new Runnable() { // from class: androidx.preference.PreferenceGroup.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.mIdRecycleCache.clear();
                }
            }
        };
        this.mPreferences = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PreferenceGroup, i, i2);
        int i3 = R$styleable.PreferenceGroup_orderingFromXml;
        this.mOrderingAsAdded = TypedArrayUtils.getBoolean(typedArrayObtainStyledAttributes, i3, i3, true);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.PreferenceGroup_initialExpandedChildrenCount)) {
            int i4 = R$styleable.PreferenceGroup_initialExpandedChildrenCount;
            setInitialExpandedChildrenCount(TypedArrayUtils.getInt(typedArrayObtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setInitialExpandedChildrenCount(int i) {
        if (i != Integer.MAX_VALUE) {
            hasKey();
        }
        this.mInitialExpandedChildrenCount = i;
    }

    public int getPreferenceCount() {
        return this.mPreferences.size();
    }

    public Preference getPreference(int i) {
        return (Preference) this.mPreferences.get(i);
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean z) {
        super.notifyDependencyChange(z);
        int preferenceCount = getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            getPreference(i).onParentChanged(this, z);
        }
    }
}

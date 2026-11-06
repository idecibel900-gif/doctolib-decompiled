package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes.dex */
final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    private static Boolean canFocusValue;

    private CanFocusChecker() {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("canFocus is read before it is written");
            throw new KotlinNothingValueException();
        }
        return bool.booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }

    public final boolean isCanFocusSet() {
        return canFocusValue != null;
    }

    public final void reset() {
        canFocusValue = null;
    }
}

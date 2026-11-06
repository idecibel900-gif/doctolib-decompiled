package com.reactnativekeyboardcontroller.extensions;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.textinput.ReactEditText;
import com.reactnativekeyboardcontroller.log.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EditTextKt {
    public static final TextWatcher addOnTextChangedListener(EditText editText, final Function1 action) throws IllegalAccessException {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TextWatcher textWatcher = new TextWatcher() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$addOnTextChangedListener$listener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String strValueOf = String.valueOf(charSequence);
                if (Intrinsics.areEqual(strValueOf, ref$ObjectRef.element)) {
                    return;
                }
                ref$ObjectRef.element = strValueOf;
                action.invoke(strValueOf);
            }
        };
        try {
            Field declaredField = ReactEditText.class.getDeclaredField("mListeners");
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(editText);
            ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
            if (arrayList != null) {
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (!(it.next() instanceof TextWatcher)) {
                        }
                    }
                }
                arrayList.add(0, textWatcher);
                return textWatcher;
            }
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because `fieldValue` does not belong to `ArrayList<TextWatcher>`", null, 4, null);
            return textWatcher;
        } catch (ClassCastException e) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because casting failed: " + e.getMessage(), null, 4, null);
            return textWatcher;
        } catch (IllegalArgumentException e2) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener to be the first in the list: " + e2.getMessage() + ". Attaching to the end...", null, 4, null);
            editText.addTextChangedListener(textWatcher);
            return textWatcher;
        } catch (NoSuchFieldException e3) {
            Logger.w$default(Logger.INSTANCE, editText.getClass().getSimpleName(), "Can not attach listener because field `mListeners` not found: " + e3.getMessage() + ". Attaching to the end...", null, 4, null);
            editText.addTextChangedListener(textWatcher);
            return textWatcher;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.EditText, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static final int getParentScrollViewTarget(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        while (editText != 0) {
            Object parent = editText.getParent();
            editText = parent instanceof View ? (View) parent : 0;
            if (editText instanceof ReactScrollView) {
                ReactScrollView reactScrollView = (ReactScrollView) editText;
                if (reactScrollView.getScrollEnabled()) {
                    return reactScrollView.getId();
                }
            }
        }
        return -1;
    }

    public static final void focus(EditText editText) {
        if (editText instanceof ReactEditText) {
            ((ReactEditText) editText).requestFocusFromJS();
        } else if (editText != null) {
            editText.requestFocus();
        }
    }

    public static final String getKeyboardType(EditText editText) {
        if (editText == null) {
            return "default";
        }
        int inputType = editText.getInputType() & 15;
        int inputType2 = editText.getInputType() & 4080;
        if (inputType2 == 32) {
            return "email-address";
        }
        if (inputType2 == 16) {
            return "url";
        }
        if (inputType2 == 144) {
            return "visible-password";
        }
        if (inputType != 2) {
            if (inputType != 3) {
                return "default";
            }
            return "phone-pad";
        }
        if ((editText.getInputType() & 8192) == 0 || (editText.getInputType() & 4096) != 0) {
            return (editText.getInputType() & 4096) != 0 ? "numeric" : "number-pad";
        }
        return "decimal-pad";
    }

    public static final Function0 addOnSelectionChangedListener(EditText editText, Function6 action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        final KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher = new KeyboardControllerSelectionWatcher(editText, action);
        keyboardControllerSelectionWatcher.setup();
        return new Function0() { // from class: com.reactnativekeyboardcontroller.extensions.EditTextKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EditTextKt.addOnSelectionChangedListener$lambda$1(keyboardControllerSelectionWatcher);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addOnSelectionChangedListener$lambda$1(KeyboardControllerSelectionWatcher keyboardControllerSelectionWatcher) {
        keyboardControllerSelectionWatcher.destroy();
        return Unit.INSTANCE;
    }
}

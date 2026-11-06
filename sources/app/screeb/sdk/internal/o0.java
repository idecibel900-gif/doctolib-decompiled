package app.screeb.sdk.internal;

import android.content.res.Resources;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.EditText;
import app.screeb.sdk.R$id;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.TokenRequest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o0 {
    public static final boolean a;
    public static final HashMap b;
    public static final SparseBooleanArray c;

    static {
        new HashSet();
        a = true;
        b = new HashMap(128);
        c = new SparseBooleanArray(128);
    }

    public static boolean a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Intrinsics.areEqual(view.getTag(R$id.screeb_no_capture_tag), Boolean.TRUE) || a(view.getContentDescription(), "screeb-no-capture") || a(view.getContentDescription(), "screebNoCapture");
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca A[LOOP:0: B:6:0x0009->B:71:0x00ca, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9 A[SYNTHETIC] */
    public static boolean a(CharSequence charSequence) {
        String str;
        boolean zA;
        char cCharAt;
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt2 = charSequence.charAt(i);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                cCharAt2 = (char) (cCharAt2 + ' ');
            }
            if (cCharAt2 != 'a') {
                if (cCharAt2 == 'c') {
                    if (!a(charSequence, i, "cvv") && !a(charSequence, i, "cvc") && !a(charSequence, i, "credit")) {
                        if (a(charSequence, i, "card")) {
                            int i2 = i + 4;
                            if (!a(charSequence, i2, "number") && (i2 >= charSequence.length() || (((cCharAt = charSequence.charAt(i2)) != ' ' && cCharAt != '_' && cCharAt != '-') || !a(charSequence, i + 5, "number")))) {
                            }
                        }
                        zA = false;
                    }
                    zA = true;
                } else if (cCharAt2 == 'o') {
                    str = "otp";
                } else if (cCharAt2 != 'p') {
                    if (cCharAt2 != 's') {
                        if (cCharAt2 == 't') {
                            str = "token";
                        }
                    } else if (a(charSequence, i, "ssn") || a(charSequence, i, "secret")) {
                        zA = true;
                    }
                    zA = false;
                } else if (a(charSequence, i, TokenRequest.GRANT_TYPE_PASSWORD) || a(charSequence, i, "passwd") || a(charSequence, i, "pwd") || a(charSequence, i, "pin")) {
                    zA = true;
                } else {
                    zA = false;
                }
                if (zA) {
                    return true;
                }
            } else {
                str = "auth";
            }
            zA = a(charSequence, i, str);
            if (zA) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(CharSequence charSequence, int i, String str) {
        if (str.length() + i > charSequence.length()) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i + i2);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = (char) (cCharAt + ' ');
            }
            if (cCharAt != str.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(CharSequence charSequence, String literal) {
        Intrinsics.checkNotNullParameter(literal, "literal");
        if (charSequence == null || charSequence.length() != literal.length()) {
            return false;
        }
        return charSequence instanceof String ? Intrinsics.areEqual(charSequence, literal) : Intrinsics.areEqual(charSequence.toString(), literal);
    }

    public static boolean b(View view) {
        boolean zValueAt;
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(view.getTag(R$id.screeb_sensitive_tag), Boolean.TRUE) || a(view.getContentDescription(), "screeb-mask-text") || a(view.getContentDescription(), "screebMaskText")) {
            return true;
        }
        if (a) {
            if (view instanceof EditText) {
                int inputType = ((EditText) view).getInputType();
                int i = inputType & 4080;
                int i2 = inputType & 15;
                if (i == 128 || i == 144 || i == 224 || (i2 == 2 && i == 16)) {
                    return true;
                }
            }
            if (a(view.getContentDescription())) {
                return true;
            }
            int id = view.getId();
            SparseBooleanArray sparseBooleanArray = c;
            int iIndexOfKey = sparseBooleanArray.indexOfKey(id);
            if (iIndexOfKey >= 0) {
                zValueAt = sparseBooleanArray.valueAt(iIndexOfKey);
            } else {
                int id2 = view.getId();
                String resourceEntryName = null;
                if (id2 != -1 && id2 > 0 && (id2 >>> 24) != 0) {
                    HashMap map = b;
                    Integer numValueOf = Integer.valueOf(id2);
                    Object obj = map.get(numValueOf);
                    if (obj == null) {
                        try {
                            Resources resources = view.getResources();
                            if (resources != null) {
                                resourceEntryName = resources.getResourceEntryName(id2);
                            }
                        } catch (Throwable unused) {
                        }
                        map.put(numValueOf, resourceEntryName);
                        obj = resourceEntryName;
                    }
                    resourceEntryName = (String) obj;
                }
                boolean zA = a(resourceEntryName);
                c.put(id, zA);
                zValueAt = zA;
            }
            if (zValueAt) {
                return true;
            }
        }
        view.getContentDescription();
        return false;
    }

    public static void c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R$id.screeb_no_capture_tag, Boolean.TRUE);
    }

    public static void d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R$id.screeb_sensitive_tag, Boolean.TRUE);
    }
}

package com.facebook.react.uimanager.events;

import android.view.View;
import com.facebook.react.R$id;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class PointerEventHelper {
    public static final PointerEventHelper INSTANCE = new PointerEventHelper();

    public enum EVENT {
        CANCEL,
        CANCEL_CAPTURE,
        CLICK,
        CLICK_CAPTURE,
        DOWN,
        DOWN_CAPTURE,
        ENTER,
        ENTER_CAPTURE,
        LEAVE,
        LEAVE_CAPTURE,
        MOVE,
        MOVE_CAPTURE,
        UP,
        UP_CAPTURE,
        OUT,
        OUT_CAPTURE,
        OVER,
        OVER_CAPTURE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EVENT.values().length];
            try {
                iArr[EVENT.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EVENT.DOWN_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EVENT.UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EVENT.UP_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EVENT.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EVENT.CANCEL_CAPTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EVENT.CLICK.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EVENT.CLICK_CAPTURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PointerEventHelper() {
    }

    public static final int getButtons(String str, String pointerType, int i) {
        Intrinsics.checkNotNullParameter(pointerType, "pointerType");
        if (INSTANCE.isExitEvent(str)) {
            return 0;
        }
        if (Intrinsics.areEqual(AuthorizationRequest.Display.TOUCH, pointerType)) {
            return 1;
        }
        return i;
    }

    public static final int getButtonChange(String pointerType, int i, int i2) {
        Intrinsics.checkNotNullParameter(pointerType, "pointerType");
        int i3 = 0;
        if (Intrinsics.areEqual(AuthorizationRequest.Display.TOUCH, pointerType)) {
            return 0;
        }
        int i4 = i2 ^ i;
        if (i4 == 0) {
            return -1;
        }
        if (i4 != 1) {
            i3 = 2;
            if (i4 != 2) {
                if (i4 == 4) {
                    return 1;
                }
                if (i4 != 8) {
                    return i4 != 16 ? -1 : 4;
                }
                return 3;
            }
        }
        return i3;
    }

    public static final String getW3CPointerType(int i) {
        if (i == 1) {
            return AuthorizationRequest.Display.TOUCH;
        }
        if (i == 2) {
            return "pen";
        }
        if (i == 3) {
            return "mouse";
        }
        return "";
    }

    public static final boolean isListening(View view, EVENT event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (view == null) {
            return true;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                Object tag = view.getTag(R$id.pointer_events);
                Integer num = tag instanceof Integer ? (Integer) tag : null;
                return (num == null || (num.intValue() & (1 << event.ordinal())) == 0) ? false : true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:33:0x0055 A[RETURN] */
    public static final int getEventCategory(String str) {
        if (str == null) {
            return 2;
        }
        switch (str) {
            case "topPointerEnter":
                return 4;
            case "topPointerLeave":
                return 4;
            case "topPointerDown":
                return 3;
            case "topPointerMove":
                return 4;
            case "topPointerOver":
                return 4;
            case "topPointerUp":
                return 3;
            case "topPointerCancel":
                return 3;
            case "topPointerOut":
                return 4;
            default:
                return 2;
        }
    }

    public final boolean isExitEvent(String str) {
        if (str == null) {
            return false;
        }
        int iHashCode = str.hashCode();
        if (iHashCode == -1780335505) {
            return str.equals("topPointerLeave");
        }
        if (iHashCode != -1065042973) {
            return iHashCode == 1343400710 && str.equals("topPointerOut");
        }
        return str.equals("topPointerUp");
    }

    public static final double getPressure(int i, String str) {
        return (INSTANCE.isExitEvent(str) || i == 0) ? 0.0d : 0.5d;
    }

    public static final boolean isBubblingEvent(String str) {
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -1304584214:
                return str.equals("topPointerDown");
            case -1304316135:
                return str.equals("topPointerMove");
            case -1304250340:
                return str.equals("topPointerOver");
            case -1065042973:
                return str.equals("topPointerUp");
            case 383186882:
                return str.equals("topPointerCancel");
            case 1343400710:
                return str.equals("topPointerOut");
            default:
                return false;
        }
    }
}

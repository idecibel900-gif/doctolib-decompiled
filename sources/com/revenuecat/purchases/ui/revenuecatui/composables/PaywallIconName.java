package com.revenuecat.purchases.ui.revenuecatui.composables;

import com.opentok.android.BaseVideoCapturer;
import com.opentok.android.BluetoothManager;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.hybridcommon.ui.HybridPurchaseLogicBridge;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.openid.appauth.CodeVerifierUtil;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b1\b\u0080\u0001\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PaywallIconName;", "", "(Ljava/lang/String;I)V", "drawable", "", "drawable$revenuecatui_defaultsBc8Release", "ADD", "ANDROID", "APPLE", "ATTACH_MONEY", "ATTACHMENT", "BAR_CHART", "BOOKMARK", "BOOKMARK_NO_FILL", "CALENDAR_TODAY", "CHAT_BUBBLE", "CHECK_CIRCLE", "CLOSE", "COLLAPSE", "COMPARE", "DOWNLOAD", "EDIT", "EMAIL", HybridPurchaseLogicBridge.RESULT_ERROR, "EXPERIMENTS", "EXTENSION", "FILE_COPY", "FILTER_LIST", "FOLDER", "GLOBE", "HELP", "INSERT_DRIVE_FILE", "LAUNCH", "LAYERS", "LINE_CHART", "LOCK", "NOTIFICATION", "PERSON", "PHONE", "PLAY_CIRCLE", "REMOVE_RED_EYE", "SEARCH", "SHARE", "SMARTPHONE", "STACKED_BAR", "STARS", "SUBTRACT", "TICK", "TRANSFER", "TWO_WAY_ARROWS", "KEY", "WARNING", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum PaywallIconName {
    ADD,
    ANDROID,
    APPLE,
    ATTACH_MONEY,
    ATTACHMENT,
    BAR_CHART,
    BOOKMARK,
    BOOKMARK_NO_FILL,
    CALENDAR_TODAY,
    CHAT_BUBBLE,
    CHECK_CIRCLE,
    CLOSE,
    COLLAPSE,
    COMPARE,
    DOWNLOAD,
    EDIT,
    EMAIL,
    ERROR,
    EXPERIMENTS,
    EXTENSION,
    FILE_COPY,
    FILTER_LIST,
    FOLDER,
    GLOBE,
    HELP,
    INSERT_DRIVE_FILE,
    LAUNCH,
    LAYERS,
    LINE_CHART,
    LOCK,
    NOTIFICATION,
    PERSON,
    PHONE,
    PLAY_CIRCLE,
    REMOVE_RED_EYE,
    SEARCH,
    SHARE,
    SMARTPHONE,
    STACKED_BAR,
    STARS,
    SUBTRACT,
    TICK,
    TRANSFER,
    TWO_WAY_ARROWS,
    KEY,
    WARNING;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, PaywallIconName> valueMap;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaywallIconName.values().length];
            try {
                iArr[PaywallIconName.WARNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallIconName.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallIconName.ANDROID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallIconName.APPLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaywallIconName.ATTACH_MONEY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaywallIconName.ATTACHMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PaywallIconName.BAR_CHART.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PaywallIconName.BOOKMARK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PaywallIconName.BOOKMARK_NO_FILL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PaywallIconName.CALENDAR_TODAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PaywallIconName.CHAT_BUBBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PaywallIconName.CHECK_CIRCLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PaywallIconName.CLOSE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PaywallIconName.COLLAPSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PaywallIconName.COMPARE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PaywallIconName.DOWNLOAD.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PaywallIconName.EDIT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PaywallIconName.EMAIL.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[PaywallIconName.ERROR.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[PaywallIconName.EXPERIMENTS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[PaywallIconName.EXTENSION.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[PaywallIconName.FILE_COPY.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[PaywallIconName.FILTER_LIST.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[PaywallIconName.FOLDER.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[PaywallIconName.GLOBE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[PaywallIconName.HELP.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[PaywallIconName.INSERT_DRIVE_FILE.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[PaywallIconName.LAUNCH.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[PaywallIconName.LAYERS.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[PaywallIconName.LINE_CHART.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[PaywallIconName.LOCK.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[PaywallIconName.NOTIFICATION.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[PaywallIconName.PERSON.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[PaywallIconName.PHONE.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[PaywallIconName.PLAY_CIRCLE.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[PaywallIconName.REMOVE_RED_EYE.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[PaywallIconName.SEARCH.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[PaywallIconName.SHARE.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[PaywallIconName.SMARTPHONE.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[PaywallIconName.STACKED_BAR.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[PaywallIconName.STARS.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[PaywallIconName.SUBTRACT.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[PaywallIconName.TICK.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[PaywallIconName.TRANSFER.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[PaywallIconName.TWO_WAY_ARROWS.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[PaywallIconName.KEY.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        PaywallIconName[] paywallIconNameArrValues = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(paywallIconNameArrValues.length), 16));
        for (PaywallIconName paywallIconName : paywallIconNameArrValues) {
            String lowerCase = paywallIconName.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, paywallIconName);
        }
        valueMap = linkedHashMap;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PaywallIconName$Companion;", "", "()V", "valueMap", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PaywallIconName;", "fromValue", "value", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PaywallIconName fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (PaywallIconName) PaywallIconName.valueMap.get(value);
        }
    }

    public final int drawable$revenuecatui_defaultsBc8Release() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return R.drawable.warning;
            case 2:
                return R.drawable.add;
            case 3:
                return R.drawable.f96android;
            case 4:
                return R.drawable.apple;
            case 5:
                return R.drawable.attach_money;
            case 6:
                return R.drawable.attachment;
            case 7:
                return R.drawable.bar_chart;
            case 8:
                return R.drawable.bookmark;
            case 9:
                return R.drawable.bookmark_no_fill;
            case 10:
                return R.drawable.calendar_today;
            case BaseVideoCapturer.RGBA /* 11 */:
                return R.drawable.chat_bubble;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                return R.drawable.check_circle;
            case 13:
                return R.drawable.close;
            case 14:
                return R.drawable.collapse;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return R.drawable.compare;
            case 16:
                return R.drawable.download;
            case 17:
                return R.drawable.edit;
            case 18:
                return R.drawable.email;
            case 19:
                return R.drawable.error;
            case 20:
                return R.drawable.experiments;
            case 21:
                return R.drawable.extension;
            case 22:
                return R.drawable.file_copy;
            case 23:
                return R.drawable.filter_list;
            case ColorExtractionConstants.ALPHA_CHANNEL_SHIFT /* 24 */:
                return R.drawable.folder;
            case BluetoothManager.SCO_CONNECTION_ATTEMPT_DELAY /* 25 */:
                return R.drawable.globe;
            case 26:
                return R.drawable.help;
            case 27:
                return R.drawable.insert_drive_file;
            case 28:
                return R.drawable.launch;
            case 29:
                return R.drawable.layers;
            case 30:
                return R.drawable.line_chart;
            case BackgroundUIConstants.minSDKVersionSupportingBlur /* 31 */:
                return R.drawable.lock;
            case 32:
                return R.drawable.notifications;
            case 33:
                return R.drawable.person;
            case 34:
                return R.drawable.phone;
            case 35:
                return R.drawable.play_circle;
            case 36:
                return R.drawable.remove_red_eye;
            case 37:
                return R.drawable.search;
            case 38:
                return R.drawable.share;
            case 39:
                return R.drawable.smartphone;
            case 40:
                return R.drawable.stacked_bar;
            case 41:
                return R.drawable.stars;
            case 42:
                return R.drawable.subtract;
            case CodeVerifierUtil.MIN_CODE_VERIFIER_LENGTH /* 43 */:
                return R.drawable.tick;
            case 44:
                return R.drawable.transfer;
            case 45:
                return R.drawable.two_way_arrows;
            case 46:
                return R.drawable.vpn_key;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}

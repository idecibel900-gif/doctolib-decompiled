package androidx.media3.session;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class CommandButton {
    private static final String FIELD_SESSION_COMMAND = Util.intToStringMaxRadix(0);
    private static final String FIELD_PLAYER_COMMAND = Util.intToStringMaxRadix(1);
    private static final String FIELD_ICON_RES_ID = Util.intToStringMaxRadix(2);
    private static final String FIELD_DISPLAY_NAME = Util.intToStringMaxRadix(3);
    private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(4);
    private static final String FIELD_ENABLED = Util.intToStringMaxRadix(5);
    private static final String FIELD_ICON_URI = Util.intToStringMaxRadix(6);
    private static final String FIELD_ICON = Util.intToStringMaxRadix(7);
    private static final String FIELD_SLOTS = Util.intToStringMaxRadix(8);

    static ImmutableList copyWithUnavailableButtonsDisabled(List list, SessionCommands sessionCommands, Player.Commands commands) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < list.size(); i++) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list.get(i));
            if (isButtonCommandAvailable(null, sessionCommands, commands)) {
                builder.add((Object) null);
            } else {
                throw null;
            }
        }
        return builder.build();
    }

    static boolean isButtonCommandAvailable(CommandButton commandButton, SessionCommands sessionCommands, Player.Commands commands) {
        throw null;
    }

    static ImmutableList getCustomLayoutFromMediaButtonPreferences(List list, boolean z, boolean z2) {
        if (list.isEmpty()) {
            return ImmutableList.of();
        }
        if (list.size() > 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list.get(0));
            throw null;
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        if (list.size() > 0) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list.get(0));
            throw null;
        }
        return builder.build();
    }

    static boolean containsButtonForSlot(List list, int i) {
        if (list.size() <= 0) {
            return false;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(list.get(0));
        throw null;
    }
}

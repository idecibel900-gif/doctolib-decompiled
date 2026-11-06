package app.notifee.core;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationManagerCompat;
import app.notifee.core.model.ChannelGroupModel;
import app.notifee.core.model.ChannelModel;
import app.notifee.core.utility.ColorUtils;
import app.notifee.core.utility.ResourceUtils;
import com.amazon.a.a.o.b;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChannelManager {
    private static String TAG = "ChannelManager";

    static ListenableFuture createChannel(final ChannelModel channelModel) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.m2973$r8$lambda$LdnDY665yVee7FuTMnfKedYtuE(channelModel);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$LdnDY66-5yVee7FuTMnfKedYtuE, reason: not valid java name */
    public static /* synthetic */ Void m2973$r8$lambda$LdnDY665yVee7FuTMnfKedYtuE(ChannelModel channelModel) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        ChannelManager$$ExternalSyntheticApiModelOutline3.m();
        NotificationChannel notificationChannelM = ChannelManager$$ExternalSyntheticApiModelOutline2.m(channelModel.getId(), channelModel.getName(), channelModel.getImportance().intValue());
        notificationChannelM.setShowBadge(channelModel.getBadge().booleanValue());
        notificationChannelM.setBypassDnd(channelModel.getBypassDnd().booleanValue());
        notificationChannelM.setDescription(channelModel.getDescription());
        notificationChannelM.setGroup(channelModel.getGroupId());
        notificationChannelM.enableLights(channelModel.getLights().booleanValue());
        if (channelModel.getLightColor() != null) {
            notificationChannelM.setLightColor(channelModel.getLightColor().intValue());
        }
        notificationChannelM.setLockscreenVisibility(channelModel.getVisibility());
        notificationChannelM.enableVibration(channelModel.getVibration().booleanValue());
        long[] vibrationPattern = channelModel.getVibrationPattern();
        if (vibrationPattern.length > 0) {
            notificationChannelM.setVibrationPattern(vibrationPattern);
        }
        if (channelModel.getSound() != null) {
            Uri soundUri = ResourceUtils.getSoundUri(channelModel.getSound());
            if (soundUri != null) {
                notificationChannelM.setSound(soundUri, new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
            } else {
                Logger.w(TAG, "Unable to retrieve sound for channel, sound was specified as: " + notificationChannelM.getSound());
            }
        } else {
            notificationChannelM.setSound(null, null);
        }
        NotificationManagerCompat.from(ContextHolder.getApplicationContext()).createNotificationChannel(notificationChannelM);
        return null;
    }

    static ListenableFuture createChannels(final List list) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.m2972$r8$lambda$4iVZGO3ebFqbIO_EgJiK6Zhss(list);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$4iVZGO3ebFq-b-IO_EgJiK6Zhss, reason: not valid java name */
    public static /* synthetic */ Void m2972$r8$lambda$4iVZGO3ebFqbIO_EgJiK6Zhss(List list) throws ExecutionException, InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            createChannel((ChannelModel) it.next()).get();
        }
        return null;
    }

    static ListenableFuture createChannelGroup(final ChannelGroupModel channelGroupModel) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.$r8$lambda$1PFJkpP2bxqz0yGYGthdhBQ3tOA(channelGroupModel);
            }
        });
    }

    public static /* synthetic */ Void $r8$lambda$1PFJkpP2bxqz0yGYGthdhBQ3tOA(ChannelGroupModel channelGroupModel) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return null;
        }
        ChannelManager$$ExternalSyntheticApiModelOutline1.m();
        NotificationChannelGroup notificationChannelGroupM = ChannelManager$$ExternalSyntheticApiModelOutline0.m(channelGroupModel.getId(), channelGroupModel.getName());
        if (i >= 28 && channelGroupModel.getDescription() != null) {
            notificationChannelGroupM.setDescription(channelGroupModel.getDescription());
        }
        NotificationManagerCompat.from(ContextHolder.getApplicationContext()).createNotificationChannelGroup(notificationChannelGroupM);
        return null;
    }

    static ListenableFuture createChannelGroups(final List list) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.m2975$r8$lambda$Rb4gAKImP1nycFZ1Awhw5AgW0g(list);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$R-b4gAKImP1nycFZ1Awhw5AgW0g, reason: not valid java name */
    public static /* synthetic */ Void m2975$r8$lambda$Rb4gAKImP1nycFZ1Awhw5AgW0g(List list) throws ExecutionException, InterruptedException {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            createChannelGroup((ChannelGroupModel) it.next()).get();
        }
        return null;
    }

    static void deleteChannel(String str) {
        NotificationManagerCompat.from(ContextHolder.getApplicationContext()).deleteNotificationChannel(str);
    }

    static void deleteChannelGroup(String str) {
        NotificationManagerCompat.from(ContextHolder.getApplicationContext()).deleteNotificationChannelGroup(str);
    }

    static ListenableFuture getChannels() {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.m2974$r8$lambda$Oo9PLeR02Ydjxqfymt6RQeUCbY();
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$Oo9PLeR02Y-djxqfymt6RQeUCbY, reason: not valid java name */
    public static /* synthetic */ List m2974$r8$lambda$Oo9PLeR02Ydjxqfymt6RQeUCbY() {
        List notificationChannels = NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannels();
        if (notificationChannels.size() == 0 || Build.VERSION.SDK_INT < 26) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(notificationChannels.size());
        Iterator it = notificationChannels.iterator();
        while (it.hasNext()) {
            arrayList.add(convertChannelToBundle((NotificationChannel) it.next()));
        }
        return arrayList;
    }

    static ListenableFuture getChannel(final String str) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.convertChannelToBundle(NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannel(str));
            }
        });
    }

    static ListenableFuture isChannelBlocked(final String str) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.$r8$lambda$Z7rz9p4wSlU3PIWbILpTAs32Ei8(str);
            }
        });
    }

    public static /* synthetic */ Boolean $r8$lambda$Z7rz9p4wSlU3PIWbILpTAs32Ei8(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return Boolean.FALSE;
        }
        NotificationChannel notificationChannel = NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannel(str);
        if (notificationChannel == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(notificationChannel.getImportance() == 0);
    }

    static ListenableFuture isChannelCreated(final String str) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.m2971$r8$lambda$40Hzw66g8oZQMWzTrFqStkkh4(str);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$40Hzw6-6g8oZQMWzTrFq-Stkkh4, reason: not valid java name */
    public static /* synthetic */ Boolean m2971$r8$lambda$40Hzw66g8oZQMWzTrFqStkkh4(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannel(str) != null);
    }

    static ListenableFuture getChannelGroups() {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.$r8$lambda$siIvPI325j2m50gSWJ_4YJUGpWA();
            }
        });
    }

    public static /* synthetic */ List $r8$lambda$siIvPI325j2m50gSWJ_4YJUGpWA() {
        List notificationChannelGroups = NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannelGroups();
        if (notificationChannelGroups.size() == 0 || Build.VERSION.SDK_INT < 26) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
        Iterator it = notificationChannelGroups.iterator();
        while (it.hasNext()) {
            arrayList.add(convertChannelGroupToBundle((NotificationChannelGroup) it.next()));
        }
        return arrayList;
    }

    static ListenableFuture getChannelGroup(final String str) {
        return Notifee.getListeningExecutorService().submit(new Callable() { // from class: app.notifee.core.ChannelManager$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ChannelManager.convertChannelGroupToBundle(NotificationManagerCompat.from(ContextHolder.getApplicationContext()).getNotificationChannelGroup(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle convertChannelToBundle(NotificationChannel notificationChannel) {
        if (notificationChannel == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(DiagnosticsEntry.ID_KEY, notificationChannel.getId());
        bundle.putString("name", notificationChannel.getName().toString());
        bundle.putBoolean("badge", notificationChannel.canShowBadge());
        bundle.putBoolean("bypassDnd", notificationChannel.canBypassDnd());
        if (notificationChannel.getDescription() != null) {
            bundle.putString(b.c, notificationChannel.getDescription());
        }
        if (notificationChannel.getGroup() != null) {
            bundle.putString("groupId", notificationChannel.getGroup());
        }
        bundle.putInt("importance", notificationChannel.getImportance());
        bundle.putBoolean("lights", notificationChannel.shouldShowLights());
        bundle.putBoolean("vibration", notificationChannel.shouldVibrate());
        bundle.putBoolean("blocked", notificationChannel.getImportance() == 0);
        if (notificationChannel.getSound() != null) {
            bundle.putString("soundURI", notificationChannel.getSound().toString());
            String soundName = ResourceUtils.getSoundName(notificationChannel.getSound());
            if (soundName != null) {
                bundle.putString("sound", soundName);
            }
        }
        if (notificationChannel.getLightColor() != 0) {
            bundle.putString("lightColor", ColorUtils.getColorString(notificationChannel.getLightColor()));
        }
        long[] vibrationPattern = notificationChannel.getVibrationPattern();
        if (vibrationPattern != null && vibrationPattern.length > 0) {
            try {
                int[] iArr = new int[vibrationPattern.length];
                for (int i = 0; i < vibrationPattern.length; i++) {
                    iArr[i] = (int) vibrationPattern[i];
                }
                bundle.putIntArray("vibrationPattern", iArr);
            } catch (Exception e) {
                Logger.e(TAG, "Unable to convert Vibration Pattern to Channel Bundle", e);
            }
        }
        int lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        if (lockscreenVisibility != -1000) {
            bundle.putInt("visibility", lockscreenVisibility);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle convertChannelGroupToBundle(NotificationChannelGroup notificationChannelGroup) {
        if (notificationChannelGroup == null || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(DiagnosticsEntry.ID_KEY, notificationChannelGroup.getId());
        bundle.putString("name", notificationChannelGroup.getName().toString());
        List<NotificationChannel> channels = notificationChannelGroup.getChannels();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(channels.size());
        Iterator<NotificationChannel> it = channels.iterator();
        while (it.hasNext()) {
            arrayList.add(convertChannelToBundle(ChannelManager$$ExternalSyntheticApiModelOutline4.m(it.next())));
        }
        bundle.putParcelableArrayList("channels", arrayList);
        if (Build.VERSION.SDK_INT >= 28) {
            bundle.putBoolean("blocked", notificationChannelGroup.isBlocked());
            bundle.putString(b.c, notificationChannelGroup.getDescription());
            return bundle;
        }
        bundle.putBoolean("blocked", false);
        return bundle;
    }
}

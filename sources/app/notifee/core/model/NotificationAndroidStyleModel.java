package app.notifee.core.model;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import app.notifee.core.Logger;
import app.notifee.core.utility.BundleValueReader;
import app.notifee.core.utility.ParcelableCompatReader;
import app.notifee.core.utility.ResourceUtils;
import app.notifee.core.utility.TextUtils;
import com.amazon.a.a.o.b;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class NotificationAndroidStyleModel {
    private static final String TAG = "NotificationAndroidStyle";
    private Bundle mNotificationAndroidStyleBundle;

    private NotificationAndroidStyleModel(Bundle bundle) {
        this.mNotificationAndroidStyleBundle = bundle;
    }

    public static NotificationAndroidStyleModel fromBundle(Bundle bundle) {
        return new NotificationAndroidStyleModel(bundle);
    }

    private static Person.Builder getPersonBuilder(Bundle bundle) {
        Person.Builder builder = new Person.Builder();
        builder.setName(bundle.getString("name"));
        if (bundle.containsKey(DiagnosticsEntry.ID_KEY)) {
            builder.setKey(bundle.getString(DiagnosticsEntry.ID_KEY));
        }
        if (bundle.containsKey("bot")) {
            builder.setBot(bundle.getBoolean("bot"));
        }
        if (bundle.containsKey("important")) {
            builder.setImportant(bundle.getBoolean("important"));
        }
        if (bundle.containsKey("uri")) {
            builder.setUri(bundle.getString("uri"));
        }
        return builder;
    }

    private static ListenableFuture getPerson(ListeningExecutorService listeningExecutorService, final Bundle bundle) {
        return listeningExecutorService.submit(new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return NotificationAndroidStyleModel.$r8$lambda$TkxUkObooWfINu0DRsjBG_QgIgc(bundle);
            }
        });
    }

    public static /* synthetic */ Person $r8$lambda$TkxUkObooWfINu0DRsjBG_QgIgc(Bundle bundle) {
        Person.Builder personBuilder = getPersonBuilder(bundle);
        if (bundle.containsKey("icon")) {
            String string = bundle.getString("icon");
            Objects.requireNonNull(string);
            try {
                Bitmap bitmap = (Bitmap) ResourceUtils.getImageBitmapFromUrl(string).get(10L, TimeUnit.SECONDS);
                if (bitmap != null) {
                    personBuilder.setIcon(IconCompat.createWithAdaptiveBitmap(bitmap));
                }
            } catch (RuntimeException e) {
                e = e;
                Logger.e(TAG, "An error occurred whilst trying to retrieve or create a person icon: " + string, e);
            } catch (ExecutionException e2) {
                e = e2;
                Logger.e(TAG, "An error occurred whilst trying to retrieve or create a person icon: " + string, e);
            } catch (TimeoutException e3) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a person icon: " + string, (Exception) e3);
            }
        }
        return personBuilder.build();
    }

    private static Person awaitPerson(ListenableFuture listenableFuture, Bundle bundle) throws ExecutionException, InterruptedException {
        try {
            return (Person) listenableFuture.get(20L, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Logger.e(TAG, "Unexpected failure whilst building a messaging style person", (Exception) e);
            throw e;
        } catch (TimeoutException e2) {
            Logger.e(TAG, "Timeout occurred whilst trying to retrieve a messaging style person", (Exception) e2);
            return getPersonBuilder(bundle).build();
        }
    }

    public Bundle toBundle() {
        return (Bundle) this.mNotificationAndroidStyleBundle.clone();
    }

    public ListenableFuture getStyleTask(ListeningExecutorService listeningExecutorService) {
        int intPreserving = BundleValueReader.getIntPreserving(this.mNotificationAndroidStyleBundle, "type");
        if (intPreserving == 0) {
            return getBigPictureStyleTask(listeningExecutorService);
        }
        if (intPreserving == 1) {
            return Futures.immediateFuture(getBigTextStyle());
        }
        if (intPreserving == 2) {
            return Futures.immediateFuture(getInboxStyle());
        }
        if (intPreserving != 3) {
            return null;
        }
        return getMessagingStyleTask(listeningExecutorService);
    }

    private ListenableFuture getBigPictureStyleTask(ListeningExecutorService listeningExecutorService) {
        return listeningExecutorService.submit(new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getBigPictureStyleTask$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotificationCompat.Style lambda$getBigPictureStyleTask$1() throws Exception {
        String string;
        Bitmap bitmap;
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        Bitmap bitmap2 = null;
        if (this.mNotificationAndroidStyleBundle.containsKey("picture")) {
            String string2 = this.mNotificationAndroidStyleBundle.getString("picture");
            Objects.requireNonNull(string2);
            try {
                bitmap = (Bitmap) ResourceUtils.getImageBitmapFromUrl(string2).get(10L, TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style image: " + string2, (Exception) e);
                bitmap = null;
            } catch (Exception e2) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style image: " + string2, e2);
                bitmap = null;
            }
            if (bitmap != null) {
                bigPictureStyle.bigPicture(bitmap);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("largeIcon")) {
            string = this.mNotificationAndroidStyleBundle.getString("largeIcon");
            if (string == null) {
                bigPictureStyle.bigLargeIcon(null);
            }
        } else {
            string = null;
        }
        if (string != null) {
            try {
                bitmap2 = (Bitmap) ResourceUtils.getImageBitmapFromUrl(string).get(10L, TimeUnit.SECONDS);
            } catch (TimeoutException e3) {
                Logger.e(TAG, "Timeout occurred whilst trying to retrieve a big picture style large icon: " + string, (Exception) e3);
            } catch (Exception e4) {
                Logger.e(TAG, "An error occurred whilst trying to retrieve a big picture style large icon: " + string, e4);
            }
            if (bitmap2 != null) {
                bigPictureStyle.bigLargeIcon(bitmap2);
            }
        }
        if (this.mNotificationAndroidStyleBundle.containsKey(b.S)) {
            bigPictureStyle = bigPictureStyle.setBigContentTitle(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString(b.S)));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigPictureStyle.setSummaryText(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"))) : bigPictureStyle;
    }

    private NotificationCompat.BigTextStyle getBigTextStyle() {
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey("text")) {
            bigTextStyle = bigTextStyle.bigText(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString("text")));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey(b.S)) {
            bigTextStyle = bigTextStyle.setBigContentTitle(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString(b.S)));
        }
        return this.mNotificationAndroidStyleBundle.containsKey("summary") ? bigTextStyle.setSummaryText(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary"))) : bigTextStyle;
    }

    private NotificationCompat.InboxStyle getInboxStyle() {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        if (this.mNotificationAndroidStyleBundle.containsKey(b.S)) {
            inboxStyle = inboxStyle.setBigContentTitle(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString(b.S)));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("summary")) {
            inboxStyle = inboxStyle.setSummaryText(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString("summary")));
        }
        ArrayList<String> stringArrayList = this.mNotificationAndroidStyleBundle.getStringArrayList("lines");
        int i = 0;
        while (true) {
            Objects.requireNonNull(stringArrayList);
            if (i >= stringArrayList.size()) {
                return inboxStyle;
            }
            inboxStyle = inboxStyle.addLine(TextUtils.fromHtml(stringArrayList.get(i)));
            i++;
        }
    }

    private ListenableFuture getMessagingStyleTask(final ListeningExecutorService listeningExecutorService) {
        return listeningExecutorService.submit(new Callable() { // from class: app.notifee.core.model.NotificationAndroidStyleModel$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$getMessagingStyleTask$2(listeningExecutorService);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ NotificationCompat.Style lambda$getMessagingStyleTask$2(ListeningExecutorService listeningExecutorService) throws Exception {
        Person personAwaitPerson;
        Bundle bundle = this.mNotificationAndroidStyleBundle.getBundle("person");
        Objects.requireNonNull(bundle);
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(awaitPerson(getPerson(listeningExecutorService, bundle), bundle));
        if (this.mNotificationAndroidStyleBundle.containsKey(b.S)) {
            messagingStyle = messagingStyle.setConversationTitle(TextUtils.fromHtml(this.mNotificationAndroidStyleBundle.getString(b.S)));
        }
        if (this.mNotificationAndroidStyleBundle.containsKey("group")) {
            messagingStyle = messagingStyle.setGroupConversation(this.mNotificationAndroidStyleBundle.getBoolean("group"));
        }
        ArrayList parcelableArrayList = ParcelableCompatReader.getParcelableArrayList(this.mNotificationAndroidStyleBundle, "messages", Bundle.class);
        int i = 0;
        while (true) {
            Objects.requireNonNull(parcelableArrayList);
            if (i >= parcelableArrayList.size()) {
                return messagingStyle;
            }
            Bundle bundle2 = (Bundle) parcelableArrayList.get(i);
            long longPreserving = BundleValueReader.getLongPreserving(bundle2, DiagnosticsEntry.TIMESTAMP_KEY);
            if (bundle2.containsKey("person")) {
                Bundle bundle3 = bundle2.getBundle("person");
                Objects.requireNonNull(bundle3);
                personAwaitPerson = awaitPerson(getPerson(listeningExecutorService, bundle3), bundle3);
            } else {
                personAwaitPerson = null;
            }
            messagingStyle = messagingStyle.addMessage(TextUtils.fromHtml(bundle2.getString("text")), longPreserving, personAwaitPerson);
            i++;
        }
    }
}

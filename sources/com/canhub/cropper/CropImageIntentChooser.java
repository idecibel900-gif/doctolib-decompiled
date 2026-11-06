package com.canhub.cropper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CropImageIntentChooser {
    public static final Companion Companion = new Companion(null);
    private final ComponentActivity activity;
    private final ResultCallback callback;
    private Uri cameraImgUri;
    private final ActivityResultLauncher intentChooser;
    private List priorityIntentList;
    private String title;

    public interface ResultCallback {
        void onCancelled();

        void onSuccess(Uri uri);
    }

    public CropImageIntentChooser(ComponentActivity activity, ResultCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.activity = activity;
        this.callback = callback;
        String string = activity.getString(R$string.pick_image_chooser_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.title = string;
        this.priorityIntentList = CollectionsKt.listOf((Object[]) new String[]{"com.google.android.apps.photos", "com.google.android.apps.photosgo", "com.sec.android.gallery3d", "com.oneplus.gallery", "com.miui.gallery"});
        this.intentChooser = activity.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.canhub.cropper.CropImageIntentChooser$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                CropImageIntentChooser.intentChooser$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intentChooser$lambda$1(CropImageIntentChooser this$0, ActivityResult activityRes) {
        Uri data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityRes, "activityRes");
        if (activityRes.getResultCode() == -1) {
            Intent data2 = activityRes.getData();
            if (data2 == null || (data = data2.getData()) == null) {
                data = this$0.cameraImgUri;
            }
            this$0.callback.onSuccess(data);
            return;
        }
        this$0.callback.onCancelled();
    }

    public final void showChooserIntent(boolean z, boolean z2, Uri uri) {
        Intent intent;
        this.cameraImgUri = uri;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.activity.getPackageManager();
        if (!isExplicitCameraPermissionRequired(this.activity) && z) {
            ComponentActivity componentActivity = this.activity;
            Intrinsics.checkNotNull(packageManager);
            arrayList.addAll(getCameraIntents(componentActivity, packageManager));
        }
        if (z2) {
            Intrinsics.checkNotNull(packageManager);
            List galleryIntents = getGalleryIntents(packageManager, "android.intent.action.GET_CONTENT");
            if (galleryIntents.isEmpty()) {
                galleryIntents = getGalleryIntents(packageManager, "android.intent.action.PICK");
            }
            arrayList.addAll(galleryIntents);
        }
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            Intent intent2 = new Intent("android.intent.action.CHOOSER", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (z2) {
                intent2.setAction("android.intent.action.PICK");
                intent2.setType("image/*");
            }
            intent = intent2;
        }
        Intent intentCreateChooser = Intent.createChooser(intent, this.title);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        ActivityResultLauncher activityResultLauncher = this.intentChooser;
        Intrinsics.checkNotNull(intentCreateChooser);
        activityResultLauncher.launch(intentCreateChooser);
    }

    private final List getCameraIntents(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0)) : packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (context instanceof Activity) {
                ((Activity) context).grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraImgUri, 3);
            }
            intent2.putExtra("output", this.cameraImgUri);
            arrayList.add(intent2);
        }
        return arrayList;
    }

    private final List getGalleryIntents(PackageManager packageManager, String str) {
        Intent intent;
        Object next;
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(str, "android.intent.action.GET_CONTENT")) {
            intent = new Intent(str);
        } else {
            intent = new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        intent.setType("image/*");
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0)) : packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNull(listQueryIntentActivities);
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : this.priorityIntentList) {
            Iterator it = arrayList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((Intent) next).getPackage(), str2));
            Intent intent3 = (Intent) next;
            if (intent3 != null) {
                arrayList.remove(intent3);
                arrayList2.add(intent3);
            }
        }
        arrayList.addAll(0, arrayList2);
        return arrayList;
    }

    private final boolean isExplicitCameraPermissionRequired(Context context) {
        return hasCameraPermissionInManifest(context) && context.checkSelfPermission("android.permission.CAMERA") != 0;
    }

    private final boolean hasCameraPermissionInManifest(Context context) {
        String packageName = context.getPackageName();
        try {
            String[] strArr = (Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(4096)) : context.getPackageManager().getPackageInfo(packageName, 4096)).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str != null && StringsKt.equals(str, "android.permission.CAMERA", true)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final CropImageIntentChooser setupPriorityAppsList(List appsList) {
        Intrinsics.checkNotNullParameter(appsList, "appsList");
        this.priorityIntentList = appsList;
        return this;
    }

    public final CropImageIntentChooser setIntentChooserTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
        return this;
    }
}

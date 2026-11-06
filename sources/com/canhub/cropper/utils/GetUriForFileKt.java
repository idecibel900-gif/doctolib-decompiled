package com.canhub.cropper.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GetUriForFileKt {
    public static final String authority(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageName() + ".cropper.fileprovider";
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[Catch: Exception -> 0x004e, TryCatch #1 {Exception -> 0x004e, blocks: (B:6:0x0019, B:12:0x0047, B:43:0x00c7, B:45:0x00cc, B:46:0x00cf, B:38:0x00bc, B:40:0x00c1), top: B:57:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00cc A[Catch: Exception -> 0x004e, TryCatch #1 {Exception -> 0x004e, blocks: (B:6:0x0019, B:12:0x0047, B:43:0x00c7, B:45:0x00cc, B:46:0x00cf, B:38:0x00bc, B:40:0x00c1), top: B:57:0x0019 }] */
    public static final Uri getUriForFile(Context context, File file) throws Throwable {
        File externalCacheDir;
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        String strAuthority = authority(context);
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, strAuthority, file);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            return uriForFile;
        } catch (Exception e) {
            try {
                e.getMessage();
                File file2 = new File(new File(context.getCacheDir(), "CROP_LIB_CACHE"), file.getName());
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            ByteStreamsKt.copyTo$default(fileInputStream2, fileOutputStream, 0, 2, null);
                            Uri uriForFile2 = FileProvider.getUriForFile(context, strAuthority, file2);
                            Intrinsics.checkNotNullExpressionValue(uriForFile2, "getUriForFile(...)");
                            fileInputStream2.close();
                            fileOutputStream.close();
                            return uriForFile2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            try {
                                e.getMessage();
                                String str = "content://" + strAuthority + "/files/my_images/";
                                if (Build.VERSION.SDK_INT >= 26) {
                                    Files.createDirectories(Paths.get(str, new String[0]), new FileAttribute[0]);
                                } else {
                                    File file3 = new File(str);
                                    if (!file3.exists()) {
                                        file3.mkdirs();
                                    }
                                }
                                Uri uri = Uri.parse(str + file.getName());
                                Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return uri;
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (Exception e5) {
                e5.getMessage();
                if (Build.VERSION.SDK_INT < 29 && (externalCacheDir = context.getExternalCacheDir()) != null) {
                    try {
                        Uri uriFromFile = Uri.fromFile(new File(externalCacheDir.getPath(), file.getAbsolutePath()));
                        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
                        return uriFromFile;
                    } catch (Exception e6) {
                        e6.getMessage();
                        Uri uriFromFile2 = Uri.fromFile(file);
                        Intrinsics.checkNotNullExpressionValue(uriFromFile2, "fromFile(...)");
                        return uriFromFile2;
                    }
                }
                Uri uriFromFile3 = Uri.fromFile(file);
                Intrinsics.checkNotNullExpressionValue(uriFromFile3, "fromFile(...)");
                return uriFromFile3;
            }
        }
    }
}

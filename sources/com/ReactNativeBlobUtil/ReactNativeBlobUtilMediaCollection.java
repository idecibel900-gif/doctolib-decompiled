package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReactNativeBlobUtilMediaCollection {

    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        }
        if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        return MediaStore.Downloads.getContentUri("external_primary");
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaType == MediaType.Audio) {
                return Environment.DIRECTORY_MUSIC;
            }
            if (mediaType == MediaType.Video) {
                return Environment.DIRECTORY_MOVIES;
            }
            if (mediaType == MediaType.Image) {
                return Environment.DIRECTORY_PICTURES;
            }
            return mediaType == MediaType.Download ? Environment.DIRECTORY_DOWNLOADS : Environment.DIRECTORY_DOWNLOADS;
        }
        if (mediaType == MediaType.Audio) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMusicDir").toString();
        }
        if (mediaType == MediaType.Video) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMovieDir").toString();
        }
        if (mediaType == MediaType.Image) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyPictureDir").toString();
        }
        return mediaType == MediaType.Download ? ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString() : ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + '/' + fileDescription.partentFolder);
            try {
                return contentResolver.insert(getMediaUri(mediaType), contentValues);
            } catch (Exception unused) {
                return null;
            }
        }
        File file = new File(relativePath + fileDescription.getFullPath());
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused2) {
                return null;
            }
        }
        return Uri.fromFile(file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static boolean writeToMediaFile(Uri uri, String str, boolean z, Promise promise, ReactApplicationContext reactApplicationContext) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Context applicationContext = reactApplicationContext.getApplicationContext();
                ContentResolver contentResolver = applicationContext.getContentResolver();
                ?? r2 = 0;
                try {
                    try {
                        try {
                            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = applicationContext.getContentResolver().openFileDescriptor(uri, "w");
                            String strNormalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
                            File file = new File(strNormalizePath);
                            if (!file.exists()) {
                                promise.reject("ENOENT", "No such file ('" + strNormalizePath + "')");
                                return false;
                            }
                            FileInputStream fileInputStream = new FileInputStream(file);
                            FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            if (z) {
                                fileInputStream.read(new byte[(int) file.length()]);
                                throw new IllegalStateException("Write to media file with transform was specified but the shared file transformer is not set");
                            }
                            byte[] bArr = new byte[10240];
                            while (true) {
                                int i = fileInputStream.read(bArr);
                                if (i > 0) {
                                    fileOutputStream.write(bArr, 0, i);
                                } else {
                                    try {
                                        break;
                                    } catch (Throwable th) {
                                        r2 = uri;
                                        th = th;
                                        if (r2 != 0) {
                                            r2.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            fileInputStream.close();
                            fileOutputStream.close();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
                            if (outputStreamOpenOutputStream != null) {
                                outputStreamOpenOutputStream.close();
                                return true;
                            }
                            try {
                                promise.reject(new IOException("Failed to get output stream."));
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                                return false;
                            } catch (IOException e) {
                                e = e;
                                contentResolver.delete(null, null, null);
                                promise.reject(e);
                                if (outputStreamOpenOutputStream != null) {
                                    outputStreamOpenOutputStream.close();
                                }
                                return false;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            promise.reject(new IOException("Failed to get output stream."));
                            return false;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        outputStreamOpenOutputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused) {
                promise.reject("ReactNativeBlobUtil.createMediaFile", "Cannot write to file, file might not exist");
                return false;
            }
        } else {
            return ReactNativeBlobUtilFS.writeFile(ReactNativeBlobUtilUtils.normalizePath(uri.toString()), "uri", str, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:? A[SYNTHETIC] */
    public static void copyToInternal(Uri uri, String str, Promise promise) {
        FileOutputStream fileOutputStream;
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        File file = new File(str);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject("ReactNativeBlobUtil.copyToInternal: Cannot create parent folders<'" + str);
                    return;
                }
                if (!file.createNewFile()) {
                    promise.reject("ReactNativeBlobUtil.copyToInternal: Destination file at '" + str + "' already exists");
                    return;
                }
            } catch (IOException e) {
                promise.reject("ReactNativeBlobUtil.copyToInternal: Could not create file: " + e.getLocalizedMessage());
            }
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i > 0) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    inputStream = inputStreamOpenInputStream;
                    try {
                        promise.reject("ReactNativeBlobUtil.copyToInternal:  Could not write data: " + e.getLocalizedMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                        }
                        promise.resolve("");
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e8) {
            e = e8;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        promise.resolve("");
    }

    public static void getBlob(Uri uri, String str, Promise promise) {
        try {
            InputStream inputStreamOpenInputStream = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver().openInputStream(uri);
            int iAvailable = inputStreamOpenInputStream.available();
            byte[] bArr = new byte[iAvailable];
            int i = inputStreamOpenInputStream.read(bArr);
            inputStreamOpenInputStream.close();
            if (i < iAvailable) {
                promise.reject("EUNSPECIFIED", "Read only " + i + " bytes of " + iAvailable);
                return;
            }
            String lowerCase = str.toLowerCase();
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -1396204209) {
                if (iHashCode == 93106001 && lowerCase.equals("ascii")) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (int i2 = 0; i2 < iAvailable; i2++) {
                        writableArrayCreateArray.pushInt(bArr[i2]);
                    }
                    promise.resolve(writableArrayCreateArray);
                    return;
                }
            } else if (lowerCase.equals("base64")) {
                promise.resolve(Base64.encodeToString(bArr, 2));
                return;
            }
            promise.resolve(new String(bArr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.reactnativecommunity.asyncstorage;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AsyncStorageExpoMigration {
    public static void migrate(Context context) throws Throwable {
        ArrayList<File> expoDatabases;
        File lastModifiedFile;
        if (isAsyncStorageDatabaseCreated(context) || (lastModifiedFile = getLastModifiedFile((expoDatabases = getExpoDatabases(context)))) == null) {
            return;
        }
        try {
            ReactDatabaseSupplier.getInstance(context).get();
            copyFile(new FileInputStream(lastModifiedFile), new FileOutputStream(context.getDatabasePath("RKStorage")));
            lastModifiedFile.getName();
            try {
                for (File file : expoDatabases) {
                    if (file.delete()) {
                        file.getName();
                    } else {
                        file.getName();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            lastModifiedFile.getName();
            e2.printStackTrace();
        }
    }

    private static boolean isAsyncStorageDatabaseCreated(Context context) {
        return context.getDatabasePath("RKStorage").exists();
    }

    private static ArrayList getExpoDatabases(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrListFiles = context.getDatabasePath("noop").getParentFile().listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.getName().startsWith("RKStorage-scoped-experience-") && !file.getName().endsWith("-journal")) {
                        arrayList.add(file);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    private static File getLastModifiedFile(ArrayList arrayList) {
        File file = null;
        if (arrayList.size() == 0) {
            return null;
        }
        Iterator it = arrayList.iterator();
        long j = -1;
        while (it.hasNext()) {
            File file2 = (File) it.next();
            long lastModifiedTimeInMillis = getLastModifiedTimeInMillis(file2);
            if (lastModifiedTimeInMillis > j) {
                file = file2;
                j = lastModifiedTimeInMillis;
            }
        }
        return file != null ? file : (File) arrayList.get(0);
    }

    private static long getLastModifiedTimeInMillis(File file) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return getLastModifiedTimeFromBasicFileAttrs(file);
            }
            return file.lastModified();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    private static long getLastModifiedTimeFromBasicFileAttrs(File file) {
        try {
            return Files.readAttributes(file.toPath(), AsyncStorageExpoMigration$$ExternalSyntheticApiModelOutline0.m(), new LinkOption[0]).creationTime().toMillis();
        } catch (Exception unused) {
            return -1L;
        }
    }

    private static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws Throwable {
        Throwable th;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            FileChannel channel2 = fileInputStream.getChannel();
            try {
                channel = fileOutputStream.getChannel();
                try {
                    channel2.transferTo(0L, channel2.size(), channel);
                    try {
                        channel2.close();
                    } finally {
                        if (channel != null) {
                            channel.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel2;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } finally {
                            if (channel != null) {
                                channel.close();
                            }
                        }
                    }
                    if (channel != null) {
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                channel = null;
            }
        } catch (Throwable th4) {
            th = th4;
            channel = null;
        }
    }
}

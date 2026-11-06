package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY;
    public static final BigInteger ONE_EB_BI;
    public static final BigInteger ONE_GB_BI;
    public static final BigInteger ONE_KB_BI;
    public static final BigInteger ONE_MB_BI;
    public static final BigInteger ONE_PB_BI;
    public static final BigInteger ONE_TB_BI;
    public static final BigInteger ONE_YB;
    public static final BigInteger ONE_ZB;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
        ONE_KB_BI = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        ONE_MB_BI = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        ONE_GB_BI = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        ONE_TB_BI = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        ONE_PB_BI = bigIntegerMultiply4;
        ONE_EB_BI = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE).multiply(BigInteger.valueOf(1152921504606846976L));
        ONE_ZB = bigIntegerMultiply5;
        ONE_YB = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        EMPTY_FILE_ARRAY = new File[0];
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        doCopyFile(file, file2, z);
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            if (j2 > 31457280) {
                                j2 = 31457280;
                            }
                            long jTransferFrom = channel2.transferFrom(channel, j, j2);
                            if (jTransferFrom == 0) {
                                break;
                            } else {
                                j += jTransferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (channel2 == null) {
                                throw th2;
                            }
                            try {
                                channel2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                if (channel == null) {
                                    throw th4;
                                }
                                try {
                                    channel.close();
                                    throw th4;
                                } catch (Throwable th5) {
                                    th.addSuppressed(th5);
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        try {
                            fileOutputStream.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th6.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
            } catch (Throwable th9) {
                throw th9;
            }
        } catch (Throwable th10) {
            try {
                throw th10;
            } catch (Throwable th11) {
                try {
                    fileInputStream.close();
                    throw th11;
                } catch (Throwable th12) {
                    th10.addSuppressed(th12);
                    throw th11;
                }
            }
        }
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        copyDirectory(file, file2, null, z);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        ArrayList arrayList;
        checkFileRequirements(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(fileArrListFiles.length);
                for (File file3 : fileArrListFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
            }
        } else {
            arrayList = null;
        }
        doCopyDirectory(file, file2, fileFilter, z, arrayList);
    }

    private static void checkFileRequirements(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z, List list) throws IOException {
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    doCopyDirectory(file3, file4, fileFilter, z, list);
                } else {
                    doCopyFile(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        IOException e = null;
        for (File file2 : verifiedListFiles(file)) {
            try {
                forceDelete(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            return fileArrListFiles;
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!zExists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static boolean isSymlink(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        return Files.isSymbolicLink(file.toPath());
    }
}

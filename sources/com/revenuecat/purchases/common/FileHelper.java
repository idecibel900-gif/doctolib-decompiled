package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J(\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00060\u0014J.\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/common/FileHelper;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appendToFile", "", "filePath", "", "contentToAppend", "deleteFile", "", "fileIsEmpty", "fileSizeInKB", "", "getFileInFilesDir", "Ljava/io/File;", "getFilesDir", "openBufferedReader", "contentBlock", "Lkotlin/Function1;", "Ljava/io/BufferedReader;", "readFilePerLines", "block", "Lkotlin/sequences/Sequence;", "removeFirstLinesFromFile", "numberOfLinesToRemove", "", "onException", "", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileHelper {
    private final Context applicationContext;

    public FileHelper(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    public final double fileSizeInKB(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return FileExtensionsKt.getSizeInKB(getFileInFilesDir(filePath));
    }

    public final void appendToFile(String filePath, String contentToAppend) throws IOException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(contentToAppend, "contentToAppend");
        File fileInFilesDir = getFileInFilesDir(filePath);
        File parentFile = fileInFilesDir.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileInFilesDir, true);
        try {
            byte[] bytes = contentToAppend.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public final boolean deleteFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return getFileInFilesDir(filePath).delete();
    }

    public final void readFilePerLines(String filePath, final Function1 block) throws IOException {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(block, "block");
        openBufferedReader(filePath, new Function1() { // from class: com.revenuecat.purchases.common.FileHelper.readFilePerLines.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BufferedReader) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(BufferedReader bufferedReader) {
                Intrinsics.checkNotNullParameter(bufferedReader, "bufferedReader");
                block.invoke(TextStreamsKt.lineSequence(bufferedReader));
            }
        });
    }

    public static /* synthetic */ void removeFirstLinesFromFile$default(FileHelper fileHelper, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        fileHelper.removeFirstLinesFromFile(str, i, function1);
    }

    public final void removeFirstLinesFromFile(String filePath, final int numberOfLinesToRemove, Function1 onException) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            final StringBuilder sb = new StringBuilder();
            readFilePerLines(filePath, new Function1() { // from class: com.revenuecat.purchases.common.FileHelper.removeFirstLinesFromFile.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Sequence) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Sequence sequence) {
                    Intrinsics.checkNotNullParameter(sequence, "sequence");
                    Sequence sequenceDrop = SequencesKt.drop(sequence, numberOfLinesToRemove);
                    StringBuilder sb2 = sb;
                    Iterator it = sequenceDrop.iterator();
                    while (it.hasNext()) {
                        sb2.append((String) it.next());
                        sb2.append("\n");
                    }
                }
            });
            deleteFile(filePath);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "textToAppend.toString()");
            appendToFile(filePath, string);
        } catch (FileNotFoundException e) {
            if (onException != null) {
                onException.invoke(e);
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "FileHelper: file not found when trying to remove first lines from file: " + filePath + ". Ignoring.", e);
        } catch (Throwable th) {
            if (onException != null) {
                onException.invoke(th);
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "FileHelper: error removing first lines from file: " + filePath + ". Ignoring.", th);
            throw th;
        }
    }

    public final boolean fileIsEmpty(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File fileInFilesDir = getFileInFilesDir(filePath);
        return !fileInFilesDir.exists() || fileInFilesDir.length() == 0;
    }

    private final void openBufferedReader(String filePath, Function1 contentBlock) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(getFileInFilesDir(filePath));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    contentBlock.invoke(bufferedReader);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStreamReader, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamReader, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(fileInputStream, th5);
                throw th6;
            }
        }
    }

    private final File getFileInFilesDir(String filePath) {
        return new File(getFilesDir(), filePath);
    }

    private final File getFilesDir() {
        File filesDir = this.applicationContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "applicationContext.filesDir");
        return filesDir;
    }
}

package com.revenuecat.purchases.utils;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"BYTE_UNIT_CONVERSION", "", "sizeInBytes", "", "Ljava/io/File;", "getSizeInBytes", "(Ljava/io/File;)J", "sizeInKB", "getSizeInKB", "(Ljava/io/File;)D", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FileExtensionsKt {
    private static final double BYTE_UNIT_CONVERSION = 1024.0d;

    public static final long getSizeInBytes(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return file.length();
    }

    public static final double getSizeInKB(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return getSizeInBytes(file) / BYTE_UNIT_CONVERSION;
    }
}

package com.datadog.android.core.internal.persistence.file.batch;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface BatchFileReader {
    List readData(File file);
}

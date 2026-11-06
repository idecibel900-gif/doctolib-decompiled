package coil.disk;

import coil.util.FileSystems;
import com.amazon.a.a.o.c.a.b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;

/* JADX INFO: loaded from: classes3.dex */
public final class DiskLruCache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    private final int appVersion;
    private final CoroutineScope cleanupScope;
    private boolean closed;
    private final Path directory;
    private final DiskLruCache$fileSystem$1 fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final Path journalFile;
    private final Path journalFileBackup;
    private final Path journalFileTmp;
    private BufferedSink journalWriter;
    private final LinkedHashMap lruEntries;
    private final long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private int operationsSinceRewrite;
    private long size;
    private final int valueCount;

    /* JADX WARN: Type inference failed for: r4v9, types: [coil.disk.DiskLruCache$fileSystem$1] */
    public DiskLruCache(final FileSystem fileSystem, Path path, CoroutineDispatcher coroutineDispatcher, long j, int i, int i2) {
        this.directory = path;
        this.maxSize = j;
        this.appVersion = i;
        this.valueCount = i2;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        this.journalFile = path.resolve("journal");
        this.journalFileTmp = path.resolve("journal.tmp");
        this.journalFileBackup = path.resolve("journal.bkp");
        this.lruEntries = new LinkedHashMap(0, 0.75f, true);
        this.cleanupScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(coroutineDispatcher.limitedParallelism(1)));
        this.fileSystem = new ForwardingFileSystem(fileSystem) { // from class: coil.disk.DiskLruCache$fileSystem$1
            @Override // okio.ForwardingFileSystem, okio.FileSystem
            public Sink sink(Path path2, boolean z) {
                Path pathParent = path2.parent();
                if (pathParent != null) {
                    createDirectories(pathParent);
                }
                return super.sink(path2, z);
            }
        };
    }

    public final synchronized void initialize() {
        try {
            if (this.initialized) {
                return;
            }
            delete(this.journalFileTmp);
            if (exists(this.journalFileBackup)) {
                if (exists(this.journalFile)) {
                    delete(this.journalFileBackup);
                } else {
                    atomicMove(this.journalFileBackup, this.journalFile);
                }
            }
            if (exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException unused) {
                    try {
                        delete();
                        this.closed = false;
                        writeJournal();
                        this.initialized = true;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            writeJournal();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c8  */
    private final void readJournal() throws Throwable {
        Unit unit;
        BufferedSource bufferedSourceBuffer = Okio.buffer(source(this.journalFile));
        Throwable th = null;
        try {
            String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!Intrinsics.areEqual("libcore.io.DiskLruCache", utf8LineStrict) || !Intrinsics.areEqual("1", utf8LineStrict2) || !Intrinsics.areEqual(String.valueOf(this.appVersion), utf8LineStrict3) || !Intrinsics.areEqual(String.valueOf(this.valueCount), utf8LineStrict4) || utf8LineStrict5.length() > 0) {
                throw new IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict3 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + ']');
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(bufferedSourceBuffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.operationsSinceRewrite = i - this.lruEntries.size();
                    if (!bufferedSourceBuffer.exhausted()) {
                        writeJournal();
                    } else {
                        this.journalWriter = newJournalWriter();
                    }
                    unit = Unit.INSTANCE;
                    if (bufferedSourceBuffer != null) {
                        try {
                            bufferedSourceBuffer.close();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    if (th == null) {
                        Intrinsics.checkNotNull(unit);
                        return;
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th3, th4);
                }
            }
            th = th3;
            unit = null;
            if (th == null) {
                Intrinsics.checkNotNull(unit);
                return;
            }
            throw th;
        }
    }

    private final BufferedSink newJournalWriter() {
        return Okio.buffer(new FaultHidingSink(appendingSink(this.journalFile), new Function1() { // from class: coil.disk.DiskLruCache$newJournalWriter$faultHidingSink$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((IOException) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(IOException iOException) {
                this.this$0.hasJournalErrors = true;
            }
        }));
    }

    private final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, ' ', 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf$default + 1;
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, ' ', i, false, 4, (Object) null);
        if (iIndexOf$default2 == -1) {
            strSubstring = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (iIndexOf$default == 6 && StringsKt.startsWith$default(str, "REMOVE", false, 2, (Object) null)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        LinkedHashMap linkedHashMap = this.lruEntries;
        Object entry = linkedHashMap.get(strSubstring);
        if (entry == null) {
            entry = new Entry(strSubstring);
            linkedHashMap.put(strSubstring, entry);
        }
        Entry entry2 = (Entry) entry;
        if (iIndexOf$default2 != -1 && iIndexOf$default == 5 && StringsKt.startsWith$default(str, "CLEAN", false, 2, (Object) null)) {
            String strSubstring2 = str.substring(iIndexOf$default2 + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            List listSplit$default = StringsKt.split$default((CharSequence) strSubstring2, new char[]{' '}, false, 0, 6, (Object) null);
            entry2.setReadable(true);
            entry2.setCurrentEditor(null);
            entry2.setLengths(listSplit$default);
            return;
        }
        if (iIndexOf$default2 == -1 && iIndexOf$default == 5 && StringsKt.startsWith$default(str, "DIRTY", false, 2, (Object) null)) {
            entry2.setCurrentEditor(new Editor(entry2));
            return;
        }
        if (iIndexOf$default2 == -1 && iIndexOf$default == 4 && StringsKt.startsWith$default(str, "READ", false, 2, (Object) null)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final void processJournal() {
        Iterator it = this.lruEntries.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i = 0;
            if (entry.getCurrentEditor() == null) {
                int i2 = this.valueCount;
                while (i < i2) {
                    j += entry.getLengths()[i];
                    i++;
                }
            } else {
                entry.setCurrentEditor(null);
                int i3 = this.valueCount;
                while (i < i3) {
                    delete((Path) entry.getCleanFiles().get(i));
                    delete((Path) entry.getDirtyFiles().get(i));
                    i++;
                }
                it.remove();
            }
        }
        this.size = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void writeJournal() {
        Unit unit;
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            BufferedSink bufferedSinkBuffer = Okio.buffer(sink(this.journalFileTmp, false));
            Throwable th = null;
            try {
                bufferedSinkBuffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                bufferedSinkBuffer.writeUtf8("1").writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.appVersion).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.valueCount).writeByte(10);
                bufferedSinkBuffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor() != null) {
                        bufferedSinkBuffer.writeUtf8("DIRTY");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(entry.getKey());
                        bufferedSinkBuffer.writeByte(10);
                    } else {
                        bufferedSinkBuffer.writeUtf8("CLEAN");
                        bufferedSinkBuffer.writeByte(32);
                        bufferedSinkBuffer.writeUtf8(entry.getKey());
                        entry.writeLengths(bufferedSinkBuffer);
                        bufferedSinkBuffer.writeByte(10);
                    }
                }
                unit = Unit.INSTANCE;
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                unit = null;
                th = th3;
            }
            if (th == null) {
                Intrinsics.checkNotNull(unit);
                if (exists(this.journalFile)) {
                    atomicMove(this.journalFile, this.journalFileBackup);
                    atomicMove(this.journalFileTmp, this.journalFile);
                    delete(this.journalFileBackup);
                } else {
                    atomicMove(this.journalFileTmp, this.journalFile);
                }
                this.journalWriter = newJournalWriter();
                this.operationsSinceRewrite = 0;
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } else {
                throw th;
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public final synchronized Snapshot get(String str) {
        Snapshot snapshot;
        checkNotClosed();
        validateKey(str);
        initialize();
        Entry entry = (Entry) this.lruEntries.get(str);
        if (entry != null && (snapshot = entry.snapshot()) != null) {
            this.operationsSinceRewrite++;
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.writeUtf8("READ");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            if (journalRewriteRequired()) {
                launchCleanup();
            }
            return snapshot;
        }
        return null;
    }

    public final synchronized Editor edit(String str) {
        checkNotClosed();
        validateKey(str);
        initialize();
        Entry entry = (Entry) this.lruEntries.get(str);
        if ((entry != null ? entry.getCurrentEditor() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSnapshotCount() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(str);
                this.lruEntries.put(str, entry);
            }
            Editor editor = new Editor(entry);
            entry.setCurrentEditor(editor);
            return editor;
        }
        launchCleanup();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void completeEdit(Editor editor, boolean z) {
        Entry entry = editor.getEntry();
        if (!Intrinsics.areEqual(entry.getCurrentEditor(), editor)) {
            throw new IllegalStateException("Check failed.");
        }
        int i = 0;
        if (z && !entry.getZombie()) {
            int i2 = this.valueCount;
            for (int i3 = 0; i3 < i2; i3++) {
                if (editor.getWritten()[i3] && !exists((Path) entry.getDirtyFiles().get(i3))) {
                    editor.abort();
                    return;
                }
            }
            int i4 = this.valueCount;
            while (i < i4) {
                Path path = (Path) entry.getDirtyFiles().get(i);
                Path path2 = (Path) entry.getCleanFiles().get(i);
                if (exists(path)) {
                    atomicMove(path, path2);
                } else {
                    FileSystems.createFile(this.fileSystem, (Path) entry.getCleanFiles().get(i));
                }
                long j = entry.getLengths()[i];
                Long size = metadata(path2).getSize();
                long jLongValue = size != null ? size.longValue() : 0L;
                entry.getLengths()[i] = jLongValue;
                this.size = (this.size - j) + jLongValue;
                i++;
            }
        } else {
            int i5 = this.valueCount;
            while (i < i5) {
                delete((Path) entry.getDirtyFiles().get(i));
                i++;
            }
        }
        entry.setCurrentEditor(null);
        if (entry.getZombie()) {
            removeEntry(entry);
            return;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        if (z || entry.getReadable()) {
            entry.setReadable(true);
            bufferedSink.writeUtf8("CLEAN");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            entry.writeLengths(bufferedSink);
            bufferedSink.writeByte(10);
        } else {
            this.lruEntries.remove(entry.getKey());
            bufferedSink.writeUtf8("REMOVE");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
        }
        bufferedSink.flush();
        if (this.size > this.maxSize || journalRewriteRequired()) {
            launchCleanup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRewriteRequired() {
        return this.operationsSinceRewrite >= 2000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean removeEntry(Entry entry) {
        BufferedSink bufferedSink;
        if (entry.getLockingSnapshotCount() > 0 && (bufferedSink = this.journalWriter) != null) {
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(entry.getKey());
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.getLockingSnapshotCount() > 0 || entry.getCurrentEditor() != null) {
            entry.setZombie(true);
            return true;
        }
        int i = this.valueCount;
        for (int i2 = 0; i2 < i; i2++) {
            delete((Path) entry.getCleanFiles().get(i2));
            this.size -= entry.getLengths()[i2];
            entry.getLengths()[i2] = 0;
        }
        this.operationsSinceRewrite++;
        BufferedSink bufferedSink2 = this.journalWriter;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(entry.getKey());
            bufferedSink2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey());
        if (journalRewriteRequired()) {
            launchCleanup();
        }
        return true;
    }

    private final void checkNotClosed() {
        if (this.closed) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[0])) {
                    Editor currentEditor = entry.getCurrentEditor();
                    if (currentEditor != null) {
                        currentEditor.detach();
                    }
                }
                trimToSize();
                CoroutineScopeKt.cancel$default(this.cleanupScope, null, 1, null);
                BufferedSink bufferedSink = this.journalWriter;
                Intrinsics.checkNotNull(bufferedSink);
                bufferedSink.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize() {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie()) {
                removeEntry(entry);
                return true;
            }
        }
        return false;
    }

    private final void delete() throws IOException {
        close();
        FileSystems.deleteContents(this.fileSystem, this.directory);
    }

    /* JADX INFO: renamed from: coil.disk.DiskLruCache$launchCleanup$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DiskLruCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (diskLruCache.initialized && !diskLruCache.closed) {
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        if (diskLruCache.journalRewriteRequired()) {
                            diskLruCache.writeJournal();
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        diskLruCache.journalWriter = Okio.buffer(Okio.blackhole());
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void launchCleanup() {
        BuildersKt__Builders_commonKt.launch$default(this.cleanupScope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void validateKey(String str) {
        if (LEGAL_KEY_PATTERN.matches(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    public final class Snapshot implements Closeable {
        private boolean closed;
        private final Entry entry;

        public Snapshot(Entry entry) {
            this.entry = entry;
        }

        public final Path file(int i) {
            if (this.closed) {
                throw new IllegalStateException("snapshot is closed");
            }
            return (Path) this.entry.getCleanFiles().get(i);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    Entry entry = this.entry;
                    entry.setLockingSnapshotCount(entry.getLockingSnapshotCount() - 1);
                    if (this.entry.getLockingSnapshotCount() == 0 && this.entry.getZombie()) {
                        diskLruCache.removeEntry(this.entry);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Editor closeAndEdit() {
            Editor editorEdit;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                close();
                editorEdit = diskLruCache.edit(this.entry.getKey());
            }
            return editorEdit;
        }
    }

    public final class Editor {
        private boolean closed;
        private final Entry entry;
        private final boolean[] written;

        public Editor(Entry entry) {
            this.entry = entry;
            this.written = new boolean[DiskLruCache.this.valueCount];
        }

        public final Entry getEntry() {
            return this.entry;
        }

        public final boolean[] getWritten() {
            return this.written;
        }

        public final Path file(int i) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (this.closed) {
                    throw new IllegalStateException("editor is closed");
                }
                this.written[i] = true;
                Object obj = this.entry.getDirtyFiles().get(i);
                FileSystems.createFile(diskLruCache.fileSystem, (Path) obj);
                path = (Path) obj;
            }
            return path;
        }

        public final void detach() {
            if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                this.entry.setZombie(true);
            }
        }

        public final void commit() {
            complete(true);
        }

        public final Snapshot commitAndGet() {
            Snapshot snapshot;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                commit();
                snapshot = diskLruCache.get(this.entry.getKey());
            }
            return snapshot;
        }

        public final void abort() {
            complete(false);
        }

        private final void complete(boolean z) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                try {
                    if (this.closed) {
                        throw new IllegalStateException("editor is closed");
                    }
                    if (Intrinsics.areEqual(this.entry.getCurrentEditor(), this)) {
                        diskLruCache.completeEdit(this, z);
                    }
                    this.closed = true;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class Entry {
        private final ArrayList cleanFiles;
        private Editor currentEditor;
        private final ArrayList dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSnapshotCount;
        private boolean readable;
        private boolean zombie;

        public Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.valueCount];
            this.cleanFiles = new ArrayList(DiskLruCache.this.valueCount);
            this.dirtyFiles = new ArrayList(DiskLruCache.this.valueCount);
            StringBuilder sb = new StringBuilder(str);
            sb.append(b.a);
            int length = sb.length();
            int i = DiskLruCache.this.valueCount;
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(i2);
                this.cleanFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(DiskLruCache.this.directory.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final String getKey() {
            return this.key;
        }

        public final long[] getLengths() {
            return this.lengths;
        }

        public final ArrayList getCleanFiles() {
            return this.cleanFiles;
        }

        public final ArrayList getDirtyFiles() {
            return this.dirtyFiles;
        }

        public final boolean getReadable() {
            return this.readable;
        }

        public final void setReadable(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie() {
            return this.zombie;
        }

        public final void setZombie(boolean z) {
            this.zombie = z;
        }

        public final Editor getCurrentEditor() {
            return this.currentEditor;
        }

        public final void setCurrentEditor(Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSnapshotCount() {
            return this.lockingSnapshotCount;
        }

        public final void setLockingSnapshotCount(int i) {
            this.lockingSnapshotCount = i;
        }

        public final void setLengths(List list) throws IOException {
            if (list.size() != DiskLruCache.this.valueCount) {
                throw new IOException("unexpected journal line: " + list);
            }
            try {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    this.lengths[i] = Long.parseLong((String) list.get(i));
                }
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + list);
            }
        }

        public final void writeLengths(BufferedSink bufferedSink) {
            for (long j : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }

        public final Snapshot snapshot() {
            if (!this.readable || this.currentEditor != null || this.zombie) {
                return null;
            }
            ArrayList arrayList = this.cleanFiles;
            DiskLruCache diskLruCache = DiskLruCache.this;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!diskLruCache.fileSystem.exists((Path) arrayList.get(i))) {
                    try {
                        diskLruCache.removeEntry(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            this.lockingSnapshotCount++;
            return DiskLruCache.this.new Snapshot(this);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

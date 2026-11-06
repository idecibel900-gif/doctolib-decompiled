package io.sentry.android.core.internal.tombstone;

import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0;
import com.abovevacant.epitaph.core.BacktraceFrame;
import com.abovevacant.epitaph.core.MemoryMapping;
import com.abovevacant.epitaph.core.Register;
import com.abovevacant.epitaph.core.Signal;
import com.abovevacant.epitaph.core.Tombstone;
import com.abovevacant.epitaph.core.TombstoneThread;
import com.abovevacant.epitaph.wire.TombstoneDecoder;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryStackTraceFactory;
import io.sentry.android.core.internal.util.NativeEventUtils;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.Message;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import net.openid.appauth.RegistrationRequest;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes5.dex */
public class TombstoneParser implements Closeable {
    private final Map excTypeValueMap;
    private final List inAppExcludes;
    private final List inAppIncludes;
    private final String nativeLibraryDir;
    private final InputStream tombstoneStream;

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatHex(long j) {
        return String.format("0x%x", Long.valueOf(j));
    }

    public TombstoneParser(InputStream inputStream, List list, List list2, String str) {
        HashMap map = new HashMap();
        this.excTypeValueMap = map;
        this.tombstoneStream = inputStream;
        this.inAppIncludes = list;
        this.inAppExcludes = list2;
        this.nativeLibraryDir = str;
        map.put("SIGILL", "IllegalInstruction");
        map.put("SIGTRAP", "Trap");
        map.put("SIGABRT", "Abort");
        map.put("SIGBUS", "BusError");
        map.put("SIGFPE", "FloatingPointException");
        map.put("SIGSEGV", "Segfault");
    }

    public SentryEvent parse() throws IOException {
        InputStream inputStream = this.tombstoneStream;
        if (inputStream == null) {
            throw new IOException("No InputStream provided; use parse(Tombstone) instead.");
        }
        return parse(TombstoneDecoder.decode(inputStream));
    }

    public SentryEvent parse(Tombstone tombstone) {
        SentryEvent sentryEvent = new SentryEvent();
        sentryEvent.setLevel(SentryLevel.FATAL);
        sentryEvent.setPlatform(RegistrationRequest.APPLICATION_TYPE_NATIVE);
        sentryEvent.setMessage(constructMessage(tombstone));
        sentryEvent.setDebugMeta(createDebugMeta(tombstone));
        sentryEvent.setExceptions(createException(tombstone));
        List exceptions = sentryEvent.getExceptions();
        Objects.requireNonNull(exceptions);
        sentryEvent.setThreads(createThreads(tombstone, (SentryException) exceptions.get(0)));
        return sentryEvent;
    }

    private List createThreads(Tombstone tombstone, SentryException sentryException) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : tombstone.threads.entrySet()) {
            TombstoneThread tombstoneThread = (TombstoneThread) entry.getValue();
            SentryThread sentryThread = new SentryThread();
            sentryThread.setId(Long.valueOf(((Integer) entry.getKey()).intValue()));
            sentryThread.setName(tombstoneThread.name);
            SentryStackTrace sentryStackTraceCreateStackTrace = createStackTrace(tombstoneThread);
            sentryThread.setStacktrace(sentryStackTraceCreateStackTrace);
            if (tombstone.tid == tombstoneThread.id) {
                sentryThread.setCrashed(Boolean.TRUE);
                sentryException.setStacktrace(sentryStackTraceCreateStackTrace);
            }
            arrayList.add(sentryThread);
        }
        return arrayList;
    }

    private SentryStackTrace createStackTrace(TombstoneThread tombstoneThread) {
        Boolean boolIsInApp;
        ArrayList arrayList = new ArrayList();
        for (BacktraceFrame backtraceFrame : tombstoneThread.backtrace) {
            if (!backtraceFrame.fileName.endsWith("libart.so") && (!backtraceFrame.fileName.startsWith("<anonymous") || !backtraceFrame.functionName.isEmpty())) {
                SentryStackFrame sentryStackFrame = new SentryStackFrame();
                sentryStackFrame.setPackage(backtraceFrame.fileName);
                sentryStackFrame.setFunction(backtraceFrame.functionName);
                sentryStackFrame.setInstructionAddr(formatHex(backtraceFrame.pc));
                String str = backtraceFrame.functionName;
                if (str.isEmpty()) {
                    boolIsInApp = Boolean.FALSE;
                } else {
                    boolIsInApp = SentryStackTraceFactory.isInApp(str, this.inAppIncludes, this.inAppExcludes);
                }
                String str2 = this.nativeLibraryDir;
                boolean z = true;
                boolean z2 = str2 != null && backtraceFrame.fileName.startsWith(str2);
                if ((boolIsInApp == null || !boolIsInApp.booleanValue()) && !z2) {
                    z = false;
                }
                sentryStackFrame.setInApp(Boolean.valueOf(z));
                arrayList.add(0, sentryStackFrame);
            }
        }
        SentryStackTrace sentryStackTrace = new SentryStackTrace();
        sentryStackTrace.setFrames(arrayList);
        sentryStackTrace.setInstructionAddressAdjustment(SentryStackTrace.InstructionAddressAdjustment.NONE);
        HashMap map = new HashMap();
        for (Register register : tombstoneThread.registers) {
            map.put(register.name, formatHex(register.value));
        }
        sentryStackTrace.setRegisters(map);
        return sentryStackTrace;
    }

    private List createException(Tombstone tombstone) {
        SentryException sentryException = new SentryException();
        if (tombstone.hasSignal()) {
            Signal signal = tombstone.signal;
            sentryException.setType(signal.name);
            sentryException.setValue((String) this.excTypeValueMap.get(signal.name));
            sentryException.setMechanism(createMechanismFromSignalInfo(signal));
        }
        sentryException.setThreadId(Long.valueOf(tombstone.tid));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(sentryException);
        return arrayList;
    }

    private static Mechanism createMechanismFromSignalInfo(Signal signal) {
        Mechanism mechanism = new Mechanism();
        mechanism.setType(NativeExceptionMechanism.TOMBSTONE.getValue());
        mechanism.setHandled(Boolean.FALSE);
        mechanism.setSynthetic(Boolean.TRUE);
        HashMap map = new HashMap();
        map.put("number", Integer.valueOf(signal.number));
        map.put("name", signal.name);
        map.put(ResponseTypeValues.CODE, Integer.valueOf(signal.code));
        map.put("code_name", signal.codeName);
        mechanism.setMeta(map);
        return mechanism;
    }

    private Message constructMessage(Tombstone tombstone) {
        String str;
        Message message = new Message();
        Signal signal = tombstone.signal;
        String strM = HlsMediaPlaylist$Interstitial$Builder$$ExternalSyntheticBackport0.m(" ", tombstone.commandLine);
        if (tombstone.hasSignal()) {
            String str2 = tombstone.abortMessage;
            Locale locale = Locale.ROOT;
            if (str2.isEmpty()) {
                str = "";
            } else {
                str = str2 + ": ";
            }
            message.setFormatted(String.format(locale, "%sFatal signal %s (%d), %s (%d), pid = %d (%s)", str, signal.name, Integer.valueOf(signal.number), signal.codeName, Integer.valueOf(signal.code), Integer.valueOf(tombstone.pid), strM));
            return message;
        }
        message.setFormatted(String.format(Locale.ROOT, "Fatal exit pid = %d (%s)", Integer.valueOf(tombstone.pid), strM));
        return message;
    }

    private static class ModuleAccumulator {
        long beginAddress;
        String buildId;
        long endAddress;
        String mappingName;

        ModuleAccumulator(MemoryMapping memoryMapping) {
            this.mappingName = memoryMapping.mappingName;
            this.buildId = memoryMapping.buildId;
            this.beginAddress = memoryMapping.beginAddress;
            this.endAddress = memoryMapping.endAddress;
        }

        void extendTo(long j) {
            this.endAddress = j;
        }

        DebugImage toDebugImage() {
            if (this.buildId.isEmpty()) {
                return null;
            }
            DebugImage debugImage = new DebugImage();
            debugImage.setCodeId(this.buildId);
            debugImage.setCodeFile(this.mappingName);
            String strBuildIdToDebugId = NativeEventUtils.buildIdToDebugId(this.buildId);
            if (strBuildIdToDebugId == null) {
                strBuildIdToDebugId = this.buildId;
            }
            debugImage.setDebugId(strBuildIdToDebugId);
            debugImage.setImageAddr(TombstoneParser.formatHex(this.beginAddress));
            debugImage.setImageSize(this.endAddress - this.beginAddress);
            debugImage.setType("elf");
            return debugImage;
        }
    }

    private DebugMeta createDebugMeta(Tombstone tombstone) {
        DebugImage debugImage;
        DebugImage debugImage2;
        ArrayList arrayList = new ArrayList();
        ModuleAccumulator moduleAccumulator = null;
        for (MemoryMapping memoryMapping : tombstone.memoryMappings) {
            if (memoryMapping.read) {
                String str = memoryMapping.mappingName;
                if (!str.isEmpty() && !str.startsWith("/dev/")) {
                    boolean zIsEmpty = memoryMapping.buildId.isEmpty();
                    boolean z = memoryMapping.offset == 0;
                    if (!zIsEmpty && z) {
                        if (moduleAccumulator != null && str.equals(moduleAccumulator.mappingName)) {
                            moduleAccumulator.extendTo(memoryMapping.endAddress);
                        } else {
                            if (moduleAccumulator != null && (debugImage2 = moduleAccumulator.toDebugImage()) != null) {
                                arrayList.add(debugImage2);
                            }
                            moduleAccumulator = new ModuleAccumulator(memoryMapping);
                        }
                    } else if (moduleAccumulator != null && str.equals(moduleAccumulator.mappingName)) {
                        moduleAccumulator.extendTo(memoryMapping.endAddress);
                    }
                }
            }
        }
        if (moduleAccumulator != null && (debugImage = moduleAccumulator.toDebugImage()) != null) {
            arrayList.add(debugImage);
        }
        DebugMeta debugMeta = new DebugMeta();
        debugMeta.setImages(arrayList);
        return debugMeta;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.tombstoneStream;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}

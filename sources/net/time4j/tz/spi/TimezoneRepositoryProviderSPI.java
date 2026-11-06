package net.time4j.tz.spi;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.base.ResourceLoader;
import net.time4j.scale.LeapSecondProvider;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZoneModelProvider;
import net.time4j.tz.ZoneNameProvider;

/* JADX INFO: loaded from: classes5.dex */
public class TimezoneRepositoryProviderSPI implements ZoneModelProvider, LeapSecondProvider {
    private final Map aliases;
    private final Map data;
    private final PlainDate expires;
    private final Map leapsecs;
    private final String location;
    private final String version;

    @Override // net.time4j.tz.ZoneModelProvider
    public ZoneNameProvider getSpecificZoneNameRepository() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0208  */
    /* JADX WARN: Code duplicated, block: B:81:0x021b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public TimezoneRepositoryProviderSPI() throws Throwable {
        String str;
        String string;
        InputStream inputStream;
        IllegalStateException illegalStateException;
        String str2;
        URI uriLocate;
        InputStream inputStream2;
        String str3 = "";
        PlainDate plainDateOf = (PlainDate) PlainDate.axis().getMinimum();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        boolean z = System.getProperty("net.time4j.scale.leapseconds.path") != null;
        if (z) {
            this.leapsecs = Collections.EMPTY_MAP;
        } else {
            this.leapsecs = new LinkedHashMap(50);
        }
        String property = System.getProperty("net.time4j.tz.repository.path");
        String property2 = System.getProperty("net.time4j.tz.repository.version");
        String str4 = property2 == null ? "tzdata.repository" : "tzdata" + property2 + ".repository";
        try {
            try {
                String str5 = "tzrepo/" + str4;
                if (property == null) {
                    uriLocate = ResourceLoader.getInstance().locate("tzdata", getReference(), str5);
                } else {
                    try {
                        File file = new File(property, str4);
                        if (!file.isAbsolute()) {
                            uriLocate = ResourceLoader.getInstance().locate("tzdata", getReference(), file.toString());
                        } else if (file.exists()) {
                            uriLocate = file.toURI();
                        } else {
                            throw new FileNotFoundException("Path to tz-repository not found: " + file);
                        }
                    } catch (IOException e) {
                        e = e;
                        string = "";
                        str = string;
                        inputStream = null;
                        try {
                            IllegalStateException illegalStateException2 = new IllegalStateException("[ERROR] TZ-repository not available. => " + e.getMessage(), e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            illegalStateException = illegalStateException2;
                            str2 = str;
                            if (illegalStateException != null) {
                                throw illegalStateException;
                            }
                            this.version = str2;
                            this.location = string;
                            this.data = Collections.unmodifiableMap(map);
                            this.aliases = Collections.unmodifiableMap(map2);
                            this.expires = plainDateOf;
                        } catch (Throwable th) {
                            th = th;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (uriLocate == null) {
                    string = "";
                    inputStream2 = null;
                } else {
                    inputStream2 = ResourceLoader.getInstance().load(uriLocate, true);
                    try {
                        try {
                            string = uriLocate.toString();
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStream2;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        string = "";
                        str = string;
                        inputStream = inputStream2;
                        IllegalStateException illegalStateException3 = new IllegalStateException("[ERROR] TZ-repository not available. => " + e.getMessage(), e);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        illegalStateException = illegalStateException3;
                        str2 = str;
                        if (illegalStateException != null) {
                            throw illegalStateException;
                        }
                        this.version = str2;
                        this.location = string;
                        this.data = Collections.unmodifiableMap(map);
                        this.aliases = Collections.unmodifiableMap(map2);
                        this.expires = plainDateOf;
                    }
                }
                if (inputStream2 == null) {
                    try {
                        URL resource = getReference().getClassLoader().getResource(str5);
                        if (resource == null) {
                            throw new FileNotFoundException("Classloader cannot access tz-repository: " + str5);
                        }
                        URLConnection uRLConnectionOpenConnection = resource.openConnection();
                        uRLConnectionOpenConnection.setUseCaches(false);
                        uRLConnectionOpenConnection.connect();
                        inputStream2 = uRLConnectionOpenConnection.getInputStream();
                        string = resource.toString();
                    } catch (IOException e3) {
                        e = e3;
                        str = "";
                        inputStream = inputStream2;
                        IllegalStateException illegalStateException4 = new IllegalStateException("[ERROR] TZ-repository not available. => " + e.getMessage(), e);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        illegalStateException = illegalStateException4;
                        str2 = str;
                        if (illegalStateException != null) {
                            throw illegalStateException;
                        }
                        this.version = str2;
                        this.location = string;
                        this.data = Collections.unmodifiableMap(map);
                        this.aliases = Collections.unmodifiableMap(map2);
                        this.expires = plainDateOf;
                    }
                }
                DataInputStream dataInputStream = new DataInputStream(inputStream2);
                checkMagicLabel(dataInputStream, string);
                String utf = dataInputStream.readUTF();
                int i = dataInputStream.readInt();
                ArrayList arrayList = new ArrayList(i);
                int i2 = 0;
                while (i2 < i) {
                    String utf2 = dataInputStream.readUTF();
                    int i3 = dataInputStream.readInt();
                    byte[] bArr = new byte[i3];
                    boolean z2 = z;
                    str = str3;
                    int i4 = 0;
                    do {
                        try {
                            i4 += dataInputStream.read(bArr, i4, i3 - i4);
                            if (i4 == -1) {
                                throw new EOFException("Incomplete data: " + utf2);
                            }
                        } catch (IOException e4) {
                            e = e4;
                            inputStream = inputStream2;
                            IllegalStateException illegalStateException5 = new IllegalStateException("[ERROR] TZ-repository not available. => " + e.getMessage(), e);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            illegalStateException = illegalStateException5;
                            str2 = str;
                            if (illegalStateException != null) {
                                throw illegalStateException;
                            }
                            this.version = str2;
                            this.location = string;
                            this.data = Collections.unmodifiableMap(map);
                            this.aliases = Collections.unmodifiableMap(map2);
                            this.expires = plainDateOf;
                        }
                    } while (i3 > i4);
                    arrayList.add(utf2);
                    map.put(utf2, bArr);
                    i2++;
                    z = z2;
                    str3 = str;
                }
                boolean z3 = z;
                short s = dataInputStream.readShort();
                for (int i5 = 0; i5 < s; i5++) {
                    map2.put(dataInputStream.readUTF(), (String) arrayList.get(dataInputStream.readShort()));
                }
                if (!z3) {
                    short s2 = dataInputStream.readShort();
                    for (int i6 = 0; i6 < s2; i6++) {
                        this.leapsecs.put(PlainDate.of(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte()), Integer.valueOf(dataInputStream.readByte()));
                    }
                    plainDateOf = PlainDate.of(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte());
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                str2 = utf;
                illegalStateException = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            str = "";
            string = str;
        }
        if (illegalStateException != null) {
            throw illegalStateException;
        }
        this.version = str2;
        this.location = string;
        this.data = Collections.unmodifiableMap(map);
        this.aliases = Collections.unmodifiableMap(map2);
        this.expires = plainDateOf;
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public Set getAvailableIDs() {
        return this.data.keySet();
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public Map getAliases() {
        return this.aliases;
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public TransitionHistory load(String str) {
        try {
            byte[] bArr = (byte[]) this.data.get(str);
            if (bArr != null) {
                return (TransitionHistory) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public String getFallback() {
        return "";
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public String getName() {
        return "TZDB";
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public String getLocation() {
        return this.location;
    }

    @Override // net.time4j.tz.ZoneModelProvider
    public String getVersion() {
        return this.version;
    }

    @Override // net.time4j.scale.LeapSecondProvider
    public Map getLeapSecondTable() {
        return Collections.unmodifiableMap(this.leapsecs);
    }

    @Override // net.time4j.scale.LeapSecondProvider
    public boolean supportsNegativeLS() {
        return !this.leapsecs.isEmpty();
    }

    @Override // net.time4j.scale.LeapSecondProvider
    public PlainDate getDateOfExpiration() {
        return this.expires;
    }

    public String toString() {
        return "TZ-REPOSITORY(" + this.version + ")";
    }

    private static void checkMagicLabel(DataInputStream dataInputStream, String str) throws IOException {
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        byte b3 = dataInputStream.readByte();
        byte b4 = dataInputStream.readByte();
        byte b5 = dataInputStream.readByte();
        byte b6 = dataInputStream.readByte();
        if (b == 116 && b2 == 122 && b3 == 114 && b4 == 101 && b5 == 112 && b6 == 111) {
            return;
        }
        throw new IOException("Invalid tz-repository: " + str);
    }

    private static Class getReference() {
        if (Boolean.getBoolean("test.environment")) {
            try {
                return Class.forName("net.time4j.tz.spi.RepositoryTest");
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
        return TimezoneRepositoryProviderSPI.class;
    }
}

package androidx.core.app;

import android.content.Context;
import android.util.Xml;
import com.adjust.sdk.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppLocalesStorageHelper {
    private static final Object sAppLocaleStorageSync = new Object();

    public static String readLocales(Context context) {
        String attributeValue;
        synchronized (sAppLocaleStorageSync) {
            attributeValue = "";
            try {
                FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, Constants.ENCODING);
                    int depth = xmlPullParserNewPullParser.getDepth();
                    while (true) {
                        int next = xmlPullParserNewPullParser.next();
                        if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                            if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException | XmlPullParserException unused2) {
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
                if (attributeValue.isEmpty()) {
                    context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                }
            } catch (FileNotFoundException unused4) {
                return "";
            }
        }
        return attributeValue;
    }

    public static void persistLocales(Context context, String str) {
        synchronized (sAppLocaleStorageSync) {
            if (str.equals("")) {
                context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                return;
            }
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument(Constants.ENCODING, Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, "locales");
                    xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                    xmlSerializerNewSerializer.endTag(null, "locales");
                    xmlSerializerNewSerializer.endDocument();
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Exception unused2) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        fileOutputStreamOpenFileOutput.close();
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            }
        }
    }
}

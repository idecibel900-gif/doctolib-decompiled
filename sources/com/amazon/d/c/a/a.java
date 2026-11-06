package com.amazon.d.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface a extends IInterface {
    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    void a(String str, boolean z, String str2) throws RemoteException;

    String b() throws RemoteException;

    /* JADX INFO: renamed from: com.amazon.d.c.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0058a extends Binder implements a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        private static final String e = "com.amazon.venezia.service.verify.IApplicationVerificationService";

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0058a() {
            attachInterface(this, e);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(e);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof a)) {
                return (a) iInterfaceQueryLocalInterface;
            }
            return new C0059a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(e);
                a(parcel.readString(), parcel.readInt() != 0, parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(e);
                String strA = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strA);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(e);
                String strA2 = a();
                parcel2.writeNoException();
                parcel2.writeString(strA2);
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(e);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(e);
            String strB = b();
            parcel2.writeNoException();
            parcel2.writeString(strB);
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.c.a.a$a$a, reason: collision with other inner class name */
        private static class C0059a implements a {
            private IBinder a;

            C0059a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String c() {
                return AbstractBinderC0058a.e;
            }

            @Override // com.amazon.d.c.a.a
            public void a(String str, boolean z, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0058a.e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeString(str2);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.c.a.a
            public String a(String str) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0058a.e);
                    parcelObtain.writeString(str);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.c.a.a
            public String a() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0058a.e);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.c.a.a
            public String b() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(AbstractBinderC0058a.e);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}

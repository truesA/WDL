# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}


-repackageclasses ''
-allowaccessmodification
# -> 如果应用程序引入的有jar包,并且想混淆jar包里面的class
-dontskipnonpubliclibraryclassmembers
#  ->设置混淆的压缩比率 0 ~ 7
-optimizationpasses 5
# -> Aa aA
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
# ->混淆后生产映射文件 map 类名->转化后类名的映射
-verbose
# ->混淆采用的算法.
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#->所有activity的子类不要去混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

# -> 所有native的方法不能去混淆.
-keepclasseswithmembernames class * {
    native <methods>;
}

#  -->某些构造方法不能去混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

#  -> 枚举类不能去混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#  -> aidl文件不能去混淆.
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class * {
   public <init>(org.json.JSONObject);
}
-ignorewarnings -keep class * { public private *; }
#---------------------------------2.第三方包-------------------------------

-keepattributes InnerClasses,Signature
-keepattributes *Annotation*

-keep class cn.addapp.pickers.entity.** { *;}
-dontwarn com.wdl.amdroid_jwdl.view.StateFrameLayout.**
-keep class com.wdl.amdroid_jwdl.view.StateFrameLayout.**{*;}

-keepattributes InnerClasses,Signature
-keepattributes *Annotation*

-keep class cn.addapp.pickers.entity.** { *;}

# Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# Gson
-keep class com.google.gson.stream.** { *; }
-keepattributes EnclosingMethod

# Retrofit
-dontnote retrofit2.Platform
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

-dontwarn okio.**
-dontwarn javax.annotation.**

#黄油刀
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#bugly
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

-keep class android.support.**{*;}

#---------------------------------1.实体类---------------------------------

-keep class com.wdl.amdroid_jwdl.model.** { *; }

#---------------------------------      END     -----------------------------------

#避免泛型错误
-keepattributes Signature

#避免用到反射的类的错误
-keep public class * implements java.io.Serializable { *; }
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
    public <fields>;
}

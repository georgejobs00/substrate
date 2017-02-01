package projekt.substrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import projekt.substrate.Root;

public class LetsGetStarted {
    public static Intent initialize(Context mContext, String currentTheme, boolean theme_legacy, String theme_mode, Boolean notification) {
        Intent originalIntent = new Intent("android.intent.action.MAIN");
        if (theme_legacy) {
            originalIntent.putExtra("theme_legacy", true);
        }
        if (theme_mode != null) {
            originalIntent.putExtra("theme_mode", theme_mode);
        }
        if (notification.booleanValue()) {
            originalIntent.setFlags(603979776);
            originalIntent.putExtra("refresh_mode", true);
        }
        try {
            PackageManager pm = mContext.getPackageManager();
            PackageInfo info = pm.getPackageInfo(currentTheme, 1);
            ActivityInfo[] list = info.activities;
            for (int i = 0; i < list.length; ++i) {
                if (list[i].name.equals(currentTheme + ".SubstratumLauncher")) {
                    originalIntent.setComponent(new ComponentName(currentTheme, currentTheme + ".SubstratumLauncher"));
                    return originalIntent;
                }
                if (!list[i].name.equals("substratum.theme.template.SubstratumLauncher")) continue;
                originalIntent.setComponent(new ComponentName(currentTheme, "substratum.theme.template.SubstratumLauncher"));
                return originalIntent;
            }
        }
        catch (Exception pm) {
            // empty catch block
        }
        return null;
    }

    public static Boolean overcomeMyBeauty() {
        File file = new File("/system/etc/config/");
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return false;
    }

    public static void kissMe() {
        String mountCMD = LetsGetStarted.checkMountCMD();
        if (mountCMD != null) {
            if (mountCMD.equals("toybox")) {
                Root.runCommand("mount -o rw,remount /system");
                Root.runCommand("mkdir /system/etc/config/");
                Root.runCommand("mount -o ro,remount /system");
            } else if (mountCMD.equals("toolbox")) {
                Root.runCommand("mount -o remount,rw /system");
                Root.runCommand("mkdir /system/etc/config/");
                Root.runCommand("mount -o remount,ro /system");
            }
        }
    }
}
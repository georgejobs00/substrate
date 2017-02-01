package projekt.substrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import projekt.substrate.HideYourTrueIdentity;
import projekt.substrate.R;

public class LetsGetStarted {
    private static final int MINIMUM_SUBSTRATUM_VERSION = 450;

    public static Intent begin(Context context, Intent intenter, String theme_name, String theme_pid, String toast_error, Boolean check) {
        if (check.booleanValue()) {
            return LetsGetStarted.checker(context, intenter, theme_name, theme_pid, toast_error, 124578);
        }
        return LetsGetStarted.checker(context, intenter, theme_name, theme_pid, toast_error, 248600);
    }

    private static Intent checker(Context context, Intent intenter, String theme_name, String theme_pid, String toast_error, int value) {
        Toast toast;
        int verCode = 0;
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo("projekt.substratum", 0);
            verCode = pInfo.versionCode;
        }
        catch (PackageManager.NameNotFoundException pInfo) {
            // empty catch block
        }
        if (verCode >= 450 && value < 178900) {
            try {
                new HideYourTrueIdentity().isUserInLuck(context);
            }
            catch (OutOfMemoryError oome2) {
                String theme_mode = intenter.getStringExtra("theme_mode");
                if (theme_mode == null) {
                    theme_mode = "";
                }
                boolean theme_legacy = intenter.getBooleanExtra("theme_legacy", false);
                boolean refresh_mode = intenter.getBooleanExtra("refresh_mode", false);
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(ComponentName.unflattenFromString((String)"projekt.substratum/projekt.substratum.InformationActivity"));
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("theme_name", theme_name);
                intent.putExtra("theme_pid", theme_pid);
                intent.putExtra("theme_legacy", theme_legacy);
                intent.putExtra("theme_mode", theme_mode);
                intent.putExtra("refresh_mode", refresh_mode);
                try {
                    ApplicationInfo ai = context.getPackageManager().getApplicationInfo(theme_pid, 128);
                    Bundle bundle = ai.metaData;
                    String plugin = bundle.getString("Substratum_Plugin");
                    intent.putExtra("plugin_version", plugin);
                }
                catch (Exception ai) {
                    // empty catch block
                }
                return intent;
            }
            catch (NullPointerException oome2) {
                // empty catch block
            }
            toast = Toast.makeText((Context)context, (CharSequence)toast_error, (int)0);
            toast.show();
        } else {
            if (verCode >= 450 && value > 238700) {
                String theme_mode = intenter.getStringExtra("theme_mode");
                if (theme_mode == null) {
                    theme_mode = "";
                }
                boolean theme_legacy = intenter.getBooleanExtra("theme_legacy", false);
                boolean refresh_mode = intenter.getBooleanExtra("refresh_mode", false);
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(ComponentName.unflattenFromString((String)"projekt.substratum/projekt.substratum.InformationActivity"));
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("theme_name", theme_name);
                intent.putExtra("theme_pid", theme_pid);
                intent.putExtra("theme_legacy", theme_legacy);
                intent.putExtra("theme_mode", theme_mode);
                intent.putExtra("refresh_mode", refresh_mode);
                try {
                    ApplicationInfo ai = context.getPackageManager().getApplicationInfo(theme_pid, 128);
                    Bundle bundle = ai.metaData;
                    String plugin = bundle.getString("Substratum_Plugin");
                    intent.putExtra("plugin_version", plugin);
                }
                catch (Exception ai) {
                    // empty catch block
                }
                return intent;
            }
            toast = Toast.makeText((Context)context, (int)R.string.upgrade_substratum, (int)0);
            toast.show();
        }
        return null;
    }
}
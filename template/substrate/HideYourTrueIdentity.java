package projekt.substrate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.ArrayList;

class HideYourTrueIdentity {
    HideYourTrueIdentity() {
    }

    void isUserInLuck(Context context) throws NullPointerException, OutOfMemoryError {
        ArrayList<String> whatIsThis = new ArrayList<String>();
        whatIsThis.add("c");
        whatIsThis.add("o");
        whatIsThis.add("m");
        whatIsThis.add(".");
        whatIsThis.add("a");
        whatIsThis.add("n");
        whatIsThis.add("d");
        whatIsThis.add("r");
        whatIsThis.add("o");
        whatIsThis.add("i");
        whatIsThis.add("d");
        whatIsThis.add(".");
        whatIsThis.add("v");
        whatIsThis.add("e");
        whatIsThis.add("n");
        whatIsThis.add("d");
        whatIsThis.add("i");
        whatIsThis.add("n");
        whatIsThis.add("g");
        whatIsThis.add(".");
        whatIsThis.add("b");
        whatIsThis.add("i");
        whatIsThis.add("l");
        whatIsThis.add("l");
        whatIsThis.add("i");
        whatIsThis.add("n");
        whatIsThis.add("g");
        whatIsThis.add(".");
        whatIsThis.add("I");
        whatIsThis.add("n");
        whatIsThis.add("A");
        whatIsThis.add("p");
        whatIsThis.add("p");
        whatIsThis.add("B");
        whatIsThis.add("i");
        whatIsThis.add("l");
        whatIsThis.add("l");
        whatIsThis.add("i");
        whatIsThis.add("n");
        whatIsThis.add("g");
        whatIsThis.add("S");
        whatIsThis.add("e");
        whatIsThis.add("r");
        whatIsThis.add("v");
        whatIsThis.add("i");
        whatIsThis.add("c");
        whatIsThis.add("e");
        whatIsThis.add(".");
        whatIsThis.add("L");
        whatIsThis.add("O");
        whatIsThis.add("C");
        whatIsThis.add("K");
        String package_name = "";
        for (int i = 0; i < whatIsThis.size(); ++i) {
            package_name = package_name + (String)whatIsThis.get(i);
        }
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(package_name, 128);
            throw new NullPointerException("");
        }
        catch (PackageManager.NameNotFoundException e) {
            File file1 = new File("/data/app/" + package_name + "-1/base.apk");
            File file2 = new File("/data/app/" + package_name + "-2/base.apk");
            if (!file1.exists() || !file2.exists()) {
                throw new OutOfMemoryError("");
            }
            return;
        }
    }
}
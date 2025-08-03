package pixelclient;

import java.io.File;

public class CosmeticToggle {
    public CosmeticToggle() {
    }

    public static File getFolder(String mod) {
        File file = new File(FileManager.MODS_DIR, mod);
        file.mkdirs();
        return file;
    }

    public static void saveIsEnabledToFile(String mod, Boolean b) {
        FileManager.writeJsonToFile(new File(getFolder(mod), "Enabled.json"), b);
    }

    public static Boolean loadEnabledFromFile(String mod) {
        Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
        if (b == null) {
            b = true;
            saveIsEnabledToFile(mod, b);
        }

        return b;
    }

    public static void saveDoubleToFile(String mod, Double b) {
        FileManager.writeJsonToFile(new File(getFolder(mod), "Double.json"), b);
    }

    public static Double loadDoubleFromFile(String mod) {
        Double b = (Double)FileManager.readFromJson(new File(getFolder(mod), "Double.json"), Double.class);
        if (b == null) {
            b = 1.0D;
            saveDoubleToFile(mod, b);
        }

        return b;
    }
}

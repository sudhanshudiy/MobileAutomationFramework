package Util;

import java.io.IOException;

public class CommonUtils {

    public Process getProcess(String machineName) throws IOException {
        String cmd = "$ANDROID_HOME/platform-tools/adb devices";
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (machineName.equalsIgnoreCase("Windows"))
            processBuilder.command("cmd.exe", "/c", cmd);
        else
            processBuilder.command("bash", "-c", cmd);
        Process process = processBuilder.start();
        return process;
    }
}

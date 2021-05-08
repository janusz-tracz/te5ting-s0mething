package com.gupb.manager.python;

import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;

@Component
public class PythonPackageManager {

    void createVirtualEnvironment(String pathToVirtualEnvironmentParent, String virtualEnvironmentName) {
        StringBuilder stringBuilder = new StringBuilder();

        switch (OSType.os) {
            case Win:
                stringBuilder.append("cmd /c py -m pip install virtualenv && cd ")
                        .append(pathToVirtualEnvironmentParent)
                        .append(" && py -m virtualenv ")
                        .append(virtualEnvironmentName);
                break;
            case Linux: case MacOS:
                stringBuilder.append("python3 -m pip install virtualenv && cd ")
                        .append(pathToVirtualEnvironmentParent)
                        .append(" && python3 -m virtualenv ")
                        .append(virtualEnvironmentName);
                break;
        }

        String cmd = stringBuilder.toString();
        System.out.println(cmd);
        try {
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    void removeVirtualEnvironment(String pathToVirtualEnvironment) {
        File file = new File(pathToVirtualEnvironment);
        if (file.exists()) {
            FileSystemUtils.deleteRecursively(file);
        }
    }

    void installPackagesFromRequirements(String pathToVirtualEnvironment, String pathToRequirements) {
        StringBuilder stringBuilder = new StringBuilder();

        switch (OSType.os) {
            case Win:
                stringBuilder.append("cmd /c ")
                        .append(pathToVirtualEnvironment)
                        .append(File.separator)
                        .append("Scripts")
                        .append(File.separator)
                        .append("activate.bat && py -m pip install -r ")
                        .append(pathToRequirements)
                        .append(" && deactivate");
                break;
            case Linux: case MacOS:
                stringBuilder.append("source ")
                        .append(pathToVirtualEnvironment)
                        .append(File.separator)
                        .append("bin")
                        .append(File.separator)
                        .append("activate && python3 -m pip install -r ")
                        .append(pathToRequirements)
                        .append(" && deactivate");
                break;
        }

        String cmd = stringBuilder.toString();
        try {
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}

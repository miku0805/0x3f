package com.oj.backend.judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Compiler {
    public static CompilerResult compile(String code, String options) throws IOException, InterruptedException {
        String[] command = {"g++", "-o", "a.out", "-" + options, "-"};
        ProcessBuilder pb = new ProcessBuilder(Arrays.asList(command));
        pb.redirectErrorStream(true);
        Process process = null;
        try {
            process = pb.start();
            process.getOutputStream().write(code.getBytes());
            process.getOutputStream().close();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            process.waitFor();
            if (process.exitValue() == 0) {
                return new CompilerResult(true, sb.toString());
            } else {
                return new CompilerResult(false, sb.toString());
            }
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}


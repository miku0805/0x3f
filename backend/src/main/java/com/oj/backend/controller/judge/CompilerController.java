package com.oj.backend.controller.judge;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
//@RestController
//public class CompilerController {
//    @PostMapping("/compile/")
//    public Map<String,String>compile(@RequestBody Map<String, String> map) {
//        String code = map.get("code");
//        Map<String, String> hashmap = new HashMap<>();
//        hashmap.clear();
////        try {
////            ProcessBuilder pb = new ProcessBuilder("g++", "-o", "a.out", "-");
////            ProcessBuilder pb = new ProcessBuilder("g++", "-x", "c++", "-o", "a.out", "-");
////            pb.redirectErrorStream(true);
////            Process process = pb.start();
////            process.getOutputStream().write(code.getBytes());
////            process.getOutputStream().close();
////            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
////            String line = null;
////            StringBuilder sb = new StringBuilder();
////            while ((line = br.readLine()) != null) {
////                sb.append(line).append("\n");
////            }
////            process.waitFor();
////            if (process.exitValue() == 0) {
////                hashmap.put("output","编译成功");
////                return hashmap;
////            } else {
////                hashmap.put("output","编译失败：" + sb.toString());
////                return hashmap;
////            }
////        } catch (IOException | InterruptedException e) {
////            e.printStackTrace();
////            hashmap.put("output","编译异常：" + e.getMessage());
////            return hashmap;
////        }
//        // Write code to file
//        String executableName = "main";
//        String fileName = executableName + ".cpp";
//        try {
//            Files.write(Paths.get(fileName), code.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Compile code
//        Process process = null;
//        try {
//            process = Runtime.getRuntime().exec("g++ -o " + executableName + " " + fileName);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        int result = 0;
//        try {
//            result = process.waitFor();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        if (result != 0) {
//            hashmap.put("output","Compilation error");
//            return hashmap;
//        }
//
//        // Run compiled code
//        try {
//            process = Runtime.getRuntime().exec("./" + executableName);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        String output = reader.lines().collect(Collectors.joining("\n"));
//
//        hashmap.put("output",output);
//        return hashmap;
//    }
//
//}
@RestController
public class CompilerController {
    @PostMapping("/compile/")
    public Map<String,String> compile(@RequestBody Map<String, String> map) {
        String code = map.get("code");
        String inputStr = map.get("input");
        Map<String, String> hashmap = new HashMap<>();
        hashmap.clear();
        // 将代码写入文件
        String executableName = "main";
        String fileName = executableName + ".cpp";
        try {
            Files.write(Paths.get(fileName), code.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 编译代码
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("g++ -o " + executableName + " " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = 0;
        try {
            result = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (result != 0) {
            hashmap.put("output", "编译错误");
            return hashmap;
        }

        // 运行编译后的代码
        try {
            process = Runtime.getRuntime().exec("./" + executableName);
            process.getOutputStream().write(inputStr.getBytes());
            process.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String output = reader.lines().collect(Collectors.joining("\n"));
        String error = errorReader.lines().collect(Collectors.joining("\n"));

        if (!error.isEmpty()) {
            hashmap.put("output", "运行错误: " + error);
        } else {
            hashmap.put("output", output);
        }

        return hashmap;
    }

}
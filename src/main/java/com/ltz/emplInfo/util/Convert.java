package com.ltz.emplInfo.util;

import com.ltz.emplInfo.sys.entity.EmplInfo;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;

import java.util.Objects;

public class Convert {
    public static void convertEmplInfo(EmplInfo emplInfo) {
        // if是"1 or 0"?执行转换"1,0"为"是,否"   else执行转换"是,否"为"1,0"
        if (Objects.equals(emplInfo.getPostgraduate(), "1") || Objects.equals(emplInfo.getPostgraduate(), "0")) {
            // postgraduate转换
            if (Objects.equals(emplInfo.getPostgraduate(), "1")) {
                emplInfo.setPostgraduate("是");
            } else if (Objects.equals(emplInfo.getPostgraduate(), "0")) {
                emplInfo.setPostgraduate("否");
            } else {
                emplInfo.setPostgraduate("");
            }
            // emplOntime转换
            if (Objects.equals(emplInfo.getEmplOntime(), "1")) {
                emplInfo.setEmplOntime("是");
            } else if (Objects.equals(emplInfo.getEmplOntime(), "0")) {
                emplInfo.setEmplOntime("否");
            } else {
                emplInfo.setEmplOntime("");
            }
            // emplWithintwo转换
            if (Objects.equals(emplInfo.getEmplWithintwo(), "1")) {
                emplInfo.setEmplWithintwo("是");
            } else if (Objects.equals(emplInfo.getEmplWithintwo(), "0")) {
                emplInfo.setEmplWithintwo("否");
            } else {
                emplInfo.setEmplWithintwo("");
            }
        } else {
            // postgraduate转换
            if (Objects.equals(emplInfo.getPostgraduate(), "是")) {
                emplInfo.setPostgraduate("1");
            } else if (Objects.equals(emplInfo.getPostgraduate(), "否")) {
                emplInfo.setPostgraduate("0");
            } else {
                emplInfo.setPostgraduate("");
            }
            // emplOntime转换
            if (Objects.equals(emplInfo.getEmplOntime(), "是")) {
                emplInfo.setEmplOntime("1");
            } else if (Objects.equals(emplInfo.getEmplOntime(), "否")) {
                emplInfo.setEmplOntime("0");
            } else {
                emplInfo.setEmplOntime("");
            }
            // emplWithintwo转换
            if (Objects.equals(emplInfo.getEmplWithintwo(), "是")) {
                emplInfo.setEmplWithintwo("1");
            } else if (Objects.equals(emplInfo.getEmplWithintwo(), "否")) {
                emplInfo.setEmplWithintwo("0");
            } else {
                emplInfo.setEmplWithintwo("");
            }
        }
    }

    public static void convertEmplInfoCheck(EmplInfoCheck emplInfoCheck) {
        // if是"1 or 0"?执行转换"1,0"为"是,否"   else执行转换"是,否"为"1,0"
        if (Objects.equals(emplInfoCheck.getPostgraduate(), "1") || Objects.equals(emplInfoCheck.getPostgraduate(), "0")) {
            // postgraduate转换
            if (Objects.equals(emplInfoCheck.getPostgraduate(), "1")) {
                emplInfoCheck.setPostgraduate("是");
            } else if (Objects.equals(emplInfoCheck.getPostgraduate(), "0")) {
                emplInfoCheck.setPostgraduate("否");
            } else {
                emplInfoCheck.setPostgraduate("");
            }
            // emplOntime转换
            if (Objects.equals(emplInfoCheck.getEmplOntime(), "1")) {
                emplInfoCheck.setEmplOntime("是");
            } else if (Objects.equals(emplInfoCheck.getEmplOntime(), "0")) {
                emplInfoCheck.setEmplOntime("否");
            } else {
                emplInfoCheck.setEmplOntime("");
            }
            // emplWithintwo转换
            if (Objects.equals(emplInfoCheck.getEmplWithintwo(), "1")) {
                emplInfoCheck.setEmplWithintwo("是");
            } else if (Objects.equals(emplInfoCheck.getEmplWithintwo(), "0")) {
                emplInfoCheck.setEmplWithintwo("否");
            } else {
                emplInfoCheck.setEmplWithintwo("");
            }
        } else {
            // postgraduate转换
            if (Objects.equals(emplInfoCheck.getPostgraduate(), "是")) {
                emplInfoCheck.setPostgraduate("1");
            } else if (Objects.equals(emplInfoCheck.getPostgraduate(), "否")) {
                emplInfoCheck.setPostgraduate("0");
            } else {
                emplInfoCheck.setPostgraduate("");
            }
            // emplOntime转换
            if (Objects.equals(emplInfoCheck.getEmplOntime(), "是")) {
                emplInfoCheck.setEmplOntime("1");
            } else if (Objects.equals(emplInfoCheck.getEmplOntime(), "否")) {
                emplInfoCheck.setEmplOntime("0");
            } else {
                emplInfoCheck.setEmplOntime("");
            }
            // emplWithintwo转换
            if (Objects.equals(emplInfoCheck.getEmplWithintwo(), "是")) {
                emplInfoCheck.setEmplWithintwo("1");
            } else if (Objects.equals(emplInfoCheck.getEmplWithintwo(), "否")) {
                emplInfoCheck.setEmplWithintwo("0");
            } else {
                emplInfoCheck.setEmplWithintwo("");
            }
        }
    }


}

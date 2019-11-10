package com.example.experi.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright By WeSure
 *
 * @author jaredzhang
 * @date 2019/8/21 11:04
 * @description
 */
public class ProductConfigUtils {

    public enum Modx {
        //年:YEAR ,半年:HALF_YEAR, 季:SEASON, 月:MONTH 趸:SINGLE'
        YEAR("YEAR", "年缴"),
        HALF_YEAR("HALF_YEAR", "半年缴"),
        SEASON("SEASON", "季缴"),
        MONTH("MONTH", "月缴"),
        SINGLE("SINGLE", "趸缴");

        private String code;
        private String value;

        Modx(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public static List<String> getValues() {
            List<String> values = new ArrayList<>();
            for (Modx m : Modx.values()) {
                values.add(m.code);
            }
            return values;
        }

        public static String getName(String code) {
            for (Modx m : Modx.values()) {
                if (code.equalsIgnoreCase(m.code)) {
                    return m.value;
                }
            }
            return code;
        }

        public static String getCode(Modx modx) {
            return modx.code;
        }


    }

    // 保障责任类型
    public enum InsureType {
        //医疗保障（medicalInsurance）、重疾保障（criticalDiseasesInsurance）、身故/伤残保障（deathInsurance）、养老保障（endowmentInsurance）、其他保障（otherInsurance）
        MEDICALINSURANCE("medicalInsurance", "医疗保障"),
        CRITICALDISEASESINSURANCE("criticalDiseasesInsurance", "重疾保障"),
        DEATHINSURANCE("deathInsurance", "身故/伤残保障"),
        ENDOWMENTINSURANCE("endowmentInsurance", "养老保障"),
        OTHERINSURANCE("otherInsurance", "其他保障");
        private String code;
        private String value;

        InsureType(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public static List<String> getValues() {
            List<String> values = new ArrayList<>();
            for (InsureType m : InsureType.values()) {
                values.add(m.code);
            }
            return values;
        }

        public static String getName(String code) {
            for (InsureType m : InsureType.values()) {
                if (code.equalsIgnoreCase(m.code)) {
                    return m.value;
                }
            }
            return code;
        }
    }

    // 翻译保障期间：1L 保终生 nY/M/D 保n年/月/日 nA 保至n岁
    public static String transInsurePeriod(String string) {
        String result = "";
        if (string.contains("L")) {
            result = "保终生";
        } else if (string.contains("Y")) {
            result = "保" + string.substring(0, string.length()-1) + "年";
        } else if (string.contains("M")) {
            result = "保" + string.substring(0, string.length()-1) + "月";
        } else if (string.contains("D")) {
            result = "保" + string.substring(0, string.length()-1) + "天";
        } else if (string.contains("A")) {
            result = "保至" + string.substring(0, string.length()-1) + "岁";
        } else {
            result = "其它";
        }
        return result;
    }

    // 翻译缴费期间：翻译为猜测
    public static String transCollectPeriod(String string) {
        String result = "";
        if (string.contains("L")) {
            result = "交终生";
        } else if (string.contains("Y")) {
            result = "交" + string.substring(0, string.length()-1) + "年";
        } else if (string.contains("S")) {
            result = "一次性交";
        } else if (string.contains("A")) {
            result = "交至" + string.substring(0, string.length()-1) + "岁";
        } else {
            result = "其它";
        }
        return result;
    }
}

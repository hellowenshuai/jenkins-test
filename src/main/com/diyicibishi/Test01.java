package com.diyicibishi;

import java.util.ArrayList;
import java.util.List;

/**
 * 收益 = （本金+利率）*（1-丢失率）-本金
 */
public class Test01 {
    /**
     * 初始化数据
     */
    public List<String> getLoads() {
        //String loadStr = "1000 600 a,1500 900 b,2000 1200 c";
        List<String> loads = new ArrayList<>();
        loads.add("1000 600 a");
        loads.add("1500 900 b");
        loads.add("2000 1200 c");
        return loads;
    }

    /**
     * 初始化数据
     */
    public List<String> getRisks() {
        //String riskStr = "a 0,b 0.01,c 0.05";
        List<String> risks = new ArrayList<>();
        risks.add("a 0");
        risks.add("b 0.01");
        risks.add("c 0.1");
        return risks;
    }

    /**
     * 获取收益
     *
     * @param loads
     * @param risks
     * @return
     */
    public double getMoney(List<String> loads, List<String> risks) {
        List<String[]> loadArrays = new ArrayList<>();
        List<String[]> loadArrays2 = new ArrayList<>();
        List<String[]> riskArrays = new ArrayList<>();

        for (int i = 0; i < loads.size(); i++) {
            String load = loads.get(i);
            String[] loadArray = load.split("\\s");
            loadArrays.add(loadArray);
        }
        for (int i = 0; i < risks.size(); i++) {
            String risk = risks.get(i);
            String[] riskArray = risk.split("\\s");
            riskArrays.add(riskArray);
        }
        for (int i = 0; i < loadArrays.size(); i++) {
            String[] loadArray = loadArrays.get(i);
            for (int k = 0; k < riskArrays.size(); k++) {
                String[] riskArray = riskArrays.get(k);
                if (loadArray[2].equals(riskArray[0])) {
                    loadArray[2] = riskArray[1];
                    loadArrays2.add(loadArray);
                }
            }
        }
        System.err.println(loadArrays2.toString());
        Double sum = 0d;
        for (int i = 0; i < loadArrays2.size(); i++) {
            String[] loadArray = loadArrays2.get(i);
            sum = sum + (Double.parseDouble(loadArray[0]) + Double.parseDouble(loadArray[1])) * (1 - Double.parseDouble(loadArray[2])) - Double.parseDouble(loadArray[1]);
        }

        return sum;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        List<String> loads = test01.getLoads();
        List<String> risks = test01.getRisks();
        double money = test01.getMoney(loads, risks);
        System.out.println("money:"+money);
    }
}

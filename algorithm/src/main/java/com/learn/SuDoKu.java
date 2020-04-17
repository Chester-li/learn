package com.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaoshuai.li
 * @date 2020/2/12
 * @description
 */
public class SuDoKu {

    private static final Integer[][] data = {
            {0, 6, 0, 0, 0, 2, 0, 0, 5},
            {0, 0, 9, 6, 0, 0, 8, 0, 0},
            {0, 0, 0, 0, 4, 0, 0, 0, 1},

            {4, 0, 3, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 9, 0, 5, 0, 8, 0},
            {5, 0, 0, 0, 0, 1, 0, 0, 0},

            {9, 0, 0, 0, 5, 7, 0, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 9, 0},
            {0, 0, 0, 0, 0, 0, 7, 2, 0}
    };

    /**
     * 1. check 为0 的元素 所在行可以存放的数字
     * 2. check 为0 的元素 所在列可以存放的数字
     * 3. check 为0 的元素 所在单元块可以存放的数字
     * 4.以上都校验完毕之后 可以存放的数字只有一个的写入单元格
     * 5. check完所有为0的元素之后 检查是否还有为0的元素 有的话继续执行
     * 6. 当一次执行之后，没有任何元素可以写入单元格 则当前数独无解
     */
    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            done = true;
            boolean calcResultThisTerm = false;
            for (int row = 0; row < data.length; row++) {
                for (int col = 0; col < data.length; col++) {
                    if (data[row][col] == 0) {
                        List<Integer> canStoreDigital = initCanStoreDigital(data.length);
                        calcColData(col, canStoreDigital);
                        calcRowData(row, canStoreDigital);
                        calcBlockData(col, row, canStoreDigital);
                        if(canStoreDigital.size() == 1){
                            calcResultThisTerm = true;
                            data[row][col] = canStoreDigital.get(0);
                        } else {
                            done = false;
                        }
                    }
                }
            }
            if(!calcResultThisTerm){
                System.out.println("this sudoku has no result");
                break;
            }
        }
        printResult();

    }

    private static void printResult() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                System.out.print(data[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void calcRowData(int rowNumber, List<Integer> canStoreDigital) {
        for (int i = 0; i < data[rowNumber].length; i++) {
            if (data[rowNumber][i] != 0) {
                canStoreDigital.remove(data[rowNumber][i]);
            }
        }
    }

    private static void calcColData(int colNumber, List<Integer> canStoreDigital) {
        for (int i = 0; i < data.length; i++) {
            if (data[i][colNumber] != 0) {
                canStoreDigital.remove(data[i][colNumber]);
            }
        }
    }

    private static void calcBlockData(int colNumber, int rowNumber, List<Integer> canStoreDigital) {
        int sqrt = new Long(Math.round(Math.sqrt(data.length))).intValue();
        int startColIndex = colNumber / sqrt * sqrt;
        int endColIndex = startColIndex + sqrt;
        int startRowIndex = rowNumber / sqrt * sqrt;
        int endRowIndex = startRowIndex + sqrt;

        for (int row = startRowIndex; row < endRowIndex; row++) {
            for(int col = startColIndex; col < endColIndex; col++){
                if(data[row][col] != 0){
                    canStoreDigital.remove(data[row][col]);
                }
            }
        }
    }

    /**
     * 初始化可以存放的数字
     */
    private static List<Integer> initCanStoreDigital(int length) {
        List<Integer> digitalList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            digitalList.add(i + 1);
        }
        return digitalList;

    }

}

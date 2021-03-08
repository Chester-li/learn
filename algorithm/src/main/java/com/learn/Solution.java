package com.learn;

/**
 * @author chaoshuai.li
 * @date 2021/3/1
 * @description
 */
public class Solution {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = (nums1.length + nums2.length) / 2;
        boolean oddNumber = (nums1.length + nums2.length) % 2 == 1;

        int traverseIndex = 0;

        int indexNumber1 = 0, indexNumber2 = 0;
        int before = 0;


        while (traverseIndex < index ) {

            if (traverseIndex == index -1) {
                if (oddNumber) {
                    return before;
                } else {
                    int current = Math.max(nums1[indexNumber1], nums2[indexNumber2]);
                    return (current + before) / 2.0;
                }
            }
            before = Math.min(nums1[indexNumber1], nums2[indexNumber2]);
            traverseIndex++;


            if(indexNumber1 == nums1.length -1  && indexNumber2 == nums2.length -1){
                break;
            }else if (indexNumber1 == nums1.length - 1) {
                indexNumber2++;
            } else if (indexNumber2 == nums2.length - 1) {
                indexNumber1++;
            } else {
                if (nums1[indexNumber1] > nums2[indexNumber2]) {
                    indexNumber2++;
                } else {
                    indexNumber1++;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2};
        int[] arr2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

}

package com.learn;

/**
 * @author chaoshuai.li
 * @date 2021/3/1
 * @description
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = (nums1.length + nums2.length ) /2;
        boolean oddNumber = (nums1.length + nums2.length) % 2 == 1;

        int indexNumber1 = 0 , indexNumber2 = 0;
        int before  = 0;
        while(indexNumber1 < nums1.length  && indexNumber2 < nums2.length ){
            if(indexNumber1 + indexNumber2 == index){
                int inner = Math.min(nums1[indexNumber1], nums2[indexNumber2]);
                if(oddNumber){
                    return inner;
                }else {
                    before = inner;
                }
            }
            if(indexNumber1 + indexNumber2 > index){
                int inner = Math.min(nums1[indexNumber1], nums2[indexNumber2]);
                return (inner + before ) / 2.0;
            }
            if(nums1[indexNumber1] > nums2[indexNumber2]){
                indexNumber2 ++;
            }else {
                indexNumber1 ++;
            }
        }
        return 0;
    }

}

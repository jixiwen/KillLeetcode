package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,3,9,12,5,4,10,29,17,13,16,18};
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int l, int r){
        if (l > r){
            return;
        }
        int t = nums[l];
        int low = l;
        int high = r;
        while (low < high){
            while (nums[high] >= t && low < high){
                high--;
            }
            while (nums[low] <= t && low < high){
                low++;
            }
            if (low < high){
                int temp = nums[high];
                nums[high] = nums[low];
                nums[low] = temp;
            }
        }
        nums[l] = nums[low];
        nums[low] = t;
        quickSort(nums, l, low - 1);
        quickSort(nums, low + 1, r);
    }

    public static void mergeSort(int[] nums, int l, int r, int[] temp){
        if (l >= r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid + 1 ,r, temp);
        int low = l;
        int high = mid + 1;
        int i = l;
        for (; i <= r && low <= mid && high <= r; i++) {
            if (nums[low] < nums[high]){
                temp[i] = nums[low];
                low++;
            } else {
                temp[i] = nums[high];
                high++;
            }
        }
        while (low <= mid){
            temp[i] = nums[low];
            low++;
            i++;
        }
        while (high <= r){
            temp[i] = nums[high];
            high++;
            i++;
        }
        for (; l <= r; l++) {
           nums[l] = temp[l];
        }
    }
    public static void exchange(int[] nums, int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

//    public static void quickSort(int[]a,int left,int right)
//    {
//        if(left>right)
//            return;
//        int pivot=a[left];//定义基准值为数组第一个数
//        int i=left;
//        int j=right;
//
//        while(i<j)
//        {
//            while(pivot<=a[j]&&i<j)//从右往左找比基准值小的数
//                j--;
//            while(pivot>=a[i]&&i<j)//从左往右找比基准值大的数
//                i++;
//            if(i<j)                     //如果i<j，交换它们
//            {
//                int temp=a[i];
//                a[i]=a[j];
//                a[j]=temp;
//            }
//        }
//        a[left]=a[i];
//        a[i]=pivot;//把基准值放到合适的位置
//        quickSort(a,left,i-1);//对左边的子数组进行快速排序
//        quickSort(a,i+1,right);//对右边的子数组进行快速排序
//    }
}
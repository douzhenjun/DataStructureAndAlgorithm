package 剑指offer.剑指offer11_旋转数组中的最小数字;

import java.util.Arrays;
import java.util.List;

public class FindMinInRotateArray {

    public static Integer findMin(List<Integer> arrayList){
        //设旋转数组由ba两部分组成, 并且一般情况下a中的元素要小于等于b中的元素. 我们的目的是寻找a[1].
        //如果一开始array[i]<arr[j], 这说明整个数组就是递增数组, 那么array[0]就是最小的元素.
        int i = 0;
        int j = arrayList.size()-1;

        if(arrayList.get(i) < arrayList.get(j)){
            return arrayList.get(i);
        }
        //中间元素array[m1]与array[i]比较:
        // 如果array[m1]>array[i], 说明m1位于b中, 这时i=m1;
        //如果array[m1]<array[i], 说明m1位于a中, 这时j=m1, 保证array[i] >= array[j]始终成立.
        while(i+1 < j){
            int mid = (i+j)/2;
            if(arrayList.get(mid) > arrayList.get(i)) {
                i = mid;
            }else if(arrayList.get(mid) < arrayList.get(i)){
                j = mid;
            }else {
                //如果array[m1] = array[i], 那么array[m1]与array[j]比较:
                //如果arr[m1] > arr[j], 说明m1位于b中, 这时i=m1;
                //如果arr[m1] < arr[j], 说明m1位于a中, 这是j=m1;
                //如果arr[m1] == arr[j] == arr[i], 无法获知a[1]在[i,m1]中还是[m1,j]中,
                //因此只能顺序查找了.
                if(arrayList.get(mid) > arrayList.get(j)){
                    i = mid;
                }else if(arrayList.get(mid) < arrayList.get(j)){
                    j = mid;
                }else{
                    int min = arrayList.get(i);
                    for(int k = i; k <= j; k++){
                        if(min > arrayList.get(k)){
                            min = arrayList.get(k);
                        }
                    }
                    return min;
                }
            }
        }
        //最后两个指针相邻了, 由于arr[i] >= arr[j], 所以arr[j]是最小的元素.
        return arrayList.get(j);
    }


    public static void main(String[] args) {
        Integer [] array = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);
        int num = findMin(list);

        System.out.println("旋转数组的最小元素是:"+num);

        System.out.println("---------------------------------");

        Integer[] array2 = {5, 6, -2, 0, 2, 4, 5};
        List<Integer> list2 = Arrays.asList(array2);

        System.out.println("旋转数组的最小元素是:"+findMin(list2));
        System.out.println("---------------------------------");


        Integer[] array3 = {1, 1, 1, -1, 1, 1, 1};
        List<Integer> list3 = Arrays.asList(array3);

        System.out.println("旋转数组的最小元素是:"+findMin(list3));
        System.out.println("---------------------------------");

        Integer[] array4 = {2, 0, 1, 1, 2};
        List<Integer> list4 = Arrays.asList(array4);

        System.out.println("旋转数组的最小元素是:"+findMin(list4));
        System.out.println("---------------------------------");

        Integer[] array5 = {1, 1, 1, -1, 1, 1, 1};
        List<Integer> list5 = Arrays.asList(array5);

        System.out.println("旋转数组的最小元素是:"+findMin(list5));
        System.out.println("---------------------------------");
    }
}

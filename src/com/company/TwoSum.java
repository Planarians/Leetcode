package com.company;
import java.util.*;



public class TwoSum {
    //    public static int[] twoSum(List<Integer> nums, int target) {
    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        if (nums.length == 2) {//case 1 if only two number
            output[0] = 0;
            output[1] = 1;
            return output;
        }
        ArrayList<Integer> numsSort = new ArrayList<>();
//        numsSort.addAll(nums);//copy nums
//        Collections.sort(numsSort);

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
            map1.put(nums[i],i);
        }

        // Convert the entrySet of the HashMap to a List
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Use a custom comparator to sort the List by values
        entryList.sort(Map.Entry.comparingByValue());

        // Create a new LinkedHashMap to preserve the sorting order
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
            if(map1.containsKey(target-entry.getValue())) {
                output[0] = entry.getKey();
                output[1] = map1.get(target-entry.getValue());
                return output;
            }
        }

//        System.out.println("Sorted Map by Value: " + sortedMap);




        return output;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int[] a=
//            int target = sc.nextInt();
//
//        }

        int[] nums = {1, 2, 3, 4};

//        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(3, 2, 4));
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}



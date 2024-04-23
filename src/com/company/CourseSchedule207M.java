package com.company;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-04-23 10:33
 **/
public class CourseSchedule207M {


    class Solution1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // Construct the prerequisite map
            Map<Integer, List<Integer>> preMap = new HashMap<>();
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                // Check if the course already exists in the map
                if (!preMap.containsKey(course)) {
                    preMap.put(course, new ArrayList<>());
                }
                preMap.get(course).add(preCourse);
            }

            // Initialize visitSet to track visited courses during DFS
            Set<Integer> visitSet = new HashSet<>();

            // Initialize the set to track courses that are being visited in the current DFS process
            Set<Integer> visiting = new HashSet<>();

            // Perform DFS for each course
            for (int course = 0; course < numCourses; course++) {
                if (!dfs(course, preMap, visitSet, visiting)) {
                    return false; // If cycle detected, return false
                }
            }

            return true; // No cycle detected, all courses can be finished
        }

        private boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet, Set<Integer> visiting) {
            // If the course is already visited, return true (no cycle)
            if (visitSet.contains(course)) {
                return true;
            }

            // If the course is currently being visited, return false (cycle detected)
            if (visiting.contains(course)) {
                return false;
            }

            // Mark the course as visiting
            visiting.add(course);

            // Visit all prerequisite courses
            if (preMap.containsKey(course)) {
                for (int preCourse : preMap.get(course)) {
                    if (!dfs(preCourse, preMap, visitSet, visiting)) {
                        return false; // If cycle detected, return false
                    }
                }
            }

            // Mark the course as visited
            visiting.remove(course);
            visitSet.add(course);

            return true; // No cycle detected
        }
    }

    class Solution {//wrong
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // boolean [] Courses=new boolean[numCourses];
            HashMap<Integer, List<Integer>> preMap=new HashMap<>();
            Set<Integer> visitSet=new HashSet<>();
            for(int i=0;i<prerequisites.length;i++){
                int cur=prerequisites[i][0];
                int pre=prerequisites[i][0];
                if(!preMap.containsKey(cur)){
                    preMap.put(cur,new ArrayList<>());
                }else{
                    preMap.get(cur).add(pre);
                }
            }

            for(int cur=0;cur<numCourses;cur++){
                if(!dfs(cur,preMap,visitSet)){
                    return false;
                }
            }
            return true;

        }

        public boolean dfs(int cur,Map<Integer,List<Integer>> preMap,Set<Integer> visitSet){
            if(visitSet.contains(cur)){
                return true;
            }

            visitSet.add(cur);

            if(preMap.containsKey(cur)){
                for(int pre: preMap.get(cur)){
                    if(!dfs(cur,preMap,visitSet)){
                        return false;
                    }
                }
            }

            visitSet.remove(cur);
            return true;
        }
    }
}

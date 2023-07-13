package com.altimetrik.heap;

import java.util.*;

class ScheduleTask {
  public static int tasks(List<List<Integer>> tasksList) {
      // to count the total number of machines for "optimalMachines" tasks
      int optimalMachines = 0;

      PriorityQueue<int[]> machinesAvailable = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
      PriorityQueue<int[]> tasksQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
      for (List<Integer> task: tasksList) {
          tasksQueue.offer(new int[] {
              task.get(0), task.get(1)
          });
      }

      while (!tasksQueue.isEmpty()) { // looping through the tasks list
          // remove from "tasksQueue" the task i with earliest start time
          int[] task = tasksQueue.poll();
          int[] machineInUse;
          if (!machinesAvailable.isEmpty() && task[0] >= machinesAvailable.peek()[0]) {
              // top element is deleted from "machinesAvailable"
              machineInUse = machinesAvailable.poll();
              // schedule task on the current machine
              machineInUse = new int[] {
                  task[1], machineInUse[1]
              };
          } else {
              // if there's a conflicting task, increment the
              // counter for machines and store this task's
              // end time on heap "machinesAvailable"
              optimalMachines += 1;
              machineInUse = new int[] {
                  task[1], optimalMachines
              };
          }
          machinesAvailable.offer(machineInUse);
      }
      // return the total number of machines
      return optimalMachines;
  }

  public static void main(String[] args) {
    // Input: A set "tasks_list" of "n" tasks, such that
    // each taskList has a start time and a finish time
    List<List<List<Integer>>> inputs = Arrays.asList(
        Arrays.asList(
            Arrays.asList(1, 1),
            Arrays.asList(5, 5),
            Arrays.asList(8, 8),
            Arrays.asList(4, 4),
            Arrays.asList(6, 6),
            Arrays.asList(10, 10),
            Arrays.asList(7, 7)
        ),
        Arrays.asList(
            Arrays.asList(1, 7),
            Arrays.asList(1, 7),
            Arrays.asList(1, 7),
            Arrays.asList(1, 7),
            Arrays.asList(1, 7),
            Arrays.asList(1, 7)
        ),
        Arrays.asList(
            Arrays.asList(1, 7),
            Arrays.asList(8, 13),
            Arrays.asList(5, 6),
            Arrays.asList(10, 14),
            Arrays.asList(6, 7)
        ),
        Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 5),
            Arrays.asList(5, 9),
            Arrays.asList(9, 12),
            Arrays.asList(12, 13),
            Arrays.asList(13, 16),
            Arrays.asList(16, 17)
        ),
        Arrays.asList(
            Arrays.asList(12, 13),
            Arrays.asList(13, 15),
            Arrays.asList(17, 20),
            Arrays.asList(13, 14),
            Arrays.asList(19, 21),
            Arrays.asList(18, 20)
        )
    );

    // loop to execute till the length of tasks
    List<List<List<Integer>>> inputTaskList = new ArrayList<>();
    for(int j = 0; j < inputs.size(); j++) {
        inputTaskList.add(new ArrayList<>());
        for(int k = 0; k < inputs.get(j).size(); k++) {
            inputTaskList.get(j).add(new ArrayList<>(inputs.get(j).get(k)));
        }
    }

    for (int i = 0; i < inputTaskList.size(); i++) {
      System.out.println(i + 1 + ".\tTask = " + inputTaskList.get(i).toString());
      // Output: A non-conflicting schedule of tasks in
      // "tasks_list" using the minimum number of machines
      System.out.println("\tOptimal number of machines = " + tasks(inputTaskList.get(i)));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
}

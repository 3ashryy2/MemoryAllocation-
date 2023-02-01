import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Vector<Partition> partitions = new Vector<Partition>();
        Vector<Process> processes = new Vector<Process>();

//        System.out.println("Enter number of partition:");
//       int numOfPartition = input.nextInt();
//        for (int i=0;i<numOfPartition;i++)
//        {
//            System.out.println("Partition name and its size:");
//            String name = input.next();
//            int size = input.nextInt();
//            Partition partition = new Partition(name,size);
//            partitions.add(partition);
//        }
//
//        System.out.println();
//
//        System.out.println("Enter number of processes:");
//        int numOfProcess = input.nextInt();
//        for (int i=0;i<numOfProcess;i++)
//        {
//            System.out.println("Process name and its size:");
//            String name = input.next();
//            int size = input.nextInt();
//            Process process = new Process(name,size);
//            processes.add(process);
//        }

        Partition partition0 = new Partition("Partition0",90);
        partitions.add(partition0);
        Partition partition1 = new Partition("Partition1",20);
        partitions.add(partition1);
        Partition partition2 = new Partition("Partition2",5);
        partitions.add(partition2);
        Partition partition3 = new Partition("Partition3",30);
        partitions.add(partition3);
        Partition partition4 = new Partition("Partition4",120);
        partitions.add(partition4);
        Partition partition5 = new Partition("Partition5",80);
        partitions.add(partition5);


        Process process1 = new Process("Process1",15);
        processes.add(process1);
        Process process2 = new Process("Process2",90);
        processes.add(process2);
        Process process3 = new Process("Process3",30);
        processes.add(process3);
        Process process4 = new Process("Process4",100);
        processes.add(process4);

        System.out.println("\nSelect the policy you want to apply:");
        System.out.println("1. First fit");
        System.out.println("2. Best fit");
        System.out.println("3. Worst fit");
        System.out.println("0. Exit");
        System.out.println("\nSelect policy:");
        int option = input.nextInt();

        while (option!=0)
        {
            if (option==1)
            {
                Vector<Partition> firstPartitions = new Vector<Partition>();
                for (int i=0;i<partitions.size();i++)
                {
                    Partition partition = new Partition(partitions.get(i));
                    firstPartitions.add(partition);
                }

                Vector<Process> firstProcesses = new Vector<Process>();
                for (int i=0;i<processes.size();i++)
                {
                    Process process = new Process(processes.get(i));
                    firstProcesses.add(process);
                }

                FirstFit firstFit = new FirstFit(firstPartitions,firstProcesses);
                System.out.println("\nFirst Fit");
                System.out.println("----------");
                firstFit.selectPolicy();
                firstFit.print();
                System.out.println("\nDo you want to compact? 1.yes 2.no");
                int compactNum = input.nextInt();
                if (compactNum==1)
                {
                    System.out.println("First Fit Compact");
                    System.out.println("-----------------");
                    firstFit.compact();
                    firstFit.print();
                }
            }

            if (option==2)
            {

            }

            if (option==3)
            {
                Vector<Partition> worstPartitions = new Vector<Partition>();
                for (int i=0;i<partitions.size();i++)
                {
                    Partition partition = new Partition(partitions.get(i));
                    worstPartitions.add(partition);
                }

                Vector<Process> worstProcesses = new Vector<Process>();
                for (int i=0;i<processes.size();i++)
                {
                    Process process = new Process(processes.get(i));
                    worstProcesses.add(process);
                }

                WorstFit worstFit = new WorstFit(worstPartitions,worstProcesses);
                System.out.println("\nWorst Fit");
                System.out.println("----------");
                worstFit.selectPolicy();
                worstFit.print();
                System.out.println("\nDo you want to compact? 1.yes 2.no");
                int compactNum = input.nextInt();
                if (compactNum==1)
                {
                    System.out.println("Worst Fit Compact");
                    System.out.println("-----------------");
                    worstFit.compact();
                    worstFit.print();
                }
            }

            System.out.println("\nSelect the policy you want to apply:");
            System.out.println("1. First fit");
            System.out.println("2. Best fit");
            System.out.println("3. Worst fit");
            System.out.println("0. Exit");
            System.out.println("\nSelect policy:");
            option = input.nextInt();
        }

    }
}
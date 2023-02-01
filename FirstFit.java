import java.util.Vector;

public class FirstFit
{
    private Vector<Partition> partitions;
    private Vector<Process> processes;
    private int largestNum;
    public FirstFit( Vector<Partition> partitions,Vector<Process> processes)
    {
        this.partitions = partitions;
        this.processes = processes;
        largestNum = partitions.size();
    }

    // select policy
    public void selectPolicy ()
    {
        for (int i=0;i<processes.size();i++)
        {
            if(processes.get(i).partition==null)
            {
                for (int j=0;j<partitions.size();j++)
                {
                    if(partitions.get(j).size >= processes.get(i).size && partitions.get(j).process == null)
                    {
                        partitions.get(j).process = processes.get(i);
                        partitions.get(j).size = processes.get(i).size;

                        if (partitions.get(j).copy_size-partitions.get(j).size != 0)
                        {
                            Partition p = createPartition(partitions.get(j).copy_size - partitions.get(j).size, largestNum);
                            partitions.add(j+1,p);
                            largestNum ++;
                        }

                        partitions.get(j).copy_size = partitions.get(j).size;

                        processes.get(i).partition = partitions.get(j);

                        break;
                    }
                }
            }
        }
    }

    // compact
    public void compact()
    {
        int i=0;
        int compactSize=0;
        while (i<partitions.size())
        {
            if (partitions.get(i).process==null)
            {
                compactSize += partitions.get(i).size;
                partitions.remove(i);
            }
            else
            {
                i++;
            }
        }

        if (compactSize!=0)
        {
            Partition p = createPartition(compactSize, largestNum);
            partitions.add(partitions.size(), p);
            largestNum++;

            // select policy again for non allocated process
            selectPolicy();
        }
    }

    // create new partition
    private Partition createPartition(int size, int Order)
    {
        Partition partition = new Partition();
        partition.size=size;
        partition.copy_size=size;
        partition.name="Partition"+Integer.toString(Order);

        return partition;
    }

    // print partitions
    public void print()
    {
        for (int i=0;i<partitions.size();i++)
        {
            System.out.print(partitions.get(i).name + " (" + partitions.get(i).size + " KB) => ");
            if (partitions.get(i).process != null)
                System.out.println(partitions.get(i).process.name);
            else
                System.out.println("External fragment");
        }

        System.out.println();

        for (int i=0;i<processes.size();i++)
        {
            if (processes.get(i).partition == null)
                System.out.println(processes.get(i).name + " can not be allocated");
        }
    }
}

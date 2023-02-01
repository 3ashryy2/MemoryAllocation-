public class Process
{
    String name;
    int size;
    int copy_size;
    Partition partition;
    Process(String name,int size)
    {
        this.name=name;
        this.size=size;
        this.copy_size=size;
        partition = null;
    }

    Process(Process p)
    {
        name=p.name;
        size=p.size;
        copy_size=p.size;
        partition = p.partition;
    }
}


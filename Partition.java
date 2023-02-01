import java.util.Vector;
public class Partition
{
    String name;
    int size;
    int copy_size;
    Process process;

    Partition(String name,int size)
    {
        this.name=name;
        this.size=size;
        this.copy_size=size;
        process = null;
    }

    Partition()
    {}

    Partition(Partition p)
    {
        name=p.name;
        size=p.size;
        copy_size=p.size;
        process = p.process;
    }

}

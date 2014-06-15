import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListFiles
{

  static int spc_count = -1;

  private static void Process(File aFile)
  {
    spc_count++;
    String spcs = "";
    for (int i = 0; i < spc_count; i++)
      spcs += " ";
    if (aFile.isFile())
      System.out.println(spcs + "[FILE] " + aFile.getName());
    else if (aFile.isDirectory())
    {
      System.out.println(spcs + "[DIR] " + aFile.getName());
      File[] listOfFiles = aFile.listFiles();
      if (listOfFiles != null)
      {
        for (int i = 0; i < listOfFiles.length; i++)
          Process(listOfFiles[i]);
      }
      else
      {
        System.out.println(spcs + " [ACCESS DENIED]");
      }
    }
    spc_count--;
  }

  public static void main(String[] args)
  {
    String nam = "/srv/";
    File aFile = new File(nam);
    Process(aFile);
  }

  private static void ListOfFiles()
  {
    // List of files....Queue of directories
    List<File> allFiles = new ArrayList<File>();
    Queue<File> dirs = new LinkedList<File>();

    // starting directory
    dirs.add(new File("/start/dir/"));

    while (!dirs.isEmpty())
    {
      // for each file in directory
      for (File f : dirs.poll().listFiles())
      {
        if (f.isDirectory())
        {
          // if child directory exists add to Queue
          dirs.add(f);
        }
        else if (f.isFile())
        {
          // add file to List of files
          allFiles.add(f);
        }
      }
    }
  }

  // Similar method to the above
  public static Collection<File> listFileTree(File dir)
  {
    List<File> fileTree = new ArrayList<File>();
    for (File entry : dir.listFiles())
    {
      if (entry.isFile())
        fileTree.add(entry);
      else
        fileTree.addAll(listFileTree(entry));
    }
    return fileTree;
  }

}

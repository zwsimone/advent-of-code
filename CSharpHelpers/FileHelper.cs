namespace CSharpHelpers;
public class FileHelper
{
    public static List<String> GetListFromFile(string path)
    {
        List<string> stringList = new List<string>();
        if (File.Exists(path))
        {
            using (StreamReader inputReader = File.OpenText(path))
            {
                string line = inputReader.ReadLine();
                while (line != null)
                {
                    stringList.Add(line);
                    line = inputReader.ReadLine();
                }
            }
        }
        else
        {
            throw new FileNotFoundException("File not found.");
        }
        return stringList;
    }
}

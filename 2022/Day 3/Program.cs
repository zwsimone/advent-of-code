namespace DayThree2022;
class Program
{
    public static void Main(string[] args)
    {
        string path = "input.txt";
        List<string> input = GetListFromFile(path);
        List<char> sharedItems = GetSharedItems(input);
        int prioritySum = GetPrioritySumOfSharedItems(sharedItems);
        Console.WriteLine("Total sum of priority is {0}", prioritySum);
    }

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

    public static List<char> GetSharedItems(List<string> input)
    {
        List<char> sharedItems = new List<char>();
        foreach (string rucksack in input)
        {
            string firstCompartment = rucksack.Substring(0, rucksack.Length / 2);
            string secondCompartment = rucksack.Substring(rucksack.Length / 2);
            for (int i = 0; i < firstCompartment.Length; i++)
            {
                if (secondCompartment.Contains(firstCompartment[i]))
                {
                    sharedItems.Add(firstCompartment[i]);
                    break;
                }
            }
        }
        return sharedItems;
    }

    public static int GetPrioritySumOfSharedItems(List<char> sharedItems)
    {
        int sum = 0;
        foreach (char item in sharedItems)
        {
            if (Char.IsUpper(item))
            {
                sum += item - 38;
            }
            else
            {
                sum += item - 96;
            }
        }
        return sum;
    }
}
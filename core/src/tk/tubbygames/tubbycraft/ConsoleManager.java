package tk.tubbygames.tubbycraft;

import tk.tubbygames.tubbycraft.commands.Command;
import tk.tubbygames.tubbycraft.commands.EchoCMD;

import java.util.*;

public class ConsoleManager {
    public static List<String> ConsoleText = new ArrayList<>();
    public static Map<String, Command> Commands = new HashMap<String, Command>();
    public static void InitCommands()
    {
        Commands.put("echo", new EchoCMD());
    }
    public static void ExecuteCommand(String command)
    {
        List<String> split = Arrays.asList(command.split(" "));
        System.out.println(split.size());
        String name = split.get(0);
        Commands.get(name).Execute(split.toArray(new String[0]));
    }
    public static void WriteToConsole(String line)
    {
        ConsoleText.add(line);
    }
}

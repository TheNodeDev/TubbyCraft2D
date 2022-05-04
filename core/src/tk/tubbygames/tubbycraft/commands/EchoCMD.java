package tk.tubbygames.tubbycraft.commands;

import tk.tubbygames.tubbycraft.ConsoleManager;

public class EchoCMD extends Command {
    @Override
    public void Execute(Object[] args)
    {

        ConsoleManager.WriteToConsole((String)args[1]);
    }
}

package com.cpath.esm.cloudpath.cli;

import com.cpath.esm.cloudpath.controller.SwitchController;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineInterface {

    private final SwitchController switchController;
    private final CLICommandParser commandParser;
    private final Scanner scanner;

    public CommandLineInterface(SwitchController switchController) {
        this.switchController = switchController;
        this.commandParser = new CLICommandParser();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the Virtual Switch CLI!");
        System.out.println("Type 'help' for a list of available commands.");

        while (true) {
            System.out.print("switch> ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting Virtual Switch CLI. Goodbye!");
                break;
            }

            CLICommandParser.ParsedCommand parsedCommand = commandParser.parseCommand(input);
            CLICommandParser.CommandType commandType = parsedCommand.getCommandType();
            String argument = parsedCommand.getArgument();

            switch (commandType) {
                case ADD_INTERFACE:
                    if (argument != null) {
                        switchController.processCommand("add " + argument);
                    } else {
                        System.out.println("Error: 'add' command requires an interface name.");
                    }
                    break;
                case LIST_INTERFACES:
                    switchController.processCommand("list");
                    break;
                case REMOVE_INTERFACE:
                    if (argument != null) {
                        switchController.processCommand("remove " + argument);
                    } else {
                        System.out.println("Error: 'remove' command requires an interface name.");
                    }
                    break;
                case SHOW_INTERFACE:
                    if (argument != null) {
                        switchController.processCommand("show " + argument);
                    } else {
                        System.out.println("Error: 'show' command requires an interface name.");
                    }
                    break;
                case FORWARD_PACKET:
                    if (argument != null) {
                        switchController.processCommand("forward " + argument);
                    } else {
                        System.out.println("Error: 'forward' command requires a packet identifier.");
                    }
                    break;
                case HELP:
                    displayHelp();
                    break;
                case UNKNOWN:
                    System.out.println("Unknown command. Type 'help' for a list of available commands.");
                    break;
            }
        }
        scanner.close();
    }

    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("  add <interface_name>    - Adds a new network interface.");
        System.out.println("  list                    - Lists all network interfaces.");
        System.out.println("  remove <interface_name> - Removes a specified network interface.");
        System.out.println("  show <interface_name>   - Shows details of a specific interface.");
        System.out.println("  forward <packet>        - Forwards a packet through the switch.");
        System.out.println("  exit                    - Exits the Virtual Switch CLI.");
        System.out.println("  help                    - Displays this help message.");
    }
}

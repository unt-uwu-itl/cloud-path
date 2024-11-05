package com.cpath.esm.cloudpath.cli;

public class CLICommandParser {

    // Enum to represent supported commands
    public enum CommandType {
        ADD_INTERFACE,
        LIST_INTERFACES,
        REMOVE_INTERFACE,
        SHOW_INTERFACE,
        FORWARD_PACKET,
        HELP,
        UNKNOWN
    }

    public static class ParsedCommand {
        private final CommandType commandType;
        private final String argument;

        public ParsedCommand(CommandType commandType, String argument) {
            this.commandType = commandType;
            this.argument = argument;
        }

        public CommandType getCommandType() {
            return commandType;
        }

        public String getArgument() {
            return argument;
        }
    }

    // Parses the input command and returns a ParsedCommand object
    public ParsedCommand parseCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new ParsedCommand(CommandType.UNKNOWN, null);
        }

        String[] parts = input.trim().split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : null;

        switch (command) {
            case "add":
                return new ParsedCommand(CommandType.ADD_INTERFACE, argument);
            case "list":
                return new ParsedCommand(CommandType.LIST_INTERFACES, null);
            case "remove":
                return new ParsedCommand(CommandType.REMOVE_INTERFACE, argument);
            case "show":
                return new ParsedCommand(CommandType.SHOW_INTERFACE, argument);
            case "forward":
                return new ParsedCommand(CommandType.FORWARD_PACKET, argument);
            case "help":
                return new ParsedCommand(CommandType.HELP, null);
            default:
                return new ParsedCommand(CommandType.UNKNOWN, null);
        }
    }
}

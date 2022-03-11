package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(
            new FilteredLogger(
                new ContextualLogger(name, new FileLogger("logger.txt")),
                message -> message.contains("simulation")
            ),
            new ContextualLogger(name, new ConsoleLogger())
        );
    }
}

package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {
    private final Logger logger;
    private final Predicate<String> predicate;

    public FilteredLogger(Logger logger, Predicate<String> predicate) {
        this.logger = logger;
        this.predicate = predicate;
    }

    @Override
    public void log(String message) {
        if (this.predicate.test(message)) {
            this.logger.log(message);
        }
    }
}

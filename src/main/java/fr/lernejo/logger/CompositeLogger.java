package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    private Logger firstLogger;
    private Logger secondLogger;

    public CompositeLogger(Logger firstLogger, Logger secondLogger) {
        this.firstLogger = firstLogger;
        this.secondLogger = secondLogger;
    }

    @Override
    public void log(String message) {
        firstLogger.log(message);
        secondLogger.log(message);
    }
}



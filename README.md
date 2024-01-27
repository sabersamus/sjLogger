A simple to use and easy to extend logging library for java.

# How to use:
The Log class contains most of what will be used.
You can use Log.info(), Log.debug(), Log.warn(), and Log.severe(). All of which take a String for a message.


## Default implementation: 
By default, Log will use a SimpleLogger, which uses System.out.println to log to the console.
You can change the default logger to use by using Log.setDefaultLogger

## Multiple Loggers
Log allows multiple loggers to be used. You can use Log.addLogger() to add loggers.
You can also remove loggers by using Log.removeLogger()

## Logger types & creating your own
Current types of loggers:
SimpleLogger - The default logger, logs to the console and prints a timestamp couting up from startup
TimestampLogger - This logger also prints to the console, but uses a current timestamp formatted in HH:mm
FileLogger - This logger prints text to a file, by default its found at {runtime folder}/logs/datestamp.log

You can also extend AbstractLogger and override the log method to create your own logger.
Dont forget to either set the default logger, or add it to the loggers.

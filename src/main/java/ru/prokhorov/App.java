package ru.prokhorov;


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * Входная точка в приложение
 */
@Command(
        name = "timesheet-generator",
        mixinStandardHelpOptions = true, version = "1.0",
        description = "Генератор табеля учета рабочего времени в формате Excel"
)
public class App implements Callable<Integer> {

    @Option(names = {"-m", "--month"}, description = "Месяц (1-12)")
    private int month;

    @Option(names = {"-y", "--year"}, description = "Год (например, 2024)")
    private int year;

    @Option(names = {"-o", "--output"}, description = "Имя выходного файла")
    private String outputFile;


    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        try {
            System.out.println("Приложение стартовало");
            return 0;
        } catch (Exception e) {
            System.err.println("Ошибка при создании табеля: " + e.getMessage());
            return 1;
        }
    }
}
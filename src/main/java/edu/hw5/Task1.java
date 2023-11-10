package edu.hw5;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;

public class Task1 {
    private Task1() {}

    private static Instant getInstant(String endOrBegin) {
        return Instant.parse(new StringBuilder(endOrBegin)
            .replace(endOrBegin.indexOf(", "), endOrBegin.indexOf(", ") + 2, "T")
            .append(":00Z").toString());
    }

    private static EndBegin toInstantFormat(String session) {
        final String separator =  " - ";
        final int shiftToEndingPart = 3;
        String beginning = session.substring(0, session.indexOf(separator));
        String ending = session.substring(session.indexOf(separator) + shiftToEndingPart);
        return new EndBegin(getInstant(beginning), getInstant(ending));
    }

    private static Collection<EndBegin> toInstantList(Collection<String> sessions) {
        return sessions.stream()
            .map(Task1::toInstantFormat)
            .toList();
    }

    private static boolean isValidInput(Collection<String> sessions) {
        final int validLength = 37;
        return sessions.stream().allMatch(s -> s.length() == validLength);
    }

    public static String medianTime(Collection<String> sessions) {
        if (!isValidInput(sessions)) {
            throw new IllegalArgumentException("Incorrect format of session.");
        }
        Collection<EndBegin> listOfSessions = toInstantList(sessions);
        Duration allDurations = listOfSessions.stream().reduce(Duration.ZERO, (duration, endBegin) -> {
            return duration.plus(Duration.between(endBegin.beginning, endBegin.ending));
        }, Duration::plus);
        Duration medianDuration = allDurations.dividedBy(sessions.size());
        return new StringBuilder()
            .append(medianDuration.toHoursPart())
            .append("ч ")
            .append(medianDuration.toMinutesPart())
            .append('м').toString();
    }

    private record EndBegin(Instant beginning, Instant ending) {}
}

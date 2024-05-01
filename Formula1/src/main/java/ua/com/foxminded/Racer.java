package ua.com.foxminded;

import java.time.Duration;
import java.time.LocalDateTime;

public class Racer implements Comparable<Racer> {
    private String abbreviation;
    private String name;
    private String team;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Duration duration;

    public Racer(String abbreviation, String name, String team, LocalDateTime startTime, LocalDateTime endTime) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = Duration.between(startTime, endTime);
    }

    @Override
    public int compareTo(Racer anotherRacer) {
        return this.duration.compareTo(anotherRacer.getDuration());
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Duration getDuration() {
        return duration;
    }
}

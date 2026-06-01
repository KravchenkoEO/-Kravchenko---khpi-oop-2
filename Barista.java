package ua.khpi.oop.lab01;

import java.util.Objects;
import java.util.UUID;

public class Barista {
    private String baristaId;
    private String name;
    private int experienceYears;
    private String specialization;

    public Barista() {
        this.baristaId = UUID.randomUUID().toString();
        this.specialization = "Універсал";
    }

    public Barista(String name, int experienceYears) {
        this();
        this.name = name;
        this.experienceYears = experienceYears;
    }

    // Гетери та сетери
    public String getBaristaId() { return baristaId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    @Override
    public String toString() {
        return String.format("Barista[id=%s, name=%s, experience=%d років, spec=%s]",
                baristaId.substring(0, 8), name, experienceYears, specialization);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Barista)) return false;
        Barista other = (Barista) obj;
        return Objects.equals(baristaId, other.baristaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baristaId);
    }
}
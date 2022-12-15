package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            count += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Label label = new Label(pupil.name(), sum / pupil.subjects().size());
            rsl.add(label);
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = temp.getOrDefault(subject.name(), 0);
                temp.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            int score = entry.getValue() / pupils.size();
            Label label = new Label(entry.getKey(), score);
            rsl.add(label);
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0D;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Label label = new Label(pupil.name(), sum);
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = temp.getOrDefault(subject.name(), 0);
                temp.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            Label label = new Label(entry.getKey(), entry.getValue());
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}

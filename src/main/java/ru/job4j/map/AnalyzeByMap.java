package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            count += pupil.subjects().size();
            for (Subject subject : subjects) {
                rsl += subject.score();
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            String name = pupil.name();
            double sum = 0D;
            int count = pupil.subjects().size();
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            Label label = new Label(name, sum / count);
            rsl.add(label);
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                String name = subject.name();
                int score = temp.getOrDefault(name, 0);
                temp.put(name, score + subject.score());
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
            String name = pupil.name();
            double sum = 0D;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                sum += subject.score();
            }
            Label label = new Label(name, sum);
            list.add(label);
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        LinkedHashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                String name = subject.name();
                int score = temp.getOrDefault(name, 0);
                temp.put(name, score + subject.score());
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

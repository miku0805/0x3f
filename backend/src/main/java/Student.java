public class Student implements Comparable<Student> {
    private String name;
    private int chineseScore;
    private int mathScore;
    private int englishScore;
    private int totalScore;

    public Student(String name, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = chineseScore + mathScore + englishScore;
    }

    public String getName() {
        return name;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public int compareTo(Student o) {
        if (this.totalScore > o.totalScore) {
            return -1;
        } else if (this.totalScore < o.totalScore) {
            return 1;
        } else {
            return 0;
        }
    }
}
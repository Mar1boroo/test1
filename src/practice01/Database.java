package practice01;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Integer, Student> db;

    private void init() {

        db.put(1, new Student("김동빈", "구미시", 22));
        db.put(2, new Student("이아영", "구미시", 23));
        db.put(3, new Student("진성민", "구미시", 24));
        db.put(4, new Student("김가연", "구미시", 22));
        db.put(5, new Student("권미영", "구미시", 22));
        db.put(6, new Student("박철수", "구미시", 23));
        db.put(7, new Student("고영희", "구미시", 21));
        db.put(8, new Student("이동욱", "구미시", 24));
        db.put(9, new Student("이지영", "구미시", 24));
        db.put(10, new Student("박진호", "구미시", 30));

    }

    public Database() {
        db = new HashMap<>();
        init();
    }

    public Student getStudent(int id) {
        if (1 <= id && id <= 10) return db.get(id);
        return null;
    }
}

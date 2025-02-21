package com.yunjin.callbytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class User {
    public int age;

    public User (int age) {
        this.age = age;
    }
}

public class CallByReferenceTest {

    @Test
    @DisplayName("메소드의 지역변수(참조형)은 Stack 프레임별로 저장되어 Heap영역의 주소값을 들고 있기때문에 원본 값에 영향을 주기도 하고, 안주기도 한다.")
    void referenceTypeTest() {
        User a = new User(1);
        User b = new User(2);

        // Before
        System.out.println("Before a: " + a.age);
        System.out.println("Before b: " + b.age);

        assertThat(a.age).isEqualTo(1);
        assertThat(b.age).isEqualTo(2);

        modify(a, b);

        // After
        System.out.println("After a: " + a.age);
        System.out.println("After b: " + b.age);

        assertThat(a.age).isEqualTo(2);
        assertThat(b.age).isEqualTo(2);
        assertThat(b.age).isEqualTo(7); // 자바가 Call By Reference 방식이 아닌 이유, 값을 변경하면 무조건 원본 값에 영향을 준다
        assertThat(b.age).isEqualTo(7);
    }

    private void modify(User a, User b) {
        a.age++;
        b = new User(6);
        b.age++;

        System.out.println("Modify a: " + a.age);
        System.out.println("Modify b: " + b.age);
    }
}

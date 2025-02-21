package com.yunjin.callbytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CallByValueTest {

    @Test
    @DisplayName("메소드의 지역변수(기본형)은 Stack 프레임별로 저장되어 전달받은 값 변경이 원본 값에 영향을 주지 않음.")
    void primitiveTypeTest() {
        int a = 1;
        int b = 2;

        // Before
        System.out.println("Before a: " + a);
        System.out.println("Before b: " + b);

        assertThat(a).isEqualTo(1);
        assertThat(b).isEqualTo(2);

        modify(a, b);

        // After
        System.out.println("After a: " + a);
        System.out.println("After b: " + b);

        assertThat(a).isEqualTo(1);
        assertThat(b).isEqualTo(2);
    }

    private void modify(int a, int b) {
        a++;
        b = 7;
        System.out.println("Modify a: " + a);
        System.out.println("Modify b: " + b);
    }

    @Test
    @DisplayName("증감 연산자 값 변경")
    void primitiveTypeDataChange() {
        int a = 1;

        // Before
        assertThat(a).isEqualTo(1);

        int result = modify2(a);

        // After
        assertThat(result).isEqualTo(2);
    }

    private int modify2(int a) {
        //a++;
        return a++;
    }
}

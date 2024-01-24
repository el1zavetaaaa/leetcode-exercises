package yl.lbnts.leetcode.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringsTest {

    @Test
    public void comparePrimitiveToObj(){
        String str1 = new String("string");
        String str2 = "string";

        assertThat(str1).isNotSameAs(str2);
    }

    @Test
    public void compare2Obj(){
        String str1 = new String("string");
        String str2 = new String("string");

        assertThat(str1).isNotSameAs(str2);
    }

    @Test
    public void compare2Primitives(){
        String str1 = "string";
        String str2 ="string";

        assertThat(str1).isSameAs(str2);
    }

    @Test
    public void compare2ObjAddedToStringPool(){
        String str1 = "string";
        String str2 =new String("string");
        String str2Interned =  str2.intern();

        assertThat(str1).isSameAs(str2Interned);
    }

    @Test
    public void comparePrimitivesIfOneOfThemChanged(){
        String str1 = "string";
        String str2 = "string";

        assertThat(str1).isSameAs(str2);

        str2 = str2.toUpperCase();

        assertThat(str1).isNotSameAs(str2);
    }
}

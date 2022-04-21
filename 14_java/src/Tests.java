package src;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.MessageFormat;

import student.Translations.Translator;

import StudentCode.*;
import student.*;

import java.lang.reflect.*;


public class Tests {

    @Test
    public void tests(){
        
        Stack stack = new Stack();
        
        try {
            Stack.class.getDeclaredMethod("size");
        } catch (NoSuchMethodException e){
            fail("You should have a method size");
        }

        try{
		    assertTrue(
                "size() should give 0",
                0 == stack.size()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("isEmpty");
        } catch (NoSuchMethodException e){
            fail("You should have a method isEmpty");
        }

        try{
		    assertTrue(
                "isEmpty() should give true",
                true == stack.isEmpty()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        stack.push(new State(10, -2, 113));
        try {
            Stack.class.getDeclaredMethod("size");
        } catch (NoSuchMethodException e){
            fail("You should have a method size");
        }

        try{
		    assertTrue(
                "size() should give 1",
                1 == stack.size()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        stack.push(new State(1, 2, 3));
        try {
            Stack.class.getDeclaredMethod("size");
        } catch (NoSuchMethodException e){
            fail("You should have a method size");
        }

        try{
		    assertTrue(
                "size() should give 2",
                2 == stack.size()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        stack.push(new State(11, 21.5, 13));
        try {
            Stack.class.getDeclaredMethod("size");
        } catch (NoSuchMethodException e){
            fail("You should have a method size");
        }

        try{
		    assertTrue(
                "size() should give 3",
                3 == stack.size()
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("peek", int.class);
        } catch (NoSuchMethodException e){
            fail("You should have a method peek");
        }

        try{
		    assertTrue(
                "peek(1) should give State(1, 2, 3)",
                new State(1,2,3).equals(stack.peek(1))
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("pop");
        } catch (NoSuchMethodException e){
            fail("You should have a method pop");
        }

        try{
		    assertTrue(
                "pop() should give State(11, 21.5, 13)",
                new State(11,21.5,13).equals(stack.pop())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("pop");
        } catch (NoSuchMethodException e){
            fail("You should have a method pop");
        }

        try{
		    assertTrue(
                "pop() should give State(1,2,3)",
                new State(1,2,3).equals(stack.pop())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("pop");
        } catch (NoSuchMethodException e){
            fail("You should have a method pop");
        }

        try{
		    assertTrue(
                "pop() should give State(10,-2,113)",
                new State(10,-2,113).equals(stack.pop())
            );
		} catch(Exception e){
		    fail("Unexpected exception");
		}

        
        
        try {
            Stack.class.getDeclaredMethod("pop");
        } catch (NoSuchMethodException e){
            fail("You should have a method pop");
        }

        try {
			stack.pop();
			fail("You did not catch EmptyStackException");
		} catch (EmptyStackException e){
		} catch (Exception e){
		    fail("Unexpected exception");
		}
		
    }

}
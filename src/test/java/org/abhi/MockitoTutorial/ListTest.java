package org.abhi.MockitoTutorial;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {


    @Test
    public void letsMockListSize(){
        List listMock = mock(List.class);


        // Argument Matchers
        when(listMock.size()).thenReturn(2).thenReturn(5);

        assertEquals(2, listMock.size());
        assertEquals(5,listMock.size());

        when(listMock.get(0)).thenReturn("Goku");
        assertEquals("Goku",listMock.get(0));
        assertEquals(null,listMock.get(1));

        when(listMock.get(anyInt())).thenReturn("Vegeta");
        assertEquals("Vegeta",listMock.get(24));
        assertEquals("Vegeta",listMock.get(1));

        when(listMock.get(anyInt())).thenThrow(NullPointerException.class);
        assertThrows( FileNotFoundException.class,()->listMock.get(23));
    }


}

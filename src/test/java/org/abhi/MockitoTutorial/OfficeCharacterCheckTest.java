package org.abhi.MockitoTutorial;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class OfficeCharacterCheckTest {


    @Test
    void filterCharacter() {

        Office officeMock = mock(Office.class);
        when(officeMock.characterList()).thenReturn(Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office"));
//        Office officeStub = new OfficeImpl();
        OfficeCharacterCheck officeCharacterCheck = new OfficeCharacterCheck(officeMock);
        List<String> filteredCharacters = officeCharacterCheck.filterCharacter();
        assertEquals(3,filteredCharacters.size());
    }

    @Test
    public void filterCharactersBDDMockito(){

        //GIVEN
        Office officeMock = mock(Office.class);
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);
        OfficeCharacterCheck officeCharacterCheck = new OfficeCharacterCheck(officeMock);

        //WHEN
        List<String> filteredChars = officeCharacterCheck.filterCharacter();

        //THEN
        assertEquals(3 ,filteredChars.size());
    }

    @Test
    public void verifyCalls(){

        //Given
        Office officeMock = mock(Office.class);
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);
        OfficeCharacterCheck officeCharacterCheck = new OfficeCharacterCheck(officeMock);

        //When
        officeCharacterCheck.deleteCharNonOffice();

        //Then
        verify(officeMock).deleteNonOfficeChar("Ross");
        verify(officeMock, never()).deleteNonOfficeChar("Jim Office");

        //BDD Style Then
        then(officeMock).should().deleteNonOfficeChar("Ross");
        then(officeMock).should(never()).deleteNonOfficeChar("Jim Office");
    }

    @Test
    public void ArgumentCaptors(){

        //Given
        Office officeMock = mock(Office.class);
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);
        OfficeCharacterCheck officeCharacterCheck = new OfficeCharacterCheck(officeMock);

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //When
        officeCharacterCheck.deleteCharNonOffice();

        //Then
        then(officeMock).should(times(2)).deleteNonOfficeChar(stringArgumentCaptor.capture());
        System.out.println("Checking........" + stringArgumentCaptor.getAllValues());
        assertEquals(stringArgumentCaptor.getAllValues().size(), 2);
    }
}
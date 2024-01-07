package org.abhi.MockitoTutorial;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class AnnotationMockito {

    @Mock
    private Office officeMock;
    @InjectMocks
    private OfficeCharacterCheck officeCharacterCheck;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void filterCharacter() {
        when(officeMock.characterList()).thenReturn(Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office"));
        List<String> filteredCharacters = officeCharacterCheck.filterCharacter();
        assertEquals(3,filteredCharacters.size());
    }

    @Test
    public void filterCharactersBDDMockito(){

        //GIVEN
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);

        //WHEN
        List<String> filteredChars = officeCharacterCheck.filterCharacter();

        //THEN
        assertEquals(3 ,filteredChars.size());
    }

    @Test
    public void verifyCalls(){
        //Given
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);

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
        List<String> charList = Arrays.asList("Jim Office","Pam Office","Rachel","Ross","Micheal Scott Office");
        given(officeMock.characterList()).willReturn(charList);

        //When
        officeCharacterCheck.deleteCharNonOffice();

        //Then
        then(officeMock).should(times(2)).deleteNonOfficeChar(stringArgumentCaptor.capture());
        System.out.println("Checking........" + stringArgumentCaptor.getAllValues());
        assertEquals(stringArgumentCaptor.getAllValues().size(), 2);
    }
}
